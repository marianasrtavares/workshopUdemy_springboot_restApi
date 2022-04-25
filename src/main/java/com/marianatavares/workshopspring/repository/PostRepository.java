package com.marianatavares.workshopspring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.marianatavares.workshopspring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
