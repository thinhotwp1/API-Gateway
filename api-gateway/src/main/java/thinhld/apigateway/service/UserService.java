package thinhld.apigateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thinhld.apigateway.entity.User;
import thinhld.apigateway.repository.UserRepository;

import java.util.Random;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> createUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("test");
        user.setAge(new Random().nextInt(100));
        return userRepository.save(user);
    }
}