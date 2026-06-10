package com.example.jewel.jewelcontroller;
import com.example.jewel.jewelservices.JewelService;
import com.example.jewel.jewelmodel.JewelType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@RestController
@RequestMapping("/api/jewels")
public class JewelController {
    @Autowired
    private final JewelService jewelService ;
     @Autowired
    public JewelController(JewelService jewelService) {
        this.jewelService = jewelService;
    }

    // GET all jewel types
    @GetMapping("/all-types")
    public List<JewelType> getAllTypes() {
        return jewelService.getAllTypes();
    }

    // Optional: GET a single jewel type by ID
    @GetMapping("/{id}")
    public JewelType getJewelTypeById(@PathVariable("id") int id) {
        return jewelService.getJewelTypeById(id);
    }
}

        

