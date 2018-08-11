package com.levik.searchclient.controller;

import com.levik.searchclient.dto.SearchDto;
import com.levik.searchclient.dto.SearchResponse;
import com.levik.searchclient.service.impl.SearchApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    private final SearchApiService searchApiService;

    public IndexController(SearchApiService searchApiService) {
        this.searchApiService = searchApiService;
    }

    @PostMapping("/search")
    public String submit(@ModelAttribute SearchDto searchDto, Model model) {
        model.addAttribute("search", searchDto);
        SearchResponse search = searchApiService.search(searchDto.getTokens());
        model.addAttribute("result", search);
        return "index";
    }


    @GetMapping(value = {"/", "/search"})
    public String index(Model model) {
        model.addAttribute("search", new SearchDto());
        model.addAttribute("result", new SearchResponse());
        return "index";
    }
}
