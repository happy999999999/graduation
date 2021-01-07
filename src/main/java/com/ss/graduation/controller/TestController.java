package com.ss.graduation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@Slf4j
public class TestController {

    private String picturePath = "/data/pictures/";
//    private String picturePath = "D:/";

    @GetMapping(value = "/test")
    @ResponseBody
    public String getTest(){
        return "hello spring";
    }

    @GetMapping(value = "/getPicture")
    private void getPicture(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File(picturePath+"1.jpg");
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
     * @return
     */
    @GetMapping(value = "getDistanceNoParameter")
    @ResponseBody
    public Double getDistance(){
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
    public Double getDistance(double lon1, double lat1, double lon2, double lat2){
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


}
