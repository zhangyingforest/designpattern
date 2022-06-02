package com.yc.designpattern.DMB23_访问者模式.DM2;


import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorTest {
    public static void main(String[] args) {
        new MaterialWin();
    }
}

//窗体类
class MaterialWin extends JFrame implements ItemListener {
    private static final long serialVersionUID = 1L;
    JPanel CenterJP;
    SetMaterial os;    //材料集对象
    Company visitor1, visitor2;    //访问者对象
    String[] select;

    MaterialWin() {
        super("利用访问者模式设计艺术公司和造币公司");
        JRadioButton Art;
        JRadioButton mint;
        os = new SetMaterial();
        os.add(new Cuprum());
        os.add(new Paper());
        visitor1 = new ArtCompany();//艺术公司
        visitor2 = new Mint(); //造币公司
        this.setBounds(10, 10, 750, 350);
        this.setResizable(false);
        CenterJP = new JPanel();
        this.add("Center", CenterJP);
        JPanel SouthJP = new JPanel();
        JLabel yl = new JLabel("原材料有：铜和纸，请选择生产公司：");

        Art = new JRadioButton("艺术公司", true);
        mint = new JRadioButton("造币公司");
        //绑定事件
        Art.addItemListener(this);
        mint.addItemListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(Art);
        group.add(mint);
        SouthJP.add(yl);
        SouthJP.add(Art);
        SouthJP.add(mint);
        this.add("South", SouthJP);
        select = ( os.accept(visitor1)).split(" ");    //获取产品名

        showPicture(select[0], select[1]);    //显示产品
    }

    //显示图片
    void showPicture(String Cuprum, String paper) {
        CenterJP.removeAll();    //清除面板内容
        CenterJP.repaint();    //刷新屏幕
        String FileName1 = "Picture/" + Cuprum + ".jpg";
        String FileName2 = "Picture/" + paper + ".jpg";
        JLabel lb = new JLabel(new ImageIcon(FileName1), JLabel.CENTER);
        JLabel rb = new JLabel(new ImageIcon(FileName2), JLabel.CENTER);
        CenterJP.add(lb);
        CenterJP.add(rb);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void itemStateChanged(ItemEvent arg0) {
        JRadioButton jc = (JRadioButton) arg0.getSource();
        if (jc.isSelected()) {
            if (jc.getText() == "造币公司") {
                select = (os.accept(visitor2)).split(" ");
            } else {
                select = (os.accept(visitor1)).split(" ");
            }
            showPicture(select[0], select[1]);    //显示选择的产品
        }
    }
}

//抽象访问者:公司
//抽象访问者（Visitor）角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，
// 该操作中的参数类型标识了被访问的具体元素
interface Company {
    //针对纸的处理
    String create(Paper element);
    //针对铜的处理
    String create(Cuprum element);
}

//具体访问者：艺术公司
//具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
class ArtCompany implements Company {
    @Override
    public String create(Paper element) {
        return "讲学图";
    }

    @Override
    public String create(Cuprum element) {
        return "朱熹铜像";
    }
}

//具体访问者：造币公司
//具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
class Mint implements Company {
    @Override
    public String create(Paper element) {
        return "纸币";
    }

    @Override
    public String create(Cuprum element) {
        return "铜币";
    }
}

//抽象元素：材料
//抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数
interface Material {
    //接收一个访问者用于处理每个元素。
    String accept(Company visitor);
}

//具体元素：纸
//4.具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，
// 其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
class Paper implements Material {
    @Override
    public String accept(Company visitor) {
        return   visitor.create(this);
    }
}

//具体元素：铜
class Cuprum implements Material {
    @Override
    public String accept(Company visitor) {
        return visitor.create(this);
    }
}

//对象结构角色:材料集
//对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现
class SetMaterial {
    //集合用于存元素
    private List<Material> list = new ArrayList<Material>();

    //结合迭代器模式.
    public String accept(Company visitor) {
        Iterator<Material> i = list.iterator();
        String tmp = "";
        while (i.hasNext()) {
            tmp += ((Material) i.next()).accept(visitor) + " ";
        }
        return tmp; //返回某公司的作品集
    }

    public void add(Material element) {
        list.add(element);
    }

    public void remove(Material element) {
        list.remove(element);
    }
}
