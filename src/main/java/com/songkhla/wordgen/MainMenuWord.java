/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;


import com.google.gson.JsonObject;
import static com.songkhla.wordgen.CaseSelectOverView.AcceptDate;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.json.simple.JSONObject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

/**
 *
 * @author Computer
 */
public class MainMenuWord extends javax.swing.JFrame {

    /**
     * Creates new form MainMenuWord
     */
    Connection con=null;
        PreparedStatement pst=null;
        public static String tk;
    JPanel [] panel1;
    public MainMenuWord() {
        initComponents();
        System.out.println("-------------------------------"+tk);
//        checkdata();
        ImageIcon img = new ImageIcon("./Master/WD.png");
        setIconImage(img.getImage());
       setTitle("ระบบสำนวนอิเล็กทรอนิกส์ (CRIMES E-inquiry) Version 1.1");

               try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,28f);
                     jLabel4.setFont(sizedFont);
                     jLabel3.setFont(sizedFont);
                     jLabel1.setFont(sizedFont);
                     jLabel18.setFont(sizedFont);
                     jLabel6.setFont(sizedFont);
                     jLabel16.setFont(sizedFont);
                     jLabel27.setFont(sizedFont);
                 Font  menuFont = font.deriveFont(24f);
                     jLabel11.setFont(menuFont);
                     jLabel17.setFont(menuFont);
                     jLabel19.setFont(menuFont);
                     jLabel9.setFont(menuFont);
                     jLabel12.setFont(menuFont);
                     jLabel30.setFont(menuFont);
                     jLabel20.setFont(menuFont);
                      jLabel23.setFont(menuFont);
                     jLabel25.setFont(menuFont);
                Font  labelother = font.deriveFont(1,22f);
                      jLabel2.setFont(labelother);
                      UserName.setFont(labelother);
                      jLabel13.setFont(labelother);

