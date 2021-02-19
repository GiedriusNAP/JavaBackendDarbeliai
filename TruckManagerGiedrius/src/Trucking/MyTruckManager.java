package Trucking;
import java.util.ArrayList;
import java.util.List;
import lt.itakademija.exam.Packet;
import lt.itakademija.exam.Truck;
import lt.itakademija.exam.TruckManager;


public class MyTruckManager implements TruckManager {
	private List<Truck> trucksList = new ArrayList<>();
	private List<Packet> packetsList = new ArrayList<>();
	@Override
	public void assignTruck(Truck truck, Packet packet) {
		packet.assignTruck(truck);
	}

	@Override
	public List<Packet> getPackets(String truckId) {
		List<Packet> newList = new ArrayList<>();
		for (Packet packet : packetsList) {
			if (packet.getAssignedTruck().getId().equals(truckId)) {
				newList.add(packet);
			}
		}
		return newList;
	}

	@Override
	public int getTotalTruckCapacity() {
		return trucksList.stream().map(truck -> truck.getCapacity()).reduce(0, (a, b) -> a + b);
	}

	@Override
	public Truck getTruckById(String id) {
		return trucksList.stream().filter(x -> id.equals(x.getId())).findAny().orElse(null);
	}

	@Override
	public List<Truck> getTrucks() {
		List<Truck> newList = new ArrayList<>();
		for (Truck truck : trucksList) {
			newList.add(truck);
		}
		return newList;
	}

	@Override
	public Packet registerPacket(String id, int volume) {
		if (id == null) {
			throw new NullPointerException();
		}

		if (id.isEmpty() || volume <= 0) {
			throw new IllegalArgumentException();
		}

		Packet newPacket = new Packet(id, volume);
		if (!packetsList.contains(newPacket)) {
			packetsList.add(newPacket);
		}
		return newPacket;
	}

	@Override
	public Truck registerTruck(String id, int capacity) {
		if (id == null) {
			throw new NullPointerException();
		}

		if (id.isEmpty() || capacity <= 0) {
			throw new IllegalArgumentException();
		}

		Truck newTruck = new Truck(id, capacity);
		if (!trucksList.contains(newTruck)) {
			trucksList.add(newTruck);
		}
		return newTruck;
	}

}
