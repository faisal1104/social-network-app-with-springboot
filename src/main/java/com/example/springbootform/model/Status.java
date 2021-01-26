package com.example.springbootform.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="status_table")
@Data @NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statusId;
    @Column
    private String statusText;
    @ManyToOne
    private Location location;
    @Column
    private String statusPrivacy;
//    @ManyToOne
//    @JoinTable(
//            name = "user_status",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "status_id"))
//    private User user;

    public Status(String statusText) {
        this.statusText = statusText;
    }
}
