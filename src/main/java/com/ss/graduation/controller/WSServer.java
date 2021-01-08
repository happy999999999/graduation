package com.ss.graduation.controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint(value ="/ws/{user}")
public class WSServer {
    private String currentUser;
    private static Set<Session> map = new HashSet<>();
    //用户保存
    private static Map<String,String> userName = new HashMap<String, String>();

    //连接打开时执行
    @OnOpen
    public void onOpen(@PathParam("user")String user, Session session){
        currentUser = user;
        map.add(session);
        userName.put(session.getId(),user);
        //自定义方法，更新客户端的客户在线信息
        sendOutMessage();
    }



    //收到消息时执行
    @OnMessage
    public void onMessage(String message,Session session) throws IOException {
        //把信息传到已连接的用户客户端
        for(Session sess : map){
            //userMessage& 这段是为了客户端判断信息类型，是用户发送的消息，还是所有在线用户的信息
            sess.getBasicRemote().sendText("userMessage&"+currentUser + "  : " + message);
        }

    }

    //连接关闭时执行
    @OnClose
    public void onClose(Session session, CloseReason closeReason){
        map.remove(session);//删掉断开连接的用户
        userName.remove(session.getId()); //删掉断开连接的用户信息
        //更新在线的所有用户
        sendOutMessage();
    }

    //连接错误时执行
    @OnError
    public void OnError(Throwable t){
        t.printStackTrace();
    }

    private static void sendOutMessage(){
        //将所有在线的用户拼接成字符串  userAllName&  这段是信息类型判断
        StringBuffer userAllStr = new StringBuffer("userAllName&");
        String str = "";
        for(String s : userName.keySet()){
            userAllStr.append(str+userName.get(s));
            str=",";
        }
        System.out.println(userAllStr);
        //循环所有客户id，向客户端发送信息
        for(Session session : map){
            try {
                session.getBasicRemote().sendText(userAllStr.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}