import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * 转换类
 * 这个设计模式其实很简单，就是在一个类做输入给另外一个类；
 * 在jdbc中想链接 SQLService SQLService  不提供jdbc的接口，需要odbc-jdbc 的bridge 进行转化。
 *
 * 还比如  字节流输入， 字符流输出
 *
 * @author cky
 * @create 2020 02 27 18:25
 */
public class Main {
    public static void main(String[] args) throws Exception {

        //字节流输入
        FileInputStream fis=new FileInputStream("hello.txt");
        //转换成字符流
        InputStreamReader isr=new InputStreamReader(fis);

        BufferedReader br=new BufferedReader(isr);
        String s;
        while ((s=br.readLine())!=null){
            System.out.println(s);
        }
        br.close();



    }
}
