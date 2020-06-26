/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songkhla.document;

/**
 *
 * @author Petpilin
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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.docx4j.XmlUtils;
import org.docx4j.model.fields.merge.DataFieldName;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Text;
import org.docx4j.wml.Tr;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class W37 {
     public static void w37(String cc) {
     
            Connection conn=null;
            conn=ConnectDatabase.connect();
            PreparedStatement pst=null;
             String cs="";
             String ccYear="";
             String casetype="";
             String caseno="";
             String PoliceStationName="";
             String StationAmphur="";
             String StationProvince="";
             String KK="";
             String BK="";
             String ProvincProsecutor="";
             String TelStation="";
             String RankPolice ="";
             String FirstName ="";
             String LastName ="";
             String Position ="";
             
             
            try {
//               
                    String sqlDataPoliceStation="SELECT * FROM PoliceStation";
                      Statement sp = conn.createStatement();
                  ResultSet rs=sp.executeQuery(sqlDataPoliceStation); 
                  while (rs.next()) {                    
                         PoliceStationName=rs.getString("PoliceStaionName");
                         KK=rs.getString("KK");
                         BK=rs.getString("BK");
                      }
            
                    String sqlDataPolice="SELECT * FROM Police";
                      Statement sp1 = conn.createStatement();
                  ResultSet rs1=sp1.executeQuery(sqlDataPolice); 
                  while (rs1.next()) {                    
                         RankPolice =rs1.getString("RankPolice");
                         FirstName=rs1.getString("FirstName");
                         LastName=rs1.getString("LastName");
                         Position=rs1.getString("Position");
                      }
                  
                   String sql="select crimecase.*,ChargeCase.*,ActionsCaseData.*,Person.*\n" +
                               "from crimecase \n" +
                                "left join ChargeCase on crimecase.caseid=ChargeCase.ChargeCaseid\n" +
                                "left join Person on crimecase.CaseId=Person.caseIdPerson\n" +
                                "left join ActionsCaseData on crimecase.ActionCodeCase = ActionsCaseData.ActionCodeCase\n"+
                                "where crimecase.CaseId='"+cc+"' and Person.TypePerson='ผู้ต้องหา'\n"+
                                "group by crimecase.CaseId";

                   String sqlcc="select crimecase.crimecaseyears as ccYear,crimecase.crimecaseno as ccno,"
                         + "crimecase.casetype as cctype,crimecase.crimecasenoyear as ccnoyear "
                         + "from crimecase where crimecase.CaseId='"+cc+"'";
                               
            Statement st2 = conn.createStatement();
            ResultSet s2=st2.executeQuery(sqlcc); 
            System.out.println(sqlcc);
           
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
             if (s2.next()) {                    
                     cs =s2.getString("ccno");
                    ccYear=s2.getString("ccYear");
                    casetype =s2.getString("cctype");
                    caseno  =s2.getString("ccnoyear");
                      }
                Statement st = conn.createStatement();
            ResultSet s=st.executeQuery(sql); 
                System.out.println(sql);
                JSONObject bookmarkvalue = new JSONObject();
                  bookmarkvalue.put("C1",Checknull(Date));
                bookmarkvalue.put("C01",Checknull(Month));
                bookmarkvalue.put("C001",Checknull(Year));
                 bookmarkvalue.put("CC2",Checknull(caseno));
		bookmarkvalue.put("C2",Checknull(cs));
                bookmarkvalue.put("C3",Checknull(ccYear));
                
                 bookmarkvalue.put("S2",Checknull(PoliceStationName));
                 bookmarkvalue.put("S7", Checknull(KK));
                 bookmarkvalue.put("S8", Checknull(BK));
            if(s.isBeforeFirst()){
            while((s!=null) && (s.next()))
            {    
     
                 bookmarkvalue.put("PS7",  Checknull(s.getString("FullNamePerson"))); 
                 bookmarkvalue.put("PS8",  Checknull(s.getString("FullNamePersonEn"))); 
                 bookmarkvalue.put("PS9",  Checknull(s.getString("OtherName")));
                 bookmarkvalue.put("PS10",  Checknull(s.getString("OtherSurname")));
                 bookmarkvalue.put("PS11",  Checknull(ToDate(s.getString("BirthDay"))));
                 bookmarkvalue.put("PS12",  Checknull(s.getString("FullNamePersonEn")));
                 bookmarkvalue.put("PS13",  Checknull(s.getString("Age")));
                 bookmarkvalue.put("PS14",  Checknull(s.getString("Race")));
                 bookmarkvalue.put("PS15",  Checknull(s.getString("Nationality")));
                 bookmarkvalue.put("PS17",Checknull(s.getString("Occupation")));
                 bookmarkvalue.put("PS18",Checknull(s.getString("Height")));
                 bookmarkvalue.put("PS19",Checknull(s.getString("Weight")));
                 bookmarkvalue.put("PS20",Checknull(s.getString("BloodGroup")));
                 bookmarkvalue.put("PS31",Checknull(s.getString("FatherFullName")));
                 bookmarkvalue.put("PS32",Checknull(s.getString("MotherFullName")));
                 bookmarkvalue.put("PS62",Checknull(s.getString("FatherAddress")));
                 bookmarkvalue.put("PS67",Checknull(s.getString("MotherAddress")));
                 bookmarkvalue.put("PS76",Checknull(s.getString("Office")));
                 bookmarkvalue.put("PS77",Checknull(s.getString("SpouseFullName")));
                 bookmarkvalue.put("PS79",Checknull(s.getString("FriendAddress")));
                 bookmarkvalue.put("PS80",Checknull(s.getString("FavouritePlace")));
                  
                   
                      bookmarkvalue.put("A2", Checknull(s.getString("ActionCrimesCase")));  
                      bookmarkvalue.put("B2", Checknull(s.getString("ChargeNameCase")));
                      
                      
                        bookmarkvalue.put("P02", Checknull(RankPolice));
                       bookmarkvalue.put("P03", Checknull(FirstName));
                        bookmarkvalue.put("P04", Checknull(LastName));
                         bookmarkvalue.put("P05", Checknull(Position));
                         
                           bookmarkvalue.put("C4",Checknull(ToDate(s.getString("OccuredDate"))));
                            bookmarkvalue.put("C441", ReplaceCollon(s.getString("OccuredTime")));
                            
                            bookmarkvalue.put("C5", ToDate(s.getString("CaseAcceptDate")));
                            bookmarkvalue.put("C551", ReplaceCollon(s.getString("CaseAccepTime")));
                            bookmarkvalue.put("C6", ToDate(s.getString("CaseRequestDate")));
                            bookmarkvalue.put("C661", ReplaceCollon(s.getString("CaseRequestTime")));
                            bookmarkvalue.put("C8", Checknull(s.getString("CrimeLocation")));
                            bookmarkvalue.put("C9", Checknull(s.getString("CrimeLocationMoo")));
                            bookmarkvalue.put("C10", Checknull(s.getString("CrimeLocationSoi")));
                            bookmarkvalue.put("C11", Checknull(s.getString("CrimeLocationRoad")));
                            bookmarkvalue.put("C12", Checknull(s.getString("CrimeLocationDistrict")));
                            bookmarkvalue.put("C13", Checknull(s.getString("CrimeLocationAmphur")));
                            bookmarkvalue.put("C14", Checknull(s.getString("CrimeLocationProvince")));
                            bookmarkvalue.put("C15", Checknull(s.getString("DailyNumber")));
                            
                    
                   
    
			JSONArray tablecolumn = new JSONArray();
			tablecolumn.add("C2");
			tablecolumn.add("C3");

			JSONArray table1 = new JSONArray();
			JSONObject row1 = new JSONObject();
			row1.put("C2",cs);
			row1.put("C3", ccYear);

			table1.add(row1);

		JSONObject tableobj = new JSONObject();
		tableobj.put("COLUMNS", tablecolumn);
		tableobj.put("TABLEDATA", table1);
			
		JSONArray TABLES = new JSONArray();
		TABLES.add(tableobj);
		bookmarkvalue.put("TABLES", TABLES);
		System.out.println(bookmarkvalue.toJSONString());
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w37.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/ตำหนิรูปพรรณผู้กระทำความผิด" +cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
            }    
            else{
            try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w37.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			processTABLE(bookmarkvalue,wordMLPackage);
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์"+"/"+PoliceStationName+"/ปี"+ccYear+"/"+casetype+"/"+casetype+cs+"-"+ccYear+"/ตำหนิรูปพรรณผู้กระทำความผิด" +cs+"-"+ccYear+".doc"));
		}catch( Exception ex) {
			ex.printStackTrace();
		}
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
              
	}
     
     public static void nw37() {
     
           
                 JSONObject bookmarkvalue = new JSONObject();
             
               bookmarkvalue.put("C1","");
                 bookmarkvalue.put("C01","");
                bookmarkvalue.put("C001","");
                bookmarkvalue.put("CC2","");
		bookmarkvalue.put("C2","");
                bookmarkvalue.put("C3", "");
                
                 bookmarkvalue.put("S2","");
                 bookmarkvalue.put("S7","");
                 bookmarkvalue.put("S8","");
                 
                
                 bookmarkvalue.put("PS7",""); 
                 bookmarkvalue.put("PS8",""); 
                 bookmarkvalue.put("PS9","");
                 bookmarkvalue.put("PS10","");
                 bookmarkvalue.put("PS11","");
                 bookmarkvalue.put("PS12","");
                 bookmarkvalue.put("PS13","");
                 bookmarkvalue.put("PS14","");
                 bookmarkvalue.put("PS15","");
                 bookmarkvalue.put("PS17","");
                 bookmarkvalue.put("PS18","");
                 bookmarkvalue.put("PS19","");
                 bookmarkvalue.put("PS20","");
                 bookmarkvalue.put("PS31","");
                 bookmarkvalue.put("PS32","");
                 bookmarkvalue.put("PS62","");
                 bookmarkvalue.put("PS67","");
                 bookmarkvalue.put("PS76","");
                 bookmarkvalue.put("PS77","");
                 bookmarkvalue.put("PS79","");
                 bookmarkvalue.put("PS80","");
                  
                   
                      bookmarkvalue.put("A2", "");  
                      bookmarkvalue.put("B2", "");
                      
                      
                        bookmarkvalue.put("P02", "");
                        bookmarkvalue.put("P03", "");
                        bookmarkvalue.put("P04", "");
                        bookmarkvalue.put("P05", "");
                         
                           bookmarkvalue.put("C4","");
                            bookmarkvalue.put("C441","");
                            
                            bookmarkvalue.put("C5", "");
                            bookmarkvalue.put("C551","");
                            bookmarkvalue.put("C6", "");
                            bookmarkvalue.put("C661", "");
                            
                            bookmarkvalue.put("C8", "");
                            bookmarkvalue.put("C9", "");
                            bookmarkvalue.put("C10", "");
                            bookmarkvalue.put("C11", "");
                            bookmarkvalue.put("C12", "");
                            bookmarkvalue.put("C13", "");
                            bookmarkvalue.put("C14", "");
                            bookmarkvalue.put("C15", "");
                            
              
		
		
		try {
                  
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(new java.io.File("./TEMPLATE/w37.docx"));
			processVariable(bookmarkvalue,wordMLPackage);
			
			wordMLPackage.save(new java.io.File("./สำนวนอิเล็กทรอนิกส์/แบบฟอร์มสำนวน/ตำหนิรูปพรรณผู้กระทำความผิด.doc"));
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
    	        if(strDate==null||strDate.equals("")||strDate.equals("null")) { return ""; }else{
    	       SimpleDateFormat df = new SimpleDateFormat("d/MM/yyyy", new Locale("th", "TH"));  
               SimpleDateFormat dateto  = new SimpleDateFormat("d MMMM yyyy", new Locale("th", "TH"));  
               Date date=null;
               
               date = df.parse(strDate);               
               ResultDate=dateto.format(date.getTime());}
         } catch (ParseException ex) {
             Logger.getLogger(W37.class.getName()).log(Level.SEVERE, null, ex);
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
