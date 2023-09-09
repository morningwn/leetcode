//
// Created by morningwn on 23-3-3.
// https://leetcode.cn/problems/making-file-names-unique/
//
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string getFolderName(string name, int count) {
    return name + "(" + to_string(count) + ")";
}
vector<string> getFolderNames(vector<string>& names) {
    unordered_map<string, int> folderMap;
    vector<string> folderNames;
    for (const auto & name : names) {
        string folderName = name;
        if (folderMap.count(folderName)) {
            int count = folderMap[folderName];
            while (folderMap.count(folderName)) {
                folderName = getFolderName(name, count);
                count++;
            }
            folderMap[name] = count;
            folderMap[folderName] = 1;
        } else {
            folderMap[folderName] = 1;
        }
        folderNames.push_back(folderName);
    }

    return folderNames;
}

int main () {
    return 0;
}