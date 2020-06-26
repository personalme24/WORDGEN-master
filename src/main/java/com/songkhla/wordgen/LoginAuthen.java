/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JProgressBar;

/**
 *
 * @author Computer
 */
public class LoginAuthen {
    public static void main(String[] args) {
        CreateTable.createNewTable();      
        CreateTable.InsertBaseData();
        CreateTable.AlterDataBase();
        InsertBaseData.Insert();
        InsertBaseData.insertTambon();
    Connection con=null;
    PreparedStatement pst=null;
        System.out.println(getMotherboardSerial());
     
    try{
        con = ConnectDatabase.connect();
          Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement(); 
            Statement stch = con.createStatement(); 
            
         String chname ="Select chargename from charge where chargename='ความตายเกิดจากถูกผู้อื่นทำให้ตาย'";
          ResultSet rsch = stch.executeQuery(chname);
          if(!rsch.next()){
            new BackgroundAddCharge().execute();
          }
               
                String sql ="Select * from User";
             ResultSet rs = stmt.executeQuery(sql);
              if(rs.next()){
                 if(rs.getString("StatusLogin").equals("0")){
                  LogInPage aa=new LogInPage();
                 SwingUtilities.updateComponentTreeUI(aa);
                    aa.pack();
                 aa.setVisible(true);
                 
                 }
                 else{
                 String sql2="Select * from User where serialnum='"+getMotherboardSerial()+"' and statuslogin='1'";
                 ResultSet rs2 = stmt2.executeQuery(sql2);
                 if(rs2.next()){
                 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                   
                  MainMenuWord mw=new MainMenuWord(); 
                  SwingUtilities.updateComponentTreeUI(mw);
                    mw.pack();
                  mw.setLocationRelativeTo(null);
                  mw.setVisible(true);
                  
                 
                 }
                 else{
//                 LogInPage.Username.setText(rs.getString("username"));
                 LogInPage aa=new LogInPage();
                 SwingUtilities.updateComponentTreeUI(aa);
                    aa.pack();
                 aa.setVisible(true);
                 
                 }
                 }
//             String st=rs.getString("StatusLogin");
//             if(st.equals("0")){
//             LogInPage lp=new LogInPage();
//             lp.setVisible(true);
//             
//             }
//             else{
//             MainMenuWord mw=new MainMenuWord();
//             mw.setVisible(true);
//             }
             }
             else{
             LogInPage lp=new LogInPage();
             SwingUtilities.updateComponentTreeUI(lp);
             lp.setVisible(true);
             }
             
            
            }
    catch(SQLException ex){
            ex.printStackTrace();
             JOptionPane.showMessageDialog(null, "Unable to make connection with DB"); 
        }
     catch (Exception ex) { 
                  Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
              }
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
    public static class BackgroundAddCharge extends SwingWorker<Void, Void> {

    private static final long SLEEP_TIME =10;
    private String text;
        private JProgressBar pb;
        private JLabel ab;
		private JDialog dialog;
//   public void Task() {
//       
//    }
//       public ProgressWorker(JProgressBar progress) {
//            this.progress = progress;
//        
            public BackgroundAddCharge() {
           
			addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
//					if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
						 if (dialog == null) {
								dialog = new JDialog();
                                                        ImageIcon img = new ImageIcon("./Master/WD.png");
                                                           dialog.setIconImage(img.getImage());
							dialog.setTitle("Processing");
                                                        
							dialog.setLayout(new GridBagLayout());
							dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
							GridBagConstraints gbc = new GridBagConstraints();
                                                        gbc.gridheight=20;
                                                        gbc.gridwidth = 10;
                                                         gbc.gridx = 10;
                                                            gbc.gridy = 20;
							gbc.insets = new Insets(20, 20, 20, 20);
							gbc.weightx = 1;
                                                        
							gbc.gridy = 0; 
                                                        ab=new JLabel("กำลังทำการปรับปรุงข้อมูล.....");
                                                        ab.setFont(new java.awt.Font("TH SarabunPSK", 1, 20));
							dialog.add(ab, gbc);
							pb = new JProgressBar();
                                                      
//							pb.setStringPainted(true);
//                                                        pb.setForeground(Color.blue);]
                                               
//                                                        pb.setMaximum(100);
//                                                        pb.setMinimum(0);
                                                        
							gbc.gridy = 1;
							dialog.add(ab, gbc);
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

        try { 

            for (int i = 1; i < 2; i++) {
//                x = x - i;
            setProgress((int)((i*100)/2)+1);
//        setProgress(i * (100 / N));
//				  setProgress(i);
            Thread.sleep(10);
//            Thread.sleep(SLEEP_TIME);// imitate a long-running task
     CreateTable.InsertAddCharge();
     
            }
        } catch (InterruptedException e) {
        }
//        setProgress(100);
        
        return null;
    }

    @Override
    public void done() {
                    if (dialog != null) {
				dialog.dispose();
			}
//            int rowcase=jTableCrime.getRowCount();
//                            if(rowcase ==0){
//            JOptionPane.showMessageDialog(null, "ไม่พบข้อมูลคดีในระบบ crimes");
//        }

    }
}/**/     
}
