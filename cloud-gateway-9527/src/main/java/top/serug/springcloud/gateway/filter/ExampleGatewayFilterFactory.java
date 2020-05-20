package top.serug.springcloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/20  00:38
 */
@Slf4j
@Component
public class ExampleGatewayFilterFactory extends AbstractGatewayFilterFactory<ExampleGatewayFilterFactory.Config> {

    /**
     * 定义可以再yaml中声明的属性变量
     */
    private static final String TYPE = "type";
    private static final String OP = "op";

    /**
     * constructor
     */
    public ExampleGatewayFilterFactory(){
        // 这里需要将自定义的config传过去，否则会报告ClassCastException
        super(Config.class);
    }


    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(TYPE, OP);
    }

    //@Override
    //public GatewayFilter apply(Config config) {
    //    return ((exchange, chain) -> {
    //        boolean root = "root".equals(config.getOp());
    //        if (root){
    //            log.info("************ 进入网关路由过滤器 GatewayFilter root ***************");
    //        }
    //        else {
    //            log.info("************ 进入网关路由过滤器 GatewayFilter customer ***************");
    //        }
    //        // 在then方法里的，相当于aop中的后置通知
    //        return chain.filter(exchange).then(Mono.fromRunnable(()->{
    //            // do something
    //        }));
    //    });
    //}


    @Override
    public GatewayFilter apply(Config config) {
        return new InnerFilter(config);
    }

    /**
     * 创建一个内部类，来实现2个接口，指定顺序
     */
    private class InnerFilter implements GatewayFilter, Ordered {

        private Config config;

        InnerFilter(Config config) {
            this.config = config;
        }

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            System.out.println("  pre 自定义过滤器工厂 AAAA  " + this.getClass().getSimpleName());
            boolean root = "root".equals(config.getOp());
            if (root) {
                System.out.println("  is root ");
            } else {
                System.out.println("  is no root ");
            }
            // 在then方法里的，相当于aop中的后置通知
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("  post 自定义过滤器工厂 AAAA " + this.getClass().getSimpleName());
            }));
        }

        @Override
        public int getOrder() {
            return -100;
        }
    }



    /**
     * 自定义的config类，用来设置传入的参数
     */
    public static class Config {

        /**
         * 过滤类型
         */
        private String type;

        /**
         * 操作
         */
        private String op;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }
    }
}
