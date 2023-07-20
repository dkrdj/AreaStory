package com.areastory.location.db.repository.support;

import com.areastory.location.db.entity.Article;
import com.areastory.location.dto.common.LocationDto;
import com.example.api.jooqgen.tables.records.ArticleRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.SelectUnionStep;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.api.jooqgen.Tables.ARTICLE;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryJooqImpl implements ArticleRepositoryJooq {
    private final DSLContext context;

    @Override
    public List<Article> getImage(List<LocationDto> locationList, Long userId) {
        SelectUnionStep<ArticleRecord> unionQuery = null;
        for (LocationDto locationDto : locationList) {
            Condition whereQuery = ARTICLE.DOSI.eq(locationDto.getDosi());
            if (locationDto.getSigungu() != null) {
                whereQuery = whereQuery.and(ARTICLE.SIGUNGU.eq(locationDto.getSigungu()));
            }
            if (locationDto.getDongeupmyeon() != null) {
                whereQuery = whereQuery.and(ARTICLE.DONGEUPMYEON.eq(locationDto.getDongeupmyeon()));
            }
            SelectUnionStep<ArticleRecord> query = context.selectFrom(ARTICLE)
                    .where(whereQuery.and(ARTICLE.USER_ID.eq(userId)))
                    .orderBy(ARTICLE.DAILY_LIKE_COUNT.desc())
                    .limit(1);
            unionQuery = (unionQuery == null) ? query : unionQuery.union(query);
        }
        return unionQuery.fetchInto(Article.class);
    }
}
