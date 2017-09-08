package com.wds.app.proxy.dynamic.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理工厂
 * @author wdongsen@linesum.com
 * @data 2017-09-07 10:03
 */
public class CglibProxyFactory implements MethodInterceptor {

    // 目标对象
    private Object object;

    public CglibProxyFactory(Object object) {
        this.object = object;
    }

    /**
     * 给目标对象创建一个代理对象
     * @return
     */
    public Object getProxyInstance(){
        // 工具类
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(object.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类（代理对象）
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before......");
        Object result = method.invoke(object, args);
        System.out.println("after.....");
        return result;
    }
}
