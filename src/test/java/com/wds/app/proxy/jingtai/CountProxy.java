package com.wds.app.proxy.jingtai;

/**
 * 静态代理
 * @author wdongsen@linesum.com
 * @data 2017-08-31 16:57
 */
public class CountProxy implements ICount{

    private CountImpl countImpl;

    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("处理之前。。。");
        countImpl.queryCount();
        System.out.println("处理之后。。。");
    }
}
