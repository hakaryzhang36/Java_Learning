package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {
    /**
     * 原始类
     */
    static class Base implements BaseInterface{

        @Override
        public String baseDo(String str) {
            System.out.println("Base do something.");
            return str;
        }
    }

    /**
     * 代理方法处理类
     */
    static class MyInvocationHandler implements InvocationHandler {

        Base target;

        MyInvocationHandler(Base target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            proxyDo();
            // 基于反射，调用 Method 对象的 invoke 方法。
            Object res = method.invoke(target, args);
            return res;
        }

        public void proxyDo() {
            System.out.println("Proxy do something.");
        }
    }

    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new Base());
        BaseInterface baseProxy =
                (BaseInterface)Proxy.newProxyInstance(
                        Base.class.getClassLoader(),
                        Base.class.getInterfaces(),
                        myInvocationHandler
                );
        String res = baseProxy.baseDo("abc");
        System.out.println(res);
    }
}
