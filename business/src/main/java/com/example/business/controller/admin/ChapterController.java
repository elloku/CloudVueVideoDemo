package com.example.business.controller.admin;

import com.example.server.domain.Chapter;
import com.example.server.dto.ChapterDto;
import com.example.server.dto.PageDto;
import com.example.server.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.server.service.ChapterService;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/admin/chapter")
public class ChapterController {

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/getlist")
    public ResponseDto list(@RequestBody PageDto pageDto) {
        LOG.info("pageDto: {}", pageDto);
        ResponseDto responseDto = new ResponseDto();
        PageDto page = chapterService.GetList(pageDto);
        responseDto.setContent(page);
        return responseDto;
    }

    @RequestMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {
        LOG.info("chapterDto: {}", chapterDto);
        ResponseDto responseDto = new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }


}
