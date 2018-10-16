package com.es;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3;i ++){
            list.add(i);
        }
        list.add(null);
        System.out.println("f-->" + list.size());

//        list = list.stream().filter(Objects::nonNull)
//                .map(integer -> {
//                    integer = integer + 2;
//                    return integer;
//                }).collect(Collectors.toList());

        list = list.stream().filter(Objects::nonNull).filter(integer -> integer > 1).collect(Collectors.toList());
        System.out.println("s-->" + list.size());

    }

    protected class User{
        public String userName;
        public int age;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
