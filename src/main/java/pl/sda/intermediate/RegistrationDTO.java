package pl.sda.intermediate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationDTO {
    private String firstName;
    private String lastName;
    private String eMail;
    private String passwordHash;
    private String birthDate;
    private String pesel;
    private String phone;
    private boolean preferEmails;

    private String city;
    private String country;
    private String zipCode;
    private String street;


}
