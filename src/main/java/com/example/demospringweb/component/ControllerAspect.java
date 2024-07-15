package com.example.demospringweb.component;

import com.example.demospringweb.dto.base.Request;
import com.example.demospringweb.dto.base.Response;
import com.example.demospringweb.enums.ReturnCodeEnum;
import com.example.demospringweb.execption.DemoException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Component
@Slf4j
public class ControllerAspect {

    @Autowired
    private WebRequestContext webRequestContext;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @SuppressWarnings("rawtypes")
    @Around(value = "execution(public * com.example.demospringweb.controller.*Controller.*(..)) && args(..,bindingResult)" )
    public Object arround(ProceedingJoinPoint joinPoint, BindingResult bindingResult) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Request<?> request = null;
        Response<?> response = null;

        String fuseId = httpServletRequest.getHeader("FUSE_ID");
        webRequestContext.setFuseId(fuseId);
        for(Object arg : args){
            if(arg instanceof Request){
                request = (Request<?>) arg;
                webRequestContext.setRequest(request);
                break;
            }
        }

        if(request == null){
            throw new DemoException(ReturnCodeEnum.E902);
        }

        log.info("Get Request -> {} ", request.toString() );

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            StringBuilder errorMsg = new StringBuilder();
            fieldErrors.stream().forEach(fieldError -> errorMsg.append(fieldError.getDefaultMessage()).append(","));
            errorMsg.setLength(errorMsg.length() - 1);
            for (FieldError fieldError : fieldErrors){
                if ("Pattern".equals(fieldError.getCode()) || "Size".equals(fieldError.getCode())){
                    throw new DemoException(ReturnCodeEnum.E905.getCode(),
                            String.format(ReturnCodeEnum.E905.getDesc(), errorMsg.toString()));
                } else {
                    throw new DemoException(ReturnCodeEnum.E903.getCode(),
                            String.format(ReturnCodeEnum.E903.getDesc(), errorMsg.toString()));
                }
            }
        }

        Object result = joinPoint.proceed(args);
        if (result != null && result instanceof Response) {
            response = (Response<?>) result;
            response.getHeader().setFuseId(fuseId);
            String FuseId = null;
            if(response != null){
                FuseId = response.getHeader().getFuseId();
            }
            log.info("Get Response -> {},{} ",FuseId, response.toString() );
        }


        return result;
    }
}
