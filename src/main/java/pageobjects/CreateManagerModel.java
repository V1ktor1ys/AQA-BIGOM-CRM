package pageobjects;

import core.Logger;

import java.util.logging.Level;

public class CreateManagerModel {

    public static class Builder {
        String firstNameValue;
        String lastNameValue;
        String emailValue;
        String loginValue;
        String departmentValue;
        int phoneValue;
        String skypeValue;

        public Builder() {
        }

        /**
         * Set First Name
         */
        public Builder setFirstNameValue(String firstNameValue) {
            Logger.getLog(Level.ALL, "Set First Name");

            this.firstNameValue = firstNameValue;
            return this;
        }

        /**
         * Set Last Name
         */
        public Builder setLastNameValue(String lastNameValue) {
            Logger.getLog(Level.ALL, "Set Last Name");

            this.lastNameValue = lastNameValue;
            return this;
        }

        /**
         * Set Email
         */
        public Builder setEmailValue(String emailValue) {
            Logger.getLog(Level.ALL, "Set Email");

            this.emailValue = emailValue;
            return this;
        }

        /**
         * Set Login
         */
        public Builder setLoginValue(String loginValue) {
            Logger.getLog(Level.ALL, "Set Login");

            this.loginValue = loginValue;
            return this;
        }

        /**
         * Set Department
         */
        public Builder setDepartmentValue(String departmentValue) {
            Logger.getLog(Level.ALL, "Set Department");

            this.departmentValue = departmentValue;
            return this;
        }

        /**
         * Set Phone
         */
        public Builder setPhoneValue(int phoneValue) {
            Logger.getLog(Level.ALL, "Set Phone");

            this.phoneValue = phoneValue;
            return this;
        }

        /**
         * Set Skype
         */
        public Builder setSkypeValue(String skypeValue) {
            Logger.getLog(Level.ALL, "Set Skype");

            this.skypeValue = skypeValue;
            return this;
        }

        /**
         * Create Manager Model
         */
        public CreateManagerModel build() {
            Logger.getLog(Level.ALL, "Create Manager Model");

            return new CreateManagerModel();
        }
    }
}