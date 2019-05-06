package com.nocturne.study.java.basic.day1;

import com.nocturne.study.java.basic.day1.impl.IUserDOImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by liang.ding on 2019-04-24.
 */
public class InvocationHandlerImpl implements InvocationHandler {
    //业务实现类对象，用来调用具体的业务方法
    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("业务开始了。。。。");
        result = method.invoke(target, args);
        System.out.println("业务结束了。。。。");
        return result;
    }

    public static void main(String[] args) {
        //被代理对象
        IUserDO iUserDO = new IUserDOImpl();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(iUserDO);
        ClassLoader classLoader = iUserDO.getClass().getClassLoader();
        Class<?>[] interfaces = iUserDO.getClass().getInterfaces();

        //主要装载器
        IUserDO proxy=(IUserDO)Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        proxy.save();
    }
}
