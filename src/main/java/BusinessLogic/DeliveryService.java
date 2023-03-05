package BusinessLogic;

import GUI.Register;
import Model.Administrator;
import Model.Client;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;

public class DeliveryService implements IDeliveryServiceProcessing, Serializable {

    private List<Client> clienti;
    private Register register=new Register();
    private Administrator admin=new Administrator("Andreea","1234","Andreea", "Regina Maria");
    //List<MenuItem> contine produse simple si produse compuse
    private Map<Order,List<MenuItem>> listaOrdere=new HashMap<>();

    public DeliveryService()
    {
        this.clienti=new ArrayList<>();;
    }

    public List<Client> getClienti() {
        return clienti;
    }

    /**
     * Metoda care adauga clientii, care au fost introdusi in Register
     * @param client
     */

    public void addClient(Client client)
    {
        boolean clientExistent=false;
        for(Client c: clienti) {
            if (c.getUsername().compareTo(client.getUsername()) == 0) {
                clientExistent=true;
                JOptionPane.showMessageDialog(register,"The client already exists!");
            }
        }
        if(clientExistent==false)
        {
            clienti.add(client);
        }
    }

    /**
     * Aceasta metoda verifica daca clientul introdus este in lista
     * @param user
     * @param parola
     * @return
     */

    public boolean validareClient(String user, String parola)
    {
        boolean ok = false;
        for(Client c : clienti){
            if(c.getUsername().equals(user) && c.getPassword().equals(parola)){
                ok = true;
             }
        }
        return ok;
    }

    public boolean validareAdmin(String user, String parola)
    {
        boolean ok=false;
        if(admin.getUsername().equals(user) && admin.getPassword().equals(parola))
            ok=true;
        else ok=false;

        return ok;
    }

    @Override
    public void createOrder(List<MenuItem> orderItems) {
        assert(orderItems!=null);
        assert(orderItems.size()>0);
    }

    /**
     * Chitanta unei comenzi
     * @param order
     * @param listProducts
     */

