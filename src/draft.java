import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author cky
 * @create 2020 2 25 13:01
 */
public class draft {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        Solution s=new Solution();

        //System.out.println(s.validateStackSequences(a, b));
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return new ArrayList<List<Integer>>();
        TreeNode last=root;
        TreeNode lastf=root;
        boolean trun=true;
        List<TreeNode>  l1=new ArrayList<>();
        List<TreeNode>  l2=new ArrayList<>();
        l1.add(root);
        List<List<Integer>>  res=new ArrayList<List<Integer>>();
        res.add(new ArrayList<>());
        res.get(0).add(root.val);
        res.add(new ArrayList<>());
        while(l1.size()!=0||l2.size()!=0){
            while(l1.size()>0){
                TreeNode t=l1.get((l1.size()-1));
                l1.remove(l1.size()-1);
                if(t.right!=null){
                    l2.add(t.right);
                    res.get(res.size()-1).add(t.right.val);
                }
                if(t.left!=null){
                    l2.add(t.left);
                    res.get(res.size()-1).add(t.left.val);
                }
            }
            if(l2.size()==0)
                break;
            res.add(new ArrayList<>());
            while(l2.size()>0){
                TreeNode t=l2.get((l2.size()-1));
                l2.remove(l2.size()-1);
                if(t.left!=null){
                    l1.add(t.left);
                    res.get(res.size()-1).add(t.left.val);

                }
                if(t.right!=null){
                    l1.add(t.right);
                    res.get(res.size()-1).add(t.right.val);
                }
            }
            res.add(new ArrayList<>());
        }
        while(res.get(res.size()-1).size()==0){
            res.remove(res.size()-1);
        }
        return res;
    }
}