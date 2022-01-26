package com.example.jpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {


    @PersistenceContext
    EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setName("sungwoo2");
        account.setPassword("1234");


        Study study = new Study();
        study.setName("spring data JPA");

        study.setAccount(account);

        Session session = em.unwrap(Session.class);
        session.save(account);
        session.save(study);

    }
}
