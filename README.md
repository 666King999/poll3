# 智慧校园，课调系统API

## 开发说明

数据库相关配置 在application-dev.yml文件内
sql文件在resource文件下


以后resource文件夹下的文件不要提交了


数据库中所有的表的复数形式映射到bean时都没有s  例如  数据库表中是  options  对应的bean  Option     answers 对应的bean Answer

java文件

service接口统一命名       I(Interface首字母)+接口对应的模块+Service  如(ICourseService.java)

impl包统一命名    接口实现的模块如(CourseServiceImpl.java)

controller 包统一命名 (CourseController.java)



## 平台简介



## 内置功能




## 技术选型
springboot + mybatis