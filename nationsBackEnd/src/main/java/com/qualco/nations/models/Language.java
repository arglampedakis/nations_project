package com.qualco.nations.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "languages")
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "language_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;

    @Column(name = "language", nullable = false)
    private String language;

}
