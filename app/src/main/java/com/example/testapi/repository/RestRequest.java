package com.example.testapi.repository;

import android.content.ContentValues;
import android.util.Log;

import com.example.testapi.dispatchers.Dispatcher;
import com.example.testapi.model.LoginStep2Model;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestRequest {

    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final String LINK_LOGIN_STEP_1_API = "https://utcoin.one/loyality/login_step1?phone=";


    public void request(String numberPhone, Dispatcher dispatcher) {
        String url = LINK_LOGIN_STEP_1_API + numberPhone;

        GET(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                dispatcher.dispatch("Ошибка");
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String respString = response.body().string();
                try {
                    LoginStep2Model result = new Gson().fromJson(respString, LoginStep2Model.class);
                    dispatcher.dispatch(result.getNormalizedPhone());
                } catch (Exception e) {
                    Log.w(ContentValues.TAG, e);
                }
            }
        });
    }

    private Call GET(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
        return call;
    }
}
