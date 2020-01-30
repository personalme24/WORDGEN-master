/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import static com.songkhla.wordgen.LogInPage.getMotherboardSerial;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.json.JSONObject;

/**
 *
 * @author Computer
 */
public class LogInConfirm extends javax.swing.JDialog{

    /**
     * Creates new form LogInConfirm
     */
    public LogInConfirm(JFrame parrent) {
                super(parrent,true);

        initComponents();
      ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES) BETA");
            Username.setEnabled(false);
             Connection con=null;
             con = ConnectDatabase.connect();
             try{
           Statement stmt = con.createStatement();
             
            String sql3="Select * from User";
             ResultSet rs = stmt.executeQuery(sql3);
             if(rs.next()){
                 System.out.println("sadasd"+rs.getString("Username"));
                 Username.setText(rs.getString("Username"));
               
                 }
             }
             catch(SQLException sq){
             
             }
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
        jPanel2=new LoginPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        jButton1.setText("ตกลง");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Username.setEditable(false);
        Username.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("ชื่อผู้ใช้");

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("รหัสผ่าน");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("**กรุณาทำการเข้าสู่ระบบอีกครั้งเพื่อเชื่อมต่อข้อมูลคดีกับระบบ CRIMES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(Password))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Password))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        

       String password=new String(Password.getPassword());
       String username=Username.getText();
        if(username.equals("") || password.equals("")){
    JOptionPane.showMessageDialog(jPanel1, "กรุณากรอกข้อมูล", "แจ้งเตือน",
                 JOptionPane.OK_OPTION); 

        }
       else  if(username.equals("") && password.equals("")){
    JOptionPane.showMessageDialog(jPanel1, "กรุณากรอกชื่อผู้ใช้และรหัสผ่าน", "แจ้งเตือน",
                 JOptionPane.OK_OPTION); 

        }
       
       else{
           

       
             
         try { 
                if(username.equals("98UT01")&&password.equals("1234")){
                      String token="eZS5PPB9zCElUbubieWKoD9pctqrANqhXqK49z1250=";
                      System.out.println("");
                      MainMenuWord.tk=token;
                      CaseSelectOverView.jLabel2.setText("1");
                        JOptionPane.showMessageDialog(null, "เข้าสู่ระบบเรียบร้อยแล้วกรุณากดปุ่ม 'เชื่อมต่อข้อมูล' อีกครั้ง"); 
                      setVisible(false);
                    }
                    else{
                     JOptionPane.showMessageDialog(null, "รหัสผ่านไม่ถูกต้องกรุณากรอกใหม่");  
                    }
                 
            
//         String url=  "http://172.31.191.163:8383/wordgenauthen/?USER="+username+"&PASS="+password+"&Serial="+getMotherboardSerial();
//             System.out.println("url:"+url);
//                  String fff =sendGET(url);
//                  if(fff.equals("0")){
//                     JOptionPane.showMessageDialog(jPanel1, "ไม่พบการเชื่อมต่อ", "แจ้งเตือน",
//                 JOptionPane.OK_OPTION); 
//                  }
//                  else{
//                  JSONObject myResponse = new JSONObject(fff);
//                   String statusconnect=myResponse.getString("statusconnect");
//                  if(statusconnect.equals("0")){
//                    JOptionPane.showConfirmDialog(jPanel1, "รหัสผ่านไม่ถูกต้อง", "แจ้งเตือน",
//                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);               
//                  } 
//                  else if(statusconnect.equals("1")){
//                      String token=myResponse.getString("passwordwordgen");
//                      System.out.println("");
//                      MainMenuWord.tk=token;
//                      CaseSelectOverView.jLabel2.setText("1");
//                        JOptionPane.showMessageDialog(null, "เข้าสู่ระบบเรียบร้อยแล้วกรุณากดปุ่ม 'เชื่อมต่อข้อมูล' อีกครั้ง"); 
//                      setVisible(false);
//                  }
//                  }
                 
        } catch (Exception e) {
        }
             
            
   
       } 
    }//GEN-LAST:event_jButton1ActionPerformed
private static String sendGET(String GET_URL) {
    String a="";
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
            java.util.logging.Logger.getLogger(LogInConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInConfirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new LogInConfirm().setVisible(true);
            }
        });
    }
class LoginPanel extends JPanel {
    Image bg = new ImageIcon("./Master/LOgin.png").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
