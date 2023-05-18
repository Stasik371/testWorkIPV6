package com.example.accesskeybackend.ipv6.feature.controller;


import com.example.accesskeybackend.ipv6.feature.dto.IsIpv6Dto;
import com.example.accesskeybackend.ipv6.feature.service.IPV6Service;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web")

public class IPV6Controller {

    private final IPV6Service ipv6Service;

    @Autowired
    public IPV6Controller(IPV6Service ipv6Service) {
        this.ipv6Service = ipv6Service;
    }

    @GetMapping("/checkIpv6Support")
    @NotNull
    public ResponseEntity<IsIpv6Dto> checkLink(@NotNull @RequestParam String uri) {
        var isSuccess = ipv6Service.isSupportIPV6(uri);
        return new ResponseEntity<>(new IsIpv6Dto(isSuccess), HttpStatus.OK);
    }
}
