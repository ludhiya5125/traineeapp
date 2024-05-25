package com.wiley.traineeapp.service;

import com.wiley.traineeapp.dto.TraineeDto;
import com.wiley.traineeapp.model.Trainee;
import com.wiley.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.wiley.traineeapp.util.EntityDtoUtil;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TraineeServiceImpl implements TraineeService
{

    private final TraineeRepository repository;

    @Autowired
    public TraineeServiceImpl(TraineeRepository repository) {
        this.repository = repository;
    }

    public TraineeDto saveTrainee(TraineeDto traineeDto) {
        Trainee trainee = repository.saveTrainee(EntityDtoUtil.convertToTraineeEntity(traineeDto));
        return EntityDtoUtil.convertToTraineeDto(trainee);
    }


    public TraineeDto getTrainee(int id) {
        return repository.getTraineeById(id).map(EntityDtoUtil::convertToTraineeDto).orElse(null);
    }


    public TraineeDto getTraineeByName(String name) {
        return repository.getTraineeByName(name).map(EntityDtoUtil::convertToTraineeDto).orElse(null);
    }


    public void deleteTrainee(int id) {
        repository.deleteTrainee(id);
    }

    public List<TraineeDto> getAllTrainees() {
        return repository.getAllTrainees().parallelStream().map(EntityDtoUtil::convertToTraineeDto).toList();
    }
}
