/**
 * 
 */
package com.roadtobe.supaldubey.examples.spring.web;


import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.roadtobe.supaldubey.examples.spring.domain.EntityImpl;
import com.roadtobe.supaldubey.examples.spring.service.EntityService;

/**
 * @author Supal
 *
 */
@RequestMapping("/welcome")
@Controller
public class BaseController {
	
	@Autowired
	private EntityService entityService;
	
	@RequestMapping("/hello")
	public ModelAndView hello(Model model)
	{
		model.addAttribute("test", "Supal Dubey");
		EntityImpl im = new EntityImpl();
		im.setFirstname("Supal Dubey");
		im.setStatus("ACTIVE");
		entityService.save(im);
		return new ModelAndView("heylo");
	}
	
	@RequestMapping("/hi")
	@RolesAllowed("ROLE_ADD")
	public ModelAndView hi(Model model)
	{
		model.addAttribute("test", "Supal Dubey");
		EntityImpl im = new EntityImpl();
		im.setFirstname("Supal Dubey");
		im.setStatus("ACTIVE");
		entityService.save(im);
		return new ModelAndView("index");
	}

	public EntityService getEntityService() {
		return entityService;
	}

	public void setEntityService(EntityService entityService) {
		this.entityService = entityService;
	}
}
