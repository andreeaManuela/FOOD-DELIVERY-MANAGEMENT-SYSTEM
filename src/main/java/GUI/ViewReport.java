package GUI;

import Model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewReport extends JFrame {
    private JFrame frame;
    private JPanel panel;
    //Report1
    private JLabel labelReport1;
    private JLabel startHour;
    private JTextField startHourText;
    private JLabel endHour;
    private JTextField endHourText;
    private JButton report1Button;
    //Report2
    private JLabel labelReport2;
    private JLabel report2Cerinta;
    private JLabel report2Cerinta2;
    private JTextField nrTimes;
    private JButton report2Button;
    //Report3
    private JLabel labelReport3;
    private JLabel report3Cerinta;
    private JLabel nrOrderTimes;
    private JTextField nrOrderTimesText;
    private JLabel amount;
    private JTextField amountText;
    private JButton report3Button;
    //Report 4
    private JLabel labelReport4;
    private JLabel report4Cerinta;
    private JLabel specificDay;
    private JTextField dayText;
    private JButton report4Button;

    private JButton back;

    public ViewReport(Administrator admin)
    {
        setTitle("REPORT PAGE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 400,550,600);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        this.add(panel);

        labelReport1=new JLabel("REPORT 1");
        labelReport1.setBounds(10,20,120,30);
        labelReport1.setFont(new Font("Tahoma",Font.PLAIN, 25));
        panel.add(labelReport1);

        startHour=new JLabel("Start Hour:");
        startHour.setBounds(40,60,110,20);
        startHour.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(startHour);

        startHourText=new JTextField();
        startHourText.setBounds(150,60,100,20);
        panel.add(startHourText);

        endHour=new JLabel("End Hour:");
        endHour.setBounds(40,90,110,20);
        endHour.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(endHour);

        endHourText=new JTextField();
        endHourText.setBounds(150,90,100,20);
        panel.add(endHourText);

        report1Button=new JButton("Generate REPORT 1");
        report1Button.setBounds(270,80,170,20);
        panel.add(report1Button);

        labelReport2=new JLabel("REPORT 2");
        labelReport2.setBounds(10,140,120,30);
        labelReport2.setFont(new Font("Tahoma",Font.PLAIN, 25));
        panel.add(labelReport2);

        report2Cerinta=new JLabel("Report genereted with the products ordered more than a specified number of times so far.");
        report2Cerinta.setBounds(10,180,520,25);
        panel.add(report2Cerinta);

        report2Cerinta2=new JLabel("Write the number:");
        report2Cerinta2.setBounds(10,200,200,25);
        report2Cerinta2.setFont(new Font("Tahoma",Font.PLAIN,20));
        panel.add(report2Cerinta2);

        nrTimes=new JTextField();
        nrTimes.setBounds(80,230,150,20);
        panel.add(nrTimes);

        report2Button=new JButton("Generate REPORT 2");
        report2Button.setBounds(250,230,170,20);
        panel.add(report2Button);

        labelReport3=new JLabel("REPORT 3");
        labelReport3.setBounds(10,260,120,30);
        labelReport3.setFont(new Font("Tahoma",Font.PLAIN, 25));
        panel.add(labelReport3);

        report3Cerinta=new JLabel("<html>Generate a report with the clients that have order more than a specified number of times so far and the value of the order was higher than a specifies amount.</html>");
        report3Cerinta.setBounds(10,280,500,50);
        panel.add(report3Cerinta);

        nrOrderTimes=new JLabel("Number of times specified:");
        nrOrderTimes.setBounds(10,325,250,20);
        nrOrderTimes.setFont(new Font("Tahoma",Font.PLAIN,18));
        panel.add(nrOrderTimes);

        nrOrderTimesText=new JTextField();
        nrOrderTimesText.setBounds(230,327,100,20);
        panel.add(nrOrderTimesText);

        amount=new JLabel("Amount specified:");
        amount.setBounds(10,350,150,20);
        amount.setFont(new Font("Tahoma",Font.PLAIN,18));
        panel.add(amount);

        amountText=new JTextField();
        amountText.setBounds(230,355,100,20);
        panel.add(amountText);

        report3Button=new JButton("Generate REPORT 3");
        report3Button.setBounds(350,340,160,20);
        panel.add(report3Button);

        labelReport4=new JLabel("REPORT 4");
        labelReport4.setBounds(10,385,120,30);
        labelReport4.setFont(new Font("Tahoma",Font.PLAIN, 25));
        panel.add(labelReport4);

        report4Cerinta=new JLabel("<html>Generate a report with the products ordered within a specified day with the number of times they have been ordered</html>");
        report4Cerinta.setBounds(10,410,500,50);
        panel.add(report4Cerinta);

        specificDay=new JLabel("Day specified:");
        specificDay.setBounds(10,460,150,20);
        specificDay.setFont(new Font("Tahoma", Font.PLAIN,18));
        panel.add(specificDay);

        dayText=new JTextField();
        dayText.setBounds(130,460,100,20);
        panel.add(dayText);

        report4Button=new JButton("Generate REPORT 4");
        report4Button.setBounds(300,460,170,20);
        panel.add(report4Button);

        back=new JButton("BACK");
        back.setBounds(180,510,150,20);
        panel.add(back);
    }

    //REPORT 1
    public String getStartHour()
    {
        return this.startHourText.getText();
    }

    public String getEndHour()
    {
        return this.endHourText.getText();
    }

    public void generateReport1Listener(ActionListener actionListener)
    {
        this.report1Button.addActionListener(actionListener);
    }

    //REPORT 2
    public int getNumberReport2()
    {
        String numarString=this.nrTimes.getText();
        int numarInt=Integer.parseInt(numarString);
        return numarInt;
    }

    public void generateReport2Listener(ActionListener actionListener)
    {
        this.report2Button.addActionListener(actionListener);
    }

    //REPORT 3
    public String getNrTimesReport3()
    {
        return this.nrOrderTimesText.getText();
    }

    public String getAmountReport3()
    {
        return this.amountText.getText();
    }

    public void generateReport3Listener(ActionListener actionListener)
    {
        this.report3Button.addActionListener(actionListener);
    }

    //REPORT 4
    public String getDayReport4()
    {
        return this.dayText.getText();
    }

    public void generateReport4Listener(ActionListener actionListener)
    {
        this.report4Button.addActionListener(actionListener);
    }

    //BACK
    public void backReportListener(ActionListener actionListener)
    {
        this.back.addActionListener(actionListener);
    }

}
