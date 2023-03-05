package Model;

import BusinessLogic.BaseProduct;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class TabelSearch extends JFrame{
    private JTable tabel;
    private Administrator admin=new Administrator("Andreea","1234","Andreea", "Regina Maria");
    private List<BaseProduct> searchList;
    private JScrollPane scroll;

    public TabelSearch(Administrator admin, BaseProduct searchProduct)
    {
        setTitle("MENU");
        setSize(900,450);
        String[] col={"Title", "Rating", "Calories", "Protein", "Fat", "Sodium","Price"};
        searchList=admin.searchProduct(searchProduct,admin);
        int nrCol=7;
        int i=0;
        int size=searchList.size();
        String[][] celula=new String[size][nrCol];
        for(BaseProduct s: searchList)
        {
            if(i< size)
            {
                celula[i][0]=s.getTitle();
                celula[i][1]=s.getRating();
                celula[i][2]=s.getNbOfCalories();
                celula[i][3]=s.getProteins();
                celula[i][4]=s.getFats();
                celula[i][5]=s.getSodium();
                celula[i][6]=s.getPrice();
                i++;
            }
        }
        tabel=new JTable(celula,col);
        scroll=new JScrollPane(tabel);
        add(scroll);
        setVisible(true);

    }
}
