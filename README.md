# debug_app_updater_demo
测试版本app更新demo


## 模块划分
* app 主模块
* contract 公共借口
* debug:

路由或者是服务发现，使用ARouter

debug module 只在运行时起作用，编译时不起作用，隔离性非常好，所以不用担心，一些测试工具对产品发布的影响，也不用但是，一些类引用了一些测试框架的类，导致的一些问题。

[pgyer android sdk 的集成](https://www.pgyer.com/doc/view/sdk_android_guide)