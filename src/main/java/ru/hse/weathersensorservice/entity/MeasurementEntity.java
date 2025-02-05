package ru.hse.weathersensorservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "measurement")
public class MeasurementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double value;

    Boolean raining;

    @ManyToOne
    SensorEntity sensor;
}
