package com.example.business.controller.admin;

import com.example.server.domain.Chapter;
import com.example.server.dto.ChapterDto;
import com.example.server.service.ChapterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/4/18 0:27
 * @description：
 */

@RestController
@RequestMapping("/admin")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/chapter")
    public List<ChapterDto> chapter(){
        return chapterService.GetList();
    }


}
