package com.example.homework7;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UpdateForm {
    @NotBlank
    @Length(min = 1, max = 20, message = "20文字以内で入力してください")
    private String name;

    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
