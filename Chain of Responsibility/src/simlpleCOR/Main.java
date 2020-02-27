package simlpleCOR;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 简单的责任链模式
 * 应用场景， 有一个请求需要过滤，要删除或者替换一些特定的东西，而且删除替换的东西可拓展，这个时候用责任链
 * 比如有一个字符串，需要写入到数据库中，写进去的时候需要替换敏感词
 * 但是这些敏感词是可变性比较大，有很多种过滤方式，
 * 如果单纯来写过滤方法的话，肯定是使用硬编码的方式，拓展性不好 这个时候就要使用责任链。
 * @author cky
 * @create 2020 02 27 13:16
 */
public class Main {
    public static void main(String[] args) {
        FilterChain fc=new FilterChain();
        fc.add(new Zu_anFilter());
        FilterChain fc2=new FilterChain();
        fc2.add(new ReplaceFilter());
        fc2.add(new SensitiveFilter());
        fc.add(fc2);
        String s1="SB zuanQAQ";
        String s2="zhongguoQAQqiang QAQ!";
//        Msg msg=new Msg(s1);
        Msg msg=new Msg(s2);
        fc.doFilter(msg);
        System.out.println(msg.getS());
    }
}
class  Msg{
    private String s;
    public Msg(String s) {
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }
    public String getS() {
        return s;
    }

}
interface  Filter{ public boolean doFilter(Msg s); }
class SensitiveFilter implements Filter{
    @Override
    public boolean doFilter(Msg msg ) {
        String s=msg.getS();
        msg.setS(s.replaceAll("zhongguo","中国"));
        return true;
    }
}
class ReplaceFilter implements  Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String s=msg.getS();
        msg.setS(s.replaceAll("QAQ","QVQ"));
        return true;
    }
}
class Zu_anFilter implements  Filter{
    @Override
    public boolean doFilter(Msg msg) {
        String s=msg.getS();
        if(s.contains("SB"))
            return false;
        return true;
    }
}
class FilterChain implements Filter{
    //这边的继承是责任链的精髓，如果没有这个继承，想合并两个链子变得很麻烦
    //将FilterChain 看作是Filter那么已有的FilterChain可以加入到list中，调用自己的方法；
    private LinkedList<Filter> list=new LinkedList<>();
    public void add(Filter f){
        list.add(f);
    }
    @Override
    public boolean doFilter(Msg s) {
        for(Filter i:list){
            if(!i.doFilter(s))
                return false;
        }
        return true;
    }
}




