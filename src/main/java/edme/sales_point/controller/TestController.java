package edme.sales_point.controller;

import edme.sales_point.repository.UserAccessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {

    private final UserAccessRepository userAccessRepository;

    @Autowired
    public TestController(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }


    @GetMapping("/hello")
    public String hello() {
        System.out.println(userAccessRepository.findAll());


        return "hello";
    }


}
