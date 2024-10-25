package com.cathay.bank.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cathay.bank.api.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    // 可根據幣別代碼查詢
    Currency findByCode(String code);
}
