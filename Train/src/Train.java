import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Train {
	
	public final int SEATS_IN_WAGON = 54;
	private Integer[] freeSeats;
	private int stations;
	private int leftAtStationBound = -10;
	private int cameAtStationBound = 10; 
	private int upperboundRandMovementBeetweenCarriges = 4; 
	private Random random = new Random();
//	private int coef = 10; // move it to Train class???
	
	
	public Train(Integer[] freeSeats, int stations) {
		this.freeSeats = freeSeats;
		this.stations = stations;
	}
	
	public Integer[] getFreeSeats() {
		return freeSeats;
	}
	
	public void setFreeSeats(Integer[] freeSeats) {
		this.freeSeats = freeSeats;
	}
	
	public  int getStations() {
		return stations;
	}
	
	public  void setStations(int stations) {
		this.stations = stations;
	}

	
	public void transferBetweenCarriages() {
		List<Integer> freeSeats = new ArrayList<>(Arrays.asList(getFreeSeats()));
		
		int minimumFreeSeats = freeSeats.stream()
				.filter(carriageCapasity -> carriageCapasity > 0)
				.min(Integer::compare)
				.orElseGet(() -> 0);
		
		
		int indexOfMinimumValue = freeSeats.indexOf(minimumFreeSeats) + 1;
		
		System.out.println(freeSeats);
		
		
		for(int i= 1; i <= getStations(); i++) {
			List<Integer> afterMovementSeats = freeSeats.stream()
									.map(seats -> seats + random.nextInt((cameAtStationBound 
											+ leftAtStationBound) 
											- leftAtStationBound))
									.collect(Collectors.toList());
			System.out.println(afterMovementSeats);
			afterMovementSeats.stream().map(seats -> seats + random.nextInt((upperboundRandMovementBeetweenCarriges 
						+ upperboundRandMovementBeetweenCarriges) - upperboundRandMovementBeetweenCarriges));

			minimumFreeSeats = afterMovementSeats.stream()
					.filter(carrigeCapasity ->!carrigeCapasity.equals(0))
					.min(Integer::compare)
					.orElseGet(() -> 0);
			indexOfMinimumValue = afterMovementSeats.indexOf(minimumFreeSeats) + 1;
			System.out.println("Minimum free seats at station " + i + ": " + minimumFreeSeats);
			System.out.println("At carrige #" + indexOfMinimumValue);
			System.out.println(afterMovementSeats);
			System.out.println("---------------");
		}
	}
}