package org.example.dbtransactions;

import org.example.dbtransactions.normalized.entity.Hospital;
import org.example.dbtransactions.normalized.interfaces.HospitalInteract;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DbTransactionsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HospitalInteract hospitalInteract;

    @Order(1)
    @DisplayName("Normalized - Lazy fetch non call")
    @Test
    @Transactional(readOnly = true)
    void NormalizedDatabaseLazyFetchNonCall () throws Exception {
        Hospital hospital = hospitalInteract.findById(1L);
        System.out.println(hospital.getName());
    }

    @Order(2)
    @DisplayName("Normalized - Lazy fetch call")
    @Test
    @Transactional(readOnly = true)
    void NormalizedDatabaseLazyFetchCall () throws Exception {
        Hospital hospital = hospitalInteract.findById(1L);
        System.out.println(hospital.getCare().getTypeName());
    }

    @Order(3)
    @DisplayName("Normalized - Eager fetch call")
    @Test
    @Transactional(readOnly = true)
    void NormalizedDatabaseEagerFetchCall () throws Exception {
        Hospital hospital = hospitalInteract.findById(1L);
        System.out.println(hospital.getCountry().getName());
    }
}
