package com.areastory.location.db.repository.support;

import com.areastory.location.db.entity.Article;
import com.areastory.location.dto.common.LocationDto;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryJooqImpl implements ArticleRepositoryJooq {
    private final DSLContext context;
    @Override
    public List<Article> getImage(List<LocationDto> locationList, Long userId) {
        Result<Record> fetch = context.selectFrom(table("article"))
                .where(field("dosi", String.class).eq("경기도"))
                .orderBy(field("daily_like_count", Integer.class).desc())
                .limit(1).fetch();
        List<Article> map = fetch.map(o -> o.into(Article.class));
        return map;
    }
}
