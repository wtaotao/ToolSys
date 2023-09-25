/**
 * anji-allways.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.nikki.dataflowjob.process;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Map;  
import java.util.concurrent.ConcurrentHashMap;  
  
import com.nikki.dataflowjob.entity.Foo; 
/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: DataProcess.java, v 0.1 2017年7月24日 下午5:48:50 wangyanjun Exp $
 */
public class DataProcess {  
    
    private Map<Integer, Foo> data = new ConcurrentHashMap<>(30, 1);  
    public DataProcess()  
    {  
        for(int i=0;i<30;i++){  
            data.put(i, new Foo(i,Foo.Status.TODO));  
        }  
    }  
    public List<Foo> getData(String tailId,int shardNum)  
    {  
        int intId  = Integer.parseInt(tailId);  
        List<Foo> result = new ArrayList<Foo>();  
        for (Map.Entry<Integer, Foo> each : data.entrySet()) {  
            Foo foo = each.getValue();  
            int key = each.getKey();  
            if (key % shardNum == intId && foo.getStatus() == Foo.Status.TODO) {  
                result.add(foo);  
            }  
        }  
        return result;  
    }  
    public void setData(int i){  
        data.get(i).setStatus(Foo.Status.DONE);  
    }  
  
}
