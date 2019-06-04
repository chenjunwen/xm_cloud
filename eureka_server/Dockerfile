FROM java:8

MAINTAINER "chenjunwen" <chenjunwenchn@qq.com>

# 设置时区
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone
#设置容器挂载卷
VOLUME /temp

ADD ./target/eureka_server-0.0.1-SNAPSHOT.jar ./eureka_server.jar

EXPOSE 9527
#为了缩短 Tomcat 的启动时间，添加java.security.egd的系统属性指向/dev/urandom作为 ENTRYPOINT
CMD java -Djava.security.egd=file:/dev/./urandom -jar /eureka_server.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka_server.jar"]






#FROM java:8
#
#MAINTAINER "chenjunwenchn"<952408421@qq.com>
#
#RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
#
#RUN mkdir -p /xel-eureka
#
#WORKDIR /xel-eureka
#
#ADD ./target/eureka_server-0.0.1-SNAPSHOT.jar app.jar
#
#EXPOSE 8080
#
#CMD java -Djava.security.egd=file:/dev/./urandom -jar app.jar


#打包并运行命令  docker build -t eureka_server:1 . && docker run -p 8089:8762 --name eureka_server eureka_server:1
