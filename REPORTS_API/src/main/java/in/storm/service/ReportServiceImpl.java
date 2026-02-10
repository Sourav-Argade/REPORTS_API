package in.storm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.beans.BeanUtils;
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
		
		List<SearchResponse> response = new ArrayList<>();
		
		EligibilityDetails queryBuilder = new EligibilityDetails();
		String planName = request.getPlanName();
		if(planName != null && !planName.equals("")) {
			queryBuilder.setPlanName(planName);
		}
		
		String planStatus = request.getPlanStatus();
		if(planStatus != null && !planStatus.equals("")) {
			queryBuilder.setPlanStatus(planStatus);
		}
		
		LocalDate planStartDate = request.getPlanStartDate();
		if(planStartDate != null) {
			queryBuilder.setPlanStartDate(planStartDate);
		}
		
		LocalDate planEndDate = request.getPlanEndDate();
		if(planEndDate != null) {
			queryBuilder.setPlanEndDate(planEndDate);
		}
		
		Example<EligibilityDetails> example = Example.of(queryBuilder);

		List<EligibilityDetails> entities = eligRepo.findAll(example);
		
		for(EligibilityDetails entity : entities) {
			SearchResponse sr = new SearchResponse();
			BeanUtils.copyProperties(entity, sr);
			response.add(sr);
		}
		
		return response;
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
 