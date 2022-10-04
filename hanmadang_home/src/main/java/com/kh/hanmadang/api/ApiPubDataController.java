package com.kh.hanmadang.api;


import com.kh.hanmadang.svc.ApiPub;
import com.kh.hanmadang.svc.KopisOpenApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pub")
@RequiredArgsConstructor
public class ApiPubDataController {

    private final ApiPub apiExplorer;

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public KopisOpenApi getJsonData(){
        KopisOpenApi res = apiExplorer.apiCall();
        return res;
    }


    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public KopisOpenApi getData(){
        KopisOpenApi res = apiExplorer.apiCall();
        return res;
    }
}