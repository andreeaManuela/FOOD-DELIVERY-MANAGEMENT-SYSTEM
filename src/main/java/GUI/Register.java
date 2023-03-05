package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Register extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel createAccount;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel nameLabel;
    private JLabel address;
    private JTextField userText;
    private JPasswordField passText;
    private JTextField nameText;
    private JTextField addText;
    private JButton createClient;
    private JButton back;

    public Register()
    {
        setTitle("REGISTER ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 600,500,450);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(400,400,350,450);
        this.add(panel);

        createAccount=new JLabel("CREATE ACCOUNT");
        createAccount.setBounds(170,0,400,150);
        createAccount.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(createAccount);

        userLabel=new JLabel("Username: ");
        userLabel.setBounds(70,100,80,60);
        panel.add(userLabel);

        userText=new JTextField();
        userText.setBounds(140,110,100,30);
        panel.add(userText);

        passwordLabel=new JLabel("Password: ");
        passwordLabel.setBounds(70,150,100,30);
        panel.add(passwordLabel);

        passText=new JPasswordField();
        passText.setBounds(140,150,100,30);
        panel.add(passText);

        nameLabel=new JLabel("Name: ");
        nameLabel.setBounds(70,190,100,30);
        panel.add(nameLabel);

        nameText=new JTextField();
        nameText.setBounds(140,190,100,30);
        panel.add(nameText);

        address=new JLabel("Address: ");
        address.setBounds(70,230,100,30);
        panel.add(address);

        addText=new JTextField();
        addText.setBounds(140,230,100,30);
        panel.add(addText);

        createClient=new JButton("CREATE");
        createClient.setBounds(160,280,100,30);
        panel.add(createClient);

        back=new JButton("BACK");
        back.setBounds(160,320,100,30);
        panel.add(back);

    }

    public void backButtonListener(ActionListener actionListener)
    {
        this.back.addActionListener(actionListener);
    }

    public void createClientButtonListener(ActionListener actionListener)
    {
        this.createClient.addActionListener(actionListener);
    }

    public String getUserRegister()
    {
        return this.userText.getText();
    }

 /*   public String getPassRegister()
    {
        char[] parola=passText.getPassword();
        String st=""+parola;
        return st;
    }*/

    public char[] getPassRegister()
    {
        return this.passText.getPassword();
    }

    public String getNameRegister()
    {
       return this.nameText.getText();
    }

    public String getAddressRegister()
    {
      return this.addText.getText();
    }
}
