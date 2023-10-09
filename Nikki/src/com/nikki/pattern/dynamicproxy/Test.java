/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.pattern.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: Test.java, v 0.1 2023年9月22日 下午1:29:03 wangyanjun Exp $
 */
public class Test {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        // 创建被代理对象
        UserDao userDaoImpl = new UserDaoImpl();
        // 创建invocationHandler实例
        InvocationHandlerImpl invocationHandlerImpl = new InvocationHandlerImpl(userDaoImpl);
        
        // 类加载器
        ClassLoader loader = userDaoImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();
        
        // 主要加载器、一组接口及调用处理动态代理实例
        UserDao userProxyInstance = (UserDao) Proxy.newProxyInstance(loader, interfaces, invocationHandlerImpl);
        userProxyInstance.save();

    }

}
