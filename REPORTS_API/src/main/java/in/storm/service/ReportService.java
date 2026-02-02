package in.storm.service;

import java.util.List;

import in.storm.request.SearchRequest;
import in.storm.response.SearchResponse;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	public List<String> getUniquePlanNames();
	
	public List<String> getUniquePlanStatuses();
	
	public List<SearchResponse> search(SearchRequest request);
	
	public void generateExcel(HttpServletResponse response);
	
	public void generatePdf(HttpServletResponse response);
}
