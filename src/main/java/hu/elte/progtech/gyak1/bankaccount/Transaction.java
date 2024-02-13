package hu.elte.progtech.gyak1.bankaccount;

public record Transaction(Operation operation, int amount) {

  public static Transaction deposit(int amount) {
    return new Transaction(Operation.DEPOSIT, amount);
  }

  public static Transaction withdraw(int amount) {
    return new Transaction(Operation.WITHDRAW, amount);
  }

  @Override
  public String toString() {
    return String.format("%s: %s", operation, amount);
  }
}
