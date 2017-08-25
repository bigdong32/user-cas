package com.wds.app.user.config;

import com.wds.app.user.base.InitJobBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * quartz配置
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-24 17:44
 */
@Configuration
public class QuartzConfig {

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        return new SchedulerFactoryBean();
    }

    @Bean
    public InitJobBean initJobBeanPostProcessor(){
        return new InitJobBean();
    }
}
