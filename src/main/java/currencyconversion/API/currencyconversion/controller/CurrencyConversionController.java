package currencyconversion.API.currencyconversion.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import currencyconversion.API.currencyconversion.integration.CurrencyConversionApiClient;
import currencyconversion.API.currencyconversion.model.CurrencyConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency-converter")
public class CurrencyConversionController {

    private final CurrencyConversionApiClient currencyConversionApiClient;
        //properties to save time
    private final String BASE_URL = "https://v6.exchangerate-api.com/v6";



    @GetMapping("/pair/from/{from}/to/{to}/amount/{amount}")           //part of the link that matters to change
    public ResponseEntity<?> conversion(@PathVariable String from,
                                                        @PathVariable String to,
                                                        @PathVariable double amount) throws JsonProcessingException, HttpClientErrorException {


        return currencyConversionApiClient.conversion(from,to,amount);
    }
}
