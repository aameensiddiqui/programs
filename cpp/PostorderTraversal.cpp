#include<bits/stdc++.h>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): data(x), left(NULL), right(NULL) {}
};

class PostorderTraversal {
public:
    void postorder(TreeNode* root, vector<int> &ans) {
        if(root == NULL) return;
        postorder(root->left, ans);
        postorder(root->right, ans);
        ans.push_back(root->data);
    }
    vector<int> postorder_traversal(TreeNode* root) {
        vector<int> ans;
        postorder(root, ans);
        return ans;
    }
    /**********************************/
    vector<int> iterative_postorder_traversal(TreeNode* root) {
        vector<int> ans;
        if(root == NULL) return ans;
        stack<TreeNode*> st1, st2;
        st1.push(root);
        while(!st1.empty()) {
            root = st1.top();
            st1.pop();
            st2.push(root);
            if(root->left != NULL) st1.push(root->left);
            if(root->right != NULL) st1.push(root->right);
        }
        while(!st2.empty()) {
            ans.push_back(st2.top()->data);
            st2.pop();
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

    PostorderTraversal pot;
    cout << "Postorder traversal recursively:" << endl;
    vector<int> sol = pot.postorder_traversal(root);
    for(int n : sol) cout << n << " ";
    cout << endl;
    
    cout << "Postorder traversal iteratively:" << endl;
    vector<int> sol2 = pot.iterative_postorder_traversal(root);
    for(int n : sol2) cout << n << " ";
    cout << endl;
}
