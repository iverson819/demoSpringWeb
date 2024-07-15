package com.example.demospringweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespBody {

    @JsonProperty("Rscount")
    private Integer rsCount;

    public Integer getRsCount() {
        return rsCount;
    }

    public void setRsCount(Integer rsCount) {
        this.rsCount = rsCount;
    }

    @Override
    public String toString() {
        return new StringBuilder("{\"Rscount\":").append(rsCount).toString();
    }
}
