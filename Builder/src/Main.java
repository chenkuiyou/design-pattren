/**
 * 构建器， 用于复杂对象  的灵活构造模式
 *
 * @author cky
 * @create 2020 02 27 15:49
 */
public class Main {
    public static void main(String[] args) {
        Person p=new Person.PersonBuilder()
                .basicInfo("cky",22,1)
                .height(175)
//                .weight(160)  如果某一行不要了，就直接注释掉就行
                .build();
        System.out.println(p);
    }
}
