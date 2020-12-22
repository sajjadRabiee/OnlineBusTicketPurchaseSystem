import Service.Entities.Gender;
import Service.Entities.Role;
import Service.UserService;

public class MainClass {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.registerUser("sajjad","sajjad","8391218227",Gender.male,Role.Admin);
    }
}
