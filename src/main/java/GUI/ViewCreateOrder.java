package GUI;

import BusinessLogic.BaseProduct;
import BusinessLogic.CompositeProduct;
import Model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class ViewCreateOrder extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JLabel text;
    private JComboBox listaProduse;
    private JButton addProduct;
    private JButton createOrder;
    private JButton back;
    private Administrator admin=new Administrator("Andreea","1234","Andreea", "Regina Maria");

    public ViewCreateOrder(Administrator admin)
    {
        setTitle("ORDER PAGE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 400,400,300);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.add(panel);

        text=new JLabel("Select a product:");
        text.setBounds(10,10,250,30);
        text.setFont(new Font("Tahoma",Font.ITALIC,17));
        panel.add(text);

        String[] nume=getComboBoxProduct(admin);
        listaProduse=new JComboBox(nume);
        listaProduse.setBounds(30,50,330,30);
        panel.add(listaProduse);

        addProduct=new JButton("Add product");
        addProduct.setBounds(110,100,110,30);
        panel.add(addProduct);

        createOrder=new JButton("Create Order");
        createOrder.setBounds(110,140,110,30);
        panel.add(createOrder);

        back=new JButton("BACK");
        back.setBounds(110,180,110,30);
        panel.add(back);
    }

    public String[] getComboBoxProduct(Administrator admin)
    {
        Set<BaseProduct> listProduse=admin.getProductsBP();
        List<CompositeProduct> listProdCompuse=admin.getCompositeProducts();
        String[] numeProduse=new String[listProduse.size()+listProdCompuse.size()];
        int i=0;
        for(BaseProduct b: listProduse)
        {
            numeProduse[i]=b.getTitle();
            i++;
        }
        for(CompositeProduct c: listProdCompuse)
        {
            numeProduse[i]=c.getTitle();
            i++;
        }

        return numeProduse;
    }

    public String getComboBox()
    {
        return String.valueOf(this.listaProduse.getSelectedItem());
    }

    //SELECT PRODUCT
    public void selectProductOrder(ActionListener actionListener)
    {
        this.addProduct.addActionListener(actionListener);
    }

    //CREATE ORDER
    public void createOrderListener(ActionListener actionListener)
    {
        this.createOrder.addActionListener(actionListener);
    }

    //BACK
    public void backViewCreate(ActionListener actionListener)
    {
        this.back.addActionListener(actionListener);
    }

}
