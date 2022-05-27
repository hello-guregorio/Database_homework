package com.demodatabase.ui;

import com.demodatabase.utils.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame {
    private static Login jf;
    private Login(String login){
        //frame
        super(login);
        super.setSize(250,480);
        super.setLocation(800,300);
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Image icon=toolkit.getImage(
                "src/main/resources/img.png");
        super.setIconImage(icon);
        //
        ImageIcon icon1=new ImageIcon("src/main/resources/img_1.png");
        JLabel img=new JLabel(icon1);
        JLabel label1=new JLabel("登录");
        JTextField username=new JTextField("",20);
        JLabel label2=new JLabel("密码");
        JPasswordField pwdText=new JPasswordField("",20);
        JTextField out=new JTextField("",20);
        out.setEditable(false);
        JButton button=new JButton("登录");
        button.setSize(40,20);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= username.getText();
                String pwd=pwdText.getText();
                Statement statement= DbUtil.getStatement();
                try {
                    ResultSet rs=statement.executeQuery("select * from admin");
                    boolean flag=false;
                    while (rs.next()){
                        if(rs.getString(2).equals(name)&&rs.getString(3).equals(pwd)){
                            out.setText("Login success!");
                            Select.getInstance().setVisible();
                            Select.getInstance();
                            Login.super.setVisible(false);
                            flag=true;
                            out.setText("");
                            break;
                        }
                    }
                    if(!flag){
                        out.setText("Login failed!");
                    }
                    username.setText("");
                    pwdText.setText("");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        super.add(img);
        super.add(label1);
        super.add(username);
        super.add(label2);
        super.add(pwdText);
        super.add(out);
        super.add(button);

        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setLayout(new FlowLayout(FlowLayout.LEFT));


    }
    public static Login getInstance(){
        if(jf==null){
            jf=new Login("Login");
        }
        return jf;
    }
    public void setVisible(){
        super.setVisible(true);
    }
}
