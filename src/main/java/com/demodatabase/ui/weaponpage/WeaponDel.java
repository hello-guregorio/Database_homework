package com.demodatabase.ui.weaponpage;

import com.demodatabase.operate.ResourceOperate;
import com.demodatabase.operate.WeaponOperate;
import com.demodatabase.ui.resourcepage.ResourceDel;
import com.demodatabase.ui.resourcepage.ResourcePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WeaponDel extends JFrame{
    private static WeaponDel jf;
    private WeaponDel(String resourceSlogan){
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
                WeaponPage.getInstance().setVisible();
                WeaponDel.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入想要删除的武器名称");
        JTextField resourceName=new JTextField("",20);
        JButton button=new JButton("删除");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= resourceName.getText();
                int state= WeaponOperate.delWeapon(name);
                JDialog jd=new JDialog();
                if(state==0){
                    jd.add(new JLabel("不存在该武器!"));
                }else{
                    jd.add(new JLabel("删除成功!"));
                }
                jd.setBounds(800,300,100,120);
                jd.setVisible(true);
                jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                resourceName.setText("");
            }
        });
        super.add(label1);
        super.add(resourceName);
        super.add(button);
        super.add(img);
    }
    public static WeaponDel getInstance(){
        if(jf==null){
            jf=new WeaponDel("weapon terminal");
        }
        return jf;
    }

    public void setVisible(){
        super.setVisible(true);
    }
    public static void main(String[] args) {
        getInstance();
    }
}
