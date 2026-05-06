package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SavingsAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);
    private static final double MAX_WITHDRAWAL_AMOUNT = 1000.0;
    private static final double MIN_BALANCE_REQUIRED = 5000.0;

    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction transaction = new Transaction(
                    Transaction.TYPE_DEPOSIT_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(transaction);
            logger.info("[SAVINGS] Nạp {} thành công vào tài khoản {}", amount, getAccountNumber());
        } catch (BankException e) {
            logger.warn("Giao dịch nạp tiền thất bại: {}", e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            if (amount > MAX_WITHDRAWAL_AMOUNT) {
                throw new InvalidFundingAmountException(amount);
            }
            if (initialBalance - amount < MIN_BALANCE_REQUIRED) {
                throw new InsufficientFundsException(amount);
            }

            doWithdrawing(amount);
            double finalBalance = getBalance();

            Transaction transaction = new Transaction(
                    Transaction.TYPE_WITHDRAW_SAVINGS, amount, initialBalance, finalBalance);
            addTransaction(transaction);
            logger.info("[SAVINGS] Rút {} thành công. Số dư còn: {}", amount, finalBalance);
        } catch (BankException e) {
            logger.warn("Giao dịch rút tiền thất bại: {}", e.getMessage());
        }
    }
}