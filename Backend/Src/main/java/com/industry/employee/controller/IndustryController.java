package com.industry.employee.controller;

import com.industry.employee.dto.IndustryDto;
import com.industry.employee.dto.IndustryResponseVO;
import com.industry.employee.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class IndustryController {
    @Autowired
    private IndustryService industryService;

    @RequestMapping(value = "addind", method = RequestMethod.POST)
    public Boolean insertIndustryCtrl(@RequestBody IndustryDto industryDto) {
        Boolean flag = industryService.insertIndustryService(industryDto);
        if (flag == true) {
            return flag;
        } else {
            return flag;
        }
    }

    @RequestMapping(value = "getind", method = RequestMethod.GET)
    public IndustryResponseVO<List> getIndustryDataCtrl() {
        IndustryResponseVO<List> industryResponseVO = new IndustryResponseVO<>();
        List list = industryService.getIndDataService();
        if (list.size() != 0) {
            industryResponseVO.setMessage("Data found");
            industryResponseVO.setResult(list);
            return industryResponseVO;
        } else {
            industryResponseVO.setMessage("Data Not Found");
            industryResponseVO.setResult(list);
            return industryResponseVO;
        }
    }

    @RequestMapping(value = "editind/{indId}", method = RequestMethod.GET)
    public IndustryResponseVO<IndustryDto> editIndDataCtrl(@PathVariable Integer indId) {
        IndustryResponseVO<IndustryDto> industryResponseVO = new IndustryResponseVO<>();
        IndustryDto industryDto = industryService.editIndDataService(indId);
        if (industryDto != null) {
            industryResponseVO.setMessage("Data Found");
            industryResponseVO.setResult(industryDto);
            return industryResponseVO;
        } else {
            industryResponseVO.setMessage("Not found");
            industryResponseVO.setResult(industryDto);
            return industryResponseVO;
        }
    }

    @RequestMapping(value = "deleteind/{indId}",method = RequestMethod.GET)
    public Boolean deleteIndDataCtrl(@PathVariable Integer indId){

        Boolean flag=industryService.deleteIndDataService(indId);
        if (flag==true){
            return flag;
        }
        else {
           return flag;
        }
    }
}
