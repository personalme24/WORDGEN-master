/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.CrimesCaseEdit.ChargeNameCase;
import static com.songkhla.wordgen.CrimesCaseEdit.Checknull;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextAccused;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;

/**
 *
 * @author Computer
 */
public class AccusedForm extends javax.swing.JDialog {
    Connection con=null;
    Connection con2=null;
     PreparedStatement pst=null;
     PreparedStatement pst2=null;
     boolean isInsert,isPerson;
     
     String noPerson,typeCase;
     JDatePickerImpl IssueDate,ExpiredDate,BirthDay;
     public static JDatePickerImpl DateSendInjuredOrDie;
     ArrayList<String> personname=new ArrayList<String>();
//     Font font,sizedFont;
//     private JComboBox<String> comboBox;
    /**
     * Creates new form AccusedForm
     */

    public AccusedForm(JFrame parrent,JSONObject datain,JSONObject datacase) {
        super(parrent,true);
        initComponents();  
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
            try{
               Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                Font   labelName = font.deriveFont(22f);
                     jLabel5.setFont(labelName);
                     jLabel28.setFont(labelName);
                     jLabel2.setFont(labelName);
                     jCheckInjured.setFont(labelName);
                     jCheckDead.setFont(labelName);
                     jLabel7.setFont(labelName);
                     jLabel9.setFont(labelName);
                     jLabel1.setFont(labelName);
                      jLabel6.setFont(labelName);
                     jLabel8.setFont(labelName);
                     jLabel18.setFont(labelName);
                     jLabel12.setFont(labelName);
                     jLabel13.setFont(labelName);
                     jLabel16.setFont(labelName);
                     jLabel17.setFont(labelName);
                     jLabel20.setFont(labelName);
                      jLabel15.setFont(labelName);
                     jLabel14.setFont(labelName);
                     jLabel31.setFont(labelName);
                     jLabel26.setFont(labelName);
                     jLabel29.setFont(labelName);
                     jLabel25.setFont(labelName);
                     jLabel21.setFont(labelName);
                     jLabel30.setFont(labelName);
                     jLabel22.setFont(labelName);
                     jLabel23.setFont(labelName);
                     jLabel27.setFont(labelName);
                     jLabel24.setFont(labelName);
                     jLabel4.setFont(labelName);
                     jLabel19.setFont(labelName);
                     jLabel11.setFont(labelName);
                     BtSaveAccused.setFont(labelName);
                     jButton2.setFont(labelName);
                     jButton1.setFont(labelName);
                     jButtonInjuryOrDie.setFont(labelName);
                     
            }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
//     Occupation = new HintTextField("Another hint here");
     crimecaseno.setVisible(false);
     AnswerPerson.setVisible(false);
        jButtonInjuryOrDie.setVisible(false);
       CauseSendInjuredOrDie.setVisible(false);
       WhereSendInjuredOrDie.setVisible(false);
       TimeSendInjuredOrDie.setVisible(false);
       jPanel4.setVisible(false);

     FullNamePerson.addCaretListener(new TextFieldCaretListener());
     comboBox.addActionListener(new ComboBoxActionListener());
     UtilDateModel model2 = new UtilDateModel();
//            model2.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
          JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         IssueDate = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
        IssueDate.setTextEditable(true);
        IssueDate.setBackground(Color.WHITE);
        jPanelIssueDate.setLayout(new FlowLayout());
        jPanelIssueDate.add(IssueDate); 
        
        UtilDateModel model3 = new UtilDateModel();
//            model3.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel3 = new JDatePanelImpl(model3, p);
         ExpiredDate = new JDatePickerImpl(datePanel3,new DateLabelFormatter());
        ExpiredDate.setTextEditable(true);
        ExpiredDate.setBackground(Color.WHITE);
        jPanelExpiredDate.setLayout(new FlowLayout());
        jPanelExpiredDate.add(ExpiredDate);
//       
            UtilDateModel model4 = new UtilDateModel();
//            model4.setValue(Calendar.getInstance().getTime());
        JDatePanelImpl datePanel4 = new JDatePanelImpl(model4, p);
         BirthDay = new JDatePickerImpl(datePanel4,new DateLabelFormatter());
        BirthDay.setTextEditable(true);
        BirthDay.setBackground(Color.WHITE);
        jPanelBirthDay.setLayout(new FlowLayout());
        jPanelBirthDay.add(BirthDay);
//      
UtilDateModel model5 = new UtilDateModel();
            model5.setValue(Calendar.getInstance().getTime());
        
          JDatePanelImpl datePanel5 = new JDatePanelImpl(model5, p);
         DateSendInjuredOrDie = new JDatePickerImpl(datePanel5,new DateLabelFormatter());
        DateSendInjuredOrDie.setTextEditable(true);
        DateSendInjuredOrDie.setBackground(Color.WHITE);
        jPanel4.setLayout(new FlowLayout());
        jPanel4.add(DateSendInjuredOrDie); 
        typeCase=datacase.get("TypeCase")+"";
               String[] ItemDead = {"","พยาน","บิดาผู้ตาย", "มารดาผู้ตาย", "บุตรผู้ตาย", "สามีผูตาย", "ภริยาผู้ตาย", "ผู้ปกครองผู้ตาย", "พี่ร่วมบิดามารดาของผู้ตาย",
                               "พี่ร่วมบิดาของผู้ตาย", "พี่ร่วมมารดาของผู้ตาย", "น้องร่วมบิดามารดาของผู้ตาย", "น้องร่วมบิดาของผู้ตาย", "น้องร่วมมารดาของผู้ตาย",
                                "ลุงผู้ตาย","ป้าผู้ตาย","น้าผู้ตาย","อาผู้ตาย","ปู่ผู้ตาย","ย่าผู้ตาย","ตาผู้ตาย","ยายผู้ตาย","หลานผู้ตาย","เหลนผู้ตาย","ผู้มีส่วนได้เสียกับผู้ตาย","พนักงานสอบสวนในคดี"};
       String[] ItemCrimes= {"","ผู้กล่าวหา","ผู้จับกุมผู้ต้องหาและยึดของกลาง", "ผู้จับกุมผู้ต้องหา", "ผู้พบการกระทำผิดและยึดของกลาง", "ผู้พบการกระทำผิด", "ผู้เสียหาย", "ผู้จัดการแทนผู้เสียหาย", "ผู้รับมอบอำนาจจากผู้เสียหาย","พนักงานสอบสวนในคดี"};
       if(typeCase.equals("ชันสูตร")){
           RelatedAccused.setModel(new DefaultComboBoxModel<>(ItemDead));

       }
        else {
           RelatedAccused.setModel(new DefaultComboBoxModel<>(ItemCrimes));

       }
          if(datain!=null){
            isInsert=false;
            noPerson=datain.get("NoPerson")+"";
            crimecaseno.setText(Checknull(datain.get("crimecaseno"))+"");
            PeopleRegistrationID.setText(Checknull(datain.get("PeopleRegistrationID"))+"");
            FullNamePerson.setText(Checknull(datain.get("FullNamePerson"))+"");
            Age.setText(Checknull(datain.get("Age"))+"");
            Amphur.setText(Checknull(datain.get("Amphur"))+"");
            BirthDay.getJFormattedTextField().setText(datain.get("BirthDay")+"");
            BloodGroup.setSelectedItem(Checknull(datain.get("BloodGroup"))+"");
            ExpiredDate.getJFormattedTextField().setText(Checknull(datain.get("ExpiredDate"))+"");
            FatherFullName.setText(Checknull(datain.get("FatherFullName"))+"");
            FullNamePersonEn.setText(Checknull(datain.get("FullNamePersonEn"))+"");
            Height.setText(Checknull(datain.get("Height"))+"");
            Weight.setText(Checknull(datain.get("Weight"))+"");
            HouseNumber.setText(Checknull(datain.get("HouseNumber"))+"");
            IssueDate.getJFormattedTextField().setText(Checknull(datain.get("IssueDate"))+"");
            Moo.setText(Checknull(datain.get("Moo"))+"");
            MotherFullName.setText(Checknull(datain.get("MotherFullName"))+"");
            Nationality.setText(Checknull(datain.get("Nationality"))+"");
            Occupation.setText(Checknull(datain.get("Occupation"))+"");
            PassportNumber.setText(Checknull(datain.get("PassportNumber"))+"");
            Province.setText(Checknull(datain.get("Province"))+"");
            Race.setText(Checknull(datain.get("Race"))+"");
            Religion.setText(Checknull(datain.get("Religion"))+"");
            Tambon.setText(Checknull(datain.get("Tambon"))+"");
             PhonePerson.setText(Checknull(datain.get("PhonePerson"))+"");  
             Gender.setSelectedItem(Checknull(datain.get("Gender")));
            OrderPerson.setText(Checknull(datain.get("OrderPerson"))+"");             
             ZipCode.setText(Checknull(datain.get("ZipCode"))+"");
            OtherName.setText(Checknull(datain.get("OtherName"))+"");
           OccupationPosition.setText(Checknull(datain.get("OccupationPosition"))+"");
            AnswerPerson.setText(Checknull(datain.get("AnswerPerson"))+"");
            RelatedAccused.setSelectedItem(Checknull(datain.get("Related"))+"");
           
            String statusInjure=datain.get("StatusInjuryOrDie")+"";
            if(statusInjure.equals("บาดเจ็บ")){
            jCheckInjured.setSelected(true);
            }
           else if(statusInjure.equals("ตาย")){
            jCheckDead.setSelected(true);
            }
            try{
            String ote=datain.get("TimeSendInjuredOrDie")+"";
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date timeSend = timeFormat.parse(ote);
                TimeSendInjuredOrDie.setValue(timeSend);
            }
            catch(Exception ex){
            
            }
           
           DateSendInjuredOrDie.getJFormattedTextField().setText(datain.get("DateSendInjuredOrDie")+"");   
           CauseSendInjuredOrDie.setText(datain.get("CauseSendInjuredOrDie")+"");
           WhereSendInjuredOrDie.setText(datain.get("WhereSendInjuredOrDie")+"");


      
//                    data.put("Gender", rs.getString("Gender"));


        }else{
//              SimpleDateFormat timeFormat = new SimpleDateFormat("dd/MM/yyyy");
//            Date datedd=new Date();
//            String dateInjury=timeFormat.format(datedd);
//           DateSendInjuredOrDie.setText(dateInjury);      
           crimecaseno.setText(datacase.get("CaseId")+"");
            isInsert=true;
          
        }
          FullNamePerson.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                         SetTextPerson();
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                          SetTextPerson();

                           }
             }
             );
        try {
              Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select FullNamePerson,PeopleRegistrationID from persondata ";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
             String name = res.getString("FullNamePerson");        
             personname.add(name);
//                System.out.println("Array : "+personname);  
        } 
       res.close();
        } catch (Exception e) {
        }
        BirthDay.getJFormattedTextField().getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                Age.setText(CalculateData.calculateAge(BirthDay.getJFormattedTextField().getText()));
                           }
                           public void removeUpdate(DocumentEvent e) {
//                                SueThirdTotal.setText(CalculateDateTotal(ThirdDate.getText(), SueThirdEnd.getText()));


                           }
                           public void insertUpdate(DocumentEvent e) {
                              Age.setText(CalculateData.calculateAge(BirthDay.getJFormattedTextField().getText()));

                           }
             }
             );
            Tambon.getDocument().addDocumentListener(new DocumentListener() {
             public void changedUpdate(DocumentEvent e) {
                  zp();
             }
             public void removeUpdate(DocumentEvent e) {

             }
             public void insertUpdate(DocumentEvent e) {
                  zp();
             }
                    public void zp() {
                        String provinceid="";
                           String loTam="",amp="",zp="",loAmphur="",pro="";
                          Connection con2 = ConnectDatabase.connect();
                          try {
                              Statement st2 = con2.createStatement();
                              String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
                              "where Tambon.NAMETAMBON='"+Tambon.getText()+"'";
                              ResultSet res2 = st2.executeQuery(a);
                              System.out.println("provinceid: "+a);
                          if(res2.next()){
                              zp=res2.getString("ZIPCODE");
                          provinceid=res2.getString("DOPA_CODE");
                         loTam= provinceid.substring(0, 4);
                            ZipCode.setText(zp);
                          }
                          }
                          catch(Exception ex){

                          }
                    }
                 });   
       JTextPopupMenu.addTo(OrderPerson);
       JTextPopupMenu.addTo(PeopleRegistrationID);
       JTextPopupMenu.addTo(ExpiredDate.getJFormattedTextField());
       JTextPopupMenu.addTo(IssueDate.getJFormattedTextField());
       JTextPopupMenu.addTo(PassportNumber);
       JTextPopupMenu.addTo(FullNamePerson);
       JTextPopupMenu.addTo(OtherName);
       JTextPopupMenu.addTo(FullNamePersonEn);
       JTextPopupMenu.addTo(BirthDay.getJFormattedTextField());
       JTextPopupMenu.addTo(Age);
       JTextPopupMenu.addTo(Religion);
       JTextPopupMenu.addTo(Nationality);
       JTextPopupMenu.addTo(Race);
       JTextPopupMenu.addTo(Height);
       JTextPopupMenu.addTo(Weight);
       JTextPopupMenu.addTo(Occupation);
       JTextPopupMenu.addTo(OccupationPosition);
       JTextPopupMenu.addTo(FatherFullName);
       JTextPopupMenu.addTo(MotherFullName);
       JTextPopupMenu.addTo(PhonePerson);
       JTextPopupMenu.addTo(HouseNumber);
       JTextPopupMenu.addTo(Moo);
       JTextPopupMenu.addTo(Tambon);
       JTextPopupMenu.addTo(Amphur);
       JTextPopupMenu.addTo(Province);
       JTextPopupMenu.addTo(ZipCode);

       
    }

    AccusedForm(ListAccused aThis, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtSaveAccused = new javax.swing.JButton();
        FullNamePerson = new javax.swing.JTextField();
        OtherName = new javax.swing.JTextField();
        FullNamePersonEn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Nationality = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Race = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        Occupation = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Religion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Weight = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        HouseNumber = new javax.swing.JTextField();
        FatherFullName = new javax.swing.JTextField();
        MotherFullName = new javax.swing.JTextField();
        PhonePerson = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        Moo = new javax.swing.JTextField();
        Tambon = new javax.swing.JTextField();
        Amphur = new javax.swing.JTextField();
        ZipCode = new javax.swing.JTextField();
        Province = new javax.swing.JTextField();
        jPanelBirthDay = new javax.swing.JPanel();
        jPanelIssueDate = new javax.swing.JPanel();
        jPanelExpiredDate = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        OrderPerson = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        RelatedAccused = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        OccupationPosition = new javax.swing.JTextField();
        BloodGroup = new javax.swing.JComboBox<>();
        AnswerPerson = new javax.swing.JTextField();
        jCheckInjured = new javax.swing.JCheckBox();
        jCheckDead = new javax.swing.JCheckBox();
        jButtonInjuryOrDie = new javax.swing.JButton();
        CauseSendInjuredOrDie = new javax.swing.JTextField();
        WhereSendInjuredOrDie = new javax.swing.JTextField();
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        TimeSendInjuredOrDie = new javax.swing.JSpinner(sm3);
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PeopleRegistrationID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PassportNumber = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ข้อมูลผู้กล่าวหา");

        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        crimecaseno.setText("เลขคดี");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crimecaseno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(crimecaseno))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("วันที่ออกบัตร");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วันที่บัตรหมดอายุ");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ชื่อ-สกุล");

        BtSaveAccused.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        BtSaveAccused.setText("บันทึก");
        BtSaveAccused.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSaveAccusedActionPerformed(evt);
            }
        });

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        FullNamePersonEn.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel8.setText("อายุ");

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("วันเกิด");

        Age.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AgeKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ชื่อภาษาอังกฤษ");

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Nationality.setText("ไทย");

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel12.setText("สัญชาติ");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setText("เชื้อชาติ");

        Race.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Race.setText("ไทย");
        Race.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RaceActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel14.setText("อาชีพ");

        Gender.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ชาย", "หญิง", "ไม่ระบุ" }));
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        //Occupation = new HintTextField("หากเป็นตำรวจ รับราชการตำรวจ");
        Occupation.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel15.setText("เพศ");

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel16.setText("สูง");

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Religion.setText("พุทธ");

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel17.setText("น้ำหนัก");

        Height.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel18.setText("ศาสนา");

        Weight.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("ชื่อสกุลอื่น");

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("หมู่โลหิต");

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel25.setText("หมายเลขโทรศัพท์");

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel26.setText("ชื่อบิดา");

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel29.setText("ชื่อมารดา");

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("บ้านเลขที่");

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel22.setText("แขวง/ตำบล");

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel23.setText("เขต/อำเภอ");

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel24.setText("รหัสไปรษณีย์");

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel27.setText("จังหวัด");

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel30.setText("หมู่ที่");

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Tambon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambonActionPerformed(evt);
            }
        });
        Tambon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TambonKeyReleased(evt);
            }
        });

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Amphur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AmphurKeyReleased(evt);
            }
        });

        ZipCode.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ZipCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipCodeActionPerformed(evt);
            }
        });
        ZipCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ZipCodeKeyTyped(evt);
            }
        });

        Province.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Province.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProvinceActionPerformed(evt);
            }
        });

        jPanelBirthDay.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBirthDay.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelBirthDayLayout = new javax.swing.GroupLayout(jPanelBirthDay);
        jPanelBirthDay.setLayout(jPanelBirthDayLayout);
        jPanelBirthDayLayout.setHorizontalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
        );
        jPanelBirthDayLayout.setVerticalGroup(
            jPanelBirthDayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelIssueDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelIssueDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelIssueDateLayout = new javax.swing.GroupLayout(jPanelIssueDate);
        jPanelIssueDate.setLayout(jPanelIssueDateLayout);
        jPanelIssueDateLayout.setHorizontalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        jPanelIssueDateLayout.setVerticalGroup(
            jPanelIssueDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanelExpiredDate.setBackground(new java.awt.Color(255, 255, 255));
        jPanelExpiredDate.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelExpiredDateLayout = new javax.swing.GroupLayout(jPanelExpiredDate);
        jPanelExpiredDate.setLayout(jPanelExpiredDateLayout);
        jPanelExpiredDateLayout.setHorizontalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
        jPanelExpiredDateLayout.setVerticalGroup(
            jPanelExpiredDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22));
        jLabel19.setText("คนที่");

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 0, 18)); // NOI18N
        jLabel28.setText("ผู้กล่าวหา");

        OrderPerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("เกี่ยวข้องเป็น");

        RelatedAccused.setEditable(true);
        RelatedAccused.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setText("ที่ทำงาน ตำแหน่ง หน้าที่");

        OccupationPosition.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        OccupationPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OccupationPositionActionPerformed(evt);
            }
        });

        BloodGroup.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        BloodGroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "A", "B", "AB", "O", "A Rh-", "B Rh-", "AB Rh-", "O Rh-" }));

        AnswerPerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jCheckInjured.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckInjured.setText("บาดเจ็บ");
        jCheckInjured.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckInjuredItemStateChanged(evt);
            }
        });
        jCheckInjured.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckInjuredActionPerformed(evt);
            }
        });

        jCheckDead.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckDead.setText("ตาย");
        jCheckDead.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckDeadItemStateChanged(evt);
            }
        });

        jButtonInjuryOrDie.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonInjuryOrDie.setText("รายละเอียด");
        jButtonInjuryOrDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInjuryOrDieActionPerformed(evt);
            }
        });

        CauseSendInjuredOrDie.setText(" ");

        WhereSendInjuredOrDie.setText(" ");

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(TimeSendInjuredOrDie, "HH:mm");
        TimeSendInjuredOrDie.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        TimeSendInjuredOrDie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimeSendInjuredOrDieKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("เลขบัตรประชาชน");

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        PeopleRegistrationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PeopleRegistrationIDKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("เลขหนังสือเดินทาง");

        PassportNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("คำให้การ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton2.setText("อ่านข้อมูลจากบัตร");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel19)
                                .addGap(20, 20, 20)
                                .addComponent(OrderPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jCheckInjured)
                                .addGap(7, 7, 7)
                                .addComponent(jCheckDead)
                                .addGap(11, 11, 11)
                                .addComponent(jButtonInjuryOrDie)
                                .addGap(9, 9, 9)
                                .addComponent(WhereSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(86, 86, 86)
                        .addComponent(CauseSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(TimeSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(60, 60, 60)
                                .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(10, 10, 10)
                                .addComponent(OccupationPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(78, 78, 78)
                                .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(MotherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel25)
                                .addGap(5, 5, 5)
                                .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel30)
                                .addGap(3, 3, 3)
                                .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel22)
                                .addGap(9, 9, 9)
                                .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel23)
                                .addGap(3, 3, 3)
                                .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel27)
                                .addGap(9, 9, 9)
                                .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(RelatedAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(AnswerPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BtSaveAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanelBirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(8, 8, 8)
                                        .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Religion)))))))
                .addGap(124, 124, 124))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrderPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckInjured, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckDead, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonInjuryOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WhereSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CauseSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TimeSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PassportNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelExpiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FullNamePersonEn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelBirthDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Height, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Weight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BloodGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Gender, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OccupationPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MotherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RelatedAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnswerPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(BtSaveAccused, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        PhonePerson.getAccessibleContext().setAccessibleName("");

        jScrollPane1.setViewportView(jPanel2);
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PeopleRegistrationIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PeopleRegistrationIDKeyTyped
           char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }
         if(PeopleRegistrationID.getText().length()>=13) {  
           evt.consume();
 }     // TODO add your handling code here:
    }//GEN-LAST:event_PeopleRegistrationIDKeyTyped

    private void AgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AgeKeyTyped
           char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }  // TODO add your handling code here:
    }//GEN-LAST:event_AgeKeyTyped

    private void ZipCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ZipCodeKeyTyped
     char vChar = evt.getKeyChar();
         if(!(Character.isDigit(vChar) || (vChar==KeyEvent.VK_BACK_SPACE)||(vChar==KeyEvent.VK_DELETE)))
         {
             evt.consume();
         }     
     
                  if(ZipCode.getText().length()>=5) {  
           evt.consume();
 }  // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeKeyTyped

    private void ZipCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipCodeActionPerformed

    private void BtSaveAccusedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSaveAccusedActionPerformed
 con=ConnectDatabase.connect();   
             SimpleDateFormat format = new SimpleDateFormat("HH:mm");
              String sendTime=format.format(TimeSendInjuredOrDie.getValue());
        if(isInsert){    
//         
        String sql="INSERT INTO Person (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                        "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                        "PhonePerson,Province,Race,Religion,Tambon,TypePerson,Weight,ZipCode,caseIdPerson,OrderPerson,Related,AnswerPerson,OccupationPosition,"
                      + "CauseSendInjuredOrDie,WhereSendInjuredOrDie,DateSendInjuredOrDie,TimeSendInjuredOrDie,StatusInjuryOrDie)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         

//        String sqlinsert = "INSERT INTO PersonData (FullNamePerson,Race) VALUES (?,?)";
         System.out.println("SQL : "+sql);
      try {
            pst=con.prepareStatement(sql);
                              pst.setString(1,Age.getText());
                              pst.setString(2,Amphur.getText());
                              pst.setString(3,BirthDay.getJFormattedTextField().getText());
                              pst.setString(4,BloodGroup.getSelectedItem().toString());
                              pst.setString(5,ExpiredDate.getJFormattedTextField().getText());
                              pst.setString(6,FatherFullName.getText());
                              pst.setString(7,FullNamePerson.getText());
                              pst.setString(8,FullNamePersonEn.getText());
                              pst.setString(9,Gender.getSelectedItem().toString());
                              pst.setString(10,Height.getText());
                              pst.setString(11,HouseNumber.getText());
                              pst.setString(12,IssueDate.getJFormattedTextField().getText());
                              pst.setString(13,Moo.getText());
                              pst.setString(14,MotherFullName.getText());
                              pst.setString(15,Nationality.getText());
                              pst.setString(16,Occupation.getText());
                              pst.setString(17,OtherName.getText());
                              pst.setString(18,PassportNumber.getText());
                              pst.setString(19,PeopleRegistrationID.getText());
                              pst.setString(20,PhonePerson.getText());
                              pst.setString(21,Province.getText());
                              pst.setString(22,Race.getText());
                              pst.setString(23,Religion.getText());
                              pst.setString(24,Tambon.getText());
                              pst.setString(25,"ผู้กล่าวหา");
                              pst.setString(26,Weight.getText());
                              pst.setString(27,ZipCode.getText());
                              pst.setString(28,crimecaseno.getText());
                              pst.setString(29,OrderPerson.getText());
                               pst.setString(30,RelatedAccused.getSelectedItem()+"");
                               pst.setString(31,AnswerPerson.getText());
                              pst.setString(32,OccupationPosition.getText());
                              pst.setString(33,CauseSendInjuredOrDie.getText());
                              pst.setString(34,WhereSendInjuredOrDie.getText());
                              pst.setString(35,DateSendInjuredOrDie.getJFormattedTextField().getText());
                              pst.setString(36,sendTime);
                              if(jCheckInjured.isSelected()){
                               pst.setString(37,jCheckInjured.getText());
                              }
                              else if(jCheckDead.isSelected()){
                              pst.setString(37,jCheckDead.getText());
                              }
                              
                                      
//                              --------------Insert Person---------------------------------
                      
                               
//                               JOptionPane.showMessageDialog(jPanel1,"ยืนยัน","บันทึกข้อมูล", JOptionPane.INFORMATION_MESSAGE);
                            
     int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
      InsertPerson();
         System.out.println("SQL : "+sql);
        setVisible(false); 

     } 
        } catch (Exception e) {
             JOptionPane.showMessageDialog(jPanel1,"sdfsdfsdf",null, JOptionPane.INFORMATION_MESSAGE);

             System.out.println("SQL : "+e);
        }
        }
        else{
             String sqlUpdate="Update Person set Age=?,Amphur=?,BirthDay=?,\n" +
                                    "BloodGroup=?,ExpiredDate=?,FatherFullName=?,FullNamePerson=?,FullNamePersonEn=?,\n" +
                                    "Gender=?,Height=?,HouseNumber=?,IssueDate=?,Moo=?,MotherFullName=?,Nationality=?,Occupation=?,\n" +
                                    "OtherName=?,PassportNumber=?,PeopleRegistrationID=?,PhonePerson=?,Province=?,Race=?,Religion=?,\n" +
                                    "Tambon=?,TypePerson=?,Weight=?,ZipCode=? ,caseIdPerson=?,OrderPerson=?,Related=?,OccupationPosition=?,"
                                    + "AnswerPerson=?,CauseSendInjuredOrDie=?,WhereSendInjuredOrDie=?,DateSendInjuredOrDie=?,TimeSendInjuredOrDie=?,StatusInjuryOrDie=? \n"
                                   + "where NoPerson=? and TypePerson=?";
       
         try {
            pst=con.prepareStatement(sqlUpdate);
                              pst.setString(1,Age.getText());
                              pst.setString(2,Amphur.getText());
                              pst.setString(3,BirthDay.getJFormattedTextField().getText());
                              pst.setString(4,BloodGroup.getSelectedItem().toString());
                              pst.setString(5,ExpiredDate.getJFormattedTextField().getText());
                              pst.setString(6,FatherFullName.getText());
                              pst.setString(7,FullNamePerson.getText());
                              pst.setString(8,FullNamePersonEn.getText());
                              pst.setString(9,Gender.getSelectedItem().toString());
                              pst.setString(10,Height.getText());
                              pst.setString(11,HouseNumber.getText());
                              pst.setString(12,IssueDate.getJFormattedTextField().getText());
                              pst.setString(13,Moo.getText());
                              pst.setString(14,MotherFullName.getText());
                              pst.setString(15,Nationality.getText());
                              pst.setString(16,Occupation.getText());
                              pst.setString(17,OtherName.getText());
                              pst.setString(18,PassportNumber.getText());
                              pst.setString(19,PeopleRegistrationID.getText());
                              pst.setString(20,PhonePerson.getText());
                              pst.setString(21,Province.getText());
                              pst.setString(22,Race.getText());
                              pst.setString(23,Religion.getText());
                              pst.setString(24,Tambon.getText());
                              pst.setString(25,"ผู้กล่าวหา");
                              pst.setString(26,Weight.getText());
                              pst.setString(27,ZipCode.getText());
                              pst.setString(28,crimecaseno.getText());
                              pst.setString(29,OrderPerson.getText());
                               pst.setString(30,RelatedAccused.getSelectedItem()+"");
                              pst.setString(31,OccupationPosition.getText());
                              pst.setString(32,AnswerPerson.getText());
                              pst.setString(33,CauseSendInjuredOrDie.getText());
                              pst.setString(34,WhereSendInjuredOrDie.getText());
                              pst.setString(35,DateSendInjuredOrDie.getJFormattedTextField().getText());
                              pst.setString(36,sendTime);
                              if(jCheckInjured.isSelected()){
                               pst.setString(37,jCheckInjured.getText());
                              }
                              else if(jCheckDead.isSelected()){
                              pst.setString(37,jCheckDead.getText());
                              }
                              
                            
                              pst.setString(38,noPerson);
                              pst.setString(39,"ผู้กล่าวหา");
                         int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                             pst.executeUpdate(); 
                             pst.close();
                             System.out.println("SQL : "+sqlUpdate);
                            setVisible(false); 

                                } 
        } catch (Exception e) {
                               JOptionPane.showMessageDialog(jPanel1,  "Cannot Save", null,JOptionPane.INFORMATION_MESSAGE);

             System.out.println("SQL : "+pst);
        }
        
        
        
        }
          
                            

               // TODO add your handling code here:
    }//GEN-LAST:event_BtSaveAccusedActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void RaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RaceActionPerformed

    private void OccupationPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OccupationPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OccupationPositionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JSONObject type=new JSONObject();
        type.put("TypeCase", typeCase);
        type.put("TypePerson", "ผู้กล่าวหา");
         JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        frame.removeAll();
    AnswerPersonForm rf =new AnswerPersonForm(in,type);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProvinceActionPerformed

    private void jButtonInjuryOrDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInjuryOrDieActionPerformed
        // TODO add your handling code here:
        JSONObject type=new JSONObject();
        type.put("TypeCase", typeCase);
        type.put("TypePerson", "ผู้กล่าวหา");
         JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
            InjuryOrDie rf =new InjuryOrDie(in,type);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_jButtonInjuryOrDieActionPerformed

    private void jCheckInjuredItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckInjuredItemStateChanged
        // TODO add your handling code here:
               
        if(jCheckInjured.isSelected()){
            jButtonInjuryOrDie.setVisible(true);

        }
        else{
        jButtonInjuryOrDie.setVisible(false);


        }
    }//GEN-LAST:event_jCheckInjuredItemStateChanged

    private void jCheckInjuredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckInjuredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckInjuredActionPerformed

    private void jCheckDeadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckDeadItemStateChanged
        // TODO add your handling code here:
         if(jCheckDead.isSelected()){
            jButtonInjuryOrDie.setVisible(true);

        }
        else{
        jButtonInjuryOrDie.setVisible(false);


        }
          
    }//GEN-LAST:event_jCheckDeadItemStateChanged

    private void TimeSendInjuredOrDieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimeSendInjuredOrDieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeSendInjuredOrDieKeyReleased

    private void TambonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TambonKeyReleased
        // TODO add your handling code here:
          String provinceid="";
         String loTam="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {
            Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.NAMETAMBON='"+Tambon.getText()+"'";
            ResultSet res2 = st2.executeQuery(a);
