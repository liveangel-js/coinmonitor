package org.liveangel.A;

import org.liveangel.A.stock.impl.StockRestApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liveangel on 2018-5-2.
 */
@Component
public class PriceCraw {
    private Logger logger = LoggerFactory.getLogger(PriceCraw.class);

    private String secret_key;

    private String api_key;

    private String url_prex;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockRestApi stockRestApi;


    @Scheduled(fixedRateString = "1000")
    public void test(){

        String result = stockRestApi.ticker("btc_usdt");
        logger.info(result);

    }


}
