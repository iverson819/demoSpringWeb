package com.example.demospringweb.component;

import com.example.demospringweb.dto.base.Request;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Setter
@Getter
@ToString
@Component
@RequestScope
public class WebRequestContext {

    public static final String FUSE_ID = "FUSE_ID";

    private Request<?> request;

    private String fuseId;

}
