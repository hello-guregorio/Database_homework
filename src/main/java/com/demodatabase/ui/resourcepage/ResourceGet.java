package com.demodatabase.ui.resourcepage;

import com.demodatabase.entity.Resource;
import com.demodatabase.operate.ResourceOperate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResourceGet extends JFrame {
    private static ResourceGet jf;
    private ResourceGet(String resourceSlogan){
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
                ResourceGet.super.setVisible(false);
            }
        });
        super.setLayout(new FlowLayout());
        super.setVisible(true);
        ImageIcon icon1=new ImageIcon("src/main/resources/img_3.png");
        JLabel img=new JLabel(icon1);

        JLabel label1=new JLabel("请输入想要查询的资源名称");
        JTextField resourceName=new JTextField("",20);
        JButton button=new JButton("查询");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= resourceName.getText();
                Resource resource=ResourceOperate.getResource(name);
                JDialog jd=new JDialog();
                if(resource==null){
                    jd.add(new JLabel("不存在该类型资源!"));
                }else{
                    jd.setLayout(new FlowLayout());
                    jd.add(new JLabel("资源名称:"));
                    jd.add(new JLabel(resource.getRes_name()));
                    jd.add(new JLabel("资源稀有度:"));
                    jd.add(new JLabel(resource.getRarity_name()));
                    jd.add(new JLabel("资源数量:"));
                    jd.add(new JLabel(""+Integer.toString(resource.getCount())+"个"));
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
    public static ResourceGet getInstance(){
        if(jf==null){
            jf=new ResourceGet("resource terminal");
        }
        return jf;
    }

    public void setVisible(){
        super.setVisible(true);
    }
}
