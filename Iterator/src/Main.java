import java.util.LinkedList;

/**
 *
 * 迭代器模式
 * @author cky
 * @create 2020 02 26 15:33
 */
public class Main {
    public static void main(String[] args) {
        Collection_ c=new Arraylist_(1);
        c.add(1);
        c.add("hello");
        c.add("hello");
        c.add("hello");
        c.add("55555");
        System.out.println("size:" + c.getSize());
        Iterator_ t=c.iterator();
        while(t.hasNext())
            System.out.println(t.next());


        LinkedList_ l=new LinkedList_();
        System.out.println("---------");
        l.add("123");
        l.add("hello");
        l.add("world");
        l.add("12!!!!3");
        l.add("12---3");
        System.out.println("size:" + l.getSize());
        t=l.iterator();
        while(t.hasNext())
            System.out.println(t.next());

        LinkedList_<Integer>  ll=new LinkedList_<>();
        ll.add(1);
        ll.add(1);
//        ll.add("111");
    }
}
