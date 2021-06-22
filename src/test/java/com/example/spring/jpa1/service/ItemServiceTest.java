package com.example.spring.jpa1.service;

import com.example.spring.jpa1.domain.item.Item;
import com.example.spring.jpa1.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        Item item1 = new Item() {
        };
        item1.setName("Book1");
        itemService.saveItem(item1);

    }

    @Test
    public void 상품단건조회() throws  Exception {

    }

    @Test
    public void 상품리스트조회() throws Exception {

    }
}