package com.techfirebase.spring.smartdustbin.controller;

import com.techfirebase.spring.smartdustbin.domain.Area;
import com.techfirebase.spring.smartdustbin.repository.AreaRepository;
import com.techfirebase.spring.smartdustbin.util.sensorsinfo.Dustbin;
import com.techfirebase.spring.smartdustbin.util.sensorsinfo.DustbinResponse;
import com.techfirebase.spring.smartdustbin.util.sensorsinfo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author VIVEK KUMAR SINGH
 * @since (2018 - 04 - 09 13 : 50 : 39)
 */
@RestController
@RequestMapping("area")
public class AreaController {

    private AreaRepository areaRepository;
    private Map<String, Area> dbAreaMap;
    private final String uri = "https://e2c38i5g1m.execute-api.us-east-2.amazonaws.com/Deployment";
    private Map<String, DustbinResponse> dustbinResponseMap = new HashMap<>();
    private Dustbin dustbin;

    @Autowired
    AreaController(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @GetMapping
    public List<Area> getAllAreas() {
        List<Area> dbAreas = areaRepository.findAll();

//        dbAreaMap = new HashMap<>();
        /*dbAreas.forEach(area -> {
            dbAreaMap.put(area.getDustbinId(), area);
        });*/

        return dbAreas;
    }

    /*@GetMapping("/dustbin-status")
    @Transactional
    public Map<String, DustbinResponse> getFilledAreas() {
        getAllAreas();

        for (Item item : dustbin.getItems()) {
            int height = Math.round(item.getEnvnData().getReport().getDistance());

            if (height >= 90*//* && height <= 100*//*) {
                dustbinResponseMap.put("filled", new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            } else if (height >= 75 && height < 90) {
                dustbinResponseMap.put("above-half-filled", new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            } else if (height >= 50 && height < 75) {
                dustbinResponseMap.put("half-filled", new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            } else if (height >= 25 && height <= 50) {
                dustbinResponseMap.put("below-half-filled", new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            }
        }
        return dustbinResponseMap;
    }*/

    @GetMapping("/dustbin-list/{dustbinType}")
    @Transactional
    public List<DustbinResponse> getDustbinList(@PathVariable String dustbinType) {
        getAllAreas();
        dustbin = new RestTemplate().getForObject(uri, Dustbin.class);

        List<DustbinResponse> dustbins = new ArrayList<>();

        for (Item item : dustbin.getItems()) {
            int height = Math.round(item.getEnvnData().getReport().getDistance());

            if (height >= 90 && "filled".equals(dustbinType)) {
                dustbins.add(new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            } else if (height >= 75 && height < 90 && "above-half-filled".equals(dustbinType)) {
                dustbins.add(new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            } else if (height >= 50 && height < 75 && "half-filled".equals(dustbinType)) {
                dustbins.add(new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            } else if (height <= 50 && "below-half-filled".equals(dustbinType)) {
                dustbins.add(new DustbinResponse(dbAreaMap.get(item.getDeviceId()), item.getTimestamp()));
            }
        }

        return dustbins;
    }

    @PostMapping
    public Area saveArea(@RequestBody Area area) {
        return areaRepository.saveAndFlush(area);
    }

    @PutMapping
    public Area updateAreas(@RequestBody Area area) {
        return areaRepository.save(area);
    }

    @DeleteMapping
    public void deleteArea(@RequestBody Area area) {
        areaRepository.delete(area);
    }
}
