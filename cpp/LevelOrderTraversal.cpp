#include<bits/stdc++.h>
using namespace std;

struct TreeNode {
    int data;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): data(x), left(NULL), right(NULL) {}
};

class LevelOrderTraversal {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root == NULL) return ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            vector<int> list;
            int s = q.size();
            for(int i = 0; i < s; ++i) {
                if(q.front()->left != NULL) q.push(q.front()->left);
                if(q.front()->right != NULL) q.push(q.front()->right);
                list.push_back(q.front()->data);
                q.pop();
            }
            ans.push_back(list);
        }
        return ans;
    }
};

int main() {
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);

    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);

    LevelOrderTraversal lt;
    vector<vector<int>> sol = lt.levelOrder(root);
    cout << "{";
    for(const auto& row : sol) {
        cout << "[";
        for(int n : row) cout << "(" << n << ")";
        cout << "]";
    }
    cout << "}" << endl;
    return 0;
}
