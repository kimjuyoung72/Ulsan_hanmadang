package com.kh.pdata.svc;

import lombok.Data;

@Data
public class RfcReq {
    private String serviceKey; //	인증키	100	1	-	인증키
    private String numOfRows; //	페이지 크기	4	0	10	페이지 크기(기본10)
    private String pageNo; //	시작 페이지	4	0	1	시작 페이지(기본1)

    private String searchTitle; //	축제명	50	0	  	축제명
    private String searchPlc; //	개최장소	50	0	  	개최장소
    private String searchUnqId; //	고유번호	10	0	  	고유번호
    private String searchDvsn1; //	분류	4	0	  	분류
    private String searchDvsn2; //	행사월	4	0	  	행사월


}
