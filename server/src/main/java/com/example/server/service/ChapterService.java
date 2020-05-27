package com.example.server.service;

import com.example.server.domain.ChapterExample;
import com.example.server.domain.Chapter;
import com.example.server.dto.ChapterDto;
import com.example.server.mapper.ChapterMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/4/18 13:51
 * @description：
 */

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public List<ChapterDto> GetList() {
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);
        List<ChapterDto> chapterDtos = new ArrayList<>();
        for (int i = 0,size = chapters.size(); i < size; i++) {
            Chapter chapter = chapters.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtos.add(chapterDto);
        }
        return chapterDtos;
    }


}
