package reflextion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflexTest {

    public static void main(String[] args) throws Exception{
        Base instance = new Base();
        // 获取类对象
        System.out.println(Base.class);
        System.out.println(Class.forName("reflextion.Base"));
        System.out.println(instance.getClass());

        // 获取构造器
        Constructor<Base> cs1 = Base.class.getConstructor();
        Constructor<Base> cs2 = Base.class.getConstructor(String.class);
        Base base = cs1.newInstance();

        System.out.println(Arrays.toString(cs2.getParameterTypes()));   // 获取构造器参数类型

        Constructor<?>[] cslist = Base.class.getDeclaredConstructors(); // 获取所有构造器
        System.out.println(Arrays.toString(cslist));

        // 获取字段
        Field[] fields = Base.class.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        fields[0].set(instance, "abc");                 // 通过字段给一个对象字段赋值
        String s = (String) fields[0].get(instance);    // 通过字段获取对象的字段值

        // 获取方法
        Method setNameMethod = Base.class.getMethod("setName", String.class);
        setNameMethod.invoke(instance,"abc");
        Method getNameMethod = Base.class.getMethod("getName");
        System.out.println(getNameMethod.invoke(instance));
    }
}
