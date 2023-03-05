package GUI;

import BusinessLogic.BaseProduct;
import BusinessLogic.CompositeProduct;
import Model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class ViewClient extends JFrame {
        private JFrame frame;
        private JPanel panel;
        private JLabel menu;
        private JButton menuButton;
        private JButton menuCompProd;
        private JLabel selectProducts;
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
        private JButton search;
        private JLabel orderLabel;
        private JButton back;
        private Administrator admin=new Administrator("Andreea","1234","Andreea", "Regina Maria");
        private JButton order;

        public  ViewClient()
        {
            setTitle("CLIENT PAGE");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(600, 600,500,500);

            panel=new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.WHITE);
            this.add(panel);

            menu=new JLabel("Look in the menu:");
            menu.setBounds(20,20,150,30);
            menu.setFont(new Font("Tahoma",Font.BOLD,17));
            panel.add(menu);

            menuButton=new JButton("MENU");
            menuButton.setBounds(190,20,80,30);
            panel.add(menuButton);

            menuCompProd=new JButton("MENU COMP PRODUCT");
            menuCompProd.setBounds(280,20,180,30);
            panel.add(menuCompProd);

            selectProducts=new JLabel("Search for products based on:");
            selectProducts.setBounds(20,80,250,40);
            selectProducts.setFont(new Font("Tahoma",Font.ITALIC,17));
            panel.add(selectProducts);

            title=new JLabel("Title:");
            title.setBounds(20,140,100,40);
            title.setFont(new Font("Tahoma", Font.PLAIN, 17));
            panel.add(title);

            titleText=new JTextField();
            titleText.setBounds(90,148,80,30);
            panel.add(titleText);

            rating=new JLabel("Rating:");
            rating.setBounds(20,185,100,40);
            rating.setFont(new Font("Tahoma", Font.PLAIN, 17));
            panel.add(rating);

            ratingText=new JTextField();
            ratingText.setBounds(90,188,80,30);
            panel.add(ratingText);

            calorii=new JLabel("Calories:");
            calorii.setBounds(20,230,100,40);
            calorii.setFont(new Font("Tahoma", Font.PLAIN, 17));
            panel.add(calorii);

            caloriiText=new JTextField();
            caloriiText.setBounds(90,230,80,30);
            panel.add(caloriiText);

            pret=new JLabel("Price:");
            pret.setBounds(20,275,100,40);
            pret.setFont(new Font("Tahoma", Font.PLAIN, 17));
            panel.add(pret);

            pretText=new JTextField();
            pretText.setBounds(90,277,80,30);
            panel.add(pretText);

            proteine=new JLabel("Proteins:");
            proteine.setBounds(200,140,100,40);
            proteine.setFont(new Font("Tahoma", Font.PLAIN, 17));
            panel.add(proteine);

            proteineText=new JTextField();
            proteineText.setBounds(270,145,80,30);
            panel.add(proteineText);

            fat=new JLabel("Fats:");
            fat.setBounds(200,185,100,40);
            fat.setFont(new Font("Tahoma", Font.PLAIN, 17));
            panel.add(fat);

            fatText=new JTextField();
            fatText.setBounds(270,185,80,30);
            panel.add(fatText);

            sodiu=new JLabel("Sodium:");
            sodiu.setBounds(200,230,100,40);
            sodiu.setFont(new Font("Tahoma", Font.PLAIN, 17));
            panel.add(sodiu);

            sodiuText=new JTextField();
            sodiuText.setBounds(270,230,80,30);
            panel.add(sodiuText);

            search=new JButton("SEARCH");
            search.setBounds(215,273,100,30);
            panel.add(search);

            orderLabel=new JLabel("Create an order :");
            orderLabel.setBounds(20,350,330,40);
            orderLabel.setFont(new Font("Tahoma", Font.ITALIC, 17));
            panel.add(orderLabel);

            order=new JButton("ORDER");
            order.setBounds(170,355,100,30);
            panel.add(order);

            back=new JButton("BACK");
            back.setBounds(170,390,100,30);
            panel.add(back);

        }
        //BACK
        public void backClientListener(ActionListener actionListener)
        {
            this.back.addActionListener(actionListener);
        }
        //MENU
        public void viewMenuClientListener(ActionListener actionListener)
        {
            this.menuButton.addActionListener(actionListener);
        }
        //SEARCH
        public void searchProductListener(ActionListener actionListener)
        {
            this.search.addActionListener(actionListener);
        }
        //CREATE ORDER
        public void createOrderListener(ActionListener actionListener)
        {
            this.order.addActionListener(actionListener);
        }

        //MENU COMP PRODUCT
    public void viewMenuCompProd(ActionListener actionListener)
    {
        this.menuCompProd.addActionListener(actionListener);
    }


        //TEXTFIELDS
       public String getTitle()
       {
           return this.titleText.getText();
       }

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


    }

