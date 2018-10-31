package com.lyc0.lycwx.manager;


import com.alibaba.fastjson.JSONObject;
import com.lyc0.util.HttpsClientUtil;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LoginManager {
    private static final String appId = "wx4fcb95170cacecfb";
    private static final String appSecret = "d6f54da2dd0f2499a5fa3ee74b166ef0";

    /**
     * 请求 https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
     *
     * @param code
     */
    public void login(String code) {
        Map<String, String> headers = new HashMap<>();

        Map<String, String> params = new HashMap<>();
        params.put("appid", appId);
        params.put("secre`t", appSecret);
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        try {
            HttpResponse response = HttpsClientUtil.doGet("https://api.weixin.qq.com",
                    "/sns/jscode2session", headers, params);

            JSONObject jsonObject = HttpsClientUtil.getJson(response);
            if(jsonObject!=null){

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
