# crm客户管理系统

这是一个基于纯Servlet的课程设计的作品，实现的是仅仅是一套crm（客户关系管理系统）完整流程中的一小部分功能。

**大家不要小看了crm系统的代码工作量了，仅是这一个子功能【仅仅是】，我们小组的成员提交了一百多次，拼了老命才将其完成，真的非常辛苦。不信大家可以试试实现一套crm系统的流程。**



# 编译项目

## 导入数据库

项目使用的是**MySQL**数据库，数据文件在`src\main\resources`下的`CRM.sql`。

## jndi配置  

我们使用了c3p0作为数据源，同时学习了jndi的使用；需要将jdni目录下所有的jar包拷贝到tomcat的lib目录下，并且修改tomcat的`conf/context.xml`，添加节点

```xml
	<Resource auth="Container" 
		name="jdbc/c3p0"
		driverClass="com.mysql.jdbc.Driver"
		maxPoolSize="10"
		idleConnectionTestPeriod="60"
		minPoolSize="10"
		acquireIncrement="2"
		user="root" 
		password="root" 
		factory="org.apache.naming.factory.BeanFactory"
		type="com.mchange.v2.c3p0.ComboPooledDataSource"
		jdbcUrl="jdbc:mysql://localhost:3306/crm?characterEncoding=utf-8" 
/>
```  

如果不想用jndi，可以自行修改`src\main\java\com\oraclewdp\crm\util\JdbcUtil.java`

## 编译  

项目使用的是Maven，故配置好Maven可用maven命令编译。也可以导入到Eclipse或者Intellj IDEA中编译。
