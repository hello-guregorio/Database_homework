package com.demodatabase.ui.weaponpage;

import com.demodatabase.entity.ADWeapon;
import com.demodatabase.operate.ADWeaponOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddADWeapon extends JFrame{
    private static AddADWeapon jf;
    private AddADWeapon(String resourceSlogan){
        //frame
        super(resourceSlogan);
        super.setSize(250,480);
        super.setLocation(800,300);
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image icon=toolkit.getImage(
                "src/main/resources/img.png");
        super.setIconImage(icon);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                WeaponInsert.getInstance().setVisible();
                AddADWeapon.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入攻击力");
        JTextField resourceName=new JTextField("",20);
        JLabel label2=new JLabel("请输入伤害类型");
        JTextField level=new JTextField("",20);
        JButton button=new JButton("增加");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= resourceName.getText();
                String rarity=level.getText();
                JDialog jd=new JDialog();
                ADWeaponOperate.addADWeapon(new ADWeapon(WeaponInsert.getInstance().getWeaponName(),
                        WeaponInsert.getInstance().getWeaponCount(),
                        Integer.parseInt(name),rarity));
                jd.add(new JLabel("添加成功!"));
                jd.setBounds(800,300,100,120);
                jd.setVisible(true);
                jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                resourceName.setText("");
                level.setText("");
            }
        });
        super.add(label1);
        super.add(resourceName);
        super.add(label2);
        super.add(level);
        super.add(button);
        super.add(img);
    }
    public static AddADWeapon getInstance(){
        if(jf==null){
            jf=new AddADWeapon("resource terminal");
        }
        return jf;
    }

}
