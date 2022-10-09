package com.perpustakaan.perpustakaansalwa.service.Impl;

import com.perpustakaan.perpustakaansalwa.entity.Pengembalian;
import com.perpustakaan.perpustakaansalwa.entity.dto.PengembalianDTO;
import com.perpustakaan.perpustakaansalwa.entity.mapping.PengembalianMapping;
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
    public PengembalianDTO save(PengembalianDTO param){
        Pengembalian data = repository.save(PengembalianMapping.instance.toEntity(param));
        return PengembalianMapping.instance.toDto(data);
    }

    @Override
    public List<PengembalianDTO> findAllData()
    {
        return  PengembalianMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public PengembalianDTO update(PengembalianDTO param, Long id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null){
            data.setTglPengembalian(param.getTglPengembalian()== null ? data.getTglPengembalian() : param.getTglPengembalian());
            data.setDenda(param.getDenda()== null ? data.getDenda() : param.getDenda());

            return  PengembalianMapping.instance.toDto(data);
        }
        return PengembalianMapping.instance.toDto(data);

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
    public PengembalianDTO findById(Long id) {
        return PengembalianMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
