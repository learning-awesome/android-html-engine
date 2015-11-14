package com.blue.sky.html.engine.test.x5;

import java.io.Serializable;

/**
 * Created by caoli on 15/11/14.
 */
public class ThingBean implements Serializable{
    private String name, rank, serial;
    private boolean isActive;
    private double pi = Math.PI;
    private ThingBean boss;

    public ThingBean() {}

    public String getName()
    {
        return this.name;
    }

    public String getRank()
    {
        return this.rank;
    }

    public String getSerial()
    {
        return this.serial;
    }

    public boolean isActive()
    {
        return this.isActive;
    }

    public double getPi()
    {
        return this.pi;
    }

    public ThingBean getBoss()
    {
        return this.boss;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    public void setSerial(String serial)
    {
        this.serial = serial;
    }

    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public void setPi(double pi)
    {
        this.pi = pi;
    }

    public void setBoss(ThingBean boss)
    {
        this.boss = boss;
    }

}
