package com.example.demospringweb.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {

    @JsonProperty("WebHeader")
    private WebHeader header = new WebHeader();

    @JsonProperty("Response")
    private T resp;

    public WebHeader getHeader() {
        return header;
    }

    public void setHeader(WebHeader header) {
        this.header = header;
    }

    public T getResp() {
        return resp;
    }

    public void setResp(T resp) {
        this.resp = resp;
    }

    @Override
    public String toString() {
        return new StringBuilder("{\"WebHeader\":").append(header.toString())
                         .append(" ,\"Response\":").append(resp.toString()).toString();
    }
}
