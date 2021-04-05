package com.codeup.codeup_demo;

import com.codeup.codeup_demo.models.Post;
import com.codeup.codeup_demo.models.User;
import com.codeup.codeup_demo.repo.PostRepository;
import com.codeup.codeup_demo.repo.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;





@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringblogApplication.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {

    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserRepository userDao;

    @Autowired
    PostRepository postsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Before
    public void setup() throws Exception{

        testUser = userDao.findByUsername("testUser");

//        Creates the test user if not exists
        if(testUser == null) {
            User newUser = new User();
            newUser.setUsername("testUser");
            newUser.setPassword("pass");
            newUser.setPassword(passwordEncoder.encode("pass"));
            newUser.setEmail("testUser@codeup.com");
            testUser = userDao.save(newUser);
        }

//        Throws a Post request to /login and expect a redirection to the Posts index page after being logged in

        httpSession = this.mvc.perform(post("/login").with(csrf())
                .param("username", "testUser")
                .param("password", "pass"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("/posts"))
                .andReturn()
                .getRequest()
                .getSession();
    }

    @Test
    public void contextLoads(){
//        Sanity test to ensure the MVC is working
        assertNotNull(mvc);
    }

    @Test
    public void testIfUserSessionIsActive() throws Exception{
//        it makes sure the returned session is not null
        assertNotNull(httpSession);
    }
    @Test
    public void testCreatePost() throws Exception{
//        Makes a post request to /posts/create and expect a redirection to the post
        this.mvc.perform(
                post("/posts/create").with(csrf())
                .session((MockHttpSession) httpSession)
                .param("title", "new ps5")
                .param("body", "for sale $$$"))
                .andExpect(status().is3xxRedirection());
    }











    }




