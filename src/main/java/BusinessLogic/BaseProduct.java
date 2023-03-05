package BusinessLogic;

import java.util.Collections;
import java.util.List;

public class BaseProduct implements MenuItem , Comparable<BaseProduct>{
    private String title;
    private String rating;
    private String nbOfCalories;
    private String proteins;
    private String fats ;
    private String sodium;
    private String price;
    private int nrProduse;

    public BaseProduct(String title, String rating, String calorii, String proteine, String fats, String sodiu, String price)
    {
        this.title=title;
        this.rating=rating;
        this.nbOfCalories=calorii;
        this.proteins=proteine;
        this.fats=fats;
        this.sodium=sodiu;
        this.price=price;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public String getNbOfCalories() {
        return nbOfCalories;
    }

    public String getProteins() {
        return proteins;
    }

    public String getFats() {
        return fats;
    }

    public String getSodium() {
        return sodium;
    }

    public String getPrice() {
        return price;
    }

    public String setPrice(String price) {
        return this.price = price;
    }

    public String setRating(String rating) {
        return this.rating = rating;
    }

    public String setNbOfCalories(String nbOfCalories) {
        return this.nbOfCalories = nbOfCalories;
    }

    public String setProteins(String proteins) {
        return this.proteins = proteins;
    }

    public String setFats(String fats) {
       return this.fats = fats;
    }

    public String setSodium(String sodium) {
        return this.sodium = sodium;
    }

    public int getNrProduse() {
        return nrProduse;
    }

    @Override
    public int setNrProduse(int nrProduse) {
        return this.nrProduse = nrProduse;
    }

    @Override
    public String toString() {
        return title+""; /* "title='" + title + '\'' +
                ", rating='" + rating + '\'' +
                ", nbOfCalories='" + nbOfCalories + '\'' +
                ", proteins='" + proteins + '\'' +
                ", fats='" + fats + '\'' +
                ", sodium='" + sodium + '\'' +
                ", price='" + price + '\'';*/
    }

    @Override
    public int computePrice() {
        return Integer.parseInt(price);
    }

    @Override
    public int compareTo(BaseProduct o) {
        if(this.title.compareTo(o.title) != 0)
        {
            return this.title.compareTo(o.title);
        }
        return 0;
    }



}
