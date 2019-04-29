package com.news.vo;

import lombok.Data;
import org.elasticsearch.search.aggregations.pipeline.derivative.InternalDerivative;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
@Data
public class ResponseVO<T> {

    private Integer code;

    private String message;

    private T data;

}
