package ru.sber.bank.products.cards;

import lombok.Getter;
import lombok.Setter;
import ru.sber.bank.behaviour.Debitable;
import ru.sber.bank.behaviour.Replenishable;
import ru.sber.bank.behaviour.Requestable;
import ru.sber.bank.products.BankProduct;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Карта
 */
@Getter
@Setter
public abstract class AbstractCard extends BankProduct implements Replenishable, Debitable, Requestable {
  private Currency currency;
  private BigDecimal balance = BigDecimal.valueOf(0.00);
  
  @Override
  public BigDecimal debit(BigDecimal amount) {
    BigDecimal result = getBalance().subtract(amount);
    setBalance(result);
    return result;
  }

  @Override
  public BigDecimal replenish(BigDecimal amount) {
    BigDecimal result = getBalance().add(amount);
    setBalance(result);
    return result;
  }

  @Override
  public BigDecimal balanceRequest() {
    return getBalance();
  }
}
