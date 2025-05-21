package com.imho.runnable;

import com.imho.domain.entity.user.Customer;
import com.imho.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

public class RunnableOne implements Runnable {

    @Override
    public void run() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        System.out.println(EntityManagerUtil.getEntityManager());


        for (int i = 0; i < 100; i++) {
            try {
                EntityManagerUtil.beginTransaction();
                Customer customer = EntityManagerUtil.getEntityManager().find(Customer.class, 1, LockModeType.PESSIMISTIC_WRITE);
                Integer newPhoneNumber = Integer.parseInt(customer.getPhone()) + 1;
                customer.setPhone(String.valueOf(newPhoneNumber));
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
