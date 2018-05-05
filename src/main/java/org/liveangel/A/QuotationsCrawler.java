package org.liveangel.A;

import org.liveangel.A.domain.TickerTape;
import org.liveangel.A.mail.MailService;
import org.liveangel.A.stock.impl.StockRestApi;
import org.liveangel.A.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liveangel on 2018-5-2.
 */
@Component
public class QuotationsCrawler {
    private Logger logger = LoggerFactory.getLogger(QuotationsCrawler.class);


    @Autowired
    private StockRestApi stockRestApi;

    @Autowired
    private MailService mailService;

    @Scheduled(fixedRateString = "1000000000")
    public void pollingTicker(){
        TickerTape tickerTape = stockRestApi.ticker("btc_usdt");
        String nowPrice = tickerTape.getTicker().getBuy();

        try {
            mailService.sendSimpleMail("448576871@qq.com", "BTC Price " + nowPrice, JacksonUtils.toJosn(tickerTape));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("{}",JacksonUtils.toJosn(tickerTape));
    }

}
