package Model;

import BusinessLogic.BaseProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static Model.Role.CLIENT;

public class Client extends User {
    private int clientID;
    private int nrDeComenzi;
    private static AtomicInteger inc=new AtomicInteger(0);

    public Client(String username, String password, String name, String address)
    {
        super(username, password,name, address);
        this.setRol(CLIENT);
        this.clientID=inc.incrementAndGet();
    }

    public int getNrDeComenzi() {
        return nrDeComenzi;
    }

    public void setNrDeComenzi(int nrDeComenzi) {
        this.nrDeComenzi = nrDeComenzi;
    }

    public String getUsernameClient()
    {
        return this.getUsername();
    }

    public String getPasswordClient()
    {
        return this.getPassword();
    }

    public String toString()
    {
        return super.toString();
    }

    public int getClientID()
    {
        return this.clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

}
