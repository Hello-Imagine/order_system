# order_system
大三下春季学期项目实训



使用方式

1. git clone git@github.com:Imagine9575/order_system.git
2. idea 中 project structure 更改为 jdk1.8
3. new module
   1. 选择 spring initializer
   2. 选择 jdk1.8
   3. 更改 module 中 pom.xml（样例如下）
      1. 更改 artifactId 标签为项目名称（12 行）
      2. 父项目 modules 标签中添加 <module>项目名称</module>



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



---

#### 模块

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

---

# 页面展示

* 登录
  * ![img](C:\Users\曾平\AppData\Roaming\Typora\typora-user-images\263394FBE846B93707555B07B73BACDF.png)
* 管理员模块
  * ![InkedQQ图片20220311165832_LI](C:\Users\曾平\AppData\Roaming\Typora\typora-user-images\InkedQQ图片20220311165832_LI.jpg)
  * ![img](C:\Users\曾平\AppData\Roaming\Typora\typora-user-images\BA1B5419FC64A63327B86B4417513B8B.png)
* 服务员模块
  * <img src="C:\Users\曾平\AppData\Roaming\Typora\typora-user-images\559933E54415027EB4BF9ED2E980E60B.jpg" alt="img" style="zoom: 25%;" />
* 后厨模块