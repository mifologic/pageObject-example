package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import guru.qa.pages.RegistrationFormPage;

import static java.lang.String.format;


public class StudentRegistrationFormTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillRegistrationFormTest() {

        Faker faker = new Faker();

        String resourcesPath = "src/test/resources/";

        String studentName = faker.name().firstName();
        String studentLastName = faker.name().lastName();
        String fullName = format("%s %s", studentName, studentLastName);
        String email = faker.internet().emailAddress();
        String gender = StringUtils.capitalize(faker.dog().gender());
        String phone = faker.numerify("9#########");
        String birthDay = "13";
        String birthMonth = "October";
        String birthYear = "1978";
        String birthDate = format("%s %s,%s", birthDay, birthMonth, birthYear);
        String subject = "Maths";
        String hobby = "Music";
        String photo = "bg.jpg";
        String photoFile = format("%s%s", resourcesPath, photo);
        String currentAddress = faker.address().fullAddress();
        String state = "NCR";
        String city = "Delhi";
        String stateAndCity = format("%s %s", state, city);

        registrationFormPage.openPage()
                .setFirstName(studentName)
                .setLastName(studentLastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPhoto(photoFile)
                .setAddress(currentAddress)
                .setCity(state, city)
                .submitForm()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", birthDate)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", photo)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateAndCity)
        ;

    }
}
