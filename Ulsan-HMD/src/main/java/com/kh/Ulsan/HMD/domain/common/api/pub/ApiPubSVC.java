package com.kh.Ulsan.HMD.domain.common.api.pub;

import com.kh.Ulsan.HMD.domain.PEvent;
import com.kh.Ulsan.HMD.domain.PFacility;

import java.util.List;
import java.util.Set;

public interface ApiPubSVC {
  List<PEvent> apiCall(String fromDate, String toDate);

  List<PFacility> apiCall2(Set<String> facIds);
}
