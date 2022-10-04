package com.kh.pdata;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class rfcOpenApi {
   private Header header;
   @Getter
   @Setter
   static class Header {
      private String resultCode;
      private String resultMsg;
   }
   private Body body;

   @Getter
   @Setter
   static class Body {
      private String pageIndex;
      private String numOfRows;
      private String pageNo;
      private String totalCount;
      private Data data;

      @Getter
      @Setter
      static class Data {
         private List list;
         @Getter
         @Setter

         static class List {
            private String unqId;
            private String dvsn1;
            private String dvsn1Nm;
            private String dvsn2;
            private String dvsn2Nm;
            private String sgg;
            private String sggNm;
            private String title;//
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

            @Override
            public String toString() {
               return "List{" +
                     "unqId='" + unqId + '\n' +
                     ", dvsn1='" + dvsn1 + '\n' +
                     ", dvsn1Nm='" + dvsn1Nm + '\n' +
                     ", dvsn2='" + dvsn2 + '\n' +
                     ", dvsn2Nm='" + dvsn2Nm + '\n' +
                     ", sgg='" + sgg + '\n' +
                     ", sggNm='" + sggNm + '\n' +
                     ", title='" + title + '\n' +
                     ", intr='" + intr + '\n' +
                     ", roadNmAddr='" + roadNmAddr + '\n' +
                     ", lotnoAddr='" + lotnoAddr + '\n' +
                     ", rprsTelno='" + rprsTelno + '\n' +
                     ", hmpgAddr='" + hmpgAddr + '\n' +
                     ", lot='" + lot + '\n' +
                     ", lat='" + lat + '\n' +
                     ", cn='" + cn + '\n' +
                     ", fstvlBgngYmd='" + fstvlBgngYmd + '\n' +
                     ", fstvlEndYmd='" + fstvlEndYmd + '\n' +
                     ", plc='" + plc + '\n' +
                     ", refDept='" + refDept + '\n' +
                     ", addtCn='" + addtCn + '\n' +
                     ", mdfcnDt='" + mdfcnDt + '\n' +
                     '}';
            }
         }
      }
   }
}