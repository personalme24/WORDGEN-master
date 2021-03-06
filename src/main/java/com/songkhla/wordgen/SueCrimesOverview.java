/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.wordgen;
import static com.songkhla.wordgen.ListSuspect.txtCaseNO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.xalan.trace.SelectionEvent;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.simple.JSONObject;

/**
 *
 * @author Petpilin
 */
public class SueCrimesOverview extends javax.swing.JDialog {
    Connection con=null;
    PreparedStatement pst=null;
    DataCase dc =new DataCase();
    JDatePickerImpl DateFilterStart,DateFilterEnd;
    String sqlRefresh;

    /**
     * Creates new form BailCrimesForm
     */
    public SueCrimesOverview(JFrame parrent) {
        super(parrent,true);

        initComponents();
        ImageIcon img = new ImageIcon("./Master/WD.png");
        setIconImage(img.getImage());
         setTitle("ระบบสำนวนอิเล็คทรอนิกส์ (CRIMES E-inquiry)");
           jTableSue.setOpaque(false);
        jTableSue.getTableHeader().setFont(new Font("TH SarabunPSK",Font.BOLD,20));
        jTableSue.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
jTableSue.setPreferredScrollableViewportSize(Toolkit.getDefaultToolkit().getScreenSize());
       try{
                  Font font = Font.createFont(Font.TRUETYPE_FONT, new File("./Fonts/THSarabun Bold.ttf"));
                  Font  sizedFont = font.deriveFont(1,28f);
                     jLabel1.setFont(sizedFont);
           
                 Font  labelother = font.deriveFont(1,22f);
                     jLabel3.setFont(labelother);
                     jLabel2.setFont(labelother);
                     jLabel2.setFont(labelother);
                     jButtonDate.setFont(labelother);
                     jButtonClearSearch.setFont(labelother);
                     jButtonAddSue.setFont(labelother);
                     jLabel6.setFont(labelother);
                      jLabel5.setFont(labelother);
               }
            catch(Exception x){
                System.out.println("Error Font:"+x);
            }
//        CalculateDate();
//        TestDate();

//------------------------------------------Date----------------------------------------
         UtilDateModel model = new UtilDateModel();
//            model.setValue(Calendar.getInstance().getTime());
            Properties p = new Properties();
            p.put("text.today", "Today");
            p.put("text.month", "Month");
            p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
         DateFilterStart = new JDatePickerImpl(datePanel,new DateLabelFormatter());
           DateFilterStart.setPreferredSize(new Dimension(200,32));
    DateFilterStart.getComponent(0).setPreferredSize(new Dimension(170,32)); //JFormattedTextField
    DateFilterStart.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateFilterStart.setTextEditable(true);
        DateFilterStart.setBackground(Color.WHITE);
        jPanelDateStart.setLayout(new FlowLayout());
        jPanelDateStart.add(DateFilterStart);   
        
         UtilDateModel model2 = new UtilDateModel();
//            model2.setValue(Calendar.getInstance().getTime());
         
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, p);
         DateFilterEnd = new JDatePickerImpl(datePanel2,new DateLabelFormatter());
         DateFilterEnd.setPreferredSize(new Dimension(200,30));
    DateFilterEnd.getComponent(0).setPreferredSize(new Dimension(170,32)); //JFormattedTextField
    DateFilterEnd.getComponent(1).setPreferredSize(new Dimension(30,32));//JButton
        DateFilterEnd.setTextEditable(true);
        DateFilterEnd.setBackground(Color.WHITE);
        jPanelDateEnd.setLayout(new FlowLayout());
        jPanelDateEnd.add(DateFilterEnd);   
//------------------------------------------Date----------------------------------------
        
