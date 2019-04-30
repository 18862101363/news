package com.news.util;


import com.news.enums.ResponseCode;
import com.news.vo.ResponseVO;

/**
 * Created by dong_zhengdong on 2019/4/29.
 */
public class RespUtil {


    /**
     *  return gengeral success response VO
     * @param data
     * @return
     */
    public static ResponseVO success(Object data){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseCode.SUCCESS.getCode());
        responseVO.setMessage(ResponseCode.SUCCESS.getMessage());
        responseVO.setData(data);
        return responseVO ;
    }


    /**
     *  return gengeral error response VO
     * @param data
     * @return
     */
    public static ResponseVO error(Object data){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseCode.ERROR.getCode());
        responseVO.setMessage(ResponseCode.ERROR.getMessage());
        responseVO.setData(data);
        return responseVO ;
    }

    /**
     *  return param binding missing response VO
     * @param data
     * @return
     */
    public static ResponseVO paramMissing(Object data){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(ResponseCode.PARAM_ERROR.getCode());
        responseVO.setMessage(ResponseCode.PARAM_ERROR.getMessage());
        responseVO.setData(data);
        return responseVO ;
    }


}
