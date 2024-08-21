package com.analyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/charts")
public class ChartDataController {

    @GetMapping("/data")
    public List<Integer> getChartData() {
        return Arrays.asList((int)(Math.random() * 100), (int)(Math.random() * 100), (int)(Math.random() * 100));
    }
}
