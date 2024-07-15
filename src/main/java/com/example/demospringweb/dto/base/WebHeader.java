package com.example.demospringweb.dto.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WebHeader {

    @NotBlank(message = "ProjectId is Blank.")
    @JsonProperty("ProjectID")
    private String projectId;

    @JsonProperty("ReturnCode")
    private String returnCode;

    @JsonProperty("ReturnDesc")
    private String returnDesc;

    @JsonProperty("FuseID")
    private String fuseId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }


    public String getFuseId() {
        return fuseId;
    }

    public void setFuseId(String fuseId) {
        this.fuseId = fuseId;
    }

    @Override
    public String toString(){
        return new StringBuilder("{\"ProjectID\":").append(projectId)
                .append(",\"ReturnCode\":").append(returnCode)
                .append(",\"ReturnDesc\":").append(returnDesc)
                .append(",\"FuseID\":").append(fuseId)
                .append("}").toString();
    }

}
