package io.mistarpeo.sgboard.domain.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(value = "select p.* from posts p order by p.id desc", nativeQuery=true)
    List<Posts> findAllDesc();
}


