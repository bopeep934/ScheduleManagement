package com.example.schedulemanagement.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {

    private String writer;
    private String password;
    private LocalDate date;
    // private String update;
    private String toDo;


}
