import java.text.DecimalFormat;

public class BitwiseAndBitShiftSample {
    /**
     * 位运算示例
     * & 与运算
     * | 或运算
     * ~ 非运算
     * ^ 异或运算
     * << 左位移
     * >> 右位移
     * <<< 无符号右移
     */

    public static void main(String[] args) {
        System.out.println(~(-2));

        // 右移 n 位 == 右移 n % 32 位
        System.out.println(2 >> 1);
        System.out.println(2 >> 33);
        System.out.println(-2 >>> 1);
        System.out.println(-2 >>> 33);
    }
}
