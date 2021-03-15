package com.ts.api;

import com.ts.api.entity.UserEntity;
import com.ts.api.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    public void save_select_user() {
        final UserEntity user = new UserEntity();
        user.setUserId("Test User");
        user.setUserPw("test");
        user.setUserNm("Insert Test User");

        // Insert
        assertThat(userRepo.save(user), is(notNullValue()));

        // Select
        assertThat(userRepo.findAll(), is(notNullValue()));
        userRepo.findAll().forEach(o -> System.out.println(o.getUserNm()));
        System.out.println();
    }

}
