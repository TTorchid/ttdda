package com.sugar.dda.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sugar.dda.entity.Kdda;
import com.sugar.dda.mapper.KddaMapper;
import com.sugar.dda.service.KddaService;
import org.springframework.stereotype.Service;

@Service
public class KddaServiceImpl extends ServiceImpl<KddaMapper, Kdda> implements KddaService {
}
