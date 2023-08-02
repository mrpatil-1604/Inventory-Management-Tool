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

import com.mr.dao.LogsProcessedMDao;
import com.mr.dao.LogsRawMDao;
import com.mr.dao.ProcessedItemDao;
import com.mr.model.LogsProcessedM;
import com.mr.model.LogsRawM;
import com.mr.model.ProcessedItem;
import com.mr.model.RawMaterial;

@Controller
public class ProcessedItemController {
	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	ProcessedItemDao processedItemDao = (ProcessedItemDao) context.getBean("processedItemDao");
	
	@RequestMapping("/addProcessed")
	public String addProcessedItem(){
		return "addProcessedItem";
	}
	@RequestMapping("/processedItem")
	public String insertProcessedItem(@ModelAttribute ProcessedItem processedItem,HttpServletRequest request){
		processedItemDao.insertProcessedItem(processedItem);
		return "dashboard";
	}
	@RequestMapping("/viewProcessed")
	public String viewProcessedItem(Model m){
		
		List<ProcessedItem> processedItem = processedItemDao.getAllProcessedItem();
		m.addAttribute("processedItem",processedItem);
		return "viewProcessedItem";
	}
	@RequestMapping(path="/deleteProcessed/{Id}",method=RequestMethod.GET)
	public RedirectView deleteProcessedItem(@PathVariable("Id") int Id,HttpServletRequest request){
		processedItemDao.deleteProcessedItem(Id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewProcessed");
		return redirectView;
	}
	@RequestMapping(value="/updateProcessedItem",method=RequestMethod.GET)
	public String updateRawMaterial(@RequestParam int Id,Model m){	
		m.addAttribute("Id",Id);
		return "updateProcessedItem";
	}
	@RequestMapping("/processUpdateItem")
	public RedirectView processUpdateItem(HttpServletRequest request){
		int Id = Integer.parseInt(request.getParameter("Id"));
		int newQuantity = Integer.parseInt(request.getParameter("quantity"));
		ProcessedItem processedItem= processedItemDao.getId(Id);
		processedItem.setQuantity(processedItem.getQuantity()+newQuantity);
		processedItemDao.updateQuantity(processedItem);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewProcessed");
		return redirectView;
	}
	
	@RequestMapping(value="/issueProcessedM",method=RequestMethod.GET)
	public String issueProcessedMaterial(@RequestParam int Id,String name,Model m){
		m.addAttribute("Id", Id);
		m.addAttribute("name", name);
		return "issueProcessedM";
	}
	@RequestMapping("/issuedProcessedMat")
	public RedirectView issuedProcessedMaterial(@ModelAttribute LogsProcessedM logsProcessedM,HttpServletRequest request){
		LogsProcessedMDao logsProcessedMDao = (LogsProcessedMDao) context.getBean("logsProcessedMDao");
		int Id = Integer.parseInt(request.getParameter("itemId"));
		int newQuantity = Integer.parseInt(request.getParameter("quantity"));
		ProcessedItem processedItem = processedItemDao.getId(Id);
		if((processedItem.getQuantity()-newQuantity)>=0){
		processedItem.setQuantity(processedItem.getQuantity()-newQuantity);
		processedItemDao.updateQuantity(processedItem);
		logsProcessedMDao.insertLogsProcessedM(logsProcessedM);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/viewProcessed");
		return redirectView;
		}else{
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/issueProcessedM");
			return redirectView;
		}
	}
	@RequestMapping("/viewLogsPro")
	public String viewLogsProcessed(Model m){
		LogsProcessedMDao logsProcessedMDao = (LogsProcessedMDao) context.getBean("logsProcessedMDao");
		List<LogsProcessedM> logsProcessedM = logsProcessedMDao.getAllLogsProcessed();
		m.addAttribute("logsProcessedM",logsProcessedM);
		return "viewLogsProcessed";
	}
	@RequestMapping("/viewUnavailPro")
	public String viewUnavailProcessed(Model m){
		List<ProcessedItem> processedItem = processedItemDao.getAllProcessedItem();
		m.addAttribute("processedItem",processedItem);
		return "viewUnavailPro";
	}
}
