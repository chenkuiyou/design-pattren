/**
 * @author cky
 * @create 2020 02 26 16:01
 */
public class Arraylist_<T> extends Collection_<T>{
    private T [] array=null;
    public Arraylist_() {
        array=(T[])new Object[10];
    }
    public Arraylist_(int num) {
        array=(T[])new Object[num];
    }
    int size=0;
    @Override
    public void add(T t) {
        if(size==array.length){
            T[] narrays= (T[])new Object[array.length*2] ;
            System.arraycopy(array,0,narrays,0,array.length);
            array=narrays;
        }
        array[size++]=t;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return  new iterator();
    }



    private  class iterator implements Iterator_<T> {
        private  int index=0;
        iterator(){index=0;}
        public boolean hasNext() {
            if(index>=size) return false;
            return true;
        }

        @Override
        public T next() {
            return array[index++];
        }
    }
}
