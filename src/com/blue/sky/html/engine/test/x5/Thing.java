package com.blue.sky.html.engine.test.x5;

/**
 * Created by caoli on 15/11/14.
 */
public class Thing {

    String name, rank, serial;
    boolean isActive;
    double pi = Math.PI;
    Thing boss;

    public Thing(String name, String rank, String serial)
    {
        this.name = name;
        this.rank = rank;
        this.serial = serial;
        this.isActive = true;
    }

    public void setBoss(Thing boss)
    {
        this.boss = boss;
    }
}
