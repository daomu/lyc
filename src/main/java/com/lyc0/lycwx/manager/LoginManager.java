package com.lyc0.lycwx.manager;


import com.alibaba.fastjson.JSONObject;
import com.lyc0.lycwx.object.LoginUser;
import com.lyc0.util.WXUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class LoginManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginManager.class);

    /**
     * 所有登录的人，在内存记一下好了，没几个人用
     */
    private static final List<LoginUser> loginUsers = new ArrayList<>();

    /**
     * 请求 https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
     *
     * @param code
     */
    public synchronized String login(String code, String encryptedData, String iv) {
        try {
            JSONObject sessionObject = WXUtils.code2Session(code);
            if (sessionObject != null) {
                String sessionKey = sessionObject.getString("session_key");
                JSONObject userInfoObject = WXUtils.getUserInfo(encryptedData, sessionKey, iv);
                if (userInfoObject != null) {
                    LoginUser loginUser = new LoginUser();
                    loginUser.setUserNick(userInfoObject.getString("nickName"));
                    loginUser.setAvatarUrl(userInfoObject.getString("avatarUrl"));
                    loginUser.setSessionKey(sessionKey);
                    loginUser.setOpenId(sessionObject.getString("openid"));
                    loginUser.setLoginTime(new Date());
                    loginUser.setSessionId(UUID.randomUUID().toString());

                    loginUsers.add(loginUser);
                    return loginUser.getSessionId();
                }
            }
        } catch (Exception e) {
            LOGGER.error("login error", e);
        }
        return null;
    }

    public synchronized LoginUser getLoginUser(String sessionId) {
        return loginUsers.stream()
                .filter(a -> a.getSessionId().equals(sessionId))
                .findFirst()
                .orElse(null);
    }

}
