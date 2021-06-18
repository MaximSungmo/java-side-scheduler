package com.maxim.scheduler.service.movie;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieService {

  @Autowired
  ObjectMapper objectMapper;


  private MultiValueMap<String, String> getInitKey() {
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("key", "a7924dc313bf66373b45dd9ab51aa790");
    return map;
  }

  private String getURL(String uri, MultiValueMap<String, String> params) {
    MultiValueMap<String, String> parameter = getInitKey();
    params.forEach(parameter::addAll);
    return UriComponentsBuilder.fromHttpUrl(uri).queryParams(params).build().toString();
  }

  private String getURL(String uri) {
    return getURL(uri, getInitKey());
  }


  public Mono<List<Map>> test() {
    final String URI = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json";
    final String URL = getURL(URI);

    WebClient webClient = WebClient.create();

    return webClient.get()
        .uri(URL)
        .retrieve().bodyToFlux(Map.class).collect(Collectors.toList());
  }


}
