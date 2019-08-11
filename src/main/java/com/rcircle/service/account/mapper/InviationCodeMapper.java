package com.rcircle.service.account.mapper;

import com.rcircle.service.account.model.InviationCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InviationCodeMapper {
    public InviationCode getCodeInfo(InviationCode code);
    public int update(@Param("id")int id, @Param("fuid")int fuid);
}
