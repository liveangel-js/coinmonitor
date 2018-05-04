package org.liveangel.A.config;

import org.liveangel.A.ProxyConfig;
import org.liveangel.A.network.LoggingRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.SocketAddress;
import java.util.*;
import java.net.Proxy;
import java.net.InetSocketAddress;

@Configuration
@ConditionalOnClass(ProxyConfig.class)
public class Config {
    @Value("${rest.ReadTimeout}")
    private int readTimeout;
    @Value("${rest.ConnectTimeout}")
    private int connectionTimeout;

    @Autowired
    private ProxyConfig proxyConfig;

    @Bean
    public RestTemplate createNormalRestTemplate(){
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(readTimeout);
        requestFactory.setConnectTimeout(connectionTimeout);
//        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
//                HttpClientBuilder.create().build());
        if(proxyConfig.getEnabled()){
            Properties props = System.getProperties();
//            props.put("http.proxyHost", "127.0.0.1");
//
//            props.put("http.proxyPort", "8118");
            SocketAddress address = new InetSocketAddress(proxyConfig.getHost(), proxyConfig.getPort());
            Proxy proxy = new Proxy(Proxy.Type.HTTP, address);
            requestFactory.setProxy(proxy);
        }



        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(requestFactory));
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

    @Bean
    public HttpHeaders createHeader(){
        HttpHeaders headers = new HttpHeaders();

        headers.set("Accept", "text/html, */*; q=0.01");
        headers.set("Accept-Encoding", "gzip, deflate, sdch");
        headers.set("Accept-Language", "zh-CN,zh;q=0.8");
        headers.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:46.0) Gecko/20100101 Firefox/46.0");
        headers.setContentType(MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8"));
        return headers;
    }

}
