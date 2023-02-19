package com.wjd.http.httprest;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class NativeHttpRequest {

    /**
     * POST请求
     * @param httpUrl 请求路径
     * @param jsonStr 请求参数，json字符串
     * @return 请求返回结果
     */
    public static String doPostWithJson(String httpUrl, String jsonStr) {
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader buf = null;
        String result = null;

        try {
            URL url = new URL(httpUrl);

            // 通过远程URL连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();

            // 设置连接q请求方式
            connection.setRequestMethod("POST");

            // 设置连接超时时间
            connection.setConnectTimeout(15000);

            // 设置数据读取超时时间
            connection.setReadTimeout(60000);

            // 发送数据时需要设为true，默认值为false
            connection.setDoOutput(true);
            // 接收数据时需要设为true，默认值为true
            connection.setDoInput(true);

            // 设置参数格式为json格式
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            // 设置接收数据类型为json
            connection.setRequestProperty("accept", "application/json");


            // 获取输出流并写入json数据
            os = connection.getOutputStream();
            os.write(jsonStr.getBytes(StandardCharsets.UTF_8));

            // 等待获取返回数据
            if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                is = connection.getInputStream();
                buf = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                StringBuilder sb = new StringBuilder();
                String s;
                while ((s = buf.readLine()) != null) {
                    sb.append(s).append("\n");
                }
                result = sb.toString();
            } else {
                System.out.println("response code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return result;
    }

}
