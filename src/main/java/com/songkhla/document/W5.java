/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.document;

/**
 *
 * @author Computer
 */
import com.songkhla.wordgen.ConnectDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.docx4j.XmlUtils;
import org.docx4j.model.fields.merge.DataFieldName;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Body;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class W5 {
	public static void w5(String cc) {
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
            String ccYear="";
            String cs="";
            String casetype="";
             String STATUS;
             String caseno="";
             String CourtSuspect;
             String PoliceStationName="";
             String StationAmphur="";
             String StationProvince="";
             String ProvincProsecutor="";
             String TelStation="";
             String HeadPosition="";
             String HeadName ="";
             String HeadWorkPosition="";
             String HeadWorkName="";
             String HeadRankFull="";
             String HeadWorkRankFull ="";
             String DistrictCourt="";
             String RankPoliceFull="";
             String RankPolice ="";
             String FirstName ="";
             String LastName ="";
             String Position ="";
             String CriminalCourt="";
             String JuvenileCourt="";
             String MilitaryCourt="";
             String LocationOfDrug="";
             String CheckDrug="";
           
             
             
            try {
//               
                    String sqlDataPoliceStation="SELECT * FROM PoliceStation";
                      Statement sp = conn.createStatement();
                  ResultSet rs=sp.executeQuery(sqlDataPoliceStation); 
                  while (rs.next()) {                    
                         PoliceStationName=rs.getString("PoliceStaionName");
                         StationAmphur=rs.getString("StationAmphur");
                         StationProvince=rs.getString("StationProvince");
                         ProvincProsecutor=rs.getString("ProvincProsecutor");
                         TelStation=rs.getString("TelStation");
                         DistrictCourt=rs.getString("DistrictCourt");
                         HeadName =rs.getString("HeadName");
                         HeadPosition =rs.getString("HeadPosition");
                         HeadWorkName =rs.getString("HeadWorkName");
                         HeadWorkPosition =rs.getString("HeadWorkPosition");
                         HeadRankFull =rs.getString("HeadRankFull");
                         HeadWorkRankFull =rs.getString("HeadWorkRankFull");
                         CriminalCourt=rs.getString("CriminalCourt");
                         DistrictCourt =rs.getString("DistrictCourt");
                         JuvenileCourt =rs.getString("JuvenileCourt");
                         MilitaryCourt=rs.getString("MilitaryCourt");
                         LocationOfDrug =rs.getString("LocationOfDrug");
                         CheckDrug =rs.getString("CheckDrug");
                      }
            String sqlDataPolice="SELECT * FROM Police";
                      Statement sp1 = conn.createStatement();
                  ResultSet rs1=sp1.executeQuery(sqlDataPolice); 
                  while (rs1.next()) {  
                         RankPoliceFull =rs1.getString("RankPoliceFull");
                         RankPolice =rs1.getString("RankPolice");
                         FirstName=rs1.getString("FirstName");
                         LastName=rs1.getString("LastName");
                         Position=rs1.getString("Position");
                      }
                  
                   String sql="select crimecase.*,ChargeCase.*,P1.*,P2.*,P3.*,ActionsCaseData.*,InvestInformation.*\n" +
                                "from crimecase inner join(\n" +
                              "SELECT  min(Person.NoPerson),Person.FullNamePerson AccuredName,Person.Age AgeAccured,Person.Race AccuredRace,Person.Nationality AccuredNati,Person.AnswerPerson AccuredAnswerPerson\n"
                            + "FROM Person where Person.TypePerson='ผู้กล่าวหา'\n" +
                              ")P1\n" +
                              "inner join(\n" +
                                "SELECT min(Person.NoPerson),Person.FullNamePerson suspectName,Person.Age suspectAge,Person.Amphur suspectAmp,Person.Race suspectRace,\n"+
                                "Person.Nationality suspectNati,Person.NoArrestWarrant suspectNoArrestWarrant,Person.ArrestDateTime ArrestDateTime,Person.AnswerPerson suspectAnswerPerson,"
                                + "Person.CourtSuspect suspectCourtSuspect,Person.StatusSuspect suspectStatusSuspect,Person.StatusInjuryOrDie StatusInjuryOrDie\n"
                            + "FROM Person where Person.TypePerson='ผู้ต้องหา' and Person.caseIdPerson='"+cc+"'\n" +
                                ")P2\n" +
                                "inner join(\n" +
                                "SELECT min(Person.NoPerson),Person.FullNamePerson WitnessName,Person.Age WitnessAge,Person.Amphur WitnessAmp,Person.Race WitnessRace,\n" +
                                "Person.Nationality WitnessNati,Person.AnswerPerson WitnessAnswerPerson FROM Person where Person.Related='พยาน' and Person.caseIdPerson='"+cc+"'\n" +
                                ")P3\n" +
                                "left join ChargeCase on crimecase.caseid=ChargeCase.ChargeCaseid\n" +
                                "left join ActionsCaseData on crimecase.ActionCodeCase = ActionsCaseData.ActionCodeCase\n"+
                                "left join InvestInformation on crimecase.PoliceNameCase=InvestInformation.InvestId \n" +
                                "where crimecase.CaseId='"+cc+"'\n"+
                                "group by crimecase.CaseId";

                   
                Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
                System.out.println(sql);
           JSONObject bookmarkvalue = new JSONObject();
           
            while((s!=null) && (s.next()))
            {    cs =s.getString("crimecaseno");
               ccYear=s.getString("crimecaseyears");
               STATUS=s.getString("Investigator_Result");
               casetype =s.getString("casetype");
               caseno  =s.getString("crimecasenoyear");
               CourtSuspect= Checknull(s.getString("suspectCourtSuspect"));
               STATUS=s.getString("Investigator_Result");
              String Date="";
                String Month="";
                String Year="";
                
                
                SimpleDateFormat sdfstart ;
                Calendar  calstart = Calendar.getInstance();
                sdfstart = new SimpleDateFormat("d", new Locale("th", "TH"));  
               Date =sdfstart.format(calstart.getTime());
              
               sdfstart = new SimpleDateFormat("MMMM", new Locale("th", "TH"));  
               Month=sdfstart.format(calstart.getTime());
               
               sdfstart = new SimpleDateFormat("yyyy", new Locale("th", "TH"));  
               Year=sdfstart.format(calstart.getTime());
                 
//                System.out.print("ข้อหา :: "+s.getString("ChargeCode"));
//                System.out.print(" - ");
//                 JSONObject bookmarkvalue = new JSONObject();
//              
                bookmarkvalue.put("C1",Checknull(Date));
                bookmarkvalue.put("C01",Checknull(Month));
                bookmarkvalue.put("C001",Checknull(Year));
                 bookmarkvalue.put("CC2",Checknull(caseno));
		bookmarkvalue.put("C2",Checknull(cs));
                bookmarkvalue.put("C3",Checknull(ccYear));
                bookmarkvalue.put("C37",Checknull(s.getString("Invest_SendtoDepartment")));
                bookmarkvalue.put("C38",Checknull(s.getString("Investigator_Number")));
                bookmarkvalue.put("STATUS",Checknull(STATUS));
                
                String StatusInjuryOrDie= Checknull(s.getString("StatusInjuryOrDie"));
               
                bookmarkvalue.put("CTY",Checknull(s.getString("suspectStatusSuspect")));
                
                
                bookmarkvalue.put("A2", Checknull(s.getString("ActionCrimesCase")));
                bookmarkvalue.put("A3", Checknull(s.getString("ActionDetailCase")));
                bookmarkvalue.put("A5", Checknull(s.getString("AnswerSuspectCase")));
                bookmarkvalue.put("A6", Checknull(s.getString("AnswerAccuserCase")));
                bookmarkvalue.put("C34", Checknull(s.getString("AnswerSuspectCase")));
                bookmarkvalue.put("C35", Checknull(s.getString("AnswerAccuserCase")));
                
                bookmarkvalue.put("S2",Checknull(PoliceStationName).substring(10));
                bookmarkvalue.put("S02",Checknull(PoliceStationName));
                bookmarkvalue.put("S5",Checknull(StationAmphur));
                bookmarkvalue.put("S6", Checknull(StationProvince));
                bookmarkvalue.put("S27",Checknull(ProvincProsecutor));
                bookmarkvalue.put("S10",Checknull(TelStation));
                bookmarkvalue.put("S14", Checknull(HeadPosition));
                bookmarkvalue.put("S13",Checknull(HeadName));
                bookmarkvalue.put("S15",Checknull(HeadWorkName));
                bookmarkvalue.put("S16",Checknull(HeadWorkPosition));
                bookmarkvalue.put("S19",Checknull(DistrictCourt));
                 if ((CourtSuspect).equals("ศาลแขวง") ){
                    bookmarkvalue.put("S19",Checknull(DistrictCourt));
                }
                if ((CourtSuspect).equals("ศาลอาญา/ศาลจังหวัด")){
                    bookmarkvalue.put("S19",Checknull(CriminalCourt));
                }
                if ((CourtSuspect).equals("ศาลเยาวชนและครอบครัว")){
                    bookmarkvalue.put("S19",Checknull(JuvenileCourt));
                }
                if ((CourtSuspect).equals("ศาลทหาร")){
                    bookmarkvalue.put("S19",Checknull(MilitaryCourt));
                }
                bookmarkvalue.put("S22",Checknull(LocationOfDrug));
                bookmarkvalue.put("S24",Checknull(CheckDrug));
                bookmarkvalue.put("S34",Checknull(HeadRankFull));
                bookmarkvalue.put("S36",Checknull(HeadWorkRankFull));
                
                  bookmarkvalue.put("PA7",Checknull(s.getString("AccureandOther")));
                  bookmarkvalue.put("PA13", Checknull(s.getString("AgeAccured")));
                  bookmarkvalue.put("PA14", Checknull(s.getString("AccuredRace")));
                  bookmarkvalue.put("PA15", Checknull(s.getString("AccuredNati"))); 
                  bookmarkvalue.put("PA133", Checknull(s.getString("AccuredAnswerPerson"))); 
                  
//                    
                    bookmarkvalue.put("PS7",  Checknull(s.getString("SuspectandOther"))); 
                    bookmarkvalue.put("PS13",  Checknull(s.getString("suspectAge")));
                    bookmarkvalue.put("PS14", Checknull(s.getString("suspectRace")));
                    bookmarkvalue.put("PS15",  Checknull(s.getString("suspectNati")));
                    bookmarkvalue.put("P54",ToDate(s.getString("ArrestDateTime")));
                  bookmarkvalue.put("P54","");

                    bookmarkvalue.put("PS91",  "");
                    bookmarkvalue.put("PS96",  "");
                    bookmarkvalue.put("PS133",  Checknull(s.getString("suspectAnswerPerson")));
                    bookmarkvalue.put("WN",  Checknull(s.getString("suspectNoArrestWarrant")));
                    
                    bookmarkvalue.put("PW7",  Checknull(s.getString("WitnessName"))); 
                    bookmarkvalue.put("PW133",  Checknull(s.getString("WitnessAnswerPerson"))); 
                   
                         
                        bookmarkvalue.put("B2", Checknull(s.getString("ChargeNameCase")));
                        bookmarkvalue.put("B3", Checknull(s.getString("LawCase")));
                  
                            bookmarkvalue.put("C4",getThaiNumber(ToDate(s.getString("OccuredDate"))));
                            bookmarkvalue.put("C441", ReplaceCollon(s.getString("OccuredTime")));
                            bookmarkvalue.put("C5", getThaiNumber(ToDate(s.getString("CaseAcceptDate"))));
                            bookmarkvalue.put("C551",Checknull(ReplaceCollon(s.getString("CaseAccepTime"))));
                            bookmarkvalue.put("C8", Checknull(s.getString("CrimeLocation")));
                            bookmarkvalue.put("C9", Checknull(s.getString("CrimeLocationMoo")));
                            bookmarkvalue.put("C10", Checknull(s.getString("CrimeLocationSoi")));
                            bookmarkvalue.put("C11", Checknull(s.getString("CrimeLocationRoad")));
                            bookmarkvalue.put("C12", Checknull(s.getString("CrimeLocationDistrict")));
                            bookmarkvalue.put("C13", Checknull(s.getString("CrimeLocationAmphur")));
                            bookmarkvalue.put("C14", Checknull(s.getString("CrimeLocationProvince")));
                            bookmarkvalue.put("C131", getThaiNumber(ToDate(s.getString("OccuredDateEnd"))));
                            bookmarkvalue.put("C132", ReplaceCollon(s.getString("OccuredTimeEnd")));
                            
                           
                                /*
                                bookmarkvalue.put("P02", Checknull(RankPolice));
                                bookmarkvalue.put("P03", Checknull(FirstName));
                                bookmarkvalue.put("P04", Checknull(LastName));
                                bookmarkvalue.put("P05", Checknull(Position));
                                bookmarkvalue.put("P012", Checknull(RankPoliceFull)); //ยศเต็ม
                                bookmarkvalue.put("P013", Checknull(Position)); //ตำแหน่งเต็ม
                    */
                        bookmarkvalue.put("P02", Checknull(s.getString("InvestRank")));
                        bookmarkvalue.put("P03", Checknull(s.getString("InvestName")));
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", Checknull(s.getString("InvestPosition")));
                        bookmarkvalue.put("P010", Checknull(s.getString("InvestTel")));
                        bookmarkvalue.put("P012", Checknull(s.getString("InvestRankFull"))); //ยศเต็ม
                        bookmarkvalue.put("P013", Checknull(s.getString("InvestPosition"))); //ตำแหน่งเต็ม
    
			JSONArray tablecolumn = new JSONArray();
			tablecolumn.add("C2");
			tablecolumn.add("C3");
//			tablecolumn.add("SUSPECT");
//			tablecolumn.add("VICTIM");
//			tablecolumn.add("REMARK");
			JSONArray table1 = new JSONArray();
			JSONObject row1 = new JSONObject();
			row1.put("C2",cs);
			row1.put("C3", ccYear);
//			row1.put("SUSPECT", "period1");
//			row1.put("VICTIM", "period1");
//			row1.put("REMARK", "period1");
			table1.add(row1);
			
//			JSONObject repl2 = new JSONObject();
//			repl2.put("CRIMESNO", "function1");
//			repl2.put("DESCRIPTION", "desc1");
//			repl2.put("SUSPECT", "period1");
//			repl2.put("VICTIM", "period1");
//			repl2.put("REMARK", "period1");
//			table1.add(repl2);
		JSONObject tableobj = new JSONObject();
		tableobj.put("COLUMNS", tablecolumn);
		tableobj.put("TABLEDATA", table1);
			
		JSONArray TABLES = new JSONArray();
		TABLES.add(tableobj);
		bookmarkvalue.put("TABLES", TABLES);
		
		
		
		
                
            }try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w5.docx"));
                        
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/รายงานการสอบสวน" +cs+"-"+ccYear+".doc"));
//                                                        e("D:/สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStaionName+"/ปี"+caseyear+"/"+casetype+caseno+"-"+caseyear);
                        
		}catch( Exception ex) {
			ex.printStackTrace();
//                         JOptionPane.showMessageDialog(null, "ไม่สามารถสร้างไฟล์ได้เนื่องจากไฟล์ถูกเปิดอยู่");
		}
            } catch (Exception e) {
                e.printStackTrace();
               
                JOptionPane.showMessageDialog(null, "");
            }
        
              
	}
