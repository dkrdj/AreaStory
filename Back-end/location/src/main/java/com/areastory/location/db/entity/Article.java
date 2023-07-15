package com.areastory.location.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Setter
@Table(name = "article"
//        indexes = {
//        @Index(name = "idx_location4", columnList = "daily_like_count"),
//        @Index(name = "idx_location2", columnList = "dosi,daily_like_count"),
//        @Index(name = "idx_location3", columnList = "dosi,sigungu,daily_like_count"),
//        @Index(name = "idx_location1", columnList = "dosi,sigungu,dongeupmyeon,daily_like_count")
//}
)
@SuperBuilder
public class Article extends Location {
    @Id
    @Column(name = "article_id")
    private Long articleId;
    @Column(name = "user_id")
    private Long userId;
    @Column(length = 200, name = "image")
    private String image;
    @Column(name = "daily_like_count")
    @ColumnDefault("0")
    private Long dailyLikeCount;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "public_yn")
    private Boolean publicYn;
}
