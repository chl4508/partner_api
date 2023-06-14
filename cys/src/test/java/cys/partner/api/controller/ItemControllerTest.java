package cys.partner.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import cys.partner.api.application.service.ItemService;
import cys.partner.api.entity.Item;
import cys.partner.api.vo.GetItemListRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Disabled
public class ItemControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

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
        Item item = new Item();
        item.setId(UUID.fromString("123e4567-e89b-12d3-a456-556642440000"));
        item.setProfileId(UUID.fromString("a9da7509-3649-4727-8353-c529cf94d96f"));
        item.setAssetType(1);
        item.setTxt(new Item.ItemTxt("한글 제목", "한글 설명"));


        //WHEN
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/item/-/123e4567-e89b-12d3-a456-556642440000?mecheck=true")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(item))
        );

        //THEN
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("id").value(item.getId().toString()))
                .andExpect(jsonPath("profileId").value(item.getProfileId().toString()))
                //.andExpect(jsonPath("worldId").value(item.getWorldId().toString()))
                .andExpect(jsonPath("assetType").value(1))
                .andExpect(jsonPath("txt.title.ko").value("한글 제목"))
                .andExpect(jsonPath("txt.desc.ko").value("한글 설명"))
        ;

    }

    @Test
    @DisplayName("아이템 리스트")
    public void getItemList() throws Exception {
        //GIVEN
        List<Item> list = new ArrayList<>();
        for(int i=0; i < 5; i++){
            Item item = new Item();
            item.setId(UUID.randomUUID());
            item.setProfileId(UUID.randomUUID());
            list.add(item);
        }

        var request = new GetItemListRequest();
        request.setProfileId("123e4567-e89b-12d3-a456-556642440000");
        when(itemService.GetItemList(request)).thenReturn(list);

        //WHEN
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/item/123e4567-e89b-12d3-a456-556642440000")
                .contentType(MediaType.APPLICATION_JSON)
        );

        // THEN
        var result = resultActions.andExpect(status().isOk())
                        .andExpect(jsonPath("$.length()", equalTo(list.size())));
    }

    @Test
    @DisplayName("아이템 생성")
    public void createItem() throws Exception{
        // GIVEN
        Item item = new Item();
        item.setId(UUID.fromString("123e4567-e89b-12d3-a456-556642440000"));
        item.setProfileId(UUID.fromString("a9da7509-3649-4727-8353-c529cf94d96f"));
        item.setAssetType(1);
        String[] hashTag = new String[]{"test", "test2"};
        item.setTxt(new Item.ItemTxt("한글 제목", "한글 설명", hashTag));
        item.setWorldId(UUID.randomUUID());

        //WHEN
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/item/-/123e4567-e89b-12d3-a456-556642440000")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(item))
        );

        //THEN
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("id").value(item.getId().toString()))
                .andExpect(jsonPath("profileId").value(item.getProfileId().toString()))
                .andExpect(jsonPath("worldId").value(item.getWorldId().toString()))
                .andExpect(jsonPath("assetType").value(1))
                .andExpect(jsonPath("txt.title.ko").value("한글 제목"))
                .andExpect(jsonPath("txt.desc.ko").value("한글 설명"))
        ;
    }

    @Test
    @DisplayName("아이템 수정")
    public void updateItem() throws Exception{
        // GIVEN
        Item item = new Item();
        item.setId(UUID.fromString("123e4567-e89b-12d3-a456-556642440000"));
        item.setProfileId(UUID.fromString("a9da7509-3649-4727-8353-c529cf94d96f"));
        item.setAssetType(1);
        String[] hashTag = new String[]{"test", "test2"};
        item.setTxt(new Item.ItemTxt("한글 제목", "한글 설명", hashTag));
        item.setWorldId(UUID.randomUUID());

        //WHEN
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.put("/item/-/123e4567-e89b-12d3-a456-556642440000")
                //.contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(item))
        );

        //THEN
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("id").value(item.getId().toString()))
                .andExpect(jsonPath("profileId").value(item.getProfileId().toString()))
                //.andExpect(jsonPath("worldId").value(item.getWorldId().toString()))
                .andExpect(jsonPath("assetType").value(1))
                .andExpect(jsonPath("txt.title.ko").value("한글 제목"))
                .andExpect(jsonPath("txt.desc.ko").value("한글 설명"))
        ;
    }
}