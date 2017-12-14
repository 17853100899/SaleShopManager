package com.tsinghua.saleshopmanager.util;

import java.text.DecimalFormat;


public class NumberFormatUtil {
	public static String format(double number){
		DecimalFormat nf=new DecimalFormat("0.00");	
		return nf.format(number);
	}
	public static void main(String[] args) {
		System.out.println(format(1.68999876));
	}

}
