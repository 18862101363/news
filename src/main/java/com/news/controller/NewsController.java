package com.news.controller;

import com.news.constant.WebSiteConst;
import com.news.entity.News;
import com.news.service.NewsService;
import com.news.service.impl.NewsServiceImpl;
import com.news.util.RespUtil;
import com.news.vo.ResponseVO;
import com.sun.tools.corba.se.idl.StringGen;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {


    @Autowired
    private NewsService newsService;


    /**
     * Search available authors
     */
    @GetMapping("listAuthors")
    public ResponseVO listAuthors() {
        List<String> authors = null;
        try {
            authors = ((NewsServiceImpl) newsService).listAllAuthors();
        } catch (Exception e) {
            log.error("exception message = {}", e.getMessage());
            e.printStackTrace();
            return RespUtil.error(e.getMessage());
        }

        return RespUtil.success(authors);
    }


    /**
     * Search newss based on news author name
     *
     * @return
     */
    @GetMapping("listByAuthor")
    public ResponseVO listByAuthor(@RequestParam("author") String author,
                                   @RequestParam(value = "page", required = false, defaultValue = WebSiteConst.FIRST_PAGE) String page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = WebSiteConst.PAGE_SIZE) String pageSize) {
        List<News> newss = null;
        try {
            PageRequest pageRequest = new PageRequest(Integer.valueOf(page), Integer.valueOf(pageSize));
            newss = newsService.listByAuthor(author, pageRequest);
        } catch (Exception e) {
            log.error("exception message = {}", e.getMessage());
            e.printStackTrace();
            return RespUtil.error(e.getMessage());
        }

        return RespUtil.success(newss);
    }


    /**
     * Search newss based on news title and description
     *
     * @return
     */
    @GetMapping("listByTitleORDescription")
    public ResponseVO listByTitleORDescription(@RequestParam("title") String title,
                                               @RequestParam("description") String description,
                                               @RequestParam(value = "page", required = false, defaultValue = WebSiteConst.FIRST_PAGE) String page,
                                               @RequestParam(value = "pageSize", required = false, defaultValue = WebSiteConst.PAGE_SIZE) String pageSize) {
        List<News> newss = null;
        try {
            PageRequest pageRequest = new PageRequest(Integer.valueOf(page), Integer.valueOf(pageSize));
            newss = newsService.listByTitleORDescription(title, description, pageRequest);
        } catch (Exception e) {
            log.error("exception message = {}", e.getMessage());
            e.printStackTrace();
            return RespUtil.error(e.getMessage());
        }

        return RespUtil.success(newss);
    }


}
