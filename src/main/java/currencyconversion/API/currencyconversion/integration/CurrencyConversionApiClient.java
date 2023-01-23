package currencyconversion.API.currencyconversion.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import currencyconversion.API.currencyconversion.config.Config;
import currencyconversion.API.currencyconversion.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@FeignClient(name = "${feign.currency-conversion-api.name:currency-converter-api}",
        url = "${feign.currency-converter-api.url:https://v6.exchangerate-api.com/v6/0afb8998c3ab1a5e8269a4c0}",
        configuration = Config.class)
public interface CurrencyConversionApiClient {

    final String MY_API_KEY = "0afb8998c3ab1a5e8269a4c0";

    @GetMapping("/pair/{from}/{to}/{amount}")           //part of the link that matters to change
    ResponseEntity<?> conversion(@PathVariable("from") String from,
                                         @PathVariable("to") String to,
                                         @PathVariable("amount") double amount) throws JsonProcessingException, HttpClientErrorException;

}
