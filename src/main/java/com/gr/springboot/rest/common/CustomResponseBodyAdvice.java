package com.gr.springboot.rest.common;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 对于json响应，根据code判断是否需要设置X-Custom-Fee
 * 对于html响应，默认不计费，由接口方法自行设置X-Custom-Fee
 */
@Component
@RestControllerAdvice("com.gr")
public class CustomResponseBodyAdvice implements ResponseBodyAdvice {

    private static final String FEE_HEADER_NAME = "X-Custom-Fee";

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (MediaType.TEXT_HTML.equals(mediaType)||MediaType.TEXT_PLAIN.equals(mediaType)) {
            System.out.println("返回HTML响应");
        } else if (MediaType.APPLICATION_JSON.equals(mediaType)||MediaType.APPLICATION_JSON_UTF8.equals(mediaType)) {
            System.out.println("返回JSON响应");
            if (o instanceof IResult) {
                IResult iResult = (IResult)o;
                if (iResult != null && iResult.getCode() == 200) {
                    serverHttpResponse.getHeaders().add(FEE_HEADER_NAME,"true");
                }
            }
        } else {
            //ignore
            System.out.println("其他响应");
        }

        return o;
    }
}
