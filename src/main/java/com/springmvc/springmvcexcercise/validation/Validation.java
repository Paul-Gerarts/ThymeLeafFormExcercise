package com.springmvc.springmvcexcercise.validation;

import com.springmvc.springmvcexcercise.entities.SecurityRole;
import com.springmvc.springmvcexcercise.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validation {

    public String validatePhoneNumber(String phoneNumber) {
        Pattern regular = Pattern.compile("\\d{3,4}/(\\d{2}.){2}\\d{2}");
        Pattern landCodePrefix = Pattern.compile("\\+\\d{4,5}/(\\d{2}.){2}\\d{2}");
        Matcher matcher1 = regular.matcher(phoneNumber.trim());
        Matcher matcher2 = landCodePrefix.matcher(phoneNumber.trim());

        if (matcher1.matches() || matcher2.matches()) {
            return phoneNumber.trim();
        } else {
            throw new ValidationException("The phonenumber must match xxx/xxxxxx, xxxx/xxxxxx, +xxxx/xxxxxx or +xxxxx/xxxxxx");
        }
    }

    public String validateEmail(String email) {
        String correctedEmail = email.trim().toLowerCase();
        Pattern emailPattern = Pattern.compile("(?:[a-z0-9!#$%&'*+\\\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+\\\\/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher matcher = emailPattern.matcher(correctedEmail);

        if (matcher.matches()) {
            return correctedEmail;
        } else {
            throw new ValidationException("You've entered an incorrect emailaddress");
        }
    }

    public SecurityRole getRoleByName(String roleName) {
        switch (roleName) {
            case "admin":
                return SecurityRole.ADMIN;
            default:
            case "user":
                return SecurityRole.USER;
        }
    }
}
