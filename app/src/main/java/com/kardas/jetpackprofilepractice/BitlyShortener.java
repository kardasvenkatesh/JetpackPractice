package com.kardas.jetpackprofilepractice;

import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BitlyShortener {
    private static final String TAG = BitlyShortener.class.getSimpleName();

    private static final String BITLY_API_BASE_URL = "https://api-ssl.bitly.com/v4/shorten";
    private static final String BITLY_ACCESS_TOKEN = "9b5c477a07745d48aff16458a4d8d38991728c78";

    private OkHttpClient client;

    public BitlyShortener() {
        client = new OkHttpClient();
    }

    public interface BitlyShortenCallback {
        void onUrlShortened(String shortenedUrl);

        void onError(String errorMessage);
    }

    public void shortenUrl(String url, final BitlyShortenCallback callback) {
        String requestBody = "{\"long_url\": \"" + url + "\"}";

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), requestBody);
        Request request = new Request.Builder().url(BITLY_API_BASE_URL).header("Authorization", "Bearer " + BITLY_ACCESS_TOKEN).post(body).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String jsonResponse = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(jsonResponse);
                        String shortenedUrl = jsonObject.getString("id");
                        callback.onUrlShortened(shortenedUrl);
                    } catch (JSONException e) {
                        Log.e(TAG, "Error parsing JSON response: " + e.getMessage());
                        callback.onError("Error parsing response from Bitly API");
                    }
                } else {
                    callback.onError("Failed to shorten URL with Bitly API");
                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onError("Failed to connect to Bitly API");
            }
//
        });
    }
}


//@Override
//            public void onFailure(Call call, IOException e) {
//                callback.onError("Failed to connect to Bitly API");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    String jsonResponse = response.body().string();
//                    try {
//                        JSONObject jsonObject = new JSONObject(jsonResponse);
//                        String shortenedUrl = jsonObject.getString("id");
//                        callback.onUrlShortened(shortenedUrl);
//                    } catch (JSONException e) {
//                        Log.e(TAG, "Error parsing JSON response: " + e.getMessage());
//                        callback.onError("Error parsing response from Bitly API");
//                    }
//                } else {
//                    callback.onError("Failed to shorten URL with Bitly API");
//                }
//            }
