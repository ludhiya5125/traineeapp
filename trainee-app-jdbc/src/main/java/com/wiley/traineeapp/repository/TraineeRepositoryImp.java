package com.wiley.traineeapp.repository;

import com.wiley.traineeapp.TraineeAppJdbcApplication;
import com.wiley.traineeapp.exception.RecordNotFoundException;
import com.wiley.traineeapp.model.Trainee;
import com.wiley.traineeapp.util.TraineeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TraineeRepositoryImp implements TraineeRepository{

    private final JdbcTemplate jdbcTemplate;
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TraineeRepositoryImp.class);

    @Autowired
    public TraineeRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public Trainee saveTrainee(Trainee trainee) {
    int rowCount=jdbcTemplate.update("insert into trainees(trainee_name,email,location)values(?,?,?)",
            trainee.getName(),trainee.getEmail(),trainee.getLocation());
    log.info("Record Saved:"+rowCount);
        if (rowCount > 0) {
            return getTraineeByName(trainee.getName()).get();
        }
        return null;

    }


    public Optional<Trainee> getTraineeById(int id) {
        try{
            Trainee trainee=jdbcTemplate.queryForObject("select * from trainees where id=" +id,new TraineeRowMapper());
            log.info("Found Trainee:"+trainee.toString());
            return Optional.of(trainee);
        }
        catch(DataAccessException ex)
        {
            log.error("Trainee with id:" +id+"Not Found");
            throw new RecordNotFoundException("Trainee with id:" +id+"Not Found");
        }
    }

    public Optional<Trainee> getTraineeByName(String name) {
        Trainee trainee=jdbcTemplate.queryForObject("select * from trainees where trainee_name="+name+"'",new TraineeRowMapper());
        if (trainee==null){
            throw new RecordNotFoundException("Trainee with name : "+name+" Not Found");
        }
        return Optional.of(trainee);
    }


    public List<Trainee> getAllTrainees() {
        return jdbcTemplate.query("select * from trainees", new TraineeRowMapper());

    }


    public void deleteTrainee(int id) {
        jdbcTemplate.update("delete from trainees where id=?",id);
    }
}
