class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        TreeNode root=build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    TreeNode build(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart>preEnd) return null;
        TreeNode root=new TreeNode(pre[preStart]);
        int index=map.get(root.val);
        int numDiff=index-inStart;
        root.left=build(pre,preStart+1,preStart+numDiff,in,inStart,index-1);
        root.right=build(pre,preStart+numDiff+1,preEnd,in,index+1,inEnd);
        return root;
    }
}