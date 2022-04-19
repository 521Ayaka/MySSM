package com.ganga;

import com.ganga.factory.UsbSellImpl;
import com.ganga.handler.MyInvocationHandler;
import com.ganga.servlet.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DameMain {

    public static void main(String[] args) {

        //创建目标对象
        UsbSell usbSell = new UsbSellImpl();

        //[创建代理功能] 实现的InvocationHandler对象 并放入目标对象
        InvocationHandler factory = new MyInvocationHandler(usbSell);

        //[创建代理对象] 使用Proxy.newProxyInstance() 方法
        /**
         * 参数有三个
         */
        UsbSell usbSellProxy = (UsbSell) Proxy.newProxyInstance(
                usbSell.getClass().getClassLoader(),
                usbSell.getClass().getInterfaces(),
                factory
        );

        //通过代理对象执行代理方法 中的 method.invoke(目标方法,参数)方法 代理执行目标方法 并获取方法的返回值
        float money = usbSellProxy.sell(1);
        System.out.println("代理出售单个价钱为:" + money);

    }
/*运行结果:

==========目标方法===========
目标对象方法执行...
==========增强方法===========
原工厂单个价钱为: 85.0
获取优惠卷.......
代理出售单个价钱为:110.0
============================
代理出售单个价钱为:110.0

*/
}
