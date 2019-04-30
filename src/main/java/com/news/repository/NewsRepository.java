package com.news.repository;

import com.news.document.News;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public interface NewsRepository extends ElasticsearchRepository<News, String> {


}