                 Font  footer = font.deriveFont(1,14f);
                      jLabel7.setFont(footer);

    
               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
      jLabel13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       jPanel9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       jPanel12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       jPanel14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       jPanel10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       jPanel11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       jPanel15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       profilemenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       policemenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       personmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       formmenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       howtomenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       howtomenu1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       howtomenu2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       jPanel16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       
       jPanel17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       
       jPanel18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       
      
//        DataCase tt=new DataCase();
//        tt.setToken("f");

//        CalculateDate();
        data();
//        setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenuWord.class.getResource("D://Master//user.png")));
        pack();
        setLocationRelativeTo(null); 
        panel1 = new JPanel[]{personmenu,formmenu,howtomenu};
        setMaximumSize(new Dimension(1280, 720));
        setMinimumSize(new Dimension(1280, 720));
        setMaximizedBounds ( new Rectangle ( 1280, 720 ) );
        setResizable(false);
         jLabel13.setVisible(true);
        con=ConnectDatabase.connect();
        CreateTable.createNewTable();      
        CreateTable.InsertBaseData();
        InsertBaseData.Insert();
        InsertBaseData.insertTambon();

//        InsertBaseData.insertTambon();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        policemenu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        personmenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        profilemenu = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        formmenu = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        howtomenu = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        howtomenu1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        howtomenu2 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new BgPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(4, 93, 179));
        jPanel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 500));

        policemenu.setBackground(new java.awt.Color(4, 93, 179));
        policemenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        policemenu.setPreferredSize(new java.awt.Dimension(155, 54));
        policemenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                policemenuMouseMoved(evt);
            }
        });
        policemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                policemenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                policemenuMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("./Master/police-station.png"));
        jLabel3.setText("ข้อมูลสถานีตำรวจ");
        jLabel3.setPreferredSize(new java.awt.Dimension(77, 33));

        javax.swing.GroupLayout policemenuLayout = new javax.swing.GroupLayout(policemenu);
        policemenu.setLayout(policemenuLayout);
        policemenuLayout.setHorizontalGroup(
            policemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(policemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        policemenuLayout.setVerticalGroup(
            policemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(policemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        personmenu.setBackground(new java.awt.Color(4, 93, 179));
        personmenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        personmenu.setPreferredSize(new java.awt.Dimension(155, 54));
        personmenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                personmenuMouseMoved(evt);
            }
        });
        personmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personmenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                personmenuMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("./Master/group (1).png"));
        jLabel1.setText("ข้อมูลบุคคล");

        javax.swing.GroupLayout personmenuLayout = new javax.swing.GroupLayout(personmenu);
        personmenu.setLayout(personmenuLayout);
        personmenuLayout.setHorizontalGroup(
            personmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        personmenuLayout.setVerticalGroup(
            personmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        profilemenu.setBackground(new java.awt.Color(4, 93, 179));
        profilemenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        profilemenu.setPreferredSize(new java.awt.Dimension(145, 54));
        profilemenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                profilemenuMouseMoved(evt);
            }
        });
        profilemenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilemenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilemenuMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("./Master/user.png"));
        jLabel4.setText("ข้อมูลผู้ใช้");

        javax.swing.GroupLayout profilemenuLayout = new javax.swing.GroupLayout(profilemenu);
        profilemenu.setLayout(profilemenuLayout);
        profilemenuLayout.setHorizontalGroup(
            profilemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        profilemenuLayout.setVerticalGroup(
            profilemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        formmenu.setBackground(new java.awt.Color(4, 93, 179));
        formmenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        formmenu.setPreferredSize(new java.awt.Dimension(149, 54));
        formmenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formmenuMouseMoved(evt);
            }
        });
        formmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formmenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formmenuMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formmenuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formmenuMouseReleased(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setIcon(new javax.swing.ImageIcon("./Master/document.png"));
        jLabel18.setText("แบบฟอร์ม");

        javax.swing.GroupLayout formmenuLayout = new javax.swing.GroupLayout(formmenu);
        formmenu.setLayout(formmenuLayout);
        formmenuLayout.setHorizontalGroup(
            formmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formmenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        formmenuLayout.setVerticalGroup(
            formmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        howtomenu.setBackground(new java.awt.Color(4, 93, 179));
        howtomenu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        howtomenu.setPreferredSize(new java.awt.Dimension(136, 54));
        howtomenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                howtomenuMouseMoved(evt);
            }
        });
        howtomenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                howtomenuMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                howtomenuMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("./Master/folder.png"));
        jLabel6.setText("ข้อมูลพื้นฐาน");

        javax.swing.GroupLayout howtomenuLayout = new javax.swing.GroupLayout(howtomenu);
        howtomenu.setLayout(howtomenuLayout);
        howtomenuLayout.setHorizontalGroup(
            howtomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howtomenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );
        howtomenuLayout.setVerticalGroup(
            howtomenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howtomenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        howtomenu1.setBackground(new java.awt.Color(4, 93, 179));
        howtomenu1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        howtomenu1.setPreferredSize(new java.awt.Dimension(136, 54));
        howtomenu1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                howtomenu1MouseMoved(evt);
            }
        });
        howtomenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                howtomenu1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                howtomenu1MouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon("./Master/folderopen.png"));
        jLabel16.setText("แฟ้มสำนวน");

        javax.swing.GroupLayout howtomenu1Layout = new javax.swing.GroupLayout(howtomenu1);
        howtomenu1.setLayout(howtomenu1Layout);
        howtomenu1Layout.setHorizontalGroup(
            howtomenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howtomenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        howtomenu1Layout.setVerticalGroup(
            howtomenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howtomenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        howtomenu2.setBackground(new java.awt.Color(4, 93, 179));
        howtomenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        howtomenu2.setPreferredSize(new java.awt.Dimension(136, 54));
        howtomenu2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                howtomenu2MouseMoved(evt);
            }
        });
        howtomenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                howtomenu2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                howtomenu2MouseExited(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon("./Master/transfer.png"));
        jLabel27.setText("เชื่อมต่อระบบ CRIMES");

        javax.swing.GroupLayout howtomenu2Layout = new javax.swing.GroupLayout(howtomenu2);
        howtomenu2.setLayout(howtomenu2Layout);
        howtomenu2Layout.setHorizontalGroup(
            howtomenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howtomenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );
        howtomenu2Layout.setVerticalGroup(
            howtomenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(howtomenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(personmenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(profilemenu, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(policemenu, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(formmenu, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(howtomenu, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(howtomenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(howtomenu2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(profilemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(policemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(personmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(howtomenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(howtomenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(howtomenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, new java.awt.Color(204, 204, 204)));
        jPanel4.setVerifyInputWhenFocusTarget(false);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel9MouseMoved(evt);
            }
        });
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("คดีอาญา");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("./Master/11.png"));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(4, 93, 179));

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ชื่อผู้ใช้ :");

        UserName.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        UserName.setForeground(new java.awt.Color(255, 255, 255));
        UserName.setText("Name");

        jLabel13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ออกจากระบบ");
        jLabel13.setIcon(new javax.swing.ImageIcon("./Master/logout.png"));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel12MouseMoved(evt);
            }
        });
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("คดีจราจร");

        jLabel15.setIcon(new javax.swing.ImageIcon("./Master/21.png"));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel14MouseMoved(evt);
            }
        });
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel14MouseExited(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("คดีชันสูตร");

        jLabel31.setIcon(new javax.swing.ImageIcon("./Master/51.png"));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel10MouseMoved(evt);
            }
        });
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ผัดฟ้องฝากขัง");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("./Master/61.png"));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel11MouseMoved(evt);
            }
        });
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel11MouseExited(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ประกัน");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon("./Master/41.png"));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel15MouseMoved(evt);
            }
        });
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("สมุดคุมคดีผู้ต้องหา");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon("./Master/91.png"));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel16MouseMoved(evt);
            }
        });
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel16MouseExited(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("สมุดคุมคดีอาญา");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon("./Master/B1.png"));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel17MouseMoved(evt);
            }
        });
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel17MouseExited(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("สมุดคุมคดีจราจร");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon("./Master/b2.png"));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel18MouseMoved(evt);
            }
        });
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel18MouseExited(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("สมุดคุมคดีชันสูตร");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon("./Master/B3.png"));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 51, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("TH SarabunPSK", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ระบบสำนวนอิเล็กทรอนิกส์(CRIMES E-Inquiry) เวอร์ชั่นทดลองใช้งาน Copyright © 2020 (ว1.008497) ศูนย์เทคโนโลยีสารสนเทศกลาง สำนักงานตำรวจแห่งชาติ All Right Reserve.");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 51, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
          JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
//         UIManager.setLookAndFeel("Nimbus");
 
        CrimesCaseOverView ccv =new CrimesCaseOverView(this); 
        ccv.pack();
        ccv.setLocationRelativeTo(null);
        ccv.setVisible(true);
    }//GEN-LAST:event_jPanel9MouseClicked

    private void formmenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formmenuMousePressed
            // TODO add your handling code here:


    }//GEN-LAST:event_formmenuMousePressed

    private void formmenuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formmenuMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_formmenuMouseReleased

    private void formmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formmenuMouseClicked
        // TODO add your handling code here:
