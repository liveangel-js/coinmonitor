package org.liveangel.A;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liveangel on 2018-5-2.
 */
@Component
public class PriceCraw {
    private Logger logger = LoggerFactory.getLogger(PriceCraw.class);

    @Scheduled(fixedRateString = "1000")
    public void test(){

        logger.info("dd");

    }
}
