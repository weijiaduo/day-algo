package com.wjd.http.httpsrest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpsClient3Request {

    static {
        // 设置自定义的 SSL
        Protocol myhttps = new Protocol("https", new CustomSSLSocketFactory(), 443);
        Protocol.registerProtocol("https", myhttps);
    }

    /**
     * POST请求
     * @param httpUrl 请求路径
     * @param jsonStr 请求参数，json字符串
     * @return 请求返回结果
     */
    public static String doPostWithJson(String httpUrl, String jsonStr) {

        InputStream is = null;
        BufferedReader buf = null;
        String result = null;

        // 创建 HttpClient 实例
        HttpClient httpClient = new HttpClient();
        // 设置连接超时时间
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);

        // 创建请求方法实例
        PostMethod postMethod = new PostMethod(httpUrl);
        // 设置请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        // 设置请求接收数据类型
        postMethod.setRequestHeader("accept", "application/json");

        // 执行请求并获取返回数据
        try {
            StringRequestEntity requestEntity = new StringRequestEntity(jsonStr,
                    "application/json", "UTF-8");
            postMethod.setRequestEntity(requestEntity);

            // 获取请求状态码
            int statusCode = httpClient.executeMethod(postMethod);
            if (statusCode == HttpStatus.SC_OK) {
                // 获取请求返回数据流
                is = postMethod.getResponseBodyAsStream();
                buf = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                StringBuffer sb = new StringBuffer();
                String s;
                while ((s=buf.readLine()) != null) {
                    sb.append(s).append("\n");
                }

                result = sb.toString();
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
        }

        return result;
    }

}
