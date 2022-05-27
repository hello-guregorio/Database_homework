package com.demodatabase.ui.weaponpage;

import com.demodatabase.entity.ADWeapon;
import com.demodatabase.entity.DefWeapon;
import com.demodatabase.entity.Resource;
import com.demodatabase.entity.Weapon;
import com.demodatabase.operate.ADWeaponOperate;
import com.demodatabase.operate.DefWeaponOperate;
import com.demodatabase.operate.ResourceOperate;
import com.demodatabase.operate.WeaponOperate;
import com.demodatabase.ui.resourcepage.ResourceInsert;
import com.demodatabase.ui.resourcepage.ResourcePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WeaponInsert extends JFrame{
    private static WeaponInsert jf;
    private static String WeaponName;
    private static int WeaponCount;
    public String getWeaponName(){
        return WeaponName;
    }
    public int getWeaponCount(){
        return WeaponCount;
    }
    private WeaponInsert(String resourceSlogan){
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
                WeaponInsert.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入想要新增的武器名称");
        JTextField resourceName=new JTextField("",20);
        JLabel label2=new JLabel("请输入武器类型(攻击或防御)");
        JTextField level=new JTextField("",20);
        JLabel label3=new JLabel("请输入入库数量");
        JTextField countText=new JTextField("",20);
        JButton button=new JButton("继续");
        button.setSize(40,20);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WeaponName=resourceName.getText();
                WeaponCount=Integer.parseInt(countText.getText());
                WeaponOperate.addWeapon(new Weapon(WeaponName,WeaponCount));
                if(level.getText().equals("攻击")){
                    WeaponInsert.super.setVisible(false);
                    AddADWeapon.getInstance().setVisible(true);
                    AddADWeapon.getInstance();
                }else{
                    WeaponInsert.super.setVisible(false);
                    AddDefWeapon.getInstance().setVisible(true);
                    AddDefWeapon.getInstance();
                }
                level.setText("");
                countText.setText("");
                resourceName.setText("");
            }
        });
        super.add(label1);
        super.add(resourceName);
        super.add(label2);
        super.add(level);
        super.add(label3);
        super.add(countText);
        super.add(button);
    }
    public static WeaponInsert getInstance(){
        if(jf==null){
            jf=new WeaponInsert("resource terminal");
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
