/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;


import static com.songkhla.wordgen.ActionPageInsert.ActionCrimes;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseid;
import static com.songkhla.wordgen.CrimesCaseEdit.crimecaseno;
import static com.songkhla.wordgen.LoginAuthen.getMotherboardSerial;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicProgressBarUI;
//import org.apache.http.auth.UsernamePasswordCredentials;
import org.json.JSONObject;

/**
 *
 * @author Computer
 */
public class LogInPage extends javax.swing.JFrame {
     Connection con=null;
    PreparedStatement pst=null;
    public static String tk;
    /**
     * Creates new form LogInPage
     */
//    String username="",password="";
    public LogInPage() {
        initComponents();
          ImageIcon img = new ImageIcon("./Master/WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES E-inquiry) Version 2.0");
            setMaximumSize(new Dimension(1280, 760));
        setMinimumSize(new Dimension(1280, 760));
        setMaximizedBounds ( new Rectangle ( 1280, 760 ) );
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
           CreateTable.createNewTable();      
        CreateTable.InsertBaseData();
        InsertBaseData.Insert();
        InsertBaseData.insertTambon();
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
           con = ConnectDatabase.connect();
           Statement st = con.createStatement();
                      Statement stmt2 = con.createStatement();
             
            String sql3="Select * from User";
             ResultSet rs3 = st.executeQuery(sql3);
             if(rs3.next()){
                 String sql2="Select * from User where serialnum='"+getMotherboardSerial()+"'";
                 ResultSet rs2 = stmt2.executeQuery(sql2);
                 if(rs2.next()){
//                 PopupMessage pm=new PopupMessage(this);
//                 pm.setVisible(true);
                    Username.setText(rs2.getString("Username")); 
                 Username.setEditable(false);
                 jPanel3.setVisible(false);
                    
//                 JOptionPane.showConfirmDialog(jPanel1, "***ท่านได้ทำการเข้าสู่ระบบไว้แล้ว ไม่สามารถทำการเปลี่ยนแปลงชื่อผู้ใช้ได้\nหากต้องการเข้าใช้งานด้วยชื่อผู้ใช้อื่นให้ท่านทำการดาวน์โหลดโปรแกรมใหม่***", "แจ้งเตือน",
//                 JOptionPane.OK_OPTION); 
//                 PopupMessage pm=new PopupMessage(this);
//                 pm.setVisible(true);
                 }
                 
                 else{
                  
                 Username.setEditable(false);
                 Username.setText(rs3.getString("Username"));    
                  JOptionPane.showConfirmDialog(jPanel1, "***ท่านได้ทำการเข้าสู่ระบบไว้แล้ว ไม่สามารถทำการเปลี่ยนแปลงชื่อผู้ใช้ได้\nหากต้องการเข้าใช้งานด้วยชื่อผู้ใช้อื่นให้ท่านทำการดาวน์โหลดโปรแกรมใหม่***", "แจ้งเตือน",
                 JOptionPane.OK_OPTION); 
                 
                 }
                 rs2.close();
             }
             else{
             
             
             }
        
             rs3.close();
             stmt2.close();
        }
        catch(Exception ex){
         ex.printStackTrace();
        }
        addWindowListener(new java.awt.event.WindowAdapter() {
           @Override
           public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                   System.exit(0);
       //        }
           }
       });
