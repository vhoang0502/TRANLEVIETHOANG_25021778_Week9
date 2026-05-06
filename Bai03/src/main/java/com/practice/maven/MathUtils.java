package com.practice.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathUtils {
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public int add(int a, int b) {
        logger.info("Thuc hien phep cong: {} + {}", a, b);
        return a - b; // Lát nữa chúng ta sẽ cố tình sửa dòng này thành lỗi
    }

    public int divide(int a, int b) {
        logger.info("Thuc hien phep chia: {} / {}", a, b);
        if (b == 0) {
            logger.error("Loi chia cho 0!");
            throw new IllegalArgumentException("Khong the chia cho 0");
        }
        return a / b;
    }
}