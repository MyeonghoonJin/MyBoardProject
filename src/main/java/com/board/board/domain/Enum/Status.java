package com.board.board.domain.Enum;

import lombok.Getter;

@Getter
public enum Status {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    Status(String value){
        this.value = value;
    }
    private String value;
}
