/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.ActionPageInsert.ActionCrimes;
import static com.songkhla.wordgen.ActionPageInsert.ActionDetail;
import static com.songkhla.wordgen.ActionPageInsert.ActionNote;
import static com.songkhla.wordgen.ChargePage.ChargeCode;
import static com.songkhla.wordgen.ChargePage.ChargeName;
import static com.songkhla.wordgen.ChargePage.Law;
import static com.songkhla.wordgen.ChargePage.Note;
import static com.songkhla.wordgen.ChargePage.RateOfPenalty;
import static com.songkhla.wordgen.CrimesCaseEdit.EvidenceRecordCase;
import static com.songkhla.wordgen.CrimesCaseEdit.ListAsset;
import static com.songkhla.wordgen.CrimesCaseEdit.RecordInvestCase;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelActionCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelChargeCode;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelNumberAcc;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelNumberSus;
import static com.songkhla.wordgen.CrimesCaseEdit.jLabelNumberWitness;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextAccused;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextSuspect;
import static com.songkhla.wordgen.CrimesCaseEdit.jTextWitness;
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
public class ActionPage extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;
        boolean isInsert;
   String caseidac,typecase;
    
    /**
     * Creates new form ChangPage
     */
//    String chargeNo; 
    public ActionPage(JFrame parrent,JSONObject datain,JSONObject caseid) {
        super(parrent,true);
        initComponents();       
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
        con=ConnectDatabase.connect();
        typecase=caseid.get("typecase")+"";
        jLabel21.setVisible(false);
        jLabel20.setVisible(false);
        jScrollPane5.setVisible(false);
        jScrollPane6.setVisible(false);
             try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,36f);
                     jLabel6.setFont(sizedFont);
           
                 Font  labelother = font.deriveFont(1,22f);
                     jLabel5.setFont(labelother);
                     jLabel4.setFont(labelother);
                     jLabel2.setFont(labelother);
                     jLabel3.setFont(labelother);
                     jButton2.setFont(labelother);
                     ButtonAddAction.setFont(labelother);
                     ButtonAddAction1.setFont(labelother);
            
               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
        if(datain!=null){
            caseidac=datain.get("ActionCaseId")+"";
//            caseid= "" + datain.get("CaseId"); 
//            chargeNo=datain.get("ActionCode")+"";
            ActionCode.setText(datain.get("ActionCodeCase")+"");
            ActionCrimes.setText(datain.get("ActionCrimesCase")+"");
             ActionDetail.setText(datain.get("ActionDetailCase")+"");
              ActionNote.setText(datain.get("ActionNoteCase")+"");
               AnswerAccuser.setText(datain.get("AnswerAccuserCase")+"");
              AnswerSuspect.setText(datain.get("AnswerSuspectCase")+"");
             }
        else{
          caseidac=caseid.get("caseid")+"";
        isInsert=true; 
        ButtonAddAction.setEnabled(false);
        }
       
         ActionCode.getDocument().addDocumentListener(new DocumentListener() {
                           public void changedUpdate(DocumentEvent e) {
                                       ButtonAddAction.setEnabled(true);
                           }
                           public void removeUpdate(DocumentEvent e) {                              
//                                  SueSecDateT.setText(CalculateDateNextTimes(SueFirstEnd.getText()));
                                                   
                           }
                           public void insertUpdate(DocumentEvent e) {
                                           ButtonAddAction.setEnabled(true);

                           }
             }
             );
         JTextPopupMenu.addTo(ActionCrimes);
         JTextPopupMenu.addTo(ActionDetail);
         JTextPopupMenu.addTo(AnswerAccuser);
         JTextPopupMenu.addTo(AnswerSuspect);
         JTextPopupMenu.addTo(ActionNote);
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
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ActionDetail = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ButtonAddAction = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ActionNote = new javax.swing.JTextArea();
        ActionCode = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        AnswerAccuser = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        AnswerSuspect = new javax.swing.JTextArea();
        ButtonAddAction1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        ActionCrimes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ข้อมูลข้อหา");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("TH SarabunPSK", 0, 16)); // NOI18N
        setForeground(java.awt.Color.white);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(4, 93, 179));
        jPanel1.setPreferredSize(new java.awt.Dimension(744, 720));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("พฤติการณ์คดี");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("หมายเหตุ");

        ActionDetail.setColumns(10);
        ActionDetail.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ActionDetail.setLineWrap(true);
        ActionDetail.setRows(5);
        ActionDetail.setTabSize(1);
        ActionDetail.setWrapStyleWord(true);
        jScrollPane4.setViewportView(ActionDetail);

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("รายละเอียดพฤติการณ์คดี");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel4.setText("พฤติการณ์คดี");

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("รหัสพฤติการณ์");

        ButtonAddAction.setBackground(java.awt.SystemColor.windowText);
        ButtonAddAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        ButtonAddAction.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAddAction.setText("บันทึกข้อมูล");
        ButtonAddAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddActionActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("เลือกพฤติการณ์");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ActionNote.setColumns(20);
        ActionNote.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ActionNote.setLineWrap(true);
        ActionNote.setRows(2);
        ActionNote.setTabSize(1);
        ActionNote.setWrapStyleWord(true);
        jScrollPane2.setViewportView(ActionNote);

        ActionCode.setEditable(false);
        ActionCode.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ActionCode.setEnabled(false);
        ActionCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionCodeActionPerformed(evt);
            }
        });

        AnswerAccuser.setColumns(20);
        AnswerAccuser.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        AnswerAccuser.setLineWrap(true);
        AnswerAccuser.setRows(4);
        AnswerAccuser.setTabSize(1);
        AnswerAccuser.setWrapStyleWord(true);
        jScrollPane5.setViewportView(AnswerAccuser);

        jLabel21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel21.setText("คำให้การผู้กล่าวหา/พยาน");

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel20.setText("คำให้การผู้ต้องหา");

        AnswerSuspect.setColumns(20);
        AnswerSuspect.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        AnswerSuspect.setLineWrap(true);
        AnswerSuspect.setRows(4);
        AnswerSuspect.setTabSize(1);
        AnswerSuspect.setWrapStyleWord(true);
        AnswerSuspect.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane6.setViewportView(AnswerSuspect);

        ButtonAddAction1.setBackground(java.awt.SystemColor.windowText);
        ButtonAddAction1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        ButtonAddAction1.setForeground(new java.awt.Color(255, 255, 255));
        ButtonAddAction1.setText("เพิ่มเป็นพฤติการณ์ใหม่");
        ButtonAddAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAddAction1ActionPerformed(evt);
            }
        });

        ActionCrimes.setColumns(10);
        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        ActionCrimes.setLineWrap(true);
        ActionCrimes.setRows(1);
        ActionCrimes.setTabSize(1);
        jScrollPane7.setViewportView(ActionCrimes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(ActionCode, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(350, 350, 350)
                                        .addComponent(jButton2))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(602, 602, 602))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel20)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(753, 753, 753))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ButtonAddAction)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonAddAction1))
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(ActionCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonAddAction1)
                            .addComponent(ButtonAddAction))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddActionActionPerformed
        // TODO add your handling code here: 
         con=ConnectDatabase.connect();
     if(isInsert){
       String sql="INSERT INTO ActionsCaseData (ActionCodeCase,ActionCrimesCase,ActionDetailCase,AnswerSuspectCase,AnswerAccuserCase,ActionNoteCase,ActionCaseId)"+
            "VALUES (?,?,?,?,?,?,?)";
            System.out.println(sql);
            try {

                pst=con.prepareStatement(sql);

                pst.setString(1,ActionCode.getText());
                pst.setString(2,ActionCrimes.getText());
                pst.setString(3,ActionDetail.getText());
                pst.setString(4,AnswerSuspect.getText());
                pst.setString(5,AnswerAccuser.getText());
                pst.setString(6,ActionNote.getText());
                pst.setString(7,caseidac);
                              
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
//          String intCr="insert into CrimesCase(AnswerSuspect,AnswerAccuse) values(?,?) ";
       String updateAcc="UPDATE ActionsCaseData set "
                + "ActionCodeCase=?,"
                + "ActionCrimesCase=?,"
                + "ActionDetailCase=?,"
                + "AnswerSuspectCase=?,"
                + "AnswerAccuserCase=?,"
                + "ActionNoteCase=?"               
                 + " Where ActionCaseId=?";
            try {
           
           pst=con.prepareStatement(updateAcc);
           pst.setString(1, ActionCode.getText());
           pst.setString(2, ActionCrimes.getText());
           pst.setString(3, ActionDetail.getText());
           pst.setString(4, AnswerSuspect.getText());
           pst.setString(5, AnswerAccuser.getText()); 
             pst.setString(6, ActionNote.getText());
           pst.setString(7, caseidac);    
            int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการแก้ไขข้อมูล", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                     pst.execute();
                     System.out.println("SQLLLLL : "+updateAcc);
                     pst.close();
              } 
        } catch (Exception e) {
          JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);
            
        }
     }
     if(typecase.equals("อาญา")){
             CrimesCaseEdit.ActionCrimes.setText(ActionCrimes.getText());
        CrimesCaseEdit.jLabelActionCode.setText(ActionCode.getText());    
     }
     else if(typecase.equals("จราจร")){
         TrafficEdit.ActionCrimes.setText(ActionCrimes.getText());
        TrafficEdit.jLabelActionCode.setText(ActionCode.getText());
     }
     else if(typecase.equals("ชันสูตร")){
         IdentityEdit.ActionCrimes.setText(ActionCrimes.getText());
        IdentityEdit.jLabelActionCode.setText(ActionCode.getText());
     }  
        setVisible(false);
    }//GEN-LAST:event_ButtonAddActionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrame frame = new JFrame();
             JDialog dialog = new JDialog(frame);//frame is owner
             JFrame f = (JFrame)(dialog.getParent());               
             f.removeAll();
                   ActionList d = new ActionList(f);
                    d.pack();
                     d.setLocationRelativeTo(null);                   
                    d.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ButtonAddAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAddAction1ActionPerformed
        // TODO add your handling code here:
           String intAc="INSERT into ActionsCase(ActionCode,ActionCrimes,ActionDetail,ActionNote,AnswerAccuser,AnswerSuspect) values(?,?,?,?,?,?) ";
