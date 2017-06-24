package android.kan.nop.myandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import static android.util.Log.d;

/**
 * Created by Admin on 24/6/2560.
 */

public class PostDataToServer extends AsyncTask<String, Void, String>{
    private Context context;

    public PostDataToServer(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", params[0])
                    .add("User", params[1])
                    .add("Password", params[2])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[3]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            Log.d("SiamV1", "e doin ==> "+e.toString());
            return null;
        }

    }
}   // Main Class
