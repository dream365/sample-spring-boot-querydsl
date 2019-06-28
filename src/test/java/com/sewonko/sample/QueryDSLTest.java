package com.sewonko.sample;

import com.sewonko.sample.model.HomeAddress;
import com.sewonko.sample.model.Member;
import com.sewonko.sample.model.Phone;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryDSLTest extends QuerydslRepositorySupport {

    @PersistenceContext
    private EntityManager em;

    public QueryDSLTest() {
        super(Member.class);
    }

    @Before
    public void before() {
        Phone phone = new Phone(1, "010-1111-1111", "LG");

        Phone phone1 = new Phone(2, "010-2222-1111", "SAMSUNG");
        Phone phone2 = new Phone(3, "010-2222-2222", "SAMSUNG");
        Phone phone3 = new Phone(4, "010-2222-3333", "SAMSUNG");

        Phone phone4 = new Phone(5, "010-3333-1111", "APPLE");
        Phone phone5 = new Phone(6, "010-3333-2222", "APPLE");
        Phone phone6 = new Phone(7, "010-3333-3333", "APPLE");

        HomeAddress homeAddress1 = HomeAddress.builder()
                                    .id(1)
                                    .address("경기도 구리시")
                                    .build();

        HomeAddress homeAddress2 = HomeAddress.builder()
                                    .id(2)
                                    .address("경기도 하남시")
                                    .build();

        HomeAddress homeAddress3 = HomeAddress.builder()
                                    .id(3)
                                    .address("경기도 수원시")
                                    .build();

        Member member1 = Member.builder()
                            .id(1)
                            .name("member_1")
                            .build();

        Member member2 = Member.builder()
                .id(2)
                .name("member_2")
                .build();

        Member member3 = Member.builder()
                .id(3)
                .name("member_3")
                .build();

        member1.setHomeAddress(homeAddress1);
        member1.addPhone(phone);

        member2.setHomeAddress(homeAddress2);
        member2.addPhone(phone1);
        member2.addPhone(phone2);
        member2.addPhone(phone3);

        member3.setHomeAddress(homeAddress3);
        member3.addPhone(phone4);
        member3.addPhone(phone5);
        member3.addPhone(phone6);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.flush();
        em.clear();
    }
}
