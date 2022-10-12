package ru.sber.bank.behaviour;

import java.math.BigDecimal;

/**
 * Интерфейс запроса баланса
 */
public interface Requestable {
  /**
   * Запрос баланса
   */
  BigDecimal balanceRequest();
}