public static void nw5() {

         
                 JSONObject bookmarkvalue = new JSONObject();
             
                bookmarkvalue.put("C1","");
                bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
                bookmarkvalue.put("CC2","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("C3","");
                bookmarkvalue.put("C37","");
                bookmarkvalue.put("C38","");
                bookmarkvalue.put("STATUS","");
                bookmarkvalue.put("CTY","");
                
                bookmarkvalue.put("A2", "");
                bookmarkvalue.put("A3", "");
                bookmarkvalue.put("C34", "");
                bookmarkvalue.put("C35", "");
                
                bookmarkvalue.put("S2","");
                bookmarkvalue.put("S02","");
                bookmarkvalue.put("S5","");
                bookmarkvalue.put("S6","");
                bookmarkvalue.put("S27","");
                bookmarkvalue.put("S10","");
                bookmarkvalue.put("S13","");
                bookmarkvalue.put("S14","");
                bookmarkvalue.put("S15","");
                bookmarkvalue.put("S16","");
                bookmarkvalue.put("S19","");
                bookmarkvalue.put("S22","");
                bookmarkvalue.put("S24","");
                bookmarkvalue.put("S34","");
                bookmarkvalue.put("S35","");
                bookmarkvalue.put("S36","");
                
                  bookmarkvalue.put("PA7","");
                  bookmarkvalue.put("PA13", "");
                  bookmarkvalue.put("PA14", "");
                  bookmarkvalue.put("PA15","");
                  bookmarkvalue.put("PA133",""); 
//                    
                    bookmarkvalue.put("PS7",  ""); 
                    bookmarkvalue.put("PS13", "");
                    bookmarkvalue.put("PS14", "");
                    bookmarkvalue.put("PS15", "");
                    bookmarkvalue.put("PS133", "");
                    bookmarkvalue.put("WN", "");
                         
                        bookmarkvalue.put("PW7","");
                        bookmarkvalue.put("PW133","");
                       
                            bookmarkvalue.put("C4","");
                            bookmarkvalue.put("C441", "");
                            bookmarkvalue.put("C12","");
                            bookmarkvalue.put("C5", "");
                            bookmarkvalue.put("C551","");
                            bookmarkvalue.put("C8","");
                            bookmarkvalue.put("C9","");
                            bookmarkvalue.put("C10","");
                            bookmarkvalue.put("C11","");
                            bookmarkvalue.put("C12","");
                            bookmarkvalue.put("C13","");
                            bookmarkvalue.put("C14","");
                                
                                 bookmarkvalue.put("B2","");
                                 bookmarkvalue.put("B3","");
                      
                        bookmarkvalue.put("P02", "");
                        bookmarkvalue.put("P03", "");
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", "");
                        bookmarkvalue.put("P010", "");
                        bookmarkvalue.put("P012", "");
                        bookmarkvalue.put("P013", "");
                   
    
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w5.docx"));
                        
			processVariable(bookmarkvalue,wordMLPackage);
			//processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/รายงานการสอบสวน.doc"));
                        
                        
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }  
            
            
            
        
	public static void processVariable(JSONObject inputdata,WordprocessingMLPackage wordMLPackage) throws Exception {
		Object KEYSET[] = inputdata.keySet().toArray();
		Map<DataFieldName, String> map = new HashMap<DataFieldName, String>();
		for(int i=0;i<KEYSET.length;i++) {
			String KEY = (String)KEYSET[i];
			if(KEY.equals("TABLES")) { continue; }
			map.put(new DataFieldName(KEY), inputdata.get(KEY)+"");
                        System.out.println(KEY+"/"+inputdata.get(KEY)+"");
		}
		org.docx4j.model.fields.merge.MailMerger.performMerge(wordMLPackage, map, true);
	}
	
	public static void processTABLE(JSONObject inputdata,WordprocessingMLPackage wordMLPackage) throws Exception {
		

		JSONArray TABLES = (JSONArray)inputdata.get("TABLES");
		if(TABLES!=null) {
			for(int i=0;i<TABLES.size();i++) {
				JSONObject table  =(JSONObject)TABLES.get(i);
				if(table.get("COLUMNS")==null) {
					System.out.println("FOUND NULL COLUMNS");
					continue;
				}
				if(table.get("TABLEDATA")==null) {
					System.out.println("FOUND NULL TABLEDATA");
					continue;
				}
				replaceTable((JSONArray)table.get("COLUMNS"), (JSONArray)table.get("TABLEDATA"), wordMLPackage);
			}
		}else {
			System.out.println("FOUND NULL TABLES");
		}

	}
	
	
	
	private static Tbl getTemplateTable(List<Object> tables, String templateKey) throws Docx4JException, JAXBException {
		for (Iterator<Object> iterator = tables.iterator(); iterator.hasNext();) {
			Object tbl = iterator.next();
			List<?> textElements = getAllElementFromObject(tbl, Text.class);
			for (Object text : textElements) {
				Text textElement = (Text) text;
				if (textElement.getValue() != null && textElement.getValue().equals(templateKey))
					return (Tbl) tbl;
			}
		}
		return null;
	}
	
	private static void addRowToTable(Tbl reviewtable, Tr templateRow, JSONObject datarow) {
		Tr workingRow = (Tr) XmlUtils.deepCopy(templateRow);
		List<?> textElements = getAllElementFromObject(workingRow, Text.class);
		for (Object object : textElements) {
			Text text = (Text) object;
			String replacementValue = (String) datarow.get(text.getValue());
			if (replacementValue != null) {
				text.setValue(replacementValue);
			}
		}

		reviewtable.getContent().add(workingRow);
	}
	
	private static List<Object> getAllElementFromObject(Object obj, Class<?> toSearch) {
		List<Object> result = new ArrayList<Object>();
		if (obj instanceof JAXBElement) obj = ((JAXBElement<?>) obj).getValue();
		
		if (obj==null) {
			return result;
		}
		if (obj.getClass().equals(toSearch))
			result.add(obj);
		else if (obj instanceof ContentAccessor) {
			List<?> children = ((ContentAccessor) obj).getContent();
			for (Object child : children) {
				result.addAll(getAllElementFromObject(child, toSearch));
			}
		}
		return result;
	}
        
	private static void replaceTable(JSONArray placeholders, JSONArray data,
			WordprocessingMLPackage template) throws Docx4JException, JAXBException {
		List<Object> tables = getAllElementFromObject(template.getMainDocumentPart(), Tbl.class);

		// 1. find the table
		Tbl tempTable = getTemplateTable(tables, (String)placeholders.get(0));
		List<Object> rows = getAllElementFromObject(tempTable, Tr.class);

		// first row is header, second row is content
		if (rows.size() == 2) {
			// this is our template row
			System.out.println("Found Table!! "+(String)placeholders.get(0));
			Tr templateRow = (Tr) rows.get(1);
			
			for(int i=0;i<data.size();i++) {
				// 2 and 3 are done in this method
				JSONObject datarow=(JSONObject)data.get(i);
				addRowToTable(tempTable, templateRow, datarow);
			}

			// 4. remove the template row
			tempTable.getContent().remove(templateRow);
		}
	}
         private static String ToDate(String strDate){
               String ResultDate="";
         try {
    	        if(strDate==null||strDate.equals("")||strDate.equals("null")) { return "";
                }else{
    	       SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy", new Locale("th", "TH"));  
               SimpleDateFormat dateto  = new SimpleDateFormat("d MMMM yyyy", new Locale("th", "TH"));  
               Date date=null;
               
               date = df.parse(strDate);               
               ResultDate=dateto.format(date.getTime());}
         } catch (ParseException ex) {
             Logger.getLogger(W5.class.getName()).log(Level.SEVERE, null, ex);
         }
               return ResultDate;
}
         public static String Checknull(String input){
					if(input==null||input==""||input=="null") { return ""; }
					return getThaiNumber(input);
					}
         public static String ReplaceCollon(String inputTime){
                                        if(inputTime==null||inputTime==""||inputTime=="null") { return ""; }
					return  getThaiNumber(inputTime.replaceAll(":", "."));
					}
    private static String getThaiNumber(String amount) {  
        if(amount == null || amount.isEmpty()) return "";
        String[] DIGIT_TH = { "๐", "๑", "๒", "๓", "๔", "๕", "๖", "๗", "๘", "๙" };
        StringBuilder sb = new StringBuilder();
        for(char c : amount.toCharArray()){
            if(Character.isDigit(c)){
                String index = DIGIT_TH[Character.getNumericValue(c)].toString();
                sb.append(index);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();  
    }  
}

