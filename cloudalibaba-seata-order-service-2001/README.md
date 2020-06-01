#修改seata支持mysql8

seata默认使用的是mysql5.1.30，不支持mysql8。<br>
所以需要做一定的配置修改，以支持mysql8.

1.file.conf
```
driver-class-name = "com.mysql.cj.jdbc.Driver"
url = "jdbc:mysql://ip:3306/seata?serverTimezone=UTC"
```
2.seata默认不支持mysq8，需要替换lib包下面的jar
```
mysql-connector-java-8.0.17.jar
```


#seata配置完以后事务不回滚问题记录
我这里是因为没有更换SpringBoot的默认数据源，导致事务回滚失败，添加了 DataSourceConfiguration.java之后，就没问题了
