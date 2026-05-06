package com.practice.maven;

import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileManagerTest {

    @Test
    public void testCrossPlatformPath() {
        FileManager fm = new FileManager();
        String result = fm.createFilePath("docs", "report.txt"); // Hàm này luôn trả về: docs\report.txt

        // Đường dẫn chuẩn do chính Hệ điều hành (OS) đang chạy sinh ra
        String expectedOsPath = Paths.get("docs", "report.txt").toString();

        // Kiểm tra xem hàm của ta có khớp với chuẩn của OS không
        assertEquals(expectedOsPath, result, "Loi: Duong dan khong tuong thich voi HĐH hien tai!");
    }
}