package com.nawale.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Features {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String featureTitle;
    private String featureDescription;
    private String icon;

}
