# news
News Scraper Service Problem statement: 
  1. Scrap newspaper articles data from http://www.chinadaily.com.cn/cndy/2019- 04/27/index1.html 
  2. Create a REST service which answers following queries from scrap data: 
      a. Search available authors 
      b. Search articles based on author name 
      c. Search articles based on article title and description



Implementation instructions:

1. IDEA, JDK1.8, SpringBoot-2.X project, use spring-boot-starter-data-elasticsearch to store data in ElasticSearch for full-text search 
        a). please install ElasticSearch service first, I use ElasticSearch-5.6.2. 
            Also I attached the elasticsearch.yml file for ElasticSearch installation configuration. 
            and ElasticSearch should not be installed and runned as root user. 

2. For details, see the com.news.schedule.ScrapNewsDaily class which daily import data store from China Daily website to ElasticSearch 
        a). For test, at the beginning you can make it start every 30 sec and after data imported, 
            then stop the application and comment @Scheduled out.

3. Function correspondence:
       a. Search available authors:
                See the corresponding REST API news/listAuthors for details.
                
       b. Search articles based on author name:
                See the corresponding REST API news/listByAuthor for details.
                
       c. Search articles based on article title and description:
                See the corresponding REST API news/listByTitleORDescription for details.



if you have any questions, please do not hesitate to contact me through sending me email:  dzd_shanghai@sina.com
