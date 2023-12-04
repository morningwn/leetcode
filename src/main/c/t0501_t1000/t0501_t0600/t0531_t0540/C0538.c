/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/
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

struct TreeNode *convertBST(struct TreeNode *root) {
    helper(root, 0);
    return root;
}

int main() {
    return 0;
}