//               JOptionPane.showMessageDialog(jPanel5, "เนื่องจากเป็นเวอร์ชันทดลอง จึงไม่สามารถทำการใช้งานหน้านี้เพื่อสร้างเอกสารแบบฟอร์มเปล่าได้\nผู้ใช้จะสามารถใช้งานได้ในเวอร์ชันจริง", "แจ้งเตือน",
//                        JOptionPane.OK_OPTION); 
         JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
    ReportAllForm rf =new ReportAllForm(this,null);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setVisible(true);
    }//GEN-LAST:event_formmenuMouseClicked

    private void howtomenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenuMouseMoved
        // TODO add your handling code here:
        setPanelBackground(howtomenu);
    }//GEN-LAST:event_howtomenuMouseMoved

    private void howtomenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenuMouseExited
        // TODO add your handling code here:
        resetPanelBackground(howtomenu);
    }//GEN-LAST:event_howtomenuMouseExited

    private void formmenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formmenuMouseMoved
        // TODO add your handling code here:
        setPanelBackground(formmenu);
    }//GEN-LAST:event_formmenuMouseMoved

    private void formmenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formmenuMouseExited
        // TODO add your handling code here:
         resetPanelBackground(formmenu);
    }//GEN-LAST:event_formmenuMouseExited

    private void personmenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personmenuMouseMoved
        // TODO add your handling code here:
         setPanelBackground(personmenu);
    }//GEN-LAST:event_personmenuMouseMoved

    private void personmenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personmenuMouseExited
        // TODO add your handling code here:
        resetPanelBackground(personmenu);
    }//GEN-LAST:event_personmenuMouseExited

    private void policemenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_policemenuMouseMoved
        // TODO add your handling code here:
         setPanelBackground(policemenu);
    }//GEN-LAST:event_policemenuMouseMoved

    private void policemenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_policemenuMouseExited
        // TODO add your handling code here:
                resetPanelBackground(policemenu);

    }//GEN-LAST:event_policemenuMouseExited

    private void profilemenuMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilemenuMouseMoved
        // TODO add your handling code here:
                 setPanelBackground(profilemenu);

    }//GEN-LAST:event_profilemenuMouseMoved

    private void profilemenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilemenuMouseExited
        // TODO add your handling code here:
            resetPanelBackground(profilemenu);
    }//GEN-LAST:event_profilemenuMouseExited

    private void profilemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilemenuMouseClicked
        // TODO add your handling code here:
            
          try{
             
                String sql="select * from Police";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("ExSql : "+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("IdPolice", rs.getString("IdPolice"));
                    data.put("IdCardPolice", rs.getString("IdCardPolice"));
                    data.put("RankPolice", rs.getString("RankPolice"));
                    data.put("FirstName", rs.getString("FirstName"));
                    data.put("LastName", rs.getString("LastName"));
                    data.put("Position", rs.getString("Position"));
                    data.put("RankPoliceFull", rs.getString("RankPoliceFull"));

                    PolisForm pf =new PolisForm(this,data);
                     pf.pack();
                    pf.setLocationRelativeTo(null);
                    pf.pack();
                    pf.setLocationRelativeTo(null);
                    pf.setVisible(true);
                }
                else{
                     PolisForm pf =new PolisForm(this,null);
                      pf.pack();
                pf.setLocationRelativeTo(null);
                pf.pack();
                pf.setLocationRelativeTo(null);
                    pf.setVisible(true);
                }

                rs.close();
                stmt.close();
  
            }catch(Exception ex){
                ex.printStackTrace();

            }
          data() ;
