package com.matthewyao.base64decode;

import java.io.*;
import java.net.URLDecoder;

import com.matthewyao.allyes.carpenter.CarpenterLogs;

import sun.misc.BASE64Decoder;

public class Test {

	public static String TimeStamp2Date(String timestampString, String formats){
		Long timestamp = Long.parseLong(timestampString)*1000;
		String date = new java.text.SimpleDateFormat(formats).format(new java.util.Date(timestamp));
		return date;
	}

	public static void main(String[] args) throws Exception{
		FileReader fr;
		FileWriter fw;
		BufferedReader br;
		BufferedWriter bw;
		int i = 1;
		String line;
		try{
			fr = new FileReader("E:/idigger/lines.log");
			fw = new FileWriter("E:/idigger/result.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			while ((line = br.readLine()) != null){
				byte[] b = new BASE64Decoder().decodeBuffer(line);
				CarpenterLogs.RawLog rawLog = CarpenterLogs.RawLog.parseFrom(b);
				String time = TimeStamp2Date(String.valueOf(rawLog.getTimestamp()),"yyyy-MM-dd HH:mm:ss");
				String url = rawLog.getRequestUrl();
				url = url.substring(url.indexOf("ecm=")+4, url.length());
				url = url.substring(0, url.indexOf("&"));
				url = URLDecoder.decode(url, "utf-8");
				url = URLDecoder.decode(url, "utf-8");
				url = URLDecoder.decode(url, "utf-8");
				url = url.replaceAll("`","\t");
				if (url.length()>13 && ! url.startsWith("p")){
//					System.out.println(time + "\t" + url);
					bw.write(time + "\t" + url);
					bw.newLine();
				}
				i++;

//				Field[] fields = rawLog.getClass().getFields();
//				for(Field f : fields){
//					Method m;
//					if (f.getName().equals("PARSER")){
//
//					}
//					else{
//						m = rawLog.getClass().getMethod("get" + f.getName());
//					}
//					String val = m.invoke(rawLog).toString();
//					bw.write(val);
//				}
//				bw.write("\n");
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage()+",i:"+i);
		}
		finally {
		}
	}

}
