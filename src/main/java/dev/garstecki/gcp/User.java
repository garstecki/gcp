package dev.garstecki.gcp;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Entity(name = "user")
class User {
    @Id
    public Long id;
    public String name;

    public User(String name) {
        this.name = name;
    }
}
