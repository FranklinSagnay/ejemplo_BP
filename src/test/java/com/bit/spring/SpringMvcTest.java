package com.bit.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
public class SpringMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ZapatoJPARepository mockRepository;

    @Before
    public void init() {
        Zapato zapato = new Zapato("ZAP-MOCK", "Zapato prueba", "MOCK Verano 2022", "F", "Magenta", "7.5", 10);
        Mockito.when(mockRepository.findById("ZAP-MOCK")).thenReturn(Optional.of(zapato));
        List<Zapato> lista = new ArrayList<>();
        lista.add(zapato);
        zapato = new Zapato("ZAP-MOCK2", "Zapato prueba", "MOCK Verano 2022", "F", "Magenta", "7.5", 10);
        lista.add(zapato);
        Mockito.when(mockRepository.findAll()).thenReturn(lista);

    }

    @WithMockUser("user")
    @Test
    public void buscaId() throws Exception {
        ObjectMapper maper = new ObjectMapper();
        String valor = mockMvc.perform(get("/zapato/ZAP-MOCK")).andReturn().getResponse().getContentAsString();
        Zapato z = maper.readValue(valor, Zapato.class);

        mockMvc.perform(get("/zapato/ZAP-MOCK"))
                .andDo(print()).andExpect(status().isOk())
                .andExpectAll(jsonPath("$.zapCodigo", Matchers.is("ZAP-MOCK")),
                        jsonPath("$.zapNombre", Matchers.is("Zapato prueba")),
                        jsonPath("$.zapModelo", Matchers.is("MOCK Verano 2022")));

        Assert.assertEquals("7.5", z.getZapTalla());



    }

    @Test
    public void error() throws Exception {
        mockMvc.perform(get("/zapato/ZAP-MOCK"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

}