//}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new BgPanel();
        jPanel2 = new LoginPanel();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        jPanel3 = new InformPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel1.setText("ชื่อผู้ใช้   :");

        Username.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("รหัสผ่าน :");

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("เข้าสู่ระบบ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Password.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Username)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Username)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ระบบสำนวนอิเล็กทรอนิกส์(CRIMES E-Inquiry) เวอร์ชั่น 2.0");

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Copyright © 2020 (ว1.008497) ศูนย์เทคโนโลยีสารสนเทศกลาง สำนักงานตำรวจแห่งชาติ All Rights Reserved.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(445, 445, 445)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        setVisible(false);
//        MainMenuWord d =new MainMenuWord();
//        d.setVisible(true); 

    Connection con=null;
    PreparedStatement pst=null;
    String  username=Username.getText();
       String password=new String(Password.getPassword());
  
        if(username.equals("") || password.equals("")){
    JOptionPane.showMessageDialog(jPanel1, "กรุณากรอกข้อมูล", "แจ้งเตือน",
                 JOptionPane.OK_OPTION); 

        }
       else  if(username.equals("") && password.equals("")){
    JOptionPane.showMessageDialog(jPanel1, "กรุณากรอกชื่อผู้ใช้และรหัสผ่าน", "แจ้งเตือน",
                 JOptionPane.OK_OPTION); 

        }
       
       else{
           
try{
        con = ConnectDatabase.connect();
             Statement stmt = con.createStatement();
            String sql ="Select * from User Where username='"+username+"' and password='"+password+"'";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){  
                 
                 String url=  "http://172.31.191.163:8383/wordgenauthen/?USER="+username+"&PASS="+password+"&Serial="+getMotherboardSerial();
             System.out.println("url:"+url);
                  String fff =sendGET(url); 
                  System.out.println("Status network:"+fff);
                  
                  if(fff.equals("0")){
                         System.out.println("Login");
                      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    MainMenuWord mwa=new MainMenuWord();
                     SwingUtilities.updateComponentTreeUI(mwa);
                     mwa.setVisible(true);
                     setVisible(false);
                  }
                  else{
             System.out.println("Login and Update");
               yourAttemptActionPerformed();
                  }


             }
             else{
             
         try { 
             
             System.out.println("FirstTimeeeeeeeeee");
         String url=  "http://172.31.191.163:8383/wordgenauthen/?USER="+username+"&PASS="+password+"&Serial="+getMotherboardSerial();
             System.out.println("url:"+url);
                  String fff =sendGET(url); 
                  System.out.println("Status network:"+fff);
                  
                  if(fff.equals("0")){
                     JOptionPane.showMessageDialog(jPanel1, "ไม่พบการเชื่อมต่อเครือข่าย", "แจ้งเตือน",
                 JOptionPane.OK_OPTION); 
                  }
                  else{
                 JSONObject myResponse = new JSONObject(fff);
                  String statusconnect=myResponse.getString("statusconnect");
//                   String statusconnect=myResponse.getString("statusconnect");
                  if(statusconnect.equals("0")){
                   
                    JOptionPane.showMessageDialog(null, "ไม่พบข้อมูลผู้ใช้ของท่านในระบบ CRIMES \nกรุณาตรวจสอบชื่อผู้ใช้และรหัสผ่าน\nหรือติดต่อ 1228 กด 2");  
                  } 
                 else if(statusconnect.equals("6")){
                   JOptionPane.showMessageDialog(null, "ชื่อผู้ใช้ของท่านยังไม่ได้รับสิทธิ์พนักงานสอบสวนหรือหัวหน้างานสอบสวน กรุณาติดต่อ 1228 กด 2");            
                  } 
                  else if(statusconnect.equals("1")){
//                         new BackgroundWorker().execute();
                         yourAttemptActionPerformed();
                  }
                  else if(statusconnect.equals("2")){
                        JOptionPane.showMessageDialog(null, "อายุการใช้งานชื่อผู้ใช้ของท่านในระบบ CRIMES หมดอายุ 12กรุณาติดต่อ 1228");            
                  }
                   else if(statusconnect.equals("5")){
                        JOptionPane.showMessageDialog(null, "พบข้อผิดพลาดเกี่ยวกับข้อมูล กรุณาติดต่อ 1228");            
                  }
                  }
//-------------------------Traning-------------------------------------------
//                    if(username.equals("98UT01")&&password.equals("1234")){
//                             yourAttemptActionPerformed();
//                    }
//                    else{
//                     JOptionPane.showMessageDialog(null, "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้องกรุณากรอกใหม่");  
//                    }
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ไม่พบการเชื่อมต่อ");            

        }
             }
            }
    catch(Exception ex){
            ex.printStackTrace();
        }
       }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new LogInPage().setVisible(true); 
            }
        });
    }
