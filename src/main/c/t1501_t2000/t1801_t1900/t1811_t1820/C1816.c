/**
 * <a href="https://leetcode-cn.com/problems/truncate-sentence/">1816. 截断句子</a>
 *
 * @author morningwn
 * @date Created in 2021/12/6 10:39
 */

#include <stdio.h>
#include <string.h>

char *truncateSentence(char *s, int k) {
    int length = strlen(s);
    int count = 0;
    for (int i = 0; i < length; ++i) {
        if (s[i] == ' ' && ++count >= k) {
            s[i] = '\0';
            break;
        }

    }
    return s;
}

int main() {
    return 0;
}