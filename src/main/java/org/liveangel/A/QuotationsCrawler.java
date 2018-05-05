package org.liveangel.A;

import org.liveangel.A.domain.Subscriber;
import org.liveangel.A.domain.TickerTape;
import org.liveangel.A.mail.MailService;
import org.liveangel.A.stock.impl.StockRestApi;
import org.liveangel.A.utils.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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

    private List<Subscriber> subscriberList;
    @PostConstruct
    private void init(){
        subscriberList = new ArrayList<>();
        subscriberList.add(new Subscriber("448576871@qq.com"));

    }

    @Scheduled(fixedRateString = "1000000000")
    public void pollingTicker(){
        TickerTape tickerTape = stockRestApi.ticker("btc_usdt");
        String nowPrice = tickerTape.getTicker().getBuy();
        for(Subscriber subscriber: subscriberList){
            mailService.sendSimpleMail(subscriber.getEmail(), "BTC Price " + nowPrice, JacksonUtils.toJosn(tickerTape));
        }

        logger.info("{}",JacksonUtils.toJosn(tickerTape));
    }

}
