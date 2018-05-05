package org.liveangel.A.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by sjiang3 on 6/7/17.
 */
@Component
public class ContextStartedEventHandler implements ApplicationListener<ContextRefreshedEvent>  {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContextStartedEventHandler.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        LOGGER.info("Application ContextStartedEventHandler");
        LOGGER.info("我的父容器为：" + event.getApplicationContext().getParent());
        LOGGER.info("容器被初始化或者刷新");

    }
}