package com.wto.scaffolds.util;

import com.wto.scaffolds.handler.BaseResult;
import com.wto.scaffolds.handler.FreshException;
import com.wto.scaffolds.model.enums.FreshResultEnum;
import org.springframework.util.StringUtils;

/**
 * <pre>
 * mesgType:ResultUtil
 * message desc:返回数据信息
 *
 * create date: 2021/6/23 17:33
 * <pre>
 **/
public class ResultUtil {
    private void ResultUtils() {}

    /**
     * 成功返回
     */
    public static BaseResult resultSuccess() {
        return resultSuccess(null);
    }

    /**
     * 成功返回
     * @param data
     * 接口返回数据
     * @return
     */
    public static BaseResult resultSuccess(Object data) {
        BaseResult result = new BaseResult();
        result.setCode(FreshResultEnum.SUCCESS.getCode());
        result.setMessage("操作成功");//FreshResultEnum.SUCCESS.getMessage()
        result.setData(data);
        return result;
    }

    /**
     * 成功返回
     * @param message
     * 接口返回数据
     * @return
     */
    public static BaseResult resultSuccess(String message) {
        BaseResult result = new BaseResult();
        result.setCode(FreshResultEnum.SUCCESS.getCode());
        result.setMessage(StringUtils.isEmpty(message) ? "操作成功！": message);
        result.setData(null);
        return result;
    }

    /**
     * 失败返回
     * @param e
     * 自定义异常
     * @return
     */
    public static BaseResult resultFail(FreshException e) {
        BaseResult result = new BaseResult();
        result.setCode(e.getCode());
        result.setMessage(e.getMsg());
        return result;
    }

    /**
     * 失败返回
     * @param e
     * @param obj
     * @return
     */
    public static BaseResult resultFail(FreshException e, Object obj) {
        BaseResult result = new BaseResult();
        result.setCode(e.getCode());
        result.setMessage(e.getMsg());
        result.setData(obj);
        return result;
    }

    /**
     * 错误返回
     * @return
     */
    public static BaseResult resultError() {
        BaseResult result = new BaseResult();
        result.setCode(FreshResultEnum.ERROR.getCode());
        result.setMessage(FreshResultEnum.ERROR.getCodeMsg());
        return result;
    }
}
