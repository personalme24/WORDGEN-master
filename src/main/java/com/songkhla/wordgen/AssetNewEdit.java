/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;

/**
 *
 * @author Matazz
 */
public class AssetNewEdit extends javax.swing.JDialog {
    Connection con=null;
     PreparedStatement pst=null;
       boolean isInsert;
        String caseid,cc,noasset,caseType;
   JDatePickerImpl DateSequester;
    /**
     * Creates new form AssetNewEdit
     */
    public AssetNewEdit(JFrame parrent,JSONObject datain,JSONObject dataType) {
        super(parrent,true);
        initComponents();
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
            try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,28f);
                     jLabel8.setFont(sizedFont);
           
                 Font  labelother = font.deriveFont(1,22f);
                     jLabel1.setFont(labelother);
                     jRecord.setFont(labelother);
                     jLabel2.setFont(labelother);
                     jLabel5.setFont(labelother);
                     jLabel6.setFont(labelother);
                     jLabel11.setFont(labelother);
                     jLabel10.setFont(labelother);
                     jLabel7.setFont(labelother);
                     jLabel3.setFont(labelother);
                     jLabel4.setFont(labelother);
                     jLabel9.setFont(labelother);
                     
          
               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
        crimecaseno.setVisible(false);
          crimecaseno.setText(AssetOverView.txtCaseno.getText());
      caseType=dataType.get("typecase")+"";
        try { Connection con = ConnectDatabase.connect();
            Statement stmt = con.createStatement();
             int id=0;
              cc=crimecaseno.getText(); 
          String orderid="Select MAX(OrderAsset) FROM Asset where caseIdAsset ='"+cc+"'";
          System.out.print(orderid);
            ResultSet rs = stmt.executeQuery(orderid);
       
            if(rs.next()){
                id=rs.getInt(1);
                System.out.println(id);
            }
            if(id==0){
                id=1;
            }
            else
            { id=id+1;}
          
        } catch (Exception e) {
        }
        UtilDateModel model = new UtilDateModel();
//            model.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
         DateSequester = new JDatePickerImpl(datePanel,new DateLabelFormatter());
        DateSequester.setTextEditable(true);
        DateSequester.setBackground(Color.WHITE);
        jPanelDateAsset.setLayout(new FlowLayout());
        jPanelDateAsset.add(DateSequester);    
        if(datain!=null){
            noasset=datain.get("NoAsset")+"";
            crimecaseno.setText(Checknull(datain.get("crimecaseno"))+"");
            EvidenceRecordNumber1.setText(Checknull(datain.get("EvidenceRecordNumber"))+"");
            OrderAsset.setText(Checknull(datain.get("OrderAsset"))+"");
            Name.setText(Checknull(datain.get("Name"))+"");
            OccupantName.setText(Checknull(datain.get("OccupantName"))+"");
            Remark.setText(Checknull(datain.get("Remark"))+"");
            Amount.setText(Checknull(datain.get("Amount"))+"");
            DateSequester.getJFormattedTextField().setText(Checknull(datain.get("DateSequester"))+"");
            DefectMark.setText(Checknull(datain.get("DefectMark"))+"");
            Value.setText(Checknull(datain.get("Value"))+"");
            PlaceFoundExhibit.setText(Checknull(datain.get("PlaceFoundExhibit"))+"");
            PointFoundCheck.setText(Checknull(datain.get("PointFoundCheck"))+"");
             StatusAsset.setSelectedItem(Checknull(datain.get("StatusAsset")));

            isInsert=false;
           
        }else{
            noasset=NoAsset();
            OrderAsset.setText(OrderAsset());
            isInsert=true;
        }
        
//        ----------------------------Right Click---------------------------------
          JTextPopupMenu.addTo(EvidenceRecordNumber1);
           JTextPopupMenu.addTo(Name);
          JTextPopupMenu.addTo(OccupantName);
          JTextPopupMenu.addTo(DefectMark);
          JTextPopupMenu.addTo(PlaceFoundExhibit);
          JTextPopupMenu.addTo(PointFoundCheck);
          JTextPopupMenu.addTo(Amount);
          JTextPopupMenu.addTo(Value);
          JTextPopupMenu.addTo(Remark);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        OccupantName = new javax.swing.JTextField();
        DefectMark = new javax.swing.JTextField();
        PointFoundCheck = new javax.swing.JTextField();
        Value = new javax.swing.JTextField();
        Amount = new javax.swing.JTextField();
        Remark = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        PlaceFoundExhibit = new javax.swing.JTextField();
        OrderAsset = new javax.swing.JTextField();
        crimecaseno = new javax.swing.JLabel();
        jRecord = new javax.swing.JLabel();
        EvidenceRecordNumber1 = new javax.swing.JTextField();
        StatusAsset = new javax.swing.JComboBox<>();
        jPanelDateAsset = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(4, 93, 179));

        jLabel8.setBackground(new java.awt.Color(46, 156, 202));
        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("เพิ่มข้อมูลทรัพย์");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("ลำดับ");

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("รายการ");

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("จำนวน");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setText("มูลค่าทรัพย์สิน(บาท)");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ยึดจาก");

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("วัน เดือน ปี ที่ยึด");

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel7.setText("จุดที่พบ");

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("หมายเหตุ");

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("สถานที่พบ");

        Name.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        OccupantName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        DefectMark.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        PointFoundCheck.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Value.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Amount.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        Remark.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jButton1.setBackground(java.awt.SystemColor.windowText);
        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("บันทึก");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel11.setText("ตำหนิ");

        PlaceFoundExhibit.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        OrderAsset.setEditable(false);
        OrderAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        crimecaseno.setText("ccno");

        jRecord.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jRecord.setText("สมุดบัญชีเลขที่");

        EvidenceRecordNumber1.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        StatusAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        StatusAsset.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ของกลาง", "ประทุษร้าย", "ได้คืน", "ไม่ได้คืน", "เพลิงไหม้", " " }));

        jPanelDateAsset.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelDateAssetLayout = new javax.swing.GroupLayout(jPanelDateAsset);
        jPanelDateAsset.setLayout(jPanelDateAssetLayout);
        jPanelDateAssetLayout.setHorizontalGroup(
            jPanelDateAssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        jPanelDateAssetLayout.setVerticalGroup(
            jPanelDateAssetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Value, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Remark)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(StatusAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(OrderAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRecord)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(EvidenceRecordNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE))
                                    .addComponent(DefectMark)
                                    .addComponent(PointFoundCheck)
                                    .addComponent(PlaceFoundExhibit)
                                    .addComponent(Name)
                                    .addComponent(OccupantName)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanelDateAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crimecaseno)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(crimecaseno))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(OrderAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRecord)
                        .addComponent(EvidenceRecordNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OccupantName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelDateAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DefectMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlaceFoundExhibit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PointFoundCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Value, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Remark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StatusAsset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
             con=ConnectDatabase.connect();
        if (isInsert) {
              String sql="INSERT INTO Asset (EvidenceRecordNumber,Amount,DateSequester,DefectMark,PlaceFoundExhibit,"
                      + "Name,Remark,OccupantName,OrderAsset,PointFoundCheck,Value,caseIdAsset,StatusAsset,NoAsset) "           
                      + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
              
               try {
            pst=con.prepareStatement(sql);
                              pst.setString(1,EvidenceRecordNumber1.getText());
                              pst.setString(2,Amount.getText());
                              pst.setString(3,DateSequester.getJFormattedTextField().getText());
                              pst.setString(4,DefectMark.getText());
                              pst.setString(5,PlaceFoundExhibit.getText());
                              pst.setString(6,Name.getText());
                              pst.setString(7,Remark.getText());
                              pst.setString(8,OccupantName.getText());
                              pst.setString(9,OrderAsset.getText());
                              pst.setString(10,PointFoundCheck.getText());
                              pst.setString(11,Value.getText());
                              pst.setString(12,crimecaseno.getText());
                              pst.setString(13,StatusAsset.getSelectedItem().toString());
                              pst.setString(14,noasset);
                              
                             
                              
                              
                              pst.executeUpdate();
                              
                              JOptionPane.showMessageDialog(jPanel1, "บันทึกข้อมูล",null, JOptionPane.INFORMATION_MESSAGE);
                             pst.close();
                        
        } catch (Exception e) {
             JOptionPane.showMessageDialog(jPanel1, "Cannot Save",null, JOptionPane.INFORMATION_MESSAGE);
             System.out.println("SQL : "+pst);
        }
          
        }
      
        else{
        String sqlUpdate="Update Asset set EvidenceRecordNumber=?,Amount=?,DateSequester=?,\n" +
                                    "DefectMark=?,PlaceFoundExhibit=?,Name=?,Remark=?,OccupantName=?,\n" +
                                    "OrderAsset=?,PointFoundCheck=?,Value=?,caseIdAsset=?,StatusAsset=? where NoAsset=?";
                 try {
            pst=con.prepareStatement(sqlUpdate);
                              pst.setString(1,EvidenceRecordNumber1.getText());
                              pst.setString(2,Amount.getText());
                              pst.setString(3,DateSequester.getJFormattedTextField().getText());
                              pst.setString(4,DefectMark.getText());
                              pst.setString(5,PlaceFoundExhibit.getText());
                              pst.setString(6,Name.getText());
                              pst.setString(7,Remark.getText());
                              pst.setString(8,OccupantName.getText());
                              pst.setString(9,OrderAsset.getText());
                              pst.setString(10,PointFoundCheck.getText());
                              pst.setString(11,Value.getText());
                              pst.setString(12,crimecaseno.getText());
                              pst.setString(13,StatusAsset.getSelectedItem().toString());
                              pst.setString(14,noasset);

                              pst.executeUpdate();
                              JOptionPane.showMessageDialog(jPanel1, "บันทึกข้อมูล",null, JOptionPane.INFORMATION_MESSAGE);
                             pst.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e); 
             System.out.println("SQL : "+pst);
        }
        } 
        if(caseType.equals("อาญา")){
     CrimesCaseEdit.EvidenceRecordCase.setText(EvidenceRecordNumber1.getText());}
         if(caseType.equals("จราจร")){
     TrafficEdit.EvidenceRecordCase.setText(EvidenceRecordNumber1.getText());}
          if(caseType.equals("ชันสูตร")){
     IdentityEdit.EvidenceRecordCase.setText(EvidenceRecordNumber1.getText());}

     
        setVisible(false);
      
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
public  String OrderAsset(){
         Connection con=null;
         String a=crimecaseno.getText();
         con=ConnectDatabase.connect();
            String sqlId="Select max(OrderAsset) OrderAsset from Asset where caseIdAsset='"+cc+"'";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("OrderAsset"); 
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
public  String NoAsset(){
         Connection con=null;
         String a=crimecaseno.getText();
         con=ConnectDatabase.connect();
            String sqlId="Select max(NoAsset) NoAsset from Asset";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("NoAsset"); 
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
            java.util.logging.Logger.getLogger(AssetNewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssetNewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssetNewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssetNewEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    AssetNewEdit  AssetAdd=new AssetNewEdit(null,null,null);
                    AssetAdd.setVisible(true);
              
            }
        });
    }
     public static String Checknull(Object input){
					if(input==null||input==""||input=="null") { return ""; }
					return input+"";
					}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Amount;
    private javax.swing.JTextField DefectMark;
    private javax.swing.JTextField EvidenceRecordNumber1;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField OccupantName;
    private javax.swing.JTextField OrderAsset;
    private javax.swing.JTextField PlaceFoundExhibit;
    private javax.swing.JTextField PointFoundCheck;
    private javax.swing.JTextField Remark;
    private javax.swing.JComboBox<String> StatusAsset;
    private javax.swing.JTextField Value;
    private javax.swing.JLabel crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelDateAsset;
    private javax.swing.JLabel jRecord;
    // End of variables declaration//GEN-END:variables
}
