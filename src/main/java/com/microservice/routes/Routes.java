package com.microservice.routes;


import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

@Configuration
public class Routes {

//  The Routes class in the API Gateway uses Spring Cloud Gateway's programmatic routing approach.
//  Instead of using annotations like @RequestMapping or @GetMapping, it uses RouterFunction to define routes.

   @Bean
//    A predicate is a condition a request predicate is a conditio nthat needs to be met to follow this route
public RouterFunction<ServerResponse> ProductServiceRoute(){
   return GatewayRouterFunctions.route("productService-route")
            .route(RequestPredicates.path("/UserData/AddProduct"), HandlerFunctions.http("http://localhost:8080/UserData/AddProduct"))
           .route(RequestPredicates.path("/UserData/AddProduct"), HandlerFunctions.http("http://localhost:8080/UserData/AddProduct"))
           .route(RequestPredicates.path("/UserData/Stock"), HandlerFunctions.http("http://localhost:8080/UserData/Stock"))
           .build();
}


   @Bean
//    A predicate is a condition a request predicate is a conditio nthat needs to be met to follow this route
   public RouterFunction<ServerResponse> OrderServiceRoute(){
      return GatewayRouterFunctions.route("productService-route2")
              .route(RequestPredicates.path("/UserData/Stripe/Authenticate"), HandlerFunctions.http("http://localhost:8081/UserData/Stripe/Authenticate"))
              .route(RequestPredicates.path("/UserData/OrderDetails"), HandlerFunctions.http("http://localhost:8081/UserData/OrderDetails"))
              .build();
   }




}
