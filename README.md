# mail-service
继承docker的邮件服务

### 部署详情
将项目放置服务器
服务器环境 JDK1.8 maven docker
mvn clean package docker:build 
打包如果能成功拉取镜像，如果不能手动构建
去classes目录下，docker文件
docker build -t mail-service .
构建镜像
docler pull  mail-service
拉取镜像
docker run -d --name mailService -p 10086:10086 
运行镜像，恭喜你可以访问了。