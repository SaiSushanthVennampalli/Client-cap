package com.example.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capstore.beans.OrderBean;
import com.cg.capstore.beans.ProductBean;

@RestController
public class FrontentController {

	@RequestMapping("/")
	public String consume() {
		return "REST Consumer";
	}

	@RequestMapping(value = "/forgot")
	public String forgotPassword(String email) {
		RestTemplate restTemplate = new RestTemplate();
		String password = restTemplate.getForObject("http://localhost:9002/forgotpassword?email=" + email, String.class);
		return password;
	}

	@RequestMapping(value = "/sortByBestSeller")
	public List<ProductBean> productSortingByBestSeller() {

		RestTemplate restTemplate = new RestTemplate();
		List<ProductBean> products = restTemplate.getForObject("http://localhost:9002//sortbybestseller", List.class);
		return products;
	}

	@RequestMapping("/getSortListHighToLow")
	public ModelAndView getSortListHighToLow(String category) {

		ModelAndView mav = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();

		category = "mOBILE";
		List<ProductBean> response = restTemplate
				.getForObject("http://localhost:9002//sorthightolow?category=" + category, List.class);
		System.out.println("***************" + response);
		mav.addObject("product", response);
		mav.setViewName("displaySortingDetails");
		return mav;
	}

	@RequestMapping("/getSortListLowToHigh")
	public ModelAndView getTransaction(String category) {
		ModelAndView mav = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();

		category = "mOBILE";
		List<ProductBean> response = restTemplate
				.getForObject("http://localhost:9002//sortlowtohigh?category=" + category, List.class);
		
		mav.addObject("product", response);
		mav.setViewName("displaySortingDetails");
		return mav;
	}

	@RequestMapping("/getSortListByRange")
	public ModelAndView getSortListByRange(Double min, Double max, String category) {

		ModelAndView mav = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		category = "mOBILE";
		map.add("min", min);
		map.add("max", max);
		map.add("category", category);

		List<ProductBean> products = restTemplate.postForObject("http://localhost:9002/rangesort", map, List.class);

		mav.addObject("product", products);
		mav.setViewName("displaySortingDetails");
		return mav;
	}

	@RequestMapping("/getSortListByMostViewed")
	public ModelAndView getSortListByMostViewed(String category) {
		ModelAndView mav = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		category = "mOBILE";
		List<ProductBean> products = restTemplate
				.getForObject("http://localhost:9002//sortbymostviewed?category=" + category, List.class);
		mav.addObject("product", products);
		mav.setViewName("displaySortingDetails");
		return mav;
	}

	@RequestMapping("/getTransactionalDetails")
	public ModelAndView getTransactionDetails(String orderId) {
		System.out.println("***********" + orderId);
		ModelAndView mav1 = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();

		OrderBean response = restTemplate
				.getForObject("http://localhost:9002/gettransactionaldetails?orderId=" + orderId, OrderBean.class);
		mav1.addObject("order", response);
		System.out.println(response);
		mav1.setViewName("getTransactionalDetails");
		return mav1;
	}

	@RequestMapping("/statusCheck")
	public ModelAndView updateStatus(OrderBean order,Model model) {
		
		ModelAndView mav = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();
		model.addAttribute("order",order);
		/*MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("orderId", orderId);
		map.add("orderStatus", orderStatus);
		System.out.println(map);*/
		OrderBean response = restTemplate.postForObject("http://localhost:9002/statusupdate", order, OrderBean.class);
		mav.addObject("customer", response);
		mav.setViewName("statusCheck");
		return mav;
	}

	@RequestMapping("/customerStatusCheck")
	public ModelAndView checkStatus(String orderId) {
	
		ModelAndView mav1 = new ModelAndView();
		RestTemplate restTemplate = new RestTemplate();

		OrderBean response = restTemplate.getForObject("http://localhost:9002/gettransactionaldetails?orderId=" + orderId,
				OrderBean.class);
		mav1.addObject("customer", response);
		System.out.println(response);
		mav1.setViewName("customerStatusCheck");
		return mav1;
	}
	@RequestMapping("/refund")
	public String refund(String orderId) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:9002/refund?orderId="+orderId, String.class);
		
	}
	@RequestMapping("/rating")
	public String refund() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:9002/Avg", String.class);
		
	}
	@RequestMapping("/promos")
	public String promo(String customerEmail) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:9002/sendPromo?email="+customerEmail, String.class);
		
	}


}
