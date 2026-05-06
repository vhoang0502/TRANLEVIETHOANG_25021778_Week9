package bank_system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp khởi chạy chính của hệ thống ngân hàng.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    /**
     * Hàm main entry point.
     *
     * @param args Tham số dòng lệnh
     */
    public static void main(String[] args) {
        logger.info("He thong Bank System dang khoi dong...");

        Bank bank = new Bank();
        // Bạn có thể thêm vài dòng code test nhẹ ở đây nếu muốn
        System.out.println("Build Success - Project is ready!");
    }
}