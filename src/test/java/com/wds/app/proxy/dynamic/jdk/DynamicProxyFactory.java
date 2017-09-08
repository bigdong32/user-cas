package com.wds.app.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象（也可以实现InvocationHandler接口）
 * @author wdongsen@linesum.com
 * @data 2017-09-07 9:27
 */
public class DynamicProxyFactory{

    // 目标对象
    private Object target;

    public DynamicProxyFactory(Object target) {
        this.target = target;
    }

    // 生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("before...");
                    // 执行目标方法
                    Object result = method.invoke(target, args);
                    System.out.println("after...");
                    return result;
                });
    }
}
