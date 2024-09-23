package com.board.board.domain;


import com.board.board.domain.Enum.Status;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Table(name="Member")
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Size(min = 6,max = 16)
    @NotEmpty(message = "필수항목입니다.")
    private String id;

    @Size(min = 8,max = 16)
    @NotEmpty(message = "필수항목입니다.")
    private String pwd;

    @Size(min = 2,max = 10)
    @NotEmpty(message = "필수항목입니다.")
    private String name;

    @Enumerated(EnumType.STRING)
/*    @Convert(converter = StatusAttributeConverter.class)*/
    private Status status;


    public Member(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public Member() {

    }
}

/*
//Converter
@Converter
public class StatusAttributeConverter implements AttributeConverter<String,Integer> {
    @Override
    public Integer convertToDatabase(String s){
        if("ADMIN".equals(s)){
            return 1;
        }
        else if("USER".equals(s)){
            return 2;
        }
        return 0;
    }
    @Override
    public String convertToEntityAttribute(Integer c){
        if(1 == c){
            return  "ADMIN";
        }
        else if(2 == c){
            return "USER";
        }
        return "X";
    }
}*/
