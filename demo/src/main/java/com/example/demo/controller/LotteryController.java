package com.example.demo.controller;

import com.example.demo.service.LotteryResultService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LotteryController {
    private final LotteryResultService lotteryResultService;

    public LotteryController(LotteryResultService lotteryResultService) {
        this.lotteryResultService = lotteryResultService;
    }

    @GetMapping("/fetch-lottery-results")
    public String fetchAndSaveLotteryResults() {
        try {
            // Step 1: Connect to the website
            String url = "https://www.lotteryusa.com/powerball/";
            Document doc = Jsoup.connect(url).get();

            // Step 2: Parse the HTML to find the lottery results
            Elements resultElements = doc.select(".c-result"); // Update selector if needed
            
            // Step 3: Extract results and save to database
            for (var result : resultElements) {
                String resultNumbers = result.text();
                lotteryResultService.saveResult(resultNumbers);
            }
            return "Lottery results saved to database.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching or saving lottery results.";
        }
    }
}
