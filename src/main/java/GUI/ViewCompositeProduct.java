package GUI;

import BusinessLogic.BaseProduct;
import Model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ViewCompositeProduct extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JLabel labelCreate;
    private JComboBox items;
    private JButton selectProduct;
    private JButton back;

    public ViewCompositeProduct(Administrator admin)
    {
        setTitle("COMPOSITE PRODUCTS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200,350,250);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);

        labelCreate=new JLabel("Select a base product to make a menu:");
        labelCreate.setBounds(10,5,250,25);
        panel.add(labelCreate);

        Set<BaseProduct> listProduse=admin.getProductsBP();
        String[] numeProduse=new String[listProduse.size()];
        int i=0;
        for(BaseProduct b: listProduse)
        {
            numeProduse[i]=b.getTitle();
            i++;
        }
        items=new JComboBox<>(numeProduse);
        items.setBounds(30,40,250,20);
        panel.add(items);

        selectProduct=new JButton("SELECT PRODUCT");
        selectProduct.setBounds(40,80,190,20);
        panel.add(selectProduct);

        back=new JButton("DONE, GO BACK");
        back.setBounds(40,120,190,20);
        panel.add(back);
    }

    public String getComboBox()
    {
        return String.valueOf(this.items.getSelectedItem());
    }

    public void selectProductCP(ActionListener actionListener)
    {
        this.selectProduct.addActionListener(actionListener);
    }

    public void doneCPAdmin(ActionListener actionListener)
    {
        this.back.addActionListener(actionListener);
    }

   }
