package GUI;

import Model.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.awt.Font.ITALIC;

public class View extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JComboBox user;
    private JLabel username;
    private JLabel parola;
    private JLabel register;
    private JButton registerInterfata;
    private JButton logIn;
    private JTextField usernameText;
    private JPasswordField parolaText;
    private JLabel welcome;
    private ImageIcon imagine;
    private JLabel imag;

    public View()
    {
        setTitle("FOOD DELIVERY APPLICATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 600,600,600);

        panel=new JPanel();
        panel.setLayout(null);

        imagine=new ImageIcon(getClass().getResource("/foodDelivery2.png"));
        imag=new JLabel(imagine);
        imag.setSize(700,700);
        panel.add(imag);
        this.add(panel);

        welcome=new JLabel("Welcome to our food delivery service. Please LOG IN:");
        welcome.setBounds(70,15,500,35);
        welcome.setFont(new Font("Tahoma", ITALIC, 20));
        panel.add(welcome);

        username=new JLabel("Username :");
        username.setBounds(150,120,150,40);
        username.setFont(new Font("Tahoma",Font.PLAIN ,20));
        imag.add(username);

        usernameText=new JTextField();
        usernameText.setBounds(260,120,100,30);
        imag.add(usernameText);

        parola=new JLabel("Password :");
        parola.setBounds(150,160,150,40);
        parola.setFont(new Font("Tahoma",Font.PLAIN ,20));
        imag.add(parola);

        parolaText=new JPasswordField();
        parolaText.setBounds(260,160,100,30);
        imag.add(parolaText);

        Role[] utilizatori=new Role[]{Role.ADMIN, Role.CLIENT, Role.EMPLOYEE};
        user=new JComboBox<Role>(utilizatori);
        user.setBounds(170,210,170,30);
        imag.add(user);

        logIn=new JButton("LOG IN");
        logIn.setBounds(170,270,140,30);
        imag.add(logIn);

        register=new JLabel("Don't have an account? Sign up!");
        register.setBounds(10,390,250,40);
        register.setFont(new Font("Tahoma",Font.BOLD ,15));
        imag.add(register);

        registerInterfata=new JButton("REGISTER");
        registerInterfata.setBounds(10,440,130,25);
        imag.add(registerInterfata);
    }

    public String getUsernameInput()
    {
      return this.usernameText.getText();
    }

    public char[] getPassMainInterface()
    {
        return this.parolaText.getPassword();
    }

    public Role getItemComboBox()
    {
        return (Role)this.user.getSelectedItem();
    }

    public void registerListener(ActionListener actionListener)
    {
        this.registerInterfata.addActionListener(actionListener);
    }

    public void logInListener(ActionListener actionListener)
    {
        this.logIn.addActionListener(actionListener);
    }
}
