package com.lacheln.dcms.mapper;

import java.math.BigDecimal;

import com.lacheln.dcms.dto.TreatmentPlanDTO;
import com.lacheln.dcms.entity.TreatmentPlans;

public class TreatmentPlanMapper {

    public static TreatmentPlans toEntity(TreatmentPlanDTO dto) {
        if (dto == null) {
            return null;
        }

        TreatmentPlans entity = new TreatmentPlans();
        entity.setCaseNo(dto.getCaseNo());
        entity.setTotalAmount(dto.getTotalAmount().toString());
        entity.setRegDate(dto.getRegDate());
        entity.setStatus(dto.getPlanStatus());
        entity.setTotalBalanceAmount(dto.getTotalAmount().toString());
        entity.setTotalPaidAmount("0");

        // Assuming you have a method to convert List<PlansDTO> to List<Plans>
        // entity.setPlans(PlansMapper.toEntityList(dto.getPlans()));

        return entity;
    }

    public static TreatmentPlanDTO toDto(TreatmentPlans entity) {
        if (entity == null) {
            return null;
        }

        TreatmentPlanDTO dto = new TreatmentPlanDTO();
        dto.setTpId(entity.getTpId());
        dto.setCaseNo(entity.getCaseNo());
        dto.setTotalAmount(new BigDecimal(entity.getTotalAmount()));
        dto.setRegDate(entity.getRegDate());
        dto.setPlanStatus(entity.getStatus());

        // Assuming you have a method to convert List<Plans> to List<PlansDTO>
        // dto.setPlans(PlansMapper.toDtoList(entity.getPlans()));

        return dto;
    }
}
