package com.sugar.dda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sugar.dda.entity.Diseases;
import com.sugar.dda.mapper.DiseasesMapper;
import com.sugar.dda.service.DiseasesService;
import org.springframework.stereotype.Service;

@Service
public class DiseasesServiceImpl extends ServiceImpl<DiseasesMapper, Diseases> implements DiseasesService {
}
