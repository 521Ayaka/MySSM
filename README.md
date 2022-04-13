# SSM三大框架复习





## Spring框架



### 介绍

---

![image-20220413082758419](D:\MySSM\img\md-img\image-20220413082758419.png)

---

<br>

**Spring优势**

---

![image-20220413082944652](D:\MySSM\img\md-img\image-20220413082944652.png)

![image-20220413083028235](D:\MySSM\img\md-img\image-20220413083028235.png)

---



**Spring体系结构**

---

![image-20220413083135688](D:\MySSM\img\md-img\image-20220413083135688.png)

---

---



### Spring开发步骤

![image-20220413083256330](D:\MySSM\img\md-img\image-20220413083256330.png)



#### 一. 坐标 导入基本包

```xml
<dependencies>
    
	<!--导入spring的context坐标，context依赖core、beans、expression-->
	<dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.18</version>
    </dependency>
    
</dependencies>

```

---



#### 二. 编写Dao和实现类对象

```java
public interface UserDao {
	public void save();
}


public class UserDaoImpl implements UserDao {
	@Override
	public void save() {
	System.out.println("UserDao save method running....");
	}
}

```

---



#### 三. 核心配置文件 applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">


</beans>
```

---



#### 四. 在 Spring 配置文件中配置 UserDaoImpl

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="userDao" class="com.itheima.dao.impl.UserDaoImpl"></bean>
    
</beans>
```

---



#### 五. 使用Spring的API获得Bean实例

```java
@Test
public void test1(){
    
	ApplicationContext applicationContext = new
        ClassPathXmlApplicationContext("applicationContext.xml");
	UserDao userDao = (UserDao) applicationContext.getBean("userDao");
	userDao.save();
    
}
```

---





### Spring配置文件



#### Bean标签

----



##### Bean标签基本配置

![image-20220413084939770](D:\MySSM\img\md-img\image-20220413084939770.png)

---



##### **Scope范围配置**

![image-20220413085143163](D:\MySSM\img\md-img\image-20220413085143163.png)

1. 当scope的取值为**`singleton`**时
    1. Bean的实例化个数：**1个 **
    2. Bean的实例化时机：当Spring核心文件被加载时，实例化配置的Bean实例
    3. Bean的生命周期：
        1. 对象创建：当应用加载，**创建容器时**，对象就被创建了
        2. 对象运行：只要容器在，对象一直活着
        3. 对象销毁：当应用卸载，销毁容器时，**对象就被销毁了**
2. 当scope的取值为**`prototype`**时
    1. Bean的实例化个数：**多个**
    2. Bean的实例化时机：当调用getBean()方法时实例化Bean
        1. 对象创建：当使用对象时，**创建新的对象实例**
        2. 对象运行：只要对象在使用中，就一直活着
        3. 对象销毁：当对象长时间不用时，**被 Java 的垃圾回收器回收了**

---



##### Bean生命周期配置

<font color="red">**init-method：指定类中的初始化方法名称**</font>

<font color="red">**destroy-method：指定类中销毁方法名称**</font>

---



##### Bean实例化三种方式

<font color="red">	**1 无参构造方法实例化 **</font>

<font color="red">	**2 工厂静态方法实例化 **</font>

<font color="red">	**3 工厂实例方法实例化**</font>



1. **无参构造方法实例化**

```xml
<bean id="userDao" class="com.itheima.factory.StaticFactoryBean"/>
<!-- 没有无参构造时不能被创建 -->
```





2. **工厂静态方法实例化**

<font color="red">factory-method 寻找该id的静态方法 从返回值中获取对象</font>

```java
public class StaticFactoryBean {
	public static UserDao createUserDao(){
		return new UserDaoImpl();
	}
}

```

```xml
<bean id="userDao" class="com.itheima.factory.StaticFactoryBean" 
factory-method="createUserDao"/>
```



3. **工厂实例方法实例化**

<font color="red">factory-bean 寻找此id的bean对象 </font>

<font color="red">factory-method 寻找到的bean对象的id</font>

```java
public class DynamicFactoryBean {
	public UserDao createUserDao(){
		return new UserDaoImpl();
	}
}
```

```xml
<bean id="factoryBean" class="com.itheima.factory.DynamicFactoryBean"/>
<bean id="userDao" factory-bean="factoryBean" factory-method="createUserDao"/>
```

----





##### 依赖注入



###### 注入方式

![image-20220413091857306](D:\MySSM\img\md-img\image-20220413091857306.png)

![image-20220413091917185](D:\MySSM\img\md-img\image-20220413091917185.png)





<font color="red">**Bean的依赖注入概念：**</font>



**依赖注入（<font color="red">Dependency Injection</font>）：它是 Spring 框架核心 IOC 的具体实现。**



**在编写程序时，通过控制反转，把对象的创建交给了 Spring，但是代码中不可能出现没有依赖的情况。 IOC 解耦只是降低他们的依赖关系，但不会消除。例如：业务层仍会调用持久层的方法。 **



**那这种业务层和持久层的依赖关系，在使用 Spring 之后，就让 Spring 来维护了。 简单的说，就是坐等框架把持久层对象传入业务层，而不用我们自己去获取。**



![image-20220413092516763](D:\MySSM\img\md-img\image-20220413092516763.png)



**Set方式:**

```java
public class SetServiceImpl implements SetService {
    
	private SetDao setDao;
    
    public void setUserDao(SetDao setDao) {
		this.setDao = setDao;
	}
    
	@Override
	public void save() {
		setDao.save();
	}
    
}
```

