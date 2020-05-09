package top.serug.myribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: serug
 * @Date: 2020/5/9  14:35
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
