package Trucking;

import lt.itakademija.exam.TruckManager;
import lt.itakademija.exam.test.BaseTest;

public class Test extends BaseTest {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected TruckManager createTransportManager() {
		// TODO Auto-generated method stub
		return new MyTruckManager();
	}

}
