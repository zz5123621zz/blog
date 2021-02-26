package com.google.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class Cats {

    private String name, sex, owner;
    private int ageByMonth;

    @Override
    public String toString() {
        return owner + "的猫'" +
                name + "'是" +
                sex + "的, 今年有'" +
                ageByMonth + "'个月大了,住在" +
                community
                ;
    }

    // 无参构造，是java默认创建的，隐藏的
    //只要创建类，就会存在无参构造方法（无参构造器）
    public Cats() {

    }

    // 有参构造,如果只写有参构造，会覆盖掉无参构造，造成报错（）
    public Cats(String owner, String name, String sex, int ageByMonth) {
        this.owner = owner;
        this.name = name;
        this.sex = sex;
        this.ageByMonth = ageByMonth;
    }

    // 使用lombok插件以后，不需要再手动写getter setter
    public void setAgeByMonth(int ageByMonth) {
        // 对用户输入的ageByMonth值进行合法性判断
        // 如果不合法，直接返回0,并提示用户输入错误
        if (ageByMonth < 0 || ageByMonth > 120) {
            System.out.println("您输入的数据不合法，已经默认清零");
            this.ageByMonth = 0;
        } else {
            this.ageByMonth = ageByMonth;
        }
    }

    public void eat() {
        System.out.println(this.owner + "的猫'" + this.name + "'在吃饭");
    }

    public void play() {
        System.out.println(this.owner + "的猫'" + this.name + "'在乱几把跑");
        this.eat();
    }

    // 静态变量 community
    private static String community = "滨湖新村";

    // 定义一个静态方法 inject
    public static void inject() {
        class Inside{
            //方法内部类，只能在这个方法里用
        }
        System.out.println(community + "里所有的猫，在5月前都要去打疫苗");
    }
    public static String getCommunity(){
        return community;
    }

}
