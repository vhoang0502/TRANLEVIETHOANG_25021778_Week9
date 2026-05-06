package com.practice.maven;

public class FileManager {
    // Hàm tạo đường dẫn ghép từ tên thư mục và tên file
    public String createFilePath(String folder, String fileName) {
        // CỐ TÌNH LỖI: Dùng cứng dấu gạch chéo ngược của Windows (\)
        return folder + "\\" + fileName;
    }
}