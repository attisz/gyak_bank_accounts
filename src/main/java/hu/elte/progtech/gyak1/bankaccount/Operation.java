package hu.elte.progtech.gyak1.bankaccount;

public enum Operation {
  DEPOSIT, WITHDRAW;

  @Override
  public String toString() {
    return switch (this) {
      case DEPOSIT -> "Deposit";
      case WITHDRAW -> "Withdraw";
    };
  }
}
