/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.AnswerPersonForm.AnswerDetail;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
/**
 *
 * @author Computer
 */
public class InjuryOrDie extends javax.swing.JDialog {

    /**
     * Creates new form AnswerPersonForm
     */
    String typecase,typePerson;
        Connection con=null;
    PreparedStatement pst=null;
     Date timeSend ;
  JDatePickerImpl DateSendInjuredOrDie;
    public InjuryOrDie(JFrame parrent,JSONObject datacase) {
    super(parrent,true);
   
        initComponents();
            ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry) BETA");
              try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
   
                 Font  labelother = font.deriveFont(1,22f);
                     jLabel3.setFont(labelother);
                     jLabel2.setFont(labelother);
                     jLabel5.setFont(labelother);
                     jLabel1.setFont(labelother);
                     jButton1.setFont(labelother);
 

               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
         AnswerTypeCase.setVisible(false);
          AnswerTypePerson.setVisible(false);
        typePerson=datacase.get("TypePerson")+"";
        typecase=datacase.get("TypeCase")+"";

            UtilDateModel model2 = new UtilDateModel();
            model2.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
          JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         DateSendInjuredOrDie = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
        DateSendInjuredOrDie.setTextEditable(true);
        DateSendInjuredOrDie.setBackground(Color.WHITE);
        jPanelDateSendInjuredOrDie.setLayout(new FlowLayout());
        jPanelDateSendInjuredOrDie.add(DateSendInjuredOrDie); 
        AnswerTypePerson.setText(typePerson);
        AnswerTypeCase.setText(typecase); 
        
//        String ote=AccusedForm.TimeSendInjuredOrDie.getText();
//        try{
//        if(ote.equals("") || ote.equals(null)|| ote.equals("null"))
//        {
//        
//        }
//        else{
//         
//                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//                 timeSend = timeFormat.parse(ote);}
//        }
//        catch(Exception e){
//        
//        }
    
        if(typePerson.equals("ผู้กล่าวหา")){
        CauseSendInjuredOrDie.setText( AccusedForm.CauseSendInjuredOrDie.getText());
        TimeSendInjuredOrDie.setValue(AccusedForm.TimeSendInjuredOrDie.getValue());
        WhereSendInjuredOrDie.setText( AccusedForm.WhereSendInjuredOrDie.getText());
        DateSendInjuredOrDie.getJFormattedTextField().setText(AccusedForm.DateSendInjuredOrDie.getJFormattedTextField().getText());

        }
        else if(typePerson.equals("ผู้ต้องหา")){
          CauseSendInjuredOrDie.setText( SuspectForm.CauseSendInjuredOrDie.getText());
        TimeSendInjuredOrDie.setValue(SuspectForm.TimeSendInjuredOrDie.getValue());
        WhereSendInjuredOrDie.setText( SuspectForm.WhereSendInjuredOrDie.getText());
        DateSendInjuredOrDie.getJFormattedTextField().setText( SuspectForm.DateSendInjuredOrDie.getText());
        }
       else if(typePerson.equals("พยานและบุคคลอื่น")){
          CauseSendInjuredOrDie.setText( WitnessForm.CauseSendInjuredOrDie.getText());
        TimeSendInjuredOrDie.setValue(WitnessForm.TimeSendInjuredOrDie.getValue());
        WhereSendInjuredOrDie.setText( WitnessForm.WhereSendInjuredOrDie.getText());
        DateSendInjuredOrDie.getJFormattedTextField().setText( WitnessForm.DateSendInjuredOrDie.getText());
        }
          JTextPopupMenu.addTo(CauseSendInjuredOrDie);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        CauseSendInjuredOrDie = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AnswerTypeCase = new javax.swing.JLabel();
        AnswerTypePerson = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        WhereSendInjuredOrDie = new javax.swing.JTextField();
        jPanelDateSendInjuredOrDie = new javax.swing.JPanel();
        Date date3=new Date();

