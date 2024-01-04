/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.pattern;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jesse Wang
 * @filename Singleton.java
 * @version v0.1 
 * @time 2024年1月4日 上午10:17:51 
 *
 */
public class Singleton {
    
    private static volatile Singleton ins = null;

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    private void Singleton() {
    }
    
    public static Singleton getInstance() {
        
        if (ins == null) {
            synchronized(Singleton.class) {
                if (ins == null) {
                    ins = new Singleton();
                }
            }
        } 
        
        return ins;
    }

}
