package Model;

import BusinessLogic.BaseProduct;
import BusinessLogic.CompositeProduct;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static Model.Role.ADMIN;

public class Administrator extends User{
    private Set<BaseProduct> listaProduseBaseP;
    private List<CompositeProduct> listaProduseCompuse;

       public Administrator(String username, String password, String name, String address)
    {
       super(username,password,name, address);
       this.setRol(ADMIN);
       listaProduseBaseP=new TreeSet<>();
       listaProduseCompuse=new ArrayList<>();

        try {
            List<String> file=new ArrayList<>();
            List<BaseProduct> lista=new ArrayList<>();
            String filename="products.csv";
            Stream<String> stream= null;
            stream = Files.lines(Paths.get(filename));
            file=stream.collect(Collectors.toList());
            lista= file.stream().map(s->s.split(",")).map(array->new BaseProduct(array[0], array[1], array[2], array[3], array[4], array[5], array[6])).collect(Collectors.toList());
            lista = lista.stream().sorted().collect(Collectors.toList());
            for(BaseProduct b: lista)
            {
               listaProduseBaseP.add(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<BaseProduct> getProductsBP(){ return listaProduseBaseP;}
    public List<CompositeProduct> getCompositeProducts(){ return listaProduseCompuse;}

    //ADAUGAREA IN BP SI IN CP
    public void adaugareBP(BaseProduct produs)
    {
        listaProduseBaseP.add(produs);
    }

    public void adaugareCP(CompositeProduct cp)
    {
        listaProduseCompuse.add(cp);
    }
    //STERGEREA IN BP SI CP
    public void deleteBP(BaseProduct produs)
    {
        listaProduseBaseP.remove(produs);
    }


    public BaseProduct modificareProdus(BaseProduct nou,String nume,String rating,String calorii, String prot, String fat, String sodiu, String pret)
    {
        for(BaseProduct s: listaProduseBaseP)
        {
            if(s.getTitle().equals(nou.getTitle()))
            {
                nou=new BaseProduct(nume,s.setRating(rating), s.setNbOfCalories(calorii),s.setProteins(prot),s.setFats(fat),s.setSodium(sodiu),s.setPrice(pret));
            }
        }
        return nou;
    }

    public TreeSet<CompositeProduct> getAllCompProd()
    {
        TreeSet<CompositeProduct> listaFinala=new TreeSet<>();
        for(CompositeProduct c: listaProduseCompuse)
        {
            listaFinala.add(c);
            //System.out.println(c.toString());
        }
        return listaFinala;
    }

    //Cautare client in lista
    public List<BaseProduct> searchProduct(BaseProduct produs, Administrator admin)
    {
        //am nevoie de o lista de base products
        //lista de base products e de tip Set
        Set<BaseProduct> listaProduseSet=admin.getProductsBP();
        List<BaseProduct> listaProduse=new ArrayList<>();
        //adaug din lista de tip set in lista
        for(BaseProduct b: listaProduseSet)
        {
            listaProduse.add(b);
        }

        List<BaseProduct> produseGasite=listaProduse
                .stream()
                .filter(b->b.getTitle().contains(produs.getTitle()) && b.getRating().contains(produs.getRating()) && b.getNbOfCalories().contains(produs.getNbOfCalories()) && b.getProteins().contains(produs.getProteins()) && b.getFats().contains(produs.getFats()) && b.getSodium().contains(produs.getSodium()) && b.getPrice().contains(produs.getPrice()))
                .collect(Collectors.toList());

        return produseGasite;

    }



}