//      PolisForm pf =new PolisForm(this,null);
//                    pf.setVisible(true);
        
    }//GEN-LAST:event_profilemenuMouseClicked
   
//    private void checkdata(){
//      String sql= "select * from Police";
//            Connection con = ConnectDatabase.connect();
//          
//            try { 
//                Statement stmt = con.createStatement();
//                 ResultSet rs = stmt.executeQuery(sql);
//              if(rs.next()== false){
//               
//                     PolisForm a= new PolisForm(this, null);
//                     a.setVisible(true);
//                
//            }
//             
//    } catch (Exception e) {
//    }
//    
//    
//    }
    private void data() 
{       String a;
        String name="";
            String sql= "select * from Police";
            Connection con = ConnectDatabase.connect();
          
            try { 
                Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(sql);
              if(rs.next()){
                       
                      name=rs.getString("RankPolice")+" "+rs.getString("FirstName")+" "+rs.getString("LastName");
                            
                            Data d =new Data();
                            a=rs.getString("FirstName");
//                            System.out.print(a);
        d.setPolicName(a); 
                
            }
             
    } catch (Exception e) {
    }
            UserName.setText(name);

}
    private void policemenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_policemenuMouseClicked
        // TODO add your handling code here:
        
                
          try{
             
                String sql="select * from PoliceStation";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("ExSql : "+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                     data.put("PoliceStartionId", rs.getString("PoliceStartionId"));
                    data.put("PoliceStartionCode", rs.getString("PoliceStartionCode"));
                    data.put("PoliceStaionName", rs.getString("PoliceStaionName"));
                    data.put("PoliceStaionShort", rs.getString("PoliceStaionShort"));
                    data.put("StationAddress", rs.getString("StationAddress"));
                    data.put("StationAmphur", rs.getString("StationAmphur"));
                       data.put("StationProvince", rs.getString("StationProvince"));
                    data.put("BK", rs.getString("BK"));
                    data.put("BH", rs.getString("BH"));
                    data.put("Fax", rs.getString("Fax"));
                    data.put("TelStation", rs.getString("TelStation"));
                       data.put("PhonePolice", rs.getString("PhonePolice"));
                    data.put("HeadName", rs.getString("HeadName"));
                    data.put("HeadPosition", rs.getString("HeadPosition"));
                    data.put("HeadWorkName", rs.getString("HeadWorkName"));
                    data.put("HeadWorkPosition", rs.getString("HeadWorkPosition"));
                       data.put("CriminalCourt", rs.getString("CriminalCourt"));
                    data.put("JuvenileCourt", rs.getString("JuvenileCourt"));
                    data.put("DistrictCourt", rs.getString("DistrictCourt"));
                    data.put("MilitaryCourt", rs.getString("MilitaryCourt"));
                    data.put("AssetCourt", rs.getString("AssetCourt"));
                       data.put("LocationOfDrug", rs.getString("LocationOfDrug"));
                    data.put("CheckGun", rs.getString("CheckGun"));
                    data.put("CheckDrug", rs.getString("CheckDrug"));
                    data.put("CheckOtherExhibit", rs.getString("CheckOtherExhibit"));
                    data.put("CauseSerious", rs.getString("CauseSerious"));
                       data.put("ProvincProsecutor", rs.getString("ProvincProsecutor"));
                    data.put("ProvincProsecutorCh", rs.getString("ProvincProsecutorCh"));
                    data.put("THNumBook", rs.getString("THNumBook"));
                    data.put("ProtectChild", rs.getString("ProtectChild"));
                    data.put("StationMoo", rs.getString("StationMoo"));
                    data.put("StationTambon", rs.getString("StationTambon"));
                    data.put("Postcode", rs.getString("Postcode"));                 
                    data.put("HeadRankFull", rs.getString("HeadRankFull"));
                    data.put("HeadRankShort", rs.getString("HeadRankShort"));
                    data.put("HeadWorkRankFull", rs.getString("HeadWorkRankFull"));
                    data.put("HeadWorkRankShort", rs.getString("HeadWorkRankShort"));       
                            StationForm sf = new StationForm(this,data);
                             sf.pack();
                             sf.setLocationRelativeTo(null);
                             sf.setVisible(true);
                }
                else{
                     StationForm sf = new StationForm(this,null);
                      sf.pack();
                      sf.setLocationRelativeTo(null);
                     sf.setVisible(true);
                }

                rs.close();
                stmt.close();
  
            }catch(Exception ex){
                ex.printStackTrace();

            }

    }//GEN-LAST:event_policemenuMouseClicked

    private void personmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personmenuMouseClicked
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame po = (JFrame)(dialog.getParent());
        po.removeAll();
         PersonOverView ps = new PersonOverView(po);
          ps.pack();
            ps.setLocationRelativeTo(null);
        ps.setVisible(true);
    }//GEN-LAST:event_personmenuMouseClicked

    private void howtomenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenuMouseClicked
        // TODO add your handling code here:
    
           JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
        BaseDataMenu iv=new BaseDataMenu(in);
         iv.pack();
            iv.setLocationRelativeTo(null);
        iv.setVisible(true);
    }//GEN-LAST:event_howtomenuMouseClicked

    private void howtomenu1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenu1MouseMoved
        // TODO add your handling code here:
          setPanelBackground(howtomenu1);
    }//GEN-LAST:event_howtomenu1MouseMoved

    private void howtomenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenu1MouseClicked
        // TODO add your handling code here:
