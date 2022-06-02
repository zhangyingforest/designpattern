package com.yc.designpattern.DMB16_迭代子模式.DM2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @program: design-pattern-yc
 * @description: 使用迭代器模式实现一个风景图片浏览
 * @author: zy
 * @create: 2022-05-16 09:43
 */
public class PictureIterator {
    public static void main(String[] args) {
        new PictureFrame();
    }
}

//相框类
class PictureFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    ViewSpotSet ag; //婺源景点集接口
    ViewSpotIterator it; //婺源景点迭代器接口
    WyViewSpot ob;    //当前显示 婺源景点类

    /**
     * 构造方法中完成数据的初始化.
     */
    PictureFrame() {
        super("中国最美乡村“婺源”的部分风景图");
        this.setResizable(false);
        //集合的初始化
        ag = new WyViewSpotSet();
        ag.add(new WyViewSpot("江湾",
                "江湾景区是婺源的一个国家5A级旅游景区，景区内有萧江宗祠、永思街、滕家老屋、婺源人家、乡贤园、百工坊等一大批古建筑，精美绝伦，做工精细。"));
        ag.add(new WyViewSpot("李坑",
                "李坑村是一个以李姓聚居为主的古村落，是国家4A级旅游景区，其建筑风格独特，是著名的徽派建筑，给人一种安静、祥和的感觉。"));
        ag.add(new WyViewSpot("思溪延村",
                "思溪延村位于婺源县思口镇境内，始建于南宋庆元五年（1199年），当时建村者俞氏以（鱼）思清溪水而名。"));
        ag.add(new WyViewSpot("晓起村",
                "晓起有“中国茶文化第一村”与“国家级生态示范村”之美誉，村屋多为清代建筑，风格各具特色，村中小巷均铺青石，曲曲折折，回环如棋局。"));
        ag.add(new WyViewSpot("菊径村",
                "菊径村形状为山环水绕型，小河成大半圆型，绕村庄将近一周，四周为高山环绕，符合中国的八卦“后山前水”设计，当地人称“脸盆村”。"));
        ag.add(new WyViewSpot("篁岭",
                "篁岭是著名的“晒秋”文化起源地，也是一座距今近六百历史的徽州古村；篁岭属典型山居村落，民居围绕水口呈扇形梯状错落排布。"));
        ag.add(new WyViewSpot("彩虹桥",
                "彩虹桥是婺源颇有特色的带顶的桥——廊桥，其不仅造型优美，而且它可在雨天里供行人歇脚，其名取自唐诗“两水夹明镜，双桥落彩虹”。"));
        ag.add(new WyViewSpot("卧龙谷",
                "卧龙谷是国家4A级旅游区，这里飞泉瀑流泄银吐玉、彩池幽潭碧绿清新、山峰岩石挺拔奇巧，活脱脱一幅天然泼墨山水画。"));

        it = ag.iterator(); //获取婺源景点迭代器
        ob = it.first();  //取第一个景点的信息

        this.showPicture(ob.getName(), ob.getIntroduce());
    }

    //显示图片
    void showPicture(String Name, String Introduce) {
        Container cp = this.getContentPane();
        JPanel picturePanel = new JPanel();
        JPanel controlPanel = new JPanel();
        String FileName="Picture\\"+Name+".jpg";
        JLabel lb = new JLabel(Name, new ImageIcon(FileName), JLabel.CENTER);
        JTextArea ta = new JTextArea(Introduce);
        lb.setHorizontalTextPosition(JLabel.CENTER);
        lb.setVerticalTextPosition(JLabel.TOP);
        lb.setFont(new Font("宋体", Font.BOLD, 20));
        ta.setLineWrap(true);
        ta.setEditable(false);
        //ta.setBackground(Color.orange);
        picturePanel.setLayout(new BorderLayout(5, 5));
        picturePanel.add("Center", lb);
        picturePanel.add("South", ta);

        JButton first, last, next, previous;
        first = new JButton("第一张");
        next = new JButton("下一张");
        previous = new JButton("上一张");
        last = new JButton("最末张");

        //四个按钮绑定点击事件
        first.addActionListener(this);
        next.addActionListener(this);
        previous.addActionListener(this);
        last.addActionListener(this);

        controlPanel.add(first);
        controlPanel.add(next);
        controlPanel.add(previous);
        controlPanel.add(last);
        cp.add("Center", picturePanel);
        cp.add("South", controlPanel);
        this.setSize(630, 550);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        //获取点击的按钮.
        String command = arg0.getActionCommand();
        if (command.equals("第一张")) {
            ob = it.first();   //调用迭代器的first()取第一个风景
            this.showPicture(ob.getName(), ob.getIntroduce());
        } else if (command.equals("下一张")) {
            ob = it.next();
            this.showPicture(ob.getName(), ob.getIntroduce());
        } else if (command.equals("上一张")) {
            ob = it.previous();
            this.showPicture(ob.getName(), ob.getIntroduce());
        } else if (command.equals("最末张")) {
            ob = it.last();
            this.showPicture(ob.getName(), ob.getIntroduce());
        }
    }
}

/**
  实体类: 婺源景点类,用于存到集合.
 */
class WyViewSpot {
    private String Name;  //景点名
    private String Introduce;  //景点介绍

    WyViewSpot(String Name, String Introduce) {
        this.Name = Name;
        this.Introduce = Introduce;
    }

    public String getName() {
        return Name;
    }

    public String getIntroduce() {
        return Introduce;
    }
}

/**
 *  抽象聚合：婺源景点集接口
 *  容器接口:  理解 成  jdk中的 Collection接口
 */
interface ViewSpotSet {
    /**
     * 添加
     * @param obj
     */
    void add(WyViewSpot obj);

    /**
     * 移除
     * @param obj
     */
    void remove(WyViewSpot obj);

    /**
     * *****获取迭代器
     * @return
     */
    ViewSpotIterator iterator();

}

/**
 * 具体聚合：婺源景点集
 * 容器类:   理解成   ArrayList
 */

class WyViewSpotSet implements ViewSpotSet {

    private ArrayList<WyViewSpot> list = new ArrayList<WyViewSpot>();

    @Override
    public void add(WyViewSpot obj) {
        list.add(obj);
    }

    @Override
    public void remove(WyViewSpot obj) {
        list.remove(obj);
    }

    @Override
    public ViewSpotIterator iterator() {
        return new WyViewSpotIterator(list);
    }
}

/**
   抽象迭代器：婺源景点迭代器接口
   理解 成前面 ｊｄｋ中的 Iterator(它只有 ｈａｓＮｅｘｔ（），　ｎｅｘｔ（）　）
 */
interface ViewSpotIterator {
    boolean hasNext();

    WyViewSpot next();



    WyViewSpot first();

    WyViewSpot previous();

    WyViewSpot last();
}

/**
 *  具体迭代器：婺源景点迭代器
 *  可以理解成：　　　ｊｄｋ中的  ArrayList中的 Ｉｔｅ类
 */
class WyViewSpotIterator implements ViewSpotIterator {
    private ArrayList<WyViewSpot> list = null;
    private int index = -1;
    WyViewSpot obj = null;

    public WyViewSpotIterator(ArrayList<WyViewSpot> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public WyViewSpot first() {
        index = 0;
        obj = list.get(index);
        return obj;
    }

    @Override
    public WyViewSpot next() {
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public WyViewSpot previous() {
        if (index > 0) {
            obj = list.get(--index);
        }
        return obj;
    }

    @Override
    public WyViewSpot last() {
        index = list.size() - 1;
        obj = list.get(index);
        return obj;
    }
}
