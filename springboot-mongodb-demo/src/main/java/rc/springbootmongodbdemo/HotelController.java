package rc.springbootmongodbdemo;



//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.Rest

//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.IndexDirection;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.mongodb.core.MongoTemplate;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelRepository hotelRepository;

    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/all")
    public List<Hotel> getAll(){
        List<Hotel> hotels = this.hotelRepository.findAll();

        return hotels;
    }
}