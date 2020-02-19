package com.gift.evoucher;

import com.gift.evoucher.service.VoucherService;
import com.gift.evoucher.service.impl.VoucherServiceImpl;
import com.gift.evoucher.util.VoucherGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EVoucherApplication {


	public static void main(String[] args) {
		SpringApplication.run(EVoucherApplication.class, args);

	}

}
