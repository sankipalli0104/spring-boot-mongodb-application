package spring.boot.mongo.demo.scheduler;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        Date currentTimeStamp = new Date(System.currentTimeMillis() + 43200000);
        System.out.println("Current "+currentTimeStamp);
        System.out.println("modified"+new Date(System.currentTimeMillis() + 43100000));

    }
}
