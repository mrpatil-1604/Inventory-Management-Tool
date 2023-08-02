package com.mr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.mr.dao.LogsRawMDao;
import com.mr.dao.RawMaterialDao;
import com.mr.model.LogsRawM;
import com.mr.model.ProcessedItem;
import com.mr.model.RawMaterial;
@Controller
public class RawMaterialController {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	RawMaterialDao rawMaterialDao = (RawMaterialDao) context.getBean("rawMaterialDao");
	
	@RequestMapping("/addRaw")
	public String addRawPage(){
		return "addRawM";
	}
	
	@RequestMapping("/processAddRaw")
	public String insertRawMaterial(@ModelAttribute RawMaterial rawMaterial,HttpServletRequest request){
		rawMaterialDao.insertRaw(rawMaterial);
		return "dashboard";
	}
	@RequestMapping("/viewRaw")
	public String viewRawMaterial(Model m){
		
		List<RawMaterial> rawMaterial = rawMaterialDao.getAllRaw();
		m.addAttribute("rawMaterial",rawMaterial);
		return "viewRawM";
	}
	@RequestMapping(path="/deleteRawM/{Id}",method=RequestMethod.GET)
	public RedirectView deleteRawMaterial(@PathVariable("Id") int Id,HttpServletRequest request){
		rawMaterialDao.deleteRaw(Id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewRaw");
		return redirectView;
	}
	@RequestMapping(value="/updateRawM",method=RequestMethod.GET)
	public String updateRawMaterial(@RequestParam int Id,Model m){	
		m.addAttribute("Id",Id);
		return "updateRawM";
	}
	@RequestMapping("/processUpdate")
	public RedirectView processUpdate(HttpServletRequest request){
		int Id = Integer.parseInt(request.getParameter("Id"));
		int newQuantity = Integer.parseInt(request.getParameter("quantity"));
		RawMaterial rawMaterial = rawMaterialDao.getId(Id);
		rawMaterial.setQuantity(rawMaterial.getQuantity()+newQuantity);
		rawMaterialDao.updateQuantity(rawMaterial);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewRaw");
		return redirectView;
	}
	@RequestMapping(value="/issueRawM",method=RequestMethod.GET)
	public String issueRawMaterial(@RequestParam int Id,String name,Model m){
		m.addAttribute("Id", Id);
		m.addAttribute("name", name);
		return "issueRawM";
	}
	@RequestMapping("/issuedRawMat")
	public RedirectView issuedRawMaterial(@ModelAttribute LogsRawM logsRawM,HttpServletRequest request){
		LogsRawMDao logsRawMDao = (LogsRawMDao) context.getBean("logsRawMDao");
		int Id = Integer.parseInt(request.getParameter("itemId"));
		int newQuantity = Integer.parseInt(request.getParameter("quantity"));
		RawMaterial rawMaterial = rawMaterialDao.getId(Id);
		if((rawMaterial.getQuantity()-newQuantity)>=0){
		rawMaterial.setQuantity(rawMaterial.getQuantity()-newQuantity);
		rawMaterialDao.updateQuantity(rawMaterial);
		logsRawMDao.insertLogsRawM(logsRawM);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewRaw");
		return redirectView;
		}else{
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/issueRawM");
			return redirectView;
		}
	}
	@RequestMapping("/viewLogsRaw")
	public String viewLogsRaw(Model m){
		LogsRawMDao logsRawMDao = (LogsRawMDao) context.getBean("logsRawMDao");
		List<LogsRawM> logsRawM = logsRawMDao.getAllLogsRaw();
		m.addAttribute("logsRawM",logsRawM);
		return "viewLogsRaw";
	}
	@RequestMapping("/viewUnavailRaw")
	public String viewUnavailRaw(Model m){
		List<RawMaterial> rawMaterial = rawMaterialDao.getAllRaw();
		m.addAttribute("rawMaterial",rawMaterial);
		return "viewUnavailRaw";
	}
}
