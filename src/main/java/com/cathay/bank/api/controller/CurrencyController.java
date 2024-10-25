package com.cathay.bank.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cathay.bank.api.model.Currency;
import com.cathay.bank.api.service.CurrencyService;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {
	
	@Autowired
    private CurrencyService currencyService;
	
    // 查詢所有幣別
    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.findAll();
    }
	
	
    @PostMapping
    public Currency createCurrency(@RequestBody Currency currency) {
        return currencyService.create(currency);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Currency> getCurrencyById(@PathVariable Long id) {
        return currencyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Currency> updateCurrency(@PathVariable Long id, @RequestBody Currency currencyDetails) {
        return ResponseEntity.ok(currencyService.update(id, currencyDetails));
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
        currencyService.delete(id);
        return ResponseEntity.noContent().build();
    }
	
	

}
