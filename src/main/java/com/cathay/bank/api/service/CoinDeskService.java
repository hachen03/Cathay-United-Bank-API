package com.cathay.bank.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cathay.bank.api.dto.CoinDeskResponseDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CoinDeskService {

    private static final String COINDESK_API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
    private final RestTemplate restTemplate;

    public CoinDeskService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CoinDeskResponseDTO getCoinDeskData() {
        Map<String, Object> response = restTemplate.getForObject(COINDESK_API_URL, Map.class);

        CoinDeskResponseDTO result = new CoinDeskResponseDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formattedUpdateTime = sdf.format(new Date());
        result.setUpdatedTime(formattedUpdateTime);

        List<CoinDeskResponseDTO.CurrencyInfo> currencyInfoList = new ArrayList<>();
        Map<String, Object> bpi = (Map<String, Object>) response.get("bpi");

        bpi.forEach((code, data) -> {
            Map<String, Object> currencyData = (Map<String, Object>) data;
            CoinDeskResponseDTO.CurrencyInfo currencyInfo = new CoinDeskResponseDTO.CurrencyInfo();
            currencyInfo.setCode((String) currencyData.get("code"));
            currencyInfo.setName(getCurrencyName((String) currencyData.get("code")));
            currencyInfo.setRate((String) currencyData.get("rate"));
            currencyInfoList.add(currencyInfo);
        });

        result.setCurrencyInfo(currencyInfoList);
        return result;
    }

    private String getCurrencyName(String code) {
        switch (code) {
            case "USD": return "美元";
            case "GBP": return "英鎊";
            case "EUR": return "歐元";
            default: return code;
        }
    }
}