private static String sendGET(String GET_URL) {
    String a="";
                try{
		URL serverUrl = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) serverUrl.openConnection();      

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("Accept-Charset", "UTF-8");
                con.setConnectTimeout(5000);
                con.setReadTimeout(5000);
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
           
                catch (java.net.SocketTimeoutException e) {
                   System.out.println("Socket Error"+e.getMessage());

                    return "0";
                 } catch (IOException ie) {
                                     System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+ie.getMessage());

                    return "0";
                 }
	}
     private void yourAttemptActionPerformed() {


       
    new BackgroundWorker().execute();


    }
public class BackgroundWorker extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
		private JDialog dialog;
                        private JLabel ab;
            public BackgroundWorker() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
//					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
								dialog = new JDialog();
                                                                      JPanel jp=new JPanel();
//                                                    jp.setBackground(new java.awt.Color(255, 255, 255));
//                                                 ImageIcon loading = new ImageIcon("./Master/ajax-loader.gif");
                                            //     jp.setLayout(BorderLayout.CENTER);
                                                 jp.add(new JLabel("กำลังเชื่อมต่อข้อมูลกรุณารอสักครู่... ", JLabel.CENTER));
                                            //    frame.add(new JLabel("กำลังขอหมายเลขประจำวัน... ", loading, JLabel.CENTER));
                                                dialog.add(jp);
                                                dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                                                dialog.setMinimumSize(new Dimension(300, 100));
                                                dialog.setBackground(new java.awt.Color(255, 255, 255));
                                            //    frame.setSize(400, 300);
                                              

                                                dialog.pack();
                                                dialog.setLocationRelativeTo(null);
                                                dialog.setModal(true);
                                                JDialog.setDefaultLookAndFeelDecorated(true);
                                                dialog.setVisible(true);
                                                    
						}
//						pb.setValue(getProgress());
//					}
				}

			});
		}
    @Override
    public Void doInBackground() {
//        try{
//          for (int i = 0; i < 20; i++) {
////              setProgress(10);
//              System.out.println(""+i);
                insertData();
//            Thread.sleep(100);
//          }
//        }
//       catch (Exception e) {
//////
//                e.printStackTrace();
//////
//                }

        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
  try{
                    setVisible(false);
                     UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");    
                    MainMenuWord f=new MainMenuWord();
                    SwingUtilities.updateComponentTreeUI(f);
                    f.setVisible(true);
  }
  catch(Exception ex){
  
  }
//          System.out.println(text + " is done");
//        Toolkit.getDefaultToolkit().beep();
    }
}/**/


