package ankitkumar.TodoTracker.service;

import ankitkumar.TodoTracker.controller.Background_Img_Controller;
import ankitkumar.TodoTracker.dto.NasaApodResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class external_api_service {
    Background_Img_Controller bg;

   // @Value("${nasa.api.random}")
    private String apiUrl = "https://api.nasa.gov/planetary/apod?api_key=Q6gHrBqHdU7fEmFfa7MaXE9uMUfOgZCjQUpEqgdl";
    NasaApodResponse apodResponse;


    private final RestTemplate template = new RestTemplate();



    public String getRandomUrl() {

        System.out.println(apiUrl);
      NasaApodResponse response =   template.getForObject(apiUrl,NasaApodResponse.class);
   if(response != null) {
       System.out.println(response.getUrl());
       return response.getUrl();
   }

        return "https://picsum.photos/id/1/200/300";
    };
}
