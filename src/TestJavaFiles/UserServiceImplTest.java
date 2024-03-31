package com.sandisedijs.zpus.EdijaTesti;

import com.sandisedijs.zpus.models.User;
import com.sandisedijs.zpus.repo.IUserRepo;
import com.sandisedijs.zpus.services.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframe}work.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest
{
    @Autowired
    IUserService userService;

    @Autowired
    IUserRepo userRepo;

    User validUser = new User(
            "username",
            "password",
            "test@test.com",
            "Name",
            "Surname",
            "ADMIN");

    User invalidUser = new User(
            "user1",
            "pass2",
            "test@testcom",
            "",
            "SurnameSurnameSurnameSurnameSurnameSurnameSurnameSurnameSurnameSurnameSurnameSurname",
            null);

    @Test
    void createUserCorrectly()
    {
        )
        assertNotNull(validUser);

        if(userRepo.findByUsername(validUser.getUsername()) != null)
        {
            userRepo.delete(userRepo.findByUsername(validUser.getUsername()));
        }

        userService.createUser(validUser);

        assertNotNull(userRepo.findByUsernameAndEmailAndNameAndSurnameAndAuthorizationLevel(
                validUser.getUsername(),
                validUser.getEmail(),
                validUser.getName(),
                validUser.getSurname(),
                validUser.getAuthorizationLevel()
        ));
    }
]]
    @Test
    void createUserIncorrectly()
    {
        if(userRepo.findByUsername(invalidUser.getUsername() != null)
        {
            userRepo.delete(userRepo.findByUsername(invalidUser.getUsername()));
        }
    }
}
(
    



{
    [
    
    
    [