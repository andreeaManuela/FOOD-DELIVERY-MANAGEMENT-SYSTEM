package BusinessLogic;

import Model.Client;

import java.util.List;
import java.util.TreeSet;

public interface IDeliveryServiceProcessing {

    /**
     *
     * @param orderItems list of items to be added to the order
     * @pre orderItmes not null
     * @pre orderItems.size() > 0
     * @post order exists
     * @post order contains items from orderItems
     */
    void createOrder(List<MenuItem> orderItems);
    void addClient(Client client);
    boolean validareClient(String user, String parola);
    boolean validareAdmin(String user, String parola);
    void report1TimeInterval(String startHour, String endHour);
    void report2ProductsOrdered(int nrTime);
    void report3(int nrTimes, int amount);
    void report4(String day);


}
