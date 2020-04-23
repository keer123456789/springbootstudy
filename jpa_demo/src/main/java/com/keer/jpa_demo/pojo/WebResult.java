package com.keer.jpa_demo.pojo;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.jdbctemplatedemo.POJO
 * @Author: keer
 * @CreateTime: 2020-04-22 15:16
 * @Description: 请求返回值
 */
public class WebResult<T> {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;
    private int status;
    private T data;
    private String message;

    public WebResult() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}