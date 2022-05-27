package com.demodatabase.ui.characterpage;

import com.demodatabase.operate.CharactersOperate;
import com.demodatabase.operate.OtherOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class CharacterRetire extends JFrame{
    private static CharacterRetire jf;
    private CharacterRetire(String resourceSlogan){
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
                CharacterRetire.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入要删除的干员");
        JTextField textField=new JTextField("",20);
        JButton button=new JButton("删除");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog jd=new JDialog();
                int state=CharactersOperate.delCharacter(textField.getText());
                if(state==0){
                    jd.add(new JLabel("删除失败!"));
                }else{
                    jd.add(new JLabel("删除成功!"));
                }
                jd.setBounds(800,300,100,120);
                jd.setVisible(true);
                jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        });
        super.add(label1);
        super.add(textField);
        super.add(button);
        super.add(img);
    }
    public static CharacterRetire getInstance(){
        if(jf==null){
            jf=new CharacterRetire("resource terminal");
        }
        return jf;
    }

    public void setVisible(){
        super.setVisible(true);
    }
}
