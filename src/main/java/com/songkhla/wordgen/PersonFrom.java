/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.CrimesCaseEdit.EvidenceRecordCase;
import static com.songkhla.wordgen.CrimesCaseEdit.ListAsset;
import static com.songkhla.wordgen.CrimesCaseEdit.RecordInvestCase;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelActionCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelNumberAcc;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelNumberSus;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelNumberWitness;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextAccused;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextSuspect;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextWitness;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author Petpilin
 */
public class PersonFrom extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;;
    boolean isInsert;
    /**
     * Creates new form PersonFrom
     */
    public PersonFrom(JFrame parrent,JSONObject datain) {
                super(parrent,true);

        initComponents();
          ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
            NoPerson.setVisible(false);
              try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,28f);
                     jLabel1.setFont(sizedFont);
           
                 Font  labelother = font.deriveFont(1,20f);
                     jLabel10.setFont(labelother);
                     jLabel9.setFont(labelother);
                     jLabel11.setFont(labelother);
                     jLabel12.setFont(labelother);
                     jLabel13.setFont(labelother);
                     jLabel14.setFont(labelother);
                     jLabel15.setFont(labelother);
                     jLabel16.setFont(labelother);
                     jLabel17.setFont(labelother);
                     jLabel18.setFont(labelother);
                     jLabel19.setFont(labelother);
                     jLabel20.setFont(labelother);
                     jLabel21.setFont(labelother);
                     jLabel22.setFont(labelother);
                     jLabel23.setFont(labelother);
                     jLabel24.setFont(labelother);
                     jLabel25.setFont(labelother);
                     jLabel26.setFont(labelother);
                     jLabel27.setFont(labelother);
                     jLabel28.setFont(labelother);
                     jLabel29.setFont(labelother);
                     jLabel30.setFont(labelother);
                     jLabel34.setFont(labelother);
                     jLabel37.setFont(labelother);
                     jLabel36.setFont(labelother);
                     jLabel33.setFont(labelother);
                     jLabel32.setFont(labelother);
                     jLabel31.setFont(labelother);
            Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun.ttf"));
                Font  textboxFont = font2.deriveFont(20f);
                      PeopleRegistrationID.setFont(textboxFont);
                        FullNamePerson.setFont(textboxFont);
                        Race.setFont(textboxFont);
                        Nationality.setFont(textboxFont);
                        Religion.setFont(textboxFont);
                        Occupation.setFont(textboxFont);
                        BirthDay.setFont(textboxFont);
                        Age.setFont(textboxFont);
                        OccupationPosition.setFont(textboxFont);
                        HouseNumber.setFont(textboxFont);
                        Moo.setFont(textboxFont);
                        Tambon.setFont(textboxFont);
                        Amphur.setFont(textboxFont);
                        Province.setFont(textboxFont);
                        PhonePerson.setFont(textboxFont);
                        FatherFullName.setFont(textboxFont);
                        MotherFullName.setFont(textboxFont);
                        CurrentAddress.setFont(textboxFont);
                        OtherName.setFont(textboxFont);
                         SpouseFullName.setFont(textboxFont);
                        Education.setFont(textboxFont);
                        StatusSueAndPutInJail.setFont(textboxFont);
                        FatherAddress.setFont(textboxFont);
                        CarUse.setFont(textboxFont);
                        FavouritePlace.setFont(textboxFont);                        
                        Identification.setFont(textboxFont);
                        WarrantList.setFont(textboxFont);
                        NotePersonData.setFont(textboxFont);
                 Font  buttonFont = font.deriveFont(1,20f);
                 jButtonSave.setFont(buttonFont);

               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
           
