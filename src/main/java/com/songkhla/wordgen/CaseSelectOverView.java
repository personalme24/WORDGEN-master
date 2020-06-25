/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import com.google.gson.JsonObject;
import static com.songkhla.wordgen.ActionPageInsert.ActionCrimes;
import static com.songkhla.wordgen.ActionPageInsert.ActionDetail;
import static com.songkhla.wordgen.ActionPageInsert.ActionNote;
import static com.songkhla.wordgen.Send_HTTP_Request2.NewDate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JSpinner;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DateFormatter;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
/**
 *
 * @author Petpilin
 */
public class CaseSelectOverView extends javax.swing.JDialog {

    /**
     * Creates new form CrimesCaseView
     */
 

    Connection con=null;
    PreparedStatement pst=null;
     JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame facc = (JFrame)(dialog.getParent());
      JDatePickerImpl DateAcceptStart,DateAcceptEnd,DateReqStart,DateReqEnd,DateAcceptStartTC,DateAcceptEndTC,DateReqStartTC,DateReqEndTC;

    public CaseSelectOverView(JFrame parrent) {
                super(parrent,true);

        initComponents();
        ImageIcon img = new ImageIcon("./Master/WD.png");
        setIconImage(img.getImage());
        setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
          try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,36f);
                     jLabel1.setFont(sizedFont);
         Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                 Font  labelother = font2.deriveFont(1,22f); 
                 jTabbedPane1.setFont(labelother);
                 jTableTraffic.getTableHeader().setFont(labelother);
                 jTableCrime.getTableHeader().setFont(labelother);
                  jTableCrime.getTableHeader().setOpaque(false);
                    Font  labelname = font2.deriveFont(1,20f); 
                     jLabel10.setFont(labelname);
                     jLabel28.setFont(labelname);
                     jLabel25.setFont(labelname);
                     jLabel7.setFont(labelname);
                     jLabel8.setFont(labelname);
                     jLabel16.setFont(labelname);
                     jLabel18.setFont(labelname);
                     jLabel17.setFont(labelname);
                      jLabel9.setFont(labelname);
                     jLabel11.setFont(labelname);
                     jLabel14.setFont(labelname);
                     jLabel15.setFont(labelname);
                     
                     jLabel23.setFont(labelname);
                        jLabel27.setFont(labelname);
                     jLabel37.setFont(labelname);
                     jLabel19.setFont(labelname);
                     jLabel20.setFont(labelname);
                     jLabel38.setFont(labelname);
                     jLabel40.setFont(labelname);
                     jLabel39.setFont(labelname);
                      jLabel21.setFont(labelname);
                     jLabel22.setFont(labelname);
                     jLabel24.setFont(labelname);
                     jLabel26.setFont(labelname);
                     
                      Font  labelRemark = font2.deriveFont(1,18f); 
                     jLabel4.setFont(labelRemark);
                     jLabel6.setFont(labelRemark);
                     jLabel3.setFont(labelRemark);
                     jLabel5.setFont(labelRemark);
//            Font font1 = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun.ttf"));
//            Font  formFont = font1.deriveFont(1,20f);
                   
             Font  font20 = font2.deriveFont(1,20f);
                         jLabelorgcode.setFont(font20 );
                     orgnamelabel.setFont(font20 );
                      casenocc.setFont(font20 );
                     caseyearscc.setFont(font20 );
                      casenocc1.setFont(font20 );
                     casenocc3.setFont(font20 );
                      caseyearscc1.setFont(font20 );
                      jButtonConCrime.setFont(font20 );
                      jButton3.setFont(font20 );
                      jButtonConTraffic.setFont(font20 );
                      jButton7.setFont(font20 );
//                     jLabel10.setFont(labelother);
//                     jLabel11.setFont(labelother);
//                     jLabel12.setFont(labelother);
                     
               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
        jLabel2.setVisible(false);
        jPanel7.setVisible(true);
        jTableCrime.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableCrime.setPreferredScrollableViewportSize(Toolkit.getDefaultToolkit().getScreenSize());
                jTableCrime.getColumnModel().getColumn(0).setMinWidth(15);
                  jTableCrime.getColumnModel().getColumn(1).setMinWidth(75);
              jTableCrime.getColumnModel().getColumn(2).setWidth(0);
                jTableCrime.getColumnModel().getColumn(2).setMinWidth(0);
                jTableCrime.getColumnModel().getColumn(2).setMaxWidth(0); 
                 jTableCrime.getColumnModel().getColumn(3).setWidth(0);
                jTableCrime.getColumnModel().getColumn(3).setMinWidth(0);
                jTableCrime.getColumnModel().getColumn(3).setMaxWidth(0);
         jTableCrime.getColumnModel().getColumn(4).setMinWidth(150);
         jTableCrime.getColumnModel().getColumn(5).setMinWidth(250);
         jTableCrime.getColumnModel().getColumn(6).setMinWidth(250);
                  jTableCrime.getColumnModel().getColumn(7).setMinWidth(250);
         jTableCrime.getColumnModel().getColumn(8).setMinWidth(250);
               jTableTraffic.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableTraffic.setPreferredScrollableViewportSize(Toolkit.getDefaultToolkit().getScreenSize());
                jTableTraffic.getColumnModel().getColumn(0).setMinWidth(15);
                  jTableTraffic.getColumnModel().getColumn(1).setMinWidth(75);
               jTableTraffic.getColumnModel().getColumn(2).setWidth(0);
                jTableTraffic.getColumnModel().getColumn(2).setMinWidth(0);
                jTableTraffic.getColumnModel().getColumn(2).setMaxWidth(0); 
                 jTableTraffic.getColumnModel().getColumn(3).setWidth(0);
                jTableTraffic.getColumnModel().getColumn(3).setMinWidth(0);
                jTableTraffic.getColumnModel().getColumn(3).setMaxWidth(0);
         jTableTraffic.getColumnModel().getColumn(4).setMinWidth(150);
         jTableTraffic.getColumnModel().getColumn(5).setMinWidth(250);
         jTableTraffic.getColumnModel().getColumn(6).setMinWidth(250);
                  jTableTraffic.getColumnModel().getColumn(7).setMinWidth(250);
         jTableTraffic.getColumnModel().getColumn(8).setMinWidth(250);
//        jButton2.setVisible(false);
//        jButton1.setVisible(false);
//        jLabelorgcode.setVisible(false);
jlabeltoken.setVisible(true);
    DataCase tt=new DataCase();
   jlabeltoken.setText(tt.getToken());
        idcardlabel.setVisible(false);
        usernamelabel.setVisible(false);
        orgnamelabel.setVisible(true);
        DataUser();
//    RefreshDataCrime();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      UtilDateModel model = new UtilDateModel();
//           Calendar c = Calendar.getInstance();   // this takes current date
//           c.set(Calendar.DAY_OF_MONTH, 1);
            model.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();        
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
         DateAcceptStart = new JDatePickerImpl(datePanel,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,32));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptStart.setTextEditable(true);
//        DateAcceptStart.setBackground(Color.WHITE);
        jPanelStAcc.setLayout(new FlowLayout());
        jPanelStAcc.add(DateAcceptStart);
        
          UtilDateModel model2 = new UtilDateModel();
            model2.setValue(Calendar.getInstance().getTime());
   
        JDatePanelImpl datePane2 = new JDatePanelImpl(model2,p);
         DateAcceptEnd = new JDatePickerImpl(datePane2,new DateLabelFormatter());
//           DateAcceptEnd.setPreferredSize(new Dimension(220,30));
//    DateAcceptEnd.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptEnd.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptEnd.setTextEditable(true);
//        DateAcceptEnd.setBackground(Color.WHITE);
        jPanelEnAcc.setLayout(new FlowLayout());
        jPanelEnAcc.add(DateAcceptEnd);    
        
        UtilDateModel model3 = new UtilDateModel();
            model3.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane3 = new JDatePanelImpl(model3,p);
         DateAcceptStartTC = new JDatePickerImpl(datePane3,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptStartTC.setTextEditable(true);
//        DateAcceptStartTC.setBackground(Color.WHITE);
        jPanel4.setLayout(new FlowLayout());
        jPanel4.add(DateAcceptStartTC);    
        
        UtilDateModel model4 = new UtilDateModel();
            model4.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane4 = new JDatePanelImpl(model4,p);
         DateAcceptEndTC = new JDatePickerImpl(datePane4,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateAcceptEndTC.setTextEditable(true);
//        DateAcceptEndTC.setBackground(Color.WHITE);
        jPanel5.setLayout(new FlowLayout());
        jPanel5.add(DateAcceptEndTC);  
        
          UtilDateModel model5 = new UtilDateModel();
            model5.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane5 = new JDatePanelImpl(model5,p);
         DateReqStart= new JDatePickerImpl(datePane5,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateReqStart.setTextEditable(true);
//        DateReqStart.setBackground(Color.WHITE);
        jPanelReg.setLayout(new FlowLayout());
        jPanelReg.add(DateReqStart);  
        
          UtilDateModel model6 = new UtilDateModel();
            model6.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane6 = new JDatePanelImpl(model6,p);
         DateReqEnd = new JDatePickerImpl(datePane6,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateReqEnd.setTextEditable(true);
//        DateReqEnd.setBackground(Color.WHITE);
        jPanelReg2.setLayout(new FlowLayout());
        jPanelReg2.add(DateReqEnd);  
        
         UtilDateModel model7 = new UtilDateModel();
            model7.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane7 = new JDatePanelImpl(model7,p);
         DateReqStartTC = new JDatePickerImpl(datePane7,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateReqStartTC.setTextEditable(true);
        jPanelRegTCS.setLayout(new FlowLayout());
        jPanelRegTCS.add(DateReqStartTC);  
        
             UtilDateModel model8 = new UtilDateModel();
            model8.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePane8 = new JDatePanelImpl(model8,p);
         DateReqEndTC = new JDatePickerImpl(datePane8,new DateLabelFormatter());
//           DateAcceptStart.setPreferredSize(new Dimension(220,30));
//    DateAcceptStart.getComponent(0).setPreferredSize(new Dimension(190,32)); //JFormattedTextField
//    DateAcceptStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateReqEndTC.setTextEditable(true);
//        DateReqEndTC.setBackground(Color.WHITE);
          jPanelRegTCE.setLayout(new FlowLayout());
        jPanelRegTCE.add(DateReqEndTC);  
        
       
        
         DateReqStart.getJFormattedTextField().setText("");
        DateReqStart.getComponent(1).setEnabled(false);
       DateReqStart.getJFormattedTextField().setEnabled(false);
        DateReqEnd.getJFormattedTextField().setText("");
      DateReqEnd.getComponent(1).setEnabled(false);
       DateReqEnd.getJFormattedTextField().setEnabled(false); 
       
       DateAcceptStart.getJFormattedTextField().setText("");
        DateAcceptStart.getComponent(1).setEnabled(false);
       DateAcceptStart.getJFormattedTextField().setEnabled(false);
        DateAcceptEnd.getJFormattedTextField().setText("");
      DateAcceptEnd.getComponent(1).setEnabled(false);
       DateAcceptEnd.getJFormattedTextField().setEnabled(false); 
       
         casenocc.setEnabled(false);
         casenocc1.setEnabled(false);
         casenocc3.setEnabled(false);
         caseyearscc.setEnabled(false);
         caseyearscc1.setEnabled(false);     
         
             DateReqStartTC.getJFormattedTextField().setText("");
        DateReqStartTC.getComponent(1).setEnabled(false);
       DateReqStartTC.getJFormattedTextField().setEnabled(false);
        DateReqEndTC.getJFormattedTextField().setText("");
      DateReqEndTC.getComponent(1).setEnabled(false);
       DateReqEndTC.getJFormattedTextField().setEnabled(false); 
       
       DateAcceptStartTC.getJFormattedTextField().setText("");
        DateAcceptStartTC.getComponent(1).setEnabled(false);
       DateAcceptStartTC.getJFormattedTextField().setEnabled(false);
        DateAcceptEndTC.getJFormattedTextField().setText("");
      DateAcceptEndTC.getComponent(1).setEnabled(false);
       DateAcceptEndTC.getJFormattedTextField().setEnabled(false); 
       
         casenocc4.setEnabled(false);
         casenocc5.setEnabled(false);
         casenocc6.setEnabled(false);
         caseyearscc3.setEnabled(false);
         caseyearscc4.setEnabled(false);   

    }
// 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idcardlabel = new javax.swing.JLabel();
        usernamelabel = new javax.swing.JLabel();
        jlabeltoken = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        casenocc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanelStAcc = new javax.swing.JPanel();
        jPanelEnAcc = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabelorgcode = new javax.swing.JLabel();
        caseyearscc = new javax.swing.JTextField();
        jPanelReg = new javax.swing.JPanel();
        jPanelReg2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButtonConCrime = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        orgnamelabel = new javax.swing.JLabel();
        caseyearscc1 = new javax.swing.JTextField();
        casenocc1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        casenocc3 = new javax.swing.JTextField();
        jCheckDateReg = new javax.swing.JCheckBox();
        jCheckAccept = new javax.swing.JCheckBox();
        jCheckCaseTwo = new javax.swing.JCheckBox();
        jCheckCase = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCrime = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        TotalCase = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        casenocc4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabelorgcode1 = new javax.swing.JLabel();
        caseyearscc3 = new javax.swing.JTextField();
        jPanelRegTCS = new javax.swing.JPanel();
        jPanelRegTCE = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButtonConTraffic = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        orgnamelabel1 = new javax.swing.JLabel();
        caseyearscc4 = new javax.swing.JTextField();
        casenocc5 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        casenocc6 = new javax.swing.JTextField();
        jCheckDateReg1 = new javax.swing.JCheckBox();
        jCheckAccept1 = new javax.swing.JCheckBox();
        jCheckCaseTwo1 = new javax.swing.JCheckBox();
        jCheckCaseT = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTraffic = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        TotalCase1 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 93, 179));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setMaximumSize(new Dimension(1280, 720));
        jPanel1.setMinimumSize(new Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ข้อมูลคดีระบบ CRIMES ในความรับผิดชอบ");

        idcardlabel.setText("jLabel13");

        usernamelabel.setText("jLabel12");

        jLabel2.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(idcardlabel)
                .addGap(32, 32, 32)
                .addComponent(usernamelabel)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(262, 262, 262)
                .addComponent(jlabeltoken, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlabeltoken, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idcardlabel)
                        .addComponent(usernamelabel)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ข้อมูลคดีที่ต้องการจากระบบ CRIMES ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 20))); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(1000, 135));
        jPanel7.setRequestFocusEnabled(false);

        casenocc.setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        casenocc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casenoccKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel7.setText("เลขคดี");

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel8.setText("ปี");

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel9.setText("วันที่รับคดี");
        jLabel9.setPreferredSize(new java.awt.Dimension(57, 30));

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel11.setText("ถึงวันที่");
        jLabel11.setPreferredSize(new java.awt.Dimension(39, 30));

        javax.swing.GroupLayout jPanelStAccLayout = new javax.swing.GroupLayout(jPanelStAcc);
        jPanelStAcc.setLayout(jPanelStAccLayout);
        jPanelStAccLayout.setHorizontalGroup(
            jPanelStAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        jPanelStAccLayout.setVerticalGroup(
            jPanelStAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelEnAcc.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanelEnAccLayout = new javax.swing.GroupLayout(jPanelEnAcc);
        jPanelEnAcc.setLayout(jPanelEnAccLayout);
        jPanelEnAccLayout.setHorizontalGroup(
            jPanelEnAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelEnAccLayout.setVerticalGroup(
            jPanelEnAccLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel10.setText("รหัสสถานี :");

        jLabelorgcode.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        caseyearscc.setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        caseyearscc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caseyearsccKeyTyped(evt);
            }
        });

        jPanelReg.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanelRegLayout = new javax.swing.GroupLayout(jPanelReg);
        jPanelReg.setLayout(jPanelRegLayout);
        jPanelRegLayout.setHorizontalGroup(
            jPanelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelRegLayout.setVerticalGroup(
            jPanelRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelReg2.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanelReg2Layout = new javax.swing.GroupLayout(jPanelReg2);
        jPanelReg2.setLayout(jPanelReg2Layout);
        jPanelReg2Layout.setHorizontalGroup(
            jPanelReg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelReg2Layout.setVerticalGroup(
            jPanelReg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel14.setText("วันที่รับแจ้ง");

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel15.setText("ถึงวันที่");

        jButtonConCrime.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonConCrime.setText("เชื่อมต่อข้อมูล");
        jButtonConCrime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConCrimeActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel25.setText("สถานะคดี : ระหว่างสอบสวน");

        orgnamelabel.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        caseyearscc1.setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        caseyearscc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caseyearscc1KeyTyped(evt);
            }
        });

        casenocc1.setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        casenocc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casenocc1KeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel16.setText("ระหว่างเลขคดี");

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel17.setText("ปี");

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel18.setText("ถึงเลขคดี");

        casenocc3.setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        casenocc3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casenocc3KeyTyped(evt);
            }
        });

        jCheckDateReg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckDateRegItemStateChanged(evt);
            }
        });

        jCheckAccept.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckAcceptItemStateChanged(evt);
            }
        });

        jCheckCaseTwo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckCaseTwoItemStateChanged(evt);
            }
        });

        jCheckCase.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckCaseItemStateChanged(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jLabel28.setText("สถานี :");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckDateReg)
                            .addComponent(jCheckAccept)
                            .addComponent(jCheckCase))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jPanelReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelReg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jPanelStAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelEnAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(10, 10, 10)
                                .addComponent(casenocc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(caseyearscc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckCaseTwo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))
                                    .addComponent(orgnamelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(casenocc1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(casenocc3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(caseyearscc1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel25)))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelorgcode, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(548, 548, 548)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addComponent(jButtonConCrime)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelorgcode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(orgnamelabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casenocc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caseyearscc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(casenocc1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casenocc3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckCaseTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caseyearscc1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckCase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConCrime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelStAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelEnAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckAccept, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckDateReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jPanelReg, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelReg2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addContainerGap(38, Short.MAX_VALUE))))
        );

        jTableCrime.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jTableCrime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "เลือก", "คดีที่/ปี", "เลขคดี", "ปี", "วันที่รับคำร้องทุกข์", "ข้อหา", "ผู้ต้องหา", "ผู้กล่าวหา", "ผู้รับผิดชอบ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCrime.setRowHeight(25);
        jScrollPane2.setViewportView(jTableCrime);
        if (jTableCrime.getColumnModel().getColumnCount() > 0) {
            jTableCrime.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton3.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jButton3.setText("ตกลง");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        TotalCase.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        TotalCase.setText("0");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jLabel13.setText("คดี");

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jLabel12.setText("จำนวนคดีทั้งหมด");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        jLabel4.setText("**กรณีที่มีการเลือกคดีจากระบบ CRIMES ซ้ำกับคดีที่มีอยู่ในโปรแกรม หากทำการยืนยันการดึงข้อมูลคดี ");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        jLabel5.setText("ข้อมูลคดีจากระบบ CRIMES จะแทนที่ข้อมูลเดิมทั้งหมดของคดีที่ได้ทำการเลือก");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addComponent(TotalCase)
                .addGap(12, 12, 12)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel5))
                    .addComponent(jLabel4)
                    .addComponent(jLabel12)
                    .addComponent(TotalCase)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(438, 438, 438))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 627, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("คดีอาญา", jPanel6);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ข้อมูลคดีที่ต้องการจากระบบ CRIMES ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("TH SarabunPSK", 1, 20))); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(1000, 135));
        jPanel8.setRequestFocusEnabled(false);

        casenocc4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casenocc4KeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("เลขคดี");

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel20.setText("ปี");

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("วันที่รับคดี");
        jLabel21.setPreferredSize(new java.awt.Dimension(57, 30));

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel22.setText("ถึงวันที่");
        jLabel22.setPreferredSize(new java.awt.Dimension(39, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel23.setText("รหัสสถานี :");

        jLabelorgcode1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N

        caseyearscc3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caseyearscc3KeyTyped(evt);
            }
        });

        jPanelRegTCS.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanelRegTCSLayout = new javax.swing.GroupLayout(jPanelRegTCS);
        jPanelRegTCS.setLayout(jPanelRegTCSLayout);
        jPanelRegTCSLayout.setHorizontalGroup(
            jPanelRegTCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelRegTCSLayout.setVerticalGroup(
            jPanelRegTCSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelRegTCE.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanelRegTCELayout = new javax.swing.GroupLayout(jPanelRegTCE);
        jPanelRegTCE.setLayout(jPanelRegTCELayout);
        jPanelRegTCELayout.setHorizontalGroup(
            jPanelRegTCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanelRegTCELayout.setVerticalGroup(
            jPanelRegTCELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel24.setText("วันที่รับแจ้ง");

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel26.setText("ถึงวันที่");

        jButtonConTraffic.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonConTraffic.setText("เชื่อมต่อข้อมูล");
        jButtonConTraffic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConTrafficActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel37.setText("สถานะคดี : ระหว่างสอบสวน");

        orgnamelabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N

        caseyearscc4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                caseyearscc4KeyTyped(evt);
            }
        });

        casenocc5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casenocc5KeyTyped(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel38.setText("ระหว่างเลขคดี");

        jLabel39.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel39.setText("ปี");

        jLabel40.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel40.setText("ถึงเลขคดี");

        casenocc6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casenocc6KeyTyped(evt);
            }
        });

        jCheckDateReg1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckDateReg1ItemStateChanged(evt);
            }
        });

        jCheckAccept1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckAccept1ItemStateChanged(evt);
            }
        });

        jCheckCaseTwo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckCaseTwo1ItemStateChanged(evt);
            }
        });

        jCheckCaseT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckCaseTItemStateChanged(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel27.setText("สถานี :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckDateReg1)
                            .addComponent(jCheckAccept1)
                            .addComponent(jCheckCaseT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jPanelRegTCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelRegTCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(10, 10, 10)
                                .addComponent(casenocc4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(caseyearscc3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckCaseTwo1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(casenocc5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(casenocc6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(caseyearscc4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(orgnamelabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel37))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelorgcode1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConTraffic))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelorgcode1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orgnamelabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casenocc4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caseyearscc3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(casenocc5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(casenocc6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckCaseTwo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caseyearscc4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckCaseT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConTraffic, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckAccept1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckDateReg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jPanelRegTCS, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelRegTCE, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );

        jTableTraffic.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jTableTraffic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "เลือก", "คดีที่/ปี", "เลขคดี", "ปี", "วันที่รับคำร้องทุกข์", "ข้อหา", "ผู้ต้องหา", "ผู้กล่าวหา", "ผู้รับผิดชอบ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableTraffic.setRowHeight(25);
        jTableTraffic.getTableHeader().setOpaque(false);
        jScrollPane3.setViewportView(jTableTraffic);
        if (jTableTraffic.getColumnModel().getColumnCount() > 0) {
            jTableTraffic.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton7.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jButton7.setText("ตกลง");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        TotalCase1.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        TotalCase1.setText("0");

        jLabel41.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jLabel41.setText("คดี");

        jLabel42.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jLabel42.setText("จำนวนคดีทั้งหมด");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel6.setText("**กรณีที่มีการเลือกคดีจากระบบ CRIMES ซ้ำกับคดีที่มีในโปรแกรม หากทำการยืนยันการดึงข้อมูลคดี ");

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel3.setText("ข้อมูลคดีจากระบบ CRIMES จะแทนที่ข้อมูลเดิมทั้งหมดของคดีที่ได้ทำการเลือก");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3)))
                        .addGap(457, 457, 457)
                        .addComponent(jLabel42)
                        .addGap(10, 10, 10)
                        .addComponent(TotalCase1)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel41)
                        .addGap(22, 22, 22)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1209, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel42)
                        .addComponent(TotalCase1)
                        .addComponent(jLabel41)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("คดีจราจร", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);    
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    private int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        return month;
    }

    private int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day;
    }
      public static int calculateDate(String DateSt,String DateEn)
   {
      int st = 0;
      String age="";

       try{
   if(DateSt.equals("")&&DateEn.equals("")){
   st=1;
   }
   else{
   Locale lc = new Locale("th","TH");
   SimpleDateFormat ch = new SimpleDateFormat("dd/M/yyyy",lc);
   Date a = ch.parse(DateSt);
   Date b = ch.parse(DateEn);
   
//    Calendar cal = Calendar.getInstance();
//          cal.setTime(a); 
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy",lc);
   SimpleDateFormat formonth = new SimpleDateFormat("M",lc);
   SimpleDateFormat fordate= new SimpleDateFormat("d",lc);
  String cc = sdf.format(a);
  String mBd=formonth.format(a);
    String dBd=fordate.format(a);
 System.out.println("d1"+dBd);
  int  yearBd=Integer.valueOf(cc);
  int  dateBd=Integer.valueOf(dBd);

           System.out.println("ss"+cc);
           String y2Day=sdf.format(b);
           String mEn=formonth.format(b);
           String d2Day=fordate.format(new Date());
 System.out.println("d2"+d2Day);

            System.out.println("toyear"+y2Day);
             int  thisyear=Integer.valueOf(y2Day);
                int  monthEnd=Integer.valueOf(mEn);
                System.out.println("monthEnd"+monthEnd);
                 int  monthStar=Integer.valueOf(mBd);
                System.out.println("monthStar"+monthStar);

                int  thisday=Integer.valueOf(d2Day);
                int calM=monthEnd-monthStar;
                int calY=thisyear-yearBd;
                System.out.println("YYYYYYYYYYYYYYY"+calY); 
                   System.out.println("fffffffff"+calM); 
                   if(calY ==0){
                     if((calM >= 0 && calM <=3)){
                          st=1;                 
                            }
                        else{
                         st=0;
                        }                 
                   }
                   else if(calY == 1){
                     if((calM >= -11 && calM <=-10)){
                          st=1;           
                            }               
                        else{
                         st=0;
                        }                  
                   }
                        else{
                         st=0;
                        }
   }
                       
           System.out.println("status:"+st);
       }catch(Exception e){
              
//           e.printStackTrace();
       
       }
            return st;

   }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                ArrayList<String> casenoList = new ArrayList<String>();

            Boolean ch=false;
              for (int i = 0; i < jTableCrime.getRowCount(); i++) {
            Boolean chked = Boolean.valueOf(jTableCrime.getValueAt(i, 0).toString()); 
            if(chked){
            casenoList.add(i+"");
            }
//            else{
//                ch=false;
//            }
          } 
              System.out.println("boo:"+ch);
            if (casenoList.size()>0) {
            new BackgroundWorkerInsert().execute();
                    }
            else{
              JOptionPane.showMessageDialog(null, "กรุณาทำการเลือกคดีที่ต้องการ");
            }
