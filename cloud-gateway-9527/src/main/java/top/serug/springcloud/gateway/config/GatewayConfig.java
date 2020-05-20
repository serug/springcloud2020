package top.serug.springcloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/19  22:11
 */
@Configuration
public class GatewayConfig {

    /**
     * @Description: 自定义路由
     * @Param:
     * @return:
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_baidu_guoneixinwen",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

    /**
     * @Description: 注入自定义的网关路由过滤器，目前使用的是在ExampleGatewayFilterFactory这个类添加@Component注解的方式注入bean
     * @Param:
     * @return:
     */
    //@Bean
    //public ExampleGatewayFilterFactory exampleGatewayFilterFactory(){
    //    return new ExampleGatewayFilterFactory();
    //}

}
