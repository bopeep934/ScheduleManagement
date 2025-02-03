package com.example.schedulemanagement.dto;

import com.example.schedulemanagement.entity.Writer;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {

    private String writer_id;
    private String password;
    private LocalDateTime date;
    private LocalDateTime upDate;
    private LocalDate findDate;
    private String toDo;


}
