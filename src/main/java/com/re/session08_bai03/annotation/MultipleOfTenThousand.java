package com.re.session08_bai03.annotation;

import com.re.session08_bai03.validator.MultipleOfTenThousandValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

/**
 * Custom annotation kiểm tra số tiền rút hợp lệ:
 *   1. Phải >= 50.000 VNĐ
 *   2. Phải là bội số của 10.000 VNĐ
 *
 * Cách dùng: @MultipleOfTenThousand trên field Long trong DTO.
 * Kết hợp với @NotNull để bắt giá trị null.
 */
@Documented
@Constraint(validatedBy = MultipleOfTenThousandValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleOfTenThousand {

    String message() default "Số tiền phải >= 50.000 VNĐ và là bội số của 10.000 VNĐ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}