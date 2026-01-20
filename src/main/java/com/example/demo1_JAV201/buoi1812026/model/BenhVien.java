package com.example.demo1_JAV201.buoi1812026.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "benh_vien")
public class BenhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_benh_vien")
    private String tenBenhVien;

    @Column(name = "dia_chi")
    private String diaChi;
}
