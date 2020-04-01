package com.hackaton.cbft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.cbft.Model.PaymentHistoryDTO;

@Repository
public interface PaymentHistory  extends JpaRepository<PaymentHistoryDTO, Long>{

}
