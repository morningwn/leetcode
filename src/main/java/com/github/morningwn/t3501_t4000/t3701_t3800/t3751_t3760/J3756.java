package com.github.morningwn.t3501_t4000.t3701_t3800.t3751_t3760;

import com.github.morningwn.prefab.FormatInput;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <a href="https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-ii">3756. 连接非零数字并乘以其数字和 II</a>
 */
public class J3756 {

    @Test
    public void test() {
//        Assert.assertArrayEquals(new int[]{12340, 4, 9}, sumAndMultiply("10203004", FormatInput.stringTo2Array("[[0,7],[1,3],[4,6]]",
//        2)));
//        Assert.assertArrayEquals(new int[]{444444137, 13770}, sumAndMultiply("9876543210", FormatInput.stringTo2Array("[[0,9],[2,4]]",
//        2)));
//        Assert.assertArrayEquals(new int[]{318566667}, sumAndMultiply("2711785625", FormatInput.stringTo2Array("[[0,9]]", 2)));
//        Assert.assertArrayEquals(new int[]{1}, sumAndMultiply("57569977386369791", FormatInput.stringTo2Array("[[16,16]]", 2)));
        Assert.assertArrayEquals(new int[]{14212, 317077000, 161389787, 882329907, 274699767, 300940897, 785430555, 513914994, 62101,
                730660, 9133375, 827275582, 751358554, 229370145, 746249343, 9142, 111061, 17640585, 809430657, 974510677, 13585136,
                660746179, 40897448, 5863, 1120455, 197417089, 454375020, 305251240, 238173859, 279317386, 10739104, 137595139, 251006020
                , 409388971, 764290238, 568372898, 280, 922291345, 827127435, 550, 10621, 145522, 1959265, 147732113, 663243696,
                545670509, 12537, 2272324, 328893895, 673301512, 319067560, 101983139, 81, 24475, 4017508, 48994450, 157682279, 49, 1264,
                19152, 3275449, 33553422, 391456933, 314015422, 688127163, 81, 3461185, 41534514, 463935280, 1408, 461359328, 1513,
                2675250, 201850, 2477385, 394550284, 1, 900, 12835, 64}, sumAndMultiply("83653355979889175588",
                FormatInput.stringTo2Array("[[0,2],[0,8],[0,10],[0,11],[0,13],[0,14],[0,15],[0,19],[1,4],[1,5],[1,6],[1,12],[1,16],[1," +
                        "17],[1,18],[2,4],[2,5],[2,7],[2,9],[2,10],[2,11],[2,14],[2,19],[3,5],[3,7],[3,9],[3,10],[3,14],[3,15],[3,16],[4," +
                        "9],[4,10],[4,15],[4,16],[4,18],[4,19],[5,6],[5,12],[5,14],[6,7],[6,8],[6,9],[6,10],[6,14],[6,15],[6,19],[7,9]," +
                        "[7,11],[7,13],[7,15],[7,17],[7,18],[8,8],[8,10],[8,12],[8,13],[8,18],[9,9],[9,10],[9,11],[9,13],[9,14],[9,15]," +
                        "[9,16],[9,19],[10,10],[10,14],[10,15],[10,19],[11,12],[11,19],[12,13],[12,16],[13,16],[13,17],[13,19],[14,14]," +
                        "[15,16],[15,17],[18,18]]", 2)));

    }

    private static final int MOD = 1000000007;
    private static final int MAX_N = 100001;
    private static final long[] pow10 = new long[MAX_N];

    // static 对于所有测试用例只运行一次
    static {
        pow10[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        int[] pfSums = new int[length];
        long[] pfXs = new long[length];
        int[] pfNums = new int[length];

        pfSums[0] = charArray[0] - '0';
        pfXs[0] = charArray[0] - '0';
        pfNums[0] = charArray[0] == '0' ? 1 : 0;

        for (int i = 1; i < length; i++) {
            pfSums[i] = charArray[i] - '0' + pfSums[i - 1];
            if (charArray[i] == '0') {
                pfNums[i] = pfNums[i - 1];
                pfXs[i] = pfXs[i - 1];
            } else {
                pfNums[i] = pfNums[i - 1] + 1;
                pfXs[i] = (pfXs[i - 1] * 10 + charArray[i] - '0') % 1000000007L;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            double pfX = start > 0 ? (pfXs[start - 1] * pow10[pfNums[end] - pfNums[start - 1]]) % 1000000007L : 0;
            double x = (pfXs[end] - pfX + 1000000007L) % 1000000007L;
            long sum = start > 0 ? pfSums[end] - pfSums[start - 1] : pfSums[end];
            ans[i] = (int) ((sum * x) % 1000000007L);
        }

        return ans;
    }
}
