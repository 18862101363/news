package com.news.repository;

import com.news.document.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by dong_zhengdong on 2019/4/29.
 *
 * https://blog.csdn.net/topdandan/article/details/81436141     springboot中ElasticSearch入门与进阶：组合查询、Aggregation聚合查询（你想要的都有）
 * https://my.oschina.net/kipeng/blog/1799827
 * https://segmentfault.com/a/1190000015568618
 */
public interface NewsRepository extends ElasticsearchRepository<News, String> {


}
