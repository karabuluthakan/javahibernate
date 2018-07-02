package com.ubit.hibernate.repository;

import com.ubit.hibernate.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface PostRepository extends CrudRepository<Post,Long> {

    Set<Post> findAll();

    Optional<Post> findByDescription(String description);

    Optional<Post> findById(Long id);

}
