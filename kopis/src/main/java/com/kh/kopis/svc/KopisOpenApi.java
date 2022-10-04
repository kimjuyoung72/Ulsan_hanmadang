package com.kh.kopis.svc;

import java.util.ArrayList;

public class KopisOpenApi {
    private DBS dbs; // dbs

    static class DBS {

       private ArrayList<List> db; // 공연정보목록

        static class List{

            private String mt20id; // 공연 ID PF132236
            private String prfnm; //공연명 우리연애할까
            private String genrenm; //공연 장르명 연극
            private String prfstate; //공연상태 공연완료
            private String prfpdfrom; //공연시작일 2016.05.12
            private String prfpdto; //공연종료일 2016.07.31
            private String poster; //공연포스터경로
                                    //http://www.kopis.or.kr/upload/pfmPoster/PF_P
                                    // F132236_160704_142630.gif
            private String fcltynm; // 공연시설명(공연장명) 피가로아트홀(구 훈아트홀)
            private String openrun; // 오픈런 Y
        }

    }
}
