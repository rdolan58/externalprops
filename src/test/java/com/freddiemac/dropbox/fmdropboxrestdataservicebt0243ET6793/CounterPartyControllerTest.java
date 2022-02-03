package com.freddiemac.dropbox.fmdropboxrestdataservicebt0243ET6793;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freddiemac.dropbox.FmdropboxRestDataServiceApplication;
import com.freddiemac.dropbox.controller.CounterPartyController;
import com.freddiemac.dropbox.domain.CounterParty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=FmdropboxRestDataServiceApplication.class)
@WebMvcTest(CounterPartyController.class)
public class CounterPartyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    CounterParty record = null;

    @Autowired
    ObjectMapper mapper;

    @Before
    public void setUp() throws Exception {

        this.record = new CounterParty();
        this.record.setActive(true);
        this.record.setCounterPartyRegisteredId("rid1");
        this.record.setCpRegisteredName("rn1");
        this.record.setId("p101010");
 
    }

 
    @Test
    public void getRecord_success() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/fmdropbox/counterparty?id=rid1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.cpRegisteredName", is("rn1")));

    }
}
