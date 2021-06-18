package com.maxim.scheduler.controller.movie;

import com.maxim.scheduler.model.response.CommonResponseEntity;
import com.maxim.scheduler.model.response.ResponseData;
import com.maxim.scheduler.service.movie.MovieService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {


  private final MovieService movieService;


  @RequestMapping("/test")
  public ResponseEntity<ResponseData<String>> test() {

    return CommonResponseEntity.of(HttpStatus.OK, "뻑맨~");
  }

  @RequestMapping("/get-movies")
  public ResponseEntity<ResponseData<List<Map>>> getMovies() {

    return CommonResponseEntity.of(HttpStatus.OK, movieService.test().block());
  }
}
