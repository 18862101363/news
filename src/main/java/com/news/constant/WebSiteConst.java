package com.news.constant;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public class WebSiteConst {

    /**
     *   china daily website main url address preffix
     */
    public static final String CHINA_DAILY_URL_PREFIX = "http://www.chinadaily.com.cn/cndy/";

    /**
     *  china daily website main url address suffix
     */
    public static final String CHINA_DAILY_URL_SUFFIX = "/index1.html";

    /**
     *  user_agent information obtained from Chrome Explorer
     */
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";

    /**
     *  jsoup connection timeout setting
     */
    public static final int TIMEOUT = 6000;


    /**
     *  the html selector for selecting every news url address from China Daily Homepage
     */
    public static final String NEWS_URL_SELECTOR = "HREF";

    /**
     *  the html selector for selecting news title information from China Daily every single news web page
     */
    public static final String NEWS_TITLE_SELECTOR = "lft_art";

    /**
     *  the html selector for selecting news author information from China Daily every single news web page
     */
    public static final String NEWS_AUTHOR_SELECTOR = "info_l";

    /**
     *  cause the news author text obtained may be ambiguous, we need to do something specifically.
     *  eg. By Ma Zhiping in Haikou | China Daily | Updated: 2019-04-30 07:03
     */
    public static final String NEWS_AUTHOR_SUBPRE = "By ";//s = s.substring(s.indexOf("By ") + "By ".length(), s.indexOf(" | "));
    public static final String NEWS_AUTHOR_SUBSUF_IN = " in ";//s = s.substring(s.indexOf("By ") + "By ".length(), s.indexOf(" | "));
    public static final String NEWS_AUTHOR_SUBSUF = " | ";
    public static final String NEWS_AUTHOR_CHINADAILY = "China Daily";

    /**
     *  the html selector for selecting news description information from China Daily every single news web page
     */
    public static final String NEWS_DESCRIPTION_SELECTOR = "Content";

    /**
     * default page number for pagination
     */
    public static final String FIRST_PAGE = "0";

    /**
     * default page size for pagination
     */
    public static final String PAGE_SIZE = "10";

    /**
     * default empty parameter value
     */
    public static final String NONE_PARAM = "NONE";
}