//         resetPanelBackground(howtomenu1);
 File f3=new File("./สำนวนอิเล็กทรอนิกส์");
          f3.mkdirs();
             System.out.print(f3);
        System.out.print("folder created");
         Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์");
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found :"+iae);
        }
    }//GEN-LAST:event_howtomenu1MouseClicked

    private void howtomenu1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenu1MouseExited
        // TODO add your handling code here:
                 resetPanelBackground(howtomenu1);
    }//GEN-LAST:event_howtomenu1MouseExited

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
          TrafficOverView tf = new TrafficOverView(this);
         tf.pack();
         tf.setLocationRelativeTo(null);
         tf.setVisible(true);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel9);
    }//GEN-LAST:event_jPanel9MouseMoved

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel9);
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
         IdentityView idt = new IdentityView(this);
         idt.pack();
         idt.setLocationRelativeTo(null);
        idt.setVisible(true);
        
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel10);
    }//GEN-LAST:event_jPanel10MouseMoved

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
         JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
           SueCrimesOverview sf=new SueCrimesOverview(in);
         sf.pack();
            sf.setLocationRelativeTo(null);
        sf.setVisible(true);
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel10);
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel11);
    }//GEN-LAST:event_jPanel11MouseMoved

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
          JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame);//frame is owner
        JFrame in = (JFrame)(dialog.getParent());
        in.removeAll();
         BailCrimesForm bcf=new BailCrimesForm(in);
         bcf.pack();
            bcf.setLocationRelativeTo(null);
        bcf.setVisible(true);
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel11);
    }//GEN-LAST:event_jPanel11MouseExited

    private void jPanel15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel15);
    }//GEN-LAST:event_jPanel15MouseMoved

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
        SuspectBookOverview bcf=new SuspectBookOverview();
