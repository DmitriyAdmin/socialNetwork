package ru.skillbox.socialnetwork.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileControllerTest {

  private final String PATH_USER = "/users";
  private static final String EMAIL_1 = "sidorovmaxim@mail.ru";//email пользователя для авторизации в тестах (кроме смены эмаил)
  private static final String EMAIL_DEL = "newUser@mail.ru";//для теста удаления юзера которого создали в тест акк контроллер

  @Autowired
    private MockMvc mvc;

  @Autowired
  private ProfileController controller;

    @WithUserDetails(EMAIL_1)
    @Test
    public void correctGetMeTest() throws Exception {
      mvc.perform(get(PATH_USER + "/me")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("id")))
          .andExpect(content().string(containsString("email")))
          .andDo(MockMvcResultHandlers.print());
    }

  @Test
  public void failGetMeTest() throws Exception {
    mvc.perform(get(PATH_USER + "/me")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .with(csrf()))
        .andExpect(status().isUnauthorized())
        //.andExpect(content().string(containsString("error")))
        //.andExpect(content().string(containsString("error_description")))
        .andDo(MockMvcResultHandlers.print());
  }

    @WithUserDetails(EMAIL_1)
    @Test
    public void correctEditMeTest() throws Exception {
      mvc.perform(put(PATH_USER + "/me")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf())
          .content("{\n"
              + "  \"first_name\": \"Петр\",\n"
              + "  \"last_name\": \"Петрович\",\n"
              + "  \"birth_date\": 1559751301818,\n"
              + "  \"phone\": \"89100000000\",\n"
              + "  \"photo_id\": \"o1doj1d91j1d01d-1d1f\",\n"
              + "  \"about\": \"Родился в небольшой, но честной семье\",\n"
              + "  \"town_id\": 123,\n"
              + "  \"country_id\": 33,\n"
              + "  \"messages_permission\": \"ALL\"\n"
              + "}"))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("id")))
          .andExpect(content().string(containsString("email")))
          .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
  @Test
  public void failEditMeTest() throws Exception {
      mvc.perform(put(PATH_USER + "/me")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isBadRequest())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("error_description")))
          .andDo(MockMvcResultHandlers.print());
  }

    @WithUserDetails(EMAIL_DEL)
    @Test
    public void correctDeleteMeTest() throws Exception {
      mvc.perform(delete(PATH_USER + "/me")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("message")))
          .andDo(MockMvcResultHandlers.print());
    }

  @Test
  public void failDeleteMeTest() throws Exception {
    mvc.perform(delete(PATH_USER + "/me")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .with(csrf()))
        .andExpect(status().isUnauthorized())
        //.andExpect(content().string(containsString("error")))
        //.andExpect(content().string(containsString("error_description")))
        .andDo(MockMvcResultHandlers.print());
  }

    @WithUserDetails(EMAIL_1)
    @Test
    public void correctGetTest() throws Exception {
      mvc.perform(get(PATH_USER + "/1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .param("id", "1")
          .with(csrf()))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("id")))
          .andExpect(content().string(containsString("email")))
          .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
  @Test
  public void failGetTest() throws Exception {
        mvc.perform(get(PATH_USER + "/1")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .with(csrf())
            .param("id", "f"))
            .andExpect(status().isBadRequest())
            .andExpect(content().string(containsString("error")))
            .andExpect(content().string(containsString("error_description")))
            .andDo(MockMvcResultHandlers.print());
  }

  @WithUserDetails(EMAIL_1)
  @Test
    public void testGetWall() throws Exception {
      mvc.perform(get(PATH_USER + "/1/wall")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("queue", "false")
                .param("id", "1")
                .param("offset", "1")
                .param("itemPerPage", "20")
                .with(csrf()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

      mvc.perform(get(PATH_USER + "/1/wall")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("queue", "")
                .param("id", "f")
                .param("offset", "")
                .param("itemPerPage", "")
                .with(csrf()))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
  @Test
    public void testPostWall() throws Exception {
      mvc.perform(post(PATH_USER + "/1/wall")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .with(csrf())
                .param("id", "1")
                .param("publishDate",""))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

      mvc.perform(post(PATH_USER + "/1/wall")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .with(csrf())
                .param("id", "f")
                .param("publishDate",""))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
  @Test
    public void testSearch() throws Exception {
      mvc.perform(get(PATH_USER + "/search")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .with(csrf())
                .param("first_name","a")
                .param("last_name","b")
                .param("age_from","1")
                .param("age_to","2")
                .param("country_id","1")
                .param("city_id","2")
                .param("offset", "2")
                .param("itemPerPage", "2"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

      mvc.perform(get(PATH_USER + "/search")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .with(csrf())
                .param("first_name","")
                .param("last_name","")
                .param("age_from","")
                .param("age_to","")
                .param("country_id","")
                .param("city_id","")
                .param("offset", "")
                .param("itemPerPage", ""))
                .andExpect(status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
  @Test
    public void correctBlockTest() throws Exception {
      mvc.perform(put(PATH_USER + "/block/1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf())
          .param("id", "1"))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("message")))
          .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
    @Test
    public void failBlockTest() throws Exception {
      mvc.perform(put(PATH_USER + "/block/1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf()))
          .andExpect(status().isBadRequest())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("error_description")))
          .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
    @Test
    public void correctUnlockTest() throws Exception {
      mvc.perform(delete(PATH_USER + "/block/1")
          .contentType(MediaType.APPLICATION_JSON_UTF8)
          .with(csrf())
          .param("id", "1"))
          .andExpect(status().isOk())
          .andExpect(content().string(containsString("error")))
          .andExpect(content().string(containsString("timestamp")))
          .andExpect(content().string(containsString("data")))
          .andExpect(content().string(containsString("message")))
          .andDo(MockMvcResultHandlers.print());
    }

  @WithUserDetails(EMAIL_1)
  @Test
  public void failUnlockTest() throws Exception {
    mvc.perform(delete(PATH_USER + "/block/ ")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .with(csrf()))
        .andExpect(status().isBadRequest())
        .andExpect(content().string(containsString("error")))
        .andExpect(content().string(containsString("error_description")))
        .andDo(MockMvcResultHandlers.print());
  }
}
