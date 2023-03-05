import BusinessLogic.BaseProduct;
import BusinessLogic.CompositeProduct;
import BusinessLogic.DeliveryService;
import BusinessLogic.Order;
import DataAccess.Serializator;
import GUI.*;
import Model.Administrator;
import Model.Client;
import Model.Tabel;
import Model.TabelSearch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainClass {
    public static void main(String[] args)
    {
        View view=new View();
        Administrator admin=new Administrator("Andreea","1234","Andreea", "Regina Maria");
        Controller controller= new Controller(view, admin);
        Serializator s=new Serializator();
        //s.SerializingObject();
        view.setVisible(true);
        //ViewClient viewClient=new ViewClient();
        //ViewAdmin viewAdmin=new ViewAdmin();
        //BaseProduct product=new BaseProduct("Zzzzzzzzz", "5", "1200","20","200","5","45");
        //ViewCompositeProduct viewCompositeProduct=new ViewCompositeProduct(admin);
        //ViewCreateOrder viewCreateOrder=new ViewCreateOrder(admin);
        //ViewReport viewReport=new ViewReport(admin);
        //Register register=new Register();

    }
}
