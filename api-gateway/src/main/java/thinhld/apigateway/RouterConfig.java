package thinhld.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thinhld.apigateway.service.UserService;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {
    @Autowired
    private UserService userService;

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/health"), request -> ServerResponse.ok().body(Mono.just("Service is up and running!"), String.class))
                .andRoute(GET("/users/get-all"), request -> ServerResponse.ok().body(userService.getAllUsers(), Flux.class))
                .andRoute(GET("/error"), request -> ServerResponse.status(500).body(Mono.just("Internal Server Error"), String.class));
    }
}
