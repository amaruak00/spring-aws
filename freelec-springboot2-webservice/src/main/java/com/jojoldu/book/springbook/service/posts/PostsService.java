package com.jojoldu.book.springbook.service.posts;

import lombok.RequiredArgsConstructor;

import com.jojoldu.book.springbook.domain.posts.PostsRepository;
import com.jojoldu.book.springbook.web.dto.PostsSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional ;

@RequiredArgsConstructor 
@Service
public class PostsService {
    private final PostsRepository postsRepository; 

    @Transactional 
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}