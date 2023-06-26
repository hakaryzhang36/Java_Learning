package designedParttern;

public class TurtleLazySingleton {
    private String name = null;

    // 不在类加载时初始化单例
    private static volatile TurtleLazySingleton instance = null;


    /**
     * 构造函数私有化
     */
    private TurtleLazySingleton() {}
    private TurtleLazySingleton(String name) {
        this.name = name;
    }


    /**
     * 获取单例对象的唯一方法，并且用 synchronize 修饰保证线程安全（不会创建多个对象）
     * @return 单例对象
     */
    public static TurtleLazySingleton getInstance() {
        if (instance == null) {
            synchronized (TurtleLazySingleton.class) {
                if (instance == null) {
                    instance = new TurtleLazySingleton("Turtle Singleton");
                }
            }
        }
        return instance;
    }
}
