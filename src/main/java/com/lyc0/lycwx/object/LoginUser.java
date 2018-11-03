package com.lyc0.lycwx.object;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LoginUser {
    private String openId;
    private String userNick;
    private String avatarUrl;
    private String sessionKey;
    private Date loginTime;

    private String sessionId;


}
