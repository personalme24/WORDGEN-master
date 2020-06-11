/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.ActionPage.ActionCode;
import static com.songkhla.wordgen.ActionPage.ActionCrimes;
import static com.songkhla.wordgen.ActionPage.ActionDetail;
import static com.songkhla.wordgen.ActionPage.ActionNote;
import static com.songkhla.wordgen.ActionPage.AnswerAccuser;
import static com.songkhla.wordgen.ActionPage.AnswerSuspect;
import static com.songkhla.wordgen.ChargePageInsert.ChargeName;
import static com.songkhla.wordgen.ChargePageInsert.Law;
import static com.songkhla.wordgen.ChargePageInsert.Note;
import static com.songkhla.wordgen.ChargePageInsert.RateOfPenalty;
import static com.songkhla.wordgen.CrimesCaseEdit.ChargeNameCase;
import static com.songkhla.wordgen.CrimesCaseEdit.Checknull;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.simple.JSONObject;

/**
 *
 * @author Matazz
 */
public class ChargePage extends javax.swing.JDialog {
 
    Connection con=null;
    PreparedStatement pst=null;
    boolean isInsert;
    String caseidch;
       String caseidac,typecase;

    /**
     * Creates new form ChangPage
     */
    String chargeNo; 
    public ChargePage(JFrame parrent,JSONObject datain,JSONObject dataid) {
        super(parrent,true);
        initComponents();
         ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
        caseno.setVisible(false);
         typecase=dataid.get("typecase")+"";
          try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,36f);
                     jLabel6.setFont(sizedFont);
           
                 Font  labelother = font.deriveFont(1,22f);
                     jLabel5.setFont(labelother);
                     jLabel4.setFont(labelother);
                     jLabel2.setFont(labelother);
                     jLabel1.setFont(labelother);
                     jLabel3.setFont(labelother);
                     jButton2.setFont(labelother);
                     jButtonSaveCharge.setFont(labelother);
                     jButtonSaveChargeData.setFont(labelother);
            
               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
            if(datain!=null){
                
//            caseid= "" + datain.get("CaseId"); 
            caseidch= datain.get("ChargeCaseId")+"";
            chargeNo=datain.get("ChargeCode")+"";
            ChargeCode.setText(Checknull(datain.get("ChargeCodeCase"))+"");
            ChargeName.setText(Checknull(datain.get("ChargeNameCase"))+"");
             Law.setText(Checknull(datain.get("LawCase"))+"");
              RateOfPenalty.setText(Checknull(datain.get("RateOfPenaltyCase"))+"");
             Note.setText(Checknull(datain.get("NoteCase"))+"");

           
        }
   
            else{
                caseidch=dataid.get("caseid")+"";
            isInsert=true;
            jButtonSaveCharge.setEnabled(false);
        }
             ChargeCode.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                       jButtonSaveCharge.setEnabled(true);
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                           jButtonSaveCharge.setEnabled(true);

                           }
             }
             );
     JTextPopupMenu.addTo(ChargeName);
         JTextPopupMenu.addTo(Law);
         JTextPopupMenu.addTo(RateOfPenalty);
         JTextPopupMenu.addTo(Note);
     
    }

