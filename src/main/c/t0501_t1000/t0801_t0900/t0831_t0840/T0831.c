//
// Created by morningwn on 2023/4/1.
// https://leetcode.cn/problems/masking-personal-information/
//
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <ctype.h>

char *maskPII(char *s) {
    char *at = strchr(s, '@');
    if (at == NULL) {
        char nums[16];
        int numCount = 0;
        for (int i = 0; s[i] != '\0'; i++) {
            if (isdigit(s[i])) {
                nums[numCount++] = s[i];
            }
        }
        nums[numCount] = '\0';
        char *phoneNumber = calloc(18, sizeof(char *));
        const char *pref[] = {"", "+*-", "+**-", "+***-"};
        sprintf(phoneNumber, "%s%s%s", pref[numCount - 10], "***-***-", nums + numCount - 4);
        return phoneNumber;
    } else {
        for (int i = 0; s[i] != '\0'; i++) {
            // 本地测试因为输入的问题，这个地方会报错，本地测试用例输入字符串为常量，不能改
            s[i] = tolower(s[i]);
        }
        char *email = calloc(45, sizeof(char *));
        sprintf(email, "%c%s%s", s[0], "****-****", at - 1);
        return email;
    }
}

int main() {
     char *s = "LeetCode@LeetCode.com";
//    char *s = "86-(10)12345678";
    char *maskS = maskPII(s);
    printf("%s", maskS);
    return 0;
}