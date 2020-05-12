package com.nooty.nootyfollow;

import com.nooty.nootyfollow.models.Follow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(FollowController.class)
class NootyFollowApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FollowRepo followRepo;

	@BeforeEach
	public void init() {
		Follow f = new Follow();
		given(this.followRepo.findById("1")).willReturn(Optional.of(f));
	}
	@Test
	void contextLoads() {
	}

}