//            System.out.println("provinceid: "+CrimeLocationProvince.getSelectedItem());
        if(res2.next()){
            zp=res2.getString("ZIPCODE");
        provinceid=res2.getString("DOPA_CODE");
       loTam= provinceid.substring(0, 4);
          ZipCode.setText(zp);
        }
	Statement st = con2.createStatement();
        String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
                            "from Amphur\n" +
                            "where Amphur.DOPA_CODE like '"+loTam+"%';";
                    System.out.println("sddddddddd:"+c);

        ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
//	           System.out.println("provinceid: "+provinceid);
	if(res.next())
	{
         
	 amp=res.getString("NameAmphur");
        String ffa=res.getString("DOPA_CODE");
        loAmphur=ffa.substring(0, 2);
         Amphur.setText(amp);
	
	}  
        Statement st3 = con2.createStatement();
        String c3 = "select nameprovince\n" +
                            "from province\n" +
                            "where provinceid = '"+loAmphur+"';";
            System.out.println("sddddddddd:"+c3);
        ResultSet res3 = st3.executeQuery(c3);
        if(res3.next())
	{
         
	 pro=res3.getString("nameprovince");
      Province.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
}
      
        
    }//GEN-LAST:event_TambonKeyReleased

    private void TambonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TambonActionPerformed

    private void AmphurKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AmphurKeyReleased
        // TODO add your handling code here:
            String provinceid="";
         String loPro="",amp="",zp="",loAmphur="",pro="";
        Connection con2 = ConnectDatabase.connect();
        try {

	Statement st = con2.createStatement();
        String c = "select Amphur.DOPA_CODE DOPA_CODE,NameAmphur\n" +
                            "from Amphur\n" +
                            "where Amphur.NameAmphur = '"+Amphur.getText()+"';";
                    System.out.println("sddddddddd:"+c);

        ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
//	           System.out.println("provinceid: "+provinceid);
	if(res.next())
	{
         
        String ffa=res.getString("DOPA_CODE");
        loAmphur=ffa.substring(0, 4);
        loPro=ffa.substring(0, 2);
	
	}  
        
         Statement st2 = con2.createStatement();
            String a="select Tambon.DOPA_CODE DOPA_CODE,Tambon.ZIPCODE ZIPCODE from Tambon\n"+
            "where Tambon.DOPA_CODE like '"+loAmphur+"%'";
            ResultSet res2 = st2.executeQuery(a);
        Statement st3 = con2.createStatement();
          if(res2.next()){
            zp=res2.getString("ZIPCODE");
          ZipCode.setText(zp);
        }
        String c3 = "select nameprovince\n" +
                            "from province\n" +
                            "where provinceid = '"+loPro+"';";
            System.out.println("sddddddddd:"+c3);
        ResultSet res3 = st3.executeQuery(c3);
        if(res3.next())
	{
         
	 pro=res3.getString("nameprovince");
      Province.setText(pro);
	
	}  
      
        
      
        }
        catch (Exception d) {  //System.out.println(d);  
}
      
    }//GEN-LAST:event_AmphurKeyReleased

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {

            if(true) {
                ReadThaiCardService read = new ReadThaiCardService();
                read.check_read();
                read.read(0);
                int st=read.getDataThaiCard().getStatus();
                if(st==1){
                    JOptionPane.showMessageDialog(null, "กรุณาเสียบบัตร");
                }
                else if(st==2){
                    JOptionPane.showMessageDialog(null, "กรุณาเสียบบัตร");
                }
                else if(st==4){
                    String str=read.getDataThaiCard().getThaiCardDetail().getThname();
                    String[] name=str.split("##",2);
                    String firstname=(name[0]+"").replace("#", "");
                    String n=firstname+" "+name[1];
                    String stren=read.getDataThaiCard().getThaiCardDetail().getEnname(); 
                                String[] nameen=stren.split("##",2);
                                String firstnameen=(nameen[0]+"").replace("#", "");
                                String nen=firstnameen+" "+nameen[1];
                    //                                String name2=name.replace("##", " ");
                    PeopleRegistrationID.setText(read.getDataThaiCard().getThaiCardDetail().getPid());
                    FullNamePerson.setText(n);
                    FullNamePersonEn.setText(nen);

                    IssueDate.getJFormattedTextField().setText(DateCard(read.getDataThaiCard().getThaiCardDetail().getIssuedate()));
                    ExpiredDate.getJFormattedTextField().setText(DateCard(read.getDataThaiCard().getThaiCardDetail().getExpiredate()));
                    BirthDay.getJFormattedTextField().setText(DateCard(read.getDataThaiCard().getThaiCardDetail().getBirthdate()));
                    HouseNumber.setText(read.getDataThaiCard().getThaiCardDetail().getAddrHS());
                    Moo.setText(read.getDataThaiCard().getThaiCardDetail().getAddrMoo().replace("หมู่ที่ ", ""));

                    //                                Road.setText(read.getDataThaiCard().getThaiCardDetail().getAdd);
//                    Soi.setText(read.getDataThaiCard().getThaiCardDetail().getAddrSoi());
                    Tambon.setText(read.getDataThaiCard().getThaiCardDetail().getAddrTmb().replace("ตำบล",""));
                    Amphur.setText(read.getDataThaiCard().getThaiCardDetail().getAddrAmp().replace("อำเภอ",""));
                    Province.setText(read.getDataThaiCard().getThaiCardDetail().getAddrPrv().replace("จังหวัด",""));
                    Gender.setSelectedItem(ChangeGender(read.getDataThaiCard().getThaiCardDetail().getGender()));
                    System.out.println(read.getDataThaiCard().getStatusMsg());
                    System.out.println(ChangeGender(read.getDataThaiCard().getThaiCardDetail().getGender()));
                    System.out.println(read.getDataThaiCard().getThaiCardDetail().getAddrTrk());
                    System.out.println(read.getDataThaiCard().getThaiCardDetail().getEnname());

                    System.out.println(read.getDataThaiCard().getThaiCardDetail().getAddrStr());

                    System.out.println(read.getDataThaiCard().getThaiCardDetail().getThname().toString()+"hhh");
                }

                //				Thread.sleep(5000);
            }
            //                        else{
                //                            System.out.println("ErrorCard:");
                //                        }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccusedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        DataCase dcc=new DataCase();
//        labelCaseNo.setText("dfv");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//             AccusedForm aa=  new AccusedForm();
//                    aa.setVisible(true);
//                    aa.setSize ( 1024, 728 );
//                    aa.setMinimumSize ( new Dimension ( 1024, 728 ) );
//                    aa.setMaximizedBounds ( new Rectangle ( 1024, 728 ) );

                    
            }
        });
    }
    
  public static String IdCase(){
         Connection c=null;
         c=ConnectDatabase.connect();
            String sqlId="Select max(CaseId) caseid from CrimeCase";
        int id=0;
        try {
            Statement s=c.createStatement();
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
  private class TextFieldCaretListener implements  CaretListener{
   public void caretUpdate(CaretEvent e){
    
       try{
        comboBox.removeAllItems();
        comboBox.hidePopup();
        jPanel2.remove(comboBox);
        
        if(e.getMark()>0){
            
        for(String string:personname){
           if(string.toLowerCase().startsWith(FullNamePerson.getText().toLowerCase())){
             jPanel2.add(comboBox);
             comboBox.addItem(string);
             comboBox.showPopup();
               }
	    }
         } 
        Connection c=null;
         c=ConnectDatabase.connect();
            String sqlId="Select * from PersonData where FullNamePerson='"+FullNamePerson.getText()+"'";

            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                PeopleRegistrationID.setText(rs.getString("PeopleRegistrationID")); 
                Age.setText(rs.getString("Age")); 
                Amphur.setText(rs.getString("Amphur")); 
                BloodGroup.setSelectedItem(rs.getString("BloodGroup")); 
                BirthDay.getJFormattedTextField().setText(rs.getString("BirthDay")); 
                FatherFullName.setText(rs.getString("FatherFullName")); 
                FullNamePersonEn.setText(rs.getString("FullNamePersonEn")); 
                Height.setText(rs.getString("Height")); 
                Weight.setText(rs.getString("Weight")); 
                Race.setText(rs.getString("Race")); 
                Religion.setText(rs.getString("Religion")); 
                Nationality.setText(rs.getString("Nationality")); 
                MotherFullName.setText(rs.getString("MotherFullName")); 
                Gender.setSelectedItem(rs.getString("Gender"));
                Occupation.setText(rs.getString("Occupation"));
                PhonePerson.setText(rs.getString("PhonePerson")); 
                MotherFullName.setText(rs.getString("MotherFullName")); 
                PassportNumber.setText(rs.getString("PassportNumber")); 

   
            }
        
        
  
       }
       catch(Exception e1){
       }
       if(e.getMark()<2){
       jPanel2.remove(comboBox);
       }
   }
  }

  private class ComboBoxActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        try{
            FullNamePerson.setText(comboBox.getSelectedItem().toString());
            comboBox.removeAllItems();
            comboBox.hidePopup();
            jPanel2.remove(comboBox);
             
        }
        catch(Exception any){
        
        }
        }
  
  }
  private void Dataperson(){
  
  try {

         Connection con2 = ConnectDatabase.connect();
	Statement st = con2.createStatement();
        	String c = "Select FullNamePerson from persondata";
        	ResultSet res = st.executeQuery(c);
	//Vector<Object> v=new Vector<Object>();
	
	while(res.next())
	{
             String name = res.getString("FullNamePerson");
             personname.add(name);

	
	}
        res.close();
  }
catch (Exception d) {  //System.out.println(d);  
}
  }
  public void InsertPerson(){
       con=ConnectDatabase.connect();
      try {
              Statement st = con.createStatement();
           String sel="Select FullNamePerson,PeopleRegistrationID from persondata where FullNamePerson='"+FullNamePerson.getText()+"' and PeopleRegistrationID='"+PeopleRegistrationID.getText()+"'";
           ResultSet rc = st.executeQuery(sel);
        if(rc.next()){
        
        isPerson=false;
        }
        else{
         isPerson=true;
        }
        if(isPerson){    
        String sql2="INSERT INTO PersonData (Age,Amphur,BirthDay,BloodGroup,ExpiredDate,FatherFullName,FullNamePerson,FullNamePersonEn,Gender,\n" +
                        "Height,HouseNumber,IssueDate,Moo,MotherFullName,Nationality,Occupation,OtherName,PassportNumber,PeopleRegistrationID,\n" +
                        "PhonePerson,Province,Race,Religion,Tambon,Weight,ZipCode,OccupationPosition)\n"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
         System.out.println("SQL : "+sql2);
      try {
            pst2=con.prepareStatement(sql2);
                              pst2.setString(1,Age.getText());
                              pst2.setString(2,Amphur.getText());
                              pst2.setString(3,BirthDay.getJFormattedTextField().getText());
                              pst2.setString(4,BloodGroup.getSelectedItem().toString());
                              pst2.setString(5,ExpiredDate.getJFormattedTextField().getText());
                              pst2.setString(6,FatherFullName.getText());
                              pst2.setString(7,FullNamePerson.getText());
                              pst2.setString(8,FullNamePersonEn.getText());
                              pst2.setString(9,Gender.getSelectedItem().toString());
                              pst2.setString(10,Height.getText());
                              pst2.setString(11,HouseNumber.getText());
                              pst2.setString(12,IssueDate.getJFormattedTextField().getText());
                              pst2.setString(13,Moo.getText());
                              pst2.setString(14,MotherFullName.getText());
                              pst2.setString(15,Nationality.getText());
                              pst2.setString(16,Occupation.getText());
                              pst2.setString(17,OtherName.getText());
                              pst2.setString(18,PassportNumber.getText());
                              pst2.setString(19,PeopleRegistrationID.getText());
                              pst2.setString(20,PhonePerson.getText());
                              pst2.setString(21,Province.getText());
                              pst2.setString(22,Race.getText());
                              pst2.setString(23,Religion.getText());
                              pst2.setString(24,Tambon.getText());                         
                              pst2.setString(25,Weight.getText());
                              pst2.setString(26,ZipCode.getText());
                                pst2.setString(27,OccupationPosition.getText());
                                pst2.executeUpdate(); 
                                pst2.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);

//             System.out.println("SQL : "+pst2);
        }
        }
      } catch (Exception e) {
      }
  
  }
    private void SetTextPerson(){
      try{
        Connection c=null;
         c=ConnectDatabase.connect();
            String sqlId="Select * from PersonData where FullNamePerson='"+FullNamePerson.getText()+"'";

            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                PeopleRegistrationID.setText(Checknull(rs.getString("PeopleRegistrationID"))); 
                IssueDate.getJFormattedTextField().setText(Checknull(rs.getString("PassportNumber")));                 
                Age.setText(Checknull(rs.getString("Age"))); 
                Amphur.setText(Checknull(rs.getString("Amphur"))); 
                BloodGroup.setSelectedItem(rs.getString("BloodGroup")); 
                BirthDay.getJFormattedTextField().setText(Checknull(rs.getString("BirthDay"))); 
                FatherFullName.setText(Checknull(rs.getString("FatherFullName"))); 
                FullNamePersonEn.setText(Checknull(rs.getString("FullNamePersonEn"))); 
                OccupationPosition.setText(Checknull(rs.getString("OccupationPosition"))); 
                Height.setText(Checknull(rs.getString("Height"))); 
                Weight.setText(Checknull(rs.getString("Weight"))); 
                Race.setText(Checknull(rs.getString("Race"))); 
                Religion.setText(Checknull(rs.getString("Religion"))); 
                Nationality.setText(Checknull(rs.getString("Nationality"))); 
                MotherFullName.setText(Checknull(rs.getString("MotherFullName"))); 
                Gender.setSelectedItem(rs.getString("Gender"));
                Occupation.setText(Checknull(rs.getString("Occupation")));
                PhonePerson.setText(Checknull(rs.getString("PhonePerson"))); 
                MotherFullName.setText(Checknull(rs.getString("MotherFullName"))); 
                PassportNumber.setText(Checknull(rs.getString("PassportNumber"))); 
               ExpiredDate.getJFormattedTextField().setText(Checknull(rs.getString("ExpiredDate"))+"");
            HouseNumber.setText(Checknull(rs.getString("HouseNumber")));
            Moo.setText(Checknull(rs.getString("Moo")));
            Province.setText(Checknull(rs.getString("Province")));
            Tambon.setText(Checknull(rs.getString("Tambon")));
             ZipCode.setText(Checknull(rs.getString("ZipCode")));
            OtherName.setText(Checknull(rs.getString("OtherName")));

//
//   
            }
       }catch(Exception ex){}
    
    
    }
    class HintTextField extends JTextField implements FocusListener {

  private final String hint;
  private boolean showingHint;

  public HintTextField(final String hint) {
    super(hint);
    this.hint = hint;
    this.showingHint = true;
    super.addFocusListener(this);
  }

  @Override
  public void focusGained(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText("");
      showingHint = false;
    }
  }
  @Override
  public void focusLost(FocusEvent e) {
    if(this.getText().isEmpty()) {
      super.setText(hint);
      showingHint = true;
    }
  }

  @Override
  public String getText() {
    return showingHint ? "" : super.getText();
  }
    }
    
  public static String Checknull(Object input){
					if(input==null||input==""||input=="null") { return ""; }
					return input+"";
					}
      public static String DateCard(String dateC) throws Exception{
     
     
      Locale lc = new Locale("th","TH");
         SimpleDateFormat inputFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("d/MM/yyyy");
          if(dateC.equals("")){
              String a="";
        return   a;
        
        }
        else{
        Date date = inputFormat.parse(dateC);
       
        String formattedDate = outputFormat.format(date);
              return   formattedDate;
        }
     }
