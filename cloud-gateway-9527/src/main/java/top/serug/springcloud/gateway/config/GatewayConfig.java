package top.serug.springcloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.serug.springcloud.gateway.filter.ExampleGatewayFilterFactory;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/19  22:11
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_baidu_guoneixinwen",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

    @Bean
    public ExampleGatewayFilterFactory exampleGatewayFilterFactory(){
        return new ExampleGatewayFilterFactory();
    }

}
