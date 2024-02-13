package hu.elte.progtech.gyak1.bankaccount;

import java.util.List;

public class Calculations {
  public static int actualBalance(List<Transaction> transactions) {
    return transactions.stream()
        .mapToInt(transaction ->
            switch (transaction.operation()) {
              case DEPOSIT -> transaction.amount();
              case WITHDRAW -> (-1) * transaction.amount();
            })
        .sum();
  }
}
