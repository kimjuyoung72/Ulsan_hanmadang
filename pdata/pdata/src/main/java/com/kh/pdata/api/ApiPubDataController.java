package com.kh.pdata.api;

import com.kh.pdata.svc.ApiExplorer;
import com.kh.pdata.svc.RfcOpenApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pub")
@RequiredArgsConstructor
public class ApiPubDataController {

   private final ApiExplorer apiExplorer;

   @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
   public RfcOpenApi getJsonData(){
      RfcOpenApi res = apiExplorer.apiCall();
      return res;
   }


   @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
   public RfcOpenApi getData(){
       RfcOpenApi res = apiExplorer.apiCall();
       return res;
   }
}

