package com.news.controller;

import com.news.constant.WebSiteConst;
import com.news.service.NewsService;
import com.news.service.impl.NewsServiceImpl;
import com.news.util.RespUtil;
import com.news.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by dong_zhengdong on 2019/4/29.
 */
@RestController
@RequestMapping("/news")
@Slf4j
public class NewsController {


    @Autowired
    private NewsService newsService;


    /**
     * Search available authors
     */
    @GetMapping("listAuthors")
    public ResponseVO listAuthors() {
        try {
            return RespUtil.success(((NewsServiceImpl) newsService)
                    .listAllAuthors());
        } catch (Exception e) {
            log.error("exception message = {}", e.getMessage());
            e.printStackTrace();
            return RespUtil.error(e.getMessage());
        }
    }

    /**
     * Search newss based on news author name
     *
     * @return
     */
    @GetMapping("listByAuthor")
    public ResponseVO listByAuthor(@RequestParam("author") String author,
                                   @RequestParam(value = "page", required = false, defaultValue = WebSiteConst.FIRST_PAGE) String page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = WebSiteConst.PAGE_SIZE) String pageSize) {
        try {
            PageRequest pageRequest = new PageRequest(Integer.valueOf(page), Integer.valueOf(pageSize));
            return RespUtil.success(newsService.
                    listByAuthor(author, pageRequest));
        } catch (Exception e) {
            log.error("exception message = {}", e.getMessage());
            e.printStackTrace();
            return RespUtil.error(e.getMessage());
        }
    }


    /**
     * Search newss based on news title and description
     *
     * @return
     */
    @GetMapping("listByTitleORDescription")
    public ResponseVO listByTitleORDescription(@RequestParam(value = "title", required = false, defaultValue = WebSiteConst.NONE_PARAM) String title,
                                               @RequestParam(value = "description", required = false, defaultValue = WebSiteConst.NONE_PARAM) String description,
                                               @RequestParam(value = "page", required = false, defaultValue = WebSiteConst.FIRST_PAGE) String page,
                                               @RequestParam(value = "pageSize", required = false, defaultValue = WebSiteConst.PAGE_SIZE) String pageSize) {
        if (WebSiteConst.NONE_PARAM.equals(title) && WebSiteConst.NONE_PARAM.equals(description))
            return RespUtil.paramMissing("either parameter title or description is required");
        try {
            PageRequest pageRequest = new PageRequest(Integer.valueOf(page), Integer.valueOf(pageSize));
            return RespUtil.success(newsService
                    .listByTitleORDescription(title, description, pageRequest));
        } catch (Exception e) {
            log.error("exception message = {}", e.getMessage());
            e.printStackTrace();
            return RespUtil.error(e.getMessage());
        }
    }




}
