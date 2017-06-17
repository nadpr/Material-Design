package salatigacity.materialdesigndemo.data.remote;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import salatigacity.materialdesigndemo.data.model.RssFeedModel;

/**
 * Created by ssh on 6/13/2017.
 */

public class FetchRss {

    public String url = "https://bit.ly/RSSJson";

    private RssCallback callback;

    public FetchRss(RssCallback callback) {
        this.callback = callback;
    }

    public void getData(){
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();

        client.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        RssFeedModel data = new Gson().fromJson(json, RssFeedModel.class);
                        callback.onResponse(data);
                    }
                });
    }

    public interface RssCallback{
        void onResponse(RssFeedModel rssFeedModel);
        void onError(Throwable throwable);
    }
}
