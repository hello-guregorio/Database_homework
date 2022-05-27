package com.demodatabase.ui.resourcepage;

import com.demodatabase.ui.Select;
import com.demodatabase.ui.characterpage.CharacterPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResourcePage extends JFrame{
    private static ResourcePage jf;
    private ResourcePage(String resourceSlogan){
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
                Select.getInstance().setVisible();
                ResourcePage.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);
        JButton button1=new JButton("增加类型");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResourcePage.super.setVisible(false);
                ResourceInsert.getInstance().setVisible();
                ResourceInsert.getInstance();
            }
        });
        JButton button2=new JButton("数量变更");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResourcePage.super.setVisible(false);
                ResourceUpdate.getInstance().setVisible();
                ResourceUpdate.getInstance();
            }
        });
        JButton button3=new JButton("库存查询");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResourcePage.super.setVisible(false);
                ResourceGet.getInstance().setVisible();
                ResourceGet.getInstance();
            }
        });
        JButton button4=new JButton("删除资源");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResourcePage.super.setVisible(false);
                ResourceDel.getInstance().setVisible();
                ResourceDel.getInstance();
            }
        });
        super.add(button1);
        super.add(button2);
        super.add(button3);
        super.add(button4);
        super.add(img);
    }
    public static ResourcePage getInstance(){
        if(jf==null){
            jf=new ResourcePage("resource terminal");
        }
        return jf;
    }
    public void setVisible(){
        super.setVisible(true);
    }
}
