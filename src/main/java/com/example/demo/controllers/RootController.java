package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.InquiryForm;
import com.example.demo.models.MemberRegisterForm;
import com.example.demo.repositries.InquiryRepository;
import com.example.demo.repositries.MemberRepository;

@Controller
@RequestMapping("/")
public class RootController {

	@Autowired
	InquiryRepository repository;

	@Autowired
	MemberRepository memrepository;
	
	@GetMapping
	public String index() {
		return "root/index";
	}

	@GetMapping("/form")
	public String form(InquiryForm inquiryForm) {
		return "root/form";
	}

	@PostMapping("/form")
	public String form(@Validated InquiryForm inquiryForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form";
		}

		// RDBと連携できることを確認しておきます。
		repository.saveAndFlush(inquiryForm);
		inquiryForm.clear();
		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "root/form";
	}
	
	@GetMapping("/form2")
	public String form2(InquiryForm inquiryForm) {
		return "root/form2";
	}

	@PostMapping("/form2")
	public String form2(@Validated InquiryForm inquiryForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/form2";
		}

		// RDBと連携できることを確認しておきます。
		repository.saveAndFlush(inquiryForm);
		inquiryForm.clear();
		model.addAttribute("message", "お問い合わせを受け付けました。");
		return "root/form2";
	}

	@GetMapping("/memberregister")
	public String memberregister(MemberRegisterForm memberRegisterForm) {
		return "root/memberregister";
	}

	@PostMapping("/memberregister")
	public String memberregister(@Validated MemberRegisterForm memberRegisterForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "root/memberregister";
		}

		// RDBと連携できることを確認しておきます。
		memrepository.saveAndFlush(memberRegisterForm);
		memberRegisterForm.clear();
		model.addAttribute("message", "会員登録を受け付けました。");
		return "root/memberregister";
	}
	
}