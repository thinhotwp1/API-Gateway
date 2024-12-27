package thinhld.apigateway.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import thinhld.apigateway.entity.User;

public interface UserRepository extends ReactiveCrudRepository<User, String> {}