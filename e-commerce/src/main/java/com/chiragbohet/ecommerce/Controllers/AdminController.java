package com.chiragbohet.ecommerce.Controllers;

import com.chiragbohet.ecommerce.Services.CustomerService;
import com.chiragbohet.ecommerce.Services.SellerService;
import com.chiragbohet.ecommerce.Utilities.GlobalVariables;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api("Various Admin related tasks")
@RestController
public class AdminController {

    @Autowired
    CustomerService customerService;

    @Autowired
    SellerService sellerService;

    @ApiOperation("Get a list of all registered Customers")
    @GetMapping("/admin/customer")
    ResponseEntity getAllCustomers(@RequestParam(value = "page", defaultValue = GlobalVariables.DEFAULT_PAGE_OFFSET) Optional<Integer> page,
                                   @RequestParam(value = "size", defaultValue = GlobalVariables.DEFAULT_PAGE_SIZE) Optional<Integer> size,
                                   @RequestParam(value = "sort", defaultValue = GlobalVariables.DEFAULT_SORT_PROPERTY) Optional<String> sortProperty,
                                   @RequestParam(value = "direction", defaultValue = GlobalVariables.DEFAULT_SORT_DIRECTION) Optional<String> sortDirection) {

        return customerService.getAllCustomers(page, size, sortProperty, sortDirection);

    }

    @ApiOperation("Get a list of all registered Sellers")
    @GetMapping("/admin/seller")
    ResponseEntity getAllSellers(@RequestParam(value = "page", defaultValue = GlobalVariables.DEFAULT_PAGE_OFFSET) Optional<Integer> page,
                                 @RequestParam(value = "size", defaultValue = GlobalVariables.DEFAULT_PAGE_SIZE) Optional<Integer> size,
                                 @RequestParam(value = "sort", defaultValue = GlobalVariables.DEFAULT_SORT_PROPERTY) Optional<String> sortProperty,
                                 @RequestParam(value = "direction", defaultValue = GlobalVariables.DEFAULT_SORT_DIRECTION) Optional<String> sortDirection) {

        return sellerService.getAllSellers(page, size, sortProperty, sortDirection);

    }

    @ApiOperation("Activate a customer")
    @PatchMapping("admin/customer/activate/{id}")
    ResponseEntity activateCustomer(@PathVariable Long id) {
        return customerService.activateCustomer(id);
    }

    @ApiOperation("Deactivate a customer")
    @PatchMapping("admin/customer/deactivate/{id}")
    ResponseEntity deactivateCustomer(@PathVariable Long id) {
        return customerService.deactivateCustomer(id);
    }

    @ApiOperation("Activate a seller")
    @PatchMapping("admin/seller/activate/{id}")
    ResponseEntity activateSeller(@PathVariable Long id) {
        return sellerService.activateSeller(id);
    }

    @ApiOperation("Deactivate a seller")
    @PatchMapping("admin/seller/deactivate/{id}")
    ResponseEntity deactivateSeller(@PathVariable Long id) {
        return sellerService.deactivateSeller(id);
    }

}
