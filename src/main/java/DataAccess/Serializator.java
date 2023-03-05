package DataAccess;

import BusinessLogic.DeliveryService;
import Model.Administrator;

import java.io.*;

public class Serializator implements Serializable {
    private DeliveryService comanda;

    public void SerializingObject() {

        try {
            FileOutputStream fileOutputStream= null;
            fileOutputStream = new FileOutputStream("serializare.txt");
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(comanda);
            objectOutputStream.flush();
            objectOutputStream.close();
            System.out.println("Done!");

            FileInputStream fileIn=new FileInputStream("serializare.txt");
            ObjectInputStream objin=new ObjectInputStream(fileIn);
            DeliveryService com2=(DeliveryService) objin.readObject();
            objin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
