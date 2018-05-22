# debug_app_updater_demo
测试版本app更新demo

# demo的运行方式
* git clone demo
* 运行 "git submodule update --init" 下载子模块
* 获取pgyer 的appkey,apikey ,user key ,参考 [debug_app_updater](https://github.com/pokercc/debug_app_updater)的简单使用，改好配置文件
* 在本工程的根目录执行 "sh ./upload" 进行测试


## 模块划分
* app 主模块
* contract 公共借口
* debug:

路由或者是服务发现，使用[ARouter](https://github.com/alibaba/ARouter)

debug module 只在运行时起作用，编译时不起作用，隔离性非常好，所以不用担心，一些测试工具对产品发布的影响，也不用担心，一些类引用了一些测试框架的类，导致的一些问题。
关键代码在app module的build.gradle:
```

dependencies {
    debugRuntimeOnly project(':debug')
}
```
## 参考文档
* [pgyer android sdk 的集成](https://www.pgyer.com/doc/view/sdk_android_guide)