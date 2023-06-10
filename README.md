# intelligent order system

## Setup the Project

1. Git clone git@github.com:Imagine9575/order_system.git
2. Change the project structure in JetBrains Idea to jdk1.8
3. New module
   1. Choose spring initializer
   2. Choose jdk1.8
   3. Set pom.xml in the module as follows
      1. Change the artifactId label to project name (12nd lines)
      2. Add <module>project name</module> to the parent project modules tab

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>order-system</artifactId>
        <groupId>com.example</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>demo</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
    </dependencies>

</project>
```

## Function Modules
<!-- 
* images
  * 用途：图片上传到服务器，返回图片 url
* kitchen
  * 用途：后厨管理
    * 实时公告页面
    * 订单详情页面
    * 消息编辑页面
* admin
  * 用途：餐厅管理员
    * 员工管理页面
    * 菜单管理页面
    * 订单管理页面
    * 历史经营数据
    * 展示与更改信息页面
* waiter
  * 用途：餐厅服务员
    * 查看实时公告
    * 点餐
    * 待结算订单
    * 传菜消息
    * 后厨消息
    * 查看菜品
* menu
  * 用途：动态菜单设计
    * 管理员菜单
    * 服务员菜单
    * 后厨菜单 
-->
* images
  * Purpose: Upload images to the server and receive the image URL.
* kitchen
  * Purpose: Back kitchen management.
    * Real-time bulletin page.
    * Order details page.
    * Message editing page.
* admin
  * Purpose: Restaurant administrator.
    * Employee management page.
    * Menu management page.
    * Order management page.
    * Historical business data.
    * Display and modification information page.
* waiter
  * Purpose: Restaurant waiter.
    * View real-time bulletin.
    * Place orders.
    * Pending settlement orders.
    * Serving messages.
    * Back kitchen messages.
    * View dishes.
* menu
  * Purpose: Dynamic menu design.
    * Administrator menu.
    * Waiter menu.
    * Back kitchen menu.

---

## Project Overview
<!-- 
* 登录
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/2.png)
* 管理员模块
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/1.png)
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/3.png)
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/10.png)
* 后厨模块
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/20.png)
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/21.png)
* 服务员模块
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/40.png) 
-->

* Login
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/2.png)

* Administrator Module
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/1.png)
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/3.png)
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/10.png)

* Kitchen Module
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/20.png)
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/21.png)

* Waiter Module
  ![img](https://github.com/Hello-Imagine/order_system/blob/main/images/40.jpg)
