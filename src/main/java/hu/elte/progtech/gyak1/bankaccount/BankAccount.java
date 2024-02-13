package hu.elte.progtech.gyak1.bankaccount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BankAccount {

  private List<Transaction> transactions = new ArrayList<>();

  public int getBalance() {
    return Calculations.actualBalance(transactions);
  }

  public void deposit(int amount) {
    transactions.add(Transaction.deposit(amount));
  }

  public void withdraw(int amount) {
    if (getBalance() < amount) {
      throw new IllegalStateException();
    }
    transactions.add(Transaction.withdraw(amount));
  }

  public String getTransactionHistory() {
    return IntStream.range(0, transactions.size())
        .mapToObj(i -> String.format("%s. %s\n", i + 1, transactions.get(i)))
        .collect(Collectors.joining());
  }
}