```xml
<bean id="setDao" class="com.ganga.dao.impl.SetDaoImpl"></bean>
<!-- 使用property标签 -->
<bean id="setService" class="com.ganga.service.impl.SetServiceImpl">
	<property name="setDao" ref="setDao"/>
</bean>

<!--
      在setService中添加依赖关系 将setDao注入到setService
          set方法注入

      添加标签 property
              name: 该class(com.ganga.service.impl.SetServiceImpl)
                      的用于获取对象的 set...方法
                      setSetDao(SetDao setDao)方法 去掉set
                      并将第一个字母变为小写
                    即: ref="setDao"
              ref:  注入对象的bean id标识
                    即: name="setDao"
-->
```

另外还可以引入<font color="red">**p**</font>标签

``p:setDao-ref="setDao"``

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

       xmlns:p="http://www.springframework.org/schema/p"

       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--
        第一步: 在命名空间中导入p标签
                 xmlns:p="http://www.springframework.org/schema/p"
    -->


    <bean id="setDao" class="com.ganga.dao.impl.SetDaoImpl"></bean>

    <bean id="setService" class="com.ganga.service.impl.SetServiceImpl" p:setDao-ref="setDao"></bean>
    <!--
        第二步: 在setService中 设置 p:setDao-ref="setDao"

                p:后面加 对应的set方法 如:property 的 name属性
                -ref 是指set方式注入对象  [不带ref是注入的属性]
                ="注入对象的bean 的id" 如property 的 ref属性
    -->

</beans>
```

---



**构造方法注入**

```java
public class ConstructorServiceImpl implements ConstructorService {

    //创建ConstructorDao的空对象
    private ConstructorDao constructorDao;

    //无参构造方法
    public ConstructorServiceImpl(){

    }

    //有参构造
    public ConstructorServiceImpl(ConstructorDao constructorDao){
        //将参数放入constructorDao对象当中
        this.constructorDao = constructorDao;
    }

    @Override
    public void method() {
        //最后调用方法
        constructorDao.method();
    }


}
```

```xml

<bean id="constructorDao" class="com.ganga.dao.impl.ConstructorDaoImpl"></bean>

<bean id="constructorService" class="com.ganga.service.impl.ConstructorServiceImpl">
	<constructor-arg name="constructorDao" ref="constructorDao"/>
</bean>
    <!--
        在setService中添加依赖关系 将setDao注入到setService
            构造方法注入

        添加标签 constructor-arg
                    name: 指定的构造器参数名称
                    ref:  引用容器当中bean id名

    -->
```

---





###### Bean依赖注入的数据类型

上面的操作，都是注入的引用Bean，处了对象的引用可以注入，普通数据类型，集合等都可以在容器中进行注入。

注入数据的三种数据类型

<font color="red">**普通数据类型**</font>

<font color="red">**引用数据类型**</font>

<font color="red">**集合数据类型** </font>

其中引用数据类型，此处就不再赘述了，之前的操作都是对UserDao对象的引用进行注入的，下面将以set方法注入为 例，演示普通数据类型和集合数据类型的注入。





<font color="red">**普通数据类型**</font>

```xml
<!-- 以set方式注入 -->
<bean id="x01SetDao" class="com.ganga.dao.impl.X01SetDaoImpl">
    <property name="username" value="尴尬酱"/>
    <property name="age" value="9"/>
</bean>

<!-- 以构造器方式注入 -->
<bean id="x01ConstructorDao" class="com.ganga.dao.impl.X01ConstructorDaoImpl">
    <constructor-arg name="username" value="这就尴尬了"/>
    <constructor-arg name="age" value="20"/>
</bean>
```



<font color="red">**引用数据类型**</font>



<font color="red">**集合数据类型** </font>

```java
public class X03DaoImpl implements X03Dao {

    //注入List集合
    private List<String> stringList;
    private List<User> userList;
    //注入Map集合
    private Map<String, User> stringUserMap;
    //注入Properties
    private Properties properties;

    //注入List集合 set方法
    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    //注入Map集合 set方法
    public void setStringUserMap(Map<String, User> stringUserMap) {
        this.stringUserMap = stringUserMap;
    }

    //注入Properties set方法
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void method() {
        System.out.println("====== List ======");
        System.out.println(stringList);
        for (User user : userList) {
            System.out.println(user);
        }

        System.out.println("\n====== Map ======");
        System.out.println(stringUserMap);

        System.out.println("\n====== Properties ======");
        System.out.println(properties);

        System.out.println("\nrun X03DaoImpl method...");
    }
}
```

applicationContext.xml

```xml
<bean id="x03Dao" class="com.ganga.dao.impl.X03DaoImpl">

        <!--注入List数据-->
        <property name="stringList">
            <list>
                <value>亚索哥哥</value>
                <value>永恩弟弟</value>
                <value>卡特妹妹</value>
            </list>
        </property>
        <property name="userList">
            <list>
                <ref bean="user1"/>
                <ref bean="user2"/>
                <ref bean="user3"/>
                <bean class="com.ganga.pojo.User">
                    <constructor-arg name="username" value="盖伦哥哥"/>
                    <constructor-arg name="age" value="10"/>
                    <constructor-arg name="adds" value="德玛西亚"/>
                </bean>
            </list>
        </property>

        <!--Map集合注入-->
        <property name="stringUserMap">
            <map>
                <entry key="u1" value-ref="user1"/>
                <entry key="u2" value-ref="user2"/>
                <entry key="u3" value-ref="user3"/>
            </map>
        </property>

        <!--Properties注入-->
        <property name="properties">
            <props>
                <prop key="p1">亚索哥哥</prop>
                <prop key="p2">永恩哥哥</prop>
                <prop key="p3">卡特妹妹</prop>
            </props>
        </property>

    </bean>

    <!--user对象-->
    <bean id="user1" class="com.ganga.pojo.User">
        <constructor-arg name="username" value="亚索哥哥"/>
        <constructor-arg name="age" value="18"/>
        <constructor-arg name="adds" value="艾欧尼亚"/>
    </bean>
    <bean id="user2" class="com.ganga.pojo.User">
        <constructor-arg name="username" value="永恩哥哥"/>
        <constructor-arg name="age" value="16"/>
        <constructor-arg name="adds" value="艾欧尼亚"/>
    </bean>
    <bean id="user3" class="com.ganga.pojo.User">
        <constructor-arg name="username" value="卡特妹妹"/>
        <constructor-arg name="age" value="9"/>
        <constructor-arg name="adds" value="诺克萨斯"/>
    </bean>