        RefreshData();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSue = new javax.swing.JTable();
        jButtonAddSue = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanelDateStart = new javax.swing.JPanel();
        jPanelDateEnd = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonDate = new javax.swing.JButton();
        jButtonClearSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxSue = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxCaseType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(4, 93, 179));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("TH SarabunPSK", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ผู้ต้องหาผัดฟ้องฝากขัง");

        jButton3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("./Master/home.png"));
        jButton3.setText("เมนูหลัก");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 892, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addComponent(jButton3))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, -1));

        jTableSue.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jTableSue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "เลขคดี", "คดี", "ผู้ต้องหา", "ครั้งที่ 1", "ครั้งที่ 2", "ครั้งที่ 3", "ครั้งที่ 4", "ครั้งที่ 5", "ครั้งที่ 6", "ครั้งที่ 7", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSue.setGridColor(new java.awt.Color(255, 255, 255));
        jTableSue.setFocusable(false);

        jTableSue.setIntercellSpacing(new java.awt.Dimension(0, 0));

        jTableSue.setRowHeight(25);
        jTableSue.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableSue);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 1140, 440));

        jButtonAddSue.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonAddSue.setText("เปิด");
        jButtonAddSue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSueActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddSue, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 80, 30));

        jLabel2.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel2.setText("ถึง");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jPanelDateStart.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelDateStartLayout = new javax.swing.GroupLayout(jPanelDateStart);
        jPanelDateStart.setLayout(jPanelDateStartLayout);
        jPanelDateStartLayout.setHorizontalGroup(
            jPanelDateStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanelDateStartLayout.setVerticalGroup(
            jPanelDateStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelDateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 210, 40));

        jPanelDateEnd.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelDateEndLayout = new javax.swing.GroupLayout(jPanelDateEnd);
        jPanelDateEnd.setLayout(jPanelDateEndLayout);
        jPanelDateEndLayout.setHorizontalGroup(
            jPanelDateEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanelDateEndLayout.setVerticalGroup(
            jPanelDateEndLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelDateEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 210, 40));

        jLabel3.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel3.setText("วันที่ครบกำหนด");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jButtonDate.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonDate.setText("ค้นหา");
        jButtonDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDateActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, -1));

        jButtonClearSearch.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jButtonClearSearch.setText("ล้างข้อมูล");
        jButtonClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClearSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 100, -1));

        jLabel5.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel5.setText("ประเภทคดี");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, 30));

        jComboBoxSue.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jComboBoxSue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทั้งหมด", "ผัดฟ้องฝากขัง", "ผัดฟ้อง", "ฝากขัง" }));
        jComboBoxSue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSueItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxSue, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 120, 30));

        jLabel6.setFont(new java.awt.Font("TH SarabunPSK", 1, 22)); // NOI18N
        jLabel6.setText("สถานะการผัดฟ้องฝากขัง");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, 30));

        jComboBoxCaseType.setFont(new java.awt.Font("TH SarabunPSK", 0, 22)); // NOI18N
        jComboBoxCaseType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ทั้งหมด", "อาญา", "จราจร", "ชันสูตร" }));
        jComboBoxCaseType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCaseTypeItemStateChanged(evt);
            }
        });
        jComboBoxCaseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCaseTypeActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCaseType, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1212, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddSueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSueActionPerformed
        // TODO add your handling code here:
         if(jTableSue.getSelectedRow()>=0){
            try{
                String crimecaseno = jTableSue.getModel().getValueAt(jTableSue.getSelectedRow(), 0)+"";
                String nameSuspect = jTableSue.getModel().getValueAt(jTableSue.getSelectedRow(), 3)+"";
                String CaseType = jTableSue.getModel().getValueAt(jTableSue.getSelectedRow(), 1)+"";

//                 String dateArr = jTableSue.getModel().getValueAt(jTableSue.getSelectedRow(), 2)+"";
                String sql="select CaseId,crimecasenoyear,AccureandOther,chargecase.ChargeCodeCase ChargeCase,chargecase.ChargeNameCase ChargeNameCase,crimecaseyears,crimecaseno,CaseType,Person.* from Person\n"+
                           "left join CrimeCase on Person.CaseIdPerson=CrimeCase.CaseId\n"+
                            "left join chargecase on crimecase.CaseId=chargecase.ChargeCaseId\n" +
                          " Where CaseId='"+crimecaseno+"' and FullNamePerson='"+nameSuspect+"' and CaseType='"+CaseType+"'";
                Connection con = ConnectDatabase.connect();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("ExSql : "+sql);
                if(rs.next()){
                    JSONObject data = new JSONObject();
                    data.put("CaseId", rs.getString("CaseId"));
                     data.put("StatusSuspect", rs.getString("StatusSuspect"));
                    data.put("crimecasenoyear", rs.getString("crimecasenoyear"));
                    data.put("AccureandOther", rs.getString("AccureandOther"));
                    data.put("ChargeName", rs.getString("ChargeNameCase"));
                    data.put("crimecaseyears", rs.getString("crimecaseyears"));
                    data.put("crimecaseno", rs.getString("crimecaseno"));
                    data.put("CaseType", rs.getString("CaseType"));
                    data.put("FullNamePerson", rs.getString("FullNamePerson"));
                    data.put("PeopleRegistrationID", rs.getString("PeopleRegistrationID"));
                     data.put("PlaceArrest", rs.getString("PlaceArrest"));
                      data.put("ArrestDateTime", rs.getString("ArrestDateTime")); 
                    data.put("ArrestDateTimeEnd", rs.getString("ArrestDateTimeEnd"));                    
                    data.put("StatusBail", rs.getString("StatusBail"));                    
                    data.put("CourtSuspect", rs.getString("CourtSuspect"));                    
                    data.put("RatePrison", rs.getString("RatePrison")); 
                    data.put("SueFirst", rs.getString("SueFirst"));
                    data.put("SueFirstDate", ChangFormat(rs.getString("SueFirstDate")));
                     data.put("SueFirstEnd", ChangFormat(rs.getString("SueFirstEnd")));
                      data.put("SueFirstTotal", rs.getString("SueFirstTotal"));
                      data.put("SueFirstRequest", rs.getString("SueFirstRequest"));
                    data.put("SueFirstCause", rs.getString("SueFirstCause"));
                     data.put("SueSecond", rs.getString("SueSecond"));
                      data.put("SueSecDate", ChangFormat(rs.getString("SueSecDate")));
                      data.put("SueSecEnd", ChangFormat(rs.getString("SueSecEnd")));
                    data.put("SueSecTotal", rs.getString("SueSecTotal"));
                     data.put("SueSecRequest", rs.getString("SueSecRequest"));
                      data.put("SueSecCause", rs.getString("SueSecCause"));
                      data.put("SueThird", rs.getString("SueThird"));
                    data.put("SueThirdDate", ChangFormat(rs.getString("SueThirdDate")));
                     data.put("SueThirdStart", ChangFormat(rs.getString("SueThirdStart")));
                      data.put("SueThirdEnd", ChangFormat(rs.getString("SueThirdEnd")));
                      data.put("SueThirdTotal", rs.getString("SueThirdTotal"));
                    data.put("SueThirdRequest", rs.getString("SueThirdRequest"));
                     data.put("SueThirdCause", rs.getString("SueThirdCause"));
                      data.put("SueFourth", rs.getString("SueFourth"));
                      data.put("SueFourthDate", ChangFormat(rs.getString("SueFourthDate")));
                    data.put("SueFourthEnd", ChangFormat(rs.getString("SueFourthEnd")));
                     data.put("SueFourthtotal", rs.getString("SueFourthtotal"));
                      data.put("SueFourthRequest", rs.getString("SueFourthRequest"));
                      data.put("SueFourthCause", rs.getString("SueFourthCause"));
                      
                                 data.put("SueFifth", rs.getString("SueFifth"));
                    data.put("SueFifthDate", ChangFormat(rs.getString("SueFifthDate")));
                     data.put("SueFifthEnd", ChangFormat(rs.getString("SueFifthEnd")));
                      data.put("SueFifthTotal", rs.getString("SueFifthTotal"));
                      data.put("SueFifthRequest", rs.getString("SueFifthRequest"));
                    data.put("SueFifthCause", rs.getString("SueFifthCause"));

                                data.put("SueSixth", rs.getString("SueSixth"));
                    data.put("SueSixthDate", ChangFormat(rs.getString("SueSixthDate")));
                     data.put("SueSixthEnd", ChangFormat(rs.getString("SueSixthEnd")));
                      data.put("SueSixthTotal", rs.getString("SueSixthTotal"));
                      data.put("SueSixthRequest", rs.getString("SueSixthRequest"));
                    data.put("SueSixthCause", rs.getString("SueSixthCause"));
        
                    data.put("SueSeven", rs.getString("SueSeven"));
                    data.put("SueSevenDate", ChangFormat(rs.getString("SueSevenDate")));
                      data.put("SueSevenEnd", ChangFormat(rs.getString("SueSevenEnd")));
                      data.put("SueSevenTotal", rs.getString("SueSevenTotal"));
                    data.put("SueSevenRequest", rs.getString("SueSevenRequest"));
                     data.put("SueSevenCause", rs.getString("SueSevenCause"));
                     
                    data.put("NoPerson", rs.getString("NoPerson"));
                    data.put("caseIdPerson", rs.getString("caseIdPerson"));
                    
                    
//                     data.put("SueFirstDate", rs.getString("SueFirstDate"));
                   


                    JFrame frame = new JFrame();
                    JDialog dialog = new JDialog(frame);//frame is owner
                    JFrame in = (JFrame)(dialog.getParent());
                    in.removeAll();

                    SueCrimesFrom scf =new SueCrimesFrom(in,data);
                    scf.pack();
                    scf.setLocationRelativeTo(null);
                    scf.setVisible(true);
                }

                rs.close();
                stmt.close();
                RefreshData();
            }catch(Exception ex){
                ex.printStackTrace();

            }
        }else{

        }
        
    }//GEN-LAST:event_jButtonAddSueActionPerformed

    private void jButtonDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDateActionPerformed
        // TODO add your handling code here:
        RefreshData();
    }//GEN-LAST:event_jButtonDateActionPerformed

    private void jButtonClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearSearchActionPerformed
        // TODO add your handling code here:

      DateFilterStart.getJFormattedTextField().setText("");
       DateFilterEnd.getJFormattedTextField().setText("");
        RefreshData();

 
    }//GEN-LAST:event_jButtonClearSearchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        MainMenuWord.closeAllDialogs();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBoxSueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSueItemStateChanged
        // TODO add your handling code here:
        RefreshData();
    }//GEN-LAST:event_jComboBoxSueItemStateChanged

    private void jComboBoxCaseTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCaseTypeItemStateChanged
        // TODO add your handling code here:
        RefreshData();
    }//GEN-LAST:event_jComboBoxCaseTypeItemStateChanged

    private void jComboBoxCaseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCaseTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCaseTypeActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SueCrimesOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SueCrimesOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SueCrimesOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SueCrimesOverview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new SueCrimesOverview().setVisible(true);
            }
        });
    }
   
     
   
    public void RefreshData(){
        try{
              
        Connection con = ConnectDatabase.connect();
        Statement stmt = con.createStatement();
//        String a=txtCaseNO.getText();
        String sql;
                sql=    "select CaseId,crimecasenoyear,CaseType,StatusSuspect,CaseIdPerson,SueFirstDate,SueSecDate,CourtSuspect,"
                        + "SueThirdDate,SueFourthDate,SueFifthDate,SueSixthDate,SueSevenDate,"
                        + "FullNamePerson,SueFirstEnd,SueSecEnd,SueThirdEnd,SueFourthEnd,SueFifthEnd,SueSixthEnd,SueSevenEnd,TypeChild\n"
                        + "from Person\n"+
                        "left join CrimeCase on Person.CaseIdPerson=CrimeCase.CaseId ";
                    if(jComboBoxSue.getSelectedItem().equals("ทั้งหมด")){

                    sql=sql+" where StatusSuspect IN('ผัดฟ้องฝากขัง','ผัดฟ้อง','ฝากขัง')";
                    }
                    else if(jComboBoxSue.getSelectedItem().equals("ผัดฟ้องฝากขัง")){

                    sql=sql+" where StatusSuspect='ผัดฟ้องฝากขัง'";
                    }
                    else if(jComboBoxSue.getSelectedItem().equals("ผัดฟ้อง")){

                    sql=sql+" where StatusSuspect='ผัดฟ้อง'";
                    }
                    else if(jComboBoxSue.getSelectedItem().equals("ฝากขัง")){

                    sql=sql+" where StatusSuspect='ฝากขัง'";
                    }
                    if(jComboBoxCaseType.getSelectedItem().equals("ทั้งหมด")){

                    sql=sql+"and  CaseType IN('คดีอาญา','คดีจราจร','คดีชันสูตร')";
                    }
                    else if(jComboBoxCaseType.getSelectedItem().equals("อาญา")){

                    sql=sql+" and CaseType='คดีอาญา'";
                    }
                    else if(jComboBoxCaseType.getSelectedItem().equals("จราจร")){

                    sql=sql+" and CaseType='คดีจราจร'";
                    }
                    else if(jComboBoxCaseType.getSelectedItem().equals("ชันสูตร")){

                    sql=sql+" and CaseType='คดีชันสูตร'";
                    }
//                if(jButtonDate.getModel().isPressed()){
//        sql=sql+" and\n" +
//        "SueFirstEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
//        "SueSecEnd    between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' " ;
//       }
//        "SueThirdEnd  between '2562/07/20' and '2562/07/21' or\n" +
//        "SueFourthEnd between '2562/07/20' and '2562/07/21'";   
        if(DateFilterStart.getJFormattedTextField().getText() != null && DateFilterEnd.getJFormattedTextField().getText() != null && !"".equals(DateFilterStart.getJFormattedTextField().getText())&& !"".equals(DateFilterEnd.getJFormattedTextField().getText())){
          sql=sql+" and\n"+
        "SueFirstEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
        "SueSecEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
        "SueThirdEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
        "SueFourthEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
        "SueFifthEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
        "SueSixthEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
        "SueSevenEnd    between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' " ;
        }
//  




        ResultSet rs = stmt.executeQuery(sql);
          System.out.println("SQL : "+sql);
        Vector<Vector> tabledata = new Vector<Vector>();
        while(rs.next()){
          
            Vector<String> row = new Vector<String>();
            row.add(rs.getString("CaseId"));
             row.add(rs.getString("CaseType"));
            row.add(rs.getString("crimecasenoyear"));
            row.add(rs.getString("FullNamePerson"));
           row.add(rs.getString("TypeChild"));
            row.add(rs.getString("CourtSuspect"));            
            row.add(rs.getString("StatusSuspect"));
            row.add(ChangFormat(rs.getString("SueFirstEnd")));
            row.add(ChangFormat(rs.getString("SueSecEnd")));
            row.add(ChangFormat(rs.getString("SueThirdEnd")));
             row.add(ChangFormat(rs.getString("SueFourthEnd")));
            row.add(ChangFormat(rs.getString("SueFifthEnd")));
             row.add(ChangFormat(rs.getString("SueSixthEnd")));
            row.add(ChangFormat(rs.getString("SueSevenEnd")));
            tabledata.add(row);
        }
        rs.close();
        stmt.close();
        Vector ColumnName = new Vector(); 
        ColumnName.add("CaseId");
         ColumnName.add("ประเภทคดี");
         ColumnName.add("เลขคดี"); 
         ColumnName.add("ผู้ต้องหา"); 
         ColumnName.add("ประเภทผู้ต้องหา"); 
         ColumnName.add("ศาล");  
         ColumnName.add("สถานะ");              
         ColumnName.add("ครั้งที่ 1 ครบ");         
         ColumnName.add("ครั้งที่ 2 ครบ");
         ColumnName.add("ครั้งที่ 3 ครบ");
         ColumnName.add("ครั้งที่ 4 ครบ");
         ColumnName.add("ครั้งที่ 5 ครบ");
         ColumnName.add("ครั้งที่ 6 ครบ");
         ColumnName.add("ครั้งที่ 7 ครบ");
         
        


//         ColumnName.add("ครบ 2 เดือน");
         

         System.out.println("SQL : "+sql);
     
        jTableSue.setModel(new javax.swing.table.DefaultTableModel(
            tabledata,
            ColumnName
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
     
        }catch(Exception ex){
            ex.printStackTrace();
        }
        jTableSue.getColumnModel().getColumn(0).setWidth(0);
jTableSue.getColumnModel().getColumn(0).setMinWidth(0);
jTableSue.getColumnModel().getColumn(0).setMaxWidth(0); 

jTableSue.getColumnModel().getColumn(1).setMinWidth(80);                
jTableSue.getColumnModel().getColumn(3).setMinWidth(125);
jTableSue.getColumnModel().getColumn(4).setMinWidth(125);

jTableSue.getColumnModel().getColumn(5).setMinWidth(135);
jTableSue.getColumnModel().getColumn(6).setMinWidth(100);

jTableSue.getColumnModel().getColumn(7).setMinWidth(120);
jTableSue.getColumnModel().getColumn(8).setMinWidth(120);
jTableSue.getColumnModel().getColumn(9).setMinWidth(120);
jTableSue.getColumnModel().getColumn(10).setMinWidth(120);
jTableSue.getColumnModel().getColumn(11).setMinWidth(120);
jTableSue.getColumnModel().getColumn(12).setMinWidth(120);
jTableSue.getColumnModel().getColumn(13).setMinWidth(120);


    }

     private String getFilterCondition(){
        HashMap<String,String> filter = new HashMap<String,String>();
        String result="";
        if(DateFilterStart.getJFormattedTextField().getText() != null && DateFilterEnd.getJFormattedTextField().getText() != null){
          result=" and\n"+
         "SueFirstEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
        "SueSecEnd    between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' " ;
        }
        
        String[] key = filter.keySet().toArray(new String[0]);
        
        for(int i=0;i<key.length;i++){
//            if(i==0){
//                result=" and\n"+
//         "SueFirstEnd  between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' or\n" +
//        "SueSecEnd    between '"+ChangFormatDate(DateFilterStart.getJFormattedTextField().getText())+"' and '"+ChangFormatDate(DateFilterEnd.getJFormattedTextField().getText())+"' " ;
//            }
//            if(i==key.length-1){
//                result+= " "+key[i]+" LIKE '%"+filter.get(key[i])+"%'";
//            }else{
//                result+= " "+key[i]+" LIKE "+filter.get(key[i]);
//            }
            System.out.println(result);
        }
        
        return result;
    }
      public static String ChangFormat(String DateSue){
        String newFormatDate=null;
       try{   Calendar cal;
       Locale lc = new Locale("th","TH");
        SimpleDateFormat formatdate =new SimpleDateFormat("yyyy/MM/d",lc);     
        if(DateSue != null && !"".equals(DateSue)){
        Date b=formatdate.parse(DateSue);
         cal = Calendar.getInstance();
          cal.setTime(b); 
          System.out.println("fffffff : "+cal.getTime());
           SimpleDateFormat dateformat =new SimpleDateFormat("d/MM/yyyy",lc);   
         newFormatDate=dateformat.format(cal.getTime()); 
        
        }
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    
    }
       public static String ChangFormatDate(String DateSue){
        String newFormatDate=null;
       try{   Calendar cal;
        SimpleDateFormat formatdate =new SimpleDateFormat("d/MM/yyyy");     
        Date b=formatdate.parse(DateSue);
         cal = Calendar.getInstance();
          cal.setTime(b); 
           SimpleDateFormat dateformat =new SimpleDateFormat("yyyy/MM/d");   
         newFormatDate=dateformat.format(cal.getTime());
    
         }
         catch(Exception e){
         e.printStackTrace();
         }
    return newFormatDate;
    
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAddSue;
    private javax.swing.JButton jButtonClearSearch;
    private javax.swing.JButton jButtonDate;
    private javax.swing.JComboBox<String> jComboBoxCaseType;
    private javax.swing.JComboBox<String> jComboBoxSue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDateEnd;
    private javax.swing.JPanel jPanelDateStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSue;
    // End of variables declaration//GEN-END:variables
}
