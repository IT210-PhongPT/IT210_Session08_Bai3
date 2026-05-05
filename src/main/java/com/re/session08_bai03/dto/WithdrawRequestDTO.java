package com.re.session08_bai03.dto;

import com.re.session08_bai03.annotation.MultipleOfTenThousand;
import jakarta.validation.constraints.NotNull;

public class WithdrawRequestDTO {

    // @NotNull bắt trường hợp client không gửi field này (null)
    // @MultipleOfTenThousand kiểm tra 2 điều kiện nghiệp vụ còn lại
    @NotNull(message = "Số tiền rút không được để trống")
    @MultipleOfTenThousand
    private Long withdrawAmount;

    // Getters & Setters
    public Long getWithdrawAmount() { return withdrawAmount; }
    public void setWithdrawAmount(Long withdrawAmount) { this.withdrawAmount = withdrawAmount; }
}