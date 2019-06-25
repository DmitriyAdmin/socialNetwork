package ru.skillbox.socialnetwork.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.skillbox.socialnetwork.api.response.AttachmentApi;
import ru.skillbox.socialnetwork.config.AppConfig;
import ru.skillbox.socialnetwork.model.PostFile;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig.class)
public class PostFileMapperTest {
    @Autowired
    private ModelMapper mapper;

    @Test
    public void testEntityToApi()
    {
        //заполняем поля
        PostFile postFile = new PostFile();
        postFile.setId(343);
        postFile.setName("text.txt");
        postFile.setPath("res/directory/text.txt");
        postFile.setPostId(232);

        //мапим и сравниваем
        AttachmentApi attachmentApi = mapper.map(postFile, AttachmentApi.class);
        assertEquals(postFile.getId(), attachmentApi.getId());
        assertEquals(postFile.getName(), attachmentApi.getName());
        assertEquals(postFile.getPath(), attachmentApi.getPath());
        assertEquals(String.valueOf(postFile.getPostId()), attachmentApi.getPost_id());
    }

    @Test
    public void testApiToEntity()
    {
        //заполняем поля
        AttachmentApi attachmentApi = new AttachmentApi();
        attachmentApi.setId(567);
        attachmentApi.setName("file.txt");
        attachmentApi.setPath("res/gta/");
        attachmentApi.setPost_id("345");

        //мапим и сравниваем
        PostFile postFile = mapper.map(attachmentApi, PostFile.class);
        assertEquals(attachmentApi.getId(), postFile.getId());
        assertEquals(attachmentApi.getName(), postFile.getName());
        assertEquals(attachmentApi.getPath(), postFile.getPath());
        assertEquals(Integer.parseInt(attachmentApi.getPost_id()), postFile.getPostId());
    }
}
