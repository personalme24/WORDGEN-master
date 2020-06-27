/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.ChargeOverView.jTable1;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Computer
 */
public class TrafficBookOverview extends javax.swing.JDialog {

    /**
     * Creates new form CrimeBookOverview
     */
    public TrafficBookOverview() {
        initComponents();
           ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES E-inquiry)");
            pack();
            setLocationRelativeTo(null);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.setPreferredScrollableViewportSize(Toolkit.getDefaultToolkit().getScreenSize());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(4, 93, 179));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("สมุดคุมคดีจราจร");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addContainerGap(1042, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(25);
        jTable1.getTableHeader().setFont(new Font("TH SarabunPSK", Font.BOLD, 20));
        jTable1.getTableHeader().setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jButton1.setText("สร้างเอกสารสมุดคุมคดีอาญา");

        jButton2.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jButton2.setText("สร้างเอกสารสมุดคุมคดีจราจร");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        WriteExcelBookTraffic.crimebook();
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
            java.util.logging.Logger.getLogger(TrafficBookOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrafficBookOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrafficBookOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrafficBookOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrafficBookOverview().setVisible(true);
            }
        });
    }
 public void RefreshData(){
        try{
            
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
        String sql = "Select noperson,\n" +
                        "       GROUP_CONCAT(distinct CASE WHEN typeperson = 'ผู้กล่าวหา' THEN fullnameperson ELSE NULL END \n" +
                        "                     ) AS Accure,\n" +
                        "       GROUP_CONCAT(distinct CASE WHEN typeperson = 'ผู้ต้องหา' THEN fullnameperson ELSE NULL END\n" +
                        "                    ) AS Suspect, \n" +
                        "	   GROUP_CONCAT(distinct CASE WHEN typeperson = 'พยานและบุคคลอื่นๆ' THEN fullnameperson ELSE NULL END \n" +
                        "                    ) AS Witness,CrimeCase.*,ChargeCase.*,ActionsCaseData.*\n" +
                        "from CrimeCase \n" +
                        "left outer join Person on CrimeCase.caseid=Person.caseidperson\n" +
                        "left join ChargeCase on CrimeCase.caseid=ChargeCase.ChargeCaseId\n" +
                        "left join ActionsCaseData on CrimeCase.caseid=ActionsCaseData.ActionCaseId\n" +  
                        "where CrimeCase.CaseType='คดีจราจร'\n"+
                        "GROUP BY caseidperson ";

//                + "left join Person on Person.caseIdPerson = CrimeCase.CaseId "+getFilterCondition();

        ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Sqll : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("CaseId"));
            row.add(rs.getString("crimecasenoyear")); 
            String invest=rs.getString("Investigator_Result");
            if(invest.equals("อยู่ระหว่างสอบสวน")){
                
             row.add(rs.getString("Investigator_Result"));
            }
            else{ 
                invest="จำหน่าย"; 
             row.add(invest);
            } 
            row.add(rs.getString("CaseAcceptDate"));
            row.add(rs.getString("CaseRequestDate"));            
            row.add(rs.getString("Accure"));
            row.add(rs.getString("Suspect"));
            row.add(rs.getString("Witness"));
            row.add(rs.getString("ChargeNameCase"));
            row.add(rs.getString("ActionCrimesCase"));
            row.add(rs.getString("Investigator_Result"));
            row.add(rs.getString("Prosecutor_Result"));
            row.add(rs.getString("CourtResult"));
          
           
//            row.add(rs.getString("Investigator_Result"));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector();
        ColumnName.add("ลำดับ");
        ColumnName.add("เลขคดี/ปี"); 
        ColumnName.add("สถานะคดี");
        ColumnName.add("วันที่รับคำร้องทุกข์");
        ColumnName.add("วันที่รับแจ้งเหตุ");
        ColumnName.add("ผู้ต้องหา");
        ColumnName.add("ผู้กล่าวหา");
        ColumnName.add("พยานและบุคคลอื่นๆ");
        ColumnName.add("ข้อหา");     
        ColumnName.add("พฤติการณ์");
        ColumnName.add("ผลการสอบสวน");
        ColumnName.add("ผลคดีชั้นอัยการ");
        ColumnName.add("ผลคดีชั้นศาล");
  

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        }catch(Exception ex){
            ex.printStackTrace();
        }
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);                
        jTable1.getColumnModel().getColumn(1).setMinWidth(50);
        jTable1.getColumnModel().getColumn(2).setMinWidth(125);
        jTable1.getColumnModel().getColumn(3).setMinWidth(125);
        jTable1.getColumnModel().getColumn(4).setMinWidth(95);
         jTable1.getColumnModel().getColumn(5).setMinWidth(180);
        jTable1.getColumnModel().getColumn(6).setMinWidth(180);
        jTable1.getColumnModel().getColumn(7).setMinWidth(180);
        jTable1.getColumnModel().getColumn(8).setMinWidth(180); 
        jTable1.getColumnModel().getColumn(9).setMinWidth(180);
        jTable1.getColumnModel().getColumn(10).setMinWidth(140);
         jTable1.getColumnModel().getColumn(11).setMinWidth(140);
          jTable1.getColumnModel().getColumn(12).setMinWidth(140);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
