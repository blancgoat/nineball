package com.match.nineball.account;

import com.google.gson.Gson;
import com.match.nineball.account.dto.CreateAccountDto;
import com.match.nineball.account.enums.Provider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AccountController.class)
class AccountControllerTest {

    private MockMvc mockMvc;
    @MockBean
    private AccountService accountService;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(accountService)).build();
    }

    @Test
    void postAccount() throws Exception {
        // given
        given(accountService.createAccountAndSocial(any()))
                .willReturn(Social.builder()
                        .account(Account
                                .builder()
                                .nickname("테스트유저")
                                .build()
                        )
                        .provider(Provider.KAKAO)
                        .authKey("0120321abcd")
                        .build());

        CreateAccountDto createAccountDto = new CreateAccountDto("테스트유저", Provider.KAKAO, "0120321abcd");

        // when
        final ResultActions resultActions = mockMvc.perform(
                post("/api/v1/account")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(createAccountDto)));

        // then
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("account.nickname").value("테스트유저"))
                .andExpect(jsonPath("provider").value("KAKAO"))
                .andExpect(jsonPath("authKey").value("0120321abcd"));
    }

    @Test
    void getAccount() throws Exception {
        // given
        given(accountService.getAccountAndSocialByAccountId(any()))
                .willReturn(Social.builder()
                        .account(Account
                                .builder()
                                .nickname("테스트유저")
                                .build()
                        )
                        .provider(Provider.KAKAO)
                        .authKey("0120321abcd")
                        .build());

        // when
        final ResultActions resultActions = mockMvc.perform(
                get("/api/v1/account/1")
                        .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("account.nickname").value("테스트유저"))
                .andExpect(jsonPath("provider").value("KAKAO"))
                .andExpect(jsonPath("authKey").value("0120321abcd"));
    }
}