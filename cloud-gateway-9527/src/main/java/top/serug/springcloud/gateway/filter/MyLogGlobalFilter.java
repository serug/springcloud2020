package top.serug.springcloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description:
 *      这里的order不能使用@order 的注解
 *      在fitler里面的是pre类型，会在路由前执行，在then里面的是post类型会在路由后执行
 *      order 的数值越小pre越先执行，post越后执行
 * @Author: serug
 * @Date: 2020/5/19  22:36
 */
@Component
@Slf4j
public class MyLogGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //log.info("this is a pre filter");
        //return chain.filter(exchange).then(Mono.fromRunnable(() -> {
        //    log.info("this is a post filter");
        //}));

        //log.info("===============进入全局过滤器 MyLogGlobalFilter，时间为"+ new Date());
        //
        //String name = exchange.getRequest().getQueryParams().getFirst("name");
        //
        //if(name == null){
        //    log.info("*************用户名不能为空，非法用户**************");
        //    exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
        //    return exchange.getResponse().setComplete();
        //}
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
