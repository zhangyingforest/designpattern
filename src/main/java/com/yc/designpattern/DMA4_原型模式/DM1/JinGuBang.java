package com.yc.designpattern.DMA4_原型模式.DM1;

import java.io.Serializable;

//金箍棒
public class JinGuBang implements Serializable {
    public float h = 100;
    public float d = 10;

    public void big(){
        this.d *= 2;
        this.h *= 2;
    }

    public void small(){
        this.d /= 2;
        this.h /= 2;
    }

    @Override
    public String toString() {
        return "JinGuBang{" +
                "h=" + h +
                ", d=" + d +
                '}';
    }
}
