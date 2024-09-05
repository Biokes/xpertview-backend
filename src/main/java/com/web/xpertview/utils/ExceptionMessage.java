package com.web.xpertview.utils;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    INVALID_DETAILS_PROVIDED("INVALID DETAILS PROVIDED");
    final String message;
    ExceptionMessage(String text){
        this.message=text;
    }
}
