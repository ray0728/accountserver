package com.rcircle.service.account.controller;

import com.rcircle.service.account.services.InviationCodeService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("update")
    public String updateCode(@RequestParam(name = "uid")int uid,
                          @RequestParam(name="cid")int cid){
        inviationCodeService.updateCode(cid, uid);
        return "";
    }
}
