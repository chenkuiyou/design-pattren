/**
 * @author cky
 * @create 2020 2 24 20:40
 */
public class CatHeightCompare implements Comparator<Cat>{

    @Override
    //String 的compare接口是用来比较 两个字符串除去 相同部分之后的长度差，
    public int compare(Cat a, Cat b) {
        if(a.height>b.height) return 1;
        else if(a.height<b.height) return -1;
        else return 0;

    }
}
