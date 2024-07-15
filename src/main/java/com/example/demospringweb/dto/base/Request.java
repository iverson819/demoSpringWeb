package com.example.demospringweb.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Request<T> {

    @Valid
    @JsonProperty("WebHeader")
    private WebHeader webHeader = new WebHeader();

    @Valid
    @JsonProperty("TranRQ")
    private T tranrq;

    public WebHeader getWebHeader() {
        return webHeader;
    }

    public void setWebHeader(WebHeader webHeader) {
        this.webHeader = webHeader;
    }

    public T getTranrq() {
        return tranrq;
    }

    public void setTranrq(T tranrq) {
        this.tranrq = tranrq;
    }

    @Override
    public String toString(){
        return new StringBuilder("{\"WEBHEADER\":").append(webHeader.toString())
                .append(",\"TRANRQ\":").append(tranrq == null ? null : tranrq.toString()).append("}")
                .toString();
    }

}
