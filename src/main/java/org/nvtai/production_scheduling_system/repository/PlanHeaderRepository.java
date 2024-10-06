package org.nvtai.production_scheduling_system.repository;

import org.nvtai.production_scheduling_system.entity.PlanHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanHeaderRepository extends JpaRepository<PlanHeader, Long> {

}