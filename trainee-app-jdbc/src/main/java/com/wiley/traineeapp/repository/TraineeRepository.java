package com.wiley.traineeapp.repository;

import com.wiley.traineeapp.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeRepository
{
     public Trainee saveTrainee(Trainee trainee);
    public Optional<Trainee> getTraineeById(int id);
    public Optional<Trainee>getTraineeByName(String name);
    public List<Trainee> getAllTrainees();
    public void deleteTrainee(int id);
}