```



######  引入其他配置文件（分模块开发）

实际开发中，Spring的配置内容非常多，这就导致Spring配置很繁杂且体积很大，所以，可以将部分配置拆解到其他 配置文件中，而在Spring主配置文件通过import标签进行加载

```XML
<import resource="applicationContext-xxx.xml"/>
```



---



### **Spring相关API**



#### ApplicationContext的继承体系

<font color="red">**applicationContext：**</font>接口类型，代表应用上下文，可以通过其实例获得 Spring 容器中的 Bean 对象



![ApplicationContext继承体系](D:\MySSM\img\md-img\ApplicationContext继承体系.png)



---



#### ApplicationContext的实现类



1. <font color="red">**ClassPathXmlApplicationContext**</font>

   ​	它是从类的根路径下加载配置文件 推荐使用这种

2. <font color="red">**ClassPathXmlApplicationContext**</font>

   ​	它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置。

3. <font color="red">**ClassPathXmlApplicationContext**</font>

   ​	当使用注解配置容器对象时，需要使用此类来创建 spring 容器。它用来读取注解。

---



#### getBean()方法使用



常用的有两个

1. 通过bean的 字符id来找 ``getBean("userDao")``

   其中，当参数的数据类型是字符串时，表示根据Bean的id从容器中获得Bean实例，返回是Object，需要强转。



2. 通过类的calss自动匹配  ``getBean(UserDao.class)``

   当参数的数据类型是Class类型时，表示根据类型从容器中匹配Bean实例，当容器中相同类型的Bean有多个时， 则此方法会报错。



---





### Spring配置数据源



#### 数据源（连接池）的作用

1. 数据源(连接池)是提高程序性能如出现的
2. 事先实例化数据源，初始化部分连接资源
3. 使用连接资源时从数据源中获取
4. 使用完毕后将连接资源归还给数据源



常见的数据源(连接池)：<font color="red">**DBCP、C3P0、BoneCP、Druid**</font>等



#### 数据源的开发步骤

1. 导入数据源的坐标和数据库驱动坐标
2. 创建数据源对象
3. 设置数据源的基本连接数据
4. 使用数据源获取连接资源和归还连接资源



#### Spring配置数据源

可以将DataSource的创建权交由Spring容器去完成

​	DataSource有无参构造方法，而Spring默认就是通过无参构造方法实例化对象的

​	DataSource要想使用需要通过set方法设置数据库连接信息，而Spring可以通过set方法进行字符串注入



**抽取jdbc配置文件**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation=
               "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 先引入context命名空间 和 约束路径 -->

    <!-- 通过Spring加载properties的方法 -->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <bean id="c3p0DataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driverClass}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.user}"/>
        <property name="password" value="${jdbc.password}"/>
    </bean>

    
</beans>
```

```properties
# jdbc.properties
jdbc.driverClass=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql:///webcase?useSSL=false&useServerPrepStmts=true
jdbc.user=root
jdbc.password=ganga
```



<font color="red">**重点: Spring容器加载properties文件**</font>

```xml
<!-- 通过Spring加载properties的方法 -->
<context:property-placeholder location="xx.properties"/>
 <!-- 可以使用el表达式获取properties文件的数据 -->
<property name="" value="${key}"/>
```

---





### Spring注解开发



Spring是轻代码而重配置的框架，配置比较繁重，影响开发效率，所以注解开发是一种趋势，注解代替xml配置 文件可以简化配置，提高开发效率。



#### Spring原始注解



<font color="red">**Spring原始注解主要是替代的配置**</font>

![原注解](D:\MySSM\img\md-img\原注解.png)



<font color="red">**注意： **</font>

​		使用注解进行开发时，需要在applicationContext.xml中配置组件扫描，作用是指定哪个包及其子包下的Bean 需要进行扫描以便识别使用注解配置的类、字段和方法。

```xml
<!--注解的组件扫描-->
<context:component-scan base-package="com.ganga"></context:component-scan>
<!-- 扫描com.ganga包及其以下包的的文件 -->
```



使用@Component或@Service标识UserServiceImpl需要Spring进行实例化

使用@Autowired或者@Autowired+@Qulifier或者@Resource进行userDao的注入

使用@Value进行字符串的注入  一般配合el表达式来体现解耦合