//            jButtonSave.setEnabled(false);
        if(datain != null){
            NoPerson.setText(datain.get("NoPerson")+"");
        PeopleRegistrationID.setText(datain.get("PeopleRegistrationID")+"");
        FullNamePerson.setText(datain.get("FullNamePerson")+"");
        Age.setText(datain.get("Age")+"");
        BirthDay.setText(datain.get("BirthDay")+"");
        Race.setText(datain.get("Race")+"");
        Nationality.setText(datain.get("Nationality")+"");
        Religion.setText(datain.get("Religion")+"");
        Occupation.setText(datain.get("Occupation")+"");
        OccupationPosition.setText(Checknull(datain.get("OccupationPosition"))+"");
        HouseNumber.setText(datain.get("HouseNumber")+"");
        Moo.setText(datain.get("Moo")+"");
        Tambon.setText(datain.get("Tambon")+"");
        Amphur.setText(datain.get("Amphur")+"");
        Province.setText(datain.get("Province")+"");
        PhonePerson.setText(Checknull(datain.get("PhonePerson"))+"");
        FatherFullName.setText(Checknull(datain.get("FatherFullName"))+"");
         MotherFullName.setText(Checknull(datain.get("MotherFullName"))+"");
        SpouseFullName.setText(Checknull(datain.get("SpouseFullName"))+"");
        Education.setText(Checknull(datain.get("Education"))+"");
        StatusSueAndPutInJail.setText(Checknull(datain.get("StatusSueAndPutInJail"))+"");
        FatherAddress.setText(Checknull(datain.get("FatherAddress"))+"");
        CarUse.setText(Checknull(datain.get("CarUse"))+"");
        Identification.setText(Checknull(datain.get("Identification"))+"");
        WarrantList.setText(Checknull(datain.get("WarrantList"))+"");
        NotePersonData.setText(Checknull(datain.get("NotePersonData"))+"");
         FavouritePlace.setText(Checknull(datain.get("FavouritePlace"))+"");
        
        
        }
        else{
        isInsert=true;
        
        }
         addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            System.exit(0);
