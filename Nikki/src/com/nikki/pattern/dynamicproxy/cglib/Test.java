/**
 * anji-allways.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.pattern.dynamicproxy.cglib;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: Test.java, v 0.1 2023年9月22日 下午4:23:07 wangyanjun Exp $
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
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = (UserDao) cglibProxy.getInstance(new UserDaoImpl());
        userDao.save();
    }

}
