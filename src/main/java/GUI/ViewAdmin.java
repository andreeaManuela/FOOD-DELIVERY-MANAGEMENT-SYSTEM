package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewAdmin extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JLabel menuView;
    private JButton menu;
    private JButton menuComposite;
    private JLabel label;
    private JLabel title;
    private JTextField titleText;
    private JLabel rating;
    private JTextField ratingText;
    private JLabel calorii;
    private JTextField caloriiText;
    private JLabel proteine;
    private JTextField proteineText;
    private JLabel fat;
    private JTextField fatText;
    private JLabel sodiu;
    private JTextField sodiuText;
    private JLabel pret;
    private JTextField pretText;
    private JButton addProduct;
    private JButton modifyProduct;
    private JButton deleteProduct;
    private JButton back;
    private JLabel nameMenu;
    private JTextField nameMenuText;
    private JButton createCompositeProduct;
    private JLabel labelReports;
    private JButton reports;

    public  ViewAdmin()
    {
        setTitle("ADMIN PAGE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 500,500,750);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);

        menuView=new JLabel("Current Menu:");
        menuView.setBounds(20,20,150,30);
        menuView.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(menuView);

        menu=new JButton("MENU");
        menu.setBounds(150,23,110,25);
        panel.add(menu);

        menuComposite=new JButton("MENU COMP PRODUCTS");
        menuComposite.setBounds(270,23,200,25);
        panel.add(menuComposite);

        label=new JLabel("Manage Products from the MENU:");
        label.setBounds(20,60,270,30);
        label.setFont(new Font("Tahoma", Font.ITALIC,17));
        panel.add(label);

        title=new JLabel("Title:");
        title.setBounds(100,120,80,30);
        title.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(title);

        titleText=new JTextField();
        titleText.setBounds(185,122,190,25);
        panel.add(titleText);

        rating=new JLabel("Rating:");
        rating.setBounds(100,160,80,30);
        rating.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(rating);

        ratingText=new JTextField();
        ratingText.setBounds(185,162,190,25);
        panel.add(ratingText);

        calorii=new JLabel("Calories:");
        calorii.setBounds(100,200,80,30);
        calorii.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(calorii);

        caloriiText=new JTextField();
        caloriiText.setBounds(185,202,190,25);
        panel.add(caloriiText);

        proteine=new JLabel("Proteins:");
        proteine.setBounds(100,240,80,30);
        proteine.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(proteine);

        proteineText=new JTextField();
        proteineText.setBounds(185,242,190,25);
        panel.add(proteineText);

        fat=new JLabel("Fat:");
        fat.setBounds(100,280,80,30);
        fat.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(fat);

        fatText=new JTextField();
        fatText.setBounds(185,282,190,25);
        panel.add(fatText);

        sodiu=new JLabel("Sodium:");
        sodiu.setBounds(100,320,80,30);
        sodiu.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(sodiu);

        sodiuText=new JTextField();
        sodiuText.setBounds(185,322,190,25);
        panel.add(sodiuText);

        pret=new JLabel("Price:");
        pret.setBounds(100,360,80,30);
        pret.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(pret);

        pretText=new JTextField();
        pretText.setBounds(185,362,190,25);
        panel.add(pretText);

        addProduct=new JButton("ADD");
        addProduct.setBounds(120,420,130,20);
        panel.add(addProduct);

        modifyProduct=new JButton("MODIFY");
        modifyProduct.setBounds(250,420,130,20);
        panel.add(modifyProduct);

        deleteProduct=new JButton("DELETE");
        deleteProduct.setBounds(120,450,130,20);
        panel.add(deleteProduct);

        back=new JButton("BACK");
        back.setBounds(250,450,130,20);
        panel.add(back);

        nameMenu=new JLabel("Write the name of the menu with composite products:");
        nameMenu.setFont(new Font("Tahoma", Font.ITALIC,17));
        nameMenu.setBounds(20,490,450,30);
        panel.add(nameMenu);

        nameMenuText=new JTextField();
        nameMenuText.setBounds(100,530,200,20);
        panel.add(nameMenuText);

        createCompositeProduct=new JButton("Create Composite Product");
        createCompositeProduct.setBounds(100,560,200,25);
        panel.add(createCompositeProduct);

        labelReports=new JLabel("Generate the administrator specific reports:");
        labelReports.setBounds(20,600,400,25);
        labelReports.setFont(new Font("Tahoma",Font.ITALIC,17));
        panel.add(labelReports);

        reports=new JButton("REPORTS");
        reports.setBounds(150,640,100,25);
        panel.add(reports);

    }
    //BACK
    public void backAdminListener(ActionListener actionListener)
    {
        this.back.addActionListener(actionListener);
    }

    public String getTitle()
    {
        return this.titleText.getText();
    }

    //INT
    public int getRatingInt()
    {
        String rating="";
        rating=ratingText.getText();
        int ratingInt=Integer.parseInt(rating);
        return ratingInt;
    }

    public int getCaloriesInt()
    {
        String cal="";
        cal=caloriiText.getText();
        int caloInt=Integer.parseInt(cal);
        return caloInt;
    }

    public int getProteineInt()
    {
        String prot="";
        prot=proteineText.getText();
        int protInt=Integer.parseInt(prot);
        return protInt;
    }

    public int getFatInt()
    {
        String fatString="";
        fatString=fatText.getText();
        int fatInt=Integer.parseInt(fatString);
        return fatInt;
    }

    public int getSodiuInt()
    {
        String sodiuString=sodiuText.getText();
        int sodiuInt=Integer.parseInt(sodiuString);
        return sodiuInt;
    }

    public int getPriceInt()
    {
        String pretString="";
        pretString=pretText.getText();
        int pret=Integer.parseInt(pretString);
        return pret;
    }
    //STRING pentru a putea adauga in lista
    public String getRating()
    {
        return ratingText.getText();
    }

    public String getCalories()
    {
        return caloriiText.getText();
    }

    public String getProteine()
    {
        return proteineText.getText();
    }

    public String getFat()
    {
        return fatText.getText();
    }

    public String getSodiu()
    {
        return sodiuText.getText();
    }

    public String getPrice()
    {
        return pretText.getText();
    }


    //MENU
    public void viewMenuAdminListener(ActionListener actionListener)
    {
        this.menu.addActionListener(actionListener);
    }
    //ADD
    public void addProductAdminListener(ActionListener actionListener)
    {
        this.addProduct.addActionListener(actionListener);
    }
    //MODIFY
    public void modifProductAdminListener(ActionListener actionListener)
    {
        this.modifyProduct.addActionListener(actionListener);
    }
    //DELETE
    public void deleteProdAdminListener(ActionListener actionListener)
    {
        this.deleteProduct.addActionListener(actionListener);
    }
    //CREATE COMPOSITE PRODUCT
    public void createComProductAdmin(ActionListener actionListener)
    {
        this.createCompositeProduct.addActionListener(actionListener);
    }

    //MENU COMPOSITE PRODUCT
    public void viewMenuCompProductAdmin(ActionListener actionListener)
    {
        this.menuComposite.addActionListener(actionListener);
    }

    //NAME OF MENU WITH COMP PRODUCTS
    public String getNameMenuCP()
    {
        return nameMenuText.getText();
    }

    //REPORTS
    public void createReports(ActionListener actionListener)
    {
        this.reports.addActionListener(actionListener);
    }
}
