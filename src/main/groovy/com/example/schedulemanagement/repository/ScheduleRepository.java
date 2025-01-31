package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);//새로운 일정 추가. 스케쥴 객체를 받아 저장하고 응답 반환.

    List<ScheduleResponseDto> findAllSchedule();//모든 일정 반환

    Optional<Schedule> findScheduleById(Long id);//선택한 일정 반환

    Schedule findScheduleByIdOrElseThrow(Long id);

    int updateSchedule(Long id, String title, String contents);

    int updateTodo(Long id, String toDo);

    int deleteSchedule(Long id,String password);
}
