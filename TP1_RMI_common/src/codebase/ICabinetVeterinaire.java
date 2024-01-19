package codebase;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinetVeterinaire extends Remote {
	public void add(IAnimal animal) throws RemoteException;
	public IAnimal getPatientByName (String name) throws RemoteException;
	public void addClient(IClient client) throws RemoteException;
} 