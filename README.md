# news
News Scraper Service Problem statement: 
  1. Scrap newspaper articles data from http://www.chinadaily.com.cn/cndy/2019- 04/27/index1.html 
  2. Create a REST service which answers following queries from scrap data: 
      a. Search available authors 
      b. Search articles based on author name 
      c. Search articles based on article title and description



实现说明：

1.  SpringBoot 项目， 使用 spring-boot-starter-data-elasticsearch 将数据存储在 ElasticSearch 以实现全文检索 。

2.  详见 com.news.schedule.ScrapNewsDaily 类每日定时获取一次数据存储到 ElasticSearch 中 。 

3.  功能对应：
      a. Search available authors                                   详见对应 REST API news/listAuthors . 
      b. Search articles based on author name                       详见对应 REST API news/listByAuthor .
      c. Search articles based on article title and description     详见对应 REST API news/listByTitleORDescription .



