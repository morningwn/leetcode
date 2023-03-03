//
// Created by morningwn on 23-3-3.
// https://leetcode.cn/problems/making-file-names-unique/
//
#include <stdlib.h>
#include <stdio.h>
#include "uthash.h"

typedef struct hashItem {
    char *key;
    int val;
    UT_hash_handle hh;
} hashItem;

hashItem *addNew(hashItem **header, char *key) {
    hashItem *item = (hashItem *) malloc(sizeof(hashItem));
    item->key = (char *) calloc(sizeof(char), strlen(key) + 1);
    item->val = 1;
    strcpy(item->key, key);
    HASH_ADD_STR(*header, key, item);
    return item;
}

void hashFree(hashItem **obj) {
    hashItem *curr = NULL, *tmp = NULL;
    HASH_ITER(hh, *obj, curr, tmp) {
        HASH_DEL(*obj, curr);
        free(curr->key);
        free(curr);
    }
}


char **getFolderNames(char **names, int namesSize, int *returnSize) {
    hashItem *folderMap = NULL;

    char **folders = (char **) malloc(sizeof(char *) * namesSize);
    *returnSize = namesSize;
    for (int i = 0; i <= namesSize; i++) {
        hashItem *sourceFolder = NULL;
        HASH_FIND_STR(folderMap, names[i], sourceFolder);
        char *folder = NULL;
        if (sourceFolder == NULL) {
            folder = (char *) calloc(sizeof(char), strlen(names[i]) + 1);
            folder = strcpy(folder, names[i]);
            addNew(&folderMap, folder);
        } else {
            char folderTmp[strlen(names[i]) + 16];
            sprintf(folderTmp, "%s(%d)", names[i], sourceFolder->val);
            hashItem *tmp = NULL;
            HASH_FIND_STR(folderMap, folderTmp, tmp);
            int count = 0;
            while (tmp != NULL) {
                count++;
                sprintf(folderTmp, "%s(%d)", names[i], count);
                HASH_FIND_STR(folderMap, folderTmp, tmp);
            }
            folder = (char *) calloc(sizeof(char), strlen(folderTmp) + 1);
            folder = strcpy(folder, folderTmp);
            sourceFolder->val = count;
            addNew(&folderMap, folder);
        }
        folders[i] = folder;

    }
    hashFree(&folderMap);
    return folders;
}

int main() {
    char **names[] = {"pes", "fifa", "gta", "pes(2019)"};
    int returnSize = 0;
    char **folderNames = getFolderNames(names, 3, &returnSize);
    printf("returnSize: %d\n", returnSize);

    for (int i = 0; i <= returnSize; i++) {
        printf("%s\n", folderNames[i]);
    }
    return 0;
}

