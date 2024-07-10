package com.project.rabbit_mq.infra.db.repository;

import com.project.rabbit_mq.infra.db.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
}
