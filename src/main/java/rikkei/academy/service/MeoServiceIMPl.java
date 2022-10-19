package rikkei.academy.service;

import org.springframework.stereotype.Service;
import rikkei.academy.model.Meo;

import java.util.ArrayList;
import java.util.List;
//@Service
public class MeoServiceIMPl implements IMeoService{
    private static List<Meo>lists = new ArrayList<>();

    @Override
    public List<Meo> findAll() {
        return lists;
    }

    @Override
    public void save(Meo meo) {
        int lastId = 0;
       if (lists.size() == 0){
          lastId = 1;
       }else {
           lastId = lists.get(lists.size()-1).getId()+1;
       }
       meo.setId(lastId);
       lists.add(meo);
    }
}
