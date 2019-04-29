package com.news.service;

import com.news.entity.News;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public interface NewsService {


    Iterable<News> saveAll(List<News> newss) throws Exception;

    Iterable<News> listAll() throws Exception;

    List<News> listByAuthor(String author, PageRequest page) throws Exception;

    List<News> listByTitleORDescription(String title, String description, PageRequest page) throws Exception;


}
