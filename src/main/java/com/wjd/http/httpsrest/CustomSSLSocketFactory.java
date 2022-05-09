package com.wjd.http.httpsrest;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class CustomSSLSocketFactory implements ProtocolSocketFactory {

    private SSLContext sslContext = null;

    @Override
    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort)
            throws IOException, UnknownHostException {
        return getSSLContext().getSocketFactory().createSocket(host, port, localAddress, localPort);
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localAddress, int localPort,
                               HttpConnectionParams httpConnectionParams) throws IOException,
            UnknownHostException, ConnectTimeoutException {
        if (httpConnectionParams == null) {
            throw new IllegalArgumentException("Parameters may not be null");
        }

        int timeout = httpConnectionParams.getConnectionTimeout();
        SocketFactory socketfactory = getSSLContext().getSocketFactory();
        if (timeout == 0) {
            return socketfactory.createSocket(host, port, localAddress, localPort);
        } else {
            Socket socket = socketfactory.createSocket();
            SocketAddress localAddr = new InetSocketAddress(localAddress, localPort);
            SocketAddress remoteAddr = new InetSocketAddress(host, port);
            socket.bind(localAddr);
            socket.connect(remoteAddr, timeout);
            return socket;
        }
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return getSSLContext().getSocketFactory().createSocket(host, port);
    }

    public SSLContext getSSLContext() {
        if (sslContext == null) {
            sslContext = createSLLContext();
        }
        return sslContext;
    }

    /**
     * 创建SSLContext，设置信任所有请求证书
     * @return
     */
    private SSLContext createSLLContext() {
        SSLContext sslContext = null;

        try {
            sslContext = SSLContext.getInstance("SSL");
            //  配置认证管理器
            javax.net.ssl.TrustManager[] trustAllCerts = {new TrustAllTrustManager()};
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return sslContext;
    }
}
