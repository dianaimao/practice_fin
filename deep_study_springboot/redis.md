# redis
+ 数据存储在内存中
+ key-value方式存储
+ 没有表结构概念，存取时需要做转换--JSON
+ 为了正确调用ReidsTemplate，初始化工作，主要对存取的字符串进行一个JSON格式的系列化初始化配置


配置redis 服务
~~~
redis-server.pdf redis.windows-service.conf
启动 并执行conf配置
~~~
