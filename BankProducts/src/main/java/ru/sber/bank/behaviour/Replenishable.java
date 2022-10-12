package ru.sber.bank.behaviour;

import java.math.BigDecimal;

/**
 * Интерфейс пополнения баланса
 */
public interface Replenishable {
  /**
   * Пополнение баланса
   */
  BigDecimal replenish(BigDecimal amount);
}
