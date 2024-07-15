package com.example.demospringweb.controller;

import com.example.demospringweb.dto.Reqbody;
import com.example.demospringweb.dto.RespBody;
import com.example.demospringweb.dto.base.Request;
import com.example.demospringweb.dto.base.Response;
import com.example.demospringweb.dto.base.WebHeader;
import com.example.demospringweb.enums.ReturnCodeEnum;
import com.example.demospringweb.execption.DemoException;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping(value = "hello", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<RespBody> hello(@Validated @RequestBody Request<Reqbody> request, Errors errors) throws DemoException {

        Response<RespBody> result = new Response<>();
        RespBody respBody = new RespBody();
        WebHeader header = request.getWebHeader();
        header.setReturnCode(ReturnCodeEnum.S0000.getCode());
        header.setReturnDesc(ReturnCodeEnum.S0000.getDesc());
        respBody.setRsCount(1);
        result.setHeader(header);
        result.setResp(respBody);
        return result;
    }

}
