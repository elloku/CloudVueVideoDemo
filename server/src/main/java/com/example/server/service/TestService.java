package com.example.server.service;

import com.example.server.domain.Test;
import com.example.server.mapper.TestMapper;
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
