package com.wjd.http.httpsrest;


public class HttpTest {

    public static void main(String[] args) {
        testNative();
        testHttpClient3();
    }

    public static void testNative() {
        int s = 323;
        String url = "https://10.10.202.100:8900/services/I8a8a4cc4016c4ab34ab301dc016c4b219ce00024";
        String json = "{" +
                "  \"data\": [" +
                "    {" +
                "      \"A\": 1," +
                "      \"B\": 2," +
                "      \"C\": 3" +
                "    }," +
                "    {" +
                "      \"A\": 4," +
                "      \"B\": 5," +
                "      \"C\": 6" +
                "    }" +
                "  ]" +
                "}";

        String result = NativeHttpsRequest.doPostWithJson(url, json);
        System.out.print(result);
    }

    public static void testHttpClient3() {
        String url = "https://10.10.202.100:8900/services/I8a8a4cc4016c4ab34ab301dc016c4b219ce00024";
        String json = "{" +
                "  \"data\": [" +
                "    {" +
                "      \"A\": 1," +
                "      \"B\": 2," +
                "      \"C\": 3" +
                "    }," +
                "    {" +
                "      \"A\": 4," +
                "      \"B\": 5," +
                "      \"C\": 6" +
                "    }" +
                "  ]" +
                "}";

        String result = HttpsClient3Request.doPostWithJson(url, json);
        System.out.println(result);
    }
}
