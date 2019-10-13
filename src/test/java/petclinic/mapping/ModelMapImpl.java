package petclinic.mapping;

import java.util.HashMap;
import java.util.Map;

import br.com.meridius.junit5.petclinic.fauxspring.Model;

public class ModelMapImpl implements Model {
    
	Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
       // set will not be doing nothing for now...
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
