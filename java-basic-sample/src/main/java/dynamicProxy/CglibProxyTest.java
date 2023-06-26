package dynamicProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyTest {
    static class Base {
        public String baseDo(String str) {
            System.out.println("Base do something.");
            return str;
        }
    }

    static class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            proxyDo();
            Object res = methodProxy.invokeSuper(o, objects);
            return res;
        }

        public void proxyDo() {
            System.out.println("Proxy do something.");
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 需要代理的目标类
        enhancer.setSuperclass(Base.class);
        // 需要定义的方法拦截器
        enhancer.setCallback(new MyMethodInterceptor());

        // 代理类继承了目标类，所以可以向上转型
        Base baseProxy = (Base) enhancer.create();


        String res = baseProxy.baseDo("abc");
        System.out.println(res);
    }
}
