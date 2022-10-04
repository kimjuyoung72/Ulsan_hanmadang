package com.kh.pdata.svc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class RfcOpenApi {
   private Header header;

   @Getter
   @Setter
   @ToString
   static class Header {
      private String resultCode;
      private String resultMsg;
   }

   private Body body;

   @Getter
   @Setter
   @ToString
   static class Body {
      private String pageIndex;
      private String numOfRows;
      private String pageNo;
      private String totalCount;
      private ArrayList<List> data;


      @Getter
      @Setter
      @ToString
      static class List {
         private String unqId;
         private String dvsn1;
         private String dvsn1Nm;
         private String dvsn2;
         private String dvsn2Nm;
         private String sgg;
         private String sggNm;
         private String title;
         private String intr;
         private String roadNmAddr;
         private String lotnoAddr;
         private String rprsTelno;
         private String hmpgAddr;
         private String lot;
         private String lat;
         private String cn;
         private String fstvlBgngYmd;
         private String fstvlEndYmd;
         private String plc;
         private String refDept;
         private String addtCn;
         private String mdfcnDt;

      }
   }
}