package org.liveangel.A;

import org.liveangel.A.mail.MailService;
import org.liveangel.A.stock.impl.StockRestApi;
import org.liveangel.A.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

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

        Map<String, Object> price = JacksonUtils.fromJson(result, Map.class);
        String nowPrice = (String)((Map<String, Object>)price.get("ticker")).get("buy");

        try {
            mailService.sendSimpleMail("243651117@qq.com", "BTC Price " + nowPrice, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(result);

    }


}
