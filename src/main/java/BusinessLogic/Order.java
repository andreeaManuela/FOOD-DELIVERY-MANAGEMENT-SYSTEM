package BusinessLogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    //variable that increments itself
    private static AtomicInteger inc=new AtomicInteger(0);
    private int orderID;
    private int clientID;
    private String date;
    private String time;
    private int totalPrice;

    public Order(String date, String time)
    {
        this.orderID=inc.incrementAndGet();
        this.date=date;
        this.time=time;
        this.totalPrice=0;
   }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getIDClient() {
        return clientID;
    }

    public void setIDClient(int clientID) {
        this.clientID = clientID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int hashCode()
    {
        return this.orderID ;
    }

    @Override
    public String toString() {
        return "OrderID: " + orderID + "Date and time :" + date +" " + time;
    }


}
