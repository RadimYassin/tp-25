package io.radimyassine.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * API Gateway Service - Centralized Entry Point
 * 
 * <p>
 * This service acts as the single entry point for all client requests in the
 * Vehicle Management
 * Platform microservices architecture. It provides intelligent routing, load
 * balancing, and
 * service discovery integration using Spring Cloud Gateway and Consul.
 * </p>
 * 
 * <h2>Key Responsibilities:</h2>
 * <ul>
 * <li>Route incoming requests to appropriate microservices</li>
 * <li>Service discovery integration with Consul</li>
 * <li>Load balancing across service instances</li>
 * <li>Centralized cross-cutting concerns (logging, security, monitoring)</li>
 * </ul>
 * 
 * <h2>Key Technologies:</h2>
 * <ul>
 * <li>Spring Boot 3.1.5 - Application framework</li>
 * <li>Spring Cloud Gateway - API Gateway implementation</li>
 * <li>Spring Cloud Consul Discovery - Service registration and discovery</li>
 * <li>Spring Actuator - Health checks and monitoring</li>
 * </ul>
 * 
 * <h2>Routing Configuration:</h2>
 * <p>
 * The gateway uses dynamic service discovery to automatically route requests to
 * registered
 * services. Service names are resolved through Consul, enabling automatic load
 * balancing and
 * failover capabilities.
 * </p>
 * 
 * <h3>Example Routes:</h3>
 * <ul>
 * <li>/client-service/** → Client Service (port 8088)</li>
 * <li>/vehicle-management-service/** → Vehicle Management Service (port
 * 8089)</li>
 * </ul>
 * 
 * @author Radim Yassine
 * @version 1.0.0
 * @since 2026-01-01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	/*
	 * @Bean
	 * public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	 * return builder.routes()
	 * .route("client_route", r -> r.path("/clients/**")
	 * .uri("lb://client-service"))
	 * .route("voiture_route", r -> r.path("/voitures/**")
	 * .uri("lb://voiture-service"))
	 * .build();
	 * }
	 */
}
