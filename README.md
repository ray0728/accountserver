![travis_ci](https://www.travis-ci.org/ray0728/accountserver.svg?branch=master)
# accountserver
## 说明
账户信息管理服务
* 通过RESTFUL接口对账户进行增删改查操作
  * 操作结果保存于MySQL当中
  * 使用Redis做MySQL二级缓存
* 除极少数[查询接口](#interface)允许匿名访问，其余接口均需要在[AuthServer][1]上验证ACCESS TOKEN

### interface
允许匿名访问的接口
* /account/info  
  查询用户信息
    * 由[AuthServer][1]发起的查询，将返回指定账户的所有信息
    * 其余会话发起的查询，仅返回账户的用户名、签名、简介、头像信息
* /account/create
  * 非ADMIN及以上权限用户（包含未登录情况）将创建GUEST级别用户
  * 拥有ADMIN及以上权限用户（需先登录）将创建USER级别用户
* /account/avatar/{uid}
  * 返回指定uid用户的头像数据

## ToDo
* 无群组管理(代码已实现，未完成测试)

## 运行方式：  
application.properties中并**不包含**完整配置信息，所以**不支持**直接运行  
* java 方式

```java
java
-Djava.security.egd=file:/dev/./urandom                  \
-Dspring.cloud.config.uri=$CONFIGSERVER_URI              \
-Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI \
-Dspring.redis.host=$REDIS_URI                           \
-Dauth-server=$AUTH_URI                                  \
-Dspring.datasource.url=$DATABASE_URI                    \
-Daccount.dir.root=$ACCOUNT_DIR                          \
-Dspring.profiles.active=$PROFILE                        \
-jar target.jar
```
* docker 方式  
建议用docker-compose方式运行

```docker
accountserver:
    image: ray0728/accountserv:1.0
    ports:
      - "10003:10003"
    environment:
      DATABASE_PORT: "3306"
      REDIS_PORT: "6379"
      ZIPKIN_PORT: "9411"
      CONFIGSERVER_PORT: "10002"
      EUREKASERVER_PORT: "10001"
      AUTH_PORT: "10004"
      RESOURCE_PORT: "10005"
      CONFIGSERVER_URI: 配置服务地址
      EUREKASERVER_URI: EUREKA地址
      AUTH_URI: AUTH服务地址
      ZIPKIN_URI: ZIPKIN地址
      REDIS_URI: REDIS服务IP
      DATABASE_URI: 数据库地址
      ACCOUNT_DIR: "/mnt/account"
      PROFILE: "dev"
    volumes:
      - /home/core/account/:/mnt/account
```  
关于Docker  
编译完成的Docker位于[Dockerhub][2]请结合Release中的[Tag标签][3]获取对应的Docker

[1]:https://github.com/ray0728/authserver
[2]:https://hub.docker.com/r/ray0728/accountserv/tags
[3]:https://github.com/ray0728/accountserver/tags
