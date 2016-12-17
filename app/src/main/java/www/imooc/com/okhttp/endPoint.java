package www.imooc.com.okhttp;

/**
 * Created by aric on 16/12/13.
 */

public class EndPoint {


    /**
     * endpoint : www.baiduuat.com
     */

    public UAT UAT;
    /**
     * endpoint : www.baiduqa.com
     */

    public QA QA;

    public QA getQA() {
        return QA;
    }

    public UAT getUAT() {
        return UAT;
    }

    public Stage getStage() {
        return Stage;
    }

    /**
     * endpoint : www.baidustage.com

     */

    public Stage Stage;

    public static class UAT {
        public String endpoint;
    }

    public static class QA {
        public static String endpoint;
    }

    public static class Stage {
        public String endpoint;
    }
}
