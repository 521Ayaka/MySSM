package com.ganga.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAOP {

    /**
     * 特别注意:
     *  如果有目标接口 Target目标对象继承了这个接口
     *  那么这里注入的应该是这个接口对象
     *  TargetInterface 的对象！
     */
    @Autowired
    private TargetInterface target;

    @Test
    public void testTarget(){
        System.out.println("=============");
        target.sell1();
        System.out.println("=============");
    }

    @Test
    public void testPointcut1(){
        int age = target.sell2("尴尬", 9);
        System.out.println(age);
    }

    @Test
    public void testPointcut2() throws InterruptedException {
        int age = target.sell3("尴尬酱",9);
        System.out.println(age);
        /*
        *   前置增强...
        *   环绕前增强....
        *   姓名: 尴尬酱
        *   年龄: 9
        *   最终增强....
        *   异常抛出后增强...
        *
        * */
    }

}
