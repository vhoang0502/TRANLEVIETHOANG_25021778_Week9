package com.practice.maven;

import org.junit.jupiter.api.Test;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileManagerTest {

    @Test
    public void testCrossPlatformPath() {
        FileManager fm = new FileManager();
        String result = fm.createFilePath("docs", "report.txt");

        String expectedOsPath = Paths.get("docs", "report.txt").toString();

        // Kiểm tra xem hàm có khớp với chuẩn của OS không
        assertEquals(expectedOsPath, result, "Loi: Duong dan khong tuong thich voi HĐH hien tai!");
    }
}