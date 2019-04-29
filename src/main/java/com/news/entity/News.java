package com.news.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
@Document(indexName = "news", type = "news")
@Data
public class News {

    /**
     *
     */
    @Id
    private String id;

    /**
     * 作者名
     */
    private String author;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 新闻内容
     */
    private String description;




}
