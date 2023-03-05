package GUI;

import BusinessLogic.*;
import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {
    private View view=new View();
    private Register register=new Register();
    private ViewClient viewClient=new ViewClient();
    private ViewEmployee viewEmployee=new ViewEmployee();
    private ViewAdmin viewAdmin=new ViewAdmin();
    private DeliveryService comanda;
    private ViewCompositeProduct viewCompositeProduct;
    private ViewCreateOrder viewCreateOrder;
    private Date data=new Date();
    private SimpleDateFormat date1=new SimpleDateFormat("d MM yyyy");
    private SimpleDateFormat time=new SimpleDateFormat("HH");
    private ViewReport viewReport;

    public Controller(View view, Administrator admin)
    {
        this.view=view;
        this.comanda=new DeliveryService();
        ////////INTERFATA REGISTER//////
        this.view.registerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register=new Register();
                view.setVisible(false);
                register.setVisible(true);

                //BACK BUTTON
                register.backButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        register.setVisible(false);
                        view.setVisible(true);
                    }
                });
                //CREATE ACCOUNT
                register.createClientButtonListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String passw=String.valueOf(register.getPassRegister());
                        Client client=new Client(register.getUserRegister(), passw, register.getNameRegister(), register.getAddressRegister());
                        comanda.addClient(client);
                       // System.out.println(client);
                     }
                });
            }
          });

        //LOG IN
        view.logInListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Role userTypeInput=view.getItemComboBox();
                String use=view.getUsernameInput();
                String parola=String.valueOf(view.getPassMainInterface());
              //  System.out.println(use);
              //  System.out.println(parola);

                //CLIENT
                if(userTypeInput == Role.CLIENT && comanda.validareClient(use, parola) == true) {
                    //INTERFATA CLIENT
                        view.setVisible(false);
                        viewClient.setVisible(true);

                    //BACK
                    viewClient.backClientListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            viewClient.setVisible(false);
                            view.setVisible(true);
                        }
                    });
                    //VIEW MENU
                    viewClient.viewMenuClientListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                               Tabel tabel=new Tabel(admin);
                        }
                    });

                    //VIEW MENU COMP PROD
                    viewClient.viewMenuCompProd(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            TabelCompProd tabel=new TabelCompProd(admin);
                        }
                    });

                    //SEARCH
                    viewClient.searchProductListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            BaseProduct cautaProdus=new BaseProduct(viewClient.getTitle(), viewClient.getRating(), viewClient.getCalories(), viewClient.getProteine(), viewClient.getFat(), viewClient.getSodiu(), viewClient.getPrice());
                            TabelSearch tabelSearch=new TabelSearch(admin,cautaProdus);
                        }
                    });

                    //ORDER BUTTON
                    //INTERFATA CREATE ORDER
                    viewClient.createOrderListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            viewCreateOrder=new ViewCreateOrder(admin);
                            viewClient.setVisible(false);
                            viewCreateOrder.setVisible(true);
                            //creem o lista de menuItem
                            List<MenuItem> listaMenuItem=new ArrayList<>();
                            String dataComanda=date1.format(data);
                            String oraComanda=time.format(data);
                            Order order=new Order(dataComanda, oraComanda);

                            //BACK
                            viewCreateOrder.backViewCreate(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    viewClient.setVisible(true);
                                    viewCreateOrder.setVisible(false);
                                }
                            });

                            //SELECT PRODUCT
                            viewCreateOrder.selectProductOrder(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    //produsul selectat
                                    String numeProdusSelectat=viewCreateOrder.getComboBox();
                                    //creem o lista in care avem produsele deja existente
                                    Set<BaseProduct> listaProduseExistente=admin.getProductsBP();
                                    List<CompositeProduct> listaProduseCPExistente=admin.getCompositeProducts();
                                    //apoi comparam numele produselor pentru a putea lua pretul produselor
                                    //adaugam un produs simplu
                                    for(BaseProduct b: listaProduseExistente)
                                    {
                                        //comparam elementele din lista
                                        if(b.getTitle().compareTo(numeProdusSelectat) == 0)
                                        {
                                            b.setNrProduse(b.getNrProduse()+1);
                                            listaMenuItem.add(b);
                                        }
                                    }
                                    //adaugam un produs compus
                                    for(CompositeProduct c: listaProduseCPExistente)
                                    {
                                        if(c.getTitle().compareTo(numeProdusSelectat) == 0)
                                        {
                                            c.setNrProduse(c.getNrProduse()+1);
                                            listaMenuItem.add(c);
                                        }
                                    }
                                }
                            });

                            //ADD ORDER
                            viewCreateOrder.createOrderListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {

                                    List<Client> listClienti=comanda.getClienti();
                                    String user=view.getUsernameInput();
                                    String parolaLogIn= String.valueOf(view.getPassMainInterface());

                                    for(Client c: listClienti)
                                    {
                                        //verific clientul
                                        if(c.getUsernameClient().equals(user) && c.getPasswordClient().equals(parolaLogIn))
                                        {
                                            //atunci cand clientul face o comanda
                                            //numarul de comenzi facute creste cu 1
                                            //setam ID-ul clientului ca fiind ID-ul comenzii
                                            c.setNrDeComenzi(c.getNrDeComenzi()+1);
                                            order.setIDClient(c.getClientID());
                                           // c.setClientID(order.getClientID());
                                       //     System.out.println(c.getClientID());
                                        //    System.out.println("Order ID:" + order.getOrderID());
                                        }
                                    }
                                    comanda.createBill(order,listaMenuItem);
                                }
                            });
                        }
                    });
                }
                //ADMIN
                else if(userTypeInput.equals(Role.ADMIN) && comanda.validareAdmin(use,parola)){
                view.setVisible(false);
                viewAdmin.setVisible(true);

                    //BACK
                    viewAdmin.backAdminListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            viewAdmin.setVisible(false);
                            view.setVisible(true);
                        }
                    });

                    //VIEW MENU
                    viewAdmin.viewMenuAdminListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           Tabel tabel=new Tabel(admin);

                        }
                    });
                    //ADD PRODUCT
                    viewAdmin.addProductAdminListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            BaseProduct produsNou=new BaseProduct(viewAdmin.getTitle(), viewAdmin.getRating(), viewAdmin.getCalories(), viewAdmin.getProteine(), viewAdmin.getFat(), viewAdmin.getSodiu(), viewAdmin.getPrice());
                            admin.adaugareBP(produsNou);
                            JOptionPane.showMessageDialog(viewAdmin,"The product was added to the list!");
                       }
                    });
                    //DELETE PRODUCT
                    viewAdmin.deleteProdAdminListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            BaseProduct produsSters=new BaseProduct(viewAdmin.getTitle(),viewAdmin.getRating(), viewAdmin.getCalories(), viewAdmin.getProteine(), viewAdmin.getFat(),viewAdmin.getSodiu(), viewAdmin.getPrice());
                            admin.deleteBP(produsSters);
                            JOptionPane.showMessageDialog(viewAdmin,"The product was deleted!");
                        }
                    });

                    //MODIFY PRODUCT
                    viewAdmin.modifProductAdminListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            BaseProduct produsNou=new BaseProduct(viewAdmin.getTitle(),  viewAdmin.getRating(), viewAdmin.getCalories(), viewAdmin.getProteine(), viewAdmin.getFat(), viewAdmin.getSodiu(), viewAdmin.getPrice());
                            admin.modificareProdus(produsNou,viewAdmin.getTitle(),viewAdmin.getRating(), viewAdmin.getCalories(), viewAdmin.getProteine(), viewAdmin.getFat(), viewAdmin.getSodiu(), viewAdmin.getPrice());
                            JOptionPane.showMessageDialog(viewAdmin,"The product was modified!");
                        }
                    });

                    //VIEW MENU COMPOSITE PRODUCTS
                    viewAdmin.viewMenuCompProductAdmin(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            TabelCompProd tabel=new TabelCompProd(admin);
                        }
                    });

                    //CREATE COMPOSITE PRODUCTS
                    viewAdmin.createComProductAdmin(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            viewCompositeProduct=new ViewCompositeProduct(admin);
                            viewAdmin.setVisible(false);
                            viewCompositeProduct.setVisible(true);
                            CompositeProduct newCp=new CompositeProduct(viewAdmin.getNameMenuCP());

                            //SELECT PRODUCT
                            viewCompositeProduct.selectProductCP(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    //produsul selectat
                                    String numeProdusSelectat=viewCompositeProduct.getComboBox();
                                    //creem o lista in care avem produsele deja existente
                                    Set<BaseProduct> listaProduseExistente=admin.getProductsBP();
                                    //apoi comparam numele produselor pentru a putea lua pretul produselor
                                    for(BaseProduct b: listaProduseExistente)
                                    {
                                        if(b.getTitle().equals(numeProdusSelectat))
                                        {
                                            newCp.adaugareListaCompusa(b);
                                        }
                                    }
                                }
                            });

                            viewCompositeProduct.doneCPAdmin(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    admin.adaugareCP(newCp);
                                    viewCompositeProduct.setVisible(false);
                                    viewAdmin.setVisible(true);
                                }
                            });
                        }
                    });

                    //REPORTS
                    viewAdmin.createReports(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             viewReport=new ViewReport(admin);
                             viewAdmin.setVisible(false);
                             viewReport.setVisible(true);

                             //GENERATE REPORT 1
                             viewReport.generateReport1Listener(new ActionListener() {
                                 @Override
                                 public void actionPerformed(ActionEvent e) {
                                    String start=viewReport.getStartHour();
                                    String end=viewReport.getEndHour();
                                    comanda.report1TimeInterval(start,end);
                                 }
                             });

                             //GENERATE REPORT 2
                            viewReport.generateReport2Listener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                   int nrTimes=viewReport.getNumberReport2();
                                   comanda.report2ProductsOrdered(nrTimes);
                                }
                            });

                            //GENERATE REPORT 3
                            viewReport.generateReport3Listener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int nr=Integer.parseInt(viewReport.getNrTimesReport3());
                                    int suma=Integer.parseInt(viewReport.getAmountReport3());
                                    comanda.report3(nr,suma);
                                }
                            });

                            //GENERATE REPORT 4
                            viewReport.generateReport4Listener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String zi=viewReport.getDayReport4();
                                    comanda.report4(zi);

                                }
                            });

                            //BACK
                            viewReport.backReportListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    viewReport.setVisible(false);
                                    viewAdmin.setVisible(true);
                                }
                            });
                        }
                    });
                }
                else if(userTypeInput.equals(Role.EMPLOYEE) && comanda.validareClient(use, parola)){
                    view.setVisible(false);
                    viewEmployee.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(view,"Invalid User!Please make an account!");
                }
            }
        });
    }
}
