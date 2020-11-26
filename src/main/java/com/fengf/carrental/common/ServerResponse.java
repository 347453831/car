package com.fengf.carrental.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zyf
 * @date 2020/10/14 16:34
 */
//确保json序列化的时候，如果是null对象，其key值也会消失
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
// 生成无参构造，确保在RPC调用时，不会出现反序列失败
@NoArgsConstructor
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}
