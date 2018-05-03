package org.liveangel.A.config;

import org.liveangel.A.network.LoggingRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public RestTemplate createNormalRestTemplate(){
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
//        restTemplate.getInterceptors().add(new LoggingRequestInterceptor());
        restTemplate.setInterceptors(setInterceptors());
        return restTemplate;
    }

    private static List<ClientHttpRequestInterceptor> setInterceptors(ClientHttpRequestInterceptor... additionalInterceptors) {
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();

        if (additionalInterceptors.length > 0) {
            interceptors.addAll(Arrays.asList(additionalInterceptors));
        }

        interceptors.add(new LoggingRequestInterceptor());
        return interceptors;
    }

}
