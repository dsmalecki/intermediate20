package pl.sda.intermediate;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ValidationService {

    public Map<String, String> validate(RegistrationDTO dto){
        Map<String, String> errorMap = new HashMap<>();

        if (!dto.getFirstName().matches("^[A-Z][a-z]{2,}$")){
            errorMap.put("firstNameValRes",
                    "Imię jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe.");
        }

        if (!dto.getLastName().matches("^[A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?$")){
            errorMap.put("lastNameValRes",
                    "Nazwisko jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe\n" +
                            "        + dopuszczenie \"-\" i drugiego członu z dużej litery");
        }

        if (!dto.getZipCode().matches("^\\d{2}-\\d{3}$")){
            errorMap.put("zipCodeValRes",
                    "Zły format. Kod pocztowy powinien mieć format 12-345.");
        }

        if (StringUtils.isBlank(dto.getCountry())) {
            errorMap.put("countryValRes",
                    "Podanie nazwy kraju jest wymagane.");
        }

        if (StringUtils.isBlank(dto.getStreet())) {
            errorMap.put("streetValRes",
                    "Podanie nazwy ulicy jest wymagane.");
        }


        if (!dto.getBirthDate().matches("^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[01])$")){
            errorMap.put("birthDateValRes",
                    "Zły format. Data urodzin powinna być podana w formacie RRRR-MM-DD i byc poprawna");
        }


        if (!dto.getPesel().matches("^\\d{11}$")){
            errorMap.put("peselValRes",
                    "Zły format. Numer PESEL powinien składać się z 11 cyfr.");
        }


        if (!dto.getEMail().matches("^[\\w-.+]+@[\\w]+(\\.[a-z0-9]{2,3}){1,2}$")){
            errorMap.put("eMailValRes",
                    "Zły format adresu email");
        }


        if (!dto.getPasswordHash().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d]).{10,20}$")){
            errorMap.put("passwordValRes",
                    "Hasło jest wymagane. Musi zawierać od 10 do 20 znaków.");
        }

        return errorMap;
    }
}

    /*
                       Minimum jedna duża, jedna mała litera i jedna cyfra.
        Zły format. Numer telefonu powinien składać się z 9 cyfr.
        -> możliwa opcja z "+48" na początku",
        xxx xxx xxx (spacje) lub xxx-xxx-xxx*/
