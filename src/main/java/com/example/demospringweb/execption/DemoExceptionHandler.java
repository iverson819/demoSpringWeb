package com.example.demospringweb.execption;

import com.example.demospringweb.component.WebRequestContext;
import com.example.demospringweb.dto.RespBody;
import com.example.demospringweb.dto.base.Response;
import com.example.demospringweb.dto.base.WebHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class DemoExceptionHandler {

    @Autowired
    private WebRequestContext webRequestContext;

    @ResponseBody
    @ExceptionHandler(DemoException.class)
    public Response<?> onDemoException(DemoException e){
        Response<RespBody> response = getResponse();
        WebHeader header = response.getHeader();
        header.setReturnCode(e.getCode());
        header.setReturnDesc(e.getDesc());
        RespBody respBody = new RespBody();
        response.setResp(respBody);

        return response;
    }

    private Response<RespBody> getResponse() {
        Response<RespBody> response = new Response<>();
        if(webRequestContext.getRequest() == null || webRequestContext.getRequest().getWebHeader() == null){
            WebHeader header = new WebHeader();
      System.out.println("fuseId:"+webRequestContext.getFuseId());
            header.setFuseId(webRequestContext.getFuseId());
            response.setHeader(header);
            RespBody respBody = new RespBody();
            response.setResp(respBody);
        }else{
            response.setHeader(webRequestContext.getRequest().getWebHeader());
    }

        return response;
    }
}
