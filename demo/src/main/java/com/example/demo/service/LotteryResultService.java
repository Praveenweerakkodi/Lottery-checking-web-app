package com.example.demo.service;

import com.example.demo.entity.LotteryResult;
import com.example.demo.repository.LotteryResultRepository;
import org.springframework.stereotype.Service;

@Service
public class LotteryResultService {
    private final LotteryResultRepository repository;

    public LotteryResultService(LotteryResultRepository repository) {
        this.repository = repository;
    }

    public void saveResult(String resultNumbers) {
        LotteryResult result = new LotteryResult();
        result.setResultNumbers(resultNumbers);
        repository.save(result);
    }
}
