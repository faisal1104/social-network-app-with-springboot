package com.example.springbootform.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="status_table")
@Data @NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long statusId;

    @Column
    private String statusText;

    @ManyToOne
    private Location location;

    private Boolean statusPrivacy = true;

    public Status(String statusText) {
        this.statusText = statusText;
    }
}
