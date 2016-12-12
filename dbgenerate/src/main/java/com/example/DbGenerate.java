package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DbGenerate {


    public static void main(String args[]) {

        Schema schema = new Schema(1, "com.imooc.db");

        Entity entity = schema.addEntity("DownloadEntity");
        entity.addLongProperty("start_position");
        entity.addLongProperty("end_position");
        entity.addLongProperty("progress_position");
        entity.addStringProperty("download_url");
        entity.addIntProperty("thread_id");
        entity.addIdProperty().autoincrement();

        try {
            new DaoGenerator().generateAll(schema, "dbgenerate/src-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
