package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://weatherbit-v1-mashape.p.rapidapi.com/current?lat=48.450001&lon=34.983334&lang=ru")
                .get()
                .addHeader("X-RapidAPI-Key", "c0648fb830msh0dd8e2cf527c28dp14d6ccjsne69453a70448")
                .addHeader("X-RapidAPI-Host", "weatherbit-v1-mashape.p.rapidapi.com")
                .build();

        try {
            Response response = client.newCall(request).execute();

            JSONObject json = new JSONObject(
                    response.body().string()
            );
            String prettyResponseBody = json.toString(4);

            System.out.println(prettyResponseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}