/**
 * <a href="https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/">1576. 替换所有的问号</a>
 * @author morningwn
 * @date 2022-01-05
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *modifyString(char *s) {
    const char A = 'a';

    int length = strlen(s);

    for (int i = 0; i < length; i++) {
        int j = 0;
        while (s[i] == '?') {
            if (i > 0 && i < length - 1) {
                if (s[i - 1] != A + j && s[i + 1] != A + j) {
                    s[i] = A + j;
                }
            } else if (i == 0) {
                if (s[i + 1] != A + j) {
                    s[i] = A + j;
                }
            } else {
                if (s[i - 1] != A + j) {
                    s[i] = A + j;
                }
            }
            j++;
        }

    }

    return s;
}

int main() {
    char s[] = "ubv?w";
    printf("s:%s\n", modifyString(s));
    printf("%i", 'a');
    return 0;
}