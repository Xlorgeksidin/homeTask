package ru.sber.bank.behaviour;

import java.math.BigDecimal;

/**
 * Интерфейс списания средств
 */
public interface Debitable {
  /**
   * Списание средств
   */
  BigDecimal debit(BigDecimal amount);
}