public static String ChangeGender(String gender) throws Exception{
         
        if(gender.equals("1")){       
        return   "ชาย";
        }
        else{       
              return   "หญิง";
        }
     }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    public static javax.swing.JTextField AnswerPerson;
    private javax.swing.JComboBox<String> BloodGroup;
    private javax.swing.JButton BtSaveAccused;
    public static javax.swing.JTextField CauseSendInjuredOrDie;
    private javax.swing.JTextField FatherFullName;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField FullNamePersonEn;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JTextField Height;
    private javax.swing.JTextField HouseNumber;
    private javax.swing.JTextField Moo;
    private javax.swing.JTextField MotherFullName;
    private javax.swing.JTextField Nationality;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextField OccupationPosition;
    private javax.swing.JTextField OrderPerson;
    private javax.swing.JTextField OtherName;
    private javax.swing.JTextField PassportNumber;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PhonePerson;
    private javax.swing.JTextField Province;
    private javax.swing.JTextField Race;
    private javax.swing.JComboBox<String> RelatedAccused;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField Tambon;
    public static javax.swing.JSpinner TimeSendInjuredOrDie;
    private javax.swing.JTextField Weight;
    public static javax.swing.JTextField WhereSendInjuredOrDie;
    private javax.swing.JTextField ZipCode;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonInjuryOrDie;
    private javax.swing.JCheckBox jCheckDead;
    private javax.swing.JCheckBox jCheckInjured;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelBirthDay;
    private javax.swing.JPanel jPanelExpiredDate;
    private javax.swing.JPanel jPanelIssueDate;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
