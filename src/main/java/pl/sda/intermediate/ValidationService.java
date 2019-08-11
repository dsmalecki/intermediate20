package pl.sda.intermediate;


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

        return errorMap;
    }
}

    /*
        Nazwisko jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe
        + dopuszczenie "-" i drugiego członu z dużej litery
        Zły format. Kod pocztowy powinien mieć format 12-345.
        Podanie nazwy kraju jest wymagane.
        Podanie nazwy ulicy jest wymagane.
        Zły format. Data urodzin powinna być podana w formacie RRRR-MM-DD
        Zły format. Numer PESEL powinien składać się z 11 cyfr.
        Zły format adresu email
        Hasło jest wymagane. Musi zawierać od 10 do 20 znaków.
        Minimum jedna duża, jedna mała litera i jedna cyfra.
        Zły format. Numer telefonu powinien składać się z 9 cyfr.
        -> możliwa opcja z "+48" na początku",
        xxx xxx xxx (spacje) lub xxx-xxx-xxx*/
