package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.GeneralSetting;
import com.example.mini_pos.model.request.GeneralSettingRequest;
import com.example.mini_pos.model.response.GeneralSettingResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneralSettingMapper {
    GeneralSetting toEntity(GeneralSettingRequest request);
    GeneralSettingResponse toDTO(GeneralSetting entity);
}
