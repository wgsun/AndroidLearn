package com.examply.javacore.reflex;

import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wgsun
 * @descrbe 反射测试类
 * @since 2021/2/2 14:03
 */
public class Test {

    public static final String TAG = Test.class.getSimpleName();

    /**
     *  通过反射来获取类的基本信息
     * @throws Exception
     */
    private void infoTest() throws Exception{
        //下面代码可以获取ClassTest对应的Class
        Class<ClassTest> clazz = ClassTest.class;
        //获取该Class对象所对应类的全部构造器
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Log.d(TAG, "ClassTest全部构造器如下");
        for (Constructor c : constructors) {
            Log.d(TAG, c.toString());
        }
        //获取该Class对象所对应类的全部public构造器
        Constructor<?>[] constructorsPublic = clazz.getConstructors();
        Log.d(TAG, "ClassTest的全部public构造器如下：");
        for (Constructor c : constructorsPublic) {
            Log.d(TAG, c.toString());
        }
        //获取该Class对象所对应类的全部public方法
        Method[] methods = clazz.getMethods();
        Log.d(TAG, "ClassTest的全部public方法如下：");
        for (Method method : methods) {
            Log.d(TAG, method.toString());
        }
        //获取该Class对象所对应类的指定方法
        Log.d(TAG, "ClassTest里带一个字符串参数的info方法为："
                + clazz.getMethod("info" , String.class));
        //获取该Class对象所对应类的上的全部注释
        Annotation[] annotations = clazz.getAnnotations();
        Log.d(TAG, "ClassTest的全部Annotattion如下：");
        for (Annotation annotation : annotations) {
            Log.d(TAG, annotation.toString());
        }
        Log.d(TAG, "该Class元素上的@SuppressWarnings注释为："
                + clazz.getAnnotation(SuppressWarnings.class));
        //获取该Class对象所对应类的全部内部类
        Class<?>[] inners = clazz.getDeclaredClasses();
        Log.d(TAG, "ClassTest的全部内部类如下：");
        for (Class c : inners) {
            Log.d(TAG, c.toString());
        }
        //使用Class.forName方法加载ClassTest的Inner内部类
        Class<?> inClazz = Class.forName("com.examply.javacore.reflex.ClassTest$Inner");
        //通过getDeclaringClass()访问该类所在的外部类
        Log.d(TAG,"inClazz对应类的外部类为：" +
                inClazz.getDeclaringClass());
        Log.d(TAG, "ClassTest的包为：" + clazz.getPackage());
        Log.d(TAG, "ClassTest的父类为：" + clazz.getSuperclass());
    }

    /**
     * 使用反射生成并操作对象
     */
    //定义一个创建对象的方法，
    //该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象
    private Object createObject(String clazzName)
            throws InstantiationException , IllegalAccessException
            ,ClassNotFoundException
    {
        //根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);
        //使用clazz对应类的默认构造器创建实例
        return clazz.newInstance();
    }

    /**
     * 通过反射调用方法
     */
    private void methodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassTest classTest = new ClassTest();
        Class<? extends ClassTest> clazz = classTest.getClass();
        Method m1 = clazz.getDeclaredMethod("info");
        Method m2 = clazz.getDeclaredMethod("info", String.class);
        m1.invoke(classTest);
        m2.invoke(classTest, "methodTest");
    }

    /**
     *  通过反射访问属性
     */
    private void fieldTest() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        Class<Person> personClazz = Person.class;
        //获取Person类名为name的属性
        //使用getDeclaredField，表明可获取各种访问控制符的field
        Field nameField = personClazz.getDeclaredField("name");
        //设置通过反射访问该Field时取消访问权限检查
        nameField.setAccessible(true);
        //调用set方法为person对象的指定Field设置值
        nameField.set(person, "Lelei");
        Field ageField = personClazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person, 30);
        Log.d(TAG, "fieldTest result =" + person.toString());
    }

    /**
     * 通过反射操作数组
     */

    /**
     * 通过反射来获取泛型的信息
     */

    public void test() throws Exception {
        infoTest();
        createObject("com.examply.javacore.reflex.ClassTest");
        methodTest();
        fieldTest();
    }

}
