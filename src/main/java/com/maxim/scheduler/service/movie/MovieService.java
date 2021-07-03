package com.maxim.scheduler.service.movie;


import com.maxim.scheduler.model.movie.MoviesSearch;
import com.maxim.scheduler.repository.movie.MovieRepository;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieService {

  private final MovieRepository movieRepository;

  public Mono<List<Map>> getMovies(MoviesSearch moviesSearch) {
    return movieRepository.getMovies(moviesSearch).doOnSuccess(maps -> {
      List<Map> test = maps;

      if (!(maps.size() > 0)) {
        return;
      }
      return maps;
    }).doOnError(Throwable::printStackTrace);

    애 밥주러감;
  }


}
