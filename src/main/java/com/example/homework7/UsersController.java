package com.example.homework7;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;


@RestController
public class UsersController {

    @GetMapping("/users")
    public List<String> getNames(@RequestParam(value = "name", defaultValue = "") String name
            , @RequestParam(value = "birthday", defaultValue = "") String birthday) {

        return List.of(name, birthday);
    }


    @PostMapping("/users")
    public ResponseEntity<String> create(@RequestBody @Validated CreateForm form) {
// 登録処理は省略
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/users/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
//        System.out.println("=======================");
//        System.out.println(nameCreateForm.getName());
//        System.out.println(nameCreateForm.getAddress());
//        System.out.println(nameCreateForm.getAddress());
//        System.out.println("=======================");

        return ResponseEntity.created(url).body("name successfully　created");
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
// 更新処理は省略
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully delete"));
    }

}

