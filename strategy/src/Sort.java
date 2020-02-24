/**
 *  策略设计模式
 *  主要是要执行一个操作，这个操作能够对所有对象进行操作，只要提供相应的策略；
 *  比如 要执行sort操作， 想要对所有对象能操作排序，就要提供对应对象的比较方法
 * 提供这个比较方法就叫做策略模式
 * @author cky
 * @create 2020 2 24 20:07
 */
public class Sort<T> {

    public void sort(T[] a,Comparator<T> comparator){
        for(int i=0;i<a.length;i++){
            int max_i=0;
            for(int j=0;j<a.length-i;j++){
                    max_i=comparator.compare(a[max_i],a[j])==1?max_i:j;
            }
            swap(a,max_i,a.length-i-1);
        }
    }
    public void swap(T[]a,int i,int j){
        T t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void main(String[] args) {
        Integer[] a = {7, 1, 2, 8, 5, 4, 3, 9};
        Sort<Integer> sort1 = new Sort<>();
        sort1.sort(a, (i, j) -> {
            int i1 = (Integer) i;
            int j1 = (Integer) j;
            return Integer.compare(i1, j1);
        });
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        Cat[] cats = {new Cat("aaaa", 15,20),
                new Cat("ccc", 10,30),
                new Cat("bb", 5,40)};

        Sort<Cat> sort2=new Sort<>();

        sort2.sort(cats,new CatWeightCompare() );
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        System.out.println("************");
        sort2.sort(cats,new CatHeightCompare() );
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
        System.out.println("************");
        //使用lambda表达式 实现定制接口
        sort2.sort(cats, (o1,o2)->{
            if(o1.height<o2.height) return 1;
            else if(o1.height>o2.height) return -1;
            else return 0;
        } );
        for (int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }
    }

}
