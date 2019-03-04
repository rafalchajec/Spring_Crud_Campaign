package com.crud.springcrudcampaign.controllers;

import com.crud.springcrudcampaign.entities.Campaign;
import com.crud.springcrudcampaign.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/panel")
public class CampaignController {


    @Autowired
    CampaignRepository campaignRepository;

    @GetMapping("")
    public ModelAndView panel() {
        return new ModelAndView("panel");
    }



    @GetMapping("/add-campaigns")
    public ModelAndView addCampaigns() {
        ModelAndView modelAndView = new ModelAndView("crud/addCampaign");
        modelAndView.addObject("panel", new Campaign());
        return modelAndView;
    }
    @PostMapping("/add-campaigns")
    public String addNewCampaigns(@ModelAttribute Campaign campaign) {
        campaignRepository.save(campaign);
        return "panel";
    }







}
