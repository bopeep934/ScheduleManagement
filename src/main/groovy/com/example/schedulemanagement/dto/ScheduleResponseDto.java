package com.example.schedulemanagement.dto;

import com.example.schedulemanagement.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor// 이 annotation을 쓰면 필드에 따른 생성자를 자동으로 생성시켜줌. 그래서 따로 생성자를 작성하지 않아도 괜찮음.
public class ScheduleResponseDto {

    private Long id;
    private String writer;
    private LocalDate date;
    //  private String update;
    private String toDo;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.writer = schedule.getWriter();
        this.date = schedule.getDate();
        this.toDo = schedule.getToDo();
    }
}
