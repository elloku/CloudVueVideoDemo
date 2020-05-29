package com.example.server.service;

import com.example.server.domain.ChapterExample;
import com.example.server.domain.Chapter;
import com.example.server.dto.ChapterDto;
import com.example.server.dto.PageDto;
import com.example.server.mapper.ChapterMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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


    public PageDto GetList(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapters);
        pageDto.setTotal(pageInfo.getTotal());
        List<ChapterDto> chapterDtos = new ArrayList<>();
        for (int i = 0, size = chapters.size(); i < size; i++) {
            Chapter chapter = chapters.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter, chapterDto);
            chapterDtos.add(chapterDto);
        }
        pageDto.setList(chapterDtos);
        return pageDto;
    }


}
