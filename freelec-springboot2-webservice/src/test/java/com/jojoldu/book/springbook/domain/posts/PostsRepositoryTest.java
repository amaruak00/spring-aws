package com.jojoldu.book.springbook.domain.posts;

import org.junit.After; 
import org.junit.Test;  
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner; 

import java.util.List; 

import static org.assertj.core.api.Assertions.assertThat; 

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    
    @Autowired 
    PostsRepository postsRepository; 

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test 
    public void LoadTests(){
        //given 
        String title = "Test Post";
        String content = "본문";

        postsRepository.save(Posts.builder()
                                .title(title)
                                .content(content)
                                .author("amaruak00@hanwha.com") 
                                .build());
        //when
        List<Posts> postsList = postsRepository.findAll(); 

        //that
        Posts posts = postsList.get(0); 
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
