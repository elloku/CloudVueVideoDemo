package com.example.system.service;

import com.example.system.domain.Test;
import com.example.system.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/4/18 13:51
 * @description：
 */

@Service
public class TestService {

    @Resource
    private TestMapper testMapper;

    public List<Test> GetList(){
        return testMapper.GetList();
    }
}
