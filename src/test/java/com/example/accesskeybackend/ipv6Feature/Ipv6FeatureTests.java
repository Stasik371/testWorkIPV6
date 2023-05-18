package com.example.accesskeybackend.ipv6Feature;

import com.example.accesskeybackend.ipv6.feature.service.IPV6Service;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.testng.AssertJUnit.*;


@SpringBootTest
public class Ipv6FeatureTests {

    @Autowired
    private IPV6Service ipv6Service;

    @Test
    @DisplayName("If the link is not a URI or Domain")
    void badUrlTest() {
        var badUrl = "Foo";
        assertFalse(ipv6Service.isSupportIPV6(badUrl));
    }

    @Test
    @DisplayName("If the link support Ipv6")
    void ipv6SupportTrueTest(){
        var domain = "www.google.com";
        var uri = "https://www.google.com";
        assertTrue(ipv6Service.isSupportIPV6(domain));
        assertTrue(ipv6Service.isSupportIPV6(uri));
    }

    @Test
    @DisplayName("If the link doesn't support Ipv6")
    void ipv6SupportFalseTest(){
        var domain = "www.vk.com/feed";
        var uri = "https://www.vk.com/feed";
        assertFalse(ipv6Service.isSupportIPV6(domain));
        assertFalse(ipv6Service.isSupportIPV6(uri));
    }
}