public void insertData(){
String  username=Username.getText();
       String password=new String(Password.getPassword());
     
        Connection con=null;
       PreparedStatement pst=null;
       PreparedStatement pst2=null; 
       PreparedStatement pst3=null; 
       PreparedStatement pst4=null; 

        try { 
              String url=  "http://172.31.191.163:8383/wordgenauthen/?USER="+username+"&PASS="+password+"&Serial="+getMotherboardSerial();
//                System.out.println("url2:"+url);
             String fff =sendGET(url);
             JSONObject myResponse = new JSONObject(fff);
//                
//                x = x - i;
//            setProgress((int)((i*100)/1)+1);
//            setProgress(i * (100 / 1));          
                    con = ConnectDatabase.connect();
             Statement stmt = con.createStatement();
            String sql ="Select * from User";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                 System.out.println("UpDATE LOGIN DATA");
               String updatePolice="UPDATE Police SET IdCardPolice=?,RankPolice=?,FirstName=?,LastName=?,"
                                 + "Birthday=?,Age=?,Tel=?,Position=?,RankPoliceFull=? where IdPolice='1'";
//               System.out.println("updatePolice"+updatePolice);
               String updateInvest="UPDATE InvestInformation SET InvestCardID=?,InvestRank=?,InvestName=?,"
                       + "InvestPosition=?,InvestBirthDay=?,InvestAge=?,InvestTel=?,InvestRankFull=?\n"        
                      + "where InvestId='1'"; 
               String updateUser="UPDATE User SET Username=?,Password=?,StatusLogin=?,DateLogin=?,SerialNum=?,PeopleCard=?\n"        
                      + "where iduser='1'";
                 String updateStation="UPDATE PoliceStation SET PoliceStartionCode=?,PoliceStaionName=?,PoliceStaionShort=?,StationAddress=?,StationTambon=?,"
                         + "StationAmphur=?,StationProvince=?,PostCode=?,BK=?,BH=?,PhonePolice=?,StationAddress=?,HeadRankFull=?,HeadRankShort=?,HeadName=?,HeadPosition=?,"    
                         + "CriminalCourt=?,JuvenileCourt=?,DistrictCourt=?,MilitaryCourt=?,AssetCourt=?\n"                         
                         + "where PoliceStartionId='1'";
                  Date d=new Date();
                             pst=con.prepareStatement(updatePolice);    
                              pst.setString(1,myResponse.getString("idcard"));
                              pst.setString(2,myResponse.getString("rank"));
                              pst.setString(3,myResponse.getString("firstname"));
                              pst.setString(4,myResponse.getString("lastname"));
                              pst.setString(5,ChangDate(myResponse.getString("birthday")));
                              pst.setString(6,myResponse.getString("age"));
                              pst.setString(7,myResponse.getString("mobilephone"));
                              pst.setString(8,myResponse.getString("position"));  
                              pst.setString(9,myResponse.getString("rankfull"));        
//                              pst.setString(1,"3100501488409");
//                              pst.setString(2,"พ.ต.ท.");
//                              pst.setString(3,"ศรันย์วิทย์");
//                              pst.setString(4,"สายศิลา");
//                              pst.setString(5,"27/02/2522");
//                              pst.setString(6,"40");
//                              pst.setString(7,"0898998888");
//                              pst.setString(8,"พงส.ผู้ชำนาญการ");  
//                              pst.setString(9,"พันตำรวจโท");
                              pst.executeUpdate();                
                              pst.close();
                              
                              pst2=con.prepareStatement(updateInvest);    
                              pst2.setString(1,myResponse.getString("idcard"));
                              pst2.setString(2,myResponse.getString("rank"));
//                              pst.setString(4,myResponse.getString("rank"));
                              pst2.setString(3,myResponse.getString("firstname")+" "+myResponse.getString("lastname"));
                              pst2.setString(4,myResponse.getString("position"));
                              pst2.setString(5,ChangDate(myResponse.getString("birthday")));
                              pst2.setString(6,myResponse.getString("age"));
                              pst2.setString(7,myResponse.getString("mobilephone"));
                              pst2.setString(8,myResponse.getString("rankfull"));     
//                              pst2.setString(1,"3100501488409");
//                              pst2.setString(2,"พ.ต.ท.");
////                              pst.setString(4,myResponse.getString("rank"));
//                              pst2.setString(3,"ศรันย์วิทย์"+" "+"สายศิลา");
//                              pst2.setString(4,"พงส.ผู้ชำนาญการ");
//                              pst2.setString(5,"27/02/2522");
//                              pst2.setString(6,"40");
//                              pst2.setString(7,"0898998888");
//                              pst2.setString(8,"พันตำรวจโท"); 
                              pst2.executeUpdate();                
                              pst2.close();
                              
                              pst3=con.prepareStatement(updateUser);
                              pst3.setString(1,username);
                              pst3.setString(2,password);
                              pst3.setString(3,"1");
                              pst3.setString(4,d+"");
                              pst3.setString(5,getMotherboardSerial());        
                              pst3.setString(6,myResponse.getString("idcard")); 
//                              pst3.setString(6,"22222"); 

//                              pst3.setString(8,myResponse.getString("passwordwordgen"));  
//                              pst3.setString(8,"eZS5PPB/9zCElUbubieWKoD9pctqrANqhXqK49z1250=");  
                             MainMenuWord.tk=myResponse.getString("passwordwordgen");
//                             MainMenuWord.tk="eZS5PPB9zCElUbubieWKoD9pctqrANqhXqK49z1250=";

                              pst3.executeUpdate();                
                              pst3.close();
                              
                              pst4=con.prepareStatement(updateStation); 
                              pst4.setString(1,myResponse.getString("orgcode"));
//                              pst4.setString(2,"70028");
                              pst4.setString(2,myResponse.getString("stationname").trim());
                              pst4.setString(3,myResponse.getString("initialname").trim());
                              pst4.setString(4,myResponse.getString("address"));
                              pst4.setString(5,myResponse.getString("tambon"));
                              pst4.setString(6,myResponse.getString("amphur"));                        
                             pst4.setString(7,myResponse.getString("province"));                        
                             pst4.setString(8,myResponse.getString("zipcode"));                        
                             pst4.setString(9,myResponse.getString("bk"));                        
                             pst4.setString(10,myResponse.getString("bh"));  
                             pst4.setString(11,myResponse.getString("mobilephone"));                                                     
                             pst4.setString(12,myResponse.getString("address"));                        
                             pst4.setString(13,myResponse.getString("headrankfull"));                        
                             pst4.setString(14,myResponse.getString("headpolicerank"));                        
                             pst4.setString(15,myResponse.getString("headpolicename")+" "+myResponse.getString("headpolicesurname"));                        
                             pst4.setString(16,myResponse.getString("headpositionfull"));   
                                pst4.setString(17,"");                        
                             pst4.setString(18,"");                        
                             pst4.setString(19,"");                        
                             pst4.setString(20,"");                        
                             pst4.setString(21,""); 
//                    --------------------------------Traning----------------------------------------------------
//                                pst4.setString(1,"70028");
////                              pst4.setString(2,"70028");
//                              pst4.setString(2,"สถานีตำรวจภูธรบ้านข่อย");
//                              pst4.setString(3,"สภ.บ้านข่อย");
//                              pst4.setString(4,"38 หมู่ 10");
//                              pst4.setString(5,"บ้านข่อย");
//                              pst4.setString(6,"เมืองลพบุรี");                        
//                             pst4.setString(7,"ลพบุรี");                        
//                             pst4.setString(8,"15000");                        
//                             pst4.setString(9,"ภ.จว.ลพบุรี");                        
//                             pst4.setString(10,"ภ.1");  
//                             pst4.setString(11,"0898998888");                                                     
//                             pst4.setString(12,"");                        
//                             pst4.setString(13,"พันตำรวจเอก");                        
//                             pst4.setString(14,"พ.ต.อ.");                        
//                             pst4.setString(15,"สมศักดิ์"+" "+"สมมุติ");                        
//                             pst4.setString(16,"ผกก.");  
//                                pst4.setString(17,"ศาลจังหวัดลพบุรี");                        
//                             pst4.setString(18,"ศาลเยาวชนและครอบครัวจังหวัดลพบุรี");                        
//                             pst4.setString(19,"ศาลแขวงลพบุรี");                        
//                             pst4.setString(20,"ศาลมณฑลทหารบกที่ 13 (ลพบุรี)");                        
//                             pst4.setString(21,"ศาลทรัพย์สินทางปัญญาและการค้าระหว่างประเทศกลาง"); 
                              pst4.executeUpdate();                
                              pst4.close();
                          
                              System.out.println("UpDATEdd LOGIN DATA");
             }
             else{
//                 String neww=re
           
//             String statusconnect=myResponse.getString("statusconnect"); 
     
                con=ConnectDatabase.connect();
     
              String insertPolice="INSERT INTO Police (IdPolice,IdCardPolice,RankPolice,FirstName,LastName,"
                      + "Birthday,Age,Tel,Position,RankPoliceFull) "           
                      + "VALUES (?,?,?,?,?,?,?,?,?,?)";
               String insertInvest="INSERT INTO InvestInformation (InvestId,InvestCardID,InvestRank,InvestName,"
                       + "InvestPosition,InvestBirthDay,InvestAge,InvestTel,InvestRankFull)\n"        
                      + "VALUES (?,?,?,?,?,?,?,?,?)"; 
               String insertUser="INSERT INTO User (iduser,Username,Password,StatusLogin,DateLogin,SerialNum,PeopleCard)\n"        
                      + "VALUES (?,?,?,?,?,?,?)";
                 String insertStation="INSERT INTO PoliceStation (PoliceStartionId,PoliceStartionCode,PoliceStaionName,PoliceStaionShort,StationAddress,StationTambon,"
                         + "StationAmphur,StationProvince,PostCode,BK,BH,PhonePolice,StationAddress,HeadRankFull,HeadRankShort,HeadName,HeadPosition,CriminalCourt,JuvenileCourt,DistrictCourt,MilitaryCourt,AssetCourt)\n"        
                      + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               try {
                              Date d=new Date();
                             pst=con.prepareStatement(insertPolice);
                              pst.setString(1,"1");
                              pst.setString(2,myResponse.getString("idcard"));
                              pst.setString(3,myResponse.getString("rank"));
                              pst.setString(4,myResponse.getString("firstname"));
                              pst.setString(5,myResponse.getString("lastname"));
                              pst.setString(6,ChangDate(myResponse.getString("birthday")));
                              pst.setString(7,myResponse.getString("age"));
                              pst.setString(8,myResponse.getString("mobilephone"));
                              pst.setString(9,myResponse.getString("position"));  
                              pst.setString(10,myResponse.getString("rankfull"));     
//                        ----------------------------Training------------------------------
//                              pst.setString(1,"1");
//                              pst.setString(2,"3100501488409");
//                              pst.setString(3,"พ.ต.ท.");
//                              pst.setString(4,"ศรันย์วิทย์");
//                              pst.setString(5,"สายศิลา");
//                              pst.setString(6,"27/02/2522");
//                              pst.setString(7,"40");
//                              pst.setString(8,"0898998888");
//                              pst.setString(9,"พงส.ผู้ชำนาญการ");  
//                              pst.setString(10,"พันตำรวจโท");   

                              pst.executeUpdate();                
                              pst.close();
                              
                               pst2=con.prepareStatement(insertInvest);    
                              pst2.setString(1,"1");
                              pst2.setString(2,myResponse.getString("idcard"));
                              pst2.setString(3,myResponse.getString("rank"));
                              pst2.setString(4,myResponse.getString("firstname")+" "+myResponse.getString("lastname"));
                              pst2.setString(5,myResponse.getString("position"));
                              pst2.setString(6,ChangDate(myResponse.getString("birthday")));
                              pst2.setString(7,myResponse.getString("age"));
                              pst2.setString(8,myResponse.getString("mobilephone"));
                              pst2.setString(9,myResponse.getString("rankfull"));  
//                              -------------------------Training---------------------------------
//                                pst2.setString(1,"1");
//                              pst2.setString(2,"3100501488409");
//                              pst2.setString(3,"พ.ต.ท.");
//                              pst2.setString(4,"ศรันย์วิทย์"+" "+"สายศิลา");
//                              pst2.setString(5,"พงส.ผู้ชำนาญการ");
//                              pst2.setString(6,"27/02/2522");
//                              pst2.setString(7,"40");
//                              pst2.setString(8,"0898998888");
//                              pst2.setString(9,"พันตำรวจโท");      
                              pst2.executeUpdate();                
                              pst2.close();
                              
                              pst3=con.prepareStatement(insertUser);
                              pst3.setString(1,"1");
                              pst3.setString(2,username);
                              pst3.setString(3,password);
                              pst3.setString(4,"1");
                              pst3.setString(5,d+"");
                              pst3.setString(6,getMotherboardSerial());        
                              pst3.setString(7,myResponse.getString("idcard")); 
//                              pst3.setString(7,"3100501488409"); 

//                              pst3.setString(8,myResponse.getString("passwordwordgen"));  
//                              pst3.setString(8,"eZS5PPB/9zCElUbubieWKoD9pctqrANqhXqK49z1250=");  
                             MainMenuWord.tk=myResponse.getString("passwordwordgen");
//                              MainMenuWord.tk="eZS5PPB9zCElUbubieWKoD9pctqrANqhXqK49z1250=";

                              pst3.executeUpdate();                
                              pst3.close();
                              
                              pst4=con.prepareStatement(insertStation);
                              pst4.setString(1,"1");
                              pst4.setString(2,myResponse.getString("orgcode"));
//                              pst4.setString(2,"70028");
                              pst4.setString(3,myResponse.getString("stationname").trim());
                              pst4.setString(4,myResponse.getString("initialname").trim());
                              pst4.setString(5,myResponse.getString("address"));
                              pst4.setString(6,myResponse.getString("tambon"));
                              pst4.setString(7,myResponse.getString("amphur"));                        
                             pst4.setString(8,myResponse.getString("province"));                        
                             pst4.setString(9,myResponse.getString("zipcode"));                        
                             pst4.setString(10,myResponse.getString("bk"));                        
                             pst4.setString(11,myResponse.getString("bh"));  
                             pst4.setString(12,myResponse.getString("mobilephone"));                                                     
                             pst4.setString(13,myResponse.getString("address"));                        
                             pst4.setString(14,myResponse.getString("headrankfull"));                        
                             pst4.setString(15,myResponse.getString("headpolicerank"));                        
                             pst4.setString(16,myResponse.getString("headpolicename")+" "+myResponse.getString("headpolicesurname"));                        
                             pst4.setString(17,myResponse.getString("headpositionfull"));
                              pst4.setString(18,"");                        
                             pst4.setString(19,"");                        
                             pst4.setString(20,"");                        
                             pst4.setString(21,"");                        
                             pst4.setString(22,""); 
//                            ----------------------------Traning--------------------------------
//                             pst4.setString(1,"1");
//                              pst4.setString(2,"70028");
////                              pst4.setString(2,"70028");                             
//                              pst4.setString(3,"สถานีตำรวจภูธรบ้านข่อย");
//                              pst4.setString(4,"สภ.บ้านข่อย");
//                              pst4.setString(5,"38 หมู่ 10");
//                              pst4.setString(6,"บ้านข่อย");
//                              pst4.setString(7,"เมืองลพบุรี");                        
//                             pst4.setString(8,"ลพบุรี");                        
//                             pst4.setString(9,"15000");                        
//                             pst4.setString(10,"ภ.จว.ลพบุรี");                        
//                             pst4.setString(11,"ภ.1");  
//                             pst4.setString(12,"0898998888");                                                     
//                             pst4.setString(13,"");                        
//                             pst4.setString(14,"พันตำรวจเอก");                        
//                             pst4.setString(15,"พ.ต.อ.");                        
//                             pst4.setString(16,"สมศักดิ์"+" "+"สมมุติ");                        
//                             pst4.setString(17,"ผกก.");   
//                              pst4.setString(18,"ศาลจังหวัดลพบุรี");                        
//                             pst4.setString(19,"ศาลเยาวชนและครอบครัวจังหวัดลพบุรี");                        
//                             pst4.setString(20,"ศาลแขวงลพบุรี");                        
//                             pst4.setString(21,"ศาลมณฑลทหารบกที่ 13 (ลพบุรี)");                        
//                             pst4.setString(22,"ศาลทรัพย์สินทางปัญญาและการค้าระหว่างประเทศกลาง"); 
                              pst4.executeUpdate();                
                              pst4.close();
                        
        } catch (Exception e) {
//             JOptionPane.showMessageDialog(jPanel1, "Cannot Save",null, JOptionPane.INFORMATION_MESSAGE);
             System.out.println("SQL : "+pst);
        }
        
      
             }
             
             
        } catch (Exception e) {
        }
