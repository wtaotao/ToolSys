/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.pattern.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * <pre>
 * 代理主要类
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: CglibProxy.java, v 0.1 2023年9月22日 下午4:10:44 wangyanjun Exp $
 */
public class CglibProxy implements MethodInterceptor {
    
    private Object target;
    
    public Object getInstance(Object target) {
        //设置需要创建子类的类
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    
    /**
     * 代理实际方法
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @return
     * @throws Throwable
     * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
     */
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println("开始事务");
        Object result = arg3.invoke(target, arg2);
        System.out.println("结束事务");
        //返回代理对象
        return result;
    }

}
