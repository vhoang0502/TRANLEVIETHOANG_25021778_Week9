#!/bin/bash

# Biên dịch dự án và kiểm tra Checkstyle
echo "--- Dang bien dich va kiem tra chat luong code (Checkstyle) ---"
mvn clean compile checkstyle:check

# Kiểm tra nếu lệnh trước đó bị lỗi thì dừng lại luôn
if [ $? -ne 0 ]; then
    echo "Loi: Code khong vuot qua kiem tra Checkstyle hoac loi bien dich!"
    exit 1
fi

# Chạy chương trình
echo "--- Dang khoi chay chuong trinh ---"
mvn exec:java -Dexec.mainClass="bank_system.Main"