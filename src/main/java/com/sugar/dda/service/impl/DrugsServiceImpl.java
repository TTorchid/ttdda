package com.sugar.dda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sugar.dda.entity.Drugs;
import com.sugar.dda.mapper.DrugsMapper;
import com.sugar.dda.service.DrugsService;
import org.springframework.stereotype.Service;

@Service
public class DrugsServiceImpl extends ServiceImpl<DrugsMapper, Drugs> implements DrugsService {
}
