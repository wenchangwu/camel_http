package rpc.service;

import org.springframework.stereotype.Service;

import rpc.entity.Spittle;

@Service(value="spittleService")
public class SpittleServiceImpl implements SpittleService{

	@Override
	public Spittle getSpittle(int id) {
		System.out.println("test for RPC");
		Spittle s=new Spittle();
		s.setName("this is just a demo");
		return s;
	}

}
