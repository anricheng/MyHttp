package www.imooc.com.okhttp;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.imooc.download.DownloadConfig;
import com.imooc.download.DownloadManager;
import com.imooc.download.db.DownloadHelper;
import com.imooc.download.file.FileStorageManager;
import com.imooc.download.http.HttpManager;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author nate
 */
public class MyApplication extends Application {

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
    }
}
