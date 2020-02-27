package COR;


import java.lang.annotation.Repeatable;
import java.util.ArrayList;

/**
 * 模拟Servlet中的filter 这个filter和简单责任链很像，
 * 不过要求的是在filter1执行了前半部之后，到filter2执行前半部，再到filter2执行前后半部，最后回到filter1执行了前后部
 * 1221的顺序，类似于TCP链接 给物理数据报拆下
 * @author cky
 * @create 2020 02 27 13:16
 */
public class Main {
    public static void main(String[] args) {
        FilterChain1 fc=new FilterChain1();
        fc.add(new HeadFilter());
        fc.add(new BodyFilter());

        Response res=new Response();
        Request req=new Request();
        fc.doFilter(req,res,fc);
        System.out.println(res.s);


        //测试会不会像之前那样 能够实现filterchain套filterfilter
//        FilterChain1 fc2=new FilterChain1();
//        fc2.add(new HeadFilter());
//        FilterChain1 fc3=new FilterChain1();
//
//        fc3.add(new HeadFilter());
//        fc3.add(new BodyFilter());
//
//        fc2.add(fc3);
//        Response res1=new Response();
//        Request req1=new Request();
//
//        fc2.doFilter(req1,res1,fc2);
//        System.out.println(res1.s);


    }
}
interface Filter{ public void doFilter(Request req, Response res, Filter fc); }
class HeadFilter implements Filter {


    @Override
    public void doFilter(Request req, Response res, Filter fc) {
        System.out.println("filter req.head");
        fc.doFilter(req,res,fc);
        System.out.println("filter res.head");
        res.s="head response! "+res.s;
    }
}
class BodyFilter implements Filter {
    @Override
    public void doFilter(Request req, Response res, Filter fc) {
        System.out.println("filter req.body");
        fc.doFilter(req,res,fc);
        System.out.println("filter res.body");
        res.s="body response! "+res.s;
    }
}
class FilterChain1 implements  Filter{
    ArrayList<Filter> list;
    int index=0;
    FilterChain1(){
        index=0;
        list=new ArrayList<>();
    }
    public void  add(Filter filter){
        list.add(filter);
    }
    @Override
    public void doFilter(Request req, Response res, Filter fc) {
        if(index>=list.size())
            return ;
        if(list.get(index) instanceof FilterChain1){
            FilterChain1 t=(FilterChain1)list.get(index) ;
            list.get(index++).doFilter(req,res,t);
        }

        else
            list.get(index++).doFilter(req,res,fc);
        return ;
    }
}

class Request {
    String s="";
}
class Response{
    String s="";

}


