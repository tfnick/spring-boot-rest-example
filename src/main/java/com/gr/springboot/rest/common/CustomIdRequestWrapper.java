package com.gr.springboot.rest.common;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomIdRequestWrapper extends HttpServletRequestWrapper {

    private static final String CUSTOM_ID_HEADER_NAME = "X-Custom-ID";
    private static final String CUSTOM_ID_PARAM_NAME = "cid";

    public CustomIdRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    /**
     * 优先把header中的cid赋与方法中的参数
     * @param name
     * @return
     */
    @Override
    public String[] getParameterValues(String name) {
        String cid = this.getHeader(CUSTOM_ID_HEADER_NAME);
        if (CUSTOM_ID_PARAM_NAME.equals(name) && !StringUtils.isEmpty(cid)){
            return new String[]{cid};
        }
        return super.getParameterValues(name);
    }
}
