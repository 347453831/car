package com.fengf.carrental.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fengf.carrental.entity.Vehicle;
import com.fengf.carrental.service.VehicleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * (Vehicle)表控制层
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Controller
@RequestMapping("/vehicle/")
public class VehicleController {
    /**
     * 服务对象
     */
    @Resource
    private VehicleService vehicleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Vehicle selectOne(Integer id) {
        return this.vehicleService.queryById(id);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param vehicleNum
     * @return 单条数据
     */
    @RequestMapping(value = "/selectOneByNum/{vehicleNum}",method = RequestMethod.GET)
    @ResponseBody
    public Boolean selectOne(@PathVariable("vehicleNum") String vehicleNum) {
        Vehicle vueByNum = vehicleService.findVueByNum(vehicleNum);
        if(ObjectUtil.isNotNull(vueByNum)){
            return true;
        }
        return false;
    }

    /**
     * 查询所有车辆
     */
    @GetMapping("selAllVehicle")
    public String selAllVehicle(Model model) {
        List<Vehicle> vehicles = vehicleService.queryAllVehicle();
        if (CollectionUtil.isNotEmpty(vehicles)) {
            model.addAttribute("vehicles", vehicles);
            return "find_car";
        } else {
            model.addAttribute("msg", "查找数据为空");
            return "find_car";
        }
    }

    /**
     * 添加车辆
     */
    @PostMapping("addVehicle")
    public String selectOne(Vehicle vehicle, Model model) {
        if (ObjectUtil.isNotNull(vehicle)) {
            if (vehicleService.insert(vehicle) > 0) {
                model.addAttribute("msg", "添加车辆成功");
                return "redirect:/vehicle/selAllVehicle";
            } else {
                model.addAttribute("msg", "添加车辆失败");
                return "add_car";
            }
        } else {
            model.addAttribute("msg", "添加车辆成功");
            return "add_car";
        }

    }

    /**
     * 修改车辆
     */
    @GetMapping("updVehicle")
    public String updVehicle() {
        return "update_car";

    }

    /**
     * 删除单个车辆页面
     */
    @GetMapping("delOneVehicle")
    public String delEmpById(Integer vheId) {
        if (vehicleService.deleteById(vheId)) {
            return "redirect:/vehicle/selAllVehicle";
        } else {
            return "redirect:/vehicle/selAllVehicle";
        }

    }


    /**
     * 查看车损
     */
    @GetMapping("carBad_mess")
    public String carBadMess(String vehicleNum, Model model) {

        if (ObjectUtil.isNotNull(vehicleNum)) {
            Vehicle vehicle = vehicleService.findVueByNum(vehicleNum);
            model.addAttribute("vehicle", vehicle);
            return "carbad_mess";
        }
        return "redirect:/vehicle/mend_carPage";
    }

    /**
     * 维修车辆页面
     */
    @PostMapping("mendCarPage")

    public String maintenanceCar(String vehicleNum, String vehicleChesun, String vehicleIntroduce) {

        if (ObjectUtil.isNotNull(vehicleNum)) {
            Vehicle vehicle = vehicleService.findVueByNum(vehicleNum);
            vehicle.setVehicleChesun(vehicleChesun);
            vehicle.setVehicleIntroduce(vehicleIntroduce);
            int count = vehicleService.updVueByNum(vehicle, vehicleNum);
            if (count > 0) {
                return "redirect:/vehicle/mend_carPage";
            } else {
                return "redirect:/vehicle/selAllVehicle";
            }
        }
        return "mend_car";
    }

    /**
     * 查看所有需要维修的车辆
     */
    @GetMapping("mend_carPage")
    public String mendCarPage(Model model) {
        List<Vehicle> vehicles = vehicleService.findAllByVehicleSituation();
        if (CollectionUtil.isNotEmpty(vehicles)) {
            model.addAttribute("list", vehicles);
            return "mend_car";
        } else {
            model.addAttribute("msg", "目前没有破损的车辆");
            return "mend_car";
        }
    }

    /**
     * 车辆报损页面
     */
    @GetMapping("car_badPage")
    public String carBadPage(String vehicleNum, Model model) {

        if (ObjectUtil.isNotNull(vehicleNum)) {
            model.addAttribute("vehicleNumber", vehicleNum);
        }
        return "car_bad";
    }

    /**
     * 车辆修复
     */
    @GetMapping("carRepairPage")
    public String carRepairPage(String vehicleNum, Model model) {

        if (ObjectUtil.isNotNull(vehicleNum)) {
            Vehicle vehicle = vehicleService.findVueByNum(vehicleNum);
            if (vehicle.getVehicleStatu() != 0) {
                model.addAttribute("msg", "请将车辆入库后在进行修复");
                return "mend_car";
            } else {
                vehicle.setVehicleSituation(0);
                vehicle.setVehicleChesun("");
                vehicle.setVehicleIntroduce("");
                vehicleService.updVueByNum(vehicle, vehicleNum);
                return "redirect:/vehicle/mend_carPage";
            }
        }
        model.addAttribute("vehicleNum", vehicleNum);
        return "car_bad";
    }

    /**
     * 会员租车
     */
    @GetMapping("borrow_carPage")
    public String borrow_carPage() {

        return "borrow_car";
    }

}