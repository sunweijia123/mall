package com.wuhan.mall.util;

import net.sf.json.JSONObject;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AccessToken {

    public static String getAccessToken(String appid, String appsecret) throws Exception{
        String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                +appid+ "&secret="+appsecret;
        System.out.println("URL for getting accessToken accessTokenUrl="+accessTokenUrl);

        URL url = new URL(accessTokenUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();

        //获取返回的字符
        InputStream inputStream = connection.getInputStream();
        int size =inputStream.available();
        byte[] bs =new byte[size];
        inputStream.read(bs);
        String message=new String(bs,"UTF-8");

        //获取access_token
        JSONObject jsonObject = JSONObject.fromObject(message);
        String accessToken = jsonObject.getString("access_token");
        String expires_in = jsonObject.getString("expires_in");
        System.out.println("accessToken="+accessToken);
        System.out.println("expires_in="+expires_in);
        return accessToken;
    }

    public static void main(String[] args) {
        try {
            getAccessToken("wx5571ac28b6823b94","8e076468cf6e91b66939dc33d1c27ca8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
