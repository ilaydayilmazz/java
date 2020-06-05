package com.i.springBootCrudRestDemo.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Kurs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kurs-numarator")
    @SequenceGenerator(name = "kurs-numarator",  sequenceName = "KURS_SEQ", allocationSize=1)
    @Column(name="ID")
    private Integer id;

    @Column(name="KURS_ADI")
    private String kursAdi;

    @Column(name="saat")
    private int saat;

    @Column(name="ogretmen_id")
    private String ogretmen_id;

    public Kurs() {
    }

    public Integer getId() {
        return id;
    }

    public String getKursAdi() {
        return kursAdi;
    }

    public int getSaat() {
        return saat;
    }

    public String getOgretmen_id() {
        return ogretmen_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKursAdi(String kursAdi) {
        this.kursAdi = kursAdi;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public void setOgretmen_id(String ogretmen_id) {
        this.ogretmen_id = ogretmen_id;
    }
}
