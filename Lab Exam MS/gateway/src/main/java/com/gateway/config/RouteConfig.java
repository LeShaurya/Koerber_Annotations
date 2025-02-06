package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator productAppRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/company/employee/**")
                        .filters( f -> f.rewritePath("/company/employee/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("service-down")
                                        .setFallbackUri("forward:/contactSupport")))
                        .uri("lb://EMP-APP"))
                .route(p -> p
                        .path("/company/department/**")
                        .filters( f -> f.rewritePath("/company/department/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(config -> config.setName("service-down")
                                        .setFallbackUri("forward:/contactSupport")))
                        .uri("lb://DEPT-APP"))
                .build();
    }
}

