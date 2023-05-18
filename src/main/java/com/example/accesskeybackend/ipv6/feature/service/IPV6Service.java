package com.example.accesskeybackend.ipv6.feature.service;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;


import java.net.URI;
import java.util.Arrays;


import org.xbill.DNS.*;
import org.xbill.DNS.Record;

@Service
public class IPV6Service {

    public boolean isSupportIPV6(@NotNull String uri) {
        try {
            if(!uri.startsWith("http") && !uri.startsWith("https")){
                uri = "http://" + uri;
            }
            Lookup lookup = new Lookup(URI.create(uri).getHost(), Type.AAAA);
            Record[] resultOfDnsServerLookup = lookup.run();
            if (lookup.getResult() == Lookup.SUCCESSFUL) {
                return Arrays
                        .stream(resultOfDnsServerLookup)
                        .filter(record -> record instanceof AAAARecord)
                        .toList().size() > 0;
            }
        } catch (TextParseException | IllegalArgumentException | NullPointerException e) {
            return false;
        }
        return false;
    }
}
