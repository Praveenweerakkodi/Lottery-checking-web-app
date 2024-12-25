package com.example.demo.repository;

import com.example.demo.entity.LotteryResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryResultRepository extends JpaRepository<LotteryResult, Integer> {
}
