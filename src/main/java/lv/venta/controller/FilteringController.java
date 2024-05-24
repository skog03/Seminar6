package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import lv.venta.model.Grade;
import lv.venta.service.IFilteringService;


@Controller
@RequestMapping("/filter")
public class FilteringController {
	
	@Autowired
	private IFilteringService filterService;
	
	public String getFilterGradeFailed(Model model) {
		
		try {
			ArrayList<Grade> dataFromService =  filterService.selectFailedGrades();
			model.addAttribute("myPackage", dataFromService);
			
			return "show-all-grades-page"; // will show show-all-grades-page html page
		}
		catch(Exception e){
			model.addAttribute("myPackage", e.getMessage());
			
			return "error-page";
		}
		
	}
	
}
