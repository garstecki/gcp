package dev.garstecki.gcp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GcpController {
    private final UserRepository repository;

    GcpController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    String main() {
        return "GCP V4";
    }

    @PostMapping("/set/{name}")
    void set(@PathVariable String name) {
        this.repository.save(new User(name));
    }

    @GetMapping("/all")
    Iterable<User> all() {
        return this.repository.findAll();
    }
}
