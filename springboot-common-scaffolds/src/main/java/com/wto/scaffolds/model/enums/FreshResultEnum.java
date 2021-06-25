package com.wto.scaffolds.model.enums;

/**
 * <pre>
 * mesgType:FreshResultEnum
 * message desc:异常枚举类
 *
 * create date: 2021/6/23 17:34
 * <pre>
 **/
public enum FreshResultEnum {
    ERROR("999","服务器异常,请求失败"),
    SUCCESS("200","成功"),
    MISSPARAMETER("304","参数缺失");

    /**
     *状态码
     */
    private String code;

    /**
     * 状态描述
     */
    private String codeMsg;

    private Object obj;

    FreshResultEnum(String code, String message) {
        this.code = code;
        this.codeMsg = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
