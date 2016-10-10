package com.mumu.realmadrid.controller;

import lib.utils.MD5Util;
import lib.utils.StringUtil;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 7mu on 2016/6/28.
 * 基础控制器
 */
public class BaseController {
    private static final String TOKEN_KEY = "HalaMadrid";

    protected void generateToken(HttpSession session, String username){
        String token = MD5Util.MD5(username + System.currentTimeMillis());
        session.setAttribute("token", token);
        session.setMaxInactiveInterval(60*60*24);
    }

    /**
     * 验证sign的有效性，保证请求是安全无恶意的
     * @param queryString 请求携带的参数
     * @param sign 加密的sign
     * @return 安全则返回true，反之为false
     */
    protected boolean validateSign(String queryString, String sign){
        if(StringUtil.isEmpty(sign))
            return false;
        if(StringUtil.isEmpty(queryString))
            return false;
        String[] strings =  queryString.split("&");
        Map<String, String> paramsMap = new HashMap<String, String>();
        if(strings.length > 0){
            for(int i=0;i<strings.length;i++){
                if(strings[i].contains("="))
                    paramsMap.put(strings[i].substring(0, strings[i].lastIndexOf("=")), "");
            }
        }
        return sign.equals(MD5Util.createParamSign(paramsMap, TOKEN_KEY));
    }

    /**
     * 比较请求参数的token和session里的token
     * @param session HttpSession
     * @param token token
     * @return 如果token有效则返回true，反之返回false
     */
    protected boolean validateToken(HttpSession session, String token){
        if(StringUtil.isEmpty(token))
            return false;
        return token.equals(session.getAttribute("token"));
    }

    protected String getApplicationPath(){
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        return  servletContext.getRealPath("/");
    }
}
