//package edme.sales_point.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//
//
//@Service
//@RequiredArgsConstructor
//public class RemoteServiceClient {
//
//    private final RestTemplate restTemplate;
//    private final RetryTemplate retryTemplate;
//
//    public String callRemoteService(String url) {
//        return retryTemplate.execute(context -> {
//            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//
//            if (response.getStatusCode().is5xxServerError()) {
//                throw new ServerErrorException("5xx error from remote service");
//            }
//
//            if (response.getStatusCode().is4xxClientError()) {
//                throw new ClientErrorException("4xx error from remote service");
//            }
//
//            if (!response.hasBody() || response.getBody().isEmpty()) {
//                throw new EmptyResponseException("Received empty response from remote service");
//            }
//
//            return response.getBody();
//        });
//    }
//}
//
