package dev.garstecki.gcp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

//    @Test
    void can_save_and_load_user() {
        repository.save(new User("test"));

        User user = repository.findAll().iterator().next();

        Assertions.assertNotNull(user.id);
        Assertions.assertEquals("test", user.name);
    }
}
