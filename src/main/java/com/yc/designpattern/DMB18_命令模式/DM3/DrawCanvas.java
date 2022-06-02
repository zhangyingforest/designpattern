package com.yc.designpattern.DMB18_命令模式.DM3;

import java.awt.*;

/**
 * @project: design-patterns
 * @description: 实现"绘制对象"的类,充当接收者
 */
public class DrawCanvas extends Canvas implements Drawable {

    //颜色
    private Color color = Color.green;
    //要绘制的圆点半径
    private int redius = 5;
    //命令的历史记录
    private MacroCommand history;

    //构造函数
    public DrawCanvas(int width, int height, MacroCommand history) {
        this.setSize(width, height);
        this.setBackground(Color.white);
        this.history = history;
    }

    //重新全部绘制
    public void repaint(Graphics graphics) {
        history.execute();
    }

    //绘制
    @Override
    public void draw(int x, int y) {
        Graphics graphics = getGraphics();
        graphics.setColor(color);
        graphics.fillOval(x - redius, y - redius, redius * 2, redius * 2);
    }
}
