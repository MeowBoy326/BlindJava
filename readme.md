## 概述

- `BlindJava`是一个java源代码混淆工具，它可以针对java maven工程项目的源代码文本进行代码混淆，最后生成混淆后的java源代码maven工程文件

## 特性

- 支持完整maven项目的源代码混淆，非`.java`文件保留，例如`.yml` `.properties` `.xml` `.sh` `.bat`都可以维持原样保留 ，`.java`文件会进行代码混淆
- 支持maven多模块项目混淆，比如SpringCloud项目，如果多模块之间存在依赖关系，也可以混淆，比如A依赖B， B依赖C， D依赖C，可以同时对ABCD四个模块进行代码混淆。
- 支持指定代码不混淆，比如Springboot项目，对mybatis相关的mapper接口、java entity实体类不混淆

## 效果展示

![](https://freakchicken.gitee.io/images/blindjava/demo.png)

## 官方文档

<p align="center">
	👉 <a target="_blank" href="https://blindjava.51dbapi.com">https://blindjava.51dbapi.com</a>  👈
</p>
