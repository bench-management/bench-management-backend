package BenchManagementTool.BMT.services;

import BenchManagementTool.BMT.Repo.CandidatesRepository;
import BenchManagementTool.BMT.lib.Utils;
import BenchManagementTool.BMT.models.Candidate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DarwinService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper;
    @Autowired
    private CandidatesRepository candidatesRepository;
    @Autowired
    private TokenService tokenService;

    @PostConstruct
    public void init(){
        getCandidateDataAndSaveToMongo();
    }
    @Value("${darwin.url}")
    private String darwinUrl;

    @Autowired
    public DarwinService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Scheduled(cron = "0 0 20 * * ?")
    public void getCandidateDataAndSaveToMongo() {
        getCandidateDataAndSaveToMongo(Utils.getTodaysDate());
    }


    public void getCandidateDataAndSaveToMongo(String date) {
        try {

            final String token = tokenService.getToken();


            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            headers.set("Content-Type", "application/json");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(darwinUrl)
                    .queryParam("source", "darwin")
                    //.queryParam("dateOfJoining", getTodaysDate())
                    .queryParam("startDate", date);


            String uriWithParams = builder.toUriString();
            ResponseEntity<String> response = restTemplate.exchange(uriWithParams, HttpMethod.GET, entity, String.class);

            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            //module.addDeserializer(Utils.Status.class, new StatusDeserializer());
            mapper.registerModule(module);

            List<Candidate> candidateList = mapper.readValue(response.getBody(), new TypeReference<List<Candidate>>() {});

            setDefaultValues(candidateList);

            System.out.println(response);
            //candidatesRepository.save(response.getBody());

        } catch (Exception e) {
            System.err.println("Error processing API data or saving to MongoDB: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void setDefaultValues(List<Candidate> candidateList) {
        for(Candidate candidate : candidateList){
            candidate.setStatus(Utils.Status.UNDER_EVALUATION);
        }
    }
}
