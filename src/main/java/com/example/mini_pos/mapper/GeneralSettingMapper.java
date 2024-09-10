package com.example.mini_pos.mapper;

import com.example.mini_pos.model.entity.GeneralSetting;
import com.example.mini_pos.model.request.GeneralSettingRequest;
import com.example.mini_pos.model.response.GeneralSettingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GeneralSettingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    GeneralSetting toEntity(GeneralSettingRequest request);
    GeneralSettingResponse toDTO(GeneralSetting entity);
}
