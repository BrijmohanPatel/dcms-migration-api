package com.lacheln.dcms.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.lacheln.dcms.dto.PlansDTO;
import com.lacheln.dcms.entity.Plans;

public class PlansMapper {
	
	static String trtPlanID;

    public static List<Plans> toEntityList(String tpID, List<PlansDTO> plansDataList) {
        if (plansDataList == null) {
            return null;
        }
        
        trtPlanID = tpID;

        return plansDataList.stream().map(PlansMapper::toEntity).collect(Collectors.toList());
    }

    public static Plans toEntity(PlansDTO plansData) {
        if (plansData == null) {
            return null;
        }

        Plans plans = new Plans();
        plans.setEstimatedAmount(plansData.getEstimatedAmount());
        plans.setLowerLeftTooth(plansData.getLowerLeftTooth());
        plans.setLowerRightTooth(plansData.getLowerRightTooth());       
        plans.setTreatment(plansData.getTreatment());
        plans.setTpId(trtPlanID);
        plans.setUpperLeftTooth(plansData.getUpperLeftTooth());
        plans.setUpperRightTooth(plansData.getUpperRightTooth());
        
        return plans;
    }

    public static List<PlansDTO> toDtoList(List<Plans> plansList) {
        if (plansList == null) {
            return null;
        }

        return plansList.stream().map(PlansMapper::toDto).collect(Collectors.toList());
    }

    public static PlansDTO toDto(Plans plans) {
        if (plans == null) {
            return null;
        }

        PlansDTO plansData = new PlansDTO();
        // Map individual fields
        return plansData;
    }
}
