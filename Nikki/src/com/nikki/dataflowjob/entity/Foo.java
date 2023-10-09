/**
 * nikki.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.nikki.dataflowjob.entity;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: Foo.java, v 0.1 2017年7月24日 下午5:50:36 wangyanjun Exp $
 */
public class Foo {  
    private int id;  
    private Status status;  
    public Foo(final int id,final Status status) {  
        this.id = id;  
        this.status = status;  
    }  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public Status getStatus() {  
        return status;  
    }  
    public void setStatus(Status status) {  
        this.status = status;  
    }  
    public enum Status{  
        TODO,  
        DONE  
    }   
  
} 
