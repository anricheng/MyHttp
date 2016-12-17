package www.imooc.com.okhttp;

/**
 * Created by aric on 16/12/13.
 */

public class UrlEndLine {


    public static UAT UAT;
    public static QA QA;
    public static Stage Stage;

    public static class UAT {
        public String endpoint1;
        public String endpoint2;
        public String endpoint3;

        public String getEndpoint1() {
            return endpoint1;
        }

        public void setEndpoint1(String endpoint1) {
            this.endpoint1 = endpoint1;
        }

        public String getEndpoint2() {
            return endpoint2;
        }

        public void setEndpoint2(String endpoint2) {
            this.endpoint2 = endpoint2;
        }

        public String getEndpoint3() {
            return endpoint3;
        }

        public void setEndpoint3(String endpoint3) {
            this.endpoint3 = endpoint3;
        }
    }

    public static class QA {
        public String endpoint1;
        public String endpoint2;
        public String endpoint3;
        public String getEndpoint1() {
            return endpoint1;
        }

        public void setEndpoint1(String endpoint1) {
            this.endpoint1 = endpoint1;
        }

        public String getEndpoint2() {
            return endpoint2;
        }

        public void setEndpoint2(String endpoint2) {
            this.endpoint2 = endpoint2;
        }

        public String getEndpoint3() {
            return endpoint3;
        }

        public void setEndpoint3(String endpoint3) {
            this.endpoint3 = endpoint3;
        }

    }

    public static class Stage {
        public String endpoint1;
        public String endpoint2;
        public String endpoint3;

        public String getEndpoint1() {
            return endpoint1;
        }

        public void setEndpoint1(String endpoint1) {
            this.endpoint1 = endpoint1;
        }

        public String getEndpoint2() {
            return endpoint2;
        }

        public void setEndpoint2(String endpoint2) {
            this.endpoint2 = endpoint2;
        }

        public String getEndpoint3() {
            return endpoint3;
        }

        public void setEndpoint3(String endpoint3) {
            this.endpoint3 = endpoint3;
        }
    }
}
