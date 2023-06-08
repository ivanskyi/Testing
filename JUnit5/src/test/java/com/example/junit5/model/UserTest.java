package com.example.junit5.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.xmlunit.assertj.XmlAssert;
import java.time.LocalDate;
import java.util.Objects;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("primary")
class UserTest {
    private static final int ALLOWED_USER_AGE = 16;
    private static final String ALEX_NAME = "Alex";
    private static final String XML_CONTENT = "<a><b attr=\"user\"></b></a>";
    private static final String XML_PATH = "//a/b/@attr";
    private static User user;

    @BeforeEach
    void initUser() {
        user = new User("Alex", 35, false, LocalDate.now().minusYears(35));
    }

    @AfterEach
    void destroyUser() {
        user = null;
    }

    @AfterAll
    static void destroyEverythingAfterTesting() {
        if (Objects.nonNull(user)) {
            user = null;
        }
    }

    @Test
    @DisplayName("User age should be more than allowed")
    void userAgeShouldBeMoreThanAllowed() {
        assertTrue(user.age() >= ALLOWED_USER_AGE);
    }

    @Test
    @DisplayName("User name should be equal to Alex")
    void userNameShouldBeEqualToAlex() {
        Assertions.assertThat(user.name()).isEqualTo(ALEX_NAME);
    }

    @Test
    @DisplayName("Is the user blocked")
    void userShouldNotBeBlocked() {
        Assertions.assertThat(user.blocked())
                .as("The %s should not be blocked.", user.name())
                .isFalse();
    }

    @Test
    @DisplayName("Is XML path exist in the XML content")
    void isXMLPathValid() {
        XmlAssert.assertThat(XML_CONTENT)
                .nodesByXPath(XML_PATH)
                .exist();
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 50, 80})
    void isUsersAgesGreaterThanAllowedAge(final int userAge) {
        Assertions.assertThat(userAge).isGreaterThan(ALLOWED_USER_AGE);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/Users.csv", numLinesToSkip = 1)
    void isUsersAgeValidToBuySomething(final String userName, final int age) {
        Assertions.assertThat(age)
                .as("The user %s doesn't have the opportunity to buy something.", userName)
                .isGreaterThan(ALLOWED_USER_AGE);
    }
}
