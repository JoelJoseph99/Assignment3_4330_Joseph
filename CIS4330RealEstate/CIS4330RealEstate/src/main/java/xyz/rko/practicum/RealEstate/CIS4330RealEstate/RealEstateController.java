package xyz.rko.practicum.RealEstate.CIS4330RealEstate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//mport org.springframework.web.servlet.mvc.method.annotation.PathVariableMapMethodArgumentResolver;


@RestController

public class RealEstateController {
    List<Float> ArrayList = new ArrayList<>();

@GetMapping("/housing-statistics/min/{price}, {type}, {state},{city},{street}, {sq_ft}")
public float min(
    @PathVariable float price, @PathVariable String type, @PathVariable String state, @PathVariable String city, 
    @PathVariable String street, @PathVariable float sq_ft){

        float min = Float.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < ArrayList.size(); i++) {
            Float f = ArrayList.get(i);
            if (Float.compare(f.floatValue(), min) < 0) {
                min = f.floatValue();
                index = i;
            }
        }
        return index;
    }


@GetMapping("/housing-statistics/max/{price}, {type}, {state},{city},{street} , {sq_ft}")

public float max(
    @PathVariable  float price, @PathVariable String type, @PathVariable String state, @PathVariable String city, 
    @PathVariable String street, @PathVariable float sq_ft ) {
        float max = Float.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < ArrayList.size(); i++) {
            Float f = ArrayList.get(i);
            if (Float.compare(f.floatValue(), max) > 0) {
                max = f.floatValue();
                index = i;
            }
        }
        return index;
    
}

    

@GetMapping("/housing-statistics/average/{price},{type},{state},{city},{street}, {sq_ft}")

public Float averageHouse(
    @PathVariable  float price, @PathVariable String type, @PathVariable String state, @PathVariable String city, 
    @PathVariable String street, @PathVariable float sq_ft )
    {
        int sum = 0;
        for (Float i : ArrayList) {
           sum+=i;
        }
        if(ArrayList.isEmpty()){
           System.out.println("Empty list!");
        } else {
           System.out.println("Average = " + sum/(float)ArrayList.size());
        }
        return price;
        
        
    }   



@GetMapping ("/housing-statistics/add/{price},{type},{state},{city},{street}, {sq_ft}")
public float sum(
    @PathVariable  float price, @PathVariable String type, @PathVariable String state, @PathVariable String city, 
    @PathVariable String street, @PathVariable float sq_ft ) {

        Float output = price + price;
               
               
        return output;





    }

    @GetMapping("/housing-statistics/add/{price},{type},{state},{city},{street}, {sq_ft}")
    public float range(
        @PathVariable  float price, @PathVariable String type, @PathVariable String state, @PathVariable String city, 
        @PathVariable String street, @PathVariable float sq_ft ) 
     {
        float output = max(price, type, state, city, street, sq_ft) - min(price, type, state, city, street, sq_ft);
        return output;
    }
    


    @GetMapping("/housing-statistics/zipcode")
    @ResponseBody
    public String getZipcode(@RequestParam Integer zipcode) {
        return "Zipcode: " + zipcode;
    }

@GetMapping("/housing-statistics/sale_date")
    @ResponseBody
    public String getSaleDate(@RequestParam String sale_date) {
        Date startDate = new Date();
        return "Start Date: " + startDate;
    }
    @GetMapping("/housing-statistics/sale_date")
    @ResponseBody
    public String getEndDate(@RequestParam String sale_date) {
        Date endDate = new Date();

        return "End Date: " + endDate;
    }

}
