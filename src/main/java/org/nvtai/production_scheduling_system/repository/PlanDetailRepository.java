package org.nvtai.production_scheduling_system.repository;

import org.nvtai.production_scheduling_system.entity.PlanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDetailRepository extends JpaRepository<PlanDetail, Long> {
}