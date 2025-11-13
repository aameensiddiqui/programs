#include<bits/stdc++.h>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): data(x), left(nullptr), right(nullptr) {}
};

class InorderTraversal {
public:
    void inorder(TreeNode* root, vector<int> &ans) {
        if(root == nullptr) return;
        inorder(root->left, ans);
        ans.push_back(root->data);
        inorder(root->right, ans);
    }
    vector<int> inorder_traversal(TreeNode* root) {
        vector<int> ans;
        inorder(root, ans);
        return ans;
    }
    /*****************************/
    vector<int> iterative_inorder_traversal(TreeNode* root) {
        vector<int> ans;
        if(root == nullptr) return ans;
        stack<TreeNode*> st;
        while(true) {
            if(root != nullptr) {
                st.push(root);
                root = root->left;
            } else {
                if(st.empty()) break;
                root = st.top();
                st.pop();
                ans.push_back(root->data);
                root = root->right;
            }
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

    InorderTraversal it;
    cout << "Inorder traversal rcursively" << endl;
    vector<int> sol = it.inorder_traversal(root);
    for(int n : sol) cout << n << " ";
    cout << endl;

    cout << "Inorder traversal iteratively" << endl;
    vector<int> sol2 = it.iterative_inorder_traversal(root);
    for(int n : sol) cout << n << " ";
    cout << endl;
    
    return 0;
}
