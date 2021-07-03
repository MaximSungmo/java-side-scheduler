package com.maxim.scheduler.model.movie;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * search parameter for get movies http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json
 */
@Getter
@Builder
public class MoviesSearch {

  private String code;
  private String curPage;
  private String itemPerPage;
  private String movieNm;
  private String directorNm;
  private String openStartDt;
  private String openEndDt;
  private String prdtStartYear;
  private String prdtEndYear;
  private String repNationCd;
  private String movieTypeCd;
}
