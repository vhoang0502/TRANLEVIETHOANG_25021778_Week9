package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckingAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);

    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        double initialBalance = getBalance();
        try {
            doDepositing(amount);
            double finalBalance = getBalance();
            Transaction transaction = new Transaction(
                    Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance, finalBalance);
            addTransaction(transaction);
            logger.info("[CHECKING] Nạp {} thành công vào tài khoản {}", amount, getAccountNumber());
        } catch (BankException e) {
            logger.warn("Giao dịch nạp tiền thất bại: {}", e.getMessage());
        }
    }

    @Override
    public void withdraw(double amount) {
        double initialBalance = getBalance();
        try {
            doWithdrawing(amount);
            double finalBalance = getBalance();
            Transaction transaction = new Transaction(
                    Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance, finalBalance);
            addTransaction(transaction);
            logger.info("[CHECKING] Rút {} thành công từ tài khoản {}", amount, getAccountNumber());
        } catch (BankException e) {
            logger.warn("Giao dịch rút tiền thất bại: {}", e.getMessage());
        }
    }
}