package com.example.server.service;

import com.example.server.domain.ChapterExample;
import com.example.server.domain.Chapter;
import com.example.server.dto.ChapterDto;
import com.example.server.dto.PageDto;
import com.example.server.mapper.ChapterMapper;
import com.example.server.util.CopyUtil;
import com.example.server.util.UuidUtil;
import com.example.server.util.ValidatorUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        /*List<ChapterDto> chapterDtos = new ArrayList<>();
        for (int i = 0, size = chapters.size(); i < size; i++) {
            Chapter chapter = chapters.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter, chapterDto);
            chapterDtos.add(chapterDto);
        }*/
        List<ChapterDto> chapterDtos = CopyUtil.copyList(chapters, ChapterDto.class);
        pageDto.setList(chapterDtos);
        return pageDto;
    }

    /**
     * 保存方法中判断是否存在id字段，如果存在则为修改，不存在则是新增，调用不同的方法进行处理
     *
     * @param chapterDto
     */
    public void save(ChapterDto chapterDto) {

        // 保存校验
        ValidatorUtil.require(chapterDto.getName(), "名称");
        ValidatorUtil.require(chapterDto.getCourseId(), "课程ID");
        ValidatorUtil.length(chapterDto.getCourseId(), "课程ID", 1, 8);

        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        if (StringUtils.isEmpty(chapterDto.getId())) {
            this.insert(chapter);
        } else {
            this.update(chapter);
        }
    }

    private void insert(Chapter chapter) {
        chapter.setId(UuidUtil.getShortUuid());
        chapterMapper.insert(chapter);
    }

    private void update(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
    }

    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }


}
