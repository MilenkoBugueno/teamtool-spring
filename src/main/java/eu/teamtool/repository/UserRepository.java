package eu.teamtool.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import eu.teamtool.domain.User;

public interface UserRepository extends MongoRepository<User, Long> {

    User findOneByUsername(String username);

}
