package com.demodatabase.ui;

import com.demodatabase.entity.Resource;
import com.demodatabase.ui.characterpage.CharacterPage;
import com.demodatabase.ui.resourcepage.ResourcePage;
import com.demodatabase.ui.weaponpage.WeaponPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Select extends JFrame {
    private static Select jf;
    private Select(String select){
        //frame
        super(select);
        super.setSize(250,480);
        super.setLocation(800,300);
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image icon=toolkit.getImage(
                "src/main/resources/img.png");
        super.setIconImage(icon);
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Login.getInstance().setVisible();
                Select.super.setVisible(false);
            }
        });
        ImageIcon icon1=new ImageIcon("src/main/resources/img_2.png");
        JLabel img=new JLabel(icon1);
        JButton button1=new JButton("干员事项");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharacterPage.getInstance().setVisible();
                CharacterPage.getInstance();
                Select.super.setVisible(false);
            }
        });
        JButton button2=new JButton("资源事项");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResourcePage.getInstance().setVisible();
                ResourcePage.getInstance();
                Select.super.setVisible(false);
            }
        });
        JButton button3=new JButton("装备事项");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeaponPage.getInstance().setVisible();
                WeaponPage.getInstance();
                Select.super.setVisible(false);
            }
        });
        super.add(button1);
        super.add(button2);
        super.add(button3);
        super.add(img);
    }
    public static Select getInstance(){
        if(jf==null){
            jf=new Select("select");
        }
        return jf;
    }

    public static void main(String[] args) {
        getInstance();
    }

    public void setVisible() {
        super.setVisible(true);
    }
}
