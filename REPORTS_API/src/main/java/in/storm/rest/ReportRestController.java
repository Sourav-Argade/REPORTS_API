package in.storm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.storm.request.SearchRequest;
import in.storm.response.SearchResponse;
import in.storm.service.ReportService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ReportRestController {
	
	@Autowired
	private ReportService service;
	
	@GetMapping("/plans")
	public ResponseEntity<List<String>> getPlanNames(){
		List<String> planNames = service.getUniquePlanNames();
		return new ResponseEntity<>(planNames, HttpStatus.OK);
		
	} 
	
	@GetMapping("/statuses")
	public ResponseEntity<List<String>> getPlanStatuses(){
		
		List<String> uniquePlanStatuses = service.getUniquePlanStatuses();
		return new ResponseEntity<>(uniquePlanStatuses, HttpStatus.OK);
		
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<SearchResponse>> search(@RequestBody SearchRequest request){
		
		List<SearchResponse> response = service.search(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}

}
