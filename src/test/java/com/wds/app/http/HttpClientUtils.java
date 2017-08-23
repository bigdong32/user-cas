package com.wds.app.http;

import org.apache.commons.lang3.RandomUtils;
import org.apache.http.Consts;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.RequestAcceptEncoding;
import org.apache.http.client.protocol.ResponseContentEncoding;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.*;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;

/**
 * http客户端工具类
 * @author wdongsen@linesum.com
 */
public class HttpClientUtils {

    // 用户代理浏览器
    private static final String[] USER_AGENTS = {
            "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36",// Chrome 32.0.1667.0
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1664.3 Safari/537.36",// Chrome 32.0.1664.3
            "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36",// Chrome 31.0.1650.16
            "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.17 Safari/537.36",// Chrome 30.0.1599.17
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36",// Chrome 29.0.1547.62
            "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36",// Chrome 60.0.3112.90
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36",// Chrome 50.0.2661.87
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0",// Firefox 46.0
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.154 Safari/537.36 LBBROWSER",// 猎豹浏览器
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36"// 360安全浏览器
    };

    // 连接超时时间:5秒
    private static final int CONNECTION_TIME_OUT = 5000;
    // 连接超时时间:30秒
    private static final int SOCKET_TIME_OUT = 30000;

    private static final HttpClient HTTP_CLIENT;

    static {
        HttpClientBuilder httpClientBuilder = HttpClients.custom();

        //设置请求头
        httpClientBuilder.addInterceptorFirst(new RequestAcceptEncoding());// 设置请求头Accept-Encoding:gzip
        httpClientBuilder.addInterceptorFirst(new ResponseContentEncoding());// 设置反馈gzip支持
        httpClientBuilder.setUserAgent(USER_AGENTS[RandomUtils.nextInt(0, USER_AGENTS.length)]);// 设置用户代理浏览器

        // 设置请求配置
        RequestConfig defaultRequestConfig =
                RequestConfig.custom()
                        .setExpectContinueEnabled(false)    // 不使用Expect:100-Continue握手
                        .setConnectTimeout(CONNECTION_TIME_OUT)   // 连接超时时间
                        .setSocketTimeout(SOCKET_TIME_OUT)    // 数据读取超时时间
                        .build();
        httpClientBuilder.setDefaultRequestConfig(defaultRequestConfig);

        // 设置请求重试策略（失败重试一次）
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(1, true));

        Registry<ConnectionSocketFactory> registry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.INSTANCE)
                        .register("https", SSLConnectionSocketFactory.getSocketFactory())
                        .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(300);// 设置连接池最大http连接数
        connectionManager.setDefaultMaxPerRoute(200);// 目标路由的最大连接

        SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();// 关闭Nagle算法，这样数据将会更早地发送，但是增加了网络消耗。
        connectionManager.setDefaultSocketConfig(socketConfig);
        ConnectionConfig connectionConfig = ConnectionConfig.custom().setCharset(Consts.UTF_8).build();// 设置编码
        connectionManager.setDefaultConnectionConfig(connectionConfig);
        httpClientBuilder.setConnectionManager(connectionManager);

        HTTP_CLIENT = httpClientBuilder.build();
    }

    /**
     * 模拟请求
     * @param request
     * @return
     * @throws IOException
     */
    public static String execute(HttpUriRequest request) throws IOException {
        return HTTP_CLIENT.execute(request, new BasicResponseHandler());
    }
}
