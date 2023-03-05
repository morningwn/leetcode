//
// Created by morningwn on 23-3-5.
// https://leetcode.cn/problems/delete-characters-to-make-fancy-string/
//
#include <string>

using namespace std;

string makeFancyString(string s) {
    string fancyStr;
    char pre = ' ';
    int flag = 0;
    for (const char &c: s) {
        if (c == pre) {
            flag++;
        } else {
            flag = 0;
        }
        pre = c;
        if (flag < 2) {
            fancyStr.push_back(c);
        }
    }

    return fancyStr;
}