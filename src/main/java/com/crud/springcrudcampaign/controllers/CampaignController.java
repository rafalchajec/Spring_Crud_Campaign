package com.crud.springcrudcampaign.controllers;


import com.crud.springcrudcampaign.entities.Campaign;
import com.crud.springcrudcampaign.repositories.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/panel")
public class CampaignController {


    public static long budget = 1000000;
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
        modelAndView.addObject("budget",budget);
        return modelAndView;
    }
    @PostMapping("/add-campaigns")
    public String addNewCampaigns(@ModelAttribute Campaign campaign) {
        budget=budget-campaign.getCampaignFund();
        if(budget<=0) {
            System.out.println("WE DONT HAVE MONEY!!");
            budget=0;
        }
        else {
            campaignRepository.save(campaign);
        }

        return "panel";
    }

    @GetMapping("/edit-campaigns")
    public ModelAndView editCampaigns(){
        ModelAndView modelAndView = new ModelAndView("crud/editCampaign");
        modelAndView.addObject("panel", new Campaign());
        return modelAndView;
    }

    @PostMapping("/edit-campaigns")
    public String editNewCampaigns(@ModelAttribute Campaign campaign) {
        budget=budget-campaign.getCampaignFund();
        Optional<Campaign> campaign1 = campaignRepository.findByCampaignName(campaign.getCampaignName());
        if(campaign1.isPresent()){
            Campaign campaign2 = campaign1.get();
            campaign2.setCampaignName(campaign.getCampaignName());
            campaign2.setKeyword(campaign.getKeyword());
            campaign2.setBidAmount(campaign.getBidAmount());
            campaign2.setCampaignFund(campaign.getCampaignFund());
            campaign2.setStatus(campaign.getStatus());
            campaign2.setTown(campaign.getTown());
            campaign2.setRadius(campaign.getRadius());

            if(budget<=0) {
                System.out.println("WE DONT HAVE MONEY!!!");
                budget=0;
            }
            else {
                campaignRepository.save(campaign2);
            }
        }
        else
            return "panel";



        System.out.println("Our budget: "+budget);
        return "panel";
    }


    @GetMapping("/show-campaigns")
    public ModelAndView showCampaigns() {
        ModelAndView modelAndView = new ModelAndView("crud/showCampaign");
        List<Campaign> campaignList = campaignRepository.findAll();
        modelAndView.addObject("showCampaignsLists",campaignList);

        return modelAndView;
    }


    @GetMapping("/delete-campaigns")
    public ModelAndView deleteGoods() {
        ModelAndView modelAndView = new ModelAndView("crud/deleteCampaign");
        modelAndView.addObject("panel", new Campaign());
        return modelAndView;

    }
    @PostMapping("/delete-campaigns")
    public String deleteNewCampaigns(@ModelAttribute Campaign campaign) {
        Optional<Campaign> campaign1 = campaignRepository.findByCampaignName(campaign.getCampaignName());
        if (campaign1.isPresent()) {
            campaignRepository.delete(campaign1.get());
        }
        else return "panel";


        return "panel";
    }





}
