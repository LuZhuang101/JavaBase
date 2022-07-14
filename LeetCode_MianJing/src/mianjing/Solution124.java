package mianjing;

public class Solution124 {

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        if(root == null){
            return 0;
        }
        dfs(root);
        return ans;
    }

    public RetureType dfs(TreeNode node){
        if(node==null){
            ans = Math.max(ans, 0);
            return new RetureType(0,0,0);
        }
        RetureType leftReturn = dfs(node.left);
        int leftMax = Math.max(leftReturn.leftSum, leftReturn.rightSum);
        ans = Math.max(leftMax,ans);
        ans = Math.max(ans,leftMax+node.val);
        RetureType rightReturn = dfs(node.right);
        int rightMax = Math.max(rightReturn.leftSum, rightReturn.rightSum);
        rightMax = Math.max(rightMax, rightReturn.maxSum);
        ans = Math.max(rightMax, ans);
        ans = Math.max(ans,rightMax+node.val);
        return new RetureType(leftMax+node.val,rightMax+node.val,leftMax+rightMax+node.val);
    }

    class RetureType{
        int leftSum;
        int rightSum;
        int maxSum;
        RetureType(){};
        RetureType(int leftSum, int rightSum, int maxSum){
            this.leftSum = leftSum;
            this.rightSum = rightSum;
            this.maxSum = maxSum;
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}