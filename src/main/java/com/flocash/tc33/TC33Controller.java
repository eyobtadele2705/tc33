package com.flocash.tc33;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tc33")
@RequiredArgsConstructor
public class TC33Controller {

    private final TC33Service tc33Service;

    @PostMapping
    public Wrapper processFile() {
        return tc33Service.readFile();
    }
}
