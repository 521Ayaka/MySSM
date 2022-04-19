package com.ganga.factory;

import com.ganga.servlet.UsbSell;

public class UsbSellImpl implements UsbSell {
    @Override
    public float sell(int amount) {
        System.out.println("==========目标方法===========");
        System.out.println("目标对象方法执行...");
        return 85.0f;
    }
}
