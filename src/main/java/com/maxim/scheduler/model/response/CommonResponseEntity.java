package com.maxim.scheduler.model.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonResponseEntity {

  public static <T> ResponseEntity<ResponseData<T>> of(T data) {
    return CommonResponseEntity.of(HttpStatus.OK, data);
  }

  public static <T> ResponseEntity<ResponseData<T>> of(HttpStatus httpStatus, T data) {
    return CommonResponseEntity.of(httpStatus, data, CommonCode.SUCCESS);
  }

  public static <T> ResponseEntity<ResponseData<T>> of(HttpStatus httpStatus, T data,
      CommonCode commonCode) {
    ResponseData<T> responseData = new ResponseData<>(data);
    responseData.setCommonCode(commonCode);
    return ResponseEntity.status(httpStatus).body(responseData);
  }

  public static <T> ResponseEntity<ResponseData<T>> success(HttpStatus httpStatus, T data) {
    ResponseData<T> responseData = new ResponseData<>(data);
    responseData.setCommonCode(CommonCode.SUCCESS);
    return ResponseEntity.status(httpStatus).body(responseData);
  }

  public static <T> ResponseEntity<ResponseData<T>> fail(HttpStatus httpStatus, T data) {
    ResponseData<T> responseData = new ResponseData<>(data);
    responseData.setCommonCode(CommonCode.FAIL);
    return ResponseEntity.status(httpStatus).body(responseData);
  }
}
