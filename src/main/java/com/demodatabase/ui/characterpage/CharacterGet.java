package com.demodatabase.ui.characterpage;

import com.demodatabase.entity.Resource;
import com.demodatabase.entity.View;
import com.demodatabase.operate.ResourceOperate;
import com.demodatabase.operate.ViewOperate;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class CharacterGet extends JFrame {
    private static CharacterGet jf;
    private CharacterGet(String resourceSlogan){
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
                CharacterGet.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入想要查询的干员id");
        JTextField idField=new JTextField("",20);
        JButton button=new JButton("查询");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= idField.getText();
                ArrayList<View> arrayList= ViewOperate.getView(Integer.parseInt(idField.getText()));
                JDialog jd=new JDialog();
                jd.setPreferredSize(new Dimension(400,300));
                JTextArea jTextArea=new JTextArea(400,200);
                jTextArea.setBorder(new TitledBorder(new EtchedBorder(),"Log"));
                jTextArea.setEditable(false);
                for (View view:arrayList){
                    jTextArea.append(view.toString()+"\n");
                }
                jd.add(jTextArea);
                jd.setBounds(800,300,100,120);
                jd.setVisible(true);
                jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                idField.setText("");
            }
        });
        super.add(label1);
        super.add(idField);
        super.add(button);
        super.add(img);
    }
    public static CharacterGet getInstance(){
        if(jf==null){
            jf=new CharacterGet("resource terminal");
        }
        return jf;
    }

    public void setVisible(){
        super.setVisible(true);
    }
}
