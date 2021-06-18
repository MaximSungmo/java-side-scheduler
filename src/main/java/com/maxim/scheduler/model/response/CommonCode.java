package com.maxim.scheduler.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum CommonCode {
  SUCCESS(0, "SUCCESS"),
  FAIL(-1, "FAIL");

  int code;
  String message;

  CommonCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
