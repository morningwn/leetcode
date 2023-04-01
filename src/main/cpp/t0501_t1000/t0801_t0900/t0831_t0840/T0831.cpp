//
// Created by morningwn on 2023/4/1.
// https://leetcode.cn/problems/masking-personal-information/
//
#include <string>
#include <regex>

using namespace std;

string maskPII(string s) {
    int atIndex = s.find('@');
    if (atIndex != string::npos) {
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        return s.substr(0, 1) + "*****" + s.substr(atIndex - 1);
    } else {
        const vector<string> pref = {"", "+*-", "+**-", "+***-"};
        s = regex_replace(s, regex("[^0-9]"), "");
        return pref[s.length() - 10] + "***-***-" + s.substr(s.length() - 4);
    }
}