```java
//添加bean id="annoFirstService"
//Service层 用 @Service
@Service("annoFirstService")
public class AnnoFirstServiceImpl implements AnnoFirstService {

    //注入引用数据用Autowired
    //@Autowired
    //@Qualifier("annoFirstDao") //按照id值 从容器中进行匹配
    //不加 @Qualifier 会按照数据类型从Spring容器中进行匹配  类型为1个时可以省略
    @Resource(name = "annoFirstDao")
    //@Resource 相当于 @Autowired + @Qualifier
    private AnnoFirstDao annoFirstDao;

    //注入普通数据用@Value  一般和el表达式一起用才有价值
    @Value("${jdbc.driverClass}")
    private String driver;

    //用注解开发 不用 set方法也行
    /*public void setAnnoFirstDao(AnnoFirstDao annoFirstDao) {
        this.annoFirstDao = annoFirstDao;
    }*/

    @Override
    public void method() {
        System.out.println("-------------------------------");
        System.out.println("driver: " + driver);
        System.out.println("-------------------------------");
        annoFirstDao.method();
    }

}
```



使用@PostConstruct标注初始化方法，使用@PreDestroy标注销毁方法

```java

@PostConstruct
public void init(){
	System.out.println("初始化方法....");
}

@PreDestroy
public void destroy(){
	System.out.println("销毁方法.....");
}

```







####  Spring新注解

​	**使用上面的注解还不能全部替代xml配置文件，还需要使用注解替代的配置如下：**

1. **非自定义的Bean的配置：**``<bean>``
2. **加载properties文件的配置：**``<context:property-placeholder>``
3. **组件扫描的配置：**``<context:component-scan>``
4. **引入其他文件：**``<import>``



<font color="red">**引入Spring新注解**</font>

![新注解](D:\MySSM\img\md-img\新注解.png)

要想使用注解开发 **首先有一个核心配置类**

``SpringApplicationContext.java``

```java
package com.ganga.config;
/*

* Spring核心配置类
*
* */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 使用@Configuration 定义Spring配置类
@Configuration
// 扫描组件
@ComponentScan("com.ganga")
// 导入其他子配置类
@Import({SpringDataSourceApplicationContext.class})
public class SpringApplicationContext {

}
```



解决 非自定义的Bean的配置 创建DataSource对象

```SpringDataSourceApplicationContext.java```

```java
package com.ganga.config;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;

//需要引入properties文件
@PropertySource("classpath:jdbc.properties")
public class SpringDataSourceApplicationContext {

    //已经导入了jdbc.properties文件
    //这里直接注入数据
    @Value("${jdbc.driverClass}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    //注入自定义的Bean 用@Bean注解 注到方法上 该方法的返回值为bean的对象
    @Bean("dataSourceNew")
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

}
```

---







### Spring整合Junit



#### 原始Junit测试Spring的问题

在测试类中，每个测试方法都有以下两行代码：

```java
ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
IAccountService as = ac.getBean("accountService",IAccountService.class);
```

这两行代码的作用是获取容器，如果不写的话，直接会提示空指针异常。所以又不能轻易删掉。

**上述问题解决思路**

	1. 让SpringJunit负责创建Spring容器，但是需要将配置文件的名称告诉它
	1. 将需要进行测试Bean直接在测试类中进行注入



#### Spring集成Junit步骤

	1. **导入spring集成Junit的坐标**
	1. **使用@Runwith注解替换原来的运行期**
	1. **使用@ContextConfiguration指定配置文件或配置类**
	1. **使用@Autowired注入需要测试的对象**
	1. **创建测试方法进行测试**



<font color="red">**① 导入spring集成Junit的坐标**</font>

```xml
<!--此处需要注意的是，spring5 及以上版本要求 junit 的版本必须是 4.12 及以上-->

<!-- spring-test -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>5.3.18</version>
</dependency>

<!-- junit依赖坐标 -->
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.13.1</version>
	<!--<scope>test</scope>-->
</dependency>
```



<font color="red">**② 使用@Runwith注解替换原来的运行期**</font>

<font color="red">**③ 使用@ContextConfiguration指定配置文件或配置类**</font>

<font color="red">**④ 使用@Autowired注入需要测试的对象**</font>

<font color="red">**⑤ 创建测试方法进行测试**</font>

`SpringJunitRunTest.java`

```java
package com.ganga.test;

import com.ganga.config.SpringApplicationContext;
import com.ganga.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//第一步: 导入spring-test坐标

//第二步: 使用@Runwith注解替换原来的运行期
@RunWith(SpringJUnit4ClassRunner.class)

//第三步: 指定配置文件/配置类用 @ContextConfiguration
@ContextConfiguration(classes = {SpringApplicationContext.class} )
//@ContextConfiguration("classpath:applicationContext.xml")

public class SpringJunitRunTest {

    //第四步: 使用Autowired注入需要测试的对象
    @Autowired
    private UserService userService;

    //第五步: 创建测试方法进行测试
    @Test
    public void userServiceTest(){
        userService.SelectAll();
    }

    @Autowired
    //@Qualifier("dataSource")
    private DataSource dataSource;
    @Test
    public void dataSourceTest() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}
```

---









### Spring集成Web环境





#### ApplicationContext应用上下文获取问题

**ApplicationContext应用上下文获取方式**

![image-20220413175942469](D:\MySSM\img\md-img\image-20220413175942469.png)

**Spring提供了获取应用上下文的工具**

![image-20220413180046845](D:\MySSM\img\md-img\image-20220413180046845.png)





#### Spring集成Web环境步骤



导入Spring集成Web的坐标

```xml
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-web</artifactId>
	<version>5.3.18</version>
</dependency>
```

在web.xml中配置ContextLoaderListener监听器

```xml
<!-- Spring集成Web环境 -->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<listener>
    <!-- 添加C监听器 -->
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<!-- 即: 可以使用WebApplicationContextUtils
         的 getWebApplicationContext() 获取Spring核心容器
 -->
```

使用Spirng-web 提供的工具获取Spring核心容器

```java
//使用Spring-web 提供的工具了
ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

```



















