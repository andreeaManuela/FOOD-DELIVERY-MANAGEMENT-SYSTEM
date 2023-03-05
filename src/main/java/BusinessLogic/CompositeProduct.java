package BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeProduct implements MenuItem, Comparable<CompositeProduct> {
    private List<BaseProduct> compositeProductName;
    private int price;
    private String titleCp;
    private int nrProduse;

    public CompositeProduct(String titleCp)
    {
        this.compositeProductName=new ArrayList<>();
        this.price=price;
        this.titleCp=titleCp;
    }

    public List<BaseProduct> getCompositeProductName() {
        return compositeProductName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitleCp() {
        return titleCp;
    }

    public int getNrProduse() {
        return nrProduse;
    }

    public int setNrProduse(int nrProduse) {
       return this.nrProduse = nrProduse;
    }

    @Override
    public int computePrice() {
        int finalPrice=0;
        for(MenuItem menuItem: compositeProductName)
        {
            finalPrice += menuItem.computePrice();
        }
        return finalPrice;
    }

    public void adaugareListaCompusa(BaseProduct cp)
    {
        compositeProductName.add(cp);
    }

    public int hashCode()
    {
        return Objects.hash(compositeProductName);
    }

    @Override
    public int compareTo(CompositeProduct o) {
        if(this.titleCp.compareTo(o.titleCp) != 0)
        {
            return this.titleCp.compareTo(o.titleCp);
        }
        return 0;
    }

    @Override
    public String toString() {
        return  compositeProductName+"";
    }

    @Override
    public String getTitle() {
        return titleCp;
    }


}
