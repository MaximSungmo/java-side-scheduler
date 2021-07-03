package com.maxim.scheduler.repository.movie;

import com.maxim.scheduler.model.movie.MoviesSearch;
import com.maxim.scheduler.util.map.CustomMapUtils;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@Repository
public class MovieRepository {

  private final String key = "a7924dc313bf66373b45dd9ab51aa790";

  private String getURL(String uri, MultiValueMap<String, String> params) {
    params.addIfAbsent("key", key);
    return UriComponentsBuilder.fromHttpUrl(uri).queryParams(params).build().toString();
  }

  private String getURL(String uri) {
    return getURL(uri, new LinkedMultiValueMap<>());
  }

  public Mono<List<Map>> getMovies(MoviesSearch moviesSearch) {
    final String URI = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json";

    String URL = "";
    if (!ObjectUtils.isEmpty(moviesSearch)) {
      URL = getURL(URI, CustomMapUtils.convertObject(moviesSearch));
    }
    URL = getURL(URI);

    WebClient webClient = WebClient.create();

    return webClient.get()
        .uri(URL)
        .retrieve().bodyToFlux(Map.class).collect(Collectors.toList());
  }

}
