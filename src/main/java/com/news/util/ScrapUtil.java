package com.news.util;


import com.news.constant.WebSiteConst;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public class ScrapUtil {


    /**
     * get Document Object from certain url address
     * @param url   url address accessed
     * @return
     * @throws Exception
     */
    public static Document getRespDocument(String url) throws Exception{
        return getRespDocument(url, WebSiteConst.USER_AGENT, WebSiteConst.TIMEOUT);
    }


    /**
     *
     * @param url
     * @param userAgent
     * @return
     * @throws Exception
     */
    public static Document getRespDocument(String url, String userAgent) throws Exception{
        return getRespDocument(url,userAgent,WebSiteConst.TIMEOUT);
    }



    public static Document getRespDocument(String url, String userAgent, int timeOut) throws Exception{
        Connection connect = Jsoup.connect(url);
        Document document = connect.userAgent(userAgent)
                .timeout(timeOut)
                .ignoreContentType(true)
                .get();
        return document;
    }

}
