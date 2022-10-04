package com.kh.pdata.api;

import com.kh.pdata.svc.ApiExplorer;
import com.kh.pdata.svc.RfcOpenApi;
import com.kh.pdata.svc.RfcReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pub")
@RequiredArgsConstructor
public class ApiPubDataController {

   private final ApiExplorer apiExplorer;

   @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
   //http://localhost:9080/api/pub/json?searchTitle='###'&searchPlc='###'
   //                               처럼 json? 뒤에 검색 분류에대한 키워드 요청
   public RfcOpenApi getJsonData(@RequestParam("searchTitle")String searchTitle){

      RfcReq rfcReq = new RfcReq();

      rfcReq.setPageNo("1");
      rfcReq.setNumOfRows("10");
      rfcReq.setSearchTitle(searchTitle); //   축제명   50   0        축제명
//      rfcReq.setSearchPlc(); //   개최장소   50   0        개최장소
//      rfcReq.setSearchUnqId(); //   고유번호   10   0        고유번호
   //   rfcReq.setSearchDvsn1(searchDvsn1); //   분류   4   0        분류
//      rfcReq.setSearchDvsn2(); //   행사월   4   0        행사월


      RfcOpenApi res = apiExplorer.apiCall(rfcReq);
      return res;
   }


   @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
   public RfcOpenApi getData(@RequestParam("searchTitle")String searchTitle){
//
      RfcReq rfcReq = new RfcReq();

      rfcReq.setPageNo("1");
      rfcReq.setNumOfRows("10");
      // rfcReq.setSearchPlc(searchPlc);
      rfcReq.setSearchTitle(searchTitle);
//
      RfcOpenApi res = apiExplorer.apiCall(rfcReq);
      return res;
   }
}
