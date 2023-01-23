package currencyconversion.API.currencyconversion.config;

import currencyconversion.API.currencyconversion.integration.CurrencyConversionApiClient;
import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Collections;

@Configuration
@EnableFeignClients(clients = { CurrencyConversionApiClient.class})
public class Config {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * To support text/html responses.
     */
    @Bean
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        return converter;
    }

    @Bean
    RequestInterceptor currencyConverterApiInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                requestTemplate.header("headerName1",Collections.singletonList("value1"));
            }
        };
    }

//    twitter.consumerKey=yOP9lyCYtULoQIwQWEF46QJLev
//    twitter.consumerSecret=1XtR2l9KKTchKqq9BfKYStcBsyyIjqyatTwB1nge8gpawKm8fn
//    twitter.accessToken=AAAAAAAAAAAAAAAAAAAAAAigjAEAAAAA3e7uR0j0tGp9vXmW0v3ow0wAuJc%3D2PYQhboe0zCL4mtF5fJclOnJVumoBq35V7qdoob96idDHLCTt8
}
