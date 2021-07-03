package com.maxim.scheduler.util.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
public class CustomMapUtils {

  @Autowired
  private static ObjectMapper objectMapper;

  public CustomMapUtils(ObjectMapper objectMapper) {
    CustomMapUtils.objectMapper = objectMapper;
  }

  public static MultiValueMap<String, String> convertObject(Object object) {
    Map<String, String> moviesSearchMap = objectMapper.convertValue(object, Map.class);
    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
    moviesSearchMap.forEach(multiValueMap::add);
    return multiValueMap;
  }
}
