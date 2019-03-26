package office;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestCaseMap {		
	static SortedMap<String,String> tm=new TreeMap<String,String>();
			
			public static void createMap(String id,String resultHeadder) throws EncryptedDocumentException, FileNotFoundException, IOException {
				Scanner sc=new Scanner(System.in);
				Workbook wb = WorkbookFactory.create(new FileInputStream("./testdata/testcasedata.xlsx"));
				Sheet sheet = wb.getSheet("Sheet1");
				int lastRowNum = sheet.getLastRowNum();
				int lastCellNum = sheet.getRow(0).getLastCellNum();
				for(int i=1; i<lastRowNum; i++)
				{
					for(int j=0; j<lastCellNum; j++) 
					{						
						String tcId = sheet.getRow(1).getCell(0).toString();
						String result = sheet.getRow(0).getCell(j+1).toString();
						System.out.println(result);
						if(result.equals(resultHeadder)) {
							String resultValue = sheet.getRow(i).getCell(j+1).toString();
							System.out.println(resultValue);
							tm.put(tcId, resultValue);
							break;
						}						
					}
				}
				Set<String> keySet = tm.keySet();
				System.out.println(keySet);				
				System.out.println("Enter test case id to get the status :");
				
				String keyId1 = sc.nextLine();
				String keyId=keyId1.toUpperCase();				
				String res = tm.get(keyId);
				System.out.println("Test case status : "+res);
				new FileInputStream("./testdata/testcasedata.xlsx").close();
				sc.close();
				
			}
			
}
