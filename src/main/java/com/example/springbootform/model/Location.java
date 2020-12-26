package com.example.springbootform.model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="location_table")
@Data @NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationId;
    @Column
    private String locationName;


    public Location(String locationName) {
        this.locationName = locationName;
    }
}
