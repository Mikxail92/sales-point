package edme.sales_point.controller;


import edme.sales_point.model.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenProvider jwtTokenProvider;
//
//@Autowired
//    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }

    @PostMapping("/login")
    //TODO
    //LoginRequest заменить на другое название

    public String login(@RequestBody LoginRequest loginRequest) {
        // Аутентификация пользователя с использованием AuthenticationManager
        // Если аутентификация успешна, генерируем JWT токен
      //  Authentication authentication = authenticationManager.authenticate(
          //      new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
      //  );
      //  String token = jwtTokenProvider.generateToken(authentication);
      //  return token;
        return  null;
    }
}
