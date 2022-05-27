package com.demodatabase.ui.weaponpage;

import com.demodatabase.entity.Character;
import com.demodatabase.entity.Resource;
import com.demodatabase.entity.Weapon;
import com.demodatabase.operate.ResourceOperate;
import com.demodatabase.operate.WeaponOperate;
import com.demodatabase.ui.resourcepage.ResourceGet;
import com.demodatabase.ui.resourcepage.ResourcePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class WeaponGet extends JFrame{
    private static WeaponGet jf;
    private WeaponGet(String resourceSlogan){
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
                ResourcePage.getInstance().setVisible();
                WeaponGet.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入想要查询的武器名称");
        JTextField resourceName=new JTextField("",20);
        JButton button=new JButton("查询");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= resourceName.getText();
                ArrayList<Character> arrayList=WeaponOperate.getWhoEquipped(name);
                JDialog jd=new JDialog();
                if(arrayList==null){
                    jd.add(new JLabel("没有装备该武器的干员!"));
                }else{
                    //
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
    public static WeaponGet getInstance(){
        if(jf==null){
            jf=new WeaponGet("resource terminal");
        }
        return jf;
    }

}
