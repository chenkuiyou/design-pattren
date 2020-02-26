import java.util.ArrayList;

/**
 *
 * 组合模式
 * 类似于文件系统 里面有两种对象， 一种是文件夹，一种是文件
 *
 * @author cky
 * @create 2020 02 26 10:44
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root=new BranchNode("root");
        BranchNode chp1=new BranchNode("chp1");
        BranchNode chp2=new BranchNode("chp2");
        root.add(chp1);
        root.add(chp2);

        chp1.add(new TreeNode("1.1"));
        chp1.add(new TreeNode("1.2"));
        chp2.add(new TreeNode("2.1"));
        chp2.add(new TreeNode("2.2"));

        root.add(new TreeNode("结束语"));
        root.print(0);



    }
}
abstract  class node<T> {    public abstract void print(int h);  }
class BranchNode extends node{
    String desc;
    ArrayList<node> list=new ArrayList<>();
    @Override
    public void print(int h) {
        int k=h+1;
        while(h>0){
            h--;
            System.out.print("--");
        }
        System.out.println(desc);
        for(node e:list){
            e.print(k);
        }
    }

    public BranchNode(String desc) {
        this.desc = desc;
    }
    public void add(node e){
        list.add(e);
    }
}
class TreeNode extends node{
    String desc;
    @Override
    public void print(int h) {
        while(h>0){
            h--;
            System.out.print("--");
        }
        System.out.println(desc);
    }

    public TreeNode(String desc) {
        this.desc = desc;
    }
}