## SpringMVC框架

<font color="red">****</font>



### SpringMVC概述

SpringMVC 是一种基于 Java 的实现 MVC 设计模型的请求驱动类型的轻量级 Web 框架，属于 SpringFrameWork 的后续产品，已经融合在 Spring Web Flow 中。



SpringMVC 已经成为目前最主流的MVC框架之一，并且随着Spring3.0 的发布，全面超越 Struts2，成为最优 秀的 MVC 框架。它通过一套注解，让一个简单的 Java 类成为处理请求的控制器，而无须实现任何接口。同时 它还支持 RESTful 编程风格的请求。



### SpringMVC快速入门

需求：客户端发起请求，服务器端接收请求，执行逻辑并进行视图跳转。

开发步骤：

	1. <font color="red">**导入SpringMVC相关坐标**</font>
	1. <font color="red">**配置SpringMVC核心控制器DispathcerServlet**</font>
	1. <font color="red">**创建Controller类和视图页面**</font>
	1. <font color="red">**使用注解配置Controller类中业务方法的映射地址**</font>
	1. <font color="red">**配置SpringMVC核心文件 spring-mvc.xml**</font>
	1. <font color="red">**客户端发起请求测试**</font>



<font color="red">**① 导入Spring和SpringMVC的坐标**</font>

<font color="red">**① 导入Servlet和Jsp的坐标**</font>

```xml
<!-- Spring/SpringMVC 框架坐标 -->

<!-- springMVC依赖坐标 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.18</version>
</dependency>
<!-- spring依赖坐标 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.18</version>
</dependency>
<!-- spring-web工具依赖坐标 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.3.18</version>
</dependency>
<!-- spring-test -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>5.3.18</version>
</dependency>

<!-- service依赖坐标 -->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>javax.servlet-api</artifactId>
	<version>4.0.1</version>
	<scope>provided</scope>
</dependency>
<dependency>
	<groupId>javax.servlet.jsp</groupId>
	<artifactId>javax.servlet.jsp-api</artifactId>
	<version>2.3.3</version>
</dependency>

<dependency>
	<groupId>javax.servlet.jsp</groupId>
	<artifactId>jsp-api</artifactId>
	<version>2.2</version>
	<scope>provided</scope>
</dependency>
```



<font color="red">**② 在web.xml配置SpringMVC的核心控制器**</font>

```xml
<!-- 第二步: 配置SpringMVC核心控制器 DispathcerServlet -->
<servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- 初始化参数配置spring-web.xml文件位置 -->
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <!-- 设置每次启动时加载该servlet服务 -->
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```



<font color="red">**③ 创建Controller和业务方法**</font>

<font color="red">**③ 创建视图页面index.jsp**</font>

<font color="red">**④ 配置注解**</font>

```java
package com.ganga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//第三步: 创建Controller类 和 视图页面
//第四步: 使用注解@Controller 将类 添加到容器当中
@Controller
public class UserController {

    //第四步: 使用注解@RequestMapping 添加请求映射
    @RequestMapping("/method")
    public String method(){
        System.out.println("UserController method run ...");
        return "index.jsp";
    }

}
```



<font color="red">**⑤ 创建spring-mvc.xml**</font>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation=
               "http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
               ">

    <!-- 第五步: 配置Spring核心文件 spring-mvc.xml -->
    <!-- 扫描controller组件 -->
    <context:component-scan base-package="com.ganga.controller"/>

    <!-- 注意: 在web.xml当中 配置此文件的参数路径！ -->

</beans>
```



<font color="red">**⑥ 访问测试地址**</font>





### SpringMVC流程视图



![image-20220413173457520](D:\MySSM\img\md-img\image-20220413173457520.png)



### SpringMVC的组件解析



#### **SpringMVC的执行流程**

![image-20220413173712264](D:\MySSM\img\md-img\image-20220413173712264.png)



① 用户发送请求至前端控制器DispatcherServlet。

② DispatcherServlet收到请求调用HandlerMapping处理器映射器。

③ 处理器映射器找到具体的处理器(可以根据xml配置、注解进行查找)，生成处理器对象及处理器拦截器(如果 有则生成)一并返回给DispatcherServlet。

④ DispatcherServlet调用HandlerAdapter处理器适配器。

⑤ HandlerAdapter经过适配调用具体的处理器(Controller，也叫后端控制器)。

⑥ Controller执行完成返回ModelAndView。

⑦ HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet。

⑧ DispatcherServlet将ModelAndView传给ViewReslover视图解析器。

⑨ ViewReslover解析后返回具体View。

⑩ DispatcherServlet根据View进行渲染视图（即将模型数据填充至视图中）。DispatcherServlet响应用户。



#### **SpringMVC 组件解析**



1. <font color="red">**前端控制器：DispatcherServlet**</font>

   ​	用户请求到达前端控制器，它就相当于 MVC 模式中的 C，DispatcherServlet 是整个流程控制的中心，由 它调用其它组件处理用户的请求，DispatcherServlet 的存在降低了组件之间的耦合性。

2. <font color="red">**处理器映射器：HandlerMapping**</font>

   ​	HandlerMapping 负责根据用户请求找到 Handler 即处理器，SpringMVC 提供了不同的映射器实现不同的 映射方式，例如：配置文件方式，实现接口方式，注解方式等。

3. <font color="red">**处理器适配器：HandlerAdapter**</font>

   ​	通过 HandlerAdapter 对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理 器进行执行。

4. <font color="red">**处理器：Handler处理器：Handler**</font>

   ​	它就是我们开发中要编写的具体业务控制器。由 DispatcherServlet 把用户请求转发到 Handler。由 Handler 对具体的用户请求进行处理。

5. <font color="red">**视图解析器：View Resolver**</font>

   ​	View Resolver 负责将处理结果生成 View 视图，View Resolver 首先根据逻辑视图名解析成物理视图名，即 具体的页面地址，再生成 View 视图对象，最后对 View 进行渲染将处理结果通过页面展示给用户。

6. <font color="red">**视图：View**</font>

   ​	SpringMVC 框架提供了很多的 View 视图类型的支持，包括：jstlView、freemarkerView、pdfView等。最 常用的视图就是 jsp。一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户，需要由程 序员根据业务需求开发具体的页面







#### SpringMVC注解解析

##### <font color="red">**@RequestMapping**</font>

![image-20220413174802168](D:\MySSM\img\md-img\image-20220413174802168.png)

```java
@Controller
/*
这里加了@RequestMapping("/web/x1")注解
    该类里的方法 是"/web/x1"的子项目
*/
@RequestMapping("/web/x1")
public class UserControllerDame02 {
    /*
    * 实际地址:http://localhost:8080/B5_SpringMVC_war/web/x1/dame02
    * */
    @RequestMapping("/dame02")
    public String method(){
        System.out.println("run UserControllerDame02 dame02 ...");
        return "/jsp/dame02.jsp";
        /*
        * 返回字符串前不加 "/"
        *   访问的资源是: http://localhost:8080/B5_SpringMVC_war/web/x1/jsp/dame02.jsp
        *
        * 返回字符串前加上 "/"
        *   访问的资源是: http://localhost:8080/B5_SpringMVC_war/jsp/dame02.jsp
        *
        * [注意!] [所以] 要访问根对应的文件 一定要加上"/"
        *
        * */
    }

}
```

---

```java
package com.ganga.controller.X1_RequestMapping注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//1. 不设置路径

