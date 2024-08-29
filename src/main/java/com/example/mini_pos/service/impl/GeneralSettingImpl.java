package com.example.mini_pos.service.impl;

import com.example.mini_pos.execption.ResourceNotFoundException;
import com.example.mini_pos.mapper.GeneralSettingMapper;
import com.example.mini_pos.model.entity.GeneralSetting;
import com.example.mini_pos.model.response.GeneralSettingResponse;
import com.example.mini_pos.repositories.GeneralSettingRepository;
import com.example.mini_pos.service.GeneralSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralSettingImpl implements GeneralSettingService {

    @Autowired
    private GeneralSettingRepository generalSettingRepository;

    @Autowired
    private GeneralSettingMapper generalSettingMapper;

    @Override
    public GeneralSetting create(GeneralSetting request) {
        return generalSettingRepository.save(request);
    }

    @Override
    public GeneralSetting getById(Long id) {
        return generalSettingRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("GeneralSetting", id));
    }

    @Override
    public GeneralSetting update(Long id, GeneralSetting update) {
        GeneralSetting generalSettingUpdate = getById(id);

        for(Field field : GeneralSetting.class.getDeclaredFields()){
            field.setAccessible(true);
            try {
                Object newValue = field.get(update);
                if (newValue != null){
                    field.set(generalSettingUpdate, newValue);
                }
            }catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to update field: " + field.getName(), e);
            }
        }
        return generalSettingRepository.save(generalSettingUpdate);
    }

    @Override
    public List<GeneralSettingResponse> listAll() {
        return generalSettingRepository.findByIsDeletedFalseOrderByIdDesc().stream()
                .map(generalSettingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GeneralSetting deleteById(Long id) {
        GeneralSetting generalSetting = getById(id);
        generalSetting.setDeleted(true);
        return generalSettingRepository.save(generalSetting);
    }
}
