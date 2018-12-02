import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.TextArea;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GUI
{
   private JComboBox comboBoxType = new JComboBox();
   private JFrame frame;
   private VIABusModelManager manager = new VIABusModelManager();
   private JTextField textFieldModel;
   private JTextField textFieldSeats;
   private JPanel panel = new JPanel();
   JPanel panel_1 = new JPanel();
   JPanel panel_3 = new JPanel();
   private JTable table;
   private JTextField textFieldCName;
   private JTextField textFieldCAddress;
   private JTextField textFieldCID;
   private JTextField textFieldCPhone;
   private JTextField textFieldCMail;
   private JTable tableChauffeur;
   private JTextField textFieldFrom;
   private JTextField textFieldTo;
   private JTextField textFieldHour1;
   private JTextField textFieldMinute1;
   private JTextField textFieldHour2;
   private JTextField textFieldMinute2;
   private JTable tableChauffeurAvailable;

   private JTextField textFieldDay1;
   private JTextField textFieldMonth1;
   private JTextField textFieldYear1;
   private JTextField textFieldDay2;
   private JTextField textFieldMonth2;
   private JTextField textFieldYear2;
   private JTextField textFieldDay3;
   private JTextField textFieldMonth3;
   private JTextField textFieldYear3;
   private JTextField textFieldHour3;
   private JTextField textFieldMinute3;
   private JTextField textFieldMinute4;
   private JTextField textFieldHour4;
   private JTextField textFieldYear4;
   private JTextField textFieldMonth4;
   private JTextField textFieldDay4;
   private JTable table_1;
   private JTextField textFieldIndexC;
   private JTextField textFieldIndexB;
   JTextArea textArea_1 = new JTextArea();
   JTextArea textArea = new JTextArea();

   /**
    * Launch the application.
    */
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
      {
         public void run()
         {
            try
            {
               GUI window = new GUI();
               window.frame.setVisible(true);
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public GUI()
   {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize()
   {
      frame = new JFrame();
      frame.setBounds(100, 100, 903, 485);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.setSize(1200, 650);
      frame.setResizable(false);
      frame.getContentPane().setLayout(new BorderLayout(0, 0));

      JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
      frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
      MyDate date = new MyDate(5, 2, 2405);
      String[] string = new String[date.numberOfDaysInMonth()];
      for (int i = 0; i < date.numberOfDaysInMonth(); i++)
      {
         String temp = Integer.toString(i + 1);
         string[i] = temp;

      }

      JPanel panel_6 = new JPanel();
      tabbedPane.addTab("Home", null, panel_6, null);

      JPanel panel_2 = new JPanel();
      tabbedPane.addTab("Create tour", null, panel_2, null);
      panel_2.setLayout(null);

      textFieldFrom = new JTextField();
      textFieldFrom.setText("Horsens");
      textFieldFrom.setBounds(82, 34, 121, 20);
      panel_2.add(textFieldFrom);
      textFieldFrom.setColumns(10);

      textFieldTo = new JTextField();
      textFieldTo.setColumns(10);
      textFieldTo.setBounds(82, 65, 121, 20);
      panel_2.add(textFieldTo);

      textFieldHour1 = new JTextField();
      textFieldHour1.setBounds(390, 34, 28, 20);
      panel_2.add(textFieldHour1);
      textFieldHour1.setColumns(10);

      textFieldMinute1 = new JTextField();
      textFieldMinute1.setColumns(10);
      textFieldMinute1.setBounds(434, 34, 28, 20);
      panel_2.add(textFieldMinute1);

      JLabel label = new JLabel(":");
      label.setBounds(424, 37, 11, 14);
      panel_2.add(label);

      textFieldHour2 = new JTextField();
      textFieldHour2.setColumns(10);
      textFieldHour2.setBounds(390, 65, 28, 20);
      panel_2.add(textFieldHour2);

      JLabel label_2 = new JLabel(":");
      label_2.setBounds(424, 68, 11, 14);
      panel_2.add(label_2);

      textFieldMinute2 = new JTextField();
      textFieldMinute2.setColumns(10);
      textFieldMinute2.setBounds(434, 65, 28, 20);
      panel_2.add(textFieldMinute2);

      JLabel lblFrom = new JLabel("From");
      lblFrom.setBounds(26, 37, 46, 14);
      panel_2.add(lblFrom);

      JLabel lblTo = new JLabel("To");
      lblTo.setBounds(26, 68, 46, 14);
      panel_2.add(lblTo);

      JLabel lblReturn = new JLabel("Return");
      lblReturn.setBounds(513, 11, 46, 14);
      panel_2.add(lblReturn);

      // table_1.setModel(new DefaultTableModel(
      // manager.getAvailableBusesTypeTable(from, to, type),
      // new String[] {
      // "Name"
      // }
      // ));

      JComboBox comboBoxTourType = new JComboBox();
      comboBoxTourType.setBounds(82, 96, 121, 20);
      panel_2.add(comboBoxTourType);
      comboBoxTourType.setModel(new DefaultComboBoxModel(new String[] {
            "One-day trip", "Travel" }));

      JLabel lblType = new JLabel("Type");
      lblType.setBounds(26, 99, 46, 14);
      panel_2.add(lblType);

      // button.addActionListener(new ActionListener() {
      // public void actionPerformed(ActionEvent e) {
      // try{
      // String model=textFieldModel.getText();
      // String type=(String)comboBoxType.getSelectedItem();
      // int seats=Integer.parseInt(textFieldSeats.getText());
      // manager.addBus(model, type, seats);
      //
      // //// DefaultTableModel model1 = (DefaultTableModel) table.getModel();
      // model1.addRow(manager.getLastBus());}
      // catch(Exception e2){
      // JOptionPane.showMessageDialog(null, "Enter bus details correctly");}

      JButton btnSearchForBus = new JButton("Search for bus");
      btnSearchForBus.setBounds(311, 158, 121, 23);
      panel_2.add(btnSearchForBus);

      btnSearchForBus.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               
               MyDate from = new MyDate(Integer.parseInt(textFieldDay1
                     .getText()), Integer.parseInt(textFieldMonth1.getText()),
                     Integer.parseInt(textFieldYear1.getText()));
               MyDate to = new MyDate(Integer.parseInt(textFieldDay4
                     .getText()), Integer.parseInt(textFieldMonth4.getText()),
                     Integer.parseInt(textFieldYear4.getText()));
               textArea_1.setText(null);
               textArea_1.append(manager.getAvailableBuses(from, to).toString());

               // DefaultTableModel model1 = (DefaultTableModel)
               // tableBusAvailable.getModel();
               // tableBusAvailable.setModel(new
               // DefaultTableModel(manager.getAvailableBusesTable(departure,
               // arrival),new String[]{"Model","Type","Seats"}));

            }

            catch (Exception e2)
            {
               JOptionPane.showMessageDialog(null, "Enter time correctly ");
            }
         }
      });

      JButton btnsfc = new JButton("Search for chauffeur");
      btnsfc.setBounds(82, 160, 157, 23);
      panel_2.add(btnsfc);

      btnsfc.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {

               MyDate from = new MyDate(Integer.parseInt(textFieldDay1
                     .getText()), Integer.parseInt(textFieldMonth1.getText()),
                     Integer.parseInt(textFieldYear1.getText()));
               MyDate to = new MyDate(Integer.parseInt(textFieldDay4
                     .getText()), Integer.parseInt(textFieldMonth4.getText()),
                     Integer.parseInt(textFieldYear4.getText()));
               textArea.setText(null);
               textArea.append(manager.getAvailableChauffeurs(from, to).toString());
               ;

            }

            catch (Exception e2)
            {
               JOptionPane.showMessageDialog(null, "Enter time correctly ");
            }
         }
      });

      tabbedPane.addTab("Make reservation", null, panel, null);

      JPanel panel_5 = new JPanel();
      tabbedPane.addTab("Reserve Bus & Chauffeur", null, panel_5, null);

      tabbedPane.addTab("Buses", null, panel_3, null);
      panel_3.setLayout(null);

      JLabel lblModel = new JLabel("Model");
      lblModel.setBounds(87, 45, 42, 23);
      panel_3.add(lblModel);

      textFieldModel = new JTextField();
      textFieldModel.setFont(new Font("Tahoma", Font.PLAIN, 14));
      textFieldModel.setColumns(10);
      textFieldModel.setBounds(178, 43, 240, 23);
      panel_3.add(textFieldModel);

      JLabel lblSelectType = new JLabel("Type");
      lblSelectType.setBounds(87, 96, 42, 14);
      panel_3.add(lblSelectType);

      JLabel lblNumberOfSeats = new JLabel("Number of seats");
      lblNumberOfSeats.setBounds(45, 148, 110, 14);
      panel_3.add(lblNumberOfSeats);

      textFieldSeats = new JTextField();
      textFieldSeats.setColumns(10);
      textFieldSeats.setBounds(177, 144, 86, 23);
      panel_3.add(textFieldSeats);

      panel_1.setLayout(null);

      JButton btnQuit = new JButton("Save");
      btnQuit.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            tabbedPane.setSelectedIndex(2);
            tabbedPane.removeTabAt(3);

         }
      });
      btnQuit.setBounds(421, 147, 53, 23);
      panel_1.add(btnQuit);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(650, 45, 510, 397);
      panel_3.add(scrollPane);

      String[] columnNames = { "Model", "Type", "No. Seats" };

      Object[][] o;
      o = manager.getBusesTable();
      JTable table = new JTable(new DefaultTableModel(o, columnNames));

      table.getColumnModel().getColumn(0).setPreferredWidth(200);
      table.getColumnModel().getColumn(0).setMinWidth(50);
      table.getColumnModel().getColumn(0).setMaxWidth(400);
      table.getColumnModel().getColumn(1).setPreferredWidth(87);
      table.getColumnModel().getColumn(1).setMaxWidth(150);
      table.getColumnModel().getColumn(2).setMaxWidth(63);
      table.getColumnModel().getColumn(2).setMinWidth(63);
      table.getColumnModel().getColumn(2).setPreferredWidth(63);
      scrollPane.setViewportView(table);
      JButton button = new JButton("Add Bus");
      button.setFont(new Font("Tahoma", Font.PLAIN, 17));
      button.setBounds(178, 218, 105, 29);
      panel_3.add(button);

      button.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               String model = textFieldModel.getText();
               String type = (String) comboBoxType.getSelectedItem();
               int seats = Integer.parseInt(textFieldSeats.getText());
               manager.addBus(model, type, seats);

               DefaultTableModel model1 = (DefaultTableModel) table.getModel();
               model1.addRow(manager.getLastBus());
            }
            catch (Exception e2)
            {
               JOptionPane.showMessageDialog(null,
                     "Enter bus details correctly");
            }

         }

      });

      JButton btnRemoveBus = new JButton("Remove bus");
      btnRemoveBus.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {
               DefaultTableModel model = (DefaultTableModel) table.getModel();

               // JOptionPane.showMessageDialog(null, table.getSelectedRow());
               manager.removeBus(table.getSelectedRow());
               model.removeRow(table.getSelectedRow());

            }
            catch (Exception e1)
            {
               JOptionPane.showMessageDialog(null, "No bus selected");
            }

         }
      });
      btnRemoveBus.setFont(new Font("Tahoma", Font.PLAIN, 17));
      btnRemoveBus.setBounds(650, 484, 149, 37);
      panel_3.add(btnRemoveBus);

      textFieldDay1 = new JTextField();
      textFieldDay1.setBounds(238, 34, 28, 20);
      panel_2.add(textFieldDay1);
      textFieldDay1.setColumns(10);

      textFieldMonth1 = new JTextField();
      textFieldMonth1.setBounds(275, 34, 28, 20);
      panel_2.add(textFieldMonth1);
      textFieldMonth1.setColumns(10);

      textFieldYear1 = new JTextField();
      textFieldYear1.setBounds(310, 34, 61, 20);
      panel_2.add(textFieldYear1);
      textFieldYear1.setColumns(10);

      textFieldDay2 = new JTextField();
      textFieldDay2.setColumns(10);
      textFieldDay2.setBounds(238, 65, 28, 20);
      panel_2.add(textFieldDay2);

      textFieldMonth2 = new JTextField();
      textFieldMonth2.setColumns(10);
      textFieldMonth2.setBounds(275, 65, 28, 20);
      panel_2.add(textFieldMonth2);

      textFieldYear2 = new JTextField();
      textFieldYear2.setColumns(10);
      textFieldYear2.setBounds(310, 65, 61, 20);
      panel_2.add(textFieldYear2);

      textFieldDay3 = new JTextField();
      textFieldDay3.setColumns(10);
      textFieldDay3.setBounds(513, 34, 28, 20);
      panel_2.add(textFieldDay3);

      textFieldMonth3 = new JTextField();
      textFieldMonth3.setColumns(10);
      textFieldMonth3.setBounds(550, 34, 28, 20);
      panel_2.add(textFieldMonth3);

      textFieldYear3 = new JTextField();
      textFieldYear3.setColumns(10);
      textFieldYear3.setBounds(585, 34, 61, 20);
      panel_2.add(textFieldYear3);

      textFieldHour3 = new JTextField();
      textFieldHour3.setColumns(10);
      textFieldHour3.setBounds(665, 34, 28, 20);
      panel_2.add(textFieldHour3);

      JLabel label_1 = new JLabel(":");
      label_1.setBounds(699, 37, 11, 14);
      panel_2.add(label_1);

      textFieldMinute3 = new JTextField();
      textFieldMinute3.setColumns(10);
      textFieldMinute3.setBounds(709, 34, 28, 20);
      panel_2.add(textFieldMinute3);

      textFieldMinute4 = new JTextField();
      textFieldMinute4.setColumns(10);
      textFieldMinute4.setBounds(709, 65, 28, 20);
      panel_2.add(textFieldMinute4);

      JLabel label_3 = new JLabel(":");
      label_3.setBounds(699, 68, 11, 14);
      panel_2.add(label_3);

      textFieldHour4 = new JTextField();
      textFieldHour4.setColumns(10);
      textFieldHour4.setBounds(665, 65, 28, 20);
      panel_2.add(textFieldHour4);

      textFieldYear4 = new JTextField();
      textFieldYear4.setColumns(10);
      textFieldYear4.setBounds(585, 65, 61, 20);
      panel_2.add(textFieldYear4);

      textFieldMonth4 = new JTextField();
      textFieldMonth4.setColumns(10);
      textFieldMonth4.setBounds(550, 65, 28, 20);
      panel_2.add(textFieldMonth4);

      textFieldDay4 = new JTextField();
      textFieldDay4.setColumns(10);
      textFieldDay4.setBounds(513, 65, 28, 20);
      panel_2.add(textFieldDay4);

      JButton btnCreateTour = new JButton("Create Tour");
      btnCreateTour.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            try
            {

               MyDate date1 = new MyDate(Integer.parseInt(textFieldDay1
                     .getText()), Integer.parseInt(textFieldMonth1.getText()),
                     Integer.parseInt(textFieldYear1.getText()));

               MyDate date3 = new MyDate(Integer.parseInt(textFieldDay4
                     .getText()), Integer.parseInt(textFieldMonth4.getText()),
                     Integer.parseInt(textFieldYear4.getText()));
               MyDate date2 = new MyDate(Integer.parseInt(textFieldDay2
                     .getText()), Integer.parseInt(textFieldMonth2.getText()),
                     Integer.parseInt(textFieldYear2.getText()));
               MyDate date4 = new MyDate(Integer.parseInt(textFieldDay3
                     .getText()), Integer.parseInt(textFieldMonth3.getText()),
                     Integer.parseInt(textFieldYear3.getText()));
               String from = textFieldFrom.getText();
               String to = textFieldFrom.getText();

               int k = Integer.parseInt(textFieldIndexB.getText());
               Bus bus = manager.getAvailableBuses(date1, date4).getBus(k-1);
               
               int k2=Integer.parseInt(textFieldIndexC.getText());
               Chauffeur chauffeur = manager.getAvailableChauffeurs(date1,
                     date4).getChauffeur(k2-1);
               
               manager.createTour((String) comboBoxTourType.getSelectedItem(),
                     from, to, date1, date2, date3, date4, bus, chauffeur);

               // manager.createTour(comboBoxTourType.getSelectedItem().toString(),
               // from, to, date1, date2, date3, date4, bus, chauffeur);

               // BusList buses=bla.getAllBuses();

               // for(int i=0;i<bla.getSize();i++){
               // if(bus.equals(buses.getBus(i))){
               // buses.addBus(bus);
               // }
               // }
               // buses.addBus(bus);
               // buses.getBus(0).notAvailable(tour.getInterval());
               // bla.saveBuses(buses);

               JOptionPane.showMessageDialog(null, "Tour created successfully");

            }
            catch (Exception e2)
            {
               JOptionPane.showMessageDialog(null, "Enter all details");
            }

         }
      });
      btnCreateTour.setFont(new Font("Tahoma", Font.PLAIN, 17));
      btnCreateTour.setBounds(82, 503, 139, 35);
      panel_2.add(btnCreateTour);

      textFieldIndexC = new JTextField();
      textFieldIndexC.setBounds(153, 437, 86, 20);
      panel_2.add(textFieldIndexC);
      textFieldIndexC.setColumns(10);

      textFieldIndexB = new JTextField();
      textFieldIndexB.setBounds(367, 437, 86, 20);
      panel_2.add(textFieldIndexB);
      textFieldIndexB.setColumns(10);

      JLabel lblIndex = new JLabel("Index");
      lblIndex.setBounds(83, 440, 60, 14);
      panel_2.add(lblIndex);

      JLabel lblIndex_1 = new JLabel("Index");
      lblIndex_1.setBounds(311, 440, 46, 14);
      panel_2.add(lblIndex_1);
      textArea.setEditable(false);

      
      textArea.setBounds(82, 194, 162, 219);
      panel_2.add(textArea);
      textArea.append(manager.getAllChauffeurs().toString());
      textArea_1.setEditable(false);

      
      textArea_1.setBounds(311, 194, 219, 219);
      panel_2.add(textArea_1);
      textArea_1.append(manager.getAllBuses().toString());

      comboBoxType.setFont(new Font("Tahoma", Font.PLAIN, 13));
      comboBoxType.setModel(new DefaultComboBoxModel(new String[] { "Normal",
            "Minibus", "Luxury", "Party" }));
      comboBoxType.setBounds(178, 84, 105, 37);
      panel_3.add(comboBoxType);

      JPanel panel_4 = new JPanel();
      tabbedPane.addTab("Chauffeurs", null, panel_4, null);
      panel_4.setLayout(null);

      textFieldCName = new JTextField();
      textFieldCName.setBounds(148, 80, 163, 20);
      panel_4.add(textFieldCName);
      textFieldCName.setColumns(10);

      textFieldCAddress = new JTextField();
      textFieldCAddress.setColumns(10);
      textFieldCAddress.setBounds(148, 131, 163, 20);
      panel_4.add(textFieldCAddress);

      textFieldCID = new JTextField();
      textFieldCID.setColumns(10);
      textFieldCID.setBounds(148, 180, 163, 20);
      panel_4.add(textFieldCID);

      textFieldCPhone = new JTextField();
      textFieldCPhone.setColumns(10);
      textFieldCPhone.setBounds(148, 229, 163, 20);
      panel_4.add(textFieldCPhone);

      textFieldCMail = new JTextField();
      textFieldCMail.setColumns(10);
      textFieldCMail.setBounds(148, 277, 163, 25);
      panel_4.add(textFieldCMail);

      JLabel lblName = new JLabel("Name");
      lblName.setBounds(54, 82, 64, 17);
      panel_4.add(lblName);

      JLabel lblAddress = new JLabel("Address");
      lblAddress.setBounds(55, 134, 63, 14);
      panel_4.add(lblAddress);

      JLabel lblNewLabel = new JLabel("Employee ID");
      lblNewLabel.setBounds(54, 183, 84, 14);
      panel_4.add(lblNewLabel);

      JLabel lblPhoneNo = new JLabel("Phone no.");
      lblPhoneNo.setBounds(54, 232, 64, 14);
      panel_4.add(lblPhoneNo);

      JLabel lblEmail = new JLabel("E-mail address");
      lblEmail.setBounds(54, 282, 95, 14);
      panel_4.add(lblEmail);

      JScrollPane scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(521, 37, 609, 443);
      panel_4.add(scrollPane_1);
      String[] columnNamesChauffeur = { "Name", "Address", "ID", "Phone no.",
            "E-mail address" };
      tableChauffeur = new JTable(new DefaultTableModel(
            manager.getChauffeursTable(), columnNamesChauffeur));
      scrollPane_1.setViewportView(tableChauffeur);

      tableChauffeur.getColumnModel().getColumn(0).setPreferredWidth(120);
      tableChauffeur.getColumnModel().getColumn(0).setMinWidth(70);
      tableChauffeur.getColumnModel().getColumn(0).setMaxWidth(130);
      tableChauffeur.getColumnModel().getColumn(1).setPreferredWidth(140);
      tableChauffeur.getColumnModel().getColumn(1).setMaxWidth(150);
      tableChauffeur.getColumnModel().getColumn(2).setMaxWidth(50);
      tableChauffeur.getColumnModel().getColumn(2).setMinWidth(50);
      tableChauffeur.getColumnModel().getColumn(2).setPreferredWidth(50);
      tableChauffeur.getColumnModel().getColumn(3).setPreferredWidth(100);
      tableChauffeur.getColumnModel().getColumn(3).setMinWidth(50);
      tableChauffeur.getColumnModel().getColumn(3).setMaxWidth(120);
      tableChauffeur.getColumnModel().getColumn(4).setPreferredWidth(140);
      tableChauffeur.getColumnModel().getColumn(4).setMinWidth(140);
      tableChauffeur.getColumnModel().getColumn(4).setMaxWidth(200);

      JButton btnNewButton = new JButton("Add Chauffeur");
      btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
      btnNewButton.setBounds(148, 340, 147, 41);
      panel_4.add(btnNewButton);
      btnNewButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {

            try
            {
               String name = textFieldCName.getText();
               String address = textFieldCAddress.getText();
               int id = Integer.parseInt(textFieldCID.getText());
               String num = textFieldCPhone.getText();
               String mail = textFieldCMail.getText();
               manager.addChauffeur(name, address, id, num, mail);
               DefaultTableModel model = (DefaultTableModel) tableChauffeur
                     .getModel();
               model.addRow(manager.getLastChauffeur());
            }
            catch (Exception e2)
            {
               JOptionPane.showMessageDialog(null,
                     "Enter chauffeur details correctly");
            }

         }
      });

      JButton btnRemoveChauffeur = new JButton("Remove Chauffeur");
      btnRemoveChauffeur.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            try
            {
               DefaultTableModel model = (DefaultTableModel) tableChauffeur.getModel();

               // JOptionPane.showMessageDialog(null, table.getSelectedRow());
               manager.removeChauffeur(tableChauffeur.getSelectedRow());
               model.removeRow(tableChauffeur.getSelectedRow());

            }
            catch (Exception e1)
            {
               JOptionPane.showMessageDialog(null, "No chauffeur selected");
            }

         }
      });
            
            
            
            
            
       
      btnRemoveChauffeur.setFont(new Font("Tahoma", Font.PLAIN, 17));
      btnRemoveChauffeur.setBounds(923, 519, 207, 41);
      panel_4.add(btnRemoveChauffeur);

      JButton btnViewSchedule = new JButton("View Schedule");
      btnViewSchedule.setFont(new Font("Tahoma", Font.PLAIN, 17));
      btnViewSchedule.setBounds(521, 519, 155, 41);
      panel_4.add(btnViewSchedule);

      JPanel customerPanel = new JPanel(new BorderLayout(5, 5));

   }
}
