package org.liveangel.A;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by sjiang3 on 6/7/17.
 */
@Component
public class InstantiationTracingBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent>  {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("Application ContextRefreshedEvent");
        LOGGER.info("我的父容器为：" + event.getApplicationContext().getParent());
        LOGGER.info("初始化时我被调用了。");

    }
}