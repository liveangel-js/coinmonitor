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


    @Autowired
    private StockRestApi stockRestApi;

    @Autowired
    private MailService mailService;


    @Scheduled(fixedRateString = "1000000000")
    public void test(){

        String result = stockRestApi.ticker("btc_usdt");
        try {
            mailService.sendSimpleMail("448576871@qq.com", "比特币价格", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(result);

    }


}
