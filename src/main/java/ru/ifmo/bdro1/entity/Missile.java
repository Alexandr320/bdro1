package ru.ifmo.bdro1.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ifmo.bdro1.enums.GuidanceType;
import ru.ifmo.bdro1.enums.MissileType;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Missile {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column
    private String missileName;      // Название комплекса

    @Column
    private String missileCode;      // Название ракеты

    @Column
    @Enumerated(EnumType.STRING)
    private MissileType missileType;      // Тип ракеты

    @Column
    private int missileRangeMin;     // Дальность стрельбы мин.

    @Column
    private int missileRangeMax;    // Дальность стрельбы макс.

    @Column
    private int missileSpeed;       // Скорость полета маршевая, м/с

    @Column
    private int missileAltitude;     // Высота полета, м

    @Column
    private int missileMass;         // Масса ракеты, кг

    @Column
    @Enumerated(EnumType.STRING)
    private GuidanceType guidanceType;      // Тип системы наведения

    @Column
    private String missileImage;      // изображение ракеты

}
