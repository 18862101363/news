package com.news.document;

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
     * news author
     */
    private String author;

    /**
     * news title
     */
    private String title;

    /**
     * news content
     */
    private String description;


    /**
     * the url address accessed in China Daliy website
     */
    private String url;


}
