package bank_system;

/**
 * Ngoại lệ chung cho các lỗi liên quan đến nghiệp vụ hệ thống ngân hàng.
 */
public class BankException extends Exception {

    /**
     * Khởi tạo ngoại lệ với thông báo lỗi.
     *
     * @param message Thông báo lỗi chi tiết
     */
    public BankException(String message) {
        super(message);
    }
}