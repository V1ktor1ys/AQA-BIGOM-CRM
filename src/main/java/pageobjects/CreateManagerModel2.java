package pageobjects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateManagerModel2 {
    public String firstNameValue;
    public String lastNameValue;
    public String emailValue;
    public String loginValue;
    public String departmentValue;
    public int phoneValue;
    public String skypeValue;
}
