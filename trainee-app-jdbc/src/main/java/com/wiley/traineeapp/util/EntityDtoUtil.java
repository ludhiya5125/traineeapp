package com.wiley.traineeapp.util;

import com.wiley.traineeapp.dto.TraineeDto;
import com.wiley.traineeapp.model.Trainee;

public class EntityDtoUtil
{
    public static Trainee convertToTraineeEntity(TraineeDto traineeDto) {
        return new Trainee(traineeDto.name(), traineeDto.email(), traineeDto.location());
    }

    public static TraineeDto convertToTraineeDto(Trainee trainee) {
        return new TraineeDto(trainee.getId(), trainee.getName(), trainee.getEmail(), trainee.getLocation());
    }

}
