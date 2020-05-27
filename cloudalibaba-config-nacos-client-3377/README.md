Nacos 持久化目前仅支持mysql 5.6.5+，如果是MySQL8的话，需要clone源码修改。
参考博客：
【链接】Nacos配置MySQL8.0持久化
https://www.cnblogs.com/pettyfer/p/12263751.html

#或者

nacos-server.jar
1、nacos1.2.0默认只支持MySQL5，不支持MySQL8，所以需要修改源代码自己编译

2、源代码地址：https://github.com/alibaba/nacos.git

3、修改代码：

(1)pom.xml

<dependency>
<groupId>commons-dbcp</groupId>
<artifactId>commons-dbcp</artifactId>
<version>1.4</version>
</dependency>
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>5.1.34</version>
</dependency>
改为

<dependency>
<groupId>org.apache.commmons</groupId>
<artifactId>commons-dbcp2</artifactId>
<version>2.7.0</version>
</dependency>
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.16</version>
</dependency>
(2)api/pom.xml、client/pom.xml、common/pom.xml

<configuration>
<source>6</source>
<target>6</target>
</configuration>
改为

<configuration>
<source>1.8</source>
<target>1.8</target>
</configuration>
(3)config/pom.xml

<dependency>
<groupId>commons-dbcp</groupId>
<artifactId>commons-dbcp</artifactId>
</dependency>
改为

<dependency>
<groupId>org.apache.commons</groupId>
<artifactId>commons-dbcp2</artifactId>
</dependency>
(4)com.alibaba.nacos.config.server.service.BaseDataSourceServiceImpl.java、com.alibaba.nacos.config.server.service.LocalDataSourceServiceImpl.java

import org.apache.commons.dbcp.BasicDataSource; ds.setMaxActive ds.setMaxWait
改为

import org.apache.commons.dbcp2.BasicDataSource; ds.setMaxTotal ds.setMaxWaitMillis
(5)console/src/main/resources/META-INFO/nacos-default.properties

db.url.0=jdbc:mysql://11.162.196.161:3306/diamond_devtest?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.url.1=jdbc:mysql://11.163.152.91:3306/diamond_devtest?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
改为

db.url.0=jdbc:mysql://11.162.196.161:3306/diamond_devtest?serverTimezone=GMT%2B8characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
db.url.1=jdbc:mysql://11.163.152.91:3306/diamond_devtest?serverTimezone=GMT%2B8characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true
(6)com.alibaba.nacos.naming.healthcheck.MysqlHealthCheckProcessor.java

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
改为

import com.mysql.cj.jdbc.MysqlDataSource;
4、编译打包

根目录下的BUILDING文件有详细说明。

mvn -Prelease-nacos -Dmaven.test.skip=true clean install -U
编译成功后，从distribution/target/nacos-server-1.2.0/nacos/target文件夹拷取目标文件nacos-server.jar


##问题记录
在clone了Nacos源码后，修改了相关文件后，本地编译执行的时候，编译失败，均为PMD验证失败。
这时可以查看日志中pmd.xml文件。文件会显示问题类及相关位置，修改后，在执行编译即可。

##修改配置文件，使Nacos数据库修改为mysql

只需要修改application.properties即可


#nacos集群部署的各种小坑
https://www.cnblogs.com/brightfang/p/12543860.html
<br>
 首先，集群配置报错先查看日志文件nacos目录下的logs



 

说几个新手经常遇到的玄学问题（我就是新手！嘿嘿）

启动集群失败，发现nacos端口号不是./start.sh -p ****后面你配置的端口（集群启动端口号为 8848）

比如这样



 

 端口是默认的8848，好嘛那就恭喜你，估计是被网上的半桶水教程坑了

解决方法1：

切换至nacos目录

vim bin/start.sh

首先这里看看有没有问题，用于指定启动的nacos端口号



 

 然后

接收用的部分



 

 给他移到这里来

不要放在nohup里面（就是文件末尾）我虽然不太懂shell，但是逻辑还是看得懂这个地方判断你的启动模式很明显else后面是集群模式带的参数

 

 

 

 

注意：这个问题也麻烦（naming-raft日志中出现no leader is available now）



集群内部是通过网卡地址通信，不是127.0.0.1这个回路地址，通过hostname -i取得本机ip



丢这里ok。

如果还是不行

修改你的主机名和hosts

hostname 主机名

vi /etc/hosts

末尾添加  主机名 你的内网ip（就是刚刚hostname -i出来那个）

 

最大的坑！！！！

 

nacos集群如果启动失败在start。out文件中出现

error='Cannot allocate memory' (errno=12)
或者

error='Cannot commite memory' (errno=12)
注意你的linux2G内存足够跑3个nacos

出现这种问题就是start.sh文件中的集群启动是内存配置有问题

 



 

 调整-Xms -Xmx -Xmn这三个，内存小整的跟我一样就行