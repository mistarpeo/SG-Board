package io.mistarpeo.sgboard.domain.posts;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void save_content() throws Exception {
        String title = "이것이 게시판이다.";
        String content = "나는 게시판";

        Posts saved_posts = postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("mistarpeo@gmail.com").build()
                );
 
        // When
        Optional<Posts> posts = postsRepository.findById(saved_posts.getId());
        if(!posts.isPresent()) {
          throw new Exception();
        }
        assertThat(posts.get().getTitle()).isEqualTo(title);
        assertThat(posts.get().getContent()).isEqualTo(content);

    }

    @Test
    public void BaseTimeEntityTest() {
        //given
        LocalDateTime now = LocalDateTime.of(2023,2,8,0,0,0);
        postsRepository.save(Posts.builder().title("title")
                .content("content").author("author").build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
