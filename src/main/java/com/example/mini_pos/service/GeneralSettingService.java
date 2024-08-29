package com.example.mini_pos.service;


import com.example.mini_pos.model.entity.GeneralSetting;
import com.example.mini_pos.model.response.GeneralSettingResponse;

import java.util.List;

public interface GeneralSettingService {
    GeneralSetting create(GeneralSetting request);
    GeneralSetting getById(Long id);
    GeneralSetting update(Long id, GeneralSetting update);
    List<GeneralSettingResponse> listAll();
    GeneralSetting deleteById(Long id);
}
