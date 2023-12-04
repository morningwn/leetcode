/**
 * 1038. 从二叉搜索树到更大和树
 * https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/
 */

#include <stdio.h>
#include <stdlib.h>
#include "TreeNode.h"

int helper(struct TreeNode *root, int sum) {
    if (root == NULL) {
        return 0;
    }
    int rightSum = helper(root->right, sum);
    int val = root->val;
    root->val = sum + rightSum + root->val;
    int leftSum = helper(root->left, root->val);
    return rightSum + leftSum + val;
}

struct TreeNode* bstToGst(struct TreeNode* root) {
    helper(root, 0);
    return root;
}

int main() {
    return 0;
}