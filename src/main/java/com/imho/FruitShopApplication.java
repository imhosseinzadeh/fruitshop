package com.imho;

import com.imho.domain.entity.user.Customer;
import com.imho.runnable.RunnableOne;
import com.imho.runnable.RunnableTwo;
import com.imho.util.EntityManagerUtil;

public class FruitShopApplication {
    public static void main(String[] args) throws InterruptedException {

        //insert();

        Thread thread1 = new Thread(new RunnableOne());
        Thread thread2 = new Thread(new RunnableTwo());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }

    public static void insert() {
        EntityManagerUtil.beginTransaction();
        Customer customer = Customer.builder()
                .name("Ali")
                .nationalId("123424123442")
                .phone("0")
                .password("123456")
                .address("Tehran")
                .build();
        EntityManagerUtil.getEntityManager().persist(customer);
        EntityManagerUtil.commitTransaction();
    }
}