package com.example.demospringweb.enums;

public enum ReturnCodeEnum {

    S0000 ("0000", "成功"),
    E0002("0002", "資料檢核有誤(%s)"),
    E902 ("E902", "電文格式不正確"),
    E903("E903", "必填欄位不完整(%s)"),
    E905("E905", "資料格式有誤(%s)");

    private String code;

    private String desc;

    private ReturnCodeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
