#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): data(x), left(nullptr), right(nullptr) {}
};

class PreorderTraversal {
public:
    void preorder(TreeNode* root, vector<int> &ans) {
        if(root == nullptr) return;
        ans.push_back(root->data);
        preorder(root->left, ans);
        preorder(root->right, ans);
    }

    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ans;
        preorder(root, ans);
        return ans;
    }

    /************************************/
    vector<int> iterativePreorderTraversal(TreeNode* root) {
        vector<int> ans;
        if(root == nullptr) return ans;
        stack<TreeNode*> st;
        st.push(root);
        while(!st.empty()) {
            root = st.top();
            st.pop();
            ans.push_back(root->data);
            if(root->right != nullptr) st.push(root->right);
            if(root->left != nullptr) st.push(root->left);
        }
        return ans;
    }
};

int main() {
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);

    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);

    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(7);

    PreorderTraversal pt;

    cout << "Preorder Traversal recursively:" << endl;
    vector<int> sol = pt.preorderTraversal(root);
    for(int n : sol) cout << n << " ";
    cout << endl;
    
    cout << "Preorder Traversal iteratively:" << endl;
    vector<int> sol2 = pt.iterativePreorderTraversal(root);
    for(int n : sol2) cout << n << " ";
    cout << endl;

    return 0;
}
