package com.demodatabase.ui.characterpage;

import com.demodatabase.ui.Select;
import com.demodatabase.ui.resourcepage.ResourceDel;
import com.demodatabase.ui.resourcepage.ResourcePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CharacterPage extends JFrame {
    private static CharacterPage jf;
    private CharacterPage(String character){
        //frame
        super(character);
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
                CharacterPage.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);
        JButton button1=new JButton("增加干员");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharacterInsert.getInstance().setVisible();
                CharacterInsert.getInstance();
                CharacterPage.super.setVisible(false);
            }
        });
        JButton button2=new JButton("删除接触源石干员");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharacterDel.getInstance().setVisible();
                CharacterDel.getInstance();
                CharacterPage.super.setVisible(false);
            }
        });
        JButton button3=new JButton("查询资源使用情况");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharacterGet.getInstance().setVisible();
                CharacterGet.getInstance();
                CharacterPage.super.setVisible(false);
            }
        });
        JButton button4=new JButton("删除干员");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CharacterRetire.getInstance().setVisible();
                CharacterRetire.getInstance();
                CharacterPage.super.setVisible(false);
            }
        });
        super.add(button1);
        super.add(button2);
        super.add(button3);
        super.add(button4);
        super.add(img);
    }
    public static CharacterPage getInstance(){
        if(jf==null){
            jf=new CharacterPage("person terminal");
        }
        return jf;
    }
    public void setVisible(){
        super.setVisible(true);
    }
}
