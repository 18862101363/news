package com.news.service.impl;

import com.news.entity.News;
import com.news.repository.NewsRepository;
import com.news.service.NewsService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    @Override
    public Iterable<News> listAll() throws Exception {
        return newsRepository.findAll();
    }

    /**
     * Search available authors
     * @return
     * @throws Exception
     */
    public List<String> listAllAuthors() throws Exception {
        Set<String> authors = ((List<News>) listAll()).stream()
                .map(News::getAuthor)
                .collect(Collectors.toSet());
        return new ArrayList<String>(authors);
    }


    /**
     * Search newss based on news author name
     * @param author 作者
     * @param page   分页
     * @return
     * @throws Exception
     */
    @Override
    public List<News> listByAuthor(String author, PageRequest page) throws Exception {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.must(QueryBuilders.fuzzyQuery("author", author));
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(builder);
        nativeSearchQueryBuilder.withPageable(page);
        NativeSearchQuery query = nativeSearchQueryBuilder.build();
        Page<News> search = newsRepository.search(query);

        return search.getContent();
    }


    /**
     * Search newss based on news title and description
     * @param title         标题
     * @param description   内容
     * @param page          分页
     * @return
     * @throws Exception
     */
    @Override
    public List<News> listByTitleORDescription(String title, String description, PageRequest page) throws Exception {
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.should(QueryBuilders.fuzzyQuery("title", title));
        builder.should(QueryBuilders.fuzzyQuery("description", description));
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(builder);
        nativeSearchQueryBuilder.withPageable(page);
        NativeSearchQuery query = nativeSearchQueryBuilder.build();
        Page<News> search = newsRepository.search(query);

        return search.getContent();
    }
}
