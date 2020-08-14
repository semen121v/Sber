package com.semen.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.StringContains.containsString;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestBlogWebApplication {


    @Autowired
    private CompanyRepository controller;

    @Autowired
    private PersonRepository contr;

    @Autowired
    private MockMvc mockMvc;

//    @Before
//    public void contextLoads() {
//        controller.save(new Company("Sber", "IT"));
//    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        Company company = new Company("Alpla", "IT_blok");
        controller.save(company);
        Object response = this.mockMvc.perform(get("/company")).andDo(print()).andExpect(status().isOk()).
                andExpect(content().string(containsString("{\n" +
                        "  \"_embedded\" : {\n" +
                        "    \"company\" : [ {\n" +
                        "      \"companyName\" : \"Alpla\",\n" +
                        "      \"dep\" : \"IT_blok\",\n" +
                        "      \"_links\" : {\n" +
                        "        \"self\" : {\n" +
                        "          \"href\" : \"http://localhost/company/1\"\n" +
                        "        },\n" +
                        "        \"company\" : {\n" +
                        "          \"href\" : \"http://localhost/company/1{?projection}\",\n" +
                        "          \"templated\" : true\n" +
                        "        },\n" +
                        "        \"person\" : {\n" +
                        "          \"href\" : \"http://localhost/company/1/person\"\n" +
                        "        }\n" +
                        "      }\n" +
                        "    } ]\n" +
                        "  },\n" +
                        "  \"_links\" : {\n" +
                        "    \"self\" : {\n" +
                        "      \"href\" : \"http://localhost/company\"\n" +
                        "    },\n" +
                        "    \"profile\" : {\n" +
                        "      \"href\" : \"http://localhost/profile/company\"\n" +
                        "    },\n" +
                        "    \"search\" : {\n" +
                        "      \"href\" : \"http://localhost/company/search\"\n" +
                        "    }\n" +
                        "  },\n" +
                        "  \"page\" : {\n" +
                        "    \"size\" : 20,\n" +
                        "    \"totalElements\" : 1,\n" +
                        "    \"totalPages\" : 1,\n" +
                        "    \"number\" : 0\n" +
                        "  }\n" +
                        "}"))).andExpect(jsonPath("$._embedded.company[0].companyName").value("Alpla")).andExpect(jsonPath("$._embedded.company[0].dep").value("IT_blok"));
    }

    @Test
    public void greetingShouldReturnDefaultMessage_2() throws Exception {
        Company company = new Company("Alpla", "IT_blok");
        contr.save(new Person("Semen", "Kravtsov", company));
        Object response = this.mockMvc.perform(get("/company")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("_embedded.company[0].companyName").value("Alpla")).
                andExpect(jsonPath("$._embedded.company[0].dep").value("IT_blok"));
               // andExpect(jsonPath("$._embedded.company[0].person.href").value("http://localhost/company/2/person"));
        response = this.mockMvc.perform(get("/company/2/person")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("_embedded.people[0].firstName").value("Semen"));
    }
}
