/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
import static com.songkhla.wordgen.AssetOverView.jTableAsset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import java.awt.Font;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.BorderFactory;

/**
 *
 * @author Petpilin
 */
public class BailCrimesAdd extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;
    DataCase dc =new DataCase();
    String caseId;
    String personId;
    /**
     * Creates new form BailCrimesAdd
     */
    public BailCrimesAdd(JFrame parrent,JSONObject datain) {
        super(parrent,true);
        initComponents();
        ImageIcon img = new ImageIcon("./Master/WD.png");
        setIconImage(img.getImage());
         setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
         try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,28f);
                     jLabel1.setFont(sizedFont);
           
                 Font  labelother = font.deriveFont(1,22f);
                     jLabel30.setFont(labelother);
                     jLabel5.setFont(labelother);
                     jLabel7.setFont(labelother);
                     jLabel6.setFont(labelother);
                     jLabel8.setFont(labelother);
                     jLabel2.setFont(labelother);
                     jButton1.setFont(labelother);
                     jButton3.setFont(labelother);
                     jButton2.setFont(labelother);
                   jLabel31.setFont(labelother);
                     jLabel34.setFont(labelother);
                     jButtonAddSue.setFont(labelother);
                     jButtonEditSue.setFont(labelother);
                     jButtonDeleteBailAsset.setFont(labelother);
                     jLabel35.setFont(labelother);
                     jButtonAddSue1.setFont(labelother);
                     jButtonEditSue1.setFont(labelother);
                     jButtonDelete1.setFont(labelother);
                     
                     Font  tableFont = font.deriveFont(1,20f);
                jTableBailAsset.getTableHeader().setFont(tableFont);
                jTableBailAsset.getTableHeader().setOpaque(false);
                jTableBailSend.getTableHeader().setFont(tableFont);
            jTableBailSend.getTableHeader().setOpaque(false);
               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
         ChargeName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        refreshAssetData();
        refreshBailSendData();
        caseId=datain.get("CaseId")+"";
        personId=datain.get("NoPerson")+"";
        jLabel8.setText(personId);
        jLabel8.setVisible(false);
        if(datain !=null){
                String sql="select crimecasenoyear,NoPerson,crimecaseno,Investigator_Result,TypePerson,ArrestDateTimeEnd,BailDate,CourtSuspect,"
                        + "PeopleRegistrationID,PlaceArrest,ArrestDateTime,FullNamePerson,StatusSuspect,CaseId,CaseIdPerson,"
                        + "CaseAcceptDate,chargecase.ChargeCodeCase ChargeCase,chargecase.ChargeNameCase ChargeNameCase\n" +
                     "from Person\n" +
                     "left join CrimeCase on Person.CaseIdPerson=CrimeCase.CaseId\n"+
                     "left join chargecase on crimecase.CaseId=chargecase.ChargeCaseId " +                
                     "where TypePerson='ผู้ต้องหา' and caseid='"+caseId+"' and noperson='"+personId+"'";
                try{
                     Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                 if(rs.next()){
             crimecaseno.setText(rs.getString("crimecasenoyear"));
            SuspectFullName.setText(rs.getString("FullNamePerson"));
            ChargeName.setText(rs.getString("ChargeNameCase"));
            PlaceArrest.setText(rs.getString("PlaceArrest"));
            DateBail.setText(ToDateNotTime(rs.getString("BailDate")));
            DateArrest.setText(ToDate(rs.getString("ArrestDateTime"))+" เวลา "+ToTime(rs.getString("ArrestDateTime")));
           if(rs.getString("ArrestDateTimeEnd").equals("")||rs.getString("ArrestDateTimeEnd").equals("null")){
          DateArrestEnd.setText("");
           }
           else{DateArrestEnd.setText(ToDate(rs.getString("ArrestDateTimeEnd"))+" เวลา "+ToTime(rs.getString("ArrestDateTimeEnd")));
           }
            
              

                        }
                 else{
                    crimecaseno.setText("");
            SuspectFullName.setText("");
            ChargeName.setText("");
            PlaceArrest.setText("");
            DateArrest.setText("");
             DateArrestEnd.setText("");
              DateBail.setText("");
                 
                 
                 
                 
                 }
                }catch(Exception ex){
                
                }

     
        }
        refreshBailSendData();
        refreshAssetData();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SuspectFullName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ChargeName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBailAsset = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jButtonAddSue = new javax.swing.JButton();
        jButtonEditSue = new javax.swing.JButton();
        jButtonDeleteBailAsset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBailSend = new javax.swing.JTable();
        jButtonAddSue1 = new javax.swing.JButton();
        jButtonEditSue1 = new javax.swing.JButton();
        jButtonDelete1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        PlaceArrest = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DateArrest = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        DateArrestEnd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        DateBail = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("เพิ่ม/แก้ไข การประกันตัวผู้ต้องหา");

        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("./Master/home.png"));
        jButton2.setText("เมนูหลัก");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addComponent(jLabel8))
        );

        jLabel30.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel30.setText("เลขคดีที่ ");

        crimecaseno.setEditable(false);
        crimecaseno.setBackground(new java.awt.Color(204, 204, 204));
        crimecaseno.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        crimecaseno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        crimecaseno.setBorder(null);
        crimecaseno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        crimecaseno.setEnabled(false);
        crimecaseno.setPreferredSize(new java.awt.Dimension(0, 30));
        crimecaseno.setRequestFocusEnabled(false);

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("ชื่อผู้ต้องหา");

        SuspectFullName.setEditable(false);
        SuspectFullName.setBackground(new java.awt.Color(204, 204, 204));
        SuspectFullName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        SuspectFullName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SuspectFullName.setBorder(null);

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel6.setText("ข้อหา");

        ChargeName.setEditable(false);
        ChargeName.setBackground(new java.awt.Color(204, 204, 204));
        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        ChargeName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ChargeName.setBorder(null);

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        jLabel31.setBackground(new java.awt.Color(255, 204, 204));
        jLabel31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ระบุหลักประกัน ในการขอประกันตัว");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTableBailAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jTableBailAsset.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ลำดับ", "รายการทรัพย์สิน", "จำนวน", "ราคา(บาท)", "ราคา(สตางค์)", "รวมมูลค่า(บาท)", "รวมมูลค่า(สตางค์)", "หมายเหตุ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableBailAsset);

        jLabel34.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jLabel34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText("บัญชีทรัพย์สินของผู้ประกันตัว");

        jButtonAddSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddSue.setText("เพิ่ม");
        jButtonAddSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSueActionPerformed(evt);
            }
        });

        jButtonEditSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonEditSue.setText("ดูข้อมูล/แก้ไข");
        jButtonEditSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditSueActionPerformed(evt);
            }
        });

        jButtonDeleteBailAsset.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonDeleteBailAsset.setText("ลบ");
        jButtonDeleteBailAsset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteBailAssetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButtonAddSue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditSue, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDeleteBailAsset)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddSue)
                    .addComponent(jButtonEditSue)
                    .addComponent(jButtonDeleteBailAsset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 204));

        jLabel35.setBackground(new java.awt.Color(255, 204, 204));
        jLabel35.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("กำหนดวันเวลาส่งตัวผู้ต้องหา");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(198, 198, 198))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTableBailSend.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        jTableBailSend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ครั้งที่", "วันที่ส่งตัว", "เวลา", "สถานที่ส่งตัว"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableBailSend);

        jButtonAddSue1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonAddSue1.setText("เพิ่ม");
        jButtonAddSue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSue1ActionPerformed(evt);
            }
        });

        jButtonEditSue1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonEditSue1.setText("ดูข้อมูล/แก้ไข");
        jButtonEditSue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditSue1ActionPerformed(evt);
            }
        });

        jButtonDelete1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonDelete1.setText("ลบ");
        jButtonDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonAddSue1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditSue1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddSue1)
                    .addComponent(jButtonEditSue1)
                    .addComponent(jButtonDelete1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel2.setText("สถานที่จับกุม");

        PlaceArrest.setEditable(false);
        PlaceArrest.setBackground(new java.awt.Color(204, 204, 204));
        PlaceArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        PlaceArrest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PlaceArrest.setBorder(null);

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel3.setText("วันที่จับกุม");

        DateArrest.setEditable(false);
        DateArrest.setBackground(new java.awt.Color(204, 204, 204));
        DateArrest.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        DateArrest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DateArrest.setBorder(null);

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("สร้างเอกสาร");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("วันที่สิ้นสุดควบคุมตัว");

        DateArrestEnd.setEditable(false);
        DateArrestEnd.setBackground(new java.awt.Color(204, 204, 204));
        DateArrestEnd.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        DateArrestEnd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DateArrestEnd.setBorder(null);

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel7.setText("วันประกัน");

        DateBail.setEditable(false);
        DateBail.setBackground(new java.awt.Color(204, 204, 204));
        DateBail.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        DateBail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DateBail.setBorder(null);

        jButton3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton3.setText("นายประกัน");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(27, 27, 27)
                        .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(SuspectFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(DateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(DateArrestEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45)
                        .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(DateBail, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crimecaseno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuspectFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateArrestEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChargeName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(DateBail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(PlaceArrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddSue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSue1ActionPerformed
        // TODO add your handling code here:
        JSONObject data=new JSONObject();
        data.put("BailCaseId",caseId );
        data.put("BailPersonId",personId );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fr = (JFrame)(dialog.getParent());
        fr.removeAll();
        DeliverySuspect baa=new DeliverySuspect(fr,null,data);
        baa.pack();
        baa.setLocationRelativeTo(null);
        baa.setVisible(true);
        
        refreshBailSendData();
    }//GEN-LAST:event_jButtonAddSue1ActionPerformed

    private void jButtonEditSue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditSue1ActionPerformed
        // TODO add your handling code here:
         if(jTableBailSend.getSelectedRow()>=0){
            try{
                String DeliOrder= jTableBailSend.getModel().getValueAt(jTableBailSend.getSelectedRow(), 0)+"";

                String sql="select DeliId,DeliOrder,DeliDate,DeliTimes,DeliPlace,DeliPersonId from DeliverySuspect where DeliOrder='"+DeliOrder+"' and DeliPersonId='"+personId+"'";
                System.out.println("Editbutton :"+sql);
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if(rs.next()){
                    JSONObject data = new JSONObject();
                     data.put("DeliId", rs.getString("DeliId"));
                    data.put("DeliOrder", rs.getString("DeliOrder"));
                    data.put("DeliDate", rs.getString("DeliDate"));
                    data.put("DeliTimes", rs.getString("DeliTimes"));
                    data.put("DeliPlace", rs.getString("DeliPlace"));
                    data.put("DeliPersonId", rs.getString("DeliPersonId"));
 
                    JSONObject data2 = new JSONObject();
                    data2.put("BailPersonId",personId);
                      JFrame frame = new JFrame();
                    JDialog dialog = new JDialog(frame);//frame is owner
                    JFrame de = (JFrame)(dialog.getParent());
                    de.removeAll();
                    DeliverySuspect ba =new DeliverySuspect(de,data,data2);
                    ba.pack();
                    ba.setLocationRelativeTo(null);
                    ba.setVisible(true);
                }

                rs.close();
                stmt.close();
                refreshAssetData();
            }catch(Exception ex){
                ex.printStackTrace();

            }
        }else{

        }
        
        refreshBailSendData();
    }//GEN-LAST:event_jButtonEditSue1ActionPerformed

    private void jButtonDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelete1ActionPerformed
        // TODO add your handling code here:
         if(jTableBailSend.getSelectedRow()>=0){
            try{
//                String crimecaseno = txtCaseno.getText();
                String DeliOrder= jTableBailSend.getModel().getValueAt(jTableBailSend.getSelectedRow(), 0)+"";
//                String AssetId = jTableAsset.getModel().getValueAt(jTableAsset.getSelectedRow(), 4)+"";
                String sql = "Delete from DeliverySuspect where DeliOrder='"+DeliOrder+"' and DeliPersonId='"+personId+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                System.out.println("SQL : "+sql);
                stmt.close();
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }       
        refreshBailSendData();
    }//GEN-LAST:event_jButtonDelete1ActionPerformed

    private void jButtonDeleteBailAssetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteBailAssetActionPerformed
        // TODO add your handling code here:
         if(jTableBailAsset.getSelectedRow()>=0){
            try{
//                String crimecaseno = txtCaseno.getText();
                String BailAssetId = jTableBailAsset.getModel().getValueAt(jTableBailAsset.getSelectedRow(), 6)+"";
//                String AssetId = jTableAsset.getModel().getValueAt(jTableAsset.getSelectedRow(), 4)+"";
                String sql = "Delete from BailAsset WHERE BailAssetId='"+BailAssetId+"' and BailCaseId='"+caseId+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);
                System.out.println("SQL : "+sql);
                stmt.close();
            
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }       
        refreshAssetData();
    }//GEN-LAST:event_jButtonDeleteBailAssetActionPerformed

    private void jButtonEditSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditSueActionPerformed
        // TODO add your handling code here:
          if(jTableBailAsset.getSelectedRow()>=0){
            try{
                String BailAssetid = jTableBailAsset.getModel().getValueAt(jTableBailAsset.getSelectedRow(), 0)+"";

                String sql="select BailAssetOrder,BailAssetDetail,BailAssetBath,BailAmount,BailAssetTotal,BailAssetRemark,BailCaseId,BailPersonId\n" +
                     "from BailAsset\n" + 
                    "where BailAssetOrder='"+BailAssetid+"' and BailCaseId='"+caseId+"' and BailPersonId='"+personId+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("ExSql : "+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("BailAssetOrder", rs.getString("BailAssetOrder"));
                    data.put("BailAssetDetail", rs.getString("BailAssetDetail"));
                    data.put("BailAssetBath", rs.getString("BailAssetBath"));
                    data.put("BailAmount", rs.getString("BailAmount"));
                    data.put("BailAssetTotal", rs.getString("BailAssetTotal"));
                    data.put("BailAssetRemark", rs.getString("BailAssetRemark"));
                    data.put("BailCaseId", rs.getString("BailCaseId"));
                     data.put("BailPersonId", rs.getString("BailPersonId"));
                      JSONObject data2 = new JSONObject();
                          data2.put("BailCaseId", rs.getString("BailCaseId"));
                     data2.put("BailPersonId", rs.getString("BailPersonId"));
                      JFrame frame = new JFrame();
                    JDialog dialog = new JDialog(frame);//frame is owner
                    JFrame baf = (JFrame)(dialog.getParent());
                    baf.removeAll();
                    BailAssetAdd ba =new BailAssetAdd(baf,data,data2);
                    ba.pack();
                    ba.setLocationRelativeTo(null);
                    ba.setVisible(true);
                }

                rs.close();
                stmt.close();
               
            }catch(Exception ex){
                ex.printStackTrace();

            }
        }else{

        }
        refreshAssetData();
    }//GEN-LAST:event_jButtonEditSueActionPerformed

    private void jButtonAddSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSueActionPerformed
        // TODO add your handling code here:
        JSONObject data=new JSONObject();
        data.put("BailCaseId",caseId );
        data.put("BailPersonId",personId );
        
        BailAssetAdd baa=new BailAssetAdd(null,null,data);
        baa.pack();
        baa.setLocationRelativeTo(null);
        baa.setVisible(true);
        refreshAssetData();
    }//GEN-LAST:event_jButtonAddSueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JSONObject data=new JSONObject();
        data.put("caseid",caseId );
        data.put("personid",personId );
                data.put("pageBail","Bail" );

//        data.put("BailPersonId",personId );
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        ReportforCrimesCase baa=new ReportforCrimesCase(fwit,data);
        baa.pack();
        baa.setLocationRelativeTo(null);
        baa.setVisible(true);
        refreshAssetData();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MainMenuWord.closeAllDialogs();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          try{
             
                String sql="select * from Person where typeperson='พยานและบุคคลอื่นๆ' and Related='นายประกัน' and OwnerBail='"+personId+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("ExSql : "+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                   data.put("NoPerson", rs.getString("NoPerson"));
                    data.put("PeopleRegistrationID", rs.getString("PeopleRegistrationID"));
                    data.put("caseIdPerson", rs.getString("caseIdPerson"));
                    data.put("Age", rs.getString("Age"));
                    data.put("Amphur", rs.getString("Amphur"));
                    data.put("BirthDay", rs.getString("BirthDay"));
                    data.put("BloodGroup", rs.getString("BloodGroup"));
                    data.put("ExpiredDate", rs.getString("ExpiredDate"));
                    data.put("FatherFullName", rs.getString("FatherFullName"));
                    data.put("FullNamePerson", rs.getString("FullNamePerson"));
                    data.put("FullNamePersonEn", rs.getString("FullNamePersonEn"));
                    data.put("Gender", rs.getString("Gender"));
                    data.put("Height", rs.getString("Height"));
                    data.put("Weight", rs.getString("Weight"));
                    data.put("HouseNumber", rs.getString("HouseNumber"));
                    data.put("IssueDate", rs.getString("IssueDate"));
                    data.put("Moo", rs.getString("Moo"));
                    data.put("MotherFullName", rs.getString("MotherFullName"));
                    data.put("Nationality", rs.getString("Nationality"));
                    data.put("Occupation", rs.getString("Occupation"));
                    data.put("PassportNumber", rs.getString("PassportNumber"));
                    data.put("PhonePerson", rs.getString("PhonePerson"));
                    data.put("Province", rs.getString("Province"));
                    data.put("Race", rs.getString("Race"));
                    data.put("Religion", rs.getString("Religion"));
                    data.put("Tambon", rs.getString("Tambon"));
                    data.put("ZipCode", rs.getString("ZipCode"));
                    data.put("OrderPerson", rs.getString("OrderPerson"));
                    data.put("Related", rs.getString("Related"));
                    data.put("OtherName", rs.getString("OtherName"));
                    data.put("OccupationPosition", rs.getString("OccupationPosition"));
                     data.put("OwnerBail", rs.getString("OwnerBail"));    
                   
                        data.put("caseid",caseId );
                        data.put("personid",personId );
                        JFrame frame = new JFrame();
                        JDialog dialog = new JDialog(frame);//frame is owner
                        JFrame fwit = (JFrame)(dialog.getParent());
                        fwit.removeAll();
                        OwnerBailForm baa=new OwnerBailForm(fwit,data,null);
                        baa.pack();
                        baa.setLocationRelativeTo(null);
                        baa.setVisible(true);
                }
                else{
                      JSONObject c=new JSONObject();
                        c.put("caseid",caseId );
                        c.put("personid",personId );
                //        data.put("BailPersonId",personId );
                        JFrame frame = new JFrame();
                        JDialog dialog = new JDialog(frame);//frame is owner
                        JFrame ow = (JFrame)(dialog.getParent());
                        ow.removeAll();
                        OwnerBailForm baa=new OwnerBailForm(ow,null,c);
                        baa.pack();
                        baa.setLocationRelativeTo(null);
                        baa.setVisible(true);

                }

                rs.close();
                stmt.close();
  
            }catch(Exception ex){
                ex.printStackTrace();

            }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    public void refreshAssetData(){
            try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
//        String a=txtCaseNO.getText();
        String sql;
                sql= "select BailAssetId,BailAssetOrder,BailAssetDetail,BailAssetBath,BailAmount,BailAssetTotal,BailAssetRemark,BailCaseId,BailPersonId\n" +
                     "from BailAsset\n"
                   + "where BailCaseId='"+caseId+"' and BailPersonId='"+personId+"'";
    
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
           
            
            row.add(rs.getString("BailAssetOrder"));
            row.add(rs.getString("BailAssetDetail"));
            row.add(rs.getString("BailAmount"));
            row.add(rs.getString("BailAssetBath"));      
            row.add(rs.getString("BailAssetTotal"));
            row.add(rs.getString("BailAssetRemark"));
             row.add(rs.getString("BailAssetId"));
//            row.add(rs.getString("Age"));
//            row.add(rs.getString("Race"));
//            row.add(rs.getString("Nationality"));
//            row.add(rs.getString("Religion"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector(); 
      
         ColumnName.add("ลำดับ");    
         ColumnName.add("รายการทรัพย์");
         ColumnName.add("จำนวน");
         ColumnName.add("ราคาบาท");
         ColumnName.add("รวมมูลค่า");
         ColumnName.add("หมายเหตุ");
         ColumnName.add("BailAssetId");

//         ColumnName.add("ครบ 2 เดือน");
         

         System.out.println("SQL : "+sql);
     
        jTableBailAsset.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
             jTableBailAsset.getColumnModel().getColumn(6).setWidth(0);
jTableBailAsset.getColumnModel().getColumn(6).setMinWidth(0);
jTableBailAsset.getColumnModel().getColumn(6).setMaxWidth(0); 
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
     public void refreshBailSendData(){
            try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
//        String a=txtCaseNO.getText();
        String sql;
                sql= "select DeliOrder,DeliDate,DeliTimes,DeliPlace,DeliPersonId\n" +
                     "from DeliverySuspect\n"
                   + "where DeliPersonId='"+personId+"'";
    
        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("DeliOrder"));
            row.add(rs.getString("DeliDate"));
            row.add(rs.getString("DeliTimes"));
            row.add(rs.getString("DeliPlace"));
//            row.add(rs.getString("Age"));
//            row.add(rs.getString("Race"));
//            row.add(rs.getString("Nationality"));
//            row.add(rs.getString("Religion"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector(); 
      
         ColumnName.add("ครั้งที่");    
         ColumnName.add("วันส่งตัว");
         ColumnName.add("เวลา");
         ColumnName.add("สถานที่ส่งตัว");
//         ColumnName.add("ครบ 2 เดือน");
         

         System.out.println("SQL : "+sql);
     
        jTableBailSend.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
     
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
     private static String ToDate(String strDate){
               String ResultDate="";
         try {
    	        if(strDate==null||strDate.equals("")||strDate.equals("null")) { return ""; }else{
    	       SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy HH:mm", new Locale("th", "TH"));  
               SimpleDateFormat dateto  = new SimpleDateFormat("d MMMM yyyy", new Locale("th", "TH"));  
               Date date=null;
               
               date = df.parse(strDate);               
               ResultDate=dateto.format(date.getTime());}
         } catch (ParseException ex) {
           
         }
               return ResultDate;
}
          private static String ToDateNotTime(String strDate){
               String ResultDate="";
         try {
    	        if(strDate==null||strDate.equals("")||strDate.equals("null")) { return ""; }else{
    	       SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy", new Locale("th", "TH"));  
               SimpleDateFormat dateto  = new SimpleDateFormat("d MMMM yyyy", new Locale("th", "TH"));  
               Date date=null;
               
               date = df.parse(strDate);               
               ResultDate=dateto.format(date.getTime());}
         } catch (ParseException ex) {
            ex.printStackTrace();
         }
               return ResultDate;
}
 private static String ToTime(String strDate){
               String ResultDate="";
         try {
    	        if(strDate==null||strDate.equals("")||strDate.equals("null")) { return ""; }else{
    	       SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy HH:mm", new Locale("th", "TH"));  
               SimpleDateFormat dateto  = new SimpleDateFormat("HH:mm", new Locale("th", "TH"));  
               Date date=null;
               
               date = df.parse(strDate);               
               ResultDate=dateto.format(date.getTime());}
         } catch (ParseException ex) {
           
         }
               return ResultDate;
}
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
            java.util.logging.Logger.getLogger(BailCrimesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BailCrimesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BailCrimesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BailCrimesAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new BailCrimesAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ChargeName;
    private javax.swing.JTextField DateArrest;
    private javax.swing.JTextField DateArrestEnd;
    private javax.swing.JTextField DateBail;
    private javax.swing.JTextField PlaceArrest;
    private javax.swing.JTextField SuspectFullName;
    private javax.swing.JTextField crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAddSue;
    private javax.swing.JButton jButtonAddSue1;
    private javax.swing.JButton jButtonDelete1;
    private javax.swing.JButton jButtonDeleteBailAsset;
    private javax.swing.JButton jButtonEditSue;
    private javax.swing.JButton jButtonEditSue1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBailAsset;
    private javax.swing.JTable jTableBailSend;
    // End of variables declaration//GEN-END:variables
}
