package ru.ifmo.bdro1.form;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.ifmo.bdro1.enums.GuidanceType;
import ru.ifmo.bdro1.enums.MissileType;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MissileForm {
    private Long id;
    private String missileName;      // Название комплекса
    private String missileCode;      // Название ракеты
    private MissileType missileType;      // Тип ракеты
    private int missileRangeMin;     // Дальность стрельбы мин.
    private int missileRangeMax;    // Дальность стрельбы макс.
    private int missileSpeed;       // Скорость полета маршевая, м/с
    private int missileAltitude;     // Высота полета, м
    private int missileMass;         // Масса ракеты, кг
    private GuidanceType guidanceType;      // Тип системы наведения
    private String missileImage;      // изображение ракеты

}
