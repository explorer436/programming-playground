package com.mycompany.carinventory;

import com.mycompany.carinventory.controllers.CarInventoryController;
import com.mycompany.carinventory.services.CarService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class CarInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    CarInventoryController carInventoryController;

    @Mock
    CarService carService;

    @BeforeEach
    public void before() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(carInventoryController)
                .build();
    }

    @SneakyThrows
    @Test
    void shouldCallController() {
        mockMvc.perform(
                get("/api/inventory/car")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
