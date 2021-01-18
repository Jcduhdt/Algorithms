package Chapter1_base;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2021-01-18
 * 建一个基于数组可动态调整数组大小栈，实现了迭代器，逆序迭代
 */
public class J08ResizingArrayStack<Item> implements Iterable<Item>{

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public J08ResizingArrayStack(int cap){
        a = (Item[]) new Object[cap];
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     *
     * @return 当前存入数据量
     */
    public int size(){
        return N;
    }

    /**
     * 存数据，空间不够则扩容
     * @param item 待存入数据
     */
    public void push(Item item){
        // 扩容
        if(N == a.length){
            resize(2*a.length);
        }
        a[N++] = item;
    }

    /**
     * 进入应该判空抛异常，但是书上没有
     * 当存入数据小于等于当前数组的四分之1时，为节省空间就将长度减半
     * @return 返回弹出的数据
     */
    public Item pop(){
        Item item = a[--N];
        a[N] = null; // 避免游离对象，引用覆盖，让垃圾回收
        if(N > 0 && N == a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    /**
     * 调整数组大小
     * @param max 新数组大小
     */
    private void resize(int max){
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = a[i];
        }
        a = tmp;
    }

    @Override
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            if (i == 0){
                throw new NoSuchElementException();
            }
            return a[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

