package com.wto.scaffolds.handler;

import com.wto.scaffolds.model.enums.FreshResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <pre>
 * mesgType:FreshException
 * message desc:统一异常
 *
 * create date: 2021/6/23 17:39
 * <pre>
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class FreshException extends RuntimeException{
    private String code;
    private String msg;
    private String obj;

    public FreshException() {
    }

    public FreshException(FreshResultEnum freshResultEnum) {
        this.code = freshResultEnum.getCode();
        this.msg = freshResultEnum.getCodeMsg();

    }

    public FreshException(String errCode, String errMsg) {
        this.code = errCode;
        this.msg = errMsg;
    }
    public FreshException(String errCode, String errMsg,String obj) {
        this.code = errCode;
        this.msg = errMsg;
        this.obj=obj;
        // System.out.println(JSON.toJSONString(obj));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
