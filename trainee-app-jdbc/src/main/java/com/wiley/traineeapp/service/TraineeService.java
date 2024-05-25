package com.wiley.traineeapp.service;

import com.wiley.traineeapp.dto.TraineeDto;

import java.util.List;

public interface TraineeService
{
    public TraineeDto saveTrainee(TraineeDto traineeDto);

    public TraineeDto getTrainee(int id);

    public TraineeDto getTraineeByName(String name);

    public void deleteTrainee(int id);

    public List<TraineeDto> getAllTrainees();
}
