//
// Created by morningwn on 23-3-8.
// https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
//
#include <string>

using namespace std;

int minimumDeletions(string s) {
    int countB = 0;
    int countA = 0;
    int length = s.length();

    for (int i = 0; i < length; ++i) {
        countA += (s[i] == 'a' ? 1 : 0);
    }
    int minDeletions = countA;
    for (int i = 0; i < length; ++i) {
        if (s[i] == 'a') {
            countA--;
        } else {
            countB++;
        }
        minDeletions = min(minDeletions, countA + countB - 1);
    }

    return minDeletions;
}