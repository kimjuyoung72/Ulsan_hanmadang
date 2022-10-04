package com.kh.hanmadang.svc;

import lombok.Setter;

@Setter
public class KopisReq {
    private MsgBody msgBody;

    static class MsgBody{

        private String service; // 서비스키 60 필수 {서비스키}
        private String stdate;// 공연시작일 8 필수 20160101
        private String eddate;// 공연종료일 8 필수 20160630
        private String cpage;// 현재페이지 3 필수 1
        private String rows;// 페이지당 목록수 3 필수 10
//        private String shcate;// 장르코드 4 AAAA
//        private String shprfnm;// 공연명 100 사랑(URLEncoding)
//        private String shprfnmfct;// 공연시설명 100 예술의전당(URLEncoding)
//        private String prfplccd;// 공연장코드 4 FC000003-01
//        private String signgucode;// 지역(시도)코드 2 11
//        private String signgucodesub;// 지역(구군)코드 4 1111
//        private String kidstate;// 아동공연여부 1 Y(지정안하면 디폴트는 ‘N’)
//        private String prfstate;// 공연상태코드 4 01
    }
}
