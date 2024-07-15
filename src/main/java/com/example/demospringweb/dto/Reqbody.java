package com.example.demospringweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Reqbody {

    @Size(max = 12, message = "UserId(身份證字號長度不得超過12位)")
    @JsonProperty("UserId")
    private String userId;


    @NotNull
    @JsonProperty("UserName")
    private String userName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString(){
        return new StringBuilder("{\"UserId\":").append(userId)
                .append(",\"UserName\":").append(userName)
                .append("}").toString();
    }

}
