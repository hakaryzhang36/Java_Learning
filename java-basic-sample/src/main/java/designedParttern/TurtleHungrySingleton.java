package designedParttern;

/**
 * 懒汉单例（线程安全）
 * 1. 内部声明一个静态单例对象
 * 2. 将构造方法私有化
 * 3. 对外暴露一个静态方法，用于获取单例对象
 */
public class TurtleHungrySingleton {
    private String name = null;

    // 静态单例对象，在类加载时就生成
    private static final TurtleHungrySingleton instance = new TurtleHungrySingleton("Turtle Singleton");

    // 构造函数私有化，外部无法调用
    private TurtleHungrySingleton(){}
    private TurtleHungrySingleton(String name) {
        this.name = name;
    }

    /**
     * 唯一获取单例对象的方法
     * @return 单例对象
     */
    public static TurtleHungrySingleton getInstance() {
        return instance;
    }

}
