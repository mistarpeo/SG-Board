package io.mistarpeo.sgboard.web;

import io.mistarpeo.sgboard.domain.posts.Posts;
import io.mistarpeo.sgboard.domain.posts.PostsRepository;
import io.mistarpeo.sgboard.web.dto.PostsSaveRequestDto;
import io.mistarpeo.sgboard.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }
    @Test
    void save() throws Exception {

        //given
        String title = "test";
        String content = "content";
        String author = "author";

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                                            .title(title).content(content).author(author).build();

        String url = "http://localhost:"+port+"/api/v1/posts";

        //When
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        // find
        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    void update() {
        //given
        String title = "test";
        String content = "content";
        String author = "author";

        String expectTitle = "test2";
        String expectContent = "content2";

        // 저장
        Posts savePosts = postsRepository.save(Posts.builder().title(title).content(content).author(author).build());
        Long updateId = savePosts.getId();


        String url = "http://localhost:"+port+"/api/v1/posts/"+ updateId;

    }

    @Test
    void findById() {
    }
}
