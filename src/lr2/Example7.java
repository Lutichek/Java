package lr2;

public class Example7 {
    public interface BankAccount {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
    }

    public static class MyAccount implements BankAccount {
        private double balance;

        public MyAccount(double balance) {
            this.balance = balance;
        }

        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        @Override
        public void withdraw(double amount) {
            if (amount > 0) {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient funds");
                }
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        @Override
        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        // Создаем объект банковского счета
        MyAccount account = new MyAccount(1000);
        System.out.println("Initial balance: " + account.getBalance());

        // Вносим депозит
        account.deposit(800);
        System.out.println("Balance after deposit: " + account.getBalance());

        // Пытаемся внести отрицательный депозит
        account.deposit(-100);

        // Снимаем деньги
        account.withdraw(500);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Пытаемся снять слишком много денег
        account.withdraw(1500);

        // Пытаемся снять отрицательную сумму
        account.withdraw(-200);
    }
}
