package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ScheduleService {//service 인터페이스
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

    public List<ScheduleResponseDto> findAllSchedule();

    public List<ScheduleResponseDto> findScheduleByWriter(String writer_id);

    public ScheduleResponseDto findScheduleById(Long id);

    public ScheduleResponseDto updateSchedule(Long id, String writer_id, String toDo);

    public void deleteSchedule(Long id, Map<String, String> password);

    public List<ScheduleResponseDto> findScheduleByUpdate(LocalDate upDate);

    public List<ScheduleResponseDto> findScheduleByCondition(String writer, LocalDate upDate);
}