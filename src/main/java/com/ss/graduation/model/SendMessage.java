package com.ss.graduation.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class SendMessage {

    private String touser;

    private String template_id;

    private String page;

    private String miniprogram_state;

    private String lang;

    private JSONObject jsonObject;

}
