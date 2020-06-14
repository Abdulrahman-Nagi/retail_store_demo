package com.ups.retailstore.service;





import com.ups.retailstore.entity.Discount;
import com.ups.retailstore.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RetailOrderService {






    public Discount getDiscount () {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                User user = (User) authentication.getPrincipal();


                return user.getRetailDiscount();






    }


}
