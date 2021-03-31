package com.codeup.codeup_demo.controllers;

import com.codeup.codeup_demo.models.Ad;
import com.codeup.codeup_demo.models.User;
import com.codeup.codeup_demo.repo.AdRepository;
import com.codeup.codeup_demo.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;




    @Controller
    public class AdController {

        private final AdRepository adDao;
        private final UserRepository userDao;

        AdController(AdRepository adDao, UserRepository userDao){
            this.adDao = adDao;
            this.userDao = userDao;
        }



        @GetMapping("/ads")
        public String seeAllAds(Model viewModel){
            List<Ad> adsFromdb = adDao.findAll();
            viewModel.addAttribute("ads", adsFromdb);
            // do not use a / to reference a template
            return "ads/index";
        }

        @GetMapping("/ads/{id}")
        public String showOneAd(@PathVariable Long id, Model vModel){
            vModel.addAttribute("ad", adDao.getOne(id));
            return "ads/show";
        }

        @GetMapping("/ads/create")
        public String viewAdForm(Model model){
            model.addAttribute("ad", new Ad());
            return "ads/create";
        }

        @PostMapping("/ads/create")
        @ResponseBody
        public String createAd(@ModelAttribute Ad ad){

            User user = userDao.getOne(1L);

            ad.setOwner(user);

            adDao.save(ad);

            return "You created an ad.";
        }

        @GetMapping("/ads/{id}/update")
        public String updateAdForm(@PathVariable Long id, Model model){

            Ad adFromdb = adDao.getOne(id);

            model.addAttribute("oldAd",adFromdb);

            return "ads/update";
        }

        @PostMapping("/ads/{id}/update")
        @ResponseBody
        public String updateAd(@PathVariable Long id,@RequestParam("ad_title") String title, @RequestParam("ad_description") String description){

            Ad adToSave = new Ad(id,title,description);

            adDao.save(adToSave);
            return "You updated an ad.";
        }

        @PostMapping("/ads/{id}/delete")
        @ResponseBody
        public String deleteAd(@PathVariable Long id){
            adDao.deleteById(id);
            return "You deleted an ad.";

        }



    }


