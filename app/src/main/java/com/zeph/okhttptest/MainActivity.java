package com.zeph.okhttptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

  private String mBaseUrl="http://192.168.1.106:8080/OkHttpTest/";

  OkHttpClient client = new OkHttpClient();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void doPost(View view){


  }

  /**
   * OkHtpp Get方法
   * @param view
   * @throws IOException
   */
  public void doGet(View view) throws IOException {
    Request request = new Request.Builder().get().url(mBaseUrl + "login?username=aaa&password=123")
        .build();
    client.newCall(request).enqueue(new Callback() {
      @Override
      public void onFailure(Call call, IOException e) {
        L.e("onFailure："+e.getMessage());
        e.printStackTrace();
      }

      @Override
      public void onResponse(Call call, Response response) throws IOException {
        L.e("Response:");
        String data = response.body().string();
        L.e(data);
      }
    });
  }
}
