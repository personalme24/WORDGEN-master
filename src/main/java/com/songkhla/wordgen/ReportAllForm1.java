/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;

import com.songkhla.document.TestWord;
import com.songkhla.document.W1;
import com.songkhla.document.W11;
import com.songkhla.document.W12;
import com.songkhla.document.W13;
import com.songkhla.document.W14;
import com.songkhla.document.W15;
import com.songkhla.document.W16;
import com.songkhla.document.W17;
import com.songkhla.document.W18;
import com.songkhla.document.W19;
import com.songkhla.document.W2;
import com.songkhla.document.W20;
import com.songkhla.document.W21;
import com.songkhla.document.W22;
import com.songkhla.document.W23;
import com.songkhla.document.W24;
import com.songkhla.document.W25;
import com.songkhla.document.W26;
import com.songkhla.document.W27;
import com.songkhla.document.W28;
import com.songkhla.document.W29;
import com.songkhla.document.W3;
import com.songkhla.document.W30;
import com.songkhla.document.W31;
import com.songkhla.document.W32;
import com.songkhla.document.W33;
import com.songkhla.document.W34;
import com.songkhla.document.W35;
import com.songkhla.document.W36;
import com.songkhla.document.W37;
import com.songkhla.document.W38;
import com.songkhla.document.W39;
import com.songkhla.document.W4;
import com.songkhla.document.W40;
import com.songkhla.document.W41;
import com.songkhla.document.W42;
import com.songkhla.document.W43;
import com.songkhla.document.W44;
import com.songkhla.document.W45;
import com.songkhla.document.W46;
import com.songkhla.document.W47;
import com.songkhla.document.W48;
import com.songkhla.document.W49;
import com.songkhla.document.W5;
import com.songkhla.document.W50;
import com.songkhla.document.W51;
import com.songkhla.document.W52;
import com.songkhla.document.W53;
import com.songkhla.document.W6;
import com.songkhla.document.W62;
import com.songkhla.document.W63;
import com.songkhla.document.W64;
import com.songkhla.document.W65;
import com.songkhla.document.W67;
import com.songkhla.document.W68;
import com.songkhla.document.W69;
import com.songkhla.document.W7;
import com.songkhla.document.W70;
import com.songkhla.document.W71;
import com.songkhla.document.W72;
import com.songkhla.document.W73;
import com.songkhla.document.W74;
import com.songkhla.document.W8;
import com.songkhla.document.W9;
import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.json.simple.JSONObject;

/**
 *
 * @author Petpilin
 */
public class ReportAllForm1 extends javax.swing.JDialog {

