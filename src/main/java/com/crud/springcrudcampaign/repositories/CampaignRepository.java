package com.crud.springcrudcampaign.repositories;


import com.crud.springcrudcampaign.entities.Campaign;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface CampaignRepository extends CrudRepository<Campaign, Long> {

    List<Campaign> findByCampaignName(String campaignName);


}