//         bcf.pack();
//            bcf.setLocationRelativeTo(null);
        bcf.setVisible(true);
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel15);
    }//GEN-LAST:event_jPanel15MouseExited

    private void jPanel16MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel16);
    }//GEN-LAST:event_jPanel16MouseMoved

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
        CrimeBookOverview co=new CrimeBookOverview();
        co.setVisible(true);
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel16);
        
    }//GEN-LAST:event_jPanel16MouseExited

    private void jPanel17MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel17);
    }//GEN-LAST:event_jPanel17MouseMoved

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
        TrafficBookOverview tr=new TrafficBookOverview();
        tr.setVisible(true);
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel17);
    }//GEN-LAST:event_jPanel17MouseExited

    private void jPanel18MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseMoved
        // TODO add your handling code here:
         setPanel(jPanel18);
    }//GEN-LAST:event_jPanel18MouseMoved

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        // TODO add your handling code here:
          DeadBookOverview db=new DeadBookOverview();
        db.setVisible(true);
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel18);
    }//GEN-LAST:event_jPanel18MouseExited

    private void jPanel12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel12);
    }//GEN-LAST:event_jPanel12MouseMoved

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel12);
    }//GEN-LAST:event_jPanel12MouseExited

    private void jPanel14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseMoved
        // TODO add your handling code here:
        setPanel(jPanel14);
    }//GEN-LAST:event_jPanel14MouseMoved

    private void jPanel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseExited
        // TODO add your handling code here:
        resetPanel(jPanel14);
    }//GEN-LAST:event_jPanel14MouseExited

    private void howtomenu2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenu2MouseMoved
        // TODO add your handling code here:
         setPanelBackground(howtomenu2);
    }//GEN-LAST:event_howtomenu2MouseMoved

    private void howtomenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenu2MouseClicked
        // TODO add your handling code here:
        CaseSelectOverView cs=new CaseSelectOverView(this);
        cs.pack();
        cs.setLocationRelativeTo(null);
        cs.setVisible(true);
    }//GEN-LAST:event_howtomenu2MouseClicked

    private void howtomenu2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_howtomenu2MouseExited
        // TODO add your handling code here:
         resetPanelBackground(howtomenu2);
    }//GEN-LAST:event_howtomenu2MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
            // TODO add your handling code here:
          String sqlUpdate="UPDATE User set StatusLogin='0' where IdUser='1'";
          try{  
          pst=con.prepareStatement(sqlUpdate);
               int response = JOptionPane.showConfirmDialog(jPanel5, "ต้องการออกจากระบบ", "ยืนยัน",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                     pst.execute();
                     pst.close(); 
//                     con.close();
                     setVisible(false);
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                    LogInPage lp=new LogInPage();
                    SwingUtilities.updateComponentTreeUI(lp);
                     lp.setVisible(true);
                    

              } 
         
          
          }
         catch(Exception ex){
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jLabel13MouseClicked
    public void setPanelBackground (JPanel jp){
        jp.setBackground(new Color(0,102,255));
    }
     public void resetPanelBackground (JPanel jp){
        jp.setBackground(new Color(4,93,179));
    }
     public void setPanel (JPanel jp){
 //   jp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153), null, null));
  //      jp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
  jp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, new java.awt.Color(204, 204, 204)));
    }
      public void resetPanel (JPanel jp){
        jp.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    }
    /**
     * @param args the command line arguments
     */
