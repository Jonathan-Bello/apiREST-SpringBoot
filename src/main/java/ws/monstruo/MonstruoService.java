package ws.monstruo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MonstruoService {
    
    @Autowired
    private MonstruoReposity repo;

    public List<Monstruo> listAll(){
        return repo.findAll();
    }

    public void save(Monstruo monstruo){
        repo.save(monstruo);
    }

    public Monstruo get(Integer id){
        return repo.findById(id).get();
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }


	
}
