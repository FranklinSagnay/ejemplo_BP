package com.bit.spring;

import org.springframework.boot.test.web.client.TestRestTemplate;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringRestTest {   

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ZapatoJPARepository mockRepository;

    @Before
    public void init() {
        Zapato zapato = new Zapato("ZAP-MOCK", "Zapato prueba", "MOCK Verano 2022", "F", "Magenta", "7.5", 10);
        Mockito.when(mockRepository.findById("ZAP-MOCK")).thenReturn(Optional.of(zapato));
    }

    @Test
    public void loginOK() throws Exception {
        ResponseEntity<String> response = restTemplate.withBasicAuth("user", "password").getForEntity("/zapato/ZAP-MOCK", String.class);
        System.out.println("===================== LOGIN OK RESPONSE ==============================");
        System.out.println(response.getBody());
        System.out.println("======================================================================");
        Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        ObjectMapper maper = new ObjectMapper();
        Zapato resultado = maper.readValue(response.getBody(), Zapato.class);
        System.out.println("RESULTADO OBJ  " + resultado);
        Assert.assertEquals("ZAP-MOCK", resultado.getZapCodigo());
    }

    @Test
    public void noLogin() throws Exception {
        String esperado = "{\"status\":401,\"error\":\"Unauthorized\",\"path\":\"/zapato/ZAP-MOCK\"}";
        ResponseEntity<String> response = restTemplate.getForEntity("/zapato/ZAP-MOCK", String.class);
        System.out.println("===================== LOGIN FALLO RESPONSE ==============================");
        System.out.println(response.getBody());
        System.out.println("======================================================================");
        Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        JSONAssert.assertEquals(esperado, response.getBody(), false);

    }

}
