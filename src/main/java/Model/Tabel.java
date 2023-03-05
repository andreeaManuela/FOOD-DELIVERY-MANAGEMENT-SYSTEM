package Model;

import BusinessLogic.BaseProduct;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Tabel extends JFrame {
   private JTable tabel;
   private Administrator admin=new Administrator("Andreea","1234","Andreea", "Regina Maria");
   private Set<BaseProduct> productList=new TreeSet<>();
   private JScrollPane scroll;

   public Tabel(Administrator admin) {
       setTitle("MENU");
       setSize(900,450);
       String[] col={"Title", "Rating", "Calories", "Protein", "Fat", "Sodium","Price"};
       productList=admin.getProductsBP();
       int nrCol=7;
       int i=0;
       int size=productList.size();
       String[][] celula=new String[size][nrCol];
       for(BaseProduct s: productList)
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
