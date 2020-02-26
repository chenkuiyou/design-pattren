import java.util.LinkedList;

/**
 * @author cky
 * @create 2020 02 26 16:01
 */
public class LinkedList_<T> extends Collection_<T>{

    private Node<T> head=null;
    private Node<T> tail=null;
    private int size;
    LinkedList_(){

    }
    private static class Node<T> {
        T item;
        LinkedList_.Node<T> next;
        LinkedList_.Node<T> prev;
        Node(LinkedList_.Node<T> prev, T element, LinkedList_.Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public void add(T t) {
        size++;
        if(head==null){
            head=new Node<T>(null,t,null);
            tail=new Node<T>(head,null,null);
            head.next=tail;
            return ;
        }
        tail.item=t;
        tail.next=new Node<T>(tail,null,null);
        tail=tail.next;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new iterator();
    }
    private class iterator implements Iterator_{

        Node<T>  index=null;
        iterator(){
            index=head;
        }

        @Override
        public boolean hasNext() {
            if(size==0)
                return false;
            return index.item!=null?true:false;
        }

        @Override
        public Object next() {
            T t=index.item;
            index=index.next;
            return t;
        }
    }
}
