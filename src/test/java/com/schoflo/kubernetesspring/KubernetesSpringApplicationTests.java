package com.schoflo.kubernetesspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KubernetesSpringApplicationTests {

    @Test
    void contextLoads() {
        assertEquals(2, 1 + 1);
    }

}
