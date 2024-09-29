package org.nvtai.production_scheduling_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/index")
    public String forwardToIndex() {
        return "forward:/index.html"; // Chuyển tiếp đến index.html
    }
}