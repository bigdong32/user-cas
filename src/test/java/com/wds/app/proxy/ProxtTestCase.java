package com.wds.app.proxy;

import com.wds.app.proxy.dynamic.cglib.CglibProxyFactory;
import com.wds.app.proxy.dynamic.jdk.DynamicProxyFactory;
import com.wds.app.proxy.jingtai.CountImpl;
import com.wds.app.proxy.jingtai.CountProxy;
import com.wds.app.proxy.jingtai.ICount;
import org.junit.Test;

/**
 * 代理类测试
 * @author wdongsen@linesum.com
 * @data 2017-09-07 9:34
 */
public class ProxtTestCase {

    @Test
    public void testJingTai(){
        CountProxy countProxy = new CountProxy(new CountImpl());
        countProxy.queryCount();
    }

    @Test
    public void testJdkDynamic(){
        ICount target = new CountImpl();
        DynamicProxyFactory dynamicProxyFactory = new DynamicProxyFactory(target);
        ICount proxy = (ICount) dynamicProxyFactory.getProxyInstance();
        proxy.queryCount();
    }

    @Test
    public void testCglibDynamic(){
        // 目标对象
        CountImpl count = new CountImpl();
        // 代理对象
        CountImpl proxy = (CountImpl) new CglibProxyFactory(count).getProxyInstance();
        proxy.queryCount();
    }
}