    /**
     * Creates new form ReportAllForm
     */
    String caseid,caseyear,casetype,caseno,PoliceStaionName;
    Connection con=null;
    PreparedStatement pst=null;;
    public ReportAllForm1(JFrame parrent,JSONObject datain) {
        super(parrent,true);

        initComponents();
         ImageIcon img = new ImageIcon("D://Master//WD.png");
            setIconImage(img.getImage());
            setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
         //jCheckW5.setSelected(true);
         //jCheckW6.setSelected(true);
        crimecaseno.setVisible(true);
       
        if(datain != null){
        caseid=datain.get("caseid")+"";
                crimecaseno.setText(caseid);

        con=ConnectDatabase.connect();

        try{
        String sql="Select crimecasenoyear,crimecaseno,crimecaseyears,CaseType from CrimeCase where CaseId='"+caseid+"'";
         Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);  
                
        String sqlDataPoliceStation="SELECT * FROM PoliceStation";
        Statement stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery(sqlDataPoliceStation); 
                
        if(rs.next()){
         
             caseyear=rs.getString("crimecaseyears");
             caseno=rs.getString("crimecaseno");
             casetype=rs.getString("CaseType");
             PoliceStaionName=rs1.getString("PoliceStaionName");
                    }
        
        System.out.println("ffffffffffffffff : "+PoliceStaionName);
        }
        catch(Exception e){
        e.printStackTrace();
        
        }
        }
         addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            System.exit(0);
//        }
    }
});
    }

    ReportAllForm1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        crimecaseno = new javax.swing.JLabel();
        jCheckW40 = new javax.swing.JCheckBox();
        jCheckW41 = new javax.swing.JCheckBox();
        jCheckW42 = new javax.swing.JCheckBox();
        jCheckW43 = new javax.swing.JCheckBox();
        jCheckW46 = new javax.swing.JCheckBox();
        jCheckW47 = new javax.swing.JCheckBox();
        jCheckW48 = new javax.swing.JCheckBox();
        jCheckW49 = new javax.swing.JCheckBox();
        jCheckW50 = new javax.swing.JCheckBox();
        jCheckW51 = new javax.swing.JCheckBox();
        jCheckW52 = new javax.swing.JCheckBox();
        jCheckW53 = new javax.swing.JCheckBox();
        jCheckW54 = new javax.swing.JCheckBox();
        jCheckW55 = new javax.swing.JCheckBox();
        jCheckW56 = new javax.swing.JCheckBox();
        jCheckW57 = new javax.swing.JCheckBox();
        jCheckW58 = new javax.swing.JCheckBox();
        jCheckW59 = new javax.swing.JCheckBox();
        jCheckW60 = new javax.swing.JCheckBox();
        jCheckW20 = new javax.swing.JCheckBox();
        jCheckW21 = new javax.swing.JCheckBox();
        jCheckW22 = new javax.swing.JCheckBox();
        jCheckW23 = new javax.swing.JCheckBox();
        jCheckW24 = new javax.swing.JCheckBox();
        jCheckW25 = new javax.swing.JCheckBox();
        jCheckW26 = new javax.swing.JCheckBox();
        jCheckW27 = new javax.swing.JCheckBox();
        jCheckW29 = new javax.swing.JCheckBox();
        jCheckW30 = new javax.swing.JCheckBox();
        jCheckW31 = new javax.swing.JCheckBox();
        jCheckW32 = new javax.swing.JCheckBox();
        jCheckW33 = new javax.swing.JCheckBox();
        jCheckW34 = new javax.swing.JCheckBox();
        jCheckW35 = new javax.swing.JCheckBox();
        jCheckW36 = new javax.swing.JCheckBox();
        jCheckW37 = new javax.swing.JCheckBox();
        jCheckW38 = new javax.swing.JCheckBox();
        jCheckW39 = new javax.swing.JCheckBox();
        jCheckW1 = new javax.swing.JCheckBox();
        jCheckW2 = new javax.swing.JCheckBox();
        jCheckW3 = new javax.swing.JCheckBox();
        jCheckW4 = new javax.swing.JCheckBox();
        jCheckW5 = new javax.swing.JCheckBox();
        jCheckW6 = new javax.swing.JCheckBox();
        jCheckW7 = new javax.swing.JCheckBox();
        jCheckW8 = new javax.swing.JCheckBox();
        jCheckW9 = new javax.swing.JCheckBox();
        jCheckW11 = new javax.swing.JCheckBox();
        jCheckW12 = new javax.swing.JCheckBox();
        jCheckW13 = new javax.swing.JCheckBox();
        jCheckW14 = new javax.swing.JCheckBox();
        jCheckW15 = new javax.swing.JCheckBox();
        jCheckW16 = new javax.swing.JCheckBox();
        jCheckW17 = new javax.swing.JCheckBox();
        jCheckW18 = new javax.swing.JCheckBox();
        jCheckW19 = new javax.swing.JCheckBox();
        jCheckW44 = new javax.swing.JCheckBox();
        jCheckW45 = new javax.swing.JCheckBox();
        jCheckW28 = new javax.swing.JCheckBox();
        jCheckW61 = new javax.swing.JCheckBox();
        jCheckW62 = new javax.swing.JCheckBox();
        jCheckW63 = new javax.swing.JCheckBox();
        jCheckW64 = new javax.swing.JCheckBox();
        jCheckW65 = new javax.swing.JCheckBox();
        jCheckW66 = new javax.swing.JCheckBox();
        jCheckW67 = new javax.swing.JCheckBox();
        jCheckW68 = new javax.swing.JCheckBox();
        jCheckW69 = new javax.swing.JCheckBox();
        jCheckW70 = new javax.swing.JCheckBox();
        jCheckW71 = new javax.swing.JCheckBox();
        jCheckW72 = new javax.swing.JCheckBox();
        jCheckW73 = new javax.swing.JCheckBox();
        jCheckW74 = new javax.swing.JCheckBox();
        jCheckW75 = new javax.swing.JCheckBox();
        jCheckW76 = new javax.swing.JCheckBox();
        jCheckW77 = new javax.swing.JCheckBox();
        jCheckW78 = new javax.swing.JCheckBox();
        jCheckW79 = new javax.swing.JCheckBox();
        jCheckW80 = new javax.swing.JCheckBox();
        jCheckW93 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("แบบฟอร์มสำนวน");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        crimecaseno.setText("jLabel2");

        jCheckW40.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW40.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW40.setText("บันทึกการแจ้งสิทธิตาม พ.ร.บ. ค่าตอบแทนผู้เสียหาย และค่าทดแทน \n");

        jCheckW41.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW41.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW41.setText("บันทึกการตกลงค่าาเสียหาย");

        jCheckW42.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW42.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW42.setText("บันทึกคำขอรับชดใช้ค่าใช้จ่ายเบื้องต้นอันเกิดจากการขนส่ง");

        jCheckW43.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW43.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW43.setText("บันทึกเสนอสัญญาประกันสิ่งของ");

        jCheckW46.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW46.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW46.setText("หนังสือแจ้งการขอประกันสิ่งของไปดูแลรักษาหรือใช้ประโยชน์");

        jCheckW47.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW47.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW47.setText("หนังสือรายงานคนต่างด้าวเป็นผู้เสียหายในคดีอุกฉกรรจ์หรือตายโดยธรรมชาติ");

        jCheckW48.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW48.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW48.setText("หนังสือรายงานคนต่างด้าวกระทำความผิดและถูกจับกุมตัวดำเนินคดี");

        jCheckW49.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW49.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW49.setText("หนังสือขอส่งตัวคนต่างด้าว");

        jCheckW50.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW50.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW50.setText("หนังสือขอส่งรายละเอียดเกี่ยวกับคนต่างด้าวถูกกักขังหรือกักขังแทนค่าปรับ");

        jCheckW51.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW51.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW51.setText("หนังสือขอส่งตัวคนต่างด้าวหลบหนีเข้าเมืองมาเพื่อดำเนินการผลักดันออกไปนอกราชอาณาจักร");

        jCheckW52.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW52.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW52.setText("หนังสือขอให้ตรวจสอบหนังสือเดินทางหรือเอกสารที่ใช้แทนการเดินทางของบุคคลต่างด้าว");

        jCheckW53.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW53.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW53.setText("หนังสือแจ้งความคืบหน้าการสอบสวน");

        jCheckW54.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW54.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW54.setText("แบบแจ้งรูปพรรณคนหาย");

        jCheckW55.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW55.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW55.setText("แบบการสืบสวนติดตามคนหาย");

        jCheckW56.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW56.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW56.setText("แบบแจ้งผลการได้ตัวคนหายคืน");

        jCheckW57.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW57.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW57.setText("ตำหนิรูปพรรณทรัพย์หาย");

        jCheckW58.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW58.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW58.setText("ตำหนิรูปพรรณทรัพย์หายได้คืน");

        jCheckW59.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW59.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW59.setText("แบบรูปพรรณรถยนต์หรือรถจักรยนต์ที่ถูกโจรกรรม");

        jCheckW60.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW60.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW60.setText("แบบรายการรถยนต์หรือรถจักรยานยนต์ที่ได้คืน");

        jCheckW20.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW20.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW20.setText("บันทึกการนำชี้ที่เกิดเหตุประกอบคำรับสารภาพ");

        jCheckW21.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW21.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW21.setText("ใบนำส่งผู้บาดเจ็บหรือศพ");

        jCheckW22.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW22.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW22.setText("หนังสือส่งผู้ต้องหาป่วยทางจิตตรวจวินิจฉัย");

        jCheckW23.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW23.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW23.setText("รายงานชันสูตรพลิกศพ");

        jCheckW24.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW24.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW24.setText("แบบรายงานพบศพไม่ทราบชื่อ");

        jCheckW25.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW25.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW25.setText("หนังสือส่งของกลางไปตรวจพิสูจน์");

        jCheckW26.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW26.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW26.setText("หนังสือส่งยาเสพติดของกลางไปตรวจพิสูจน์");

        jCheckW27.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW27.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW27.setText("ฉลากปิดภาชนะบรรจุยาเสพติด");

        jCheckW29.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW29.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW29.setText("บันทึกการชี้ตัวผู้ต้องหา");

        jCheckW30.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW30.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW30.setText("บันทึกการชี้รูปผู้ต้องหา");

        jCheckW31.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW31.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW31.setText("บันทึกการจับกุม");

        jCheckW32.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW32.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW32.setText("บันทึกการจับกุมผู้ต้องหาที่เป็นเด็กหรือเยาวชน");

        jCheckW33.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW33.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW33.setText("บันทึกการตรวจค้น");

        jCheckW34.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW34.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW34.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้น");

        jCheckW35.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW35.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW35.setText("บัญชีการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW36.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW36.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW36.setText("บัญชีทรัพย์ประกอบบันทึกการตรวจค้นโดยไม่มีหมายค้น");

        jCheckW37.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW37.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW37.setText("ตำหนิรูปพรรณผู้กระทำความผิด");

        jCheckW38.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW38.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW38.setText("หมายเรียกผู้ต้องหา");

        jCheckW39.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW39.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW39.setText("หมายเรียกพยาน");
        jCheckW39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW39ActionPerformed(evt);
            }
        });

        jCheckW1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW1.setText("บันทึกการตรวจสำนวนการสอบสวน");

        jCheckW2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW2.setText("หนังสือส่งสำนวนคดีที่เห็นควรงดหรือให้งดการสอบสวน");

        jCheckW3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW3.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้อง แต่ยังไม่ได้ตัวผู้ต้องหา");

        jCheckW4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW4.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW4.setText("หนังสือส่งสำนวนคดีที่เห็นควรสั่งฟ้องหรือไม่สั่งฟ้อง");

        jCheckW5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW5.setText("รายงานการสอบสวน");

        jCheckW6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW6.setText("รายงานการสอบสวนสำนวนคดีไม่ปรากฎว่าผู้ใดเป็นผู้กระทำผิด");

        jCheckW7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW7.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW7.setText("รายงานการสอบสวนสำนวนชันสูตรพลิกศพ");

        jCheckW8.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW8.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW8.setText("บันทึกคำให้การผู้กล่าวหา หรือพยาน");

        jCheckW9.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW9.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW9.setText("บันทึกคำให้การผู้ต้องหา");

        jCheckW11.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW11.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW11.setText("บัญชีของกลางคดีอาญา");

        jCheckW12.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW12.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW12.setText("บัญชีทรัพย์ถูกประทุษร้าย");

        jCheckW13.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW13.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW13.setText("บัญชีทรัพย์ถูกประทุษร้ายได้คืน");

        jCheckW14.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW14.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW14.setText("บัญชีทรัพย์ถูกประทุษร้ายไม่ได้คืน");

        jCheckW15.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW15.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW15.setText("บัญชีทรัพย์ที่ถูกเพลิงไหม้");

        jCheckW16.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW16.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW16.setText("บันทึกพนักงานสอบสวน");

        jCheckW17.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW17.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW17.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีอาญา");

        jCheckW18.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW18.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW18.setText("บันทึกการตรวจสอบสถานที่เกิดเหตุคดีจราจรทางบก");

        jCheckW19.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW19.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW19.setText("แผนที่สังเขปแสดงสถานที่เกิดเหตุ");

        jCheckW44.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW44.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW44.setText("คำร้องขอคืนสิ่งของ");

        jCheckW45.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW45.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW45.setText("สัญญาประกันและรับมอบสิ่งของ");

        jCheckW28.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW28.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW28.setText("บันทึกการตรวจสภาพสภาพรถยนต์");

        jCheckW61.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW61.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW61.setText("แผนประทุษกรรม");

        jCheckW62.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW62.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW62.setText("บันทึกการควบคุมผู้ต้องหา");

        jCheckW63.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW63.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW63.setText("คำร้องขอสืบพยานไว้ก่อน");

        jCheckW64.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW64.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW64.setText("บันทึกการพบและปรึกษาทนาย");

        jCheckW65.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW65.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW65.setText("คำร้องขอส่งตัวผู้ต้องหาไปควบคุมตัวเพื่อพิสูจน์การเสพหรือการติดยาเสพติด");

        jCheckW66.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW66.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW66.setText("คำร้องขอตรวจสอบการจับ");

        jCheckW67.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW67.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW67.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่ 1");

        jCheckW68.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW68.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW68.setText("คำร้องขอผัดฟ้องหรือผัดฟ้องและฝากขังครั้งที่....");

        jCheckW69.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW69.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW69.setText("คำร้องขอฝากครั้ง");

        jCheckW70.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW70.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW70.setText("บันทึกเสนอสัญญาประกัน");

        jCheckW71.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW71.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW71.setText("คำร้องและสัญญาประกัน");

        jCheckW72.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW72.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW72.setText("คำยินยอมกรณีผู้ให้สัญญาค้ำประกันมีคู่สมรส");

        jCheckW73.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW73.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW73.setText("บันทึกรับรองการป็นโสด");

        jCheckW74.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW74.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW74.setText("หนังสือแจ้งอายัดตี๋วสัญญาใช้เงิน ตั๋วแลกเงิน พันธบัตรรัฐบาล สลากออมสิน สิทธิตามใบรับเงินฝากประจำ");

        jCheckW75.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW75.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW75.setText("บันทึกการสอบถามเบื้องต้น(กรณีเด็กหรือเยาวชน)");

        jCheckW76.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW76.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW76.setText("หนังสือแจ้งการดำเนินคดีเด็กหรือเยาวชนไปยังสถานพินิจ");

        jCheckW77.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW77.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW77.setText("หนังสือแจ้งการจับกุมเด็กหรือเยาวชนไปยังสถานพินิจ");

        jCheckW78.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW78.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW78.setText("หนังสือแจ้งการจับกุมด็กหรือเยาวชนไปยังบิดามารดา หรือผู้ปกครอง");

        jCheckW79.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW79.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW79.setText("พิมพ์ลายนิ้วมือของผู้ต้องหา");

        jCheckW80.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW80.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW80.setText("บัญชีสำนวนการสอบสวน");

        jCheckW93.setBackground(new java.awt.Color(255, 255, 255));
        jCheckW93.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jCheckW93.setText("หมายจับ");
        jCheckW93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckW93ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton1.setText("สร้างเอกสาร");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCheckW93, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addComponent(jCheckW35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(crimecaseno)
                                .addGap(34, 34, 34))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckW38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40)))
                        .addComponent(jButton1)
                        .addGap(64, 64, 64)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jCheckW49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW46, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW54, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW55, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckW57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckW40, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCheckW64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckW63, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckW62, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckW61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckW60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckW59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(jCheckW58, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckW74)
                            .addComponent(jCheckW78)
                            .addComponent(jCheckW79)
                            .addComponent(jCheckW80)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCheckW73, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW72, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW68, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckW75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jCheckW76, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckW77, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckW1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckW8)
                                    .addComponent(jCheckW27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckW9)
                                    .addComponent(jCheckW28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckW12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckW13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckW14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckW15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckW16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckW17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckW18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jCheckW19))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckW11)
                                                .addGap(264, 264, 264)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW93))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckW29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW38))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckW20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckW23))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckW41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW42)
                                            .addComponent(jCheckW61)
                                            .addComponent(jCheckW80))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckW24)
                                    .addComponent(jCheckW43)
                                    .addComponent(jCheckW62))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckW25)
                                    .addComponent(jCheckW44)
                                    .addComponent(jCheckW63))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckW26)
                                    .addComponent(jCheckW45)
                                    .addComponent(jCheckW64))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW70)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW77))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCheckW39)
                                        .addGap(33, 33, 33))
                                    .addComponent(jCheckW40)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW58)
                                            .addComponent(jCheckW74))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jCheckW59)
                                            .addComponent(jCheckW78))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckW60)
                                    .addComponent(jCheckW79))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckW46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckW57)))
                        .addContainerGap(105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 623, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(crimecaseno)
                            .addComponent(jButton1))
                        .addGap(78, 78, 78))))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckW93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW93ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW93ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            File f3=new File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน");
        
        f3.mkdirs();
        System.out.print(f3);
        System.out.print("folder created");
        
        if(jCheckW1.isSelected()){
             
		W1.nw1();
             
        }
        
        if(jCheckW2.isSelected()){
            
             W2.nw2();
        }
        if(jCheckW3.isSelected()){
            W3.nw3();
             
        }
        if(jCheckW4.isSelected()){
             W4.nw4();
        }
         if(jCheckW5.isSelected()){
            W5.nw5();
        }
        if(jCheckW6.isSelected()){
            W6.nw6();
           
        }
        if(jCheckW7.isSelected()){
            W7.nw7();
           
        }
        if(jCheckW8.isSelected()){
            W8.nw8();
           
        }
        if(jCheckW9.isSelected()){
            W9.nw9();
           
        }

        if(jCheckW11.isSelected()){
            W11.nw11();
           
        }
        if(jCheckW12.isSelected()){
            W12.nw12();
           
        }
        if(jCheckW13.isSelected()){
            W13.nw13();
           
        }
        if(jCheckW14.isSelected()){
            W14.nw14();
           
        }
        if(jCheckW15.isSelected()){
            W15.nw15();
           
        }
        if(jCheckW16.isSelected()){
            W16.nw16();
           
        }
        if(jCheckW17.isSelected()){
            W17.nw17();
           
        }
        if(jCheckW18.isSelected()){
            W18.nw18();
           
        }
        if(jCheckW19.isSelected()){
            W19.nw19();
           
        }
        if(jCheckW20.isSelected()){
            W20.nw20();
           
        }
        if(jCheckW21.isSelected()){
            W21.nw21();
           
        }
        if(jCheckW22.isSelected()){
            W22.nw22();
           
        }
        if(jCheckW23.isSelected()){
            W23.nw23();
           
        }
        if(jCheckW24.isSelected()){
            W24.nw24();
           
        }
        if(jCheckW25.isSelected()){
            W25.nw25();
           
        }
        if(jCheckW26.isSelected()){
            W26.nw26();
           
        }
        if(jCheckW27.isSelected()){
            W27.nw27();
           
        }
        if(jCheckW28.isSelected()){
            W28.nw28();
           
        }
        if(jCheckW29.isSelected()){
            W29.nw29();
           
        }
        if(jCheckW30.isSelected()){
            W30.nw30();
           
        }
        if(jCheckW31.isSelected()){
            W31.nw31();
           
        }
        if(jCheckW32.isSelected()){
            W32.nw32();
           
        }
        if(jCheckW33.isSelected()){
            W33.nw33();
           
        }
        if(jCheckW34.isSelected()){
            W34.nw34();
           
        }
        if(jCheckW35.isSelected()){
            W35.nw35();
           
        }
        if(jCheckW36.isSelected()){
            W36.nw36();
           
        }
        if(jCheckW37.isSelected()){
            W37.nw37();
           
        }
        if(jCheckW38.isSelected()){
            W38.nw38();
           
        }
        if(jCheckW39.isSelected()){
            W39 .nw39();
           
        }
         if(jCheckW40.isSelected()){
             W40 .nw40();
           
        }
          if(jCheckW41.isSelected()){
              W41 .nw41();
           
        }
           if(jCheckW42.isSelected()){
               W42 .nw42();
           
        }
            if(jCheckW43.isSelected()){
                W43 .nw43();
           
        }
             if(jCheckW44.isSelected()){
                 W44 .nw44();
           
        }
              if(jCheckW45.isSelected()){
                  W45 .nw45();
           
        } if(jCheckW46.isSelected()){
            W46 .nw46();
           
        }
         if(jCheckW47.isSelected()){
             W47 .nw47();
           
        }
          if(jCheckW48.isSelected()){
              W48 .nw48();
           
        }
           if(jCheckW49.isSelected()){
               W49 .nw49();
           
        } if(jCheckW50.isSelected()){
            W50 .nw50();
           
        }
         if(jCheckW51.isSelected()){
             W51 .nw51();
           
        } if(jCheckW52.isSelected()){
            W52 .nw52();
           
        } if(jCheckW53.isSelected()){
            W53 .nw53();
           
        }
         if(jCheckW54.isSelected()){
            //W54 .nw54();
           
        }
          if(jCheckW55.isSelected()){
            //W55 .nw55();
           
        }
           if(jCheckW56.isSelected()){
           // W56 .nw56();
           
        }
            if(jCheckW57.isSelected()){
            //W57 .nw57();
           
        }
             if(jCheckW58.isSelected()){
            //W58 .nw58();
           
        }
              if(jCheckW59.isSelected()){
            //W59 .nw59();
           
        }
               if(jCheckW60.isSelected()){
            //W60 .nw60();
           
        }
                if(jCheckW61.isSelected()){
            //W61 .nw61();
           
        }
                 if(jCheckW62.isSelected()){
                     W62 .nw62();
           
        }
                  if(jCheckW63.isSelected()){
                      W63 .nw63();
           
        }
                  if(jCheckW64.isSelected()){
                      W64 .nw64();
           
        }
                  
         if(jCheckW65.isSelected()){
             W65 .nw65();
           
        }
         if(jCheckW66.isSelected()){
             //W66.nw66();
           
        }
         if(jCheckW67.isSelected()){
             W67 .nw67();
           
        }
         if(jCheckW68.isSelected()){
             W68 .nw68();
           
        }
         if(jCheckW69.isSelected()){
             W69 .nw69();
           
        }
         if(jCheckW70.isSelected()){
             W70 .nw70();
           
        }
         if(jCheckW71.isSelected()){
             W71 .nw71();
           
        }
         if(jCheckW72.isSelected()){
             W72 .nw72();
           
        }
         if(jCheckW73.isSelected()){
             W73 .nw73();
           
        }
         if(jCheckW74.isSelected()){
             W74 .nw74();
           
        }
         
                  
        
         
           
        
              
        
         JOptionPane.showMessageDialog(jPanel1,"สร้างเอกสารสำเร็จ", "สร้างเอกสารสำเร็จ", JOptionPane.INFORMATION_MESSAGE);
         
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {    
            dirToOpen = new File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน");
            desktop.open(dirToOpen);
        } catch (Exception iae) {
            System.out.println("File Not Found");
        }
        setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckW39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckW39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckW39ActionPerformed

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
            java.util.logging.Logger.getLogger(ReportAllForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportAllForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportAllForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportAllForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ReportforCrimesCase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel crimecaseno;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckW1;
    private javax.swing.JCheckBox jCheckW11;
    private javax.swing.JCheckBox jCheckW12;
    private javax.swing.JCheckBox jCheckW13;
    private javax.swing.JCheckBox jCheckW14;
    private javax.swing.JCheckBox jCheckW15;
    private javax.swing.JCheckBox jCheckW16;
    private javax.swing.JCheckBox jCheckW17;
    private javax.swing.JCheckBox jCheckW18;
    private javax.swing.JCheckBox jCheckW19;
    private javax.swing.JCheckBox jCheckW2;
    private javax.swing.JCheckBox jCheckW20;
    private javax.swing.JCheckBox jCheckW21;
    private javax.swing.JCheckBox jCheckW22;
    private javax.swing.JCheckBox jCheckW23;
    private javax.swing.JCheckBox jCheckW24;
    private javax.swing.JCheckBox jCheckW25;
    private javax.swing.JCheckBox jCheckW26;
    private javax.swing.JCheckBox jCheckW27;
    private javax.swing.JCheckBox jCheckW28;
    private javax.swing.JCheckBox jCheckW29;
    private javax.swing.JCheckBox jCheckW3;
    private javax.swing.JCheckBox jCheckW30;
    private javax.swing.JCheckBox jCheckW31;
    private javax.swing.JCheckBox jCheckW32;
    private javax.swing.JCheckBox jCheckW33;
    private javax.swing.JCheckBox jCheckW34;
    private javax.swing.JCheckBox jCheckW35;
    private javax.swing.JCheckBox jCheckW36;
    private javax.swing.JCheckBox jCheckW37;
    private javax.swing.JCheckBox jCheckW38;
    private javax.swing.JCheckBox jCheckW39;
    private javax.swing.JCheckBox jCheckW4;
    private javax.swing.JCheckBox jCheckW40;
    private javax.swing.JCheckBox jCheckW41;
    private javax.swing.JCheckBox jCheckW42;
    private javax.swing.JCheckBox jCheckW43;
    private javax.swing.JCheckBox jCheckW44;
    private javax.swing.JCheckBox jCheckW45;
    private javax.swing.JCheckBox jCheckW46;
    private javax.swing.JCheckBox jCheckW47;
    private javax.swing.JCheckBox jCheckW48;
    private javax.swing.JCheckBox jCheckW49;
    private javax.swing.JCheckBox jCheckW5;
    private javax.swing.JCheckBox jCheckW50;
    private javax.swing.JCheckBox jCheckW51;
    private javax.swing.JCheckBox jCheckW52;
    private javax.swing.JCheckBox jCheckW53;
    private javax.swing.JCheckBox jCheckW54;
    private javax.swing.JCheckBox jCheckW55;
    private javax.swing.JCheckBox jCheckW56;
    private javax.swing.JCheckBox jCheckW57;
    private javax.swing.JCheckBox jCheckW58;
    private javax.swing.JCheckBox jCheckW59;
    private javax.swing.JCheckBox jCheckW6;
    private javax.swing.JCheckBox jCheckW60;
    private javax.swing.JCheckBox jCheckW61;
    private javax.swing.JCheckBox jCheckW62;
    private javax.swing.JCheckBox jCheckW63;
    private javax.swing.JCheckBox jCheckW64;
    private javax.swing.JCheckBox jCheckW65;
    private javax.swing.JCheckBox jCheckW66;
    private javax.swing.JCheckBox jCheckW67;
    private javax.swing.JCheckBox jCheckW68;
    private javax.swing.JCheckBox jCheckW69;
    private javax.swing.JCheckBox jCheckW7;
    private javax.swing.JCheckBox jCheckW70;
    private javax.swing.JCheckBox jCheckW71;
    private javax.swing.JCheckBox jCheckW72;
    private javax.swing.JCheckBox jCheckW73;
    private javax.swing.JCheckBox jCheckW74;
    private javax.swing.JCheckBox jCheckW75;
    private javax.swing.JCheckBox jCheckW76;
    private javax.swing.JCheckBox jCheckW77;
    private javax.swing.JCheckBox jCheckW78;
    private javax.swing.JCheckBox jCheckW79;
    private javax.swing.JCheckBox jCheckW8;
    private javax.swing.JCheckBox jCheckW80;
    private javax.swing.JCheckBox jCheckW9;
    private javax.swing.JCheckBox jCheckW93;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
