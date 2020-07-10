package com.lhs.shopcar.utils;

import lombok.Data;

@Data
public class ResponseEntity<T> {
    private int status;
    private String msg;
    private T data;

    public static <T> ResponseEntity<T> success(T data) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setData(data);
        entity.setMsg(ErrorStatus.SUCCESS.getMsg());
        entity.setStatus(ErrorStatus.SUCCESS.getStatus());
        return entity;
    }

    public static <T> ResponseEntity<T> success(ErrorStatus status, T data) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setData(data);
        entity.setMsg(status.getMsg());
        entity.setStatus(status.getStatus());
        return entity;
    }

    public static <T> ResponseEntity<T> error() {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setMsg("error");
        entity.setStatus(404);
        return entity;
    }

    public static <T> ResponseEntity<T> error(ErrorStatus status) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setMsg(status.getMsg());
        entity.setStatus(status.getStatus());
        return entity;
    }

}
