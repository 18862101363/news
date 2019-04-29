package com.news.constant;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public class WebSiteConst {

    /**
     *  china daily 网站主页 url 前缀
     */
    public static final String CHINA_DAILY_URL_PREFIX = "http://www.chinadaily.com.cn/cndy/";

    /**
     *  china daily 网站主页 url 后缀
     */
    public static final String CHINA_DAILY_URL_SUFFIX = "/index1.html";

    /**
     *  从浏览器拷贝的 user_agent 信息
     */
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36";

    /**
     *  jsoup 连接超时设置
     */
    public static final int TIMEOUT = 6000;


    /**
     *  从 china daily 网站主页获取 news url 的 html 元素选择器
     */
    public static final String NEWS_URL_SELECTOR = "HREF";

    /**
     *  从 china daily 网站每个 news 页面获取该 news 标题信息的 html 元素选择器
     */
    public static final String NEWS_TITLE_SELECTOR = "lft_art";

    /**
     *  从 china daily 网站每个 news 页面获取该 news 作者信息的 html 元素选择器
     */
    public static final String NEWS_AUTHOR_SELECTOR = "info_l";

    /**
     *  从 china daily 网站每个 news 页面获取该 news 作者信息的 html 元素内容的分隔符，元素内容如： By Li Fusheng | China Daily | Updated: 2019-04-29 07:26
     */
    public static final String NEWS_AUTHOR_SEPERATOR = "|";

    /**
     *  从 china daily 网站每个 news 页面获取该 news 内容信息的 html 元素选择器
     */
    public static final String NEWS_DESCRIPTION_SELECTOR = "Content";

    /**
     * 分页查询的默认起始页码
     */
    public static final String FIRST_PAGE = "0";

    /**
     * 分页查询的默认每页数据量
     */
    public static final String PAGE_SIZE = "10";

}
