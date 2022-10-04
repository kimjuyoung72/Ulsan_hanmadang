package com.kh.pdata.svc;

/* Java 1.8 샘플 코드 */


import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class ApiExplorerImpl implements ApiExplorer {

   private static final String serviceKey = "TosiBDCx%2BtALve4A1%2FER8fYWhY1mdbEXMlIXJaVgDeIc6Yz1A2xIo5daNZXP7cTjyhh1S0M%2FerWcYnBwi%2BkuKw%3D%3D";

   @Override
   public RfcOpenApi apiCall() {
      String xmlStr = "";
      RfcOpenApi res = null;

      try {
         StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6310000/ulsanfestival/getUlsanfestivalList"); /*URL*/
         urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey); /*Service Key*/
         urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
         urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
//         urlBuilder.append("&" + URLEncoder.encode("searchTitle", "UTF-8") + "=" + URLEncoder.encode("119안전문화축제", "UTF-8")); /*축제명*/
//         urlBuilder.append("&" + URLEncoder.encode("searchPlc", "UTF-8") + "=" + URLEncoder.encode("남구 태화강", "UTF-8")); /*개최장소*/
//         urlBuilder.append("&" + URLEncoder.encode("searchUnqId", "UTF-8") + "=" + URLEncoder.encode("7", "UTF-8")); /*고유번호*/
//         urlBuilder.append("&" + URLEncoder.encode("searchDvsn1", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*분류*/
//         urlBuilder.append("&" + URLEncoder.encode("searchDvsn2", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*행사월*/
         URL url = new URL(urlBuilder.toString());
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
//        conn.setRequestProperty("Content-type", "application/json");
//        conn.setRequestProperty("accept", "application/json");
         conn.setRequestProperty("accept", "application/xml");
         System.out.println("Response code: " + conn.getResponseCode());
         BufferedReader rd;
         if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
         }

         StringBuilder sb = new StringBuilder();
         String line;
         while ((line = rd.readLine()) != null) {
            sb.append(line);
         }
         rd.close();
         conn.disconnect();
         System.out.println(sb.toString());

         xmlStr = sb.toString();

         System.out.println(xmlStr);

         XmlMapper xmlMapper = new XmlMapper();

         //xml to java object
         res = xmlMapper.readValue(xmlStr, RfcOpenApi.class);
         System.out.println(res);

      } catch (Exception e) {
         e.printStackTrace();
      }

      return res;

   }
}