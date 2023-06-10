package cys.partner.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cys.partner.api.vo.GetItemRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Disabled
public class ItemControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    public void beforeEach(){
//        objectMapper = Jackson2ObjectMapperBuilder.json()
//                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//                .modules(new JavaTimeModule())
//                .build();
    }

    @Test
    @DisplayName("아이템 조회")
    public void getItem() throws Exception{
        // GIVEN
        GetItemRequest itemRequest = new GetItemRequest();
        itemRequest.setItemId("123e4567-e89b-12d3-a456-556642440000");
        itemRequest.setMeCheck(false);

        //WHEN
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/item/-/123e4567-e89b-12d3-a456-556642440000?mecheck=true")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(itemRequest))
        );

        //THEN
        resultActions.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value("123e4567-e89b-12d3-a456-556642440000"))
                .andExpect(jsonPath("profileId").value("a9da7509-3649-4727-8353-c529cf94d96f"))
                .andExpect(jsonPath("worldId").value("0154fd0b-067b-48db-9cbc-b83f3842e823"))
                .andExpect(jsonPath("assetType").value(1))
                .andExpect(jsonPath("$.txt.title.ko").value("한글 제목"))
                .andExpect(jsonPath("$.txt.desc.ko").value("한글 설명"))
        ;

    }

    @Test
    @DisplayName("아이템 리스트")
    public void getItemList() {
    }

    @Test
    @DisplayName("아이템 생성")
    void createItem() {
    }

    @Test
    @DisplayName("아이템 수정")
    void updateItem() {
    }
}