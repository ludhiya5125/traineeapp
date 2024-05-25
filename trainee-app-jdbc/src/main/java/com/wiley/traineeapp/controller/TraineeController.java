package com.wiley.traineeapp.controller;

import com.wiley.traineeapp.dto.TraineeDto;
import com.wiley.traineeapp.service.TraineeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
public class TraineeController
{
    @Autowired
    private TraineeService traineeService;

    /*@GetMapping("/views")
    public String viewAllTrainees(Model model){
        List<TraineeDto> trainees = traineeService.getAllTrainees();
        model.addAttribute("trainees",trainees);
        log.info("All Trainees : ");
        trainees.forEach(trainee -> log.info(trainee.toString()));
        return "show-trainees";
    }*/
    @GetMapping("/view-all")
    public String viewTrainees(Model model){
        System.out.println("Getting all the trainees from the DB!!");
        List<TraineeDto> trainees= traineeService.getAllTrainees();
        for(TraineeDto tr: trainees){
            System.out.println(tr);
        }
        model.addAttribute("trainees",trainees);
        return "show-trainees.jsp";
    }

    @GetMapping("/delete-trainee")
    public String deleteTrainee(@RequestParam("id") int id){
        traineeService.deleteTrainee(id);
        return "redirect:/view-all";
    }
}