@Controller()
@RequestMapping("web/x1")
public class UserControllerDame03 {

    //value = "" 服务资源路径 value可以省略
    //method = 特定的请求方式 [必须是枚举类型] [ RequestMethod.GET ] [ RequestMethod.POST ]等

    //get请求
    @RequestMapping(value = "/dame03-1",method = RequestMethod.GET)
    public String dame01() {
        System.out.println("run UserControllerDame03 dame03 ...");
        return "/jsp/dame03.jsp";
    }//访问成功

    //post请求
    @RequestMapping(value = "/dame03-2",method = RequestMethod.POST)
    public String dame02() {
        System.out.println("run UserControllerDame03 dame031 ...");
        return "/jsp/dame03.jsp";
    }//访问失败 因为这里用的是get请求 访问不了/web/x1/dame03-2

}

```

---

```java
package com.ganga.controller.X1_RequestMapping注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/x1")
public class UserControllerDame04 {

    //params = 字符数组   必须携带该字符数组中的所有参数

    @RequestMapping(value = "/dame04-1",params = {"username","id"},method = RequestMethod.GET)
    public String method1(){
        System.out.println("run UserControllerDame04-1 dame04-1 ...");
        return "/jsp/dame04-1.jsp";
    }

    /*
    *   http://localhost:8080/B5_SpringMVC_war/web/x1/dame04
    *   不可以访问
    *
    *   http://localhost:8080/B5_SpringMVC_war/web/x1/dame04?username=xxx
    *   不可以访问
    *
    *   http://localhost:8080/B5_SpringMVC_war/web/x1/dame04?username=xxx&id=xxx
    *   可以访问
    *
    *   必须要带 字符数组中的所有参数
    *
    * */

    //params = {"user!100"} user参数不能说100
    @RequestMapping(value = "/dame04-2",params = {"user!100"},method = RequestMethod.GET)
    public String method2(){
        System.out.println("run UserControllerDame04-2 dame04-2 ...");
        return "/jsp/dame04-2.jsp";
    }

}
```

---

---





##### <font color="red">**组件扫描**</font>

![image-20220413175146615](D:\MySSM\img\md-img\image-20220413175146615.png)

![组件扫描01](D:\MySSM\img\md-img\组件扫描01.png)

![组件扫描02](D:\MySSM\img\md-img\组件扫描02.png)



配置处理器适配器

```xml
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
	<property name="messageConverters">
		<list>
			<bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
			</list>
	</property>
</bean>


<!-- 上面比较繁琐 -->
<!-- 直接 -->
<!-- mvc的注解驱动 -->
<mvc:annotation-driven/>
<!--
	以后每次创建mvc的配置文件spring-mvc.xml时
	都先加上这句话
-->
```







##### <font color="red">**视图解析器**</font>

```xml
<!--配置内部资源视图解析器-->

<!-- 配置视图解析器 ViewResolver -->
<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<!-- 配置前缀 -->
	<property name="prefix" value="/jsp/"/>
	<!-- 配置后缀 -->
	<property name="suffix" value=".jsp"/>
</bean>

<!--拼接字符路径
	/jsp/xxx.jsp
	/jsp/xxx/xxx.jsp
-->
```









### SpringMVC的数据响应



#### SpringMVC的数据响应方式

![image-20220413182340971](D:\MySSM\img\md-img\image-20220413182340971.png)



#### 页面跳转

`forward: 转发`

`redirect: 重定向`

<font color="red">**直接返回字符串**</font>

```java
package com.ganga.controller.X3_SpringMVC数据响应.A页面跳转;

