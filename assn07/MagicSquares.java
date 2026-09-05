package assn07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MagicSquares {
    public static boolean testMagic(String pathName) throws IOException {
        // 即使提前 return 或发生异常，也会自动关闭 reader
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(pathName))) {

            String[][] square = null;
            int size = 0;
            int rowNumber = 0;
            int targetSum = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");

                if (square == null) {
                    size = parts.length;
                    square = new String[size][];
                }

                // 每行必须有 size 个数字，总行数也不能超过 size
                if (parts.length != size || rowNumber >= size) {
                    return false;
                }

                square[rowNumber] = parts;

                int sum = 0;
                for (String part : parts) {
                    sum += Integer.parseInt(part);
                }

                if (rowNumber == 0) {
                    targetSum = sum;
                } else if (sum != targetSum) {
                    return false;
                }

                rowNumber++;
            }

            // 排除空文件和行数不足的情况
            if (square == null || rowNumber != size) {
                return false;
            }

            // 检查每一列
            for (int col = 0; col < size; col++) {
                int sum = 0;

                for (int row = 0; row < size; row++) {
                    sum += Integer.parseInt(square[row][col]);
                }

                if (sum != targetSum) {
                    return false;
                }
            }

            // 两条对角线分别求和
            int mainDiagonalSum = 0;
            int otherDiagonalSum = 0;

            for (int i = 0; i < size; i++) {
                mainDiagonalSum += Integer.parseInt(square[i][i]);
                otherDiagonalSum += Integer.parseInt(square[i][size - 1 - i]);
            }

            return mainDiagonalSum == targetSum
                    && otherDiagonalSum == targetSum;
        }
    }
    public static void main(String[] args) throws IOException {
        String[] fileNames = { "Mercury.txt", "Luna.txt" };
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic("src/assn07/" + fileName));
        }
    }
}
