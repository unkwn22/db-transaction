package org.example.dbtransactions;

import com.querydsl.core.Tuple;
import org.example.dbtransactions.association.entity.CustomFamilyCommand;
import org.example.dbtransactions.association.entity.CustomPeopleCommand;
import org.example.dbtransactions.association.entity.People;
import org.example.dbtransactions.association.entity.PeopleFamilyRelation;
import org.example.dbtransactions.association.interfaces.PeopleInteract;
import org.example.dbtransactions.normalized.entity.Hospital;
import org.example.dbtransactions.normalized.interfaces.HospitalInteract;
import org.example.dbtransactions.queryDSL.interfaces.PeopleCustomInteract;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DbTransactionsApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HospitalInteract hospitalInteract;
    @Autowired
    private PeopleInteract peopleInteract;
    @Autowired
    private PeopleCustomInteract peopleCustomInteract;

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

    @Order(4)
    @DisplayName("Associated - Jpa call")
    @Test
    @Transactional(readOnly = true)
    void AssociatedDatabaseJpaCall () throws Exception {
        People youngSun = peopleInteract.findById(4L);
        List<PeopleFamilyRelation> relations = youngSun.getPeopleRelations();
        for(PeopleFamilyRelation relation : relations) {
            System.out.println(relation.getFamily().getName());
        }
    }

    @Order(5)
    @DisplayName("Associated - QueryDsl call")
    @Test
    @Transactional(readOnly = true)
    void AssociatedDatabaseQueryDSLCall () throws Exception {
        List<Tuple> tuples = peopleCustomInteract.findPeopleById(4L);

        CustomPeopleCommand customPeopleCommand = new CustomPeopleCommand();
        customPeopleCommand.setId(tuples.get(0).get(0, Long.class));
        customPeopleCommand.setName(tuples.get(0).get(1, String.class));
        List<CustomFamilyCommand> customFamilyCommands = new ArrayList<>();
        for(Tuple tuple : tuples) {
            CustomFamilyCommand command = new CustomFamilyCommand();
            command.setId(tuple.get(2, Long.class));
            command.setName(tuple.get(3, String.class));
            customFamilyCommands.add(command);
        }
        customPeopleCommand.setFamilies(customFamilyCommands);

        System.out.println("People id: " + customPeopleCommand.getId());
        System.out.println("Name id: " + customPeopleCommand.getName());
        System.out.println("===================================");
        System.out.println("");
        for(CustomFamilyCommand command : customPeopleCommand.getFamilies()) {
            System.out.println("Family id: " + command.getId());
            System.out.println("Family name: " + command.getName());
            System.out.println("===================================");
        }
    }
}
