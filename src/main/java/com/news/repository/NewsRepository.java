package com.news.repository;

import com.news.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Iterator;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public interface NewsRepository extends ElasticsearchRepository<News, String> {

}
