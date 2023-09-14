/**
 * anji-allways.com Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.nikki.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nikki.out.Print;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * <pre>
 *
 * </pre>
 *
 * @author wangyanjun
 * @version $Id: ExcelDemo.java, v 0.1 2018年1月24日 下午3:16:37 wangyanjun Exp $
 */
public class ExcelSample {

    /**
     * <pre>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
//        try {
//            jxlWrite();
//        } catch (WriteException | IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        try {
            jxlRead5();
        } catch (BiffException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * jxl写Excel
     * 
     * @author jianggujin
     * @throws IOException 
     * @throws WriteException 
     * @throws RowsExceededException 
     * 
     */
    private static void jxlWrite() throws IOException, RowsExceededException, WriteException {
        File xlsFile = new File("D:/jxl.xls");
        // 创建一个工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
        // 创建一个工作表
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                // 向工作表中添加数据
                sheet.addCell(new Label(col, row, "data" + row + col));
            }
        }
        workbook.write();
        workbook.close();
    }
    
    private static void jxlRead() throws BiffException, IOException {
        File oldxlsFile = new File("D:/old.xls");
        File newxlsFile = new File("D:/new.xls");
        // 获得工作簿对象
        Workbook workbookold = Workbook.getWorkbook(oldxlsFile);
        Workbook workbooknew = Workbook.getWorkbook(newxlsFile);
        // 获得所有工作表
        Sheet[] sheetsold = workbookold.getSheets();
        Sheet[] sheetsnew = workbooknew.getSheets();
        // 遍历工作表
        if (sheetsold != null)
        {
//           for (Sheet sheet : sheets)
            Sheet sheet1 = sheetsold[0];
            Sheet sheet2 = sheetsnew[0];
           {
              // 获得行数
              int rows1 = sheet1.getRows();
              int rows2 = sheet2.getRows();
//              // 获得列数
//              int cols = sheet1.getColumns();
              // 读取数据
              for (int row1 = 1; row1 < rows1; row1++)
              {
//                 for (int col = 0; col < cols; col++)
//                 {
//                    System.out.printf("%10s", sheet.getCell(col, row)
//                          .getContents());
//                 }
                 Cell oldCell = sheet1.getCell(0, row1);
                 boolean flag = false;
                 for (int row2 = 1; row2 < rows2; row2++) {
                     Cell newCell = sheet1.getCell(1, row2);
                     if (oldCell.getContents().replaceAll(" ", "").equalsIgnoreCase(newCell.getContents().replaceAll(" ", ""))) {
                         flag = true;
                         break;
                     }
                 }
                 if (!flag) {
                    System.out.printf("old is not in new#%d##%s", row1, sheet1.getCell(0, row1)
                          .getContents());
                 }
                 System.out.println();
              }
           }
        }
        workbookold.close();
        workbooknew.close();
    }
    
    private static void jxlRead2() throws BiffException, IOException {
        File oldxlsFile = new File("D:/old.xls");
        File newxlsFile = new File("D:/new.xls");
        // 获得工作簿对象
        Workbook workbookold = Workbook.getWorkbook(oldxlsFile);
        Workbook workbooknew = Workbook.getWorkbook(newxlsFile);
        // 获得所有工作表
        Sheet[] sheetsold = workbookold.getSheets();
        Sheet[] sheetsnew = workbooknew.getSheets();
        // 遍历工作表
        if (sheetsold != null)
        {
//           for (Sheet sheet : sheets)
            Sheet sheet2 = sheetsold[0];
            Sheet sheet1 = sheetsnew[0];
            {
                // 获得行数
                int rows1 = sheet1.getRows();
                int rows2 = sheet2.getRows();
//              // 获得列数
//              int cols = sheet1.getColumns();
                // 读取数据
                for (int row1 = 1; row1 < rows1; row1++)
                {
//                 for (int col = 0; col < cols; col++)
//                 {
//                    System.out.printf("%10s", sheet.getCell(col, row)
//                          .getContents());
//                 }
                    Cell oldCell = sheet1.getCell(0, row1);
                    boolean flag = false;
                    for (int row2 = 1; row2 < rows2; row2++) {
                        Cell newCell = sheet1.getCell(0, row2);
                        if (oldCell.getContents().replaceAll(" ", "").equalsIgnoreCase(newCell.getContents().replaceAll(" ", ""))) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.printf("new is not in old#%d##%s", row1, sheet1.getCell(1, row1)
                            .getContents());
                    }
                    System.out.println();
                }
            }
        }
        workbookold.close();
        workbooknew.close();
    }
    
    /**
     * 
     * <pre>
     * 统计excel数据
     * </pre>
     *
     * @throws BiffException
     * @throws IOException
     */
    private static void jxlRead3() throws BiffException, IOException {
        File oldxlsFile = new File("D:/old.xls");
        HashMap<String, String> id2DealerMap = new HashMap<String, String>();
        HashMap<String, Integer> id2OrderSumMap = new HashMap<String, Integer>();
        HashMap<String, Integer> id2OrderNewSumMap = new HashMap<String, Integer>();
        HashMap<String, Integer> id2ArrivedMap = new HashMap<String, Integer>();
        HashMap<String, Integer> id2ConfirmedArrivedMap = new HashMap<String, Integer>();
        HashMap<String, Integer> id2AcceptedMap = new HashMap<String, Integer>();
        HashMap<String, Integer> id2BugMap = new HashMap<String, Integer>();
        
        // 获得工作簿对象
        Workbook workbookold = Workbook.getWorkbook(oldxlsFile);
        // 获得所有工作表
        Sheet[] sheetsold = workbookold.getSheets();
        // 遍历工作表
        if (sheetsold != null)
        {
            Sheet oSheet1 = sheetsold[0];
            {
                // 获得行数
                int oRows1 = oSheet1.getRows();
                // 获得列数
                int oCols1 = oSheet1.getColumns();
                // 读取数据
                for (int oRow1 = 1; oRow1 < oRows1; oRow1++)
                {
                    Cell oldCell3 = oSheet1.getCell(2, oRow1);
                    
                    if (null != oldCell3) {
                        String dealerCode = oldCell3.getContents();
                        if (!id2DealerMap.containsKey(dealerCode))  {
                            id2DealerMap.put(dealerCode, oSheet1.getCell(3, oRow1).getContents());
                            id2OrderSumMap.put(dealerCode, 1);
                        } else {
                            int tempSum = id2OrderSumMap.get(dealerCode).intValue() + 1;
                            id2OrderSumMap.put(dealerCode, tempSum);
                        }    
                        
                        Cell oldCell6 = oSheet1.getCell(5, oRow1);
//                    SimpleDateFormat simdate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                    try {
//                        Date date = simdate.parse(oldCell5.getContents());
//                    } catch (ParseException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                        if (null != oldCell6) {
                            String calloffTimeStr = oldCell6.getContents().intern();
                            if (calloffTimeStr.contains("/19")) {
                                if (!id2OrderNewSumMap.containsKey(dealerCode)) {
                                    id2OrderNewSumMap.put(dealerCode, 1);
                                } else {
                                    int tempSum = id2OrderNewSumMap.get(dealerCode).intValue() + 1;
                                    id2OrderNewSumMap.put(dealerCode, tempSum);
                                }
                            }
                        }
                        
                        //已到达
                        Cell oldCell5 = oSheet1.getCell(4, oRow1);
                        if (null != oldCell5) {
                            String arrivedStatus = oldCell5.getContents().intern();
                            if (arrivedStatus.contains("已到达")) {
                                if (!id2ArrivedMap.containsKey(dealerCode)) {
                                    id2ArrivedMap.put(dealerCode, 1);
                                } else {
                                    int tempSum = id2ArrivedMap.get(dealerCode).intValue() + 1;
                                    id2ArrivedMap.put(dealerCode, tempSum);
                                }
                            } else if (arrivedStatus.contains("已确认到达")) {
                                if (!id2ConfirmedArrivedMap.containsKey(dealerCode)) {
                                    id2ConfirmedArrivedMap.put(dealerCode, 1);
                                } else {
                                    int tempSum = id2ConfirmedArrivedMap.get(dealerCode).intValue() + 1;
                                    id2ConfirmedArrivedMap.put(dealerCode, tempSum);
                                }
                            }
                        }
                        
                        //已签收
                        Cell oldCell7 = oSheet1.getCell(6, oRow1);
                        if (null != oldCell7) {
                            String accepteddStatus = oldCell7.getContents().intern();
                            if (accepteddStatus.contains("是")) {
                                if (!id2AcceptedMap.containsKey(dealerCode)) {
                                    id2AcceptedMap.put(dealerCode, 1);
                                } else {
                                    int tempSum = id2AcceptedMap.get(dealerCode).intValue() + 1;
                                    id2AcceptedMap.put(dealerCode, tempSum);
                                }
                            }
                        }
                        
                        //质损车
                        Cell oldCell11 = oSheet1.getCell(10, oRow1);
                        if (null != oldCell11) {
                            String bugStatus = oldCell11.getContents().intern();
                            if (bugStatus.contains("有")) {
                                if (!id2BugMap.containsKey(dealerCode)) {
                                    id2BugMap.put(dealerCode, 1);
                                } else {
                                    int tempSum = id2BugMap.get(dealerCode).intValue() + 1;
                                    id2BugMap.put(dealerCode, tempSum);
                                }
                            }
                        }
                        
                    }
                    
                    
                    
                }
            }
        }
        workbookold.close();
        
        File xlsFile = new File("D:/统计.xls");
        // 创建一个工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
        // 创建一个工作表
        WritableSheet sheet = workbook.createSheet("统计结果", 0);
        
        //title
        try {
            sheet.addCell(new Label(0, 0, "经销商名称"));
            sheet.addCell(new Label(1, 0, "经销商编码"));
            sheet.addCell(new Label(2, 0, "订单总数"));
            sheet.addCell(new Label(3, 0, "calloff（2019）订单数"));
            sheet.addCell(new Label(4, 0, "已到达"));
            sheet.addCell(new Label(5, 0, "已确认到达"));
            sheet.addCell(new Label(6, 0, "已签收"));
            sheet.addCell(new Label(7, 0, "有质损签收数"));
        } catch (RowsExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        int index = 1;
        for(String key:id2DealerMap.keySet())
        {
         System.out.println("Key: "+key+" Value: "+id2DealerMap.get(key));
         // 向工作表中添加数据
         try {
             sheet.addCell(new Label(0, index, key));
             sheet.addCell(new Label(1, index, id2DealerMap.get(key)));
             sheet.addCell(new Label(2, index, id2OrderSumMap.get(key).toString()));
             if (null != id2OrderNewSumMap.get(key)) {
                 sheet.addCell(new Label(3, index, id2OrderNewSumMap.get(key).toString()));
             } else {
                 sheet.addCell(new Label(3, index, "0"));
             }
             if (null != id2ArrivedMap.get(key)) {
                 sheet.addCell(new Label(4, index, id2ArrivedMap.get(key).toString()));
             } else {
                 sheet.addCell(new Label(4, index, "0"));
             }
             if (null != id2ConfirmedArrivedMap.get(key)) {
                 sheet.addCell(new Label(5, index, id2ConfirmedArrivedMap.get(key).toString()));
             } else {
                 sheet.addCell(new Label(5, index, "0"));
             }
             if (null != id2AcceptedMap.get(key)) {
                 sheet.addCell(new Label(6, index, id2AcceptedMap.get(key).toString()));
             } else {
                 sheet.addCell(new Label(6, index, "0"));
             }
             if (null != id2BugMap.get(key)) {
                 sheet.addCell(new Label(7, index, id2BugMap.get(key).toString()));
             } else {
                 sheet.addCell(new Label(7, index, "0"));
             }
             index++;
         } catch (WriteException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
        }
        workbook.write();
        try {
            workbook.close();
        } catch (WriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 
     * <pre>
     * 统计excel数据,统计在库车辆的差异
     * </pre>
     *
     * @throws BiffException
     * @throws IOException
     */
    private static void jxlRead4() throws BiffException, IOException {
    	File gds_instock_xlsFile = new File("D:/temp/GDS_dbo_uf_veh_instock.xls");
    	File smil_instock_xlsFile = new File("D:/temp/SMIL库存-2022.12.6.xls");
    	HashMap<String, Integer> vin2RowMap_GDS = new HashMap<String, Integer>();
    	HashMap<String, Integer> vin2RowMap_SMIL = new HashMap<String, Integer>();
    	HashMap<String, Boolean> compareFlagMap = new HashMap<String, Boolean>();
    	
    	// 获得GDS工作簿对象
    	Workbook workbook = Workbook.getWorkbook(gds_instock_xlsFile);
    	// 获得所有工作表
    	Sheet[] sheets = workbook.getSheets();
    	// 遍历工作表
        if (sheets != null)
        {
            Sheet sheet0 = sheets[0];
            {
                // 获得行数
                int rowNumber = sheet0.getRows();
                // 读取数据
                for (int row = 1; row < rowNumber; row++)
                {
                    Cell cell = sheet0.getCell(0, row);
                    
                    if (null != cell) {
                        String vin = cell.getContents();
                        if (vin2RowMap_GDS.containsKey(vin))  {
                        	Print.stringOut("GDS重复vin："+vin+" ---------");
                        } else {
                        	vin2RowMap_GDS.put(vin, row);
                        }    
                    }
                }
            }
        }
        workbook.close();
        // 获得SMIL工作簿对象
        workbook = Workbook.getWorkbook(smil_instock_xlsFile);
        // 获得所有工作表
        sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null)
        {
        	Sheet sheet0 = sheets[0];
        	{
        		// 获得行数
        		int rowNumber = sheet0.getRows();
        		// 读取数据
        		for (int row = 1; row < rowNumber; row++)
        		{
        			Cell cell = sheet0.getCell(0, row);
        			
        			if (null != cell) {
        				String vin = cell.getContents();
        				if (vin2RowMap_SMIL.containsKey(vin))  {
        					Print.stringOut("SMIL重复vin："+vin+" ---------");
        				} else {
        					vin2RowMap_SMIL.put(vin, row);
        				}    
        			}
        		}
        	}
        }
        workbook.close();
        
        // Compare
        for(String vin: vin2RowMap_GDS.keySet()) {
            if (vin2RowMap_SMIL.containsKey(vin)) {
            	compareFlagMap.put(vin, true);
            } else {
            	compareFlagMap.put(vin, false);
            }
        }
    	
        // Write to file
        File xlsFile = new File("D:/temp/diff.xls");
        // 创建一个工作簿
        WritableWorkbook writeWorkbook = Workbook.createWorkbook(xlsFile);
        // 创建一个工作表
        WritableSheet writeSheet = writeWorkbook.createSheet("统计结果", 0);
        
        //title
        try {
        	int index = 0;
        	for(String vin: compareFlagMap.keySet()) {
        		writeSheet.addCell(new Label(0, index, vin));
        		if (compareFlagMap.get(vin)) {
        			writeSheet.addCell(new Label(1, index++, "true"));
        		} else {
        			writeSheet.addCell(new Label(1, index++, "false"));
        		}
        	}
        } catch (RowsExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        writeWorkbook.write();
        try {
        	writeWorkbook.close();
        } catch (WriteException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
    }
    /**
     * 
     * <pre>
     * 生成按key字数统计的中西文hashmap
     * </pre>
     *
     * @throws BiffException
     * @throws IOException
     */
    private static void jxlRead5() throws BiffException, IOException {
    	File trans_xlsFile = new File("E:/data/1.xls");
    	Map<String, String> cn2esMap_GDS = new HashMap<String, String>();
    	
    	// 获得GDS工作簿对象
    	WorkbookSettings set1 = new WorkbookSettings();//读取时的编码规范
    	set1.setEncoding("iso-8859-1");
    	Workbook workbook = Workbook.getWorkbook(trans_xlsFile, set1);
    	// 获得所有工作表
    	Sheet[] sheets = workbook.getSheets();
    	// 遍历工作表
    	if (sheets != null)
    	{
    		Sheet sheet0 = sheets[0];
    		{
    			// 获得行数
    			int rowNumber = sheet0.getRows();
    			Print.stringOut("总行数："+rowNumber+" ---------");
    			// 读取数据
    			for (int row = 0; row < rowNumber; row++)
    			{
    				Cell cell1 = sheet0.getCell(0, row);
    				
    				if (null != cell1) {
    					String cnCotent = new String(cell1.getContents().toString().getBytes("UTF-8"));
    					if (!cnCotent.isEmpty() && 0 != cnCotent.trim().length())  {
    						Cell cell2 = sheet0.getCell(1, row);
    						String esContent = new String(cell2.getContents().toString().getBytes("UTF-8"));;
    						if (esContent.isEmpty() || 0 == esContent.trim().length()) {
    							Print.stringOut("异常，西班牙语为空，行："+row+" ---------");
    						} else {
    							if (cnCotent.equalsIgnoreCase("id")) {
    						      Print.stringOut("------id行："+row+" ---------");
    							} else {
    								cn2esMap_GDS.put(cnCotent, esContent);
//    						    Print.stringOut(cnCotent + " ---------" + esContent);
    							}
    						}
    					} else {
//    						Print.stringOut("异常，空行："+row+" ---------");
    					}    
    				}
    			}
    		}
    	}
    	workbook.close();
    	
    	//替换字符串
    	replace(cn2esMap_GDS, "E:/data/all2.sql");
    }
    
    public static void replace(Map<String, String> replaceMap, String path) {
    	try {
    		//map根据key的长度排序
    		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(replaceMap.entrySet());
    		// 使用list.sort()排序，按key排序
    		list.sort(new Comparator<Map.Entry<String, String>>() {
    			@Override
    			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
    				return new Integer(o1.getKey().length()).compareTo(o2.getKey().length());
    			}
    		});
    		
    		File file = new File(path);
    		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
    		ArrayList<String> strings = new ArrayList<String>();
    		String s;//读取每一行数据
    		while ((s=br.readLine()) != null) {
    			//int i = list.size()-1; i >= 0; i--
    			for (int i = list.size()-1; i >= 0; i--) {
    				String oldStr = list.get(i).getKey();
    				String newStr = list.get(i).getValue();
//    				Print.stringOut("--------行号"+i+"--中文：" + oldStr + "--西班牙语：" + newStr + " ---------");
    				if (s.contains(oldStr)) {
    					s = s.replace(oldStr, newStr);
    				}
    			}
    			strings.add(s); //将数据存入集合
    		}
    		
    		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    		for (String string : strings) {
    			bw.write(string); //一行一行写入数据
    			bw.newLine(); //换行
    		}
    		bw.close();
    		br.close();
    	} catch (Exception e) {
    		Print.stringOut("替换文本异常："+e.getMessage()+" ---------");
    	}
    }
}
