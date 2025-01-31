package com.example.schedulemanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {//일정 객체. 일정 하나의 정보를 담고 있다.

    private Long id;// 일정 고유 아이디, 자동 생성
    private String writer;//작성자
    private String password;//비밀번호
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate date;//생성일, 자동 생성
    private LocalDate upDate;//수정일, 자동 생성
    private String toDo;//할일


    public Schedule(String writer, String password, LocalDate date, String toDo) {//최초 생성 시 생성자
        this.writer = writer;
        this.password = password;
        this.date = date;
        this.toDo = toDo;
    }

    public Schedule(Long id, String writer, LocalDate date, String toDo) {//최초 생성 시 생성자
        this.id = id;
        this.writer = writer;
        this.date = date;
        this.toDo = toDo;
    }

    public void update(LocalDate upDate, String writer, String toDo) {//수정1: 전체적으로 수정날짜와 할일을 수정 한다. 갑자기 든 생각인데 자동생성 수정날짜를 굳이 메소드로 구현할 필요가 있을까?
        //생각해보니 답은 yes인게(아마도), 고유 번호는 절대적이지만 이건 절대적이지 않으니까.
        this.upDate = upDate;
        this.toDo = toDo;
    }

    public void updateWriter(LocalDate upDate, String writer) {//수정2. 작성자만 수정
        this.upDate = upDate;
        this.writer = writer;
    }

    public void updateToDo(LocalDate upDate, String toDo) {//수정3. 할 일만 수정
        this.upDate = upDate;
        this.toDo = toDo;
    }
}
