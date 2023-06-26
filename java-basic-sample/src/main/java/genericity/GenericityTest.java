package genericity;

import java.util.List;

/**
 * 泛型：
 * 1. 泛型类
 * 2. 泛型方法
 * 3. 泛型接口
 * @param <T>
 */
public class GenericityTest<T> {

    T obj;

    public T getObj(T obj) {
        return obj;
    }

    private Object[] elem;
    public T get(int index) {return (T)elem[index];}  // ????????????黑人问号脸
    public void set(int index, T e) {elem[index] = e;}
    public T[] getArr(){return (T[])elem;}


    /*
    * 泛型方法
    * */
    public <R> R genericityFunction(R r) {
        return r;
    }

    // 编译期间泛型有效，运行期间泛型擦除
    public void func(List<String> list){}
    // public void func(List<Integer> list){} // 报错，因为泛型擦除后和 func 方法发生重载错误


}
