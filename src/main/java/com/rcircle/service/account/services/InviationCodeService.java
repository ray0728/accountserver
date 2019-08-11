package com.rcircle.service.account.services;

import com.rcircle.service.account.mapper.InviationCodeMapper;
import com.rcircle.service.account.model.InviationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InviationCodeService {
    @Autowired
    private InviationCodeMapper inviationCodeMapper;

    public int getCodeValid(String code) {
        InviationCode inviationCode = new InviationCode();
        inviationCode.setCode(code);
        inviationCode = inviationCodeMapper.getCodeInfo(inviationCode);
        if (inviationCode != null && inviationCode.getUsed() == 0) {
            return inviationCode.getId();
        } else {
            return 0;
        }
    }

    public int updateCode(int id, int uid){
        return inviationCodeMapper.update(id, uid);
    }
}
