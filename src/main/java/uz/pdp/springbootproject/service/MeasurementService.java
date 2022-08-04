package uz.pdp.springbootproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.springbootproject.dto.Result;
import uz.pdp.springbootproject.entity.Measurement;
import uz.pdp.springbootproject.repository.MeasurementRepository;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("Bunday o'lchov birligi mavjud",true);
        measurementRepository.save(measurement);
        return new Result("Qo'shildi",false);
    }

}
