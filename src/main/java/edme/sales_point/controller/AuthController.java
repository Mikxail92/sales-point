package edme.sales_point.controller;

import edme.sales_point.dto.*;
import edme.sales_point.exception.AppResponseError;
import edme.sales_point.exception.NotCreateNewUserException;
import edme.sales_point.service.UserAccessService;
import edme.sales_point.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController()
@RequestMapping("/api/sales-point/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAccessService userAccessService;
    private final JwtTokenUtils jwtTokenUtils;
//    private final AuthenticationProvider authenticationProvider;
    private final AuthenticationManager authenticationManager;




    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequestDto authRequest) {
        try {
            //todo Перенеси в сервис и перехват исключений делать через глобальный
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserLogin(),
                    authRequest.getUserPassword()));
        } catch (BadCredentialsException e) {
            log.warn(e.toString());
//            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Не верный логин или пароль."), HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(AppResponseError.builder()
                    .status(HttpStatus.UNAUTHORIZED.value())
                    .message("Не верный логин или пароль.")
                    .build(), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userAccessService.loadUserByUsername(authRequest.getUserLogin());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDto(token));
    }

    @PostMapping("/reg")
    public ResponseEntity<?> createToUser(@RequestBody @Validated RegistrationUserDTO registrationUserDTO,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append("-")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            log.info("Не верные данные для создания пользователя");
            throw new NotCreateNewUserException(errorMessage.toString());
        }

        userAccessService.createNewUser(registrationUserDTO);

        return new ResponseEntity<>(CreatedResponseDto.builder()
                .message (String.format("Пользователь с login %S создан",registrationUserDTO.getUserLogin())).build()
                        ,HttpStatus.CREATED);
    }


    @PostMapping("/info")
    public ResponseEntity<?> info(Principal principal) {
        log.warn(principal.toString());
        return ResponseEntity.ok(principal.getName());
    }
}
