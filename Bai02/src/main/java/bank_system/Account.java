package bank_system;
import java.util.ArrayList; // Vi phạm: Wildcard import (nên import cụ thể List, ArrayList)
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp này đại diện cho tài khoản nhưng viết Javadoc rất sơ sài và sai format
 */
public abstract class Account {
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    // Vi phạm: Đặt tên hằng số không đúng chuẩn (phải là UPPER_SNAKE_CASE)
    public static final String CHECKING_TYPE = "CHECKING";
    public static final String SAVINGS_TYPE = "SAVINGS";

    // Vi phạm: Tên biến instance bắt đầu bằng dấu gạch dưới hoặc quá ngắn, không rõ nghĩa
    private long accountNumber;
    private double balance;
    protected List<Transaction> transactionList;

    // Vi phạm: Thụt lề (Indentation) không đồng nhất, không dùng 2 spaces theo chuẩn Google
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = new ArrayList<>();
    }

    // Vi phạm: Viết hàm trên một dòng, thiếu khoảng trắng giữa các toán tử/ngoặc
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

        public void setTransactionList(List<Transaction> transactionList) {
            // Vi phạm: Thiếu dấu ngoặc nhọn cho câu lệnh if (mặc dù vẫn chạy đúng)
            if (transactionList == null) {
                this.transactionList = new ArrayList<>();
            } else {
                this.transactionList = transactionList;
            }
        }

        // Vi phạm: Thiếu Javadoc cho phương thức public
    /**
     * Nạp tiền vào tài khoản.
     *
     * @param amount Số tiền cần nạp
     */
    public abstract void deposit(double amount);

    /**
     * Rút tiền khỏi tài khoản.
     *
     * @param amount Số tiền cần rút
     */
    public abstract void withdraw(double amount);

        protected void doDepositing(double amount) throws BankException {
            // Vi phạm: Whitespace quanh toán tử (amount<=0)
            if (amount <= 0) {
                throw new InvalidFundingAmountException(amount);
            }
            balance += amount;
        }

        protected void doWithdrawing(double amount) throws BankException {
            // Vi phạm: Tung ra Exception quá chung chung thay vì Exception cụ thể
            if (amount <= 0) {
                throw new InvalidFundingAmountException(amount);
            }
            if (amount > balance) {
                throw new InsufficientFundsException(amount);
            }
            balance -= amount;
        }

        public void addTransaction(Transaction transaction) {
            if (transaction != null) {
                transactionList.add(transaction);
            }
        }

        public String getTransactionHistory() {
            // Vi phạm: Dòng code quá dài (Line length) và dùng cộng chuỗi trong vòng lặp (Performance smell)
            StringBuilder sb = new StringBuilder();
            sb.append("Lịch sử giao dịch của tài khoản ").append(accountNumber).append(":\n");
            for (int i = 0; i < transactionList.size(); i++) {
                sb.append(transactionList.get(i).getTransactionSummary());
                if (i < transactionList.size() - 1) {
                    sb.append("\n");
                }
            }
            logger.debug("Đã xuất lịch sử cho tài khoản: {}", accountNumber);
            return sb.toString();
        }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Account)) {
            return false;
        }
        Account other = (Account) obj;
        return this.accountNumber == other.accountNumber;
    }

    @Override
    public int hashCode() {
        return (int) (accountNumber ^ (accountNumber >>> 32));
    }
    }