/*
* 返回字符串
*
* 配置ViewResolver视图解析器后
*   不需要写前缀 和 后缀
*
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/x3")
public class ReturnStringSkip {

    @RequestMapping("/dame05-1")
    public String method01(){
        System.out.println("run dame05 method01");
        return "dame05";
    }
    /*
    *   <!-- 配置视图解析器 ViewResolver -->
    *   <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    *       <!-- 配置前缀 -->
    *       <property name="prefix" value="/jsp/"/>
    *       <!-- 配置后缀 -->
    *       <property name="suffix" value=".jsp"/>
    *   </bean>
    *
    *   /jsp/ + dame05 + .jsp
    *   = /jsp/dame05.jsp
    * */


    /*
    * 源码:
    *   public static final String REDIRECT_URL_PREFIX = "redirect:";
    *   public static final String FORWARD_URL_PREFIX = "forward:";
    *
    * 不加: 默认forward: 转发
    *          redirect: 重定向
    * */
    //
    @RequestMapping("/dame05-2")
    public String method02(){
        System.out.println("run dame05 method02");
        return "redirect:http://localhost:8080/B5_SpringMVC_war/jsp/dame05.jsp";
    }
    //重定向 绝对路径

}
```





<font color="red">**通过ModerAndView**</font>

```java
package com.ganga.controller.X3_SpringMVC数据响应.A页面跳转;

/*
* 返回一个 ModelAndView对象 进行跳转视图
*
*   Model数据模型
*       addObject(key,obj)
*   View 视图页面
*       setViewName(url)
*
* */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/web/x3")
public class ReturnModelAndViewSkip {

    @RequestMapping("/dame06-1")
    public ModelAndView method01(){
        //创建ModelAndView模型
        ModelAndView modelAndView = new ModelAndView();
        //设置Model数据模型
        modelAndView.addObject("modelKey","123");
        //设置View视图页面
        modelAndView.setViewName("dame06");
        //返回此模型视图对象
        return modelAndView;
    }
    /*
    * 在这个视图文件中 用el表达式可以获取模型数据
    * */


    /**
     * Spring可以提供注入 把参数设置为注入的对象
     * @return
     */
    @RequestMapping("/dame06-2")
    public ModelAndView method02(ModelAndView modelAndView){
        /* 这里的modelAndView 是由Spring容器自动提供注入的 特性 */
        //设置Model数据模型
        modelAndView.addObject("modelKey","321");
        //设置View视图页面
        modelAndView.setViewName("dame06");
        //返回此模型视图对象
        return modelAndView;
    }

}
```





<font color="red">**上面两个进行拆分**</font>

```java
package com.ganga.controller.X3_SpringMVC数据响应.A页面跳转;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 *   ReturnModelAndViewSkip
 *   ReturnStringModelSkip
 *
 *   进行拆分
 * */
@Controller
@RequestMapping("/web/x3")
public class ReturnZStringModelSkip {

    @RequestMapping("/dame06-m")
    public String method(Model model){
        //设置模型数据
        model.addAttribute("modelKey","model...");
        //直接跳转页面字符串
        return "dame06";
    }

}
```





#### 回写数据

Web基础阶段，客户端访问服务器端，如果想直接回写字符串作为响应体返回的话，只需要使用 response.getWriter().print(“hello world”) 即可，那么在Controller中想直接回写字符串该怎样呢？

① 通过SpringMVC框架注入的response对象，使用response.getWriter().print(“hello world”) 回写数 据，此时不需要视图跳转，业务方法返回值为void。

```java
//SpringMVC框架会自动识别并注入的response对象
@RequestMapping("/quick4")
public void quickMethod4(HttpServletResponse response) throws IOException {
	response.getWriter().print("hello world");
}
```

② 将需要回写的字符串直接返回，但此时需要通过**@ResponseBody**注解告知SpringMVC框架，方法 返回的字符串不是跳转是直接在http响应体中返回。

```java
@RequestMapping("/quick5")
@ResponseBody
public String quickMethod5() throws IOException {
return "hello springMVC!!!";
}
```





<font color="red">**直接返回字符串**</font>

在异步项目中，客户端与服务器端往往要进行json格式字符串交互，此时我们可以手动拼接json字符串返回。

上述方式手动拼接json格式字符串的方式很麻烦，开发中往往要将复杂的java对象转换成json格式的字符串， 我们可以使用web阶段学习过的json转换工具jackson进行转换，导入jackson坐标。

```xml
<!--jackson-->
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-core</artifactId>
	<version>2.9.0</version>
</dependency>

<!-- json -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.0</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-annotations</artifactId>
    <version>2.9.0</version>
</dependency>
```

代码演示

```java
package com.ganga.controller.X3_SpringMVC数据响应.B回写数据;

import com.alibaba.fastjson.JSON;
import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/web/x3")
public class WriterBackAttribute {

    /*
    * 回写数据
    * */

    //过SpringMVC框架注入的response对象
    @RequestMapping("/dame08-1")
    public void me01(HttpServletResponse response) throws IOException {
        response.getWriter().print("response! me01");
    }

    //使用@ResponseBody注解
    //注解告知SpringMVC框架，方法
    //返回的字符串不是跳转是直接在http响应体中返回。
    @RequestMapping("/dame08-2")
    @ResponseBody
    public String me02(){
        /*没有参数 返回的字符串不是跳转的页面 而是回写的内容*/
        return "response! me02";
    }

    //手动回写JSON数据
    @RequestMapping("/dame08-3")
    @ResponseBody
    public String me03(){
        //手动书写JSON {"username":"ganga","age":18}
        return "{\"username\":\"ganga\",\"age\":18}";
    }

