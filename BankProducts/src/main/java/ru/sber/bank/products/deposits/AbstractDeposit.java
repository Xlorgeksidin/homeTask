package ru.sber.bank.products.deposits;

import lombok.Getter;
import lombok.Setter;
import ru.sber.bank.behaviour.Closeable;
import ru.sber.bank.behaviour.Replenishable;
import ru.sber.bank.behaviour.Requestable;
import ru.sber.bank.products.BankProduct;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Вклад
 */
@Getter
@Setter
public abstract class AbstractDeposit extends BankProduct implements Replenishable, Closeable, Requestable {
  private Currency currency;
  private BigDecimal balance = BigDecimal.valueOf(0.00);
  
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
  
  @Override
  public void close() {
    System.out.println("Вклад закрыт");
  }
}