//     private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
//        try {
//            // TODO add your handling code here:
//            Image img=ImageIO.read(getClass().getResource("ur path"));
//            this.setIconImage(img);
//        } catch (IOException ex) {
//
//        }
//     }
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
            java.util.logging.Logger.getLogger(MainMenuWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuWord().setVisible(true);
         
               
            }
        });
    }
         public void CalculateDate(){
            try{
            Connection con = ConnectDatabase.connect();
             Statement stmt = con.createStatement();
            String sqlListSuspect ="Select ArrestDateTime,CourtSuspect,Test2,NoPerson,caseIdPerson from Person where TypePerson='ผู้ต้องหา'";
             ResultSet rs = stmt.executeQuery(sqlListSuspect);
              int dateArr=0;
              String arrDateTime="";
              String noPer="";
              String caseid="";
              int total=0;
 
                    while(rs.next()){
                         arrDateTime=rs.getString("ArrestDateTime");
//                   dateArr=Integer.valueOf(aa);

                        if(rs.getString("CourtSuspect").equals("ศาลแขวง")){
                        total=6;}
                        else if(rs.getString("CourtSuspect").equals("ศาลอาญา")){
                        total=12;
                        }
                         else if(rs.getString("CourtSuspect").equals("อุจฉกรรจ์")){
                        total=12;
                        }

                        noPer=rs.getString("NoPerson");
                        caseid=rs.getString("caseIdPerson");
                           Calendar cal;
                        if(arrDateTime!=null || !"".equals(arrDateTime)){
                            System.out.println("DateOld : " +arrDateTime); 
                            Locale lc = new Locale("th","TH");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm",lc);
                        Date date = sdf.parse(arrDateTime);
                         cal = Calendar.getInstance();
                        cal.setTime(date);                      
                        cal.add(Calendar.HOUR, +48);
                         SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm",lc);
                          SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy",lc);

//                        System.out.println("DateNew : "+dateFormat.format(cal.getTime()));
//                        String d1=dateFormat.format(cal.getTime());
                       
                        SimpleDateFormat  format = new SimpleDateFormat("dd/MM/yyyy HH:mm",lc);  
                        String d2Day=dateFormat.format(new Date());
                        String d24= dateFormat.format(cal.getTime());
                        Date dateTo =null;
                        Date d24Hr=null;
                         dateTo=format.parse(d2Day);
                          d24Hr=format.parse(d24);

//                       format.format(d24);

//                         dateFormat.format(dt2);
                         System.out.println("DateNew : "+d24Hr);
                        System.out.println("DateToday : "+dateTo);

                            long diff = d24Hr.getTime() - dateTo.getTime();
                           long diffSeconds = diff / 1000 % 60;  
                            long diffMinutes = diff / (60 * 1000) % 60; 
                            long diffHours = diff / (60 * 60 * 1000);
                            int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
                            System.out.println("Time in seconds: " + diffSeconds + " seconds.");         
                            System.out.println("Time in minutes: " + diffMinutes + " minutes.");         
                            System.out.println("Time in hours: " + diffHours + " hours."); 
                             System.out.println("Time in Day: " + diffDays + " Days."); 

                        if(diffDays<=0 && diffHours <=0){
                           String updateSue="Update Person set SueFirst='1',SueFirstDate='"+dateFormat2.format(cal.getTime())+"',SueFirstTotal='"+total+"' where ArrestDateTime='"+arrDateTime+"'";
//                           String insertSue="insert into SueCrimeCase(SueFirst,SueFirstDate,SueFirstTotal,SueCaseId,SueSuspectId) values('1','"+dateFormat2.format(cal.getTime())+"','5','"+caseid+"','"+noPer+"')";

                             pst=con.prepareStatement(updateSue);
//                             pst=con.prepareStatement(insertSue);                                
                             pst.executeUpdate();
                             pst.close();
                        }
                        }
                    }
                 
                  
          }
            catch(Exception ex){
            ex.printStackTrace();
        }
        }
       public static void closeAllDialogs()
{
    Window[] windows = getWindows();

    for (Window window : windows)
    {
        if (window instanceof JDialog)
        {
            window.dispose();
        }
    }
}

class BgPanel extends JPanel {
    Image bg = new ImageIcon("./Master/EDOCFINAL.png").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserName;
    private javax.swing.JPanel formmenu;
    private javax.swing.JPanel howtomenu;
    private javax.swing.JPanel howtomenu1;
    private javax.swing.JPanel howtomenu2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel personmenu;
    private javax.swing.JPanel policemenu;
    private javax.swing.JPanel profilemenu;
    // End of variables declaration//GEN-END:variables
}
