package guru.qa.pages;

import com.codeborne.selenide.Condition;
import guru.qa.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String studentName) {
        $("#firstName").setValue(studentName);
        return this;
    }

    public RegistrationFormPage setLastName(String studentLastName) {
        $("#lastName").setValue(studentLastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        $("#subjectsContainer").$("input").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage uploadPhoto(String file) {
        $("#uploadPicture").uploadFile(new File(file));
        return this;
    }

    public RegistrationFormPage setAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationFormPage setCity(String state, String city) {
        $("#stateCity-wrapper").$("input").setValue(state).pressTab();
        $("#city").$("input").setValue(city).pressTab();
        return this;
    }

    public RegistrationFormPage submitForm() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        $(".modal-title").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
