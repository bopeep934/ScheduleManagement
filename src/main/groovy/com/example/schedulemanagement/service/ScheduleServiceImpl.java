package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService {//controller에서 requestDto 객체를 받고 데이터를 처리하는 클래스.

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        Schedule schedule;
        if(dto.getDate()==null&&dto.getUpDate()==null){//만약 생성일,수정일이 비었다면 현재 시간을 인자로 넘기기
            LocalDateTime date=LocalDateTime.now();
            LocalDateTime update=LocalDateTime.now();
            schedule = new Schedule(dto.getWriter_id(), dto.getPassword(), date, update, dto.getToDo());

        }else {
             schedule = new Schedule(dto.getWriter_id(), dto.getPassword(), dto.getDate(), dto.getUpDate(), dto.getToDo());
        }
        return scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedule() {
        return scheduleRepository.findAllSchedule();
    }

    public List<ScheduleResponseDto> findScheduleByWriter(String writer) {
        return scheduleRepository.findScheduleByWriter(writer);
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, String writer, String toDo) {

        // 필수값 검증
        if (writer == null || toDo == null) {//전달받은 인자가 모두 비어있다면 에러 처리
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        // memo 제목 수정
        int updatedRow = scheduleRepository.updateSchedule(id, writer, toDo);
        // 수정된 row가 0개 라면
        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data has been modified.");
        }

        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        // 수정된 메모 조회
        return new ScheduleResponseDto(schedule);

    }


    @Override
    public void deleteSchedule(Long id, Map<String, String> password) {

        // memo 삭제
        int deletedRow = scheduleRepository.deleteSchedule(id,password.get("password"));
        // 삭제된 row가 0개 라면
        if (deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
//        if (deletedRow == 1) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The password is incorrect.");
//
//        }
    }

    @Override
    public List<ScheduleResponseDto> findScheduleByUpdate(LocalDate upDate) {
        return scheduleRepository.findScheduleByUpdate(upDate);
    }

    @Override
    public List<ScheduleResponseDto> findScheduleByCondition(String writer, LocalDate upDate) {
        return scheduleRepository.findScheduleByCondition(writer,upDate);
    }


}
