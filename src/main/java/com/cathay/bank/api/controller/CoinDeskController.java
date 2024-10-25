package com.cathay.bank.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.bank.api.dto.CoinDeskResponseDTO;
import com.cathay.bank.api.service.CoinDeskService;

@RestController
@RequestMapping("/api")
public class CoinDeskController {

    private final CoinDeskService coinDeskService;

    public CoinDeskController(CoinDeskService coinDeskService) {
        this.coinDeskService = coinDeskService;
    }

    @GetMapping("/coindesk")
    public CoinDeskResponseDTO getCoinDeskData() {
        return coinDeskService.getCoinDeskData();
    }
}
