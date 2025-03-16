//package edme.sales_point.controller;
//
//import edme.sales_point.dto.SignInRequest;
//import edme.sales_point.dto.SignUpRequest;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/sales-point/auth")
//public class AuthController {
//
//    private final RestTemplate restTemplate = new RestTemplate();
//    private final String keycloakUrl = "http://keycloak:8080";
//    private final String realm = "edmebank-realm";  // Имя вашего Keycloak realm
//    private final String adminClientId = "admin-cli";  // Клиент для получения токена администратора
//    private final String adminUsername = "admin";  // Имя пользователя администратора
//    private final String adminPassword = "admin";  // Пароль администратора
//
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, Object>> login(@RequestBody SignInRequest request) {
//        String keycloakUrl = "http://keycloak:8080/realms/edmebank-realm/protocol/openid-connect/token";
//        System.out.println("!!!!!!!!!!!!!!!!!!!!");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        // Используем MultiValueMap вместо HashMap
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("grant_type", "password");
//        body.add("client_id", "gateway-client");
//        body.add("username", request.getUserLogin());
//        body.add("password", request.getUserPassword());
//
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<Map> response = restTemplate.exchange(keycloakUrl, HttpMethod.POST, entity, Map.class);
//
//        return ResponseEntity.ok(response.getBody());
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody SignUpRequest request) {
//        // Получаем админский токен
//        String token = getAdminToken();
//        if (token == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Не удалось получить токен администратора");
//        }
//
//        // URL для создания пользователя
//        String createUserUrl = keycloakUrl + "/admin/realms/" + realm + "/users";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(token);
//
//        // Формируем JSON для создания пользователя
//        Map<String, Object> user = new HashMap<>();
//        user.put("username", request.getUserLogin());
//        user.put("email", request.getEmail());
//        user.put("firstName", request.getFirstName());
//        user.put("lastName", request.getLastName());
//        user.put("enabled", true);
//
//        Map<String, String> credentials = new HashMap<>();
//        credentials.put("type", "password");
//        credentials.put("value", request.getUserPassword());
//        credentials.put("temporary", "false");
//
//        user.put("credentials", new Map[]{credentials});
//
//        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(user, headers);
//        ResponseEntity<String> response = restTemplate.exchange(createUserUrl, HttpMethod.POST, entity, String.class);
//
//        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
//    }
//
//    private String getAdminToken() {
//        String tokenUrl = keycloakUrl + "/realms/master/protocol/openid-connect/token";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("grant_type", "password");
//        body.add("client_id", adminClientId);
//        body.add("username", adminUsername);
//        body.add("password", adminPassword);
//
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
//        ResponseEntity<Map> response = restTemplate.exchange(tokenUrl, HttpMethod.POST, entity, Map.class);
//
//        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
//            return (String) response.getBody().get("access_token");
//        }
//        return null;
//    }
//}
