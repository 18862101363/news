package com.news.service.impl;

import com.news.NewsApplicationTests;
import com.news.document.News;
import com.news.service.NewsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

/**
 * Created by dong_zhengdong on 2019/4/30.
 */
public class NewsServiceImplTest extends NewsApplicationTests{

    @Autowired
    private NewsService newsService;

    @Test
    public void saveAll() throws Exception {

    }

    @Test
    public void listAll() throws Exception {
        Iterable<News> newss = newsService.listAll();


    }

    @Test
    public void listAllAuthors() throws Exception {

    }

    @Test
    public void queryTest() throws Exception {


    }

    @Test
    public void listByTitleORDescription() throws Exception {
        PageRequest pageRequest = new PageRequest(Integer.valueOf(0), Integer.valueOf(10));
        Map<String, Object> data = newsService.listByTitleORDescription("", "compensation", pageRequest);
        for(Map.Entry<String,Object> e:data.entrySet())
            System.out.println(e.getKey() +"-"+ e.getValue());

    }

}