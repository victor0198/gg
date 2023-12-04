package student.examples.ggengine.game;

import javax.validation.constraints.NotEmpty;

public class SignUpData {
    @NotEmpty(message = "Name cannot be empty")
    public String username;
    @NotEmpty(message = "Password cannot be empty")
    public String password;
}
