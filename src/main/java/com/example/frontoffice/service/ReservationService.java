package com.example.frontoffice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String backofficeUrl = "http://localhost:8080/BackOffice/api/reservations";

    public List<Map<String, Object>> getReservations(String date) {
        String url = backofficeUrl;
        if (date != null && !date.isEmpty()) {
            url += "?date=" + date;
        }
        return restTemplate.getForObject(url, List.class);
    }
}
