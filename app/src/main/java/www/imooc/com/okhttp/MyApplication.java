package www.imooc.com.okhttp;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.google.gson.Gson;
import com.aric.download.DownloadConfig;
import com.aric.download.DownloadManager;
import com.aric.download.db.DownloadHelper;
import com.aric.download.file.FileStorageManager;
import com.aric.download.http.HttpManager;
import com.squareup.leakcanary.LeakCanary;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author aric
 */
public class MyApplication extends Application {

    public static EndPoint endPoint;

    @Override
    public void onCreate() {
        super.onCreate();

        FileStorageManager.getInstance().init(this);
        HttpManager.getInstance().init(this);
        Stetho.initializeWithDefaults(this);
        DownloadHelper.getInstance().init(this);

        DownloadConfig config = new DownloadConfig.Builder()
                .setCoreThreadSize(2)
                .setMaxThreadSize(4)
                .setLocalProgressThreadSize(1)
                .builder();
        DownloadManager.getInstance().init(config);

        LeakCanary.install(this);

//        parseEndpoint();
    }

    private void parseEndpoint() {

        Gson gson = new Gson();
        InputStream is = getResources().openRawResource(R.raw.endpoint);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        endPoint = gson.fromJson(br, EndPoint.class);
    }
}


