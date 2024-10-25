package com.cathay.bank.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathay.bank.api.dao.CurrencyRepository;
import com.cathay.bank.api.model.Currency;

@Service
public class CurrencyService {
	
	@Autowired
    private CurrencyRepository currencyRepository;
	
	
    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    
    public Currency create(Currency currency) {
        return currencyRepository.save(currency);
    }

    
    public Optional<Currency> findById(Long id) {
        return currencyRepository.findById(id);
    }
    
   
    public Currency update(Long id, Currency currencyDetails) {
        Currency currency = currencyRepository.findById(id).orElseThrow(() -> new RuntimeException("Currency not found"));
        currency.setCode(currencyDetails.getCode());
        currency.setName(currencyDetails.getName());
        return currencyRepository.save(currency);
    }

   
    public void delete(Long id) {
        currencyRepository.deleteById(id);
    }

}
