//package thread;
//
//public class Countingthread extends Thread{
////private String name;
////  public Countingthread(String name) {
////	  this.name=name;
////  }
//	private Countingthread() {
//		
//	}
//	
////	@Override
////	public synchronized void start() {
////		try {
////			Thread.sleep(5000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		System.out.println(name+ " start()");
////		
////	}
//
//	@Override
//	public void run() {
//	
//		int dem=0;
//		while(dem<=100) {
//			System.out.println(this.getId()+" run() " +dem);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			dem++;
//		}
//	}
//      
//}
