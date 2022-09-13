package dev.garstecki.gcp;

import com.google.cloud.datastore.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Autowired
    private Datastore datastore;

    @Test
    void can_save_and_load_user() {
        repository.save(new User("test"));

        User user = repository.findAll().iterator().next();

        Assertions.assertNotNull(user.id);
        Assertions.assertEquals("test", user.name);
    }

    @Test
    void use_native_api() {
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");

        var taskKey1 = datastore.allocateId(keyFactory.newKey());
        var taskKey2 = datastore.allocateId(keyFactory.newKey());

        Entity task1 = Entity.newBuilder(taskKey1).set("name", "Damian").set("smt", "ZZZ").build();

        Entity task2 = Entity.newBuilder(taskKey2).set("name", 123).set("smt", "ZZZ").build();

        datastore.put(task1, task2);

        Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").setFilter(StructuredQuery.CompositeFilter.and(StructuredQuery.PropertyFilter.eq("name", "Damian"))).build();

        QueryResults<Entity> tasks = datastore.run(query);

        Assertions.assertEquals("Damian", tasks.next().getString("name"));
    }
}
