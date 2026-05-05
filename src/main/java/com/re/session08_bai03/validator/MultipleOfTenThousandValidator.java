package com.re.session08_bai03.validator;

import com.re.session08_bai03.annotation.MultipleOfTenThousand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator
        implements ConstraintValidator<MultipleOfTenThousand, Long> {

    private static final long MIN_AMOUNT     = 50_000L;
    private static final long MULTIPLE_UNIT  = 10_000L;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        // Bước 1: Trả về TRUE nếu null
        // Best Practice của Bean Validation: mỗi validator chỉ làm 1 việc.
        // Việc bắt null là trách nhiệm của @NotNull đặt riêng trên DTO.
        if (value == null) {
            return true;
        }

        // Bước 2: Chặn số âm hoặc bằng 0
        if (value <= 0) {
            buildMessage(context, "Số tiền rút phải lớn hơn 0 VNĐ");
            return false;
        }

        // Bước 3: Kiểm tra mức tối thiểu
        if (value < MIN_AMOUNT) {
            buildMessage(context, "Số tiền rút tối thiểu là 50.000 VNĐ");
            return false;
        }

        // Bước 4: Kiểm tra bội số của 10.000
        if (value % MULTIPLE_UNIT != 0) {
            buildMessage(context, "Số tiền rút phải là bội số của 10.000 VNĐ (ví dụ: 50.000, 100.000, 150.000)");
            return false;
        }

        return true;
    }

    /**
     * Ghi đè default message bằng message cụ thể theo từng trường hợp lỗi.
     */
    private void buildMessage(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}