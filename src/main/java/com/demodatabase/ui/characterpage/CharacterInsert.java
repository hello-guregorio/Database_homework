package com.demodatabase.ui.characterpage;

import com.demodatabase.entity.Character;
import com.demodatabase.entity.Resource;
import com.demodatabase.operate.CharactersOperate;
import com.demodatabase.operate.ResourceOperate;
import com.demodatabase.ui.resourcepage.ResourceInsert;
import com.demodatabase.ui.resourcepage.ResourcePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CharacterInsert extends JFrame{
    private static CharacterInsert jf;
    private CharacterInsert(String resourceSlogan){
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
                CharacterPage.getInstance().setVisible();
                CharacterInsert.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入想要新增的干员名称");
        JTextField resourceName=new JTextField("",20);
        JLabel label2=new JLabel("请输入干员装备的武器名称");
        JTextField level=new JTextField("",20);
        JLabel label3=new JLabel("请输入职业名称");
        JTextField countText=new JTextField("",20);
        JLabel label4=new JLabel("请输入性别");
        JTextField countText2=new JTextField("",20);
        JLabel label5=new JLabel("请输入攻击力");
        JTextField countText3=new JTextField("",20);
        JLabel label6=new JLabel("请输入防御力");
        JTextField countText4=new JTextField("",20);
        JLabel label7=new JLabel("请输入伤害类型");
        JTextField countText5=new JTextField("",20);
        JLabel label8=new JLabel("请输入等级");
        JTextField countText6=new JTextField("",20);
        JButton button=new JButton("添加");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String job_name=countText.getText();
                String weapon_name=level.getText();
                String name=resourceName.getText();
                String sex=countText2.getText();
                int atk=Integer.parseInt(countText3.getText());
                int def=Integer.parseInt(countText4.getText());
                String damage_type=countText5.getText();
                int ll=Integer.parseInt(countText6.getText());
                CharactersOperate.addCharacter(new Character(
                        job_name,weapon_name,name,sex,atk,def,damage_type,ll
                ));
                JDialog jd=new JDialog();
                jd.add(new JLabel("添加成功!"));
                jd.setBounds(800,300,100,120);
                jd.setVisible(true);
                jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                resourceName.setText("");
                level.setText("");
                countText.setText("");
                countText2.setText("");
                countText3.setText("");
                countText4.setText("");
                countText5.setText("");
                countText6.setText("");
            }
        });
        super.add(label1);
        super.add(resourceName);
        super.add(label2);
        super.add(level);
        super.add(label3);
        super.add(countText);
        super.add(label4);
        super.add(countText2);
        super.add(label5);
        super.add(countText3);
        super.add(label6);
        super.add(countText4);
        super.add(label7);
        super.add(countText5);
        super.add(label8);
        super.add(countText6);
        super.add(button);
        super.add(img);
    }
    public static CharacterInsert getInstance(){
        if(jf==null){
            jf=new CharacterInsert("resource terminal");
        }
        return jf;
    }

    public void setVisible(){
        super.setVisible(true);
    }
}
