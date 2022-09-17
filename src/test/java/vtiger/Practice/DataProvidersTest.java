package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {
	
	@Test(dataProvider="product")
	public void addToCart(String name,String model,int price,String feature,int qty){
		
		System.out.println(name+"-"+model+"-"+price+"-"+feature+"-"+qty);
		
		
	}
		
	@DataProvider(name="product")
	public Object[][]data(){
		Object [][] d=new Object[4][5];
		
		d[0][0]="samsung";
		d[0][1]="A80";
		d[0][2]=56566;
		d[0][3]="camera";
		d[0][4]=10;
		
		d[1][0]="vivo";
		d[1][1]="1010";
		d[1][2]=30000;
		d[1][3]="security";
		d[1][4]=15;
		
		d[2][0]="iphone";
		d[2][1]="13pro";
		d[2][2]=70000;
		d[2][3]="camera";
		d[2][4]=10;
		
		d[3][0]="redmi";
		d[3][1]="A1180";
		d[3][2]=10000;
		d[3][3]="camera";
		d[3][4]=20;
		return d;
	}
	
	

}
