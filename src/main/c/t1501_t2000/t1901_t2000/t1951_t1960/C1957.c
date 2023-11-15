//
// Created by morningwn on 23-3-5.
// https://leetcode.cn/problems/delete-characters-to-make-fancy-string/
//
#include <stdlib.h>
#include <string.h>

char *makeFancyString(char *s) {
    char *fancyStr = calloc(strlen(s) + 1, sizeof(char));
    int index = 0;
    char pre = ' ';
    int flag = 0;
    for (int i = 0; i < strlen(s); i++) {
        if (pre == s[i]) {
            flag++;
        } else {
            flag = 0;
        }
        pre = s[i];
        if (flag < 2) {
            fancyStr[index++] = s[i];
        }
    }

    return fancyStr;
}

int main () {
    return 0;
}