public class Controller {
	private EventSet es = new EventSet();
	public void addEvent(Event c) {
		es.add(c); 
	}
	public void run() {	
		Event a;
		boolean perdeu = false;

		while((a = es.getNext()) != null && !perdeu) {

			if(a.ready()) {
				a.action();
				if (a.treinadorDerrotado())
					perdeu = true;
				es.removeCurrent(); 
			}
		}
	}
}