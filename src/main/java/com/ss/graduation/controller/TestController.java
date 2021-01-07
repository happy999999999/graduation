package com.ss.graduation.controller;

import com.alibaba.fastjson.JSONObject;
import com.ss.graduation.model.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@Slf4j
public class TestController {

    private String picturePath = "/data/pictures/";
//    private String picturePath = "D:/";

    @GetMapping(value = "/test")
    @ResponseBody
    public String getTest() {
        return "hello spring";
    }

    @GetMapping(value = "/getPicture")
    private void getPicture(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File(picturePath + "1.jpg");
        FileInputStream fis;
        fis = new FileInputStream(file);
        long size = file.length();
        byte[] temp = new byte[(int) size];
        fis.read(temp, 0, (int) size);
        fis.close();
        byte[] data = temp;
        OutputStream out = response.getOutputStream();
        response.setContentType("image/png");
        out.write(data);
        out.flush();
        out.close();
        log.info("调用图片");
    }

    /**
     * 根据经纬度计算两点之间距离
     *
     * @return
     */
    @GetMapping(value = "getDistanceNoParameter")
    @ResponseBody
    public Double getDistance() {
        double lon1 = 116.474875;
        double lat1 = 40.027312;
        double lon2 = 116.465964;
        double lat2 = 40.015349;
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double c = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        c = c * 6378.137;// 6378.137赤道半径
        log.info("计算距离");
        return Math.round(c * 10000d) / 10000d;
    }

    private double rad(double d) {
        return d * Math.PI / 180.0;
    }

    @GetMapping(value = "/getDistance")
    @ResponseBody
    public Double getDistance(double lon1, double lat1, double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double c = 2 * Math.asin(Math.sqrt(
                Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        c = c * 6378.137;// 6378.137赤道半径
        log.info("计算距离");
        return Math.round(c * 10000d) / 10000d;
    }

    //小程序发送消息
    //https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/subscribe-message/subscribeMessage.send.html
    @GetMapping(value = "/sendMessages")
    @ResponseBody
    public void sendMessages() throws Exception {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setTouser("of__j5DnvSD8-ODFSW8Mva8_LgK0");
        sendMessage.setTemplate_id("4a5KscDk1A7OREtcqscFv1HExURGjW50ES9l8Kgbpag");
        sendMessage.setPage("index");
        sendMessage.setMiniprogram_state("developer");
        sendMessage.setLang("zh_CN");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("time5", "2021-01-09");
        jsonObject.put("thing1", "test");
        jsonObject.put("thing2", "test2");
        jsonObject.put("number3", "3");
        sendMessage.setJsonObject(jsonObject);
        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=40_zECRTT9y9Ootu883i_zjXidrFPK3J-fwoPrQvaqxpFh6xs4mQFlahcBEKHaWL6oHYISpDu87FJOjdkfxhmtH7GK6zg18dTpeRnC7cmJQuzU1JCgTtDZus_1XZx5xf7EZA6j_Y1GFlgFZN-yGEMCcACAYGW";
        String parm = sendMessage.toString();
        postUrl(url, parm);
        log.info("发送消息");
    }
    //调用接口
    private String postUrl(String arl, String parm) throws Exception {
        // 创建url资源
        OutputStreamWriter out = null;
        URL url;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            url = new URL(arl);

// 建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
// 设置允许输出
            conn.setDoOutput(true);
            conn.setDoInput(true);
// 设置不用缓存
            conn.setUseCaches(false);
// 设置传递方式
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setInstanceFollowRedirects(true);
            conn.setRequestMethod("POST"); // 设置请求方式
            conn.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            conn.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");//设置消息头，解决508错误
// 开始连接请求
            conn.connect();
            out = new OutputStreamWriter(
                    conn.getOutputStream(), "UTF-8"); // utf-8编码
// 写入请求的字符串
            out.append(parm);
            out.flush();
            out.close();
// System.out.println(conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
// System.out.println("success");
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
            }
        } catch (Exception e) {
// System.out.println("发送 POST 请求出现异常！" + e);
            result = new StringBuilder("{\"resCode\":\"1\",\"errCode\":\"1001\",\"resData\":\"\"}");
            e.printStackTrace();
// log.error("远程服务未开启", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

}
