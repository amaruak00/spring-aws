package com.jojoldu.book.springbook.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;

import java.util.List; 

public interface PostsRepository extends JpaRepository<Posts, Long>{
    
    @Query("select p from Posts p order by p.id desc")
    List<Posts> findAllDesc();

    //Jpa 조회용 프레임워크: QueryDSL 추천
}
