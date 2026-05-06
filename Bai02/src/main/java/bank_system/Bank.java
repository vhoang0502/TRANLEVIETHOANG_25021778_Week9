package bank_system;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Bank {
    // Vi phạm: Tên biến không rõ nghĩa, viết tắt sai chuẩn camelCase
    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private static final String ID_REGEX = "\\d{9}";

    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    // Vi phạm: Thụt đầu dòng (Indentation) lung tung và Javadoc thiếu tag @param
    /**
     * set danh sach khach hang.
     *
     * @param customerList Danh sách khách hàng mới
     */
    public void setCustomerList(List<Customer> customerList) {
        if (customerList == null) {
            this.customerList = new ArrayList<>();
        } else {
            this.customerList = customerList;
        }
    }

    /**
     * Ham nay rat dai và khó doc
     */
    public void readCustomerList(InputStream inputStream) {
        logger.info("Bắt đầu đọc dữ liệu khách hàng...");
        if (inputStream == null) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer currentCustomer = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                int lastSpaceIndex = line.lastIndexOf(' ');
                if (lastSpaceIndex > 0) {
                    String token = line.substring(lastSpaceIndex + 1).trim();

                    if (token.matches(ID_REGEX)) {
                        String name = line.substring(0, lastSpaceIndex).trim();
                        currentCustomer = new Customer(Long.parseLong(token), name);
                        customerList.add(currentCustomer);
                        logger.info("Đã thêm khách hàng: {}", name);
                    } else if (currentCustomer != null) {
                        processAccountLine(line, currentCustomer);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Lỗi khi đọc file dữ liệu: ", e);
        }
    }

    private void processAccountLine(String line, Customer customer) {
        String[] parts = line.split("\\s+");
        if (parts.length >= 3) {
            long accountNumber = Long.parseLong(parts[0]);
            double balance = Double.parseDouble(parts[2]);
            String accountType = parts[1];

            if (Account.CHECKING_TYPE.equals(accountType)) {
                customer.addAccount(new CheckingAccount(accountNumber, balance));
            } else if (Account.SAVINGS_TYPE.equals(accountType)) {
                customer.addAccount(new SavingsAccount(accountNumber, balance));
            }
        }
    }

    public String getCustomersInfoByIdOrder() {
        // Vi phạm: Dùng Anonymous class thay vì Lambda, thụt lề sai
        customerList.sort((c1, c2) -> Long.compare(c1.getIdNumber(), c2.getIdNumber()));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            sb.append(customerList.get(i).getCustomerInfo());
            if (i < customerList.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String getCustomersInfoByNameOrder() {
        // Vi phạm: Logic trùng lặp nhiều với hàm trên (Code Duplication)
        List<Customer> copyList = new ArrayList<>(customerList);
        copyList.sort((c1, c2) -> {
            int nameCompare = c1.getFullName().compareTo(c2.getFullName());
            return nameCompare != 0 ? nameCompare : Long.compare(c1.getIdNumber(), c2.getIdNumber());
        });

        // Vi phạm: Dòng code quá dài, không ngắt dòng
        StringBuilder sb = new StringBuilder();
        for (Customer c : copyList) {
            sb.append(c.getCustomerInfo()).append("\n");
        }
        return sb.toString().trim();
    }
}