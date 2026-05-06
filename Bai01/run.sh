#!/bin/bash
set -e  

ROOT_DIR="$(pwd)"
SRC_DIR="$ROOT_DIR/src"
BUILD_DIR="$ROOT_DIR/build"
JUNIT_JAR="lib/junit-platform-console-standalone-1.10.0.jar"

if [ ! -f "$JUNIT_JAR" ]; then
    echo "Không tìm thấy $JUNIT_JAR"
    exit 1
fi

mkdir -p "$BUILD_DIR"

echo "Biên dịch..."
javac -cp "$JUNIT_JAR" -d "$BUILD_DIR" $(find "$SRC_DIR" -name "*.java")

echo "Chạy kiểm thử..."
java -jar "$JUNIT_JAR" execute \
     --class-path "$BUILD_DIR" \
     --select-class MathUtilsTest \
     --details tree