package bank_system;

import java.util.Locale;

/**
 * Ngoại lệ được ném ra khi số dư tài khoản không đủ để thực hiện giao dịch.
 */
public class InsufficientFundsException extends BankException {

    /**
     * Khởi tạo ngoại lệ báo lỗi thiếu số dư.
     *
     * @param amount Số tiền yêu cầu rút gây ra lỗi
     */
    public InsufficientFundsException(double amount) {
        // Tối ưu: Đưa toàn bộ câu vào String.format thay vì cộng chuỗi bên ngoài
        super(String.format(Locale.US, "Số dư tài khoản không đủ $%.2f để thực hiện giao dịch", amount));
    }
}