/**
 * nikki.com Inc.
 * Copyright (c) 2022-2023 All Rights Reserved.
 */
package com.nikki.sample;

import java.util.Optional;

import com.nikki.temp.Hobby;
import com.nikki.temp.Person;

/**
 * <pre>
 *
 * </pre>
 *
 * @author Jesse Wang
 * @version $Id: OptionalSample.java, v 0.1 2023年9月21日 上午10:48:06 Jesse Wang Exp $
 */
public class OptionalSample {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
           Person person = new Person();
           Hobby hobby = new Hobby();
           hobby.setScope("This is scope of hobby for testing optional!");
           person.setHobby(hobby);
           
           Optional.ofNullable(person)
                   .map(p -> p.getHobby())
                   .map(h -> h.getScope())
                   .ifPresent(scope ->System.out.println(scope));
    }

}