    //使用外部JSON转换工具
    @RequestMapping("/dame08-4")
    @ResponseBody
    public String me04(){
        //模拟一个对象
        User user = new User("gangajiang", 9);
        //使用json转换工具进行转换
        String json = JSON.toJSONString(user);
        return json;
    } // {"age":9,"username":"gangajiang"}

    /*
    * 上面太麻烦了
    *     SpringMVC提供了相应的机制！
    *
    * */


    //使用外部JSON转换工具
    @RequestMapping("/dame08-5")
    @ResponseBody
    public User me05(){
        System.out.println("run dame08-5 me05...");
        //模拟一个对象
        User user = new User("obg", 99);

        return user;
    }

}
```







<font color="red">**返回对象或集合**</font>

通过SpringMVC帮助我们对对象或集合进行json字符串的转换并回写，为处理器适配器配置消息转换参数， 指定使用jackson进行对象或集合的转换，因此需要在spring-mvc.xml中进行配置

在方法上添加@ResponseBody就可以返回json格式的字符串，但是这样配置比较麻烦，配置的代码比较多， 因此，我们可以使用mvc的注解驱动代替上述配置。

```xml
<!--配置处理器适配器 配置json工具-->
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
    <property name="messageConverters">
        <list>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
        </list>
    </property>
</bean>
<!-- 上面比较繁琐 -->
<!-- 直接 -->
<!-- mvc的注解驱动 -->
<mvc:annotation-driven/>
<!--
    以后每次创建mvc的配置文件spring-mvc.xml时
        都先加上这句话
-->
```

代码演示

```java
package com.ganga.controller.X3_SpringMVC数据响应.B回写数据;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web/x3")
public class WriterBackAttributeObjAndList {

    /*
    * 回写数据
    *   返回值是个对象 WriterBackAttribute 的me05演示过了
    * */
    @RequestMapping("/dame09-1")
    @ResponseBody
    public User me01() {
        //模拟一个对象
        User user = new User("obg-me01", 99);
        return user;
    }

    /*
    * 返回一个集合
    *
    *
    * */

    @RequestMapping("/dame09-2")
    @ResponseBody
    public List<User> me02() {
        //模拟一个对象集合
        List<User> users = new ArrayList<User>();
        users.add(new User("lisa", 17));
        users.add(new User("zs", 99));
        users.add(new User("ls", 66));
        return users;
    }

}

```







### SpringMVC获取请求数据



#### 获取的数据类型

![image-20220413185144429](D:\MySSM\img\md-img\image-20220413185144429.png)

#### 基本数据类型

Controller中的业务方法的参数名称要与请求参数的name一致，参数值会自动映射匹配。

```java
package com.ganga.controller.X4_SpringMVC获取请求数据.A普通数据类型;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController01 {

    @RequestMapping("/user01")
    @ResponseBody
    public String user01(String username, int age) {
        System.out.println(username + " : " + age);
        String write = "<h1 align=\"center\">getParameter: username=" + username +
                "  &  age=" + age + "</h1>";
        return write;
    }

    /*
    * 接收普通数据类型方法
    *   将方法的参数设置成为 要获取提交参数的类型 名称要一样
    *
    *   http://localhost:8080/B5_SpringMVC_war/web/x4/user01?username=ganga&age=9
    *
    *   user01(String username, int age){//...}
    *
    * */

}

```





#### 获取POJO类型参数

Controller中的业务方法的POJO参数的属性名与请求参数的name一致，参数值会自动映射匹配。

```java
package com.ganga.controller.X4_SpringMVC获取请求数据.BPOJO数据类型;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController02 {

    @RequestMapping("/user02")
    @ResponseBody
    public String user02(User user){
        System.out.println(user);
        String write = "<h1 align=\"center\">getParameter: " +user.toString() + "</h1>";
        return write;
    }

    /*
    * User实体类中的属性
    *    请求参数必须是实体类中的 成员变量(且有set方法)
    *    请求参数 ∈ 成员变量(且有set方法)
    *
    * SpringMVC会自动封装 为一个实体类的对象
    *
    * */

}

```





#### 获取数组数据类型

Controller中的业务方法数组名称与请求参数的name一致，参数值会自动映射匹配。

```java
package com.ganga.controller.X4_SpringMVC获取请求数据.C数组数据类型;

import com.ganga.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController03 {

    @RequestMapping("/user03")
    @ResponseBody
    public String user03(String[] pramName){
        List<String> strings = Arrays.asList(pramName);
        System.out.println(strings);
        return strings.toString();
    }
    //http://localhost:8080/B5_SpringMVC_war/web/x4/user03?pramName=1111111&pramName=2222222

    /*
    * 参数名称是 abc
    *
    *   (String[] abc) 参数字符数组的名字 就是 abc
    * */

}

```





#### 获取集合数据类型

```java
package com.ganga.controller.X4_SpringMVC获取请求数据.D集合数据类型;

import com.ganga.pojo.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/x4")
public class UserRequestParameterController04 {

    @RequestMapping("/user04")
    @ResponseBody
    public String user04(VO vo){
        System.out.println(vo.toString());
        return vo.toString();
    }

}
```





#### 解决请求乱码问题

当post请求时，数据会出现乱码，我们可以设置一个过滤器来进行编码的过滤。

```xml
<!-- 配置CharacterEncodingFilter监听器 -->
<filter>
	<filter-name>CharacterEncodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
        <!-- 设置字符集格式 -->
		<param-value>UTF-8</param-value>
	</init-param>
</filter>
<filter-mapping>
	<filter-name>CharacterEncodingFilter</filter-name>
    <!-- 拦截地址/* -->
	<url-pattern>/*</url-pattern>
</filter-mapping>

```











































## MyBatis框架

### 介绍
