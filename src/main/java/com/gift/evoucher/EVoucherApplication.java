package com.gift.evoucher;

import com.gift.evoucher.model.Voucher;
import com.gift.evoucher.service.VoucherService;
import com.gift.evoucher.service.impl.VoucherServiceImpl;
import com.gift.evoucher.util.VoucherGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EVoucherApplication {


	public static void main(String[] args) {
		SpringApplication.run(EVoucherApplication.class, args);

	}

	@Bean
	CommandLineRunner init (VoucherService voucherService){
		return  args -> {
			List<Voucher> vouchers =new VoucherGenerator().generateVoucher();
			voucherService.saveAll(vouchers);
		};
	}

}
