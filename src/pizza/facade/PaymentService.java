package pizza.facade;

public class PaymentService {
    private int balance;

    public PaymentService(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        balance = initialBalance;
    }

    public void charge(int amount) {
        requirePositiveAmount(amount);
        if (amount > balance) {
            throw new IllegalStateException("Insufficient customer balance.");
        }
        balance -= amount;
    }

    public void refund(int amount) {
        requirePositiveAmount(amount);
        balance = Math.addExact(balance, amount);
    }

    public int getBalance() {
        return balance;
    }

    private void requirePositiveAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }
    }
}
