package com.example.demospringweb.execption;

import com.example.demospringweb.enums.ReturnCodeEnum;

public class DemoException extends Exception {
    public static final long serialVersionUID = 1L;

    private final String code;

    private final String desc;

    public DemoException(ReturnCodeEnum returnCodeEnum){
        this.code = returnCodeEnum.getCode();
        this.desc = returnCodeEnum.getDesc();
    }

    public DemoException(String code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
