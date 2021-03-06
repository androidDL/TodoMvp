[![](https://img.shields.io/badge/faken-lcp-green)](https://www.google.com)


# TodoMvp
学习官方的mvp例子，并添加自己的理解

MVC：xml文件作为View，Activity、Fragment作为Controller，Model是数据处理层，使得Activity或者Fragment过于臃肿，难以复用，耦合性太高，一个Activity的代码成百上千行，不利于维护

MVP：xml、Activity、Fragment作为View层，只负责展示数据，当需要更新数据时，从其中持有的Presenter引用去更新数据，当Presenter获取到新数据或者获取失败时，Presenter根据它持有的View引用去更新界面。
所以MVP将处理逻辑放到了Presenter层，解放了Activity、Fragment。View只和Presenter交互，不与Model层直接交互。当然因为Presenter持有View的引用

官方例子Todo-Mvp-kotlin理解：
1.首先定义一个BaseView，定义基本的View层操作。持有Presenter的一个属性
2.然后定义个BasePresenter，定义基本的Presenter层操作，比如定义一个start方法，当View层生命周期开始的时候，调用Presenter.start方法，初始化Presenter
3.定义一个Contract，里面有View和Presenter，分别继承自BaseView和BasePresenter
比如对于MainActivity，就定义一个MainContract，然后再新建一个类MainPresenter:MainContract.Presenter。
MainActivity继承MainContract.View，在onCreate方法中初始化MainPresenter，此时MainPresenter就和MainView互相引用，可以相互操作了。

目前项目中，不定义MainContract类。直接新建一个IMainView的接口，里面定义需要的操作，然后Activity或者Fragment继承实现即可。
MainPresenter可以不定义接口类IMainPresenter，直接使用class实现，然后与MainActivity互相引用即可。
