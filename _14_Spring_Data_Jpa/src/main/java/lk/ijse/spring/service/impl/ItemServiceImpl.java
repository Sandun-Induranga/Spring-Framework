package lk.ijse.spring.service.impl;

import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * @author : Sandun Induranga
 * @since : 0.1.0
 **/

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (repo.existsById(itemDTO.getCode())) {
            throw new RuntimeException("Item Already Exists..!");
        }
        repo.save(mapper.map(itemDTO, Item.class));
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (repo.existsById(itemDTO.getCode())) {
            repo.save(mapper.map(itemDTO, Item.class));
        } else {
            throw new RuntimeException("Item Not Exists..!");
        }
    }

    @Override
    public void deleteItem(String code) {
        if (repo.existsById(code)) {
            repo.deleteById(code);
        } else {
            throw new RuntimeException("Item Not Exists..!");
        }
    }

    @Override
    public ArrayList<CustomerDTO> getAllItems() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<ItemDTO>>() {}.getType());
    }
}
