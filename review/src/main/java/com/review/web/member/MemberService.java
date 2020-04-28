package com.review.web.member;

import java.util.List;

public interface MemberService {

	void join(Member member);

	int count();

	public Member login(Member member);
	
	public Member detail(String userid);

	public boolean check(String userid);

	boolean update(Member member);

	boolean delete(Member member);
	
	public void saveFile(Member member);
	
	public List<Member> readFile();

	List<String> list();

}
