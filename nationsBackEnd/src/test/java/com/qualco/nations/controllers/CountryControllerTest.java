package com.qualco.nations.controllers;

import com.qualco.nations.dtos.CountryDTO;
import com.qualco.nations.services.CountryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.reset;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.core.Is.is;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class CountryControllerTest {

    @Mock
    private CountryService countryService;

    @InjectMocks
    private CountryController countryController;

    private MockMvc mockMvc;
    private CountryDTO validCountryDTO;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();

        validCountryDTO.builder()
                .countryId(3)
                .name("Angola")
                .area(new BigDecimal(1246700.00))
                .countryCode2("AO")
                .countryCode3("AGO")
                .regionId(3)
                .build();

    }

    @AfterEach
    void tearDown(){
        reset(countryService);
    }

    @Test
    void fetchAll() throws Exception {
        List<CountryDTO> countryDTOList = getListOfCountryDtos();
        given(countryService.fetchAll()).willReturn(countryDTOList);

        mockMvc.perform(get("/api/v1/country/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].countryId", is(countryDTOList.get(0).getCountryId())))
                .andExpect(jsonPath("$[0].name", is(countryDTOList.get(0).getName())));

    }

    private List<CountryDTO> getListOfCountryDtos(){
        List<CountryDTO> countryDTOList = new ArrayList<>();

        CountryDTO countryDTO1 = CountryDTO.builder()
                .countryId(3)
                .name("Angola")
                .area(new BigDecimal(1246700.00))
                .countryCode2("AO")
                .countryCode3("AGO")
                .regionId(3)
                .build();

        CountryDTO countryDTO2 = CountryDTO.builder()
                .countryId(31)
                .name("Brazil")
                .area(new BigDecimal(8547403.00))
                .countryCode2("BR")
                .countryCode3("BRA")
                .regionId(6)
                .build();

        countryDTOList.add(countryDTO1);
        countryDTOList.add(countryDTO2);
        return countryDTOList;
    }
}