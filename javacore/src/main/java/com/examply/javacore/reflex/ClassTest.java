package com.examply.javacore.reflex;

import android.util.Log;

/**
 * @author wgsun
 * @descrbe
 * @since 2021/2/2 13:57
 */
@SuppressWarnings(value="unchecked")
@Deprecated
public class ClassTest {

    public static final String TAG = ClassTest.class.getSimpleName();
    //定义一个私有的构造器
    public ClassTest() {
    }

    //定义一个有参数的构造器
    public ClassTest(String name) {
        Log.d(TAG, "执行有参数的构造器");
    }

    //定义一个无参数的info方法
    public void info() {
        Log.d(TAG, "执行无参数的info方法");
    }

    public void info(String str) {
        Log.d(TAG, "执行有参数的info方法" + "， 其str参数值：" + str);
    }

    //定义测试用的内部类
    class Inner{

    }
}
