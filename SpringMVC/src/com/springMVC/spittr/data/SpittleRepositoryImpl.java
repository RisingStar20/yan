package com.springMVC.spittr.data;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.apache.bcel.verifier.statics.LONG_Upper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.springMVC.spittr.Spittle;
@Component
public class SpittleRepositoryImpl implements SpittleRepository{
	public static final String MAX_LONG_AS_STRING= Long.toString(Long.MAX_VALUE);
	public List<Spittle> findSpittle(@RequestParam(value="max",defaultValue=MAX_LONG_AS_STRING)long max,
				@RequestParam(value="count",defaultValue="5")int count) {
		List<Spittle> spittleList=new ArrayList<Spittle>();
		for(int k=0;k<count;k++){
			  Date currentTime = new Date();
				spittleList.add(new Spittle("spittle"+k,currentTime));
		}
		return spittleList;
	}
}