    public void createBill(Order order, List<MenuItem> listProducts)
    {
        int totalPrice=0;
        //initializam HashMap-ul
        //order=key  listProducts= value
        listaOrdere.put(order,listProducts);
        try {
            FileWriter bill=new FileWriter("C:\\Users\\Andreea\\Desktop\\TP\\Tema4\\bill.txt");
            int i=0;
            for(MenuItem m: listProducts)
            {
                totalPrice=totalPrice+m.computePrice();
                bill.write("Product" + i + ":"+m.getTitle()+"\n");
                i++;
            }
            bill.write("Total price:"+totalPrice);
            bill.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * ora comenzii trebuiesa fie intre stratHour si endHour
     * @param startHour
     * @param endHour
     * Se face o lista in care se pun toate comenzile care au fost comandate intre intervalul orar mentionat
     * @pre startHour and endHour not null
     * @post returns a list with orders
     */

    @Override
    public void report1TimeInterval(String startHour, String endHour) {
        int start=Integer.parseInt(startHour);
        int end=Integer.parseInt(endHour);
        //returns the keys from the HashMap
        Set<Order> comenzileExistente=listaOrdere.keySet();
        List<Order> nrOrdereFacute=comenzileExistente
                .stream()
                .filter(o->Integer.parseInt(o.getTime()) > start && Integer.parseInt(o.getTime()) < end)
                .collect(Collectors.toList());

        //scriem in fisier
        try{
            FileWriter writeReport1=new FileWriter("C:\\\\Users\\\\Andreea\\\\Desktop\\\\TP\\\\Tema4\\\\Report1.txt");
            writeReport1.write("These orders were placed between "+ startHour+ " and "+endHour+"\n");
            for(Order o:nrOrdereFacute)
            {
                writeReport1.write("Order: " + o.getOrderID() + " has: ");
               //din fiecare comanda luam lista de poduse
                List<MenuItem> listaProduse=listaOrdere.get(o);
                for(MenuItem m: listaProduse)
                {
                    writeReport1.write(m.getTitle()+" , ");
                }
            }
            writeReport1.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
 }

    /**
     * Se pune intr-o lista toate produsele care au aparut de mai multe ori decat numarul specificat
     * @param nrTime
     * @pre nrTimes not null
     * @post returns a list of products ordered > nrTime
     */

    @Override
    public void report2ProductsOrdered(int nrTime) {
        Set<Order> comenzileExistente=listaOrdere.keySet();
        List<MenuItem> produse=null;
        for(Order o : comenzileExistente)
        {
            //pentru fiecare order luam lista de produse
            List<MenuItem> finalProduse = listaOrdere.get(o);
            produse=finalProduse.stream().distinct()
                       .filter(s -> s.getNrProduse() > nrTime)
                       .collect(Collectors.toList());
        }

        try{
            FileWriter writeReport2=new FileWriter("C:\\\\Users\\\\Andreea\\\\Desktop\\\\TP\\\\Tema4\\\\Report2.txt");
            writeReport2.write("The products were ordered more than "+ nrTime + " times"+"\n");
            for(MenuItem m: produse)
            {
                writeReport2.write("Name: "+ m.getTitle()+ " was ordered " + m.getNrProduse()+ " times\n");
            }
            writeReport2.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param nrTimes
     * @param amount
     * Intr-o lista se adauga clientii carea au comandat de mai multe ori decat numarul precizat
     * Pentru fiecare client luam comanda si verificam daca s-a comandat de mai multe ori decat numarul specificat
     * Pentru fiecare comanda, luam lista si verificam daca suma produselor este mai mare decat suma specificata
     * @pre nrTime and amount not null
     * @post return a list of clients that have ordered > nrTimes
     */

    @Override
    public void report3(int nrTimes, int amount) {
        //pentru fiecare client verific numarul de comenzi
        List<Client> listaClienti = clienti.stream()
                .filter(c -> c.getNrDeComenzi() > nrTimes)
                .collect(Collectors.toList());

        Set<Order> comenzi = listaOrdere.keySet();
        List<Order> comenziClienti = new ArrayList<>();
        for (Client c : listaClienti) {
            for (Order o : comenzi) {
                if (c.getClientID() == o.getIDClient()) {
                    //System.out.println("Client ID " + c.getClientID() +"\n" +"Ordere ID " + o.getIDClient()+"\n");
                    int pret = 0;
                    //daca id-urile sunt la fel luam lista de produse
                    //si calculam pretul
                    for (MenuItem m : listaOrdere.get(o)) {
                        pret = pret + m.computePrice();
                    }
                    o.setTotalPrice(pret);
                    comenziClienti.add(o);
                }
            }
        }

        List<Order> listaFinala=new ArrayList<>();
        for(Order c: comenziClienti) {
            listaFinala=comenziClienti.stream()
                    .filter(s -> s.getTotalPrice() > amount)
                    .collect(Collectors.toList());
        }

        try{
            FileWriter raport3=new FileWriter("C:\\\\Users\\\\Andreea\\\\Desktop\\\\TP\\\\Tema4\\\\Report3.txt");
            raport3.write("The clients that ordered more than " + nrTimes + " and the value of the order was higher than "+amount+":\n");
            for(Client c: listaClienti)
            {
                raport3.write("Clientul " + c.getClientID()+"\n");// + " cu comanda :" + o.getOrderID());
                for(Order o:listaFinala)
                {
                    raport3.write("Pretul comenzii : " + o.getTotalPrice() + " Pretul specificat :" + amount+"\n");
                }
            }
            raport3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Afiseaza produsele care au fost comandate intr-o zi
     * @param day
     * @pre day not null
     * @post returns a list with products ordered in day
     */

    @Override
    public void report4(String day) {
        //luam comenzile si verificam data in care au fost facute
        Set<Order> comenzi=listaOrdere.keySet();
        List<Order> comenzileExistente=comenzi.stream()
                .filter(p->p.getDate().equals(day))
                .collect(Collectors.toList());

        //verific de cate ori au fost comandate
        //si le adaug in lista pentru a le afisa
        List<MenuItem> lista = new ArrayList<>();
        for(Order o: comenzi)
        {
            for(MenuItem m: listaOrdere.get(o))
            {
                lista.add(m);
            }
        }

        List<MenuItem> produseFaraDuplicate=lista.stream().distinct()
                .collect(Collectors.toList());

        try{
            FileWriter writeReport4=new FileWriter("C:\\\\Users\\\\Andreea\\\\Desktop\\\\TP\\\\Tema4\\\\Report4.txt");
            writeReport4.write("The products were ordered in  "+ day + " times "+"\n");
            for(MenuItem m: produseFaraDuplicate)
            {
                writeReport4.write("Name: "+ m.getTitle()+" -> "+Collections.frequency(lista,m)+"\n" );
            }
            writeReport4.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
