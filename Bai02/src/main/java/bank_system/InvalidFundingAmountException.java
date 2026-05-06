package bank_system;

import java.util.Locale;

/**
 * Ngoại lệ được ném ra khi số tiền giao dịch không hợp lệ (âm, bằng 0, hoặc vượt hạn mức).
 */
public class InvalidFundingAmountException extends BankException {

    /**
     * Khởi tạo ngoại lệ báo lỗi số tiền không hợp lệ.
     *
     * @param amount Số tiền giao dịch gây ra lỗi
     */
    public InvalidFundingAmountException(double amount) {
        // Tối ưu tương tự: Gộp chung format
        super(String.format(Locale.US, "Số tiền không hợp lệ: $%.2f", amount));
    }
}