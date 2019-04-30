package com.news.service;

import com.news.document.News;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public interface NewsService {


    Iterable<News> saveAll(List<News> newss) throws Exception;

    Iterable<News> listAll() throws Exception;

    Map<String, Object> listByAuthor(String author, PageRequest page) throws Exception;

    Map<String, Object> listByTitleORDescription(String title, String description, PageRequest page) throws Exception;


}
