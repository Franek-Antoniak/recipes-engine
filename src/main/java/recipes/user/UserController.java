package recipes.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    // TODO: 30.06.2021 New functionality - PostMapping receives JSON with two fields - You probably need to create
    //  some type of UserDTO but dunno yet. These fields are email and password. If there is no user in H2 with
    //  specified email you have to create this User, and responds with 200(OK). If user is already in H2 you should
    //  respond with 400(Bad Request). Make validation on fields - both are required, password should be validated by
    //  pattern - regex and email by @Email annotation from javax.validation. If the UserCreate doesn't meet
    //  restrictions respond with 400(Bad Request). Do not forget to user some type of encoder right before storing
    //  these values in DB - BCryptPasswordEncoder. You can make User as Entity but with passwords a coded and
    //  UserCreate as normal not encoded password everything should work.

    // TODO: 30.06.2021 Remember about, that everything except registration should be available only to the registered,
    //  authenticated, and authorized users. Otherwise response with 401(Unauthorized).

    // TODO: 30.06.2021 You should make some kind of relations between Recipe and User
    //  - OneToMany - One User can have several recipes.


}
