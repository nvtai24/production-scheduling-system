package org.nvtai.production_scheduling_system.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Bắt tất cả các ngoại lệ có thể xảy ra
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, RedirectAttributes redirectAttributes) {
        // Thêm message vào RedirectAttributes để chuyển đến trang gọi API
        redirectAttributes.addFlashAttribute("error", "Có lỗi xảy ra: " + ex.getMessage());
        return "redirect:/employees"; // Chuyển hướng lại về trang danh sách nhân viên
    }
}