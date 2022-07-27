package com.industry.employee.controller;

import com.industry.employee.dto.EmployeeDto;
import com.industry.employee.dto.IndustryResponseVO;
import com.industry.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "addemp",method = RequestMethod.POST)
    public Boolean insertEmpDataCtrl(@RequestBody EmployeeDto employeeDto){
        Boolean flag=employeeService.insertEmpDataService(employeeDto);
        if (flag==true){
            return flag;
        }
        else {
            return flag;
        }
    }

    @RequestMapping(value = "getdept/{indId}",method = RequestMethod.GET)
    public IndustryResponseVO<List> getDeptController(@PathVariable Integer indId){
        IndustryResponseVO<List> industryResponseVO=new IndustryResponseVO<>();
        List list=employeeService.getDeptService(indId);
        if (list.size()!=0){
            industryResponseVO.setResult(list);
            industryResponseVO.setMessage("List found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Not Found");
            return industryResponseVO;
        }
    }

    @RequestMapping(value = "getemp",method = RequestMethod.GET)
    public IndustryResponseVO<List> getEmpCtrl(){
        IndustryResponseVO<List> industryResponseVO=new IndustryResponseVO<>();
        List list=employeeService.getEmpService();
        if (list.size()!=0){
            industryResponseVO.setResult(list);
            industryResponseVO.setMessage("Data found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Data not found");
            return industryResponseVO;
        }
    }

    @RequestMapping(value = "getdeptwiseemp/{deptid}",method = RequestMethod.GET)
    public IndustryResponseVO<List> getEmpListCtrl(@PathVariable Integer deptid){
        IndustryResponseVO<List> industryResponseVO=new IndustryResponseVO<>();
        List list=employeeService.getEmpListService(deptid);
        if (list.size()!=0){
            industryResponseVO.setResult(list);
            industryResponseVO.setMessage("Data found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Not found");
            return industryResponseVO;
        }
    }

    @RequestMapping(value = "editemp/{empid}",method = RequestMethod.GET)
    public IndustryResponseVO<EmployeeDto> editEmpCtrl(@PathVariable Integer empid){
        IndustryResponseVO<EmployeeDto> industryResponseVO=new IndustryResponseVO<>();
        EmployeeDto employeeDto=employeeService.editEmpService(empid);
        if (employeeDto !=null){
            industryResponseVO.setResult(employeeDto);
            industryResponseVO.setMessage("Data found");
            return industryResponseVO;
        }
        else {
            industryResponseVO.setMessage("Data not found");
            return industryResponseVO;
        }

    }

    @RequestMapping(value = "deleteemp/{empid}",method = RequestMethod.GET)
    public Boolean deleteEmpCtrl(@PathVariable Integer empid){
        Boolean flag=employeeService.deletEmpService(empid);
        if (flag==true){
            return true;
        }
        else {
            return false;
        }
    }
}