        SpinnerDateModel sm3=new SpinnerDateModel(date3,null,null,Calendar.HOUR_OF_DAY);
        TimeSendInjuredOrDie = new javax.swing.JSpinner(sm3);
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        CauseSendInjuredOrDie.setColumns(20);
        CauseSendInjuredOrDie.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        CauseSendInjuredOrDie.setRows(5);
        CauseSendInjuredOrDie.setTabSize(1);
        jScrollPane1.setViewportView(CauseSendInjuredOrDie);

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("ตกลง");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("เหตุที่ต้องบาดเจ็บหรือตาย");

        AnswerTypeCase.setText("คดี");

        AnswerTypePerson.setText("ประเภทคำให้การ");

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("วันที่ส่งผู้บาดเจ็บหรือตาย");

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("่ส่งที่");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        WhereSendInjuredOrDie.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jPanelDateSendInjuredOrDie.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        javax.swing.GroupLayout jPanelDateSendInjuredOrDieLayout = new javax.swing.GroupLayout(jPanelDateSendInjuredOrDie);
        jPanelDateSendInjuredOrDie.setLayout(jPanelDateSendInjuredOrDieLayout);
        jPanelDateSendInjuredOrDieLayout.setHorizontalGroup(
            jPanelDateSendInjuredOrDieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );
        jPanelDateSendInjuredOrDieLayout.setVerticalGroup(
            jPanelDateSendInjuredOrDieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(TimeSendInjuredOrDie, "HH:mm");
        TimeSendInjuredOrDie.setEditor(timeEditor3);
        //jSpinner1.setValue(new Date());
        TimeSendInjuredOrDie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TimeSendInjuredOrDieKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("เวลา");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AnswerTypeCase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AnswerTypePerson))
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanelDateSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TimeSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(WhereSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(58, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnswerTypeCase)
                    .addComponent(AnswerTypePerson))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(WhereSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelDateSendInjuredOrDie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeSendInjuredOrDie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jButton1)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String sendInjuredTime=format.format(TimeSendInjuredOrDie.getValue());

        if(typePerson.equals("ผู้กล่าวหา")){
        AccusedForm.CauseSendInjuredOrDie.setText(CauseSendInjuredOrDie.getText());
        AccusedForm.DateSendInjuredOrDie.getJFormattedTextField().setText(DateSendInjuredOrDie.getJFormattedTextField().getText());
        AccusedForm.WhereSendInjuredOrDie.setText(WhereSendInjuredOrDie.getText());
        AccusedForm.TimeSendInjuredOrDie.setValue(TimeSendInjuredOrDie.getValue());


        }
        else if(typePerson.equals("ผู้ต้องหา")){
          SuspectForm.CauseSendInjuredOrDie.setText(CauseSendInjuredOrDie.getText());
        SuspectForm.DateSendInjuredOrDie.setText(DateSendInjuredOrDie.getJFormattedTextField().getText());
        SuspectForm.WhereSendInjuredOrDie.setText(WhereSendInjuredOrDie.getText());
        SuspectForm.TimeSendInjuredOrDie.setValue(TimeSendInjuredOrDie.getValue());
        }
        else if(typePerson.equals("พยานและบุคคลอื่น")){
       WitnessForm.CauseSendInjuredOrDie.setText(CauseSendInjuredOrDie.getText());
        WitnessForm.DateSendInjuredOrDie.setText(DateSendInjuredOrDie.getJFormattedTextField().getText());
        WitnessForm.WhereSendInjuredOrDie.setText(WhereSendInjuredOrDie.getText());
        WitnessForm.TimeSendInjuredOrDie.setValue(TimeSendInjuredOrDie.getValue());
        }
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TimeSendInjuredOrDieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TimeSendInjuredOrDieKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_TimeSendInjuredOrDieKeyReleased

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
            java.util.logging.Logger.getLogger(InjuryOrDie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InjuryOrDie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InjuryOrDie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InjuryOrDie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AnswerPersonForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnswerTypeCase;
    private javax.swing.JLabel AnswerTypePerson;
    public static javax.swing.JTextArea CauseSendInjuredOrDie;
    public static javax.swing.JSpinner TimeSendInjuredOrDie;
    public static javax.swing.JTextField WhereSendInjuredOrDie;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDateSendInjuredOrDie;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
