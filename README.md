# 2020.6.1完结


#记录一下遇到的几个问题：

##seata配置后，事务无效的处理
查看cloudalibaba-seata-order-service-2001工程中的，README.md文件有说明

##修改nacos源码，打包生成对mysql8支持的jar
查看cloudalibaba-config-nacos-client-3377工程中的，README.md文件有说明


#文档说明

##sql文件夹说明
1.nacos_cofig.sql：这个是nacos作为配置中心的时候，连接数据库做持久化是需要的数据库脚本，原脚本在nacos压缩包的conf文件夹里
2.seata.sql：这个是seata-server端需要的操作数据库
3.seata-account/seata-order/seata-storage：这三个是测试使用的三个业务数据库