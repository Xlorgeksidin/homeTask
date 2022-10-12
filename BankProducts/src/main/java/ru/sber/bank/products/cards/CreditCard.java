package ru.sber.bank.products.cards;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Кредитная карта
 */
@Getter
@Setter
public class CreditCard extends AbstractCard{

  /**
   * Процентная ставка
   */
  private BigDecimal interestRate;

  /**
   * Запрос задолженности
   */
  public BigDecimal debtRequest() {
    return null;
  }
}
