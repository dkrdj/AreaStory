package com.areastory.location.db.repository.support;

import com.areastory.location.db.entity.Article;
import com.areastory.location.dto.common.LocationDto;

import java.util.List;

public interface ArticleRepositoryJooq {
    List<Article> getImage(List<LocationDto> locationList, Long userId);
}
