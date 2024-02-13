package hu.elte.progtech.gyak1.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BankAccountTest {

  BankAccount underTest = new BankAccount();

  @Test
  void startingBalanceIsZero() {
    assertEquals(underTest.getBalance(), 0);
  }

  @Test
  void deposit() {
    assertEquals(underTest.getBalance(), 0);

    underTest.deposit(100);
    assertEquals(underTest.getBalance(), 100);

    assertEquals(underTest.getTransactionHistory(), """
        1. Deposit: 100
        """);
  }

  @Test
  void withdrawal() {
    underTest.deposit(100);
    assertEquals(underTest.getBalance(), 100);

    underTest.withdraw(50);
    assertEquals(underTest.getBalance(), 50);

    assertEquals(underTest.getTransactionHistory(), """
        1. Deposit: 100
        2. Withdraw: 50
        """);
  }

  @Test
  void cannotGetNegativeBalance() {
    underTest.deposit(100);

    assertThrows(IllegalStateException.class, () -> underTest.withdraw(101));
    assertEquals(underTest.getBalance(), 100);
  }
}
