package com.abc.learning.modules.car;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.abc.learning.interfaces.GovtRecognition;
import com.abc.learning.interfaces.Introduction;
import com.abc.learning.interfaces.Vehicle;

@Component
@Scope("singleton")
public class Car implements Vehicle {

	@Value("${car.name}")
	private String name;

	@Value("${car.type}")
	private String type;

	@Value("${car.color}")
	private String color;

	@Value("${car.gearCount}")
	private int gearCount;

	@Value("${car.seatCount}")
	private int seatCount;

	//Field Level DI Using @Autowired
	@Autowired
	@Qualifier("carIntro")
	private Introduction introduction;

	//Field Level DI Using @Autowired
	@Autowired
	@Qualifier("carGovtRecognition")
	private GovtRecognition govtRecognition;

	@Override
	public String name() {
		return name;
	}

	@Override
	public String type() {
		return type;
	}

	@Override
	public String color() {
		return color;
	}

	@Override
	public int seatCount() {
		return seatCount;
	}

	@Override
	public int gearCount() {
		return gearCount;
	}

	@PostConstruct
	@Override
	public void display() {
		System.out.println("*** Vehicle Details ***");
		System.out.println("Vehicle Name : " + name);
		System.out.println("Vehicle Type : " + type);
		System.out.println("Vehicle Color : " + color);
		System.out.println("Vehicle Gear : " + gearCount);
		System.out.println("Vehicle No. Of Seats : " + seatCount);
		System.out.println("Vehicle Image : " + introduction.image());
		System.out.println("Vehicle Intro : " + introduction.intro());
		System.out.println("Vehicle Govt Recognized : " + govtRecognition.isGovtRecognized());
		System.out.println();
	}

	@PreDestroy
	@Override
	public void destroy() {
		System.out.println("Destroying Car Bean...");

	}

}
