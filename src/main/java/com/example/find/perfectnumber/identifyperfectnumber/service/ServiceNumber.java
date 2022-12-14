package com.example.find.perfectnumber.identifyperfectnumber.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceNumber {
	
	public boolean findperfectnumber(int value) {
		int sum=0;
		for(int i=1;i<value;i++) {
			if(value%i==0)
			{
				sum=sum+i;
			}
		}
		if(sum==value) {
			return true;
		}else {
			return false;
		}
		
	}

}
