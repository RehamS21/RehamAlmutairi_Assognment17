package com.example.rehamalmutairi_assognment17.Conroller;

import com.example.rehamalmutairi_assognment17.ApiResponse.ApiResponse;
import com.example.rehamalmutairi_assognment17.Model.User;
import com.example.rehamalmutairi_assognment17.Service.UserManagementService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserManagementController {
    private final UserManagementService userManagementService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        return ResponseEntity.status(200).body(userManagementService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addNewUSer(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        userManagementService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUserController(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }

        Boolean isUpdated = userManagementService.updateUser(id, user);

        if (isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("The user updated successfully"));
        else
            return ResponseEntity.status(400).body(new ApiResponse("Sorry the id is wrong"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserConroller(@PathVariable Integer id){
        Boolean isDeleted = userManagementService.deleteUser(id);

        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
        else
            return ResponseEntity.status(400).body(new ApiResponse("Sorry the id is wrong"));
    }


}
