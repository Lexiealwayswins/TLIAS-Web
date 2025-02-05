package com.itheima.tliaswebmanagement;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++){
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * 生成JWT
     */
    @Test
    public void testFenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheimaitheimaitheimaitheimaitheimaitheimaitheima") // 设置签名算法
                .setClaims(claims) // 自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000)) // 设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcyNDAxOTk5N30.jaO0b-ttW_-ErzLz5wSKru0mVWqex6kUJnfyz8IoX-g")
                .getBody();
        System.out.println(claims);
    }

}
