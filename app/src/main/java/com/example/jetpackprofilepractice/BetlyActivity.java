package com.example.jetpackprofilepractice;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextParams;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.navigationdrawercomposeexample.R;

public class BetlyActivity extends AppCompatActivity {

    private BitlyShortener bitlyShortener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitly);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        AppCompatButton shareBtn = findViewById(R.id.shareBtn);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String originalUrl = "http://stackoverflow.com/questions/18372672/how-do-i-use-the-google-url-shortener-api-on-android/20406915";
                BitlyShortener bitlyShortener = new BitlyShortener();
                bitlyShortener.shortenUrl(originalUrl, new BitlyShortener.BitlyShortenCallback() {
                    @Override
                    public void onUrlShortened(String shortenedUrl) {
                        // Handle the shortened URL
                        Log.d(TAG, "Shortened URL: " + shortenedUrl);
                    }

                    @Override
                    public void onError(String errorMessage) {
                        // Handle the error
                        Log.e(TAG, "Error shortening URL: " + errorMessage);
                    }
                });



            }
        });

    }

}





