#include<bits/stdc++.h>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : data(x), left(nullptr), right(nullptr) {}
};
class DiameterOfBinaryTree {
public:
    int findH(TreeNode* root, int& dia) {
        if(root == nullptr) return 0;
        int lh = findH(root->left, dia);
        int rh = findH(root->right, dia);
        dia = max(dia, lh+rh);
        return 1+max(lh, rh);
    }
    int diameterOfBinaryTree(TreeNode* root) {
        if(root == nullptr) return 0;
        int dia = 0;
        findH(root, dia);
        return dia;
    }
};
int main() {
    // 1
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);

    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);
    
    // 2
    TreeNode* root2 = new TreeNode(1);
    root2->left = new TreeNode(2);
    root2->right = new TreeNode(3);

    root2->right->left = new TreeNode(4);
    root2->right->left->left = new TreeNode(5);
    root2->right->left->left->left = new TreeNode(9);
    
    root2->right->right = new TreeNode(6);
    root2->right->right->right = new TreeNode(7);
    root2->right->right->right->right = new TreeNode(8);

    DiameterOfBinaryTree d;
    cout << d.diameterOfBinaryTree(root) << endl;
    cout << d.diameterOfBinaryTree(root2) << endl;

    return 0;
}
