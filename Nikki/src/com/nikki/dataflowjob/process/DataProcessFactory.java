/**
 * anji-allways.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.nikki.dataflowjob.process;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: DataProcessFactory.java, v 0.1 2017年7月24日 下午5:51:02 wangyanjun Exp $
 */
public class DataProcessFactory {  
    private static DataProcess dataProcess = new DataProcess();  
        
      public static DataProcess getDataProcess() {  
          return dataProcess;  
      }  

}