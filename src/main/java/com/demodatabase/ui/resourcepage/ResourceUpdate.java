package com.demodatabase.ui.resourcepage;

import com.demodatabase.entity.Resource;
import com.demodatabase.operate.ResourceOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResourceUpdate extends JFrame {
    private static ResourceUpdate jf;
    private ResourceUpdate(String resourceSlogan){
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
                ResourceUpdate.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入想要更新的资源名称");
        JTextField resourceName=new JTextField("",20);
        JLabel label2=new JLabel("请输入增加或减少的数量");
        JTextField countText=new JTextField("",20);
        JButton button=new JButton("更新");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= resourceName.getText();
                int count=Integer.parseInt(countText.getText());
                int state=ResourceOperate.updateResourceCount(name,count);
                JDialog jd=new JDialog();
                if(state==0){
                    jd.add(new JLabel("不存在该类型资源!"));
                }else{
                    jd.add(new JLabel("更新成功!"));
                }
                jd.setBounds(800,300,100,120);
                jd.setVisible(true);
                jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                resourceName.setText("");
                countText.setText("");
            }
        });
        super.add(label1);
        super.add(resourceName);
        super.add(label2);
        super.add(countText);
        super.add(button);
        super.add(img);
    }
    public static ResourceUpdate getInstance(){
        if(jf==null){
            jf=new ResourceUpdate("resource terminal");
        }
        return jf;
    }

    public void setVisible(){
        super.setVisible(true);
    }
}
