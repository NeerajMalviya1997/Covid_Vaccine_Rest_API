package masai.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.IDCard;
import com.masai.service.IDCardService;

@RestController
public class IDCardController {
	
	@GetMapping(value="/qqqq")
	public String addIDCard(){
		return "neer";
	}

}