//    ChargePage(CrimesCaseEdit aThis, Object object) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Note = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        RateOfPenalty = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Law = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ChargeCode = new javax.swing.JTextField();
        jButtonSaveCharge = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        caseno = new javax.swing.JLabel();
        jButtonSaveChargeData = new javax.swing.JButton();
        jScrollChangeName = new javax.swing.JScrollPane();
        ChargeName = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ข้อมูลข้อหา");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 93, 179));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ข้อหา");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Note.setColumns(20);
        Note.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Note.setLineWrap(true);
        Note.setRows(5);
        Note.setTabSize(1);
        jScrollPane1.setViewportView(Note);

        RateOfPenalty.setColumns(20);
        RateOfPenalty.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        RateOfPenalty.setLineWrap(true);
        RateOfPenalty.setRows(5);
        RateOfPenalty.setTabSize(1);
        jScrollPane5.setViewportView(RateOfPenalty);

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel1.setText("อัตราโทษ");

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel3.setText("หมายเหตุ");

        Law.setColumns(20);
        Law.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        Law.setLineWrap(true);
        Law.setRows(3);
        Law.setTabSize(1);
        jScrollPane4.setViewportView(Law);

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel2.setText("กฎหมายที่อ้าง");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel4.setText("ข้อหา");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jLabel5.setText("รหัสข้อหา");

        ChargeCode.setEditable(false);
        ChargeCode.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N
        ChargeCode.setEnabled(false);

        jButtonSaveCharge.setBackground(java.awt.SystemColor.windowText);
        jButtonSaveCharge.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSaveCharge.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSaveCharge.setText("บันทึก");
        jButtonSaveCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChargeActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.SystemColor.windowText);
        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("เลือกข้อหา");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        caseno.setText("jLabel7");

        jButtonSaveChargeData.setBackground(java.awt.SystemColor.windowText);
        jButtonSaveChargeData.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButtonSaveChargeData.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSaveChargeData.setText("เพิ่มเป็นข้อหาใหม่");
        jButtonSaveChargeData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveChargeDataActionPerformed(evt);
            }
        });

        ChargeName.setColumns(20);
        ChargeName.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ChargeName.setLineWrap(true);
        ChargeName.setRows(1);
        ChargeName.setTabSize(1);
        jScrollChangeName.setViewportView(ChargeName);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane5)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(263, 263, 263))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonSaveCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSaveChargeData))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ChargeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(caseno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addComponent(jScrollChangeName))))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caseno)
                    .addComponent(jButton2)
                    .addComponent(jLabel5)
                    .addComponent(ChargeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollChangeName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveCharge)
                    .addComponent(jButtonSaveChargeData))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChargeActionPerformed
        // TODO add your handling code here:
   
         con=ConnectDatabase.connect();
         if(isInsert){
            String sql="INSERT INTO ChargeCase (ChargeCodeCase,ChargeNameCase,LawCase,RateOfPenaltyCase,NoteCase,ChargeCaseId)"+
            "VALUES (?,?,?,?,?,?)";
            System.out.println(sql);
            try {

                pst=con.prepareStatement(sql);

                pst.setString(1,ChargeCode.getText());
                pst.setString(2,ChargeName.getText());
               pst.setString(3,Law.getText());
            pst.setString(4,RateOfPenalty.getText());
             pst.setString(5,Note.getText());
                pst.setString(6,caseidch);
    
                              
//       JOptionPane.showMessageDialog(jPanel1,null, "Data Save", JOptionPane.INFORMATION_MESSAGE);

                
      int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการบันทึกข้อมูล", "ยืนยัน",
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
         try {
  
                 String sql="UPDATE ChargeCase SET "
                + "ChargeCodeCase=?,"
                + "ChargeNameCase=?,"
                + "LawCase=?,"
                + "RateOfPenaltyCase=?,"
                + "NoteCase=?"                        
                 + " Where ChargeCaseId=?";
            pst=con.prepareStatement(sql);    
            pst.setString(1,ChargeCode.getText());            
            pst.setString(2,ChargeName.getText());
            pst.setString(3,Law.getText());
            pst.setString(4,RateOfPenalty.getText());
             pst.setString(5,Note.getText());
             pst.setString(6,caseidch);
//          JSONObject data = new JSONObject();
//          data.put("ChargeName", ChargeName.getText());
//          data.put("ChargeCode", ChargeCode.getText());
          
  
         int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการบันทึกข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
               pst.executeUpdate(); 
               pst.close();
               System.out.println("SQLUP :"+sql);
          } 
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e); 
             System.out.println("SQL : "+pst);
        }    
         
         }
         if(typecase.equals("อาญา")){
              CrimesCaseEdit.ChargeNameCase.setText(ChargeName.getText());
           CrimesCaseEdit.jLabelChargeCode.setText(ChargeCode.getText());
     }
     else if(typecase.equals("จราจร")){
         TrafficEdit.ChargeNameCase.setText(ChargeName.getText());
        TrafficEdit.jLabelChargeCode.setText(ChargeCode.getText());
     }
         else if(typecase.equals("ชันสูตร")){
         IdentityEdit.ChargeNameCase.setText(ChargeName.getText());
        IdentityEdit.jLabelChargeCode.setText(ChargeCode.getText());
     } 
           setVisible(false);
        
        
    }//GEN-LAST:event_jButtonSaveChargeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       JFrame frame = new JFrame();
             JDialog dialog = new JDialog(frame);//frame is owner
             JFrame f = (JFrame)(dialog.getParent());               
             f.removeAll();
        ChargeOverView coList=new ChargeOverView(f);
        coList.pack();
       coList.setLocationRelativeTo(null);  
        coList.setVisible(true);
             
         
              //  rs.close();
             
       
          
                 
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonSaveChargeDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveChargeDataActionPerformed
        // TODO add your handling code here:
           con=ConnectDatabase.connect();

         String intAc="INSERT into Charge(ChargeCode,ChargeName,Law,RateOfPenalty,Note) values(?,?,?,?,?)  ";
//          String intCr="insert into CrimesCase(AnswerSuspect,AnswerAccuse) values(?,?) ";
     
            try {
              String idCh=ChargePageInsert.IdCharge();
           pst=con.prepareStatement(intAc);
           pst.setString(1, idCh);
            pst.setString(2,ChargeName.getText());
            pst.setString(3,Law.getText());
            pst.setString(4,RateOfPenalty.getText());
             pst.setString(5,Note.getText());
         
      
          
            int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการบันทึกข้อมูลลงข้อมูลพื้นฐาน", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                     pst.execute();
                     System.out.println("SQLLLLL : "+intAc);
                     pst.close();
                     RefreshCharge();
//        setVisible(false);
              }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);
            
        }
    }//GEN-LAST:event_jButtonSaveChargeDataActionPerformed
public static void RefreshCharge(){
 
   Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="select*from Charge ORDER BY ChargeCode DESC LIMIT 1";

        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                ChargeCode.setText(rs.getString("ChargeCode"));
            }
            
            
        } catch (Exception e) {
 
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
            java.util.logging.Logger.getLogger(ChargePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChargePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChargePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChargePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
//              new ChargePage().setVisible(true);

                 
            }
        });
    }
      public static String Checknull(Object input){
					if(input==null||input==""||input=="null") { return ""; }
					return input+"";
					}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ChargeCode;
    public static javax.swing.JTextArea ChargeName;
    public static javax.swing.JTextArea Law;
    public static javax.swing.JTextArea Note;
    public static javax.swing.JTextArea RateOfPenalty;
    private javax.swing.JLabel caseno;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonSaveCharge;
    private javax.swing.JButton jButtonSaveChargeData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollChangeName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
