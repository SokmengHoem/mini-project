package com.example.mini_pos.repositories;

import com.example.mini_pos.model.entity.GeneralSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneralSettingRepository extends JpaRepository<GeneralSetting, Long> {
    Optional<GeneralSetting> findByIdAndIsDeletedFalse(Long id);
    List<GeneralSetting> findByIsDeletedFalseOrderByIdDesc();
}
