package in.storm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.storm.entity.EligibilityDetails;
import in.storm.entity.EligibilityDetailsRepo;
import in.storm.request.SearchRequest;
import in.storm.response.SearchResponse;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private EligibilityDetailsRepo eligRepo;

	@Override
	public List<String> getUniquePlanNames() {
		
		return eligRepo.findPlanNames();
		
	}

	@Override
	public List<String> getUniquePlanStatuses() {
		
		return eligRepo.findPlanStatuses();
	}

	@Override
	public List<SearchResponse> search(SearchRequest request) {
		
		List<EligibilityDetails> entities = eligRepo.findAll();
		
		return null;
	}

	@Override
	public void generateExcel(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generatePdf(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
