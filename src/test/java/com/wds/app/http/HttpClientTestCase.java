package com.wds.app.http;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import java.io.IOException;

/**
 * http客户端请求模拟
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-23 15:36
 */
public class HttpClientTestCase {

    @Test
    public void testHttp() throws IOException {
        HttpPost httpPost = new HttpPost("http://www.cnblogs.com/sink_cup/archive/2011/03/15/http_user_agent.html");
        String json = JSON.toJSONString(new Object());
        StringEntity entity = new StringEntity(json, Consts.UTF_8);
        httpPost.setEntity(entity);

        String response = HttpClientUtils.execute(httpPost);
        System.out.println(response);

    }
    @Test
    public void testQiaodanHttp() throws IOException {
        HttpPost httpPost = new HttpPost("http://open.qiaodan.com:8070/ExportApi/EApi.svc/InvokApi");
        String json = JSON.toJSONString(new Object());
        StringEntity entity = new StringEntity(json, Consts.UTF_8);
        httpPost.setEntity(entity);

        String response = HttpClientUtils.execute(httpPost);
        System.out.println(response);

    }

}
