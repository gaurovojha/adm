package com.ram.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ram.domain.Offering;
import com.ram.domain.Type;
import com.ram.service.InstituteTypeService;

@RestController
public class InstituteTypeController {
	private static final Logger logger = LoggerFactory.getLogger(InstituteTypeController.class);
	@Autowired(required = true)
	private InstituteTypeService instituteTypeService;

	@RequestMapping(value = "/institutetypes", method = RequestMethod.GET)
	public List<Type> listInstituteTypes() {
		return instituteTypeService.listInstitute_types();
	}
	
	@RequestMapping(value = "/institutetypes", method = RequestMethod.PUT)
	public void addInstituteTypes(@RequestBody List<Type> types) {
		instituteTypeService.addInstitute_types(types);
	}
	
	@RequestMapping(value = "/institutetypes", method = RequestMethod.DELETE)
	public void deleteInstituteTypes(@RequestBody List<Type> types) {
		instituteTypeService.deleteInstitute_types(types);
	}
}