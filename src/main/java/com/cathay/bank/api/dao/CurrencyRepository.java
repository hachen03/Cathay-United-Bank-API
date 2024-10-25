package com.cathay.bank.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cathay.bank.api.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    
}
