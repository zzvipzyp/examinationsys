package com.xct.examinationsys.common;

/**
 * @author ZZzz
 * @version 1.0
 * @className JsonResult
 * @description TODO
 * @date 2019/8/29 20:28
 */
public class JsonResult {
    private int code; // 1 正常 0 异常
    private Object info; // 返回前端的数据

    public JsonResult() {
    }

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
