package ru.hse.weathersensorservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.hse.weathersensorservice.entity.SensorEntity;
import ru.hse.weathersensorservice.repository.SensorRepository;

@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    public SensorEntity save(SensorEntity SensorEntity) {
        return sensorRepository.save(SensorEntity);
    }


    /**
     * Создание пользователя
     *
     * @return созданный пользователь
     */
    public SensorEntity create(SensorEntity SensorEntity) {
        if (sensorRepository.existsByName(SensorEntity.getName())) {
            throw new RuntimeException("SensorEntity with name " + SensorEntity.getName() + " already exists");
        }

        return save(SensorEntity);
    }

    public SensorEntity getByName(String name) {
        return sensorRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Пользователь не найден"));
    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    public UserDetailsService sensorDetailsService() {
        return this::getByName;
    }

}
