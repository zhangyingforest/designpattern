package com.yc.designpattern.DMB18_命令模式.DM3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * @project: design-patterns
 * @description: 客户端测试类
 */
public class ClientTest extends JFrame {

    /*
    设计一个画图软件,既用户可以通过拖动鼠标在画板上画画,点击 clear 按钮时会擦除画板上的痕迹.
     */

    //绘制的历史记录
    private MacroCommand history = new MacroCommand();
    //绘制区域(设置画板大小)
    private DrawCanvas canvas = new DrawCanvas(600, 400, history);
    //删除按钮
    private JButton clearButton = new JButton("clear");

    public ClientTest(String title) {
        super(title);

        /*
        鼠标拖动事件
         */
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Command command = new DrawCommand(canvas, e.getPoint());
                history.append(command);
                command.execute();
            }
        });

        /*
        动作监听事件
         */
        clearButton.addActionListener(e -> {
            if (e.getSource() == clearButton) {
                history.clear();
                canvas.repaint();
            }
        });

        /*
        JFrame面板配置
         */
        setLayout(new BorderLayout());
        add(clearButton, BorderLayout.NORTH);
        add(canvas, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClientTest("a simple drawing board");
    }

}
