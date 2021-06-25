# springboot-common-scaffolds

SpringBoot API 脚手架

## 简介

这是一个基于`SpringBoot 2.5.1`，用于搭建`RESTful API`工程的脚手架，快速上手开发业务

## 快速开始

1. 构建数据库 'src/main/resources/sql/shiro.sql'
2. 运行`MyApplication`
3. 浏览器访问`http://localhost:8080/scaffolds/doc.html`测试接口
4. 开始编写业务代码

## 基本功能

- 封装了 RESTful 风格的返回结果
- 全局接管异常，并使用 RESTful 风格返回异常信息
- 集成了常用的库，详见相关依赖
- 集成了 MybatisPlus
- 集成了shiro

## 相关依赖

- SpringBoot
- MybatisPlus
- lombok
- shiro
- jackson
- druid