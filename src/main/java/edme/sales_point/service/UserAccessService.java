package edme.sales_point.service;

import edme.sales_point.dto.RegistrationUserDTO;
import edme.sales_point.exception.NotCreateNewUserException;
import edme.sales_point.model.UserAccess;
import edme.sales_point.model.UserRole;
import edme.sales_point.repository.UserAccessRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserAccessService implements UserDetailsService {

    private final UserAccessRepository userAccessRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccess userAccess = findByUserAccessLogin(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Пользователь с '%s' не найден.", username)));
        GrantedAuthority authority = new SimpleGrantedAuthority(userAccess.getUserRole().name());
        return new User(userAccess.getUserLogin(),
                userAccess.getUserPassword(),
                Collections.singletonList(authority));
    }

    public Optional<UserAccess> findByUserAccessLogin(String login) {
        return userAccessRepository.findByUserLogin(login);
    }

    public void createNewUser(RegistrationUserDTO registrationUserDTO) {
        if (userAccessRepository.findByUserLogin(registrationUserDTO.getUserLogin()).isEmpty()) {
            UserAccess userAccess = UserAccess.builder()
                    .userLogin(registrationUserDTO.getUserLogin())
                    .userPassword(passwordEncoder.encode(registrationUserDTO.getUserPassword()))
                    .fullName(registrationUserDTO.getFullName())
                    .userRole(UserRole.ROLE_USER)
                    .build();
            log.warn(userAccess.toString());
            userAccessRepository.save(userAccess);
        } else {
            log.warn("Пользователь с таким логином уже существует");
            throw new NotCreateNewUserException("Пользователь с таким логином уже существует(Exception)");
        }
    }

}
