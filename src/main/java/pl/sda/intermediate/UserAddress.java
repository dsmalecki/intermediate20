package pl.sda.intermediate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAddress {
    private String city;
    private String country;
    private String zipCode;
    private String street;
}
