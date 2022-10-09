package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Pengembalian;
import com.perpustakaan.perpustakaansalwa.repository.PengembalianRepository;
import com.perpustakaan.perpustakaansalwa.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PengembalianServiceImpl implements PengembalianService {

    @Autowired
    private PengembalianRepository repository;

    @Override
    public Pengembalian save(Pengembalian param)
    {
        return repository.save(param);
    }

    @Override
    public List<Pengembalian> findAllData()
    {
        return  repository.findAll();

    }
    @Override
    public Pengembalian update(Pengembalian param, Long id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null){
            data.setTglPengembalian(param.getTglPengembalian()== null ? data.getTglPengembalian() : param.getTglPengembalian());
            data.setDenda(param.getDenda()== null ? data.getDenda() : param.getDenda());

            return  repository.save(data);
        }
        return data;

    }
    @Override
    public Boolean delete(Long id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public Pengembalian findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

