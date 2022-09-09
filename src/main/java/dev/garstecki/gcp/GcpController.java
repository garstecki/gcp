package dev.garstecki.gcp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GcpController {
    @GetMapping("/")
    String main() {
        return "GCP V4";
    }
}
