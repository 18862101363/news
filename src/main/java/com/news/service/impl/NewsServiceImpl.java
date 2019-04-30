package com.news.service.impl;

import com.news.document.News;
import com.news.repository.NewsRepository;
import com.news.service.NewsService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public Iterable<News> saveAll(List<News> newss) throws Exception {
        return newsRepository.saveAll(newss);
    }

    /**
     *  return all news document
     * @return
     * @throws Exception
     */
    @Override
    public Iterable<News> listAll() throws Exception {
        return newsRepository.findAll();
    }

    /**
     * Search available authors
     *
     * @return
     * @throws Exception
     */
    public Map<String, Object> listAllAuthors() throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        Page<News> newss = (Page<News>) listAll();
        Set<String> authors = newss.getContent()
                .stream()
                .map(News::getAuthor)
                .collect(Collectors.toSet());
        data.put("total", newss.getTotalElements());
        data.put("authors", new ArrayList<String>(authors));
        return data;
    }


    /**
     * Search newss based on news author name
     *
     * @param author author
     * @param page   pagination
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> listByAuthor(String author, PageRequest page) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        // set query condition
        MatchQueryBuilder builder = QueryBuilders.matchQuery("author", author);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(builder);
        // set pagination
        nativeSearchQueryBuilder.withPageable(page);
        NativeSearchQuery query = nativeSearchQueryBuilder.build();
        // query
        Page<News> search = newsRepository.search(query);
        // set data Object
        data.put("total",search.getTotalElements());
        data.put("news",search.getContent());
        data.put("page",page.getPageNumber()+1);
        data.put("pageSize",page.getPageSize());
        return data;
    }

    /**
     * Search newss based on news title and description
     *
     * @param title       title
     * @param description description
     * @param page        pagination
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> listByTitleORDescription(String title, String description, PageRequest page) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        // set query condition
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.should(QueryBuilders.matchQuery("title", title));
        builder.should(QueryBuilders.matchQuery("description", description));
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(builder);
        // set pagination
        nativeSearchQueryBuilder.withPageable(page);
        NativeSearchQuery query = nativeSearchQueryBuilder.build();
        // query
        Page<News> search = newsRepository.search(query);
        // set data Object
        data.put("total",search.getTotalElements());
        data.put("news",search.getContent());
        data.put("page",page.getPageNumber()+1);
        data.put("pageSize",page.getPageSize());
        return data;
    }




}
