package com.areastory.location.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@SuperBuilder
public class Location {
    @Column(length = 10, name = "dosi")
    protected String dosi;
    @Column(length = 10, name = "sigungu")
    protected String sigungu;
    @Column(length = 10, name = "dongeupmyeon")
    protected String dongeupmyeon;


    public Location(Location location) {
        this.dosi = location.dosi;
        this.sigungu = location.sigungu;
        this.dongeupmyeon = location.dongeupmyeon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(dosi, location.dosi) && Objects.equals(sigungu, location.sigungu) && Objects.equals(dongeupmyeon, location.dongeupmyeon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dosi, sigungu, dongeupmyeon);
    }

}