//       new BackgroundWorkerInsert().execute();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonConCrimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConCrimeActionPerformed
        // TODO add your handling code here:
        String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token:"+aa); 
        String case1="",case2="",yearcase="";
        String date1=DateAcceptStart.getJFormattedTextField().getText();
        String date2=DateAcceptEnd.getJFormattedTextField().getText();
        String dateR1=DateReqStart.getJFormattedTextField().getText();
        String dateR2=DateReqEnd.getJFormattedTextField().getText();
     
//        if(jCheckCase.isSelected()){
//          case1=casenocc.getText();
//          case2=casenocc.getText();
//          yearcase=caseyearscc.getText();
//        }
//        else if(jCheckCaseTwo.isSelected()){
//        case1=casenocc1.getText();
//          case2=casenocc3.getText();
//          yearcase=caseyearscc1.getText();
//        }
        if(jCheckCase.isSelected()||jCheckCaseTwo.isSelected()||jCheckAccept.isSelected()||jCheckDateReg.isSelected()){
                


          if(jCheckCase.isSelected()&&jCheckDateReg.isSelected()&&jCheckAccept.isSelected()){
                      System.out.println("L1");
                         if(caseyearscc.getText().equals("")&&casenocc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
                        else  if(DateReqStart.getJFormattedTextField().getText().equals("")||DateReqEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else   if(DateAcceptStart.getJFormattedTextField().getText().equals("")||DateAcceptEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0||calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
                         }
          
              else if(jCheckCaseTwo.isSelected()&&jCheckDateReg.isSelected()&&jCheckAccept.isSelected()){
                System.out.println("L2");
                        if(caseyearscc1.getText().equals("")&&casenocc3.getText().equals("")&&casenocc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc1.getText().equals("")||casenocc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
                           else  if(DateReqStart.getJFormattedTextField().getText().equals("")||DateReqEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else   if(DateAcceptStart.getJFormattedTextField().getText().equals("")||DateAcceptEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0||calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
            }
              
             else if(jCheckCase.isSelected()&&jCheckAccept.isSelected()){
                System.out.println("L3");
                 if(caseyearscc.getText().equals("")&&casenocc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
 
                        else if(DateAcceptStart.getJFormattedTextField().getText().equals("")||DateAcceptEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
            }
             
            else   if(jCheckCase.isSelected()&&jCheckDateReg.isSelected()){
                System.out.println("L4");
                 if(caseyearscc.getText().equals("")&&casenocc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
               else  if(DateReqStart.getJFormattedTextField().getText().equals("")||DateReqEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
            }
            
              else if(jCheckCaseTwo.isSelected()&&jCheckAccept.isSelected()){
                        System.out.println("L5");
                        if(caseyearscc1.getText().equals("")&&casenocc3.getText().equals("")&&casenocc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc1.getText().equals("")||casenocc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
                        else if(DateAcceptStart.getJFormattedTextField().getText().equals("")||DateAcceptEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
            }
              
               else   if(jCheckCaseTwo.isSelected()&&jCheckDateReg.isSelected()){
                System.out.println("L6");
                if(caseyearscc1.getText().equals("")&&casenocc3.getText().equals("")&&casenocc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc1.getText().equals("")||casenocc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
               else  if(DateReqStart.getJFormattedTextField().getText().equals("")||DateReqEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
            }
               
           else if(jCheckDateReg.isSelected()&&jCheckAccept.isSelected()){
                System.out.println("L7");
                 if(DateReqStart.getJFormattedTextField().getText().equals("")||DateReqEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else   if(DateAcceptStart.getJFormattedTextField().getText().equals("")||DateAcceptEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0||calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
            }
           else if(jCheckCase.isSelected()){
               System.out.println("L8");
                        if(caseyearscc.getText().equals("")&&casenocc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
                        else{connect_crime();}
           }
           else if(jCheckCaseTwo.isSelected()){
               System.out.println("L9");
                         if(caseyearscc1.getText().equals("")&&casenocc3.getText().equals("")&&casenocc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc1.getText().equals("")||casenocc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc1.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
                        else{ connect_crime();}
           }
         else if(jCheckAccept.isSelected()){
               System.out.println("L10");
                          if(DateAcceptStart.getJFormattedTextField().getText().equals("")||DateAcceptEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
           }
           else if(jCheckDateReg.isSelected()){
               System.out.println("L11");
                           if(DateReqStart.getJFormattedTextField().getText().equals("")||DateReqEnd.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_crime();}
           }
            
        }
        else{
         JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลคดีที่ต้องการจากระบบ CRIMES");   
        }
        
   
         
        
        
        
       
       
    }//GEN-LAST:event_jButtonConCrimeActionPerformed
    private  void connect_crime(){
            String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token:"+aa); 
        String case1="",case2="",yearcase="";
        String date1=DateAcceptStart.getJFormattedTextField().getText();
        String date2=DateAcceptEnd.getJFormattedTextField().getText();
        String dateR1=DateReqStart.getJFormattedTextField().getText();
        String dateR2=DateReqEnd.getJFormattedTextField().getText();
        System.out.println("dsdfsffffffffff");
//           if(jCheckCase.isSelected()){
//          case1=casenocc.getText();
//          case2=casenocc.getText();
//          yearcase=caseyearscc.getText();
//        }
//        else if(jCheckCaseTwo.isSelected()){
//        case1=casenocc1.getText();
//          case2=casenocc3.getText();
//          yearcase=caseyearscc1.getText();
//        }
            if(aa == null){
            System.out.println("empty:");
            JFrame frame = new JFrame();
            JDialog dialog = new JDialog(frame);//frame is owner
            JFrame asv = (JFrame)(dialog.getParent());
            asv.removeAll();
            LogInConfirm lc=new LogInConfirm(asv);
            lc.pack();
            lc.setLocationRelativeTo(null);
            lc.setVisible(true);  
            aa=MainMenuWord.tk;
            System.out.println("new--------"+aa);
        }
    
           else if((jLabel2.getText().equals("1")&& aa != null)||(jLabel2.getText().equals("0")&& aa != null)){
           
         try {

                String url=  "http://172.31.191.163:8383/wordgenchecktoken/?PASSWORDWORDGEN="+aa;
                System.out.println("url:"+url);
                String fff =sendGET(url);
                System.out.println("Statussssssssssssssss:"+fff);    
                 if(fff.equals("0")){
                        JOptionPane.showMessageDialog(jPanel9, "ไม่พบการเชื่อมต่อ กรุณาตรวจสอบการเชื่อมต่อ", "แจ้งเตือน",
                        JOptionPane.OK_OPTION); 
              
                   } 
                 else{
                      JSONObject myResponse = new JSONObject(fff);
                String statuspasswordgen=myResponse.getString("statuspasswordgen");
               if(statuspasswordgen.equals("1")){
                  
                    new BackgroundWorker().execute();
                    
                }
                else if(statuspasswordgen.equals("2")){
                    JFrame frame = new JFrame();
                    JDialog dialog = new JDialog(frame);//frame is owner
                    JFrame lcf = (JFrame)(dialog.getParent());
                    lcf.removeAll();
                    LogInConfirm lc=new LogInConfirm(lcf);
                    lc.pack();
                    lc.setLocationRelativeTo(null);
                    lc.setVisible(true);
                    aa=MainMenuWord.tk;
                }
                 }
 
              
            } catch (Exception e) {
                
                
            }
      
//            String timeStart="00:00";
//        String timeEnd="23:59";
//        JsonObject jsonInput = new JsonObject();
//        
//        jsonInput.addProperty("CrimeCaseNo",case1);
//         jsonInput.addProperty("CrimeCaseNoTo",case2);
//        jsonInput.addProperty("CrimeCaseYear",yearcase);
//        jsonInput.addProperty("CrimeCaseYearTo",yearcase);
//        jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
//        //         jsonInput.addProperty("ORG_CODE","70028");
//        jsonInput.addProperty("PasswordWordgen",aa);
//        jsonInput.addProperty("StatusMagenta","Magenta_inActive");
//        
//        jsonInput.addProperty("CaseRequestDate",AcceptDate(DateReqStart.getJFormattedTextField().getText(),timeStart));
//        jsonInput.addProperty("CaseRequestDateTo",AcceptDate(DateReqEnd.getJFormattedTextField().getText(),timeEnd));
//        jsonInput.addProperty("CaseAcceptDate",AcceptDate(DateAcceptStart.getJFormattedTextField().getText(),timeStart));
//        jsonInput.addProperty("CaseAcceptDateTo",AcceptDate(DateAcceptEnd.getJFormattedTextField().getText(),timeEnd));
//
//        call_crimes(jsonInput);
//        TotalCase.setText(jTableCrime.getRowCount()+"");
//        int rowcase=jTableCrime.getRowCount();
//        if(rowcase ==0){
//            JOptionPane.showMessageDialog(null, "ไม่พบข้อมูลคดีในระบบ crimes");
//        }
       
    
              }
            
          
    }
    private void casenoccKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casenoccKeyTyped
        // TODO add your handling code here:
             char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
              
    }//GEN-LAST:event_casenoccKeyTyped

    private void caseyearsccKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caseyearsccKeyTyped
        // TODO add your handling code here:
               char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
    }//GEN-LAST:event_caseyearsccKeyTyped

    private void caseyearscc1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caseyearscc1KeyTyped
        // TODO add your handling code here:
           char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
    }//GEN-LAST:event_caseyearscc1KeyTyped

    private void casenocc1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casenocc1KeyTyped
        // TODO add your handling code here:
           char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
    }//GEN-LAST:event_casenocc1KeyTyped

    private void casenocc3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casenocc3KeyTyped
        // TODO add your handling code here:
           char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
    }//GEN-LAST:event_casenocc3KeyTyped

    private void jCheckAcceptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckAcceptItemStateChanged
        // TODO add your handling code here:
    
           SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy",new Locale("th", "TH"));
                        Date date = new Date();
                        dateFormat.format(date);
                        String text_tmp = dateFormat.format(Calendar.getInstance().getTime());
        if(jCheckAccept.isSelected()){
        DateAcceptStart.getComponent(1).setEnabled(true);
       DateAcceptStart.getJFormattedTextField().setEnabled(true);
        DateAcceptEnd.getComponent(1).setEnabled(true);
       DateAcceptEnd.getJFormattedTextField().setEnabled(true);
         DateAcceptStart.getJFormattedTextField().setText(text_tmp);
         DateAcceptEnd.getJFormattedTextField().setText(text_tmp);
         
        }
        else{
              DateAcceptStart.getComponent(1).setEnabled(false);
       DateAcceptStart.getJFormattedTextField().setEnabled(false);
        DateAcceptEnd.getComponent(1).setEnabled(false);
       DateAcceptEnd.getJFormattedTextField().setEnabled(false);
         DateAcceptStart.getJFormattedTextField().setText("");
         DateAcceptEnd.getJFormattedTextField().setText("");
         
        }
    }//GEN-LAST:event_jCheckAcceptItemStateChanged

    private void jCheckDateRegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckDateRegItemStateChanged
        // TODO add your handling code here:
         SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy",new Locale("th", "TH"));
                        Date date = new Date();
                        dateFormat.format(date);
                        String text_tmp = dateFormat.format(Calendar.getInstance().getTime());
        if(jCheckDateReg.isSelected()){
        DateReqStart.getComponent(1).setEnabled(true);
       DateReqStart.getJFormattedTextField().setEnabled(true);
        DateReqEnd.getComponent(1).setEnabled(true);
       DateReqEnd.getJFormattedTextField().setEnabled(true);
         DateReqStart.getJFormattedTextField().setText(text_tmp);
         DateReqEnd.getJFormattedTextField().setText(text_tmp);
         
        }
        else{
              DateReqStart.getComponent(1).setEnabled(false);
       DateReqStart.getJFormattedTextField().setEnabled(false);
        DateReqEnd.getComponent(1).setEnabled(false);
       DateReqEnd.getJFormattedTextField().setEnabled(false);
         DateReqStart.getJFormattedTextField().setText("");
         DateReqEnd.getJFormattedTextField().setText("");
         
        }
    }//GEN-LAST:event_jCheckDateRegItemStateChanged

    private void jCheckCaseTwoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckCaseTwoItemStateChanged
        // TODO add your handling code here:
           if(jCheckCaseTwo.isSelected()){
        casenocc.setEnabled(false);
        caseyearscc.setEnabled(false);
        casenocc1.setEnabled(true);
         casenocc3.setEnabled(true);
         caseyearscc1.setEnabled(true);
         jCheckCase.setEnabled(false);
        casenocc.setText("");
         caseyearscc.setText("");         
         
        }
        else{
         casenocc1.setEnabled(false);
         casenocc3.setEnabled(false);
         caseyearscc1.setEnabled(false);
         casenocc1.setText("");
         casenocc3.setText("");
         caseyearscc1.setText("");                 
         jCheckCase.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckCaseTwoItemStateChanged

    private void jCheckCaseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckCaseItemStateChanged
        // TODO add your handling code here:
        if(jCheckCase.isSelected()){
        casenocc.setEnabled(true);
        caseyearscc.setEnabled(true);
        casenocc1.setEnabled(false);
         casenocc3.setEnabled(false);
         caseyearscc1.setEnabled(false);
         jCheckCaseTwo.setEnabled(false);
        casenocc1.setText("");
         casenocc3.setText("");
         caseyearscc1.setText("");              
         
        }
        else{
           casenocc.setEnabled(false);
        caseyearscc.setEnabled(false);
        casenocc.setText("");
         caseyearscc.setText(""); 
         jCheckCaseTwo.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckCaseItemStateChanged

    private void casenocc4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casenocc4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_casenocc4KeyTyped

    private void caseyearscc3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caseyearscc3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_caseyearscc3KeyTyped

    private void jButtonConTrafficActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConTrafficActionPerformed
        // TODO add your handling code here:
           String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token:"+aa); 
        String case1="",case2="",yearcase="";
        String date1=DateAcceptStartTC.getJFormattedTextField().getText();
        String date2=DateAcceptEndTC.getJFormattedTextField().getText();
        String dateR1=DateReqStartTC.getJFormattedTextField().getText();
        String dateR2=DateReqEndTC.getJFormattedTextField().getText();
       
        if(jCheckCaseT.isSelected()||jCheckCaseTwo1.isSelected()||jCheckAccept1.isSelected()||jCheckDateReg1.isSelected()){
                


          if(jCheckCaseT.isSelected()&&jCheckDateReg1.isSelected()&&jCheckAccept1.isSelected()){
                      System.out.println("L1");
                         if(caseyearscc3.getText().equals("")&&casenocc4.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc4.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
                        else  if(DateReqStartTC.getJFormattedTextField().getText().equals("")||DateReqEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else   if(DateAcceptStartTC.getJFormattedTextField().getText().equals("")||DateAcceptEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0||calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
                         }
          
              else if(jCheckCaseTwo1.isSelected()&&jCheckDateReg1.isSelected()&&jCheckAccept1.isSelected()){
                System.out.println("L2");
                        if(caseyearscc4.getText().equals("")&&casenocc5.getText().equals("")&&casenocc6.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc5.getText().equals("")||casenocc6.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc4.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
                           else  if(DateReqStartTC.getJFormattedTextField().getText().equals("")||DateReqEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else   if(DateAcceptStartTC.getJFormattedTextField().getText().equals("")||DateAcceptEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0||calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
            }
              
             else if(jCheckCaseT.isSelected()&&jCheckAccept1.isSelected()){
                System.out.println("L3");
                 if(caseyearscc3.getText().equals("")&&casenocc4.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc4.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
 
                        else if(DateAcceptStartTC.getJFormattedTextField().getText().equals("")||DateAcceptEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
            }
             
            else   if(jCheckCaseT.isSelected()&&jCheckDateReg1.isSelected()){
                System.out.println("L4");
                 if(caseyearscc4.getText().equals("")&&casenocc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc3.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc4.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
               else  if(DateReqStartTC.getJFormattedTextField().getText().equals("")||DateReqEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
            }
            
              else if(jCheckCaseTwo1.isSelected()&&jCheckAccept1.isSelected()){
                        System.out.println("L5");
                        if(caseyearscc4.getText().equals("")&&casenocc5.getText().equals("")&&casenocc6.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc5.getText().equals("")||casenocc6.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc4.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
                        else if(DateAcceptStartTC.getJFormattedTextField().getText().equals("")||DateAcceptEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
            }
              
               else   if(jCheckCaseTwo1.isSelected()&&jCheckDateReg1.isSelected()){
                System.out.println("L6");
                if(caseyearscc4.getText().equals("")&&casenocc5.getText().equals("")&&casenocc6.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc5.getText().equals("")||casenocc6.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc4.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
               else  if(DateReqStartTC.getJFormattedTextField().getText().equals("")||DateReqEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
            }
               
           else if(jCheckDateReg1.isSelected()&&jCheckAccept1.isSelected()){
                System.out.println("L7");
                 if(DateReqStartTC.getJFormattedTextField().getText().equals("")||DateReqEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else   if(DateAcceptStartTC.getJFormattedTextField().getText().equals("")||DateAcceptEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0||calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
            }
           else if(jCheckCaseT.isSelected()){
               System.out.println("L8");
                        if(caseyearscc3.getText().equals("")&&casenocc4.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                       }
                        else if(casenocc4.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                           }
                       else if(caseyearscc3.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                       }
                        else{connect_traffic();}
           }
           else if(jCheckCaseTwo1.isSelected()){
               System.out.println("L9");
                         if(caseyearscc4.getText().equals("")&&casenocc5.getText().equals("")&&casenocc6.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดีและปีคดี");  
                                }

                          else   if(casenocc6.getText().equals("")||casenocc5.getText().equals("")){
                              JOptionPane.showMessageDialog(null, "กรุณากรอกเลขคดี");  
                              }
                          else if(caseyearscc4.getText().equals("")){
                                 JOptionPane.showMessageDialog(null, "กรุณากรอกปีคดี");  
                          }
                        else{connect_traffic();}
           }
         else if(jCheckAccept1.isSelected()){
               System.out.println("L10");
                          if(DateAcceptStartTC.getJFormattedTextField().getText().equals("")||DateAcceptEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับคดี");  
                             }
                        else if(calculateDate(date1, date2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
           }
           else if(jCheckDateReg1.isSelected()){
               System.out.println("L11");
                           if(DateReqStartTC.getJFormattedTextField().getText().equals("")||DateReqEndTC.getJFormattedTextField().getText().equals("")){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกวันที่รับแจ้ง");  
                             }
                        else if(calculateDate(dateR1, dateR2)==0){
                                JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
                               } 
                          else{connect_traffic();}
           }
            
        }
        else{
         JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลคดีที่ต้องการจากระบบ CRIMES");   
        }
   
         
        
    }//GEN-LAST:event_jButtonConTrafficActionPerformed
    private void connect_traffic(){
        String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token:"+aa); 
        String case1="",case2="",yearcase="";
        String date1=DateAcceptStartTC.getJFormattedTextField().getText();
        String date2=DateAcceptEndTC.getJFormattedTextField().getText();
        String dateR1=DateReqStartTC.getJFormattedTextField().getText();
        String dateR2=DateReqEndTC.getJFormattedTextField().getText();
//         if(jCheckCaseT.isSelected()){
//          case1=casenocc4.getText();
//          case2=casenocc4.getText();
//          yearcase=caseyearscc3.getText();
//        }
//        else if(jCheckCaseTwo1.isSelected()){
//        case1=casenocc5.getText();
//          case2=casenocc6.getText();
//          yearcase=caseyearscc4.getText();
//        }
    if(aa == null){
            System.out.println("empty:");
            JFrame frame = new JFrame();
            JDialog dialog = new JDialog(frame);//frame is owner
            JFrame asv = (JFrame)(dialog.getParent());
            asv.removeAll();
            LogInConfirm lc=new LogInConfirm(asv);
            lc.pack();
            lc.setLocationRelativeTo(null);
            lc.setVisible(true);  
            aa=MainMenuWord.tk;
            System.out.println("new--------"+aa);
        }
           else if(calculateDate(date1, date2)==0||calculateDate(dateR1, dateR2)==0){
             JOptionPane.showMessageDialog(null, "กรุณากรอกช่วงวันที่ไม่เกิน 3 เดือน");           
            }
           else if((jLabel2.getText().equals("1")&& aa != null)||(jLabel2.getText().equals("0")&& aa != null)){
           
         try {

                String url=  "http://172.31.191.163:8383/wordgenchecktoken/?PASSWORDWORDGEN="+aa;
                System.out.println("url:"+url);
                String fff =sendGET(url);
                
                if(fff.equals("0")){
                        JOptionPane.showMessageDialog(jPanel10, "ไม่พบการเชื่อมต่อ กรุณาตรวจสอบการเชื่อมต่อ", "แจ้งเตือน",
                        JOptionPane.OK_OPTION); 
                }
                else{
                    JSONObject myResponse = new JSONObject(fff);
                String statuspasswordgen=myResponse.getString("statuspasswordgen");
                if(statuspasswordgen.equals("1")){
                     new BackgroundWorkerTraff().execute();
                }
                else if(statuspasswordgen.equals("2")){
                    JFrame frame = new JFrame();
                    JDialog dialog = new JDialog(frame);//frame is owner
                    JFrame lcf = (JFrame)(dialog.getParent());
                    lcf.removeAll();
                    LogInConfirm lc=new LogInConfirm(lcf);
                    lc.pack();
                    lc.setLocationRelativeTo(null);
                    lc.setVisible(true);
                    aa=MainMenuWord.tk;
                }
                }

            } catch (Exception e) {
            }
    
    
              }
    }
    private void caseyearscc4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caseyearscc4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_caseyearscc4KeyTyped

    private void casenocc5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casenocc5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_casenocc5KeyTyped

    private void casenocc6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casenocc6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_casenocc6KeyTyped

    private void jCheckDateReg1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckDateReg1ItemStateChanged
        // TODO add your handling code here:
         SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy",new Locale("th", "TH"));
                        Date date = new Date();
                        dateFormat.format(date);
                        String text_tmp = dateFormat.format(Calendar.getInstance().getTime());
        if(jCheckDateReg1.isSelected()){
        DateReqStartTC.getComponent(1).setEnabled(true);
       DateReqStartTC.getJFormattedTextField().setEnabled(true);
        DateReqEndTC.getComponent(1).setEnabled(true);
       DateReqEndTC.getJFormattedTextField().setEnabled(true);
         DateReqStartTC.getJFormattedTextField().setText(text_tmp);
         DateReqEndTC.getJFormattedTextField().setText(text_tmp);
         
        }
        else{
              DateReqStartTC.getComponent(1).setEnabled(false);
       DateReqStartTC.getJFormattedTextField().setEnabled(false);
        DateReqEndTC.getComponent(1).setEnabled(false);
       DateReqEndTC.getJFormattedTextField().setEnabled(false);
         DateReqStartTC.getJFormattedTextField().setText("");
         DateReqEndTC.getJFormattedTextField().setText("");
         
        }
    }//GEN-LAST:event_jCheckDateReg1ItemStateChanged

    private void jCheckAccept1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckAccept1ItemStateChanged
        // TODO add your handling code here:
         SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy",new Locale("th", "TH"));
                        Date date = new Date();
                        dateFormat.format(date);
                        String text_tmp = dateFormat.format(Calendar.getInstance().getTime());
        if(jCheckAccept1.isSelected()){
        DateAcceptStartTC.getComponent(1).setEnabled(true);
       DateAcceptStartTC.getJFormattedTextField().setEnabled(true);
        DateAcceptEndTC.getComponent(1).setEnabled(true);
       DateAcceptEndTC.getJFormattedTextField().setEnabled(true);
         DateAcceptStartTC.getJFormattedTextField().setText(text_tmp);
         DateAcceptEndTC.getJFormattedTextField().setText(text_tmp);
         
        }
        else{
              DateAcceptStartTC.getComponent(1).setEnabled(false);
       DateAcceptStartTC.getJFormattedTextField().setEnabled(false);
        DateAcceptEndTC.getComponent(1).setEnabled(false);
       DateAcceptEndTC.getJFormattedTextField().setEnabled(false);
         DateAcceptStartTC.getJFormattedTextField().setText("");
         DateAcceptEndTC.getJFormattedTextField().setText("");
         
        }
    }//GEN-LAST:event_jCheckAccept1ItemStateChanged

    private void jCheckCaseTwo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckCaseTwo1ItemStateChanged
        // TODO add your handling code here:
           if(jCheckCaseTwo1.isSelected()){
        casenocc4.setEnabled(false);
        caseyearscc3.setEnabled(false);
        casenocc5.setEnabled(true);
         casenocc6.setEnabled(true);
         caseyearscc4.setEnabled(true);
         jCheckCaseT.setEnabled(false);
        casenocc4.setText("");
         caseyearscc3.setText("");         
         
        }
        else{
         casenocc5.setEnabled(false);
         casenocc6.setEnabled(false);
         caseyearscc4.setEnabled(false);
         casenocc5.setText("");
         casenocc6.setText("");
         caseyearscc4.setText("");                 
         jCheckCaseT.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckCaseTwo1ItemStateChanged

    private void jCheckCaseTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckCaseTItemStateChanged
        // TODO add your handling code here:
            if(jCheckCaseT.isSelected()){
        casenocc4.setEnabled(true);
        caseyearscc3.setEnabled(true);
        casenocc5.setEnabled(false);
         casenocc6.setEnabled(false);
         caseyearscc4.setEnabled(false);
         jCheckCaseTwo1.setEnabled(false);
        casenocc5.setText("");
         casenocc6.setText("");
         caseyearscc4.setText("");              
         
        }
        else{
           casenocc4.setEnabled(false);
        caseyearscc3.setEnabled(false);
        caseyearscc3.setText("");
         casenocc4.setText(""); 
         jCheckCaseTwo1.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckCaseTItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
              ArrayList<String> casenoList = new ArrayList<String>();
            Boolean ch=false;
              for (int i = 0; i < jTableTraffic.getRowCount(); i++) {
            Boolean chked = Boolean.valueOf(jTableTraffic.getValueAt(i, 0).toString()); 
            if(chked){
            casenoList.add(i+"");
            }
//            else{
//                ch=false;
//            }
          } 
              System.out.println("boo:"+ch);
            if (casenoList.size()>0) {
            new BackgroundWorkerInsertTraff().execute();
                    }
            else{
              JOptionPane.showMessageDialog(null, "กรุณาทำการเลือกคดีที่ต้องการ");
            }
        
    }//GEN-LAST:event_jButton7ActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        Change look Jtable From Nimbus to Windows
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaseSelectOverView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                CrimesCaseOverView aa=  new CrimesCaseOverView();
//                    aa.setVisible(true);
//                    aa.setSize ( 1264, 728 );
//        aa.setMinimumSize ( new Dimension ( 1264, 728 ) );
//        aa.setMaximizedBounds ( new Rectangle ( 1264, 728 ) );
            }
        });
        
    }
    public void DataUser(){
    
     try{
              
         con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        Statement stmt2 = con.createStatement();

        String sql = "select * from user";
        String sqlOrg = "select PoliceStartionCode,PoliceStaionShort from PoliceStation";

        ResultSet rs = stmt.executeQuery(sql);
        ResultSet rs2 = stmt2.executeQuery(sqlOrg);
          System.out.println("SQL : "+sql);

        if(rs.next()){
            usernamelabel.setText(rs.getString("Username"));
            idcardlabel.setText(rs.getString("PeopleCard"));
            jlabeltoken.setText(rs.getString("Token"));

        }  
      
        if(rs2.next()){
          jLabelorgcode.setText(rs2.getString("PoliceStartionCode"));
         jLabelorgcode1.setText(rs2.getString("PoliceStartionCode"));

          orgnamelabel.setText(rs2.getString("PoliceStaionShort"));
         orgnamelabel1.setText(rs2.getString("PoliceStaionShort"));

        } 
        rs.close();
        stmt.close();
        rs2.close();
        stmt2.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static String AcceptDate(String acdate,String actime){
    String formattedDate="";
     try{
        String dateAccept=acdate+" "+actime;  
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                SimpleDateFormat inputFormat2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        
           Date date = inputFormat.parse(dateAccept);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.YEAR, -543);
            Date newDate = c.getTime();
        System.out.println("aaa"+newDate); 
            String ass=inputFormat2.format(newDate);
        Date date2 = inputFormat.parse(ass);      
         formattedDate = outputFormat.format(date2);
        System.out.println(formattedDate);
    }
    catch(Exception ec){
    
    }
    
    return formattedDate;
    
    
    }
    public static String ChangDate(String date){
        String newFormatDate=null;
       try{   Calendar cal;
        SimpleDateFormat formatdate =new SimpleDateFormat("d/MM/yyyy");  
         if(date == null || date.equals("null")|| date.equals("0")){
            newFormatDate="";
        }
         else{
        Date b=formatdate.parse(date);
         cal = Calendar.getInstance();
          cal.setTime(b); 
           SimpleDateFormat dateformat =new SimpleDateFormat("yyyyMMdd");   
         newFormatDate=dateformat.format(cal.getTime());
         }
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    

}
    public void call_crimes(JsonObject json){
     try {
                String url = "http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen/";
//               String url = "http://172.31.191.171:8989/ws/CrimeCaseService_Wordgen/";
//               String url = "http://118.175.46.24:8989/ws/CrimeCaseService_Wordgen/";

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                                "   <soapenv:Header>\n" +
                                "      <exam:authentication>\n" +
                                "         <username>rtp</username>\n" +
                                "         <password>rtp</password>\n" +
                                "      </exam:authentication>\n" +
                                "   </soapenv:Header>\n" +
                                "   <soapenv:Body>\n" +
                                "      <exam:getlist_Crimescase>\n" +
                                "         <INPUT>"+json+"</INPUT>\n" +
                                "      </exam:getlist_Crimescase>\n" +
                                "   </soapenv:Body>\n" +
                                "</soapenv:Envelope>";
                System.out.println("xml:"+xml);
                con.setDoOutput(true);
               System.out.println("coooooo:"+con);
                DataOutputStream writer = new DataOutputStream(con.getOutputStream());
              
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println("SSddsafafssss"+responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
             Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
              .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("CrimeCases"); 
               Vector<Vector> tabledata = new Vector<Vector>();
           for (int temp = 0; temp < errNodes.getLength(); temp++) {
        Node nNode = errNodes.item(temp);
//        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode; 
       
//        while(rs.next()){
            Vector row = new Vector();
//          
           
             row.add(false);
               if(eElement.getElementsByTagName("CaseNo").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CaseNo").item(0).getTextContent());
               }
        if(eElement.getElementsByTagName("CrimeCaseNo").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
               }
            if(eElement.getElementsByTagName("CrimeCaseYear").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
               }
              if(eElement.getElementsByTagName("CaseRequestDate").item(0)==null){
               row.add("");
               }
               else{
                  System.out.println("Dateeeeeeeeeeeeeeeeeeeeee:"+eElement.getElementsByTagName("CaseRequestDate").item(0).getTextContent().replace("1)", ""));
                    row.add(NewDate(eElement.getElementsByTagName("CaseRequestDate").item(0).getTextContent().replace("1)", "")));
               }
               if(eElement.getElementsByTagName("DisplayCharge").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplayCharge").item(0).getTextContent());
               }
           
             if(eElement.getElementsByTagName("DisplaySuspectName").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplaySuspectName").item(0).getTextContent());
               }
             if(eElement.getElementsByTagName("DisplayVictimsname").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplayVictimsname").item(0).getTextContent());
               }
                   if(eElement.getElementsByTagName("RecievePoliceOfficer").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("RecievePoliceOfficer").item(0).getTextContent());
               }
                
             tabledata.add(row);
             
//            System.out.println("First Name : " + eElement.getElementsByTagName("DisplaySuspectName").item(0).getTextContent());
        }   
           }
              Vector ColumnName = new Vector();
        ColumnName.add("เลือก");
        ColumnName.add("คดีที่/ปี");
        ColumnName.add("เลขคดี");
        ColumnName.add("ปี");
         ColumnName.add("วันที่รับคำร้องทุกข์");
         ColumnName.add("ข้อหา");
        ColumnName.add("ผู้ต้องหา");
        ColumnName.add("ผู้กล่าวหา");
         ColumnName.add("ผู้รับผิดชอบ");

        


           jTableCrime.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

                } catch (Exception e) {
                System.out.println(e);
                }
                 jTableCrime.getColumnModel().getColumn(0).setMinWidth(15);
                  jTableCrime.getColumnModel().getColumn(1).setMinWidth(75);
                jTableCrime.getColumnModel().getColumn(2).setWidth(0);
                jTableCrime.getColumnModel().getColumn(2).setMinWidth(0);
                jTableCrime.getColumnModel().getColumn(2).setMaxWidth(0); 
                 jTableCrime.getColumnModel().getColumn(3).setWidth(0);
                jTableCrime.getColumnModel().getColumn(3).setMinWidth(0);
                jTableCrime.getColumnModel().getColumn(3).setMaxWidth(0);
         jTableCrime.getColumnModel().getColumn(4).setMinWidth(150);
         jTableCrime.getColumnModel().getColumn(5).setMinWidth(250);
         jTableCrime.getColumnModel().getColumn(6).setMinWidth(250);
                  jTableCrime.getColumnModel().getColumn(7).setMinWidth(250);
         jTableCrime.getColumnModel().getColumn(8).setMinWidth(250);


               
                }
 public void call_traffic(JsonObject json){
     try {
//         System.out.println("ssssssssssaaaaaaaaaaaaaaaaaaa");
                String url = "http://172.31.191.163:8383/ws/TrafficCaseService_Wordgen/";
//                  String url = "http://172.31.191.171:8989/ws/TrafficCaseService_Wordgen/";
//                 String url = "http://118.175.46.24:8989/ws/TrafficCaseService_Wordgen/";
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml; charset=utf-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                                "   <soapenv:Header>\n" +
                                "      <exam:authentication>\n" +
                                "         <username>rtp</username>\n" +
                                "         <password>rtp</password>\n" +
                                "      </exam:authentication>\n" +
                                "   </soapenv:Header>\n" +
                                "   <soapenv:Body>\n" +
                                "      <exam:getListTrafficCase>\n" +
                                "         <INPUT>"+json+"</INPUT>\n" +
                                "      </exam:getListTrafficCase>\n" +
                                "   </soapenv:Body>\n" +
                                "</soapenv:Envelope>";
                System.out.println("xml:"+xml);
                con.setDoOutput(true);
               System.out.println("coooooo:"+con);
                DataOutputStream writer = new DataOutputStream(con.getOutputStream());
              
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                System.out.println("SSddsafafssss"+responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
//             Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//              .parse(new InputSource(new StringReader(response.toString())));
//	       NodeList errNodes = doc.getElementsByTagName("CrimeCases"); 
//               Vector<Vector> tabledata = new Vector<Vector>();
//           for (int temp = 0; temp < errNodes.getLength(); temp++) {
//        Node nNode = errNodes.item(temp);
//        
//                String url = "http://172.31.191.171:8989/ws/TrafficCaseService_Wordgen/";
//
//                URL obj = new URL(url);
//                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//                con.setRequestMethod("POST");
////                con.setConnectTimeout(50000);
//                con.setRequestProperty("Conxtent-Type","application/soap+xml; charset=utf-8");
//                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
//                            "   <soapenv:Header>\n" +
//                            "      <exam:authentication>\n" +
//                            "         <username>rtp</username>\n" +
//                            "         <password>rtp</password>\n" +
//                            "      </exam:authentication>\n" +
//                            "   </soapenv:Header>\n" +
//                            "   <soapenv:Body>\n" +
//                            "      <exam:getListTrafficCase>\n" +
//                            "         <INPUT>"+json+"</INPUT>\n" +
//                            "      </exam:getListTrafficCase>\n" +
//                            "   </soapenv:Body>\n" +
//                            "</soapenv:Envelope>";
//                System.out.println("xml:"+xml);
//                con.setDoOutput(true);
//                     DataOutputStream writer = new DataOutputStream(con.getOutputStream());
//                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
//                        
//                wr.write(xml);
//                wr.flush();
//                wr.close();
//                String responseStatus = con.getResponseMessage();
//                System.out.println(responseStatus);
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                con.getInputStream(),"UTF-8"));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//                }
//                in.close();
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
                        
                        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
              .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("TrafficCase"); 
                               System.out.println("ssssssssssaaaaaaaaaaaaaaaaaaa"+errNodes.getLength());
               Vector<Vector> tabledata = new Vector<Vector>();
//             Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//              .parse(new InputSource(new StringReader(response.toString())));
//	       NodeList errNodes = doc.getElementsByTagName("TrafficCase");
//                System.out.println("ssssssssssaaaaaaaaaaaaaaaaaaa"+errNodes.getLength());
//               Vector<Vector> tabledata = new Vector<Vector>();
           for (int temp = 0; temp < errNodes.getLength(); temp++) {
        Node nNode = errNodes.item(temp);
//        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode; 
                   

//        while(rs.next()){
            Vector row = new Vector();
//          
           
             row.add(false);

               if(eElement.getElementsByTagName("CaseNo").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CaseNo").item(0).getTextContent());
               }
        if(eElement.getElementsByTagName("CrimeCaseNo").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
               }
            if(eElement.getElementsByTagName("CrimeCaseYear").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
               }
              if(eElement.getElementsByTagName("CaseRequestDate").item(0)==null){
               row.add("");
               }
               else{
                    row.add(NewDate(eElement.getElementsByTagName("CaseRequestDate").item(0).getTextContent()));
               }
               if(eElement.getElementsByTagName("DisplayCharge").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplayCharge").item(0).getTextContent());
               }
           
             if(eElement.getElementsByTagName("DisplaySuspectsName").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplaySuspectsName").item(0).getTextContent());
               }
             if(eElement.getElementsByTagName("DisplayVictimsName").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("DisplayVictimsName").item(0).getTextContent());
               }
                   if(eElement.getElementsByTagName("FullName_Polis").item(0)==null){
               row.add("");
               }
               else{
                    row.add(eElement.getElementsByTagName("FullName_Polis").item(0).getTextContent());
               }
                
             tabledata.add(row);
             
//            System.out.println("First Name : " + eElement.getElementsByTagName("DisplaySuspectName").item(0).getTextContent());
        }   
           }
              Vector ColumnName = new Vector();
        ColumnName.add("เลือก");
        ColumnName.add("คดีที่/ปี");
        ColumnName.add("เลขคดี");
        ColumnName.add("ปี");
         ColumnName.add("วันที่รับคำร้องทุกข์");
         ColumnName.add("ข้อหา");
        ColumnName.add("ผู้ต้องหา");
        ColumnName.add("ผู้กล่าวหา");
         ColumnName.add("ผู้รับผิดชอบ");

        


           jTableTraffic.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

                } catch (Exception e) {
                System.out.println(e);
                }
                 jTableTraffic.getColumnModel().getColumn(0).setMinWidth(15);
                  jTableTraffic.getColumnModel().getColumn(1).setMinWidth(75);
                jTableTraffic.getColumnModel().getColumn(2).setWidth(0);
                jTableTraffic.getColumnModel().getColumn(2).setMinWidth(0);
                jTableTraffic.getColumnModel().getColumn(2).setMaxWidth(0); 
                 jTableTraffic.getColumnModel().getColumn(3).setWidth(0);
                jTableTraffic.getColumnModel().getColumn(3).setMinWidth(0);
                jTableTraffic.getColumnModel().getColumn(3).setMaxWidth(0);
         jTableTraffic.getColumnModel().getColumn(4).setMinWidth(150);
         jTableTraffic.getColumnModel().getColumn(5).setMinWidth(250);
         jTableTraffic.getColumnModel().getColumn(6).setMinWidth(250);
                  jTableTraffic.getColumnModel().getColumn(7).setMinWidth(250);
         jTableTraffic.getColumnModel().getColumn(8).setMinWidth(250);


               
                }
    public static void insert_crime(JsonObject a){
     try {
                        detail_crimes(a);
                }
         catch (Exception e) {
                System.out.println(e);
                }
    }
      public static void insert_traffic(JsonObject a){
            try {
                   detail_traffic(a);

                } catch (Exception e) {
                System.out.println(e);
                }
     
                }
          public static void update_crime(JsonObject a,String caseid){
    
         try {  
             String sql = "DELETE FROM DeliverySuspect\n" +
                            "WHERE delipersonid IN (\n" +
                            "  SELECT delipersonid FROM DeliverySuspect a\n" +
                            "  INNER JOIN Person b\n" +
                            "    ON a.delipersonid=b.noperson \n" +
                             "  WHERE b.caseidperson ='"+caseid+"');\n"+
                          "DELETE FROM CrimeCase WHERE CrimeCase.CaseId='"+caseid+"';\n"+
                             "DELETE FROM RecordInquiry WHERE caseidrecord='"+caseid+"';\n"+
                             "DELETE FROM Person WHERE caseidperson='"+caseid+"';\n"+
                             "DELETE FROM ChargeCase WHERE ChargeCaseId='"+caseid+"';\n"+
                             "DELETE FROM RecordInquiry WHERE CaseIdRecord='"+caseid+"';\n"+
                             "DELETE FROM ActionsCaseData WHERE ActionCaseId='"+caseid+"';\n"+
                             "DELETE FROM BailAsset WHERE BailCaseId='"+caseid+"';\n"+                  
                                "DELETE FROM Asset WHERE caseidasset='"+caseid+"';";              
           Connection cond = ConnectDatabase.connect();
                System.out.println("Delete:"+sql);
                Statement  stmt = cond.createStatement();
                      stmt.executeUpdate(sql);
                    stmt.close();
         }
         catch(SQLException ex){
             System.out.println(ex);
         }
                detail_crimes(a);
               
     
                }
      public static void update_traffic(JsonObject a,String caseid){
     try {
                 String sql = "DELETE FROM DeliverySuspect\n" +
                            "WHERE delipersonid IN (\n" +
                            "  SELECT delipersonid FROM DeliverySuspect a\n" +
                            "  INNER JOIN Person b\n" +
                            "    ON a.delipersonid=b.noperson \n" +
                             "  WHERE b.caseidperson ='"+caseid+"');\n"+
                          "DELETE FROM CrimeCase WHERE CrimeCase.CaseId='"+caseid+"';\n"+
                             "DELETE FROM RecordInquiry WHERE caseidrecord='"+caseid+"';\n"+
                             "DELETE FROM Person WHERE caseidperson='"+caseid+"';\n"+
                             "DELETE FROM ChargeCase WHERE ChargeCaseId='"+caseid+"';\n"+
                             "DELETE FROM RecordInquiry WHERE CaseIdRecord='"+caseid+"';\n"+
                             "DELETE FROM ActionsCaseData WHERE ActionCaseId='"+caseid+"';\n"+
                             "DELETE FROM BailAsset WHERE BailCaseId='"+caseid+"';\n"+                  
                                "DELETE FROM Asset WHERE caseidasset='"+caseid+"';";
         try {               
           Connection cond = ConnectDatabase.connect();
                System.out.println("Delete:"+sql);
                Statement  stmt = cond.createStatement();
                      stmt.executeUpdate(sql);
                    stmt.close();
         }
         catch(SQLException ex){
             System.out.println(ex);
         }
                
             detail_traffic(a);

                } catch (Exception e) {
                System.out.println(e);
                }
 
        }
       public static void detail_traffic(JsonObject a){
     try {
             
                
                 String url = "http://172.31.191.163:8383/ws/TrafficCaseService_Wordgen_Import/";
//                 String url = "http://172.31.191.171:8989/ws/TrafficCaseService_Wordgen_Import";
//                 String url = "http://118.175.46.24:8989/ws/TrafficCaseService_Wordgen_Import";

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml;charset=UTF-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                    "   <soapenv:Header>\n" +
                    "      <exam:authentication>\n" +
                    "         <username>rtp</username>\n" +
                    "         <password>rtp</password>\n" +
                    "      </exam:authentication>\n" +
                    "   </soapenv:Header>\n" +
                    "   <soapenv:Body>\n" +
                    "      <exam:TrafficCaseDetail>\n" +
                    "         <INPUT>"+a+"</INPUT>\n" +
                    "      </exam:TrafficCaseDetail>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";
                System.out.println(xml);
                    con.setDoOutput(true);
                  DataOutputStream writer = new DataOutputStream(con.getOutputStream());
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("Person");
               NodeList errNodesArr = doc.getElementsByTagName("ArrestAndBailOut");
               NodeList errNodes2 = doc.getElementsByTagName("TrafficCase");       
               NodeList errNodes3 = doc.getElementsByTagName("InvolvedVehicle_TrafficCase");
               NodeList errNodes4 = doc.getElementsByTagName("InvolvedVehicle");
               
             NodeList errNodesBA = doc.getElementsByTagName("AssetsOfTheBailman_RequestForBail"); 
             NodeList errNodesBA1 = doc.getElementsByTagName("AssetsOfTheBailman"); 
                NodeList errNodesBD = doc.getElementsByTagName("DueDateDeliverySuspect"); 
                 NodeList errNodesT = doc.getElementsByTagName("Tambon"); 
                  NodeList errNodesOc = doc.getElementsByTagName("RequestForBail_Bailman_Occupation");
               NodeList errNodesTb = doc.getElementsByTagName("TrafficCaseModel_Tambon");
                NodeList errNodesAm = doc.getElementsByTagName("TrafficCaseModel_Amphur");
                NodeList errNodesPro = doc.getElementsByTagName("TrafficCaseModel_Province");
//                 NodeList errNodes5 = doc.getElementsByTagName("LawCategory");               
               
              Connection conn=null;
               Connection conn2=null;

               conn=ConnectDatabase.connect();
                              conn2=ConnectDatabase.connect();

         if (errNodes2.getLength() > 0) {
            Element err = (Element)errNodes2.item(0);
             Element er = (Element)errNodesT.item(0);
             Element tb = (Element)errNodesTb.item(0);
             Element am = (Element)errNodesAm.item(0);
             Element pr = (Element)errNodesPro.item(0);
         String insertCrime="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
                       + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd,ActionCodeCase,ChargeCodeCase,"
                      + "DailyNumber,Investigator_Result,SuspectandOther,AccureandOther,PoliceNameCase,CrimeLocation,TypeCourt,CrimeLocationDistrict,CrimeLocationAmphur,CrimeLocationProvince)\n"
                       + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         String insertCharge="insert into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note)\n"
                       + "VALUES (?,?,?,?,?)";
          String insertChargeCase="insert into ChargeCase(ChargeCodeCase,ChargeNameCase,LawCase,RateOfPenaltyCase,NoteCase,ChargeCaseId)\n"
                       + "VALUES (?,?,?,?,?,?)";
        
      String insertActionsCase="insert into ActionsCase(ActionCode,ActionCrimes,ActionDetail,ActionNote)\n"
                       + "VALUES (?,?,?,?)";
          String insertActionsCaseData="insert into ActionsCaseData(ActionCodeCase,ActionCrimesCase,ActionDetailCase,ActionNoteCase,ActionCaseId)\n"
                       + "VALUES (?,?,?,?,?)";
           String insertAsset="insert into Asset(EvidenceRecordNumber,Name,Amount,Value,StatusAsset,SumValue,caseIdAsset)\n"
                       + "VALUES (?,?,?,?,?,?,?)";
       try {
                    
                         PreparedStatement pst=null;
                         PreparedStatement pst1=null;
                         PreparedStatement pst2=null;
                          PreparedStatement pst3=null;
                         PreparedStatement pst4=null;
                          PreparedStatement pst5=null;

//                         String[] nameSus=err.getElementsByTagName("DailyNumber").item(0).getTextContent().split("2) ",1);
//                         System.out.println("nameeeeeeeeee:"+nameSus[0]);
                        pst=conn.prepareStatement(insertCrime);
                        pst.setString(1, IdCase());
                        pst.setString(2, "คดีจราจร");
                        pst.setString(3, err.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
                        pst.setString(4,  err.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
                        pst.setString(5,  err.getElementsByTagName("CaseNo").item(0).getTextContent());
                        pst.setString(6,  NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(7,   NewTime(err.getElementsByTagName("CaseRequestDate").item(0).getTextContent()));         
                        pst.setString(8, NewDate( err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(9,  NewTime(err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(10,  NewDate( err.getElementsByTagName("EventStartDate").item(0).getTextContent())); 
                        pst.setString(11,  NewTime(err.getElementsByTagName("EventStartDate").item(0).getTextContent())); 
                        pst.setString(12,   NewDate( err.getElementsByTagName("EventEndDate").item(0).getTextContent())); 
                        pst.setString(13,  NewTime(err.getElementsByTagName("EventEndDate").item(0).getTextContent())); 
                         pst.setString(14,  idAction()); 
                          pst.setString(15,  idCharge()); 
                            pst.setString(16, CheckNull(err, "DailyRecordNo"));  
                   
                            pst.setString(17, "อยู่ระหว่างสอบสวน");  
                            pst.setString(18, CheckNull(err, "DisplaySuspectsName").replace("1) ", ""));
                             pst.setString(19, CheckNull(err, "DisplayVictimsName").replace("1) ", ""));   
                            pst.setString(20,"1");
                           pst.setString(21,CheckNull(err, "Location"));   
                            pst.setString(22,"ศาลอาญา/ศาลจังหวัด"); 
                           pst.setString(23,CheckNull(tb, "Name"));   
                           pst.setString(24,CheckNull(am, "Name"));   
                           pst.setString(25,CheckNull(pr, "Name"));   

                            
//                      pst.setString(13,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                     pst.execute();
                     pst.close(); 
//                        if(err.getElementsByTagName("BehaviorOfCrimeCase").item(0)!=null){
//                           pst1=conn2.prepareStatement(insertActionsCase);
//                        pst1.setString(1, idAction());
//                        pst1.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst1.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst1.setString(4, "");     
//                                      System.out.println("addddddddddddd:"+idAction());  
//                        pst1.execute();
//                     pst1.close(); 
                     
//                            pst2=conn.prepareStatement(insertActionsCaseData);
//                        pst2.setString(1, idActionCase());
//                        pst2.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst2.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
//                        pst2.setString(4, "");
//                         pst2.setString(5, IdCasePerson());  
//                        pst2.execute();
//                     pst2.close(); 
//                        }
                 
              
                       String selectCharge="select ChargeName from Charge where ChargeName='"+CheckNull(err, "DisplayCharge").replace("1)", "")+"'";                            
                         Statement stc = conn.createStatement();
                        ResultSet sc=stc.executeQuery(selectCharge); 
                        if(sc.next()){                   
                       pst4=conn.prepareStatement(insertChargeCase);
                        pst4.setString(1, idChargeCase());
                        pst4.setString(2, CheckNull(err, "DisplayCharge").replace("1)", ""));
//                        if (errNodes5.getLength() > 0) {
//                            Element err5 = (Element)errNodes5.item(0);
//                         pst4.setString(3, err5.getElementsByTagName("NameTH").item(0).getTextContent());      
//                          }
//                          else{
                           pst4.setString(3, "");   
//                          }
                        pst4.setString(4, "");
                         pst4.setString(5, ""); 
                        pst4.setString(6, IdCasePerson());  

                        pst4.execute();
                     pst4.close();
                        
                        }
                        else{
                              pst3=conn.prepareStatement(insertCharge);
                        pst3.setString(1, idCharge());
                        pst3.setString(2,CheckNull(err, "DisplayCharge").replace("1)", ""));
//                       if (errNodes5.getLength() > 0) {
//                            Element err5 = (Element)errNodes5.item(0);
//                         pst3.setString(3, err5.getElementsByTagName("NameTH").item(0).getTextContent());      
//                          }
//                          else{
                           pst3.setString(3, "");   
//                          }
                        pst3.setString(4,"");
                         pst3.setString(5, "");  
                        pst3.execute();
                     pst3.close(); 
                     
                       pst4=conn.prepareStatement(insertChargeCase);
                        pst4.setString(1, idChargeCase());
                        pst4.setString(2, CheckNull(err, "DisplayCharge").replace("1)", ""));
//                        if (errNodes5.getLength() > 0) {
//                            Element err5 = (Element)errNodes5.item(0);
//                         pst4.setString(3, err5.getElementsByTagName("NameTH").item(0).getTextContent());      
//                          }
//                          else{
                           pst4.setString(3, "");   
//                          }
                        pst4.setString(4, "");
                         pst4.setString(5, ""); 
                        pst4.setString(6, IdCasePerson());  

                        pst4.execute();
                     pst4.close();
                        
                        
                        
                        }
                                   
//                          }
                     if (errNodes3.getLength() > 0) {
                          for (int temp = 0; temp < errNodes4.getLength(); temp++) {
                                Node nNode = errNodes4.item(temp);
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element t = (Element) nNode; 
//                                     Element err7 = (Element)errNodes8.item(0);  
                                              pst5=conn.prepareStatement(insertAsset);
                                              pst5.setString(1, CheckNull(err,"EvidenceRecordNumber"));
                                              pst5.setString(2, CheckNull(t,"BrandString")+CheckNull(t,"ModelString")+CheckNull(t,"FullNoPlate"));
                                              pst5.setString(3, CheckNull(t,"Amount1"));
                                              pst5.setString(4, CheckNull(t,"Value"));
                                              pst5.setString(5, "");
                                              pst5.setString(6, "");
                                              pst5.setString(7,IdCasePerson());

                                             pst5.execute();
                                             pst5.close();
                                           }
                                                  }
                     }
                       System.out.println("success");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }
	} else { 
		     // success
         }
           for (int temp = 0; temp < errNodes.getLength(); temp++) {

        Node nNode = errNodes.item(temp);

        

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element p = (Element) nNode; 
      NodeList nListArrTam = p.getElementsByTagName("ArrestAndBailOut_Tambon");
            NodeList nListArrAm = p.getElementsByTagName("Tabon_Amphur");
            NodeList nListArrPro = p.getElementsByTagName("Tabon_Province");
             NodeList nListArr = p.getElementsByTagName("ArrestAndBailOut");
            NodeList errNodesB = p.getElementsByTagName("RequestForBail"); 
            NodeList nListTam = p.getElementsByTagName("Person_Tambon");
            NodeList nListAm = p.getElementsByTagName("Person_Amphur");
            NodeList nListPro = p.getElementsByTagName("Person_Province");
//            -----------------------------------------Person Traffic Insert------------------------------------------
//    System.out.println("First Name : " +eElement.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
        String insertPerson="insert into Person(PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                              + "Age,TypePerson,FatherFullName,MotherFullName,Race,Religion,Nationality,Occupation,ArrestDateTime,CaseIdPerson,StatusSuspect,StatusBail,"
                             + " CourtSuspect,Related,PlaceArrest,PlaceArrestTambon,PlaceArrestAmphur,PlaceArrestProvince,BailDate,HouseNumber,Moo,Road,Soi,Amphur,Tambon,Province)\n"
//                             + "Occupation,ArrestDateTime,CaseIdPerson,StatusSuspect,StatusBail,CourtSuspect,SueFirst,SueFirstDate,SueFirstEnd,SueFirstTotal,"
//                            + " SueSecond,SueSecDate,SueSecEnd,SueSecTotal,SueThird,SueThirdDate,SueThirdEnd,SueThirdTotal,"
//                            + "SueFourth,SueFourthDate,SueFourthEnd,SueFourthtotal,SueFifth,SueFifthDate,SueFifthEnd,SueFifthTotal,"
//                            + "SueSixth,SueSixthDate,SueSixthEnd,SueSixthTotal,SueSeven,SueSevenDate,SueSevenEnd,SueSevenTotal,HouseNumber,Moo)\n"
//                                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,,?,?,?)";  
                                 + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";      
  
              String insertPersonData="insert into PersonData(PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                              + "Age,FatherFullName,MotherFullName,Race,Religion,Nationality,"
                             + "Occupation,"
                            + "HouseNumber,Road,Soi,Moo,Amphur,"
                             + "Tambon,Province,FullNamePersonEn,BloodGroup)\n"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
    String checkPersonData="Select FullNamePerson,PeopleRegistrationID from persondata where FullNamePerson='"+CheckNull(p, "FullNamePerson")+"' and PeopleRegistrationID='"+CheckNull(p, "PeopleRegistrationID")+"'";  
         try {           Element oc = (Element)errNodesOc.item(0); 
                     Statement st = conn.createStatement();
                ResultSet rc = st.executeQuery(checkPersonData);
                            if(rc.next()){
                                
                            }
                            else{
                               PreparedStatement pd=null;
                        
                        pd=conn.prepareStatement(insertPersonData);
                pd.setString(1,CheckNull(p, "PeopleRegistrationID"));
                 pd.setString(2,CheckNull(p, "FullNamePerson"));
                 if(p.getElementsByTagName("Birthday").item(0)==null){
               pd.setString(3,"");
               }
               else{
                    pd.setString(3,NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
               }

                if(p.getElementsByTagName("Gender").item(0)==null){
               pd.setString(4,"");
               }
               else{
                    pd.setString(4,NewGender(p.getElementsByTagName("Gender").item(0).getTextContent()));
               }
              pd.setString(5,CheckNull(p, "Age"));
    
              pd.setString(6,CheckNull(p, "TitleFather")+CheckNull(p, "FatherName")+" "+CheckNull(p, "FatherSurname"));
              pd.setString(7,CheckNull(p, "TitleMother")+CheckNull(p, "MotherName")+" "+CheckNull(p, "MotherSurname"));
              pd.setString(8,CheckNull(p, "Race"));
              pd.setString(9,CheckNull(p, "Religion"));
              pd.setString(10,CheckNull(p, "Nationality"));
              if(errNodesOc.getLength()>0){
               pd.setString(11,NewOccupation(CheckNull(oc, "NameTH")));
              }
              else{
              pd.setString(11,NewOccupation(CheckNull(p, "Occupation")));}
                    pd.setString(12,CheckNull(p, "HouseNumber"));
                     pd.setString(13,CheckNull(p, "Road"));
                    pd.setString(14,CheckNull(p, "Lane"));
                    pd.setString(15,CheckNull(p, "Moo"));
                     if (nListAm!= null && nListAm.getLength() > 0) {
                        Node elAm = nListAm.item(0); 
                        Element pam = (Element) elAm ;
                         pd.setString(16,CheckNull(pam, "Name"));
                         }
                        else{
                          pd.setString(16,"");
                        }
                      if (nListTam!= null && nListTam.getLength() > 0) {
                        Node elTam = nListTam.item(0); 
                        Element ptm = (Element) elTam ;
                         pd.setString(17,CheckNull(ptm, "Name"));
                         }
                        else{
                          pd.setString(17,"");
                        }
                      if (nListPro!= null && nListPro.getLength() > 0) {
                        Node elPro = nListPro.item(0); 
                        Element ppr = (Element) elPro ;
                         pd.setString(18,CheckNull(ppr, "Name"));
                         }
                        else{
                          pd.setString(18,"");
                        }
                      pd.setString(19,CheckNull(p, "TitleEN")+" "+CheckNull(p, "FirstNameEN")+" "+CheckNull(p, "SurNameEN"));
                     pd.setString(20,"");
                 
                      pd.execute();
                     pd.close();  
                            }
                        int order=temp+1;
                         PreparedStatement pst2=null;
                        
                        pst2=conn.prepareStatement(insertPerson);
//               if(p.getElementsByTagName("PeopleRegistrationID").item(0)==null){
//               pst2.setString(1,"");
//               }
//               else{
//                    pst2.setString(1,p.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
//               }
                pst2.setString(1,CheckNull(p, "PeopleRegistrationID"));
                 pst2.setString(2,CheckNull(p, "FullNamePerson"));
                 if(p.getElementsByTagName("Birthday").item(0)==null){
               pst2.setString(3,"");
               }
               else{
                    pst2.setString(3,NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
               }

                if(p.getElementsByTagName("Gender").item(0)==null){
               pst2.setString(4,"");
               }
               else{
                    pst2.setString(4,NewGender(p.getElementsByTagName("Gender").item(0).getTextContent()));
               }
              pst2.setString(5,CheckNull(p, "Age"));
              if(p.getElementsByTagName("StatusVictimOrSuspect").item(0).getTextContent().equals("Suspect")){
               pst2.setString(6,"ผู้ต้องหา");
              }  
              else{  
               pst2.setString(6,NewTypePersonTraffic(CheckNull(p, "Traffice_TypeOfPersonCase")));
              }
    
              pst2.setString(7,CheckNull(p, "FatherFullName"));
              pst2.setString(8,CheckNull(p, "MotherFullName"));
              pst2.setString(9,CheckNull(p, "Race"));
              pst2.setString(10,CheckNull(p, "Religion"));
              pst2.setString(11,CheckNull(p, "Nationality"));
              pst2.setString(12,NewOccupation(CheckNull(p, "Occupation")));
              
               pst2.setString(14,  IdCasePerson()); 
               if(p.getElementsByTagName("StatusSuspectProcess").item(0) != null){
                pst2.setString(15,CheckNull(p, "StatusSuspectProcess"));
               }
               else if (p.getElementsByTagName("StatusSueOrBail").item(0) != null) {
                 pst2.setString(15, NewStatusSue(CheckNull(p, "StatusSueOrBail"))); 
             }
             else {
                pst2.setString(15, "");
             }
            
            
////                 System.out.println("Courttttttttttttttttttttttttt:"+NewCourtProvince(CheckNull(p, "DisplayLevelDecision")));
                  pst2.setString(17,NewCourtProvince(CheckNull(p, "CourtNameTH")));
                  pst2.setString(18,NewStatusRelateTraffic(CheckNull(p, "Traffice_TypeOfPersonCase")));
            if (nListArr!= null && nListArr.getLength() > 0) {
                        Node elArr = nListArr.item(0); 
                        Element arr = (Element) elArr ;
                         pst2.setString(13,NewDate(CheckNull(arr, "ArrestDate"))+" "+NewTime(CheckNull(arr, "ArrestDate")));
                        if(arr.getElementsByTagName("StatusForBail").item(0).getTextContent().equals("SuspectForBail")){             
                            pst2.setString(16,"ประกัน");              
                         }
                        else{
                            pst2.setString(16,"");
                        }
                        pst2.setString(19,CheckNull(arr, "ArrestLocation"));
            }
            else{
              pst2.setString(13,""); 
              pst2.setString(16,"");
              pst2.setString(19,"");

            }
            if (nListArrTam != null && nListArrTam.getLength() > 0) {
                        Node elArrTam = nListArrTam.item(0); 
                        Element tb = (Element) elArrTam ;
                         pst2.setString(20,CheckNull(tb, "Name"));
            }
            else{
              pst2.setString(20,"");
            }
             if (nListArrAm != null && nListArrAm.getLength() > 0) {
                        Node elArrAm = nListArrAm.item(0); 
                        Element am = (Element) elArrAm ;
                         pst2.setString(21,CheckNull(am, "Name"));
            }
            else{
              pst2.setString(21,"");
            }
            if (nListArrPro != null && nListArrPro.getLength() > 0) {
                        Node elArrPr = nListArrPro.item(0); 
                        Element pr = (Element) elArrPr ;
                         pst2.setString(22,CheckNull(pr, "Name"));
            }
            else{
              pst2.setString(22,"");
            }
                if(errNodesB.getLength()>0){
                       Node BailDate=errNodesB.item(0);
                       Element bailD=(Element)BailDate;
                       pst2.setString(23,NewDate(CheckNull(bailD, "RequestDate")));
                   }
                   else{
                   pst2.setString(23,"");
                   }
                   pst2.setString(24,CheckNull(p, "HouseNo"));
                   pst2.setString(25,CheckNull(p, "Moo"));
                   pst2.setString(26,CheckNull(p, "Road"));
                   pst2.setString(27,CheckNull(p, "Lane"));
                if (nListAm!= null && nListAm.getLength() > 0) {
                        Node elAm = nListAm.item(0); 
                        Element pam = (Element) elAm ;
                         pst2.setString(28,CheckNull(pam, "Name"));
                         }
                        else{
                          pst2.setString(28,"");
                        }
                      if (nListTam!= null && nListTam.getLength() > 0) {
                        Node elTam = nListTam.item(0); 
                        Element ptm = (Element) elTam ;
                         pst2.setString(29,CheckNull(ptm, "Name"));
                         }
                        else{
                          pst2.setString(29,"");
                        }
                      if (nListPro!= null && nListPro.getLength() > 0) {
                        Node elPro = nListPro.item(0); 
                        Element ppr = (Element) elPro ;
                         pst2.setString(30,CheckNull(ppr, "Name"));
                         }
                        else{
                          pst2.setString(30,"");
                        }
//                  if(p.getElementsByTagName("Sue").item(0) != null){
//                 ---------------------------------------ผัดฟ้อง-----------------------------------------------     
//                    pst2.setString(18,CheckNullSue(p, "SueSeq",1));
//                     pst2.setString(19,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",1)))); 
//                     pst2.setString(20,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",1))));                 
//                     pst2.setString(21,CheckNullSue(p, "Amount",1)); 
//                      pst2.setString(22,CheckNullSue(p, "SueSeq",2));
//                     pst2.setString(23,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",2)))); 
//                     pst2.setString(24,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",2))));                 
//                     pst2.setString(25,CheckNullSue(p, "Amount",2));
//                      pst2.setString(26,CheckNullSue(p, "SueSeq",2));
//                     pst2.setString(23,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",2)))); 
//                     pst2.setString(24,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",2))));                 
//                     pst2.setString(25,CheckNullSue(p, "Amount",2));
//                      pst2.setString(26,CheckNullSue(p, "SueSeq",3));
//                     pst2.setString(27,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",3)))); 
//                     pst2.setString(28,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",3))));                 
//                     pst2.setString(29,CheckNullSue(p, "Amount",3));
//                     pst2.setString(30,CheckNullSue(p, "SueSeq",4));
//                     pst2.setString(31,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",4)))); 
//                     pst2.setString(32,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",4))));                 
//                     pst2.setString(33,CheckNullSue(p, "Amount",4));
//                      pst2.setString(34,CheckNullSue(p, "SueSeq",5));
//                     pst2.setString(35,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",5)))); 
//                     pst2.setString(36,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",5))));                 
//                     pst2.setString(37,CheckNullSue(p, "Amount",5));
//                     pst2.setString(38,CheckNullSue(p, "SueSeq",6));
//                     pst2.setString(39,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",6)))); 
//                     pst2.setString(40,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",6))));                 
//                     pst2.setString(41,CheckNullSue(p, "Amount",6));
//                      pst2.setString(42,CheckNullSue(p, "SueSeq",7));
//                     pst2.setString(43,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",7)))); 
//                     pst2.setString(44,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",7))));                 
//                     pst2.setString(45,CheckNullSue(p, "Amount",7));
//                    pst2.setString(46,  CheckNull(p, "HouseNo")); 
//                     pst2.setString(47,  CheckNull(p, "Moo"));
                     pst2.execute();
                     pst2.close();  
                     
               //       =----- ----- --------------------Bail Insert Traffic------------------------------------------
          if(p.getElementsByTagName("ArrestAndBailOut_PersonTraffic").item(0)!=null){
              String insertBailAsset = "INSERT INTO BailAsset (BailAssetOrder,BailAssetDetail,"
                      + "BailAssetBath,BailAmount,BailAssetTotal,"
                      + "BailPersonId,BailCaseId)\n"
                      + "VALUES (?,?,?,?,?,?,?)";
              String insertBailDel = "INSERT INTO DeliverySuspect (DeliOrder,DeliDate,DeliTimes,"
                                   + "DeliPlace,DeliPersonId) VALUES (?,?,?,?,?)";
                String insertBailOwn="INSERT INTO Person (Age,BirthDay,FullNamePerson,Gender,\n" +
                        "HouseNumber,Occupation,PeopleRegistrationID,\n" +
                        "PhonePerson,TypePerson,caseIdPerson,Related,"
                + "OccupationPosition,OwnerBail,Tambon,Amphur,Province)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst3=null;
                PreparedStatement pstB1=null;
                pst3=conn.prepareStatement(insertBailOwn);
                
               if(errNodesB.getLength()>0){

                  if (errNodesBA.getLength() > 0) {
                          for (int ab = 0; ab < errNodesBA1.getLength(); ab++) {
                                Node nNode1 = errNodesBA1.item(ab);
                                if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p2 = (Element) nNode1; 
//                                     Element err7 = (Element)errNodes8.item(0);  
                                              pstB1=conn.prepareStatement(insertBailAsset);
                                              pstB1.setString(1, CheckNull(p2,"Sequence"));
                                              pstB1.setString(2, CheckNull(p2,"AssetsName"));
                                              pstB1.setString(3, CheckNull(p2,"AssetsUnitValueBaht"));
                                              pstB1.setString(4, CheckNull(p2,"AssetsAmount"));
                                              pstB1.setString(5, CheckNull(p2,"AssetsTotalValueBaht"));
                                              pstB1.setString(6,IdPerson());
                                             pstB1.setString(7,IdCasePerson());
                                             pstB1.execute();
                                             pstB1.close();
                                           }
                                                  }
                     }    
                  if (errNodesBD.getLength() > 0) {
                          for (int ab = 0; ab < errNodesBD.getLength(); ab++) {
                                Node nNode1 = errNodesBD.item(ab);
                                if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p2 = (Element) nNode1; 
//                                     Element err7 = (Element)errNodes8.item(0);  
                                                PreparedStatement pstD=null;
                                              pstD=conn.prepareStatement(insertBailDel);
                                                     pstD.setString(1, CheckNull(p2,"Sequence"));
                                              pstD.setString(2, NewDate(CheckNull(p2,"DueDate")));
                                              pstD.setString(3, NewTime(CheckNull(p2,"DueDate")));
                                              pstD.setString(4, CheckNull(p2,"HandOverLocation"));
                                              pstD.setString(5, IdPerson());
                                             pstD.execute();
                                             pstD.close();
                                           }
                                                  }
                     }    
             
                     Node bailMan=errNodesB.item(0);
                     Element err4 = (Element) bailMan ;  
                    NodeList nListBailTam = err4.getElementsByTagName("RequestForBail_Bailman_Tambon");
                    NodeList nListBailAm = err4.getElementsByTagName("RequestForBail_Bailman_Amphur");
                    NodeList nListBailPro = err4.getElementsByTagName("RequestForBail_Bailman_Province");
                    NodeList nListBailOc = err4.getElementsByTagName("RequestForBail_Bailman_Occupation");

                      Element bTam= (Element) nListBailTam.item(0) ; 
                      Element bAmp= (Element) nListBailAm.item(0) ; 
                      Element bPro= (Element) nListBailPro.item(0) ; 
                      Element bOccu= (Element) nListBailOc.item(0) ; 

                    pst3.setString(1, CheckNull(err4,"BailsmanAge"));
                    pst3.setString(2,NewDate(CheckNull(err4, "BailsmanBirthDate")));
                   pst3.setString(3, CheckNull(err4, "BailsmanFullName"));
                   pst3.setString(4, NewGender(CheckNull(err4, "BailsmanSex")));
                   pst3.setString(5, CheckNull(err4, "BailsmanHouseNumber"));  
                   pst3.setString(6, CheckNull(bOccu, "NameTH"));
                   pst3.setString(7, CheckNull(err4, "BailsmanRegisterID"));
               
                   pst3.setString(8, "");
                   pst3.setString(9, "พยานและบุคคลอื่นๆ");
                   pst3.setString(10, IdCasePerson());
                   pst3.setString(11, "นายประกัน");
                    pst3.setString(12,"" );
                   pst3.setString(13, IdPerson());
                    pst3.setString(14,  CheckNull(bTam, "Name"));
                     pst3.setString(15,  CheckNull(bAmp, "Name"));
                      pst3.setString(16,  CheckNull(bPro, "Name"));
                   pst3.execute();
                   pst3.close();
               }
                    
                }
                      System.out.println("success Person");

        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }

        }
           }

                } catch (Exception e) {
                System.out.println(e);
                }
     
                }
       public static void detail_crimes(JsonObject a){
     try {            
               String url = "http://172.31.191.163:8383/ws/CrimeCaseService_Wordgen_Import/";
//                 String url = "http://172.31.191.171:8989/ws/CrimeCaseService_Wordgen_Import/";
//               String url = "http://118.175.46.24:8989/ws/CrimeCaseService_Wordgen_Import/";


                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type","application/soap+xml;charset=UTF-8");
                String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://www.example.com/\">\n" +
                "   <soapenv:Header>\n" +
                "      <exam:authentication>\n" +
                "         <username>rtp</username>\n" +
                "         <password>rtp</password>\n" +
                "      </exam:authentication>\n" +
                "   </soapenv:Header>\n" +
                "   <soapenv:Body>\n" +
                "      <exam:CrimesCaseDetail>\n" +
                "         <INPUT>"+a+"</INPUT>\n" +
                "      </exam:CrimesCaseDetail>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
                System.out.println(xml);
                    con.setDoOutput(true);
                  DataOutputStream writer = new DataOutputStream(con.getOutputStream());
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(writer, "UTF-8"));
                wr.write(xml);
                wr.flush();
                wr.close();
                String responseStatus = con.getResponseMessage();
                int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
                System.out.println(responseStatus);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream(),"UTF-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                }
                in.close();
                         System.out.println("rea:"+a);

                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
       Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
         .parse(new InputSource(new StringReader(response.toString())));
       
//                System.out.println("response:" + response.toString());
                	// System.out.println(response.toString());
//        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//         .parse(new InputSource(new StringReader(response.toString())));
	       NodeList errNodes = doc.getElementsByTagName("Person");
               NodeList errNodes2 = doc.getElementsByTagName("CrimeCase");       
               NodeList errNodes3 = doc.getElementsByTagName("ReportDailry");
               NodeList errNodes4 = doc.getElementsByTagName("Charge");
                 NodeList errNodes5 = doc.getElementsByTagName("LawCategory");               
             NodeList errNodes6 = doc.getElementsByTagName("IsExhibit_CrimeCase");               
            NodeList errNodes7 = doc.getElementsByTagName("IsExhibit"); 
            NodeList errNodesAs = doc.getElementsByTagName("Asset_IsExhibit");               
            NodeList errNodesWea = doc.getElementsByTagName("Weapon_IsExhibit"); 
            NodeList errNodesDr = doc.getElementsByTagName("Drug_IsExhibit"); 

             NodeList errNodeslo = doc.getElementsByTagName("IsLost_CrimeCase");               
            NodeList errNodeslost = doc.getElementsByTagName("IsLost"); 
            NodeList errNodes8 = doc.getElementsByTagName("Drug_SubDrugType"); 
             NodeList errNodes61 = doc.getElementsByTagName("IsRegain_CrimeCase");               
            NodeList errNodes71 = doc.getElementsByTagName("IsRegain"); 
            

             NodeList errNodesBA = doc.getElementsByTagName("AssetsOfTheBailman_RequestForBail"); 
             NodeList errNodesBA1 = doc.getElementsByTagName("AssetsOfTheBailman"); 
                NodeList errNodesBD = doc.getElementsByTagName("DueDateDeliverySuspect"); 
                NodeList errNodesSue = doc.getElementsByTagName("Sue_Person"); 
                NodeList errSue = doc.getElementsByTagName("Sue"); 
        
              Connection conn=null;
               Connection conn2=null;

               conn=ConnectDatabase.connect();
               conn2=ConnectDatabase.connect();

         if (errNodes2.getLength() > 0) {
            Element err = (Element)errNodes2.item(0);
           NodeList nListCrPro = err.getElementsByTagName("CrimeCase_Location_Province");
           NodeList nListCrTam = err.getElementsByTagName("CrimeCase_Location_Tambon");
           NodeList nListCrAmp = err.getElementsByTagName("CrimeCase_Location_Amphur");
                    
         String insertCrime="insert into CrimeCase(CaseId,CaseType,crimecaseno,crimecaseyears,crimecasenoyear,CaseAcceptDate,CaseAccepTime,"
                       + "CaseRequestDate,CaseRequestTime,OccuredDate,OccuredTime,OccuredDateEnd,OccuredTimeEnd,ActionCodeCase,ChargeCodeCase,"
                      + "DailyNumber,Investigator_Result,SuspectandOther,AccureandOther,PoliceNameCase,AssetCode,TypeCourt,CrimeLocation,CrimeLocationDistrict,"
                      + "CrimeLocationAmphur,CrimeLocationProvince,CrimeLocationRoad)\n"
                       + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
         String insertCharge="insert into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note)\n"
                       + "VALUES (?,?,?,?,?)";
          String insertChargeCase="insert into ChargeCase(ChargeCodeCase,ChargeNameCase,LawCase,RateOfPenaltyCase,NoteCase,ChargeCaseId)\n"
                       + "VALUES (?,?,?,?,?,?)";
        
      String insertActionsCase="insert into ActionsCase(ActionCode,ActionCrimes,ActionDetail,ActionNote)\n"
                       + "VALUES (?,?,?,?)";
          String insertActionsCaseData="insert into ActionsCaseData(ActionCodeCase,ActionCrimesCase,ActionDetailCase,ActionNoteCase,ActionCaseId)\n"
                       + "VALUES (?,?,?,?,?)";
          String insertAsset="insert into Asset(EvidenceRecordNumber,Name,Amount,Value,StatusAsset,SumValue,caseIdAsset,Remark)\n"
                       + "VALUES (?,?,?,?,?,?,?,?)";
       try {            
//           String[] name=err.getElementsByTagName("DisplaySuspectName").item(0).getTextContent().split("2)");

                        String renameSus=err.getElementsByTagName("DisplaySuspectName").item(0).getTextContent().replace("2) ", "2");
                        String[] nameSuspect=renameSus.split("2");
                        String renameVictim=err.getElementsByTagName("DisplayVictimsname").item(0).getTextContent().replace("2) ", "2");
                        String[] nameVictim=renameVictim.split("2");
                         PreparedStatement pst=null;
                         PreparedStatement pst1=null;
                         PreparedStatement pst2=null;
                          PreparedStatement pst3=null;
                         PreparedStatement pst4=null;
                           PreparedStatement pst5=null; 
//                         String[] nameSus=err.getElementsByTagName("DailyNumber").item(0).getTextContent().split("2) ",1);
//                         System.out.println("nameeeeeeeeee:"+nameSus[0]);
                        pst=conn.prepareStatement(insertCrime);
                        pst.setString(1, IdCase());
                        pst.setString(2, "คดีอาญา");
                        pst.setString(3, err.getElementsByTagName("CrimeCaseNo").item(0).getTextContent());
                        pst.setString(4,  err.getElementsByTagName("CrimeCaseYear").item(0).getTextContent());
                        pst.setString(5,  err.getElementsByTagName("CaseNo").item(0).getTextContent());
                        System.out.println("DATE ???:"+NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent()));
                        pst.setString(6,  NewDate( err.getElementsByTagName("CaseRequestDate").item(0).getTextContent())); 
                        pst.setString(7,   NewTime(err.getElementsByTagName("CaseRequestDate").item(0).getTextContent()));         
                        pst.setString(8, NewDate( err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(9,  NewTime(err.getElementsByTagName("CaseAcceptDate").item(0).getTextContent())); 
                        pst.setString(10,  NewDate( err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(11,  NewTime(err.getElementsByTagName("OccuredDateTimeFrom").item(0).getTextContent())); 
                        pst.setString(12,   NewDate( err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                        pst.setString(13,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                         pst.setString(14,  idAction()); 
                          pst.setString(15,  idCharge()); 
                          if (errNodes3.getLength() > 0) {
                            Element err3 = (Element)errNodes3.item(0);
                         pst.setString(16, err3.getElementsByTagName("DailyNumber").item(0).getTextContent());      
                          }
                          else{
                           pst.setString(16, "");   
                          }
                            pst.setString(17, "อยู่ระหว่างสอบสวน");  
                         
//                                String firstname=(name[0]+"").replace("#", "");
//                                String n=firstname+" "+name[1];
                            if(nameSuspect.length>1){
                            pst.setString(18, nameSuspect[0].replace("1) ", "")+"และพวก");
                            }
                            else{
                            pst.setString(18, nameSuspect[0].replace("1) ", ""));
                            }
                            if(nameVictim.length>1){
                             pst.setString(19, nameVictim[0].replace("1) ", "")+"และคนอื่นๆ");  
                            }
                            else{
                             pst.setString(19, nameVictim[0].replace("1) ", ""));  
                            }
                            pst.setString(20,"1");   
                             pst.setString(21,CheckNull(err, "EvidenceRecordNumber")); 
                             pst.setString(22,"ศาลอาญา/ศาลจังหวัด"); 
                            pst.setString(23,CheckNull(err, "CrimeLocation")); 
                            if (nListCrTam!= null && nListCrTam.getLength() > 0) {
                        Node crTam = nListCrTam.item(0); 
                        Element tmcr = (Element) crTam ;
                         pst.setString(24,CheckNull(tmcr, "Name"));
                         }
                        else{
                          pst.setString(24,"");
                        }
                             if (nListCrAmp!= null && nListCrAmp.getLength() > 0) {
                        Node crAmp = nListCrAmp.item(0); 
                        Element ampcr = (Element) crAmp ;
                         pst.setString(25,CheckNull(ampcr, "Name"));
                         }
                        else{
                          pst.setString(25,"");
                        }
                  
                       if (nListCrPro!= null && nListCrPro.getLength() > 0) {
                        Node crPro = nListCrPro.item(0); 
                        Element procr = (Element) crPro ;
                         pst.setString(26,CheckNull(procr, "Name"));
                         }
                        else{
                          pst.setString(26,"");
                        }
                         pst.setString(27,CheckNull(err, "CrimeLocationRoad"));

//                      pst.setString(13,  NewTime(err.getElementsByTagName("OccuredDateTimeTo").item(0).getTextContent())); 
                     pst.execute();
                     pst.close(); 
                        if(err.getElementsByTagName("BehaviorOfCrimeCase").item(0)!=null){
                           pst1=conn2.prepareStatement(insertActionsCase);
                        pst1.setString(1, idAction());
                        pst1.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst1.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst1.setString(4, "");     
//                                      System.out.println("addddddddddddd:"+idAction());  
                        pst1.execute();
                     pst1.close(); 
                     
                            pst2=conn.prepareStatement(insertActionsCaseData);
                        pst2.setString(1, idActionCase());
                        pst2.setString(2, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst2.setString(3, err.getElementsByTagName("BehaviorOfCrimeCase").item(0).getTextContent());
                        pst2.setString(4, "");
                         pst2.setString(5, IdCasePerson());  
                        pst2.execute();
                     pst2.close(); 
                        }
                     if (errNodes4.getLength() > 0) {
                            Element err4 = (Element)errNodes4.item(0);   
                       String selectCharge="select ChargeName from Charge where ChargeName='"+err4.getElementsByTagName("ChargeNameTH").item(0).getTextContent()+"'";                            
                         Statement stc = conn.createStatement();
                        ResultSet sc=stc.executeQuery(selectCharge); 
                       if(sc.next()){
                              pst4=conn.prepareStatement(insertChargeCase);
                        pst4.setString(1, idChargeCase());
                        pst4.setString(2, err4.getElementsByTagName("ChargeNameTH").item(0).getTextContent());
                        if (errNodes5.getLength() > 0) {
                            Element err5 = (Element)errNodes5.item(0);
                         pst4.setString(3, err5.getElementsByTagName("NameTH").item(0).getTextContent());      
                          }
                          else{
                           pst4.setString(3, "");   
                          }
                        pst4.setString(4, CheckNull(err4, "PenaltyNameTH"));
                         pst4.setString(5, ""); 
                        pst4.setString(6, IdCasePerson());  

                        pst4.execute();
                     pst4.close();
                       }
                       else{
                          pst3=conn.prepareStatement(insertCharge);
                        pst3.setString(1, idCharge());
                        pst3.setString(2,err4.getElementsByTagName("ChargeNameTH").item(0).getTextContent());
                       if (errNodes5.getLength() > 0) {
                            Element err5 = (Element)errNodes5.item(0);
                         pst3.setString(3, err5.getElementsByTagName("NameTH").item(0).getTextContent());      
                          }
                          else{
                           pst3.setString(3, "");   
                          }
                        pst3.setString(4, CheckNull(err4, "PenaltyNameTH"));
                         pst3.setString(5, "");  
                        pst3.execute();
                     pst3.close(); 
                     
                       pst4=conn.prepareStatement(insertChargeCase);
                        pst4.setString(1, idChargeCase());
                        pst4.setString(2, err4.getElementsByTagName("ChargeNameTH").item(0).getTextContent());
                        if (errNodes5.getLength() > 0) {
                            Element err5 = (Element)errNodes5.item(0);
                         pst4.setString(3, err5.getElementsByTagName("NameTH").item(0).getTextContent());      
                          }
                          else{
                           pst4.setString(3, "");   
                          }
                        pst4.setString(4, CheckNull(err4, "PenaltyNameTH"));
                         pst4.setString(5, ""); 
                        pst4.setString(6, IdCasePerson());  

                        pst4.execute();
                     pst4.close();
                       }
                    
                          }
                     if (errNodes6.getLength() > 0 ) {
                         if(errNodesAs.getLength() > 0 ){
                          for (int temp = 0; temp < errNodesAs.getLength(); temp++) {
                              System.err.println("Num:"+temp);
                                Node nNode = errNodesAs.item(temp);
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p = (Element) nNode; 
                                        String[] newAmount=CheckNull(p,"Amount").replace(".", ",").split(",");
                                          String[] newValue=CheckNull(p,"Value").replace(".", ",").split(",");
                                            pst5=conn.prepareStatement(insertAsset);
                                                pst5.setString(1, CheckNull(err,"EvidenceRecordNumber"));
                                             pst5.setString(2, CheckNull(p,"Name"));
                                              pst5.setString(3, newAmount[0]);
                                              pst5.setString(4, newValue[0]);     
                                                  pst5.setString(5, "ของกลาง");
                                              pst5.setString(6, "");
                                              pst5.setString(7,IdCasePerson());
                                              pst5.setString(8,"");
                                              pst5.execute();
                                              pst5.close();
                                              }
                         }
                         }
                            if(errNodesWea != null &&  errNodesWea.getLength()>0 ){
                          for (int temp = 0; temp < errNodesWea.getLength(); temp++) {
                              System.err.println("Wea:"+temp);
                                Node nNode = errNodesWea.item(temp);
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p = (Element) nNode;
                                    String[] newAmount=CheckNull(p,"Amount").replace(".", ",").split(",");
                                          String[] newValue=CheckNull(p,"Value").replace(".", ",").split(",");
                                        pst5=conn.prepareStatement(insertAsset);
                                                pst5.setString(1, CheckNull(err,"EvidenceRecordNumber"));
                                             pst5.setString(2, CheckNull(p,"WeaponName"));
                                              pst5.setString(3,newAmount[0]);
                                              pst5.setString(4,newValue[0]);     
                                                  pst5.setString(5, "ของกลาง");
                                              pst5.setString(6, "");
                                              pst5.setString(7,IdCasePerson());
                                              pst5.setString(8,"");

                                              pst5.execute();
                                              pst5.close();
                                }
                          
                          }
                            }
                      if(errNodesDr.getLength()>0){
                          for (int temp = 0; temp < errNodesDr.getLength(); temp++) {
                              System.err.println("Drug:"+errNodesDr.getLength());
                                Node nNode = errNodesDr.item(temp);
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p = (Element) nNode;
                                    Element dr = (Element)errNodes8.item(temp);
                                        pst5=conn.prepareStatement(insertAsset);
                                         String[] newAmount=CheckNull(p,"Amount").replace(".", ",").split(",");
                                         String[] newAmount1=CheckNull(p,"Amount1").replace(".", ",").split(",");

//                                        if(p.getElementsByTagName("Amount").item(0).getTextContent()!=null){
//                                         newAmount=CheckNull(p,"Amount").replace(".", ",").split(",");
//                                        }
//                                        else if(p.getElementsByTagName("Amount1").item(0).getTextContent()!=null){
//                                         newAmount=CheckNull(p,"Amount1").replace(".", ",").split(",");
//                                        } 
                                          String[] newValue=CheckNull(p,"Value").replace(".", ",").split(",");
                                                pst5.setString(1, CheckNull(err,"EvidenceRecordNumber"));
                                                if(errNodes8.getLength()>0){
                                               pst5.setString(2, CheckNull(dr,"NameTH")); 
                                                }
                                                else{
                                                  pst5.setString(2, ""); 
                                                }
                                      
                                             if((p.getElementsByTagName("Amount").item(0).getTextContent().equals("0.0"))&& (!"0.0".equals(p.getElementsByTagName("Amount1").item(0).getTextContent()))){
                                                pst5.setString(3, newAmount1[0]);
                                             
                                             }
                                             else{
                                                 pst5.setString(3, newAmount[0]);
                                             
                                             }
                                              pst5.setString(4,newValue[0]);     
                                                  pst5.setString(5, "ของกลาง");
                                              pst5.setString(6, "");
                                              pst5.setString(7,IdCasePerson());
                                              pst5.setString(8,CheckNull(p,"Remark"));

                                              pst5.execute();
                                              pst5.close();
                                }
                          
                          }
                            }
                                    else{
                                        System.err.println("Ddddddddddddddddddddd");
                                    }
                           }

                     if (errNodes61.getLength() > 0) {
                          for (int temp = 0; temp < errNodes71.getLength(); temp++) {
                                Node nNode = errNodes71.item(temp);
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p = (Element) nNode; 
//                                     Element err7 = (Element)errNodes8.item(0); 
                                        String[] newAmount=CheckNull(p,"Amount1").replace(".", ",").split(",");
                                          String[] newValue=CheckNull(p,"Value").replace(".", ",").split(",");
                                              pst5=conn.prepareStatement(insertAsset);
                                              pst5.setString(1, CheckNull(err,"EvidenceRecordNumber").replace("null", ""));
                                              pst5.setString(2, CheckNull(p,"DisplayAsset"));
                                              pst5.setString(3, newAmount[0]);
                                              pst5.setString(4,newValue[0]);
                                              pst5.setString(5, "ได้คืน");
                                              pst5.setString(6, "");
                                              pst5.setString(7,IdCasePerson());
                                              pst5.setString(8,"");

                                             pst5.execute();
                                             pst5.close();
                                           }
                                                  }
                     }

                       if (errNodeslo.getLength() > 0) {
                          for (int temp = 0; temp < errNodeslost.getLength(); temp++) {
                              System.err.println("Lost:"+temp);
                          
                                Node nNode = errNodeslost.item(temp);
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p = (Element) nNode; 
//                                     Element err7 = (Element)errNodes8.item(0); 
                                        String[] newAmount=CheckNull(p,"Amount").replace(".", ",").split(",");
                                          String[] newValue=CheckNull(p,"Value").replace(".", ",").split(",");
                                              pst5=conn.prepareStatement(insertAsset);
                                              pst5.setString(1, CheckNull(err,"EvidenceRecordNumber"));
                                              pst5.setString(2, CheckNull(p,"Name"));
                                              pst5.setString(3, newAmount[0]);
                                              pst5.setString(4, newValue[0]);
                                              pst5.setString(5, "ประทุษร้าย");
                                              pst5.setString(6, "");
                                              pst5.setString(7,IdCasePerson());
                                              pst5.setString(8,"");

                                             pst5.execute();
                                             pst5.close();
                                           }
                                                  }
                     }
                       System.out.println("success");
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }
	} else { 
		     // success
         }
       for (int temp = 0; temp < errNodes.getLength(); temp++) {
        Node nNode = errNodes.item(temp);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element p = (Element) nNode; 
      NodeList nListArrTam = p.getElementsByTagName("ArrestRecord_Tambon");
            NodeList nListArrAm = p.getElementsByTagName("ArrestRecord_Amphur");
            NodeList nListArrPro = p.getElementsByTagName("ArrestRecord_Province");
             NodeList nListArr = p.getElementsByTagName("ArrestRecord");
           NodeList errNodesB = p.getElementsByTagName("RequestForBail"); 
            NodeList nListTam = p.getElementsByTagName("Person_Tambon");
            NodeList nListAm = p.getElementsByTagName("Person_Amphur");
            NodeList nListPro = p.getElementsByTagName("Person_Province");

//--------------------------------------Person Crimes Insert-------------------------------------------------------------------
//    System.out.println("First Name : " +eElement.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
       String insertPerson="insert into Person(PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                              + "Age,TypePerson,FatherFullName,MotherFullName,Race,Religion,Nationality,"
                             + "Occupation,ArrestDateTime,CaseIdPerson,StatusSuspect,StatusBail,CourtSuspect,SueFirst,SueFirstDate,SueFirstEnd,SueFirstTotal,"
                            + " SueSecond,SueSecDate,SueSecEnd,SueSecTotal,SueThird,SueThirdDate,SueThirdEnd,SueThirdTotal,"
                            + "SueFourth,SueFourthDate,SueFourthEnd,SueFourthtotal,SueFifth,SueFifthDate,SueFifthEnd,SueFifthTotal,"
                            + "SueSixth,SueSixthDate,SueSixthEnd,SueSixthTotal,SueSeven,SueSevenDate,SueSevenEnd,SueSevenTotal,HouseNumber,Road,Soi,Moo,Amphur,"
                             + "Tambon,Province,Related,FullNamePersonEn,BailDate,TypeChild,PlaceArrest,PlaceArrestTambon,PlaceArrestAmphur,PlaceArrestProvince)\n"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
             String insertPersonData="insert into PersonData(PeopleRegistrationID,FullNamePerson,BirthDay,Gender,"
                              + "Age,FatherFullName,MotherFullName,Race,Religion,Nationality,"
                             + "Occupation,"
                            + "HouseNumber,Road,Soi,Moo,Amphur,"
                             + "Tambon,Province,FullNamePersonEn,BloodGroup)\n"
                                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
    String checkPersonData="Select FullNamePerson,PeopleRegistrationID from persondata where FullNamePerson='"+CheckNull(p, "FullNamePerson")+"' and PeopleRegistrationID='"+CheckNull(p, "PeopleRegistrationID")+"'";  
         try {      
                     Statement st = conn.createStatement();
                ResultSet rc = st.executeQuery(checkPersonData);
                            if(rc.next()){
                                
                            }
                            else{
                               PreparedStatement pd=null;
                        
                        pd=conn.prepareStatement(insertPersonData);
                pd.setString(1,CheckNull(p, "PeopleRegistrationID"));
                 pd.setString(2,CheckNull(p, "FullNamePerson"));
                 if(p.getElementsByTagName("Birthday").item(0)==null){
               pd.setString(3,"");
               }
               else{
                    pd.setString(3,NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
               }

                if(p.getElementsByTagName("Gender").item(0)==null){
               pd.setString(4,"");
               }
               else{
                    pd.setString(4,NewGender(p.getElementsByTagName("Gender").item(0).getTextContent()));
               }
              pd.setString(5,CheckNull(p, "Age"));
    
              pd.setString(6,CheckNull(p, "TitleFather")+CheckNull(p, "FatherName")+" "+CheckNull(p, "FatherSurname"));
              pd.setString(7,CheckNull(p, "TitleMother")+CheckNull(p, "MotherName")+" "+CheckNull(p, "MotherSurname"));
              pd.setString(8,CheckNull(p, "Race"));
              pd.setString(9,CheckNull(p, "Religion"));
              pd.setString(10,CheckNull(p, "Nationality"));
              pd.setString(11,NewOccupation(CheckNull(p, "Occupation")));
                    pd.setString(12,CheckNull(p, "HouseNumber"));
                     pd.setString(13,CheckNull(p, "Road"));
                    pd.setString(14,CheckNull(p, "Lane"));
                    pd.setString(15,CheckNull(p, "Moo"));
                     if (nListAm!= null && nListAm.getLength() > 0) {
                        Node elAm = nListAm.item(0); 
                        Element pam = (Element) elAm ;
                         pd.setString(16,CheckNull(pam, "Name"));
                         }
                        else{
                          pd.setString(16,"");
                        }
                      if (nListTam!= null && nListTam.getLength() > 0) {
                        Node elTam = nListTam.item(0); 
                        Element ptm = (Element) elTam ;
                         pd.setString(17,CheckNull(ptm, "Name"));
                         }
                        else{
                          pd.setString(17,"");
                        }
                      if (nListPro!= null && nListPro.getLength() > 0) {
                        Node elPro = nListPro.item(0); 
                        Element ppr = (Element) elPro ;
                         pd.setString(18,CheckNull(ppr, "Name"));
                         }
                        else{
                          pd.setString(18,"");
                        }
                      pd.setString(19,CheckNull(p, "TitleEN")+" "+CheckNull(p, "FirstNameEN")+" "+CheckNull(p, "SurNameEN"));
                   pd.setString(20,"");
                      pd.execute();
                     pd.close();  
                            }
//                        int order=temp+1;
                         PreparedStatement pst2=null;
                        
                        pst2=conn.prepareStatement(insertPerson);
                         Element br = (Element) errNodesB.item(0); 
                    
//               if(p.getElementsByTagName("PeopleRegistrationID").item(0)==null){
//               pst2.setString(1,"");
//               }
//               else{
//                    pst2.setString(1,p.getElementsByTagName("PeopleRegistrationID").item(0).getTextContent());
//               }
                pst2.setString(1,CheckNull(p, "PeopleRegistrationID"));
                 pst2.setString(2,CheckNull(p, "FullNamePerson"));
                 if(p.getElementsByTagName("Birthday").item(0)==null){
               pst2.setString(3,"");
               }
               else{
                    pst2.setString(3,NewDate(p.getElementsByTagName("Birthday").item(0).getTextContent()));
               }

                if(p.getElementsByTagName("Gender").item(0)==null){
               pst2.setString(4,"");
               }
               else{
                    pst2.setString(4,NewGender(p.getElementsByTagName("Gender").item(0).getTextContent()));
               }
              pst2.setString(5,CheckNull(p, "Age"));
              if(p.getElementsByTagName("StatusVictimOrSuspect").item(0).getTextContent().equals("Suspect")){
               pst2.setString(6,"ผู้ต้องหา");
              }  
              else{  
               pst2.setString(6,NewTypePerson(CheckNull(p, "PeopleVictimType")));
              }
    
              pst2.setString(7,CheckNull(p, "TitleFather")+CheckNull(p, "FatherName")+" "+CheckNull(p, "FatherSurname"));
              pst2.setString(8,CheckNull(p, "TitleMother")+CheckNull(p, "MotherName")+" "+CheckNull(p, "MotherSurname"));
              pst2.setString(9,CheckNull(p, "Race"));
              pst2.setString(10,CheckNull(p, "Religion"));
              pst2.setString(11,CheckNull(p, "Nationality"));
            
              pst2.setString(12,NewOccupation(CheckNull(p, "Occupation")));
              
               pst2.setString(14,  IdCasePerson()); 
          
              if(p.getElementsByTagName("StatusSuspectProcess").item(0) != null){
                pst2.setString(15,CheckNull(p, "StatusSuspectProcess"));
               }
               else if (p.getElementsByTagName("StatusSueOrBail").item(0) != null) {
                 pst2.setString(15, NewStatusSue(CheckNull(p, "StatusSueOrBail"))); 
             }
             else {
                pst2.setString(15, "");
             }
                 if(p.getElementsByTagName("StatusSuspectForBail").item(0).getTextContent().equals("SuspectForBail")){
                   pst2.setString(16,"ประกัน");
               }           
                 else{
                 pst2.setString(16,"");
                 }
//                 System.out.println("Courttttttttttttttttttttttttt:"+NewCourtProvince(CheckNull(p, "DisplayLevelDecision")));
                  pst2.setString(17,NewCourtProvince(CheckNull(p, "DisplayLevelDecision")));
//                  if(p.getElementsByTagName("Sue").item(0) != null){
//                 ---------------------------------------ผัดฟ้อง-----------------------------------------------     
                    pst2.setString(18,CheckNullSue(p, "SueSeq",1));
                     pst2.setString(19,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",1)))); 
                     pst2.setString(20,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",1))));                 
                     pst2.setString(21,CheckNullSue(p, "Amount",1)); 
                      pst2.setString(22,CheckNullSue(p, "SueSeq",2));
                     pst2.setString(23,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",2)))); 
                     pst2.setString(24,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",2))));                 
                     pst2.setString(25,CheckNullSue(p, "Amount",2));
                      pst2.setString(26,CheckNullSue(p, "SueSeq",2));
                     pst2.setString(23,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",2)))); 
                     pst2.setString(24,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",2))));                 
                     pst2.setString(25,CheckNullSue(p, "Amount",2));
                      pst2.setString(26,CheckNullSue(p, "SueSeq",3));
                     pst2.setString(27,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",3)))); 
                     pst2.setString(28,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",3))));                 
                     pst2.setString(29,CheckNullSue(p, "Amount",3));
                     pst2.setString(30,CheckNullSue(p, "SueSeq",4));
                     pst2.setString(31,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",4)))); 
                     pst2.setString(32,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",4))));                 
                     pst2.setString(33,CheckNullSue(p, "Amount",4));
                      pst2.setString(34,CheckNullSue(p, "SueSeq",5));
                     pst2.setString(35,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",5)))); 
                     pst2.setString(36,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",5))));                 
                     pst2.setString(37,CheckNullSue(p, "Amount",5));
                     pst2.setString(38,CheckNullSue(p, "SueSeq",6));
                     pst2.setString(39,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",6)))); 
                     pst2.setString(40,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",6))));                 
                     pst2.setString(41,CheckNullSue(p, "Amount",6));
                      pst2.setString(42,CheckNullSue(p, "SueSeq",7));
                     pst2.setString(43,ChangFormat(NewDate(CheckNullSue(p, "SueStartDate",7)))); 
                     pst2.setString(44,ChangFormat(NewDate(CheckNullSue(p, "SueEndDate",7))));                 
                     pst2.setString(45,CheckNullSue(p, "Amount",7));
                    pst2.setString(46,CheckNull(p, "HouseNumber"));
                     pst2.setString(47,CheckNull(p, "Road"));
                    pst2.setString(48,CheckNull(p, "Lane"));
                    pst2.setString(49,CheckNull(p, "Moo"));

                  
                     if (nListAm!= null && nListAm.getLength() > 0) {
                        Node elAm = nListAm.item(0); 
                        Element am = (Element) elAm ;
                         pst2.setString(50,CheckNull(am, "Name"));
                         }
                        else{
                          pst2.setString(50,"");
                        }
                      if (nListTam!= null && nListTam.getLength() > 0) {
                        Node elTam = nListTam.item(0); 
                        Element tm = (Element) elTam ;
                         pst2.setString(51,CheckNull(tm, "Name"));
                         }
                        else{
                          pst2.setString(51,"");
                        }
                      if (nListPro!= null && nListPro.getLength() > 0) {
                        Node elPro = nListPro.item(0); 
                        Element pr = (Element) elPro ;
                         pst2.setString(52,CheckNull(pr, "Name"));
                         }
                        else{
                          pst2.setString(52,"");
                        }

                     if(p.getElementsByTagName("StatusVictimOrSuspect").item(0).getTextContent().equals("Victim")){
                    pst2.setString(53,NewStatusRelate(CheckNull(p, "PeopleVictimType")));
                   }  
                    else{  
                     pst2.setString(53,NewStatusRelate(CheckNull(p, "PeopleSuspectType")));
                    }
//                    pst2.setString(53,NewStatusRelate(CheckNull(p, "PeopleVictimType")));
                      pst2.setString(54,CheckNull(p, "TitleEN")+" "+CheckNull(p, "FirstNameEN")+" "+CheckNull(p, "SurNameEN"));
                   if(errNodesB.getLength()>0){
                       Node BailDate=errNodesB.item(0);
                       Element bailD=(Element)BailDate;
                       pst2.setString(55,NewDate(CheckNull(bailD, "RequestDate")));
                   }
                   else{
                   pst2.setString(55,"");
                   }
                  if(CheckNull(p, "DisplayLevelDecision")!=null){
                     if(NewCourtProvince(CheckNull(p, "DisplayLevelDecision")).equals("ศาลเยาวชนและครอบครัว")){
                         pst2.setString(56,"ศาลเด็กและเยาวชน");
                     }
                     else{
                       pst2.setString(56,"ผู้ใหญ่");
                     }
                     }
                 else{
                  pst2.setString(56,"");
                 }
             if (nListArr!= null && nListArr.getLength() > 0) {
                        Node elArr = nListArr.item(0); 
                        Element arr = (Element) elArr ;
                         pst2.setString(13,NewDate(CheckNull(arr, "ArrestDate"))+" "+NewTime(CheckNull(arr, "ArrestDate")));
                       pst2.setString(57,CheckNull(arr, "ArrestLocation"));

            }
            else{
              pst2.setString(13,"");
              pst2.setString(57,"");

            }     
            if (nListArrTam != null && nListArrTam.getLength() > 0) {
                        Node elArrTam = nListArrTam.item(0); 
                        Element tb = (Element) elArrTam ;
                         pst2.setString(58,CheckNull(tb, "Name"));
            }
            else{
              pst2.setString(58,"");
            }
             if (nListArrAm != null && nListArrAm.getLength() > 0) {
                        Node elArrAm = nListArrAm.item(0); 
                        Element am = (Element) elArrAm ;
                         pst2.setString(59,CheckNull(am, "Name"));
            }
            else{
              pst2.setString(59,"");
            }
            if (nListArrPro != null && nListArrPro.getLength() > 0) {
                        Node elArrPr = nListArrPro.item(0); 
                        Element pr = (Element) elArrPr ;
                         pst2.setString(60,CheckNull(pr, "Name"));
            }
            else{
              pst2.setString(60,"");
            }

                  
                 
                     pst2.execute();
                     pst2.close();  
                     
               //       =----- ----- --------------------Bail Insert Crime------------------------------------------
          if(p.getElementsByTagName("StatusSuspectForBail").item(0).getTextContent().equals("SuspectForBail")){
              String insertBailAsset = "INSERT INTO BailAsset (BailAssetOrder,BailAssetDetail,"
                      + "BailAssetBath,BailAmount,BailAssetTotal,"
                      + "BailPersonId,BailCaseId)\n"
                      + "VALUES (?,?,?,?,?,?,?)";
              String insertBailDel = "INSERT INTO DeliverySuspect (DeliOrder,DeliDate,DeliTimes,"
                                   + "DeliPlace,DeliPersonId) VALUES (?,?,?,?,?)";
                String insertBailOwn="INSERT INTO Person (Age,BirthDay,FullNamePerson,Gender,\n" +
                        "HouseNumber,Occupation,PeopleRegistrationID,\n" +
                        "PhonePerson,TypePerson,caseIdPerson,Related,"
                + "OccupationPosition,OwnerBail,Tambon,Amphur,Province)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst3=null;
                PreparedStatement pstB1=null;
                pst3=conn.prepareStatement(insertBailOwn);
                
               if(errNodesB.getLength()>0){
                   
                  if (errNodesBA.getLength() > 0) {
                          for (int ab = 0; ab < errNodesBA1.getLength(); ab++) {
                                Node nNode1 = errNodesBA1.item(ab);
                                if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p2 = (Element) nNode1; 
//                                     Element err7 = (Element)errNodes8.item(0);  
                                              pstB1=conn.prepareStatement(insertBailAsset);
                                              pstB1.setString(1, CheckNull(p2,"Sequence"));
                                              pstB1.setString(2, CheckNull(p2,"AssetsName"));
                                              pstB1.setString(3, CheckNull(p2,"AssetsUnitValueBaht"));
                                              pstB1.setString(4, CheckNull(p2,"AssetsAmount"));
                                              pstB1.setString(5, CheckNull(p2,"AssetsTotalValueBaht"));
                                              pstB1.setString(6,IdPerson());
                                             pstB1.setString(7,IdCasePerson());
                                             pstB1.execute();
                                             pstB1.close();
                                           }
                                                  }
                     }    
                  if (errNodesBD.getLength() > 0) {
                          for (int ab = 0; ab < errNodesBD.getLength(); ab++) {
                                Node nNode1 = errNodesBD.item(ab);
                                if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                                    Element p2 = (Element) nNode1; 
//                                     Element err7 = (Element)errNodes8.item(0);  
                                                PreparedStatement pstD=null;
                                              pstD=conn.prepareStatement(insertBailDel);
                                                     pstD.setString(1, CheckNull(p2,"Sequence"));
                                              pstD.setString(2, NewDate(CheckNull(p2,"DueDate")));
                                              pstD.setString(3, NewTime(CheckNull(p2,"DueDate")));
                                              pstD.setString(4, CheckNull(p2,"HandOverLocation"));
                                              pstD.setString(5, IdPerson());
                                             pstD.execute();
                                             pstD.close();
                                           }
                                                  }
                     }    
                  Node bailMan=errNodesB.item(0);
                     Element err4 = (Element) bailMan ;  
                    NodeList nListBailTam = err4.getElementsByTagName("RequestForBail_Tambon");
                    NodeList nListBailAm = err4.getElementsByTagName("RequestForBail_Amphur");
                    NodeList nListBailPro = err4.getElementsByTagName("RequestForBail_Province");
                    NodeList nListBailOc = err4.getElementsByTagName("RequestForBail_Occupation");
                         Node bailDetail=nListBailOc.item(0);
                      Element bTam= (Element) nListBailTam.item(0) ; 
                      Element bAmp= (Element) nListBailAm.item(0) ; 
                      Element bPro= (Element) nListBailPro.item(0) ; 
                      Element bOccu= (Element) bailDetail ; 

                    pst3.setString(1, CheckNull(err4,"BailsmanAge"));
                    pst3.setString(2,NewDate(CheckNull(err4, "BailsmanBirthDate")));
                   pst3.setString(3, CheckNull(err4, "BailsmanFullName"));
                   pst3.setString(4, NewGender(CheckNull(err4, "BailsmanSex")));
                   pst3.setString(5, CheckNull(err4, "BailsmanHouseNumber"));  
                   pst3.setString(6, CheckNull(bOccu, "NameTH"));
                   pst3.setString(7, CheckNull(err4, "BailsmanRegisterID"));
               
                   pst3.setString(8, "");
                   pst3.setString(9, "พยานและบุคคลอื่นๆ");
                   pst3.setString(10, IdCasePerson());
                   pst3.setString(11, "นายประกัน");
                    pst3.setString(12,"" );
                   pst3.setString(13, IdPerson());
                    pst3.setString(14,  CheckNull(bTam, "Name"));
                     pst3.setString(15,  CheckNull(bAmp, "Name"));
                      pst3.setString(16,  CheckNull(bPro, "Name"));
                   pst3.execute();
                   pst3.close();
               }
                    
                }
                      System.out.println("success Person");
                      
                      
                      
                      
        } catch (SQLException e) {
                System.out.println("ddddd: "+e);
            
        }
                            
        }
           }

                } catch (Exception e) {
                System.out.println(e);
                }
     
                }

   public static String IdCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("caseid"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
     public static String IdCasePerson(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("caseid"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
        public static String IdPerson(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(NoPerson) noperson from Person";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("noperson"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
     
       public static String idChargeCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ChargeCode) chargeid from Charge";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("chargeid"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
        public static String idCharge(){
     
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ChargeCode) chargeid from Charge";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("chargeid"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
         public static String idActionCase(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ActionCode) accid from ActionsCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("accid"); 
            }
            
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
         public static String idAction(){
     
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ActionCode) accid from ActionsCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("accid"); 
            }
            
            if(id==0){
                id=1;
            }
            else{
                id=id+1;
            }
             return String.valueOf(id);
        
        } catch (Exception e) {
            return null;
//            System.out.println(e);
        } 
    
    }
//     public static String NewDateTime(String datetimee) throws Exception{
//         Locale lc = new Locale("th","TH");
//         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("d/MM/yyyy HH:mm",lc);
//          if(datetimee.equals("")){
//              String a="";
//        return   a;
//        
//        }
//        else{
//        Date date = inputFormat.parse(datetimee);
//       
//        String formattedDate = outputFormat.format(date);
//              return   formattedDate;
//        }
//      }
     public static String NewDate(String dateold) throws Exception{
         Locale lc = new Locale("th","TH");
         DateTimeFormatter  inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTimeFormatter outputFormat =DateTimeFormatter.ofPattern("d/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat("d/MM/yyyy",new Locale("th", "TH"));
       
          if(dateold.equals("")){
              String a="";
        return   a;
        
        }
        else{  
              LocalDateTime dateTime = LocalDateTime.parse(dateold, inputFormat);
             dateTime = dateTime.plusYears(543);
             
            String dateThai = dateTime.format(outputFormat);
//        Date date = inputFormat.parse(dateTime.plusYears(543););
//  
//        String formattedDate = outputFormat.format(date);
//              System.out.println("DateNewwwwwwwwwwwww:"+formattedDate);
//        Date newdate=outputFormat.parse(formattedDate);
//        
//        String dateThai= dateFormat.format(newdate);
              return   dateThai;
        }
      }
       public static String NewTime(String dateold) throws Exception{
         Locale lc = new Locale("th","TH");
         DateTimeFormatter  inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        DateTimeFormatter outputFormat =DateTimeFormatter.ofPattern("HH:mm",lc);
//
//         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm",lc);
        if(dateold.equals("")){
        return   "";
        }
        else{
             LocalDateTime dateTime = LocalDateTime.parse(dateold, inputFormat);
             dateTime = dateTime.plusHours(7);
            String dateThai = dateTime.format(outputFormat);
          return   dateThai;
        }
      }
         public static String DateSend(String dateacc) throws Exception{
         Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm",lc);
        if(dateacc.equals("")){
        return   "";
        
        }
        else{
        Date date = inputFormat.parse(dateacc);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
        }
      }
           public static String NewTypePerson(String type){
          String newType="";
         if(type.equals("Informant")){  
            newType="ผู้กล่าวหา";
         }
         else{  
            newType="พยานและบุคคลอื่นๆ";

         }
          
               return newType;
      }
            public static String NewTypePersonTraffic(String type){
          String newType="";
         if(type.equals("Charger")){  
            newType="ผู้กล่าวหา";
         }
         else{  
            newType="พยานและบุคคลอื่นๆ";

         }
          
               return newType;
      }
           public static String NewOccupation(String occ){

         if(occ.equals("ตำรวจ")){  
          return "รับราชการตำรวจ";
         }
         else{return occ;}
//               return newType;
      }
        public static String NewStatusSuspect(String occ){
            
         if(occ.equals("knowButNotArrest")){  
          return "หลบหนี";
         }
         else{return occ;}
//               return newType;
      }
      public static String NewGender(String gender) {
        String newGender = "";
        if (gender.equals("")) {
            return newGender;
        } else {
            if (gender.equals("Male")) {
                newGender = "ชาย";
            }
            if (gender.equals("Female")) {
                newGender = "หญิง";
            }
            return newGender;
        }
//               return newGender;
    }
     public static String NewCourtProvince(String court) {
      
        String newCourt="";
         if (!"".equals(court)){
             if(court.equals("ศาลอาญา")){
               return court+"/ศาลจังหวัด";
             }
             else{
         newCourt = court.substring(0,10);
        if (newCourt.equals("ศาลจังหวัด")) {                  
            newCourt="ศาลอาญา/ศาลจังหวัด";
                 
        } 
        else if(!"ศาลจังหวัด".equals(newCourt)){
        newCourt = court.substring(0,7);
         if (newCourt.equals("ศาลแขวง")) {                  
           return newCourt;
                 
        }
         else if(!"ศาลแขวง".equals(newCourt)){
             newCourt = court.substring(0,20);
              if (newCourt.equals("ศาลเยาวชนและครอบครัว")) {                  
           return newCourt;
                }
          
              }
         else{
         return  court;
         }
        }
             }
        }
         System.out.println("Courtttttttttttttt:"+newCourt);
         return newCourt;
         
    }
      public static String NewStatusSue(String sts) {
        String status = "";
     
            if (sts.equals("Jail")) {
                status = "ฝากขัง";
            }
           else if (sts.equals("Filed")) {
                status = "ผัดฟ้อง";
            }
           else if (sts.equals("FiledWithJail")) {
                status = "ผัดฟ้องฝากขัง";
            }
           else{status = "";}
            return status;
        
//               return newGender;
    }
       public static String NewStatusRelate(String sts) {
        String status = "";
     
            if (sts.equals("Victim")) {
                status = "ผู้เสียหาย";
            }
           else if (sts.equals("Suspect")) {
                status = "ผู้ต้องหา";
            }
           else if (sts.equals("Complainer")) {
                status = "ผู้แจ้ง";
            }
           else if (sts.equals("witness")) {
                status = "พยาน";
            }
           else if (sts.equals("Litigant")) {
                status = "คู่กรณี";
            }
           else if (sts.equals("Informant")) {
                status = "ผู้กล่าวหา";
            }
           else{status = "";}
            return status;
        
//               return newGender;
    }
          public static String NewStatusRelateTraffic(String sts) {
        String status = "";
     
            if (sts.equals("Victim")) {
                status = "ผู้เสียหาย";
            }
           else if (sts.equals("Suspect")) {
                status = "ผู้ต้องหา";
            }
           else if (sts.equals("Informant")) {
                status = "ผู้แจ้ง";
            }
           else if (sts.equals("witness")) {
                status = "พยาน";
            }
           else if (sts.equals("Litigant")) {
                status = "คู่กรณี";
            }
           else if (sts.equals("Charger")) {
                status = "ผู้กล่าวหา";
            }
           else if (sts.equals("OtherSuspect")) {
                status = "ผู้ต้องหา";
            }
           else{status = "";}
            return status;
        
//               return newGender;
    }
       public static String ChangFormat(String DateSue){
        String newFormatDate=null;
       try{   Calendar cal;
        SimpleDateFormat formatdate =new SimpleDateFormat("d/MM/yyyy");  
         if(DateSue == null || DateSue.equals("null")|| DateSue.equals("0")|| DateSue.equals("")){
            newFormatDate="";
        }
         else{
        Date b=formatdate.parse(DateSue);
         cal = Calendar.getInstance();
          cal.setTime(b); 
           SimpleDateFormat dateformat =new SimpleDateFormat("yyyy/MM/d");   
         newFormatDate=dateformat.format(cal.getTime());
         }
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    
    }
 public static String CheckNull(Element nd,String type){
          String newType="";
//           Element p = (Element) nd; 
//           System.out.println(type);
//           String newType2="";   
Object a=nd.getElementsByTagName(type).item(0);
//System.out.println("sasa:"+a);
          String check=".getTextContent()";
          if(nd.hasChildNodes()){
         if(a != null){ 
         
           String newType2=a+check; 
//           System.out.println("asdasdasd:"+nd.getElementsByTagName(type).item(0).getTextContent()); 
            return nd.getElementsByTagName(type).item(0).getTextContent();
         }
         else{ 
//             System.out.println("ssssssssss:"+newType);        
            return newType;

         }
          }
          else{
           return newType;
          }
      
      }
  public static String CheckNullSue(Element nd,String type,int round){
          String newType="";
//           Element p = (Element) nd; 
//           System.out.println(type);
//           String newType2="";   
        Object a=nd.getElementsByTagName(type).item(round);
//System.out.println("sasa:"+a);
          String check=".getTextContent()";
         if(a != null){ 
         
           String newType2=a+check; 
//           System.out.println("asdasdasd:"+nd.getElementsByTagName(type).item(0).getTextContent()); 
            return nd.getElementsByTagName(type).item(round).getTextContent();
         }
         else{ 
//             System.out.println("ssssssssss:"+newType);        
            return newType;

         }
      
      }
    public static String CheckNullSue2(Element nd,String type){
          String newType="";
//           Element p = (Element) nd; 
//           System.out.println(type);
//           String newType2="";   
Object a=nd.getElementsByTagName(type).item(2);
//System.out.println("sasa:"+a);
          String check=".getTextContent()";
         if(a != null){ 
         
           String newType2=a+check; 
//           System.out.println("asdasdasd:"+nd.getElementsByTagName(type).item(0).getTextContent()); 
            return nd.getElementsByTagName(type).item(2).getTextContent();
         }
         else{ 
//             System.out.println("ssssssssss:"+newType);        
            return newType;

         }
      
      }
//  public static String CheckDate(String nd,String type) {
//
//      
//      }
    private static String sendGET(String GET_URL)  {
                String a="";
//		URL serverUrl = new URL(GET_URL);
//		HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("User-Agent", "Mozilla/5.0");
//                con.setRequestProperty("Accept-Charset", "UTF-8");
//		int responseCode = con.getResponseCode();
//		System.out.println("GET Response Code :: " + responseCode);
//		if (responseCode == HttpURLConnection.HTTP_OK) { // success
//			BufferedReader in = new BufferedReader(new InputStreamReader(
//					con.getInputStream(),"UTF-8"));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//
//			while ((inputLine = in.readLine()) != null) {
//				response.append(inputLine);
//			}
//			in.close();
//
//			// print result
////			System.out.println(response.toString());
//                        return response.toString();
//		} else {
//			System.out.println("GET request not worked");
//                        return null;
//		}
  try{
		URL serverUrl = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();      
                con.setConnectTimeout(1000);
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("Accept-Charset", "UTF-8");
                System.out.println("ssss"+con.getResponseCode());
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
//			System.out.println(response.toString());
                        return response.toString();
		} else {
			System.out.println("GET request not worked");
                        return null;
		}
                }
                catch(IOException ie){
                System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+ie);
                return "0";
                }
                
	}  
    public static String getMotherboardSerial(){
		try
	    {
	        String result = null;
                 String nline = null;

	        Process p = Runtime.getRuntime().exec("wmic baseboard get product,Manufacturer,version,serialnumber");
	               BufferedReader input
	                = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
	        String line;
	        while ((line = input.readLine()) != null)
	        {
	        	nline += line;
	        }
                  result= nline.replace(" ","");
        System.out.println("aa "+result);
	        input.close();
	        return result;
	    } catch (IOException ex)
	    {
	        ex.printStackTrace();
	        return null;
	    }
	}
 public class BackgroundWorker extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
        private JLabel ab;
		private JDialog dialog;
//   public void Task() {
//       
//    }
//       public ProgressWorker(JProgressBar progress) {
//            this.progress = progress;
//        
            public BackgroundWorker() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
//					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
								dialog = new JDialog();
                                                        ImageIcon img = new ImageIcon("./Master/WD.png");
                                                           dialog.setIconImage(img.getImage());
							dialog.setTitle("Processing");
                                                        
							dialog.setLayout(new GridBagLayout());
							dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							GridBagConstraints gbc = new GridBagConstraints();
                                                        gbc.gridheight=20;
                                                        gbc.gridwidth = 10;
                                                         gbc.gridx = 10;
                                                            gbc.gridy = 20;
							gbc.insets = new Insets(20, 20, 20, 20);
							gbc.weightx = 1;
                                                        
							gbc.gridy = 0; 
                                                        ab=new JLabel("กำลังทำการเรียกดูคดีจากระบบ CRIMES.....");
                                                        ab.setFont(new java.awt.Font("TH SarabunPSK", 1, 20));
							dialog.add(ab, gbc);
							pb = new JProgressBar();
                                                      
//							pb.setStringPainted(true);
//                                                        pb.setForeground(Color.blue);]
                                               
//                                                        pb.setMaximum(100);
//                                                        pb.setMinimum(0);
                                                        
							gbc.gridy = 1;
							dialog.add(ab, gbc);
							dialog.pack();
							dialog.setLocationRelativeTo(null);
							dialog.setModal(true);
							JDialog.setDefaultLookAndFeelDecorated(true); 
							dialog.setVisible(true);
						}
//						pb.setValue(getProgress());
//					}
				}

			});
		}
    @Override
    public Void doInBackground() {

        try { 

            for (int i = 1; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
            Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task
        String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token:"+aa); 
        String case1="",case2="",yearcase="";
    
        System.out.println("dsdfsffffffffff");
           if(jCheckCase.isSelected()){
          case1=casenocc.getText();
          case2=casenocc.getText();
          yearcase=caseyearscc.getText();
        }
        else if(jCheckCaseTwo.isSelected()){
        case1=casenocc1.getText();
          case2=casenocc3.getText();
          yearcase=caseyearscc1.getText();
        }

            String timeStart="00:00";
        String timeEnd="23:59";
        JsonObject jsonInput = new JsonObject();
        
        jsonInput.addProperty("CrimeCaseNo",case1);
         jsonInput.addProperty("CrimeCaseNoTo",case2);
        jsonInput.addProperty("CrimeCaseYear",yearcase);
        jsonInput.addProperty("CrimeCaseYearTo",yearcase);
        jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
        //         jsonInput.addProperty("ORG_CODE","70028");
        jsonInput.addProperty("PasswordWordgen",aa);
        jsonInput.addProperty("StatusMagenta","Magenta_inActive");
        
        jsonInput.addProperty("CaseRequestDate",AcceptDate(DateReqStart.getJFormattedTextField().getText(),timeStart));
        jsonInput.addProperty("CaseRequestDateTo",AcceptDate(DateReqEnd.getJFormattedTextField().getText(),timeEnd));
        jsonInput.addProperty("CaseAcceptDate",AcceptDate(DateAcceptStart.getJFormattedTextField().getText(),timeStart));
        jsonInput.addProperty("CaseAcceptDateTo",AcceptDate(DateAcceptEnd.getJFormattedTextField().getText(),timeEnd));

        call_crimes(jsonInput);
        TotalCase.setText(jTableCrime.getRowCount()+"");
     
            }
        } catch (InterruptedException e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
            int rowcase=jTableCrime.getRowCount();
                            if(rowcase ==0){
            JOptionPane.showMessageDialog(null, "ไม่พบข้อมูลคดีในระบบ crimes");
        }

    }
}/**/
 public class BackgroundWorkerTraff extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
        private JLabel ab;
		private JDialog dialog;
//   public void Task() {
//       
//    }
//       public ProgressWorker(JProgressBar progress) {
//            this.progress = progress;
//        
            public BackgroundWorkerTraff() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
//					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
								dialog = new JDialog();
                                                        ImageIcon img = new ImageIcon("./Master/WD.png");
                                                           dialog.setIconImage(img.getImage());
							dialog.setTitle("Processing");
                                                        dialog.setSize(new Dimension(100, 500));
                                                        dialog.setResizable(false);
							dialog.setLayout(new GridBagLayout());
							dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							GridBagConstraints gbc = new GridBagConstraints();
							 gbc.gridheight=20;
                                                        gbc.gridwidth = 10;
                                                         gbc.gridx = 10;
                                                            gbc.gridy = 20;
							gbc.insets = new Insets(20, 20, 20, 20);
							gbc.weightx = 1;
                                                        
							gbc.gridy = 0; 
                                                        ab=new JLabel("กำลังทำการเรียกดูคดีจากระบบ CRIMES.....");
                                                        ab.setFont(new java.awt.Font("TH SarabunPSK", 1, 20));
							dialog.add(ab, gbc);
							pb = new JProgressBar();
                                                      
//							pb.setStringPainted(true);
//                                                        pb.setForeground(Color.blue);]
                                               
//                                                        pb.setMaximum(100);
//                                                        pb.setMinimum(0);
                                                        
							gbc.gridy = 1;
							dialog.add(ab, gbc);
							dialog.pack();
							dialog.setLocationRelativeTo(null);
							dialog.setModal(true);
							JDialog.setDefaultLookAndFeelDecorated(true); 
							dialog.setVisible(true);
						}
//						pb.setValue(getProgress());
//					}
				}

			});
		}
    @Override
    public Void doInBackground() {

        try { 

            for (int i = 1; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
            Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task
            String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token:"+aa); 
        String case1="",case2="",yearcase="";
         if(jCheckCaseT.isSelected()){
          case1=casenocc4.getText();
          case2=casenocc4.getText();
          yearcase=caseyearscc3.getText();
        }
        else if(jCheckCaseTwo1.isSelected()){
        case1=casenocc5.getText();
          case2=casenocc6.getText();
          yearcase=caseyearscc4.getText();
        }
        
            String timeStart="00:00";
        String timeEnd="23:59";
        JsonObject jsonInput = new JsonObject();
        
        jsonInput.addProperty("CrimeCaseNo",case1);
         jsonInput.addProperty("CrimeCaseNoTo",case2);
        jsonInput.addProperty("CrimeCaseYear",yearcase);
        jsonInput.addProperty("CrimeCaseYearTo",yearcase);
        jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
        //         jsonInput.addProperty("ORG_CODE","70028");
        jsonInput.addProperty("PasswordWordgen",aa);
        jsonInput.addProperty("StatusMagenta","Magenta_inActive");
        
        jsonInput.addProperty("CaseRequestDate",AcceptDate(DateReqStartTC.getJFormattedTextField().getText(),timeStart));
        jsonInput.addProperty("CaseRequestDateTo",AcceptDate(DateReqEndTC.getJFormattedTextField().getText(),timeEnd));
        jsonInput.addProperty("CaseAcceptDate",AcceptDate(DateAcceptStartTC.getJFormattedTextField().getText(),timeStart));
        jsonInput.addProperty("CaseAcceptDateTo",AcceptDate(DateAcceptEndTC.getJFormattedTextField().getText(),timeEnd));

        call_traffic(jsonInput);
        TotalCase1.setText(jTableTraffic.getRowCount()+"");
       
       
     
            }
        } catch (InterruptedException e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
            int rowcase=jTableTraffic.getRowCount();
        if(rowcase ==0){
            JOptionPane.showMessageDialog(null, "ไม่พบข้อมูลคดีในระบบ crimes");
        }

    }
}/**/
  public class BackgroundWorkerInsert extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
        private JLabel ab;
		private JDialog dialog;
//   public void Task() {
//       
//    }
//       public ProgressWorker(JProgressBar progress) {
//            this.progress = progress;
//        
            public BackgroundWorkerInsert() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
								dialog = new JDialog();
                                                        ImageIcon img = new ImageIcon("./Master/WD.png");
                                                           dialog.setIconImage(img.getImage());
							dialog.setTitle("Processing");
							dialog.setLayout(new GridBagLayout());
							dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							GridBagConstraints gbc = new GridBagConstraints();
							 gbc.gridheight=20;
                                                        gbc.gridwidth = 10;
                                                         gbc.gridx = 10;
                                                            gbc.gridy = 20;
							gbc.insets = new Insets(20, 20, 20, 20);
							gbc.weightx = 1;
                                                        
							gbc.gridy = 0; 
                                                        ab=new JLabel("กำลังทำการดึงข้อมูลคดีจากระบบ CRIMES.....");
                                                        ab.setFont(new java.awt.Font("TH SarabunPSK", 1, 20));
							dialog.add(ab, gbc);
							pb = new JProgressBar();
                                                      
//							pb.setStringPainted(true);
//                                                        pb.setForeground(Color.blue);]
                                               
//                                                        pb.setMaximum(100);
//                                                        pb.setMinimum(0);
                                                        
							gbc.gridy = 1;
							dialog.add(ab, gbc);
							dialog.pack();
							dialog.setLocationRelativeTo(null);
							dialog.setModal(true);
							JDialog.setDefaultLookAndFeelDecorated(true); 
							dialog.setVisible(true);
						}
						pb.setValue(getProgress());
					}
				}

			});
		}
    @Override
    public Void doInBackground() {

        try { 

            for (int b = 1; b < 2; b++) {
//                x = x - i;
            setProgress((int)((b*100)/2)+1);

//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(1000);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task
      String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token-List:"+aa);
       ArrayList<String> caseList = new ArrayList<String>();
      ArrayList<String> caseidList = new ArrayList<String>();
        ArrayList<String> casenoList = new ArrayList<String>();
    ArrayList<String> caseyearList = new ArrayList<String>();
        for (int i = 0; i < jTableCrime.getRowCount(); i++) {
            Boolean chked = Boolean.valueOf(jTableCrime.getValueAt(i, 0).toString());
            String casno = jTableCrime.getValueAt(i, 2).toString();
            String casyear = jTableCrime.getValueAt(i, 3).toString();
            String charge = jTableCrime.getValueAt(i, 5).toString();
            String orgcode=jLabelorgcode.getText();
            String user=usernamelabel.getText();
            String idcard=idcardlabel.getText();
            String nameor=orgnamelabel.getText();
            //        String newnameor="";
            //        try{
                //         newnameor=URLEncoder.encode(nameor, "UTF-8");
                //        }
            //        catch(Exception e){
                //
                //        }
            //            System.out.println("aa:"+nameor);

            if (chked) {
                try{
                    Connection c=null;
                    c=ConnectDatabase.connect();
                    String sqlId="Select caseid,crimecaseno,crimecaseyears,crimecasenoyear from CrimeCase where crimecaseno='"+casno+"' and crimecaseyears='"+casyear+"' and crimecasenoyear='"+casno+"/"+casyear+"' and CaseType='คดีอาญา'";
                    
                    Statement s=c.createStatement();
                    ResultSet rs=s.executeQuery(sqlId);
 
                    if (rs.next()) {
                        System.out.println("id"+i+"c"+casno+"/"+casyear);
                        String cid=rs.getString("caseid");
                        caseList.add(casno+"/"+casyear);
                        caseidList.add(cid);
                       casenoList.add(casno);
                       caseyearList.add(casyear);
                       
                    }
                    else{
                        JsonObject jsonInput = new JsonObject();
                        jsonInput.addProperty("CrimeCaseNo",casno);
                        jsonInput.addProperty("CrimeCaseYear",casyear);
                        jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
                        jsonInput.addProperty("Usename",usernamelabel.getText());
                        jsonInput.addProperty("PasswordWordgen",aa);
                        jsonInput.addProperty("OrgName",orgnamelabel.getText());
                        jsonInput.addProperty("Serial",getMotherboardSerial());
                        jsonInput.addProperty("DisplayChargeMain",charge);

                        String j=jsonInput.toString();
                        //         String replaced = j.replace("\"", "\\\"");
                        //String n="{\"CrimeCaseNo\":\""+casno+"\",\"CrimeCaseYear\":\""+casyear+"\",\"ORG_CODE\":\""+orgcode+"\",\"Usename\":\""+user+"\",\"Idcard\":\""+idcard+"\",\"OrgName\":\""+nameor+"\"}";
                        //String n="{\"CrimeCaseNo\":\""+casno+"\",\"CrimeCaseYear\":\""+casyear+"\",\"ORG_CODE\":\""+jLabelorgcode.getText()+"\",\"Usename\":\""+usernamelabel.getText()+"\",\"Idcard\":\""+idcardlabel.getText()+"\",\"OrgName\":\""+orgname.getText()+"\"}";

                        insert_crime(jsonInput);
                        //         String j=jsonInput.toString();
                        System.out.println(j);

                    }

                }
                catch(Exception ex){

                }
                //       		JOptionPane.showMessageDialog(null, "ดึงข้อมูลเรียบร้อยแล้ว");

                //		JOptionPane.showMessageDialog(null, dataCol1);
            } 
        
        }
        if(caseList.size()>0){
            String ar=caseList.toString().replace("[", "");
            String ae=ar.replace("]", "");
           
         int response = JOptionPane.showConfirmDialog(jPanel6, "คดีที่ "+ae+"\nมีข้อมูลคดีนี้แล้วต้องการบันทึกข้อมูลแทนที่ของเดิมหรือไม่ ", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                 if (response == JOptionPane.YES_OPTION) {
                            //             con=ConnectDatabase.connect();
                            for(int i=0;i<caseidList.size() && i<casenoList.size() && i<caseyearList.size();i++){
                            JsonObject jsonInput = new JsonObject();
                            jsonInput.addProperty("CrimeCaseNo",casenoList.get(i));
                            jsonInput.addProperty("CrimeCaseYear",caseyearList.get(i));
                            jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
                            jsonInput.addProperty("Usename",usernamelabel.getText());
                            jsonInput.addProperty("PasswordWordgen",aa);
                            jsonInput.addProperty("OrgName",orgnamelabel.getText());
                            jsonInput.addProperty("Serial",getMotherboardSerial());
                            jsonInput.addProperty("DisplayChargeMain","");
                            String j=jsonInput.toString();
                            update_crime(jsonInput,caseidList.get(i));
                            System.out.println(j);
                            }            
        }
    }
//        System.out.println("ddd"+caseList.toString());
      
   
            }
        } catch (InterruptedException e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
            JOptionPane.showMessageDialog(null, "การทำรายการเสร็จสิ้น");
        

    }
}/**/
   public class BackgroundWorkerInsertTraff extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
        private JLabel ab;
		private JDialog dialog;
//   public void Task() {
//       
//    }
//       public ProgressWorker(JProgressBar progress) {
//            this.progress = progress;
//        
            public BackgroundWorkerInsertTraff() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
									dialog = new JDialog();
                                                        ImageIcon img = new ImageIcon("./Master/WD.png");
                                                           dialog.setIconImage(img.getImage());
							dialog.setTitle("Processing");
							dialog.setLayout(new GridBagLayout());
							dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							GridBagConstraints gbc = new GridBagConstraints();
							 gbc.gridheight=20;
                                                        gbc.gridwidth = 10;
                                                         gbc.gridx = 10;
                                                            gbc.gridy = 20;
							gbc.insets = new Insets(20, 20, 20, 20);
							gbc.weightx = 1;
                                                        
							gbc.gridy = 0; 
                                                        ab=new JLabel("กำลังทำการดึงข้อมูลคดีจากระบบ CRIMES.....");
                                                        ab.setFont(new java.awt.Font("TH SarabunPSK", 1, 20));
							dialog.add(ab, gbc);
							pb = new JProgressBar();
                                                      
//							pb.setStringPainted(true);
//                                                        pb.setForeground(Color.blue);]
                                               
//                                                        pb.setMaximum(100);
//                                                        pb.setMinimum(0);
                                                        
							gbc.gridy = 1;
							dialog.add(ab, gbc);
							dialog.pack();
							dialog.setLocationRelativeTo(null);
							dialog.setModal(true);
							JDialog.setDefaultLookAndFeelDecorated(true); 
							dialog.setVisible(true);
						}
						pb.setValue(getProgress());
					}
				}

			});
		}
    @Override
    public Void doInBackground() {

        try { 

            for (int b = 1; b < 2; b++) {
//                x = x - i;
            setProgress((int)((b*100)/2)+1);

//        setProgress(i * (100 / N));
//				  setProgress(i);
				Thread.sleep(1000);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task
       String aa="";
        aa=MainMenuWord.tk;
        System.out.println("Token-List:"+aa);
       ArrayList<String> caseList = new ArrayList<String>();
      ArrayList<String> caseidList = new ArrayList<String>();
        ArrayList<String> casenoList = new ArrayList<String>();
    ArrayList<String> caseyearList = new ArrayList<String>();
        for (int i = 0; i < jTableTraffic.getRowCount(); i++) {
            Boolean chked = Boolean.valueOf(jTableTraffic.getValueAt(i, 0).toString());
            String casno = jTableTraffic.getValueAt(i, 2).toString();
            String casyear = jTableTraffic.getValueAt(i, 3).toString();
           String charge = jTableTraffic.getValueAt(i, 5).toString();
            if (chked) {
                try{
                    Connection c=null;
                    c=ConnectDatabase.connect();
                    String sqlId="Select caseid,crimecaseno,crimecaseyears,crimecasenoyear from CrimeCase where crimecaseno='"+casno+"' and crimecaseyears='"+casyear+"' and crimecasenoyear='"+casno+"/"+casyear+"' and casetype='คดีจราจร'";
                    
                    Statement s=c.createStatement();
                    ResultSet rs=s.executeQuery(sqlId);
 
                    if (rs.next()) {
                        System.out.println("id"+i+"c"+casno+"/"+casyear);
                        String cid=rs.getString("caseid");
                        caseList.add(casno+"/"+casyear);
                        caseidList.add(cid);
                       casenoList.add(casno);
                       caseyearList.add(casyear);
                       
//                        int response = JOptionPane.showConfirmDialog(jPanel6, "คดีที่ "+casno+"/"+casyear+" มีข้อมูลคดีนี้แล้วต้องการบันทึกข้อมูลซ้ำหรือไม่", "ยืนยัน",
//                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//                        if (response == JOptionPane.YES_OPTION) {
//                            //             con=ConnectDatabase.connect();
//                            JsonObject jsonInput = new JsonObject();
//                            jsonInput.addProperty("CrimeCaseNo",casno);
//                            jsonInput.addProperty("CrimeCaseYear",casyear);
//                            jsonInput.addProperty("ORG_CODE",jLabelorgcode.getText());
//                            jsonInput.addProperty("Usename",usernamelabel.getText());
//                            jsonInput.addProperty("PasswordWordgen",aa);
//                            jsonInput.addProperty("OrgName",orgnamelabel.getText());
//                            jsonInput.addProperty("Serial",getMotherboardSerial());
//                            String j=jsonInput.toString();
//                            update_crime(jsonInput,cid);
//                            System.out.println(j);
//
//                        }
                    }
                    else{
                        JsonObject jsonInput = new JsonObject();
                        jsonInput.addProperty("CrimeCaseNo",casno);
                        jsonInput.addProperty("CrimeCaseYear",casyear);
                        jsonInput.addProperty("ORG_CODE",jLabelorgcode1.getText());
                        jsonInput.addProperty("Usename",usernamelabel.getText());
                        jsonInput.addProperty("PasswordWordgen",aa);
                        jsonInput.addProperty("OrgName",orgnamelabel1.getText());
                        jsonInput.addProperty("Serial",getMotherboardSerial());
                         jsonInput.addProperty("DisplayChargeMain",charge);
                       
                        String j=jsonInput.toString();
                        //         String replaced = j.replace("\"", "\\\"");
                        //String n="{\"CrimeCaseNo\":\""+casno+"\",\"CrimeCaseYear\":\""+casyear+"\",\"ORG_CODE\":\""+orgcode+"\",\"Usename\":\""+user+"\",\"Idcard\":\""+idcard+"\",\"OrgName\":\""+nameor+"\"}";
                        //String n="{\"CrimeCaseNo\":\""+casno+"\",\"CrimeCaseYear\":\""+casyear+"\",\"ORG_CODE\":\""+jLabelorgcode.getText()+"\",\"Usename\":\""+usernamelabel.getText()+"\",\"Idcard\":\""+idcardlabel.getText()+"\",\"OrgName\":\""+orgname.getText()+"\"}";

                        insert_traffic(jsonInput);
                        //         String j=jsonInput.toString();
                        System.out.println(j);

                    }

                }
                catch(Exception ex){

                }
                //       		JOptionPane.showMessageDialog(null, "ดึงข้อมูลเรียบร้อยแล้ว");

                //		JOptionPane.showMessageDialog(null, dataCol1);
            }
        }
        if(caseList.size()>0){
            String ar=caseList.toString().replace("[", "");
            String ae=ar.replace("]", "");
           
         int response = JOptionPane.showConfirmDialog(jPanel6, "คดีที่ "+ae+"\nมีข้อมูลคดีนี้แล้วต้องการบันทึกข้อมูลแทนที่ของเดิมหรือไม่ ", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                 if (response == JOptionPane.YES_OPTION) {
                            //             con=ConnectDatabase.connect();
                            for(int i=0;i<caseidList.size() && i<casenoList.size() && i<caseyearList.size();i++){
                            JsonObject jsonInput = new JsonObject();
                            jsonInput.addProperty("CrimeCaseNo",casenoList.get(i));
                            jsonInput.addProperty("CrimeCaseYear",caseyearList.get(i));
                            jsonInput.addProperty("ORG_CODE",jLabelorgcode1.getText());
                            jsonInput.addProperty("Usename",usernamelabel.getText());
                            jsonInput.addProperty("PasswordWordgen",aa);
                            jsonInput.addProperty("OrgName",orgnamelabel1.getText());
                            jsonInput.addProperty("Serial",getMotherboardSerial());
                            jsonInput.addProperty("DisplayChargeMain","");
                            String j=jsonInput.toString();
                            update_traffic(jsonInput,caseidList.get(i));
                            System.out.println(j);
                            }            
        }
    }
//        System.out.println("ddd"+caseList.toString());
    
//        System.out.println("ddd"+caseList.toString());
      
   
            }
        } catch (InterruptedException e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
            JOptionPane.showMessageDialog(null, "การทำรายการเสร็จสิ้น");
        

    }
}/**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalCase;
    private javax.swing.JLabel TotalCase1;
    private javax.swing.JTextField casenocc;
    private javax.swing.JTextField casenocc1;
    private javax.swing.JTextField casenocc3;
    private javax.swing.JTextField casenocc4;
    private javax.swing.JTextField casenocc5;
    private javax.swing.JTextField casenocc6;
    private javax.swing.JTextField caseyearscc;
    private javax.swing.JTextField caseyearscc1;
    private javax.swing.JTextField caseyearscc3;
    private javax.swing.JTextField caseyearscc4;
    private javax.swing.JLabel idcardlabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonConCrime;
    private javax.swing.JButton jButtonConTraffic;
    private javax.swing.JCheckBox jCheckAccept;
    private javax.swing.JCheckBox jCheckAccept1;
    private javax.swing.JCheckBox jCheckCase;
    private javax.swing.JCheckBox jCheckCaseT;
    private javax.swing.JCheckBox jCheckCaseTwo;
    private javax.swing.JCheckBox jCheckCaseTwo1;
    private javax.swing.JCheckBox jCheckDateReg;
    private javax.swing.JCheckBox jCheckDateReg1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelorgcode;
    private javax.swing.JLabel jLabelorgcode1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelEnAcc;
    private javax.swing.JPanel jPanelReg;
    private javax.swing.JPanel jPanelReg2;
    private javax.swing.JPanel jPanelRegTCE;
    private javax.swing.JPanel jPanelRegTCS;
    private javax.swing.JPanel jPanelStAcc;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCrime;
    private javax.swing.JTable jTableTraffic;
    public static javax.swing.JLabel jlabeltoken;
    private javax.swing.JLabel orgnamelabel;
    private javax.swing.JLabel orgnamelabel1;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
