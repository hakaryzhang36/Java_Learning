package accessibility;

import accessibility.pa.TurtleInPa;
import accessibility.pa.TurtleInPaExtended;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public class AccessTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        new TurtleInPaExtended().print();
        new TurtleInAccess().print();

        // 这里可以证明，父子类在同一个包下时，子类虽然可以访问父类的默认字段
        // 但是这种访问的实现是基于同一包下的权限的，子类实际上还是不能继承默认字段
        Field[] fields = TurtleInPaExtended.class.getFields();
        System.out.println(Arrays.toString(fields));

        TurtleInPa turtleInPa = new TurtleInPa();
        Field field1 = TurtleInPa.class.getDeclaredField("protectedName");
        System.out.println(field1);
        field1.set(turtleInPa, "abc");

    }
}