//        }
    }
});
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
        jButtonSave = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        FullNamePerson = new javax.swing.JTextField();
        PeopleRegistrationID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Occupation = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        BirthDay = new javax.swing.JTextField();
        Nationality = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Race = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Religion = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OccupationPosition = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        HouseNumber = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Moo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        Tambon = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        Amphur = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Province = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        PhonePerson = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        FatherFullName = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        MotherFullName = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        CurrentAddress = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        OtherName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        SpouseFullName = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        StatusSueAndPutInJail = new javax.swing.JTextField();
        Education = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        CarUse = new javax.swing.JTextField();
        FavouritePlace = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        FatherAddress = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        NotePersonData = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        Identification = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        WarrantList = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NoPerson = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonSave.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonSave.setText("บันทึก");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        FullNamePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        PeopleRegistrationID.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel11.setText("เชื้อชาติ");

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel9.setText("ชื่อ-สกุล");

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel10.setText("เลขประจำตัวประชาชน");

        jLabel14.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel14.setText("อาชีพ");

        Occupation.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel16.setText("อายุ");

        Age.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel15.setText("ว/ด/ปี เกิด");

        BirthDay.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        Nationality.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel13.setText("ศาสนา");

        Race.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel12.setText("สัญชาติ");

        Religion.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel17.setText("ที่ทำงาน ตำแหน่ง มีหน้าที่");

        OccupationPosition.setColumns(20);
        OccupationPosition.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        OccupationPosition.setLineWrap(true);
        OccupationPosition.setRows(1);
        OccupationPosition.setTabSize(1);
        jScrollPane1.setViewportView(OccupationPosition);

        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel18.setText("ภูมิลำเนา เลขที่");

        HouseNumber.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel19.setText("หมู่");

        Moo.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel20.setText("ตำบล/แขวง");

        Tambon.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel21.setText("อำเภอ/เขต");

        Amphur.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel22.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel22.setText("จังหวัด");

        Province.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel23.setText("โทรศัพท์");

        PhonePerson.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel24.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel24.setText("ชื่อบิดา");

        FatherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel25.setText("ชื่อมารดา");

        MotherFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel26.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel26.setText("ที่อยู่ปัจจุบัน");

        CurrentAddress.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nationality, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Occupation))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Moo))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addGap(3, 3, 3)
                .addComponent(Amphur))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MotherFullName))
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(CurrentAddress)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FullNamePerson))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PeopleRegistrationID))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FatherFullName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FullNamePerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Race, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Religion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Occupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BirthDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PeopleRegistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HouseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Moo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tambon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amphur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Province, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhonePerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FatherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MotherFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CurrentAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel27.setText("ชื่อรอง-นามแฝง-ฉายา");

        OtherName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel28.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel28.setText("สามี/ภรรยา");

        SpouseFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel30.setText("เคยต้องโทษ ต้องหา");

        StatusSueAndPutInJail.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        Education.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel29.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel29.setText("การศึกษา");

        CarUse.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        FavouritePlace.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        FavouritePlace.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));

        jLabel37.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel37.setText("รถที่ใช้");

        FatherAddress.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel36.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel36.setText("สถานที่ที่ชอบไป");

        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel34.setText("ที่อยู่บิดามารดา");

        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel31.setText("หมายเหตุ");

        NotePersonData.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel33.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel33.setText("ตำหนิรูปพรรณ");

        Identification.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel32.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel32.setText("รายการประวัติ หมายจับ");

        WarrantList.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CarUse))
                    .addComponent(WarrantList)
                    .addComponent(Identification)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpouseFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FatherAddress))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Education, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(StatusSueAndPutInJail, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(FavouritePlace)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NotePersonData, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OtherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpouseFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Education, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusSueAndPutInJail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FatherAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarUse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(FavouritePlace, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(Identification, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NotePersonData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WarrantList, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(290, 290, 290))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ข้อมูลบุคคล");

        NoPerson.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NoPerson)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addComponent(NoPerson))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1275, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
                con=ConnectDatabase.connect();
          if(isInsert){
            String sql="INSERT INTO PersonData (PeopleRegistrationID,Race,Nationality,Religion,Occupation,BirthDay,Age,FullNamePerson,"
                    + "OccupationPosition,HouseNumber,Moo,Tambon,Amphur,Province,PhonePerson,FatherFullName,MotherFullName,CurrentAddress,"
                    + "OtherName,SpouseFullName,Education,StatusSueAndPutInJail,FatherAddress,CarUse,FavouritePlace,Identification,"
                    + "WarrantList,NotePersonData)"+
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
            System.out.println(sql);
            try {

                pst=con.prepareStatement(sql);

                pst.setString(1,PeopleRegistrationID.getText());
                pst.setString(2,Race.getText());
                pst.setString(3,Nationality.getText());
                pst.setString(4,Religion.getText());
                pst.setString(5,Occupation.getText());
                pst.setString(6,BirthDay.getText());
                pst.setString(7,Age.getText());
                pst.setString(8,FullNamePerson.getText());
                pst.setString(9,OccupationPosition.getText());
                pst.setString(10,HouseNumber.getText());
                pst.setString(11,Moo.getText());
                pst.setString(12,Tambon.getText());
                pst.setString(13,Amphur.getText());
                pst.setString(14,Province.getText());
                pst.setString(15,PhonePerson.getText());
                pst.setString(16,FatherFullName.getText());
                pst.setString(17,MotherFullName.getText());
                pst.setString(18,CurrentAddress.getText());
                pst.setString(19,OtherName.getText());
                pst.setString(20,SpouseFullName.getText());
                pst.setString(21,Education.getText());
                pst.setString(22,StatusSueAndPutInJail.getText());
                pst.setString(23,FatherAddress.getText());
                pst.setString(24,CarUse.getText());
                pst.setString(25,FavouritePlace.getText());
                pst.setString(26,Identification.getText());
                pst.setString(27,WarrantList.getText());
                pst.setString(28,NotePersonData.getText());


         
//                pst.setString(38,orcuredTimeEnd);                
                

       
         
               
//       JOptionPane.showMessageDialog(jPanel1,null, "Data Save", JOptionPane.INFORMATION_MESSAGE);

                
      int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  if (response == JOptionPane.YES_OPTION) {
//             con=ConnectDatabase.connect();
         pst.executeUpdate(); 
         pst.close();
         System.out.println("SQL : "+sql);
    

    } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }
        }
        else{
         
          
            String sqlUpdate="UPDATE PersonData SET "
            + "PeopleRegistrationID = ?,"
            +"Race = ?,"
            +"Nationality = ?,"
            +"Religion = ?,"
            +"Occupation = ?,"
            +"BirthDay = ?,"
            +"Age = ?,"
            +"FullNamePerson = ?,"
            +"OccupationPosition = ?,"
            +"HouseNumber = ?,"
            +"Moo = ?,"
            +"Tambon = ?,"
            +"Amphur = ?,"
            +"Province = ?,"
            +"PhonePerson = ?,"
            +"FatherFullName = ?," 
            +"MotherFullName = ?,"
            +"CurrentAddress = ?,"      
            +"OtherName = ?,"
            +"SpouseFullName = ?,"
            +"Education = ?,"
            +"StatusSueAndPutInJail = ?,"
            +"FatherAddress=?,"
            +"CarUse=?," 
            +"FavouritePlace=?,"
            +"Identification=?,"
            +"WarrantList=?,"
            +"NotePersonData=?"               
            +" WHERE  NoPerson = ?";
            System.out.println("SQL : "+sqlUpdate);
            try {

                pst=con.prepareStatement(sqlUpdate);
                pst.setString(1,PeopleRegistrationID.getText());
                pst.setString(2,Race.getText());
                pst.setString(3,Nationality.getText());
                pst.setString(4,Religion.getText());
                pst.setString(5,Occupation.getText());
                pst.setString(6,BirthDay.getText());
                pst.setString(7,Age.getText());
                pst.setString(8,FullNamePerson.getText());
                pst.setString(9,OccupationPosition.getText());
                pst.setString(10,HouseNumber.getText());
                pst.setString(11,Moo.getText());
                pst.setString(12,Tambon.getText());
                pst.setString(13,Amphur.getText());
                pst.setString(14,Province.getText());
                pst.setString(15,PhonePerson.getText());
                pst.setString(16,FatherFullName.getText());
                pst.setString(17,MotherFullName.getText());
                pst.setString(18,CurrentAddress.getText());
                pst.setString(19,OtherName.getText());
                pst.setString(20,SpouseFullName.getText());
                pst.setString(21,Education.getText());
                pst.setString(22,StatusSueAndPutInJail.getText());
                pst.setString(23,FatherAddress.getText());
                pst.setString(24,CarUse.getText());
                pst.setString(25,FavouritePlace.getText());
                pst.setString(26,Identification.getText());
                pst.setString(27,WarrantList.getText());
                pst.setString(28,NotePersonData.getText());
                pst.setString(29,NoPerson.getText());

                
             
                
               int response = JOptionPane.showConfirmDialog(jPanel1, "ต้องการแก้ไขข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
  if (response == JOptionPane.YES_OPTION) {
         pst.executeUpdate(); 
         pst.close();
        
         System.out.println("SQL : "+sqlUpdate);

    } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println("SQL : "+pst);
            }
        }

        
    }//GEN-LAST:event_jButtonSaveActionPerformed

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
            java.util.logging.Logger.getLogger(PersonFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new PersonFrom().setVisible(true);
            }
        });
    }
        public static Object Checknull(Object input){
		if(input==null||input==""||input=="null") { return ""; }
		return input;
		}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField Amphur;
    private javax.swing.JTextField BirthDay;
    private javax.swing.JTextField CarUse;
    private javax.swing.JTextField CurrentAddress;
    private javax.swing.JTextField Education;
    private javax.swing.JTextField FatherAddress;
    private javax.swing.JTextField FatherFullName;
    private javax.swing.JTextField FavouritePlace;
    private javax.swing.JTextField FullNamePerson;
    private javax.swing.JTextField HouseNumber;
    private javax.swing.JTextField Identification;
    private javax.swing.JTextField Moo;
    private javax.swing.JTextField MotherFullName;
    private javax.swing.JTextField Nationality;
    private javax.swing.JLabel NoPerson;
    private javax.swing.JTextField NotePersonData;
    private javax.swing.JTextField Occupation;
    private javax.swing.JTextArea OccupationPosition;
    private javax.swing.JTextField OtherName;
    private javax.swing.JTextField PeopleRegistrationID;
    private javax.swing.JTextField PhonePerson;
    private javax.swing.JTextField Province;
    private javax.swing.JTextField Race;
    private javax.swing.JTextField Religion;
    private javax.swing.JTextField SpouseFullName;
    private javax.swing.JTextField StatusSueAndPutInJail;
    private javax.swing.JTextField Tambon;
    private javax.swing.JTextField WarrantList;
    private javax.swing.JButton jButtonSave;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