//          String intCr="insert into CrimesCase(AnswerSuspect,AnswerAccuse) values(?,?) ";
     
            try {
           String idAction=IdAction();
           pst=con.prepareStatement(intAc);
           pst.setString(1, idAction);
            pst.setString(2, ActionCrimes.getText());
           pst.setString(3, ActionDetail.getText());
           pst.setString(4, ActionNote.getText());  
           pst.setString(5, AnswerAccuser.getText()); 
           pst.setString(6, AnswerSuspect.getText());
         
      
          
            int response = JOptionPane.showConfirmDialog(jPanel2, "ต้องการบันทึกข้อมูลลงข้อมูลพื้นฐาน", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                     pst.execute();
                     System.out.println("SQLLLLL : "+intAc);
                     pst.close();
                     RefreshAction();
//        setVisible(false);
              }
        } catch (Exception e) {
          JOptionPane.showMessageDialog(jPanel1,e,null, JOptionPane.INFORMATION_MESSAGE);
            
        }
    
   
   
                                           
    }//GEN-LAST:event_ButtonAddAction1ActionPerformed

    private void ActionCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionCodeActionPerformed
        // TODO add your handling code here:
//       ButtonAddAction.setEnabled(true);
    }//GEN-LAST:event_ActionCodeActionPerformed
    public static void RefreshAction(){
 
   Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="select*from ActionsCase ORDER BY ActionCode DESC LIMIT 1";

        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                ActionCode.setText(rs.getString("ActionCode"));
            }
            
            
        } catch (Exception e) {
 
//            System.out.println(e);
        } 
 
 }
    public static String IdAction(){
         Connection con=null;
         
         con=ConnectDatabase.connect();
            String sqlId="Select max(ActionCode) ActionCode from ActionsCase";
        int id=0;
        try {
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sqlId);
            
            if (rs.next()) {
                id=rs.getInt("ActionCode"); 
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
            java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                          new ActionPage().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField ActionCode;
    public static javax.swing.JTextArea ActionCrimes;
    public static javax.swing.JTextArea ActionDetail;
    public static javax.swing.JTextArea ActionNote;
    public static javax.swing.JTextArea AnswerAccuser;
    public static javax.swing.JTextArea AnswerSuspect;
    private javax.swing.JButton ButtonAddAction;
    private javax.swing.JButton ButtonAddAction1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
