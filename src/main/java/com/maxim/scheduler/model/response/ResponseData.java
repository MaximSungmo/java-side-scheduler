package com.maxim.scheduler.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ResponseData<T> extends CommonResponse {

  private T data;

  public ResponseData() {

  }

  public ResponseData(T data) {
    this.data = data;
  }

  public void setCommonCode(CommonCode commonCode) {
    this.setCode(commonCode.code);
    this.setMessage(commonCode.message);
  }
}