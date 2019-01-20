package com.jack.spider;

import com.alibaba.fastjson.JSON;
import com.jack.entity.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


import java.io.IOException;

/**
 * Description
 * <p>
 * </p>
 * DATE 2018/12/28.
 *
 * @author liweijian.
 */
public class RetrivePage {

    private static OkHttpClient httpClient = new OkHttpClient();

    public static String downloadPage(String path) throws IOException {
        Request request = new Request.Builder()
                .url(path)
                .build();


        Response response = httpClient.newCall(request).execute();

        return response.body().string();
    }

    public static String postRequest(String path) throws IOException {
        User user = new User();
        user.setUsername("liweijian");
        user.setPassword("aaa");
        user.setAge(11);
        user.setGender((short)1);
        RequestBody requestBody = RequestBody.create(MediaType.get("application/json"), JSON.toJSONString(user));
        Request request = new Request.Builder()
                .url(path)
                .post(requestBody)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        String result = downloadPage("http://localhost:8081/user/list");

        String postBody = postRequest("http://localhost:8081/user/add");
        System.out.println(postBody);
    }


}
