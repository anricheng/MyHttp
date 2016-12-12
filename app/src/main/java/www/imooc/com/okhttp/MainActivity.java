package www.imooc.com.okhttp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.imooc.download.utills.Logger;
import com.imooc.service.MoocApiProvider;
import com.imooc.service.MoocRequest;
import com.imooc.service.MoocResponse;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private ImageView mImageView;
    private ProgressBar mProgress;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mProgress = (ProgressBar) findViewById(R.id.progress);

        Map<String, String> map = new HashMap<>();
        map.put("username", "nate");
        map.put("userage", "12");
//
        MoocApiProvider.helloWorld("http://192.168.1.12:8080/web/HelloServlet", map, new MoocResponse<Person>() {

            @Override
            public void success(MoocRequest request, Person data) {

                Logger.debug("nate", data.toString());

            }

            @Override
            public void fail(int errorCode, String errorMsg) {

            }
        });


//        DownloadManager.Holder.getInstance();
//
//
//        File file = FileStorageManager.getInstance().getFileByName("http://www.imooc.com");
//        Logger.debug("nate", "file path = " + file.getAbsoluteFile());
//
//        final String url = "http://shouji.360tpcdn.com/160901/84c090897cbf0158b498da0f42f73308/com.icoolme.android.weather_2016090200.apk";
////        final String url = "http://szimg.mukewang.com/5763765d0001352105400300-360-202.jpg";
//        DownloadManager.getInstance().download(url, new DownloadCallback() {
//            @Override
//            public void success(File file) {
//                if (count < 1) {
//                    count++;
//                    return;
//                }
//                installApk(file);
//                Logger.debug("nate", "success " + file.getAbsoluteFile());
//
//            }
//
//            @Override
//            public void fail(int errorCode, String errorMessage) {
//                Logger.debug("nate", "fail " + errorCode + "  " + errorMessage);
//            }
//
//            @Override
//            public void progress(int progress) {
//                Logger.debug("nate", "progress    " + progress);
//                mProgress.setProgress(progress);
//
//            }
//        });

    }

    private void installApk(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + file.getAbsoluteFile().toString()), "application/vnd.android.package-archive");
        MainActivity.this.startActivity(intent);
    }
}
