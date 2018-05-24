package com.backend.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2018/1/8.
 * package com.elong.savior.common.json;
 * <p>
 * import java.io.Serializable;
 * import java.util.HashMap;
 * import java.util.Map;
 * <p>
 * /**
 * JsonCallBack 封装json，供前端使用
 *
 * @author guoyan
 * @version 1.0
 */
public class JsonCallBack implements Serializable {

    // 封装执行成功标示的返回值
    private Boolean success;

    // 封装执行成功与否内容的返回值
    private String message;

    // 封装键值对的返回值
    private Map<String, Object> pairs = new HashMap<String, Object>();

    public JsonCallBack() {
        super();
    }

    public JsonCallBack(Boolean success) {
        super();
        this.success = success;
    }

    public JsonCallBack(String message) {
        super();
        this.message = message;
    }

    public JsonCallBack(Map<String, Object> pairs) {
        super();
        this.pairs = pairs;
    }

    public JsonCallBack(Boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    public JsonCallBack(Boolean success, String message, Map<String, Object> pairs) {
        super();
        this.success = success;
        this.message = message;
        this.pairs = pairs;
    }

    public Map<String, Object> getPairs() {
        return pairs;
    }

    public void setPairs(Map<String, Object> pairs) {
        this.pairs = pairs;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JsonCallBack{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", pairs=" + pairs +
                '}';
    }
}