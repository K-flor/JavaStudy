import org.apache.commons.math3.linear.*;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.StopWatch;

class Multiple implements Runnable
{
	BlockRealMatrix A, B;

	Multiple(double[][] a, double[][] b){
		A = new BlockRealMatrix(a);
		B = new BlockRealMatrix(b);
	}
	
	@Override
	public void run(){
		BlockRealMatrix C = A.mutiply(B);
	}
}

public class BlockRealMatrixtest
{
	public static void main(String[] args){
		double[][] b1 = new double[4000][1500];
		double[][] b2 = new double[1500][3000];
		StopWatch sw = new StopWatch();

		for (int i=0;i<b1.length ;i++){
			for (int j=0;j<b1[0].length ;j++ ){
				b1[i][j] = RandomUtils.nextDouble();
			}
		}
		
		for (int i=0;i<b2.length ;i++){
			for (int j=0;j<b2[0].length ;j++ ){
				b2[i][j] = RandomUtils.nextDouble();
			}
		}


		sw.start();
		
		sw.stop();
		System.out.println("running Time = "+ sw.toString() );

		sw.reset();


	}
}