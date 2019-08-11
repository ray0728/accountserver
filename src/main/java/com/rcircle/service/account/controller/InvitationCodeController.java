package com.rcircle.service.account.controller;

import com.rcircle.service.account.services.InviationCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/invitation")
public class InvitationCodeController {
    @Resource
    private InviationCodeService inviationCodeService;

    @GetMapping("check_code")
    public int checkCode(String code) {
        return inviationCodeService.getCodeValid(code);
    }
}
