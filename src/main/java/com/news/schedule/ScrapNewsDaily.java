package com.news.schedule;

import com.news.constant.WebSiteConst;
import com.news.entity.News;
import com.news.repository.NewsRepository;
import com.news.service.NewsService;
import com.news.util.ScrapUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
@EnableScheduling
@Slf4j
@Component
public class ScrapNewsDaily {

    @Autowired
    private NewsService newsService;


    /**
     * 每天定时获取数据到 ElasticSearch
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void screpNews() {
        try {
            Date today = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM/dd");
            String todayStr = dateFormat.format(today);
            String indexUrl = String.format("%s%s%s", WebSiteConst.CHINA_DAILY_URL_PREFIX, todayStr, WebSiteConst.CHINA_DAILY_URL_SUFFIX);
            log.info("indexUrl = {}", indexUrl);
            // 从当天 china daily 主页获取当天所有的 news 访问的 url 地址
            List<String> newsUrls = getNewsUrls(indexUrl);
            List<News> newss = new ArrayList<>();
            for (String newsUrl : newsUrls) {
                newsUrl = String.format("%s%s/%s", WebSiteConst.CHINA_DAILY_URL_PREFIX, todayStr, newsUrl);
                log.info("newsUrl = {}", newsUrl);
                // 单独访问每个 news url 地址，获取数据组装成 Java News 对象
                newss.add(getNews(newsUrl));
            }
            System.out.println("");

            // 保存数据到 ElasticSearch news 中
            Iterable<News> newss1 = newsService.saveAll(newss);

//            for (News news:newss1){
//                System.out.println(news.getId());
//            }

        } catch (Exception e) {
            log.error("exception message={}", e.getMessage());
            e.printStackTrace();
        }

    }


    /**
     * get news url list from the main index page
     *
     * @param url url address accessed
     * @return
     * @throws Exception
     */
    private List<String> getNewsUrls(String url) throws Exception {
        Document document = ScrapUtil.getRespDocument(url);
        Elements aTags = document.getElementsByAttributeValueEnding(WebSiteConst.NEWS_URL_SELECTOR, "htm");
        return aTags.stream()
                .map(e -> e.attr(WebSiteConst.NEWS_URL_SELECTOR))
                .collect(Collectors.toList());
    }


    /**
     * get News Object by visiting the certain newsUrl address
     *
     * @param newsUrl
     * @return
     * @throws Exception
     */
    private News getNews(String newsUrl) throws Exception {
        News news = new News();
        Document document = ScrapUtil.getRespDocument(newsUrl);
        Elements elements = document.getElementsByClass(WebSiteConst.NEWS_TITLE_SELECTOR);
        if (!CollectionUtils.isEmpty(elements))
            news.setTitle(elements.get(0).text());

        elements = document.getElementsByClass(WebSiteConst.NEWS_AUTHOR_SELECTOR);
        if (!CollectionUtils.isEmpty(elements))
            news.setTitle(elements.get(0)
                    .text()
                    .split(WebSiteConst.NEWS_AUTHOR_SEPERATOR)[0]
                    .trim());

        Element element = document.getElementById(WebSiteConst.NEWS_DESCRIPTION_SELECTOR);
        if (element!=null)
            news.setDescription(element.text());

        return news;
    }


}
