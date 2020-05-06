package com.review.web.lose;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class LoseDaoImpl implements LoseDao{

	private static final String FILE_PATH = "/Users/ihyeongtae/git/repository2/review/src/main/resources/static/resources/file/";

	@Override
	public List<Lose> selectAll() {
		List<Lose> lostList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(
									new FileReader(
									new File(FILE_PATH+"lost.csv")));
			String message = "";
			while((message = reader.readLine()) !=null) {
				list.add(message);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("file read error");
		}
		Lose l = null;
		for(int i=0; i<list.size(); i++) {
			l = new Lose();
			String[] arr = list.get(i).split(",");
			l.setLostId(arr[0]);
			l.setLostName(arr[1]);
			l.setLostDate(arr[2]);
			l.setLostClass(arr[3]);
			l.setLostLocation(arr[4]);
			lostList.add(l);
		}
		return lostList;
	}

	@Override
	public Lose selectOne(String lostId) {
		Lose returnLost = null;
		List<Lose> list = selectAll();
		for(int i=0; i<list.size(); i++) {
			if(lostId.equals(list.get(i).getLostId())) {
				returnLost = list.get(i);
				break;
			}
		}
		return returnLost;
	}
	
}
