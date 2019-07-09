# AIDLDemo
介绍IPC跨进程通信方式AIDL的使用步骤和实现方法，可以很快学习AIDL这个跨进程通信知识点

实现AIDL跨进程通信步骤：
1、创建Parcelable实体类
2、在main目录下新建aidl文件夹，并在这个文件夹下新建所需的.aidl文件（实体类的.aidl+业务所需的.aidl）
3、创建Service，并在该Service中声明IBinder对象并创建一个Bider对象
3、在Activity中创建ServerConnection对象，并在onServiceConnected()中获取业务AIDL对象，获取这个对象后可以调用该对象中定义的方法
4、绑定服务
5、在onDestroy()中解绑服务
