/**
 *<a href="https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/">1614. 括号的最大嵌套深度</a>
 * 
 */
#include <stdio.h>
#include <string.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int maxDepth(char *s) {
    int length = strlen(s);
    int depth = 0;
    int maxDepth = 0;

    for (int i = 0; i < length; i++) {
        if (s[i] == '(') {
            maxDepth = MAX(maxDepth, ++depth);
        } else if (s[i] == ')') {
            --depth;
        }
    }

    return maxDepth;

}

int main() {
    char *str = "asde";
    printf("maxDepth: %d", maxDepth(str));

    return 0;
}