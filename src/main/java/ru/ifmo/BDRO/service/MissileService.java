package ru.ifmo.BDRO.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.BDRO.entity.Missile;
import ru.ifmo.BDRO.exception.MissileNotFountException;
import ru.ifmo.BDRO.form.MissileForm;
import ru.ifmo.BDRO.repository.MissileRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MissileService {

    @Autowired
    private MissileRepository missileRepository;

    @Transactional
    public Long saveAndGetId(MissileForm missileForm) {
        Missile missile = new Missile();
        BeanUtils.copyProperties(missileForm, missile);
        Missile savedMissile = missileRepository.save(missile);
        return savedMissile.getId();
    }

    @Transactional(readOnly = true)
    public MissileForm findById(Long id) {
        Optional<Missile> missileOptional = missileRepository.findById(id);
        return toForm(missileOptional);
    }

    @Transactional(readOnly = true)
    public MissileForm findByMissileName(String missileName) {
        Optional<Missile> missileOptional = missileRepository.findByMissileName(missileName);
        return toForm(missileOptional);
    }

    @Transactional(readOnly = true)
    public MissileForm findByMissileCode(String missileCode) {
        Optional<Missile> missileOptional = missileRepository.findByMissileCode(missileCode);
        return toForm(missileOptional);
    }

    @Transactional(readOnly = true)
    public List<MissileForm> findAll() {
        List<Missile> missileList = missileRepository.findAll();
        return toForm(missileList);
    }

    private List<MissileForm> toForm(List<Missile> missileList) {
        List<MissileForm> missileFormList = new ArrayList<>();
        for (Missile missile : missileList) {
            missileFormList.add(toForm(missile));
        }
        return missileFormList;
    }

    private MissileForm toForm(Optional<Missile> missileOptional) {
        if (!missileOptional.isPresent()) {
            throw new MissileNotFountException();
        }
        return toForm(missileOptional.get());
    }

    private MissileForm toForm(Missile missile) {
        MissileForm missileForm = new MissileForm();
        BeanUtils.copyProperties(missile, missileForm);
        return missileForm;
    }

    @Transactional
    public void deleteById(Long id) {
        missileRepository.deleteById(id);
    }
}
