/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.json.simple.JSONObject;
import static com.songkhla.wordgen.ChargeOverViewMenu.jTableCharge;
import java.awt.Font;

/**
 *
 * @author Matazz
 */
public class ActionListMenu extends javax.swing.JDialog {

    /**
     * Creates new form ActionList
     */
    public ActionListMenu(JFrame parrent) {
                       super(parrent,true);

        initComponents();
//        jScrollPane3.getVerticalScrollBar().setUI(new CustomScrollBarUI());
         ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
            jTableAction.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
            jTableAction.getTableHeader().setOpaque(false);
        RefreshData();
       
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
        jLabel9 = new javax.swing.JLabel();
        ActionCode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ActionCrimes = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableAction = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(4, 93, 179));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ข้อมูลพฤติการณ์คดี");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setFont(new java.awt.Font("TH SarabunPSK", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel9.setText("รหัสพฤติการณ์คดี");

        ActionCode.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel10.setText("พฤติการณ์คดี");

        ActionCrimes.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N

        jButton3.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton3.setText("ค้นหา");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTableAction.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jTableAction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "รหัสพฤติการณ์คดี", "พฤติการณ์คดี"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableAction.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableAction.setFocusable(false);
        jTableAction.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableAction.setRowHeight(25);
        jTableAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableActionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableAction);

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("เพิ่ม");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton2.setText("แก้ไข");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton4.setText("ลบ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton5.setText("ล้างข้อมูล");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ActionCode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ActionCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(ActionCrimes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jButton6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("./Master/home.png"));
        jButton6.setText("เมนูหลัก");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(435, 435, 435)
                        .addComponent(jButton6))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableActionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableActionMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame fwit = (JFrame)(dialog.getParent());
        fwit.removeAll();
        ActionPageInsert lw=new ActionPageInsert(fwit,null);
        lw.pack();
        lw.setLocationRelativeTo(null);
        lw.setVisible(true);
        RefreshData();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
          JFrame frame = new JFrame();
             JDialog dialog = new JDialog(frame);//frame is owner
             JFrame f = (JFrame)(dialog.getParent());               
             f.removeAll();
        if(jTableAction.getSelectedRow()>=0){
           
            try{
                String ActionCode = jTableAction.getModel().getValueAt(jTableAction.getSelectedRow(), 0)+"";            
                String sql = "select * from ActionsCase where ActionCode='"+ActionCode+"'";
                   
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
//                System.out.println("dddddddddddddd:"+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                      data.put("ActionCode", rs.getString("ActionCode"));
                    data.put("ActionCrimes", rs.getString("ActionCrimes"));
                    data.put("ActionDetail", rs.getString("ActionDetail"));
                    data.put("AnswerAccuser", rs.getString("AnswerAccuser"));
                    data.put("AnswerSuspect", rs.getString("AnswerSuspect"));                    
                         data.put("ActionNote", rs.getString("ActionNote"));                    

                            ActionPageInsert chIn=new ActionPageInsert(f,data);
                             chIn.pack();
                             chIn.setLocationRelativeTo(null);
                            chIn.setVisible(true);    		
                }
                
                
                rs.close();
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        
       
        }else{

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          if(jTableAction.getSelectedRow()>=0){
            try{
                String ActionCode= jTableAction.getModel().getValueAt(jTableAction.getSelectedRow(), 0)+"";
                String sql = "Delete from ActionsCase WHERE ActionCode='"+ActionCode+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                stmt.executeUpdate(sql);

                //            rs.close();
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        ActionCode.setText("");
        ActionCrimes.setText("");
        RefreshData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        RefreshData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        MainMenuWord.closeAllDialogs();
    }//GEN-LAST:event_jButton6ActionPerformed
 public void RefreshData(){
        try{
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        String sql = "select * from ActionsCase "+ getFilterCondition();
        ResultSet rs = stmt.executeQuery(sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("ActionCode"));
            row.add(rs.getString("ActionCrimes"));
             row.add(rs.getString("ActionDetail"));
              row.add(rs.getString("ActionNote"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector();
        ColumnName.add("รหัส");
        ColumnName.add("พฤติการณ์");
        ColumnName.add("รายละเอียด");
        ColumnName.add("หมายเหตุ");
        jTableAction.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
//         jTableAction.getColumnModel().getColumn(0).setWidth(40);
//jTableAction.getColumnModel().getColumn(0).setMinWidth(40);
jTableAction.getColumnModel().getColumn(0).setMaxWidth(40); 
//jTableAction.getColumnModel().getColumn(2).setMaxWidth(200); 

    }
 private String getFilterCondition(){
        HashMap<String,String> filter = new HashMap<String,String>();
        if(ActionCrimes.getText().trim().length()>0){
            filter.put("ActionCrimes", ActionCrimes.getText().trim());
        }
         if(ActionCode.getText().trim().length()>0){
            filter.put("ActionCode", ActionCode.getText().trim());
        }
        String[] key = filter.keySet().toArray(new String[0]);
        String result="";
        for(int i=0;i<key.length;i++){
            if(i==0){
                result=" where ";
            }
            if(i==key.length-1){
                result+= " "+key[i]+" LIKE '%"+filter.get(key[i])+"%'";
            }else{
                result+= " "+key[i]+" LIKE "+filter.get(key[i])+" and ";
            }
            System.out.println(result);
        }
        
        return result;
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
            java.util.logging.Logger.getLogger(ActionListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActionListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActionListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActionListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ActionList().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ActionCode;
    private javax.swing.JTextField ActionCrimes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableAction;
    // End of variables declaration//GEN-END:variables
}
