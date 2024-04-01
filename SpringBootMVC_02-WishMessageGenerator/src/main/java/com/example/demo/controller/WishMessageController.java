package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.IWishMessageService;

@Controller
@RequestMapping("/wish")
public class WishMessageController {
	
	@Autowired
	private IWishMessageService wish;

	@RequestMapping("/home")
	public String showHome() {
		return "welcome";
	}
	
	/*@RequestMapping("/wish")
	public ModelAndView showWish() {
		//Get wish message
		String message = wish.generateWishMessage();
		//Creating ModelAndView object & adding data to it  
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.addObject("dateAndTime", LocalDateTime.now());
		//Setting logical view name
		mav.setViewName("wishpage");
		return mav;
	}*/
	
	/*@RequestMapping("/wish")
	public String showWish(Map<String, Object> map) {
		String mesage = wish.generateWishMessage();
		map.put("message", mesage);
		map.put("dateAndTime", LocalDateTime.now());
		return "wishpage";
	}*/
	
	/*@RequestMapping("/wish")
	public String showWish(Model model) {
		String message = wish.generateWishMessage();
		model.addAttribute("message", message);
		model.addAttribute("dateAndTime", LocalDateTime.now());
		return "wishpage";
	}*/
	
	@RequestMapping("/wish")
	public String showWish(ModelMap map) {
		String message = wish.generateWishMessage();
		map.addAttribute("message", message);
		map.addAttribute("dateAndTime", LocalDateTime.now());
		return "wishpage";
	}
	
	/*@RequestMapping("/wish")
	public ModelMap showWish() {
		String message = wish.generateWishMessage();
		ModelMap map = new ModelMap();
		map.addAttribute("message", message);
		map.addAttribute("dateAndTime", LocalDateTime.now());
		//If no Logical View Name is not given, Then Request path itself becomes Logical View Name
		return map;
	}*/
	
	/*@RequestMapping("/wish")
	public Model showWish() {
		String message = wish.generateWishMessage();
		Model model = new ExtendedModelMap();
		model.addAttribute("message", message);
		model.addAttribute("dateAndTime", LocalDateTime.now());
		return model;
	}*/
	
	/*@RequestMapping("/wish")
	public Map<String, Object> showWish(){
		String message = wish.generateWishMessage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("dateAndTime", LocalDateTime.now());
		return map;
	}*/
	
	/*@RequestMapping("/wish")
	public void showWish(Map<String, Object> map) {
		String message = wish.generateWishMessage();
		map.put("message", message);
		map.put("dateAndTime", LocalDateTime.now());
		//It will take request path as the logical view name by excluding the '/'
	}*/
	
	/*@RequestMapping("/wish")
	public String showWish(Map<String, Object> map) {
		String message = wish.generateWishMessage();
		map.put("message", message);
		map.put("dateAndTime", LocalDateTime.now());
		return null;
	}*/
	
	/*@RequestMapping("/wish")
	public String showWish(HttpServletResponse res) throws Exception {
		String message = wish.generateWishMessage();
		PrintWriter pw = res.getWriter();
		pw.write("<h1 align='center'>Result<h1/><br><hr color='blue'>");
		pw.write("<h2>Wish message :: " + message + "</h2>");
		pw.write("<h2>Date & time :: " + new Date() + "</h2><br><hr color='blue'>");
		pw.write("<h2 align='center'><a href='home'>Go to home<a/></h2>");
		return null;
	}*/
	
	@RequestMapping({"example11", "example111", "example1111"})
	public String requestPathExample1() {
		return "example1";
	}
	
	@RequestMapping("/example2")
	public String requestPathExample2() {
		return "example2";
	}
	
	@RequestMapping("/")
	public String requestPathExample() {
		return "welcome";
	}
	
	@GetMapping("/example1")
	public String requestPath1() {
		return "example1";
	}
	
	/*@PostMapping("/example1")
	public String requestPath2() {
		return "example2";
	}*/
	
	/*@GetMapping("/example1")
	public String requestPath3() {
		return "example2";
	}*/
	
	@GetMapping("/all")
	public String example() {
		return "example2";
	}
	
	@RequestMapping("/topup")
	public String example4() {
		return "forward:wish/wish";
	}
	
}
