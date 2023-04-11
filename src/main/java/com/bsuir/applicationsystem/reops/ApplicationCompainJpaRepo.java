package com.bsuir.applicationsystem.reops;

import com.bsuir.applicationsystem.entity.ApplicationCampaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationCompainJpaRepo extends JpaRepository<ApplicationCampaign,Long> {

}
