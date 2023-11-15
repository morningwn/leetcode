//
// Created by morningwn on 23-3-2.
// https://leetcode.cn/problems/bianry-number-to-string-lcci/
//
#include <string>
#include <iostream>

using namespace std;

string printBin(double num) {
    string bin = "0.";
    while (bin.size() <= 32 && num != 0) {
        num *= 2;
        int digit = (int) num;
        bin.push_back(digit + '0');
        num -= digit;
    }

    if (bin.size() > 32) {
        return "ERROR";
    }
    return bin;
}

int main() {
    double num = 0.625;
    string bin = printBin(num);
    cout << "res: " << bin << endl;
    return 0;
}