//        setProgress(100);
        
      
}
class BgPanel extends JPanel {
    Image bg = new ImageIcon("./Master/BG03.png").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
class LoginPanel extends JPanel {
    Image bg = new ImageIcon("./Master/LOgin.png").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
class InformPanel extends JPanel {
    Image bg = new ImageIcon("./Master/252.png").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
class ProgressCircleUI extends BasicProgressBarUI {
  @Override public Dimension getPreferredSize(JComponent c) {
    Dimension d = super.getPreferredSize(c);
    int v = Math.max(d.width, d.height);
    d.setSize(v, v);
    return d;
  }
  @Override public void paint(Graphics g, JComponent c) {
    Insets b = progressBar.getInsets(); // area for border
    int barRectWidth  = progressBar.getWidth()  - b.right - b.left;
    int barRectHeight = progressBar.getHeight() - b.top - b.bottom;
    if (barRectWidth <= 0 || barRectHeight <= 0) {
      return;
    }

    // draw the cells
      Graphics2D g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setPaint(progressBar.getForeground());
    double degree = 360 * progressBar.getPercentComplete();
    double sz = Math.min(barRectWidth, barRectHeight);
    double cx = b.left + barRectWidth  * .5;
    double cy = b.top  + barRectHeight * .5;
    double or = sz * .5;
    double ir = or * .5; //or - 20;
      Shape inner = new Ellipse2D.Double(cx - ir, cy - ir, ir * 2, ir * 2);
    Shape outer = new Arc2D.Double(
        cx - or, cy - or, sz, sz, 90 - degree, degree, Arc2D.PIE);
    Area area = new Area(outer);
    area.subtract(new Area(inner));
    g2.fill(area);
    g2.dispose();

    // Deal with possible text painting
    if (progressBar.isStringPainted()) {
      paintString(g, b.left, b.top, barRectWidth, barRectHeight, 0, b);
    }
  }
}
public static String ChangDate(String date){
        String newFormatDate=null;
       try{   Calendar cal;
        SimpleDateFormat formatdate =new SimpleDateFormat("yyyyMMdd");  
         if(date == null || date.equals("null")|| date.equals("0")){
            newFormatDate="";
        }
         else{
        Date b=formatdate.parse(date);
         cal = Calendar.getInstance();
          cal.setTime(b); 
           SimpleDateFormat dateformat =new SimpleDateFormat("d/MM/yyyy");   
         newFormatDate=dateformat.format(cal.getTime());
         }
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    

}
     public static String getMotherboardSerial(){
		try
	    {
	        String result = null;
                 String nline = null;

	        Process p = Runtime.getRuntime().exec("wmic baseboard get product,Manufacturer,version,serialnumber");
	               BufferedReader input
	                = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF-8"));
	        String line;
	        while ((line = input.readLine()) != null)
	        {
	        	nline += line;
	        }
                  result= nline.replace(" ","");
        System.out.println("aa "+result);
	        input.close();
	        return result;
	    } catch (IOException ex)
	    {
	        ex.printStackTrace();
	        return null;
	    }
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    public static javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
