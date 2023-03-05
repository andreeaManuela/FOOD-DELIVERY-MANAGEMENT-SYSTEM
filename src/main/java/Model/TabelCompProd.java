package Model;

import BusinessLogic.BaseProduct;
import BusinessLogic.CompositeProduct;

import javax.swing.*;
import java.util.Set;

public class TabelCompProd extends JFrame {
    private JTable tabel;
    private Administrator admin=new Administrator("Andreea","1234","Andreea", "Regina Maria");
    private Set<CompositeProduct> produseCompuse;
    private JScrollPane scroll;

    public TabelCompProd(Administrator admin)
    {
        setTitle("MENU COMPOSITE PRODUCTS");
        setSize(900,450);
        String[] col={"Title", "Composite Products", "Price"};
        produseCompuse=admin.getAllCompProd();
        int nrCol=3;
        int i=0;
        int size=produseCompuse.size();
        String[][] celula=new String[size][nrCol];
        for(CompositeProduct s: produseCompuse)
        {
            if(i< size)
            {
                celula[i][0]=s.getTitleCp();
                celula[i][1]=s.toString();
                celula[i][2]=String.valueOf(s.computePrice());
                i++;
            }
        }
        tabel=new JTable(celula,col);
        scroll=new JScrollPane(tabel);
        add(scroll);
        setVisible(true);
    }
}
