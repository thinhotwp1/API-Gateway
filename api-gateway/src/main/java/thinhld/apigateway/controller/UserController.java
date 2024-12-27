package thinhld.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thinhld.apigateway.entity.User;
import thinhld.apigateway.service.UserService;

import java.time.Duration;
import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
//        return Flux.fromIterable(Arrays.asList("Spring", "WebFlux", "Demo")).delayElements(Duration.ofMillis(500));
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/create-user")
    public Mono<User> createUser() {
        return userService.createUser();
    }

    @GetMapping(value = "/sse", produces = "text/event-stream")
    public Flux<String> streamData() {
        return Flux.interval(Duration.ofSeconds(1)).map(sequence -> "Data Stream: " + sequence);
    }
}