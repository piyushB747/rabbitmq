package net.kanth.control;

import net.kanth.dto.PayloadCreation;
import net.kanth.service.ServiceCreation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/apiorderplaced")
public class ControlOrderPublished {
    private ServiceCreation serviceCreation;

    public ControlOrderPublished(ServiceCreation serviceCreation) {
        this.serviceCreation = serviceCreation;
    }

    @GetMapping
    public ResponseEntity<?> createuser(@RequestBody PayloadCreation user){
        return new ResponseEntity<>(serviceCreation.crationorder(user), HttpStatus.CREATED);
    }

}
