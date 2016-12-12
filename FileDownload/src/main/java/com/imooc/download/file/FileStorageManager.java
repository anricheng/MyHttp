package com.imooc.download.file;

import android.content.Context;
import android.os.Environment;

import com.imooc.download.utills.Md5Uills;

import java.io.File;
import java.io.IOException;

/**
 * @author nate
 */
public class FileStorageManager {

    private static final FileStorageManager sManager = new FileStorageManager();

    private Context mContext;

    public static FileStorageManager getInstance() {
        return sManager;
    }

    private FileStorageManager() {

    }

    public void init(Context context) {
        this.mContext = context;
    }


    public File getFileByName(String url) {

        File parent;

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            parent = mContext.getExternalCacheDir();
        } else {
            parent = mContext.getCacheDir();
        }

        String fileName = Md5Uills.generateCode(url);

        File file = new File(parent, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return file;

    }


}
