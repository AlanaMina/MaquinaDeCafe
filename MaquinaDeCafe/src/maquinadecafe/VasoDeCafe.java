package maquinadecafe;

public class VasoDeCafe {
	private boolean lleno = false;
	
	public VasoDeCafe(boolean lleno) {
		this.lleno = lleno;
	}
	
	public boolean estaLleno() {
		return this.lleno;
	}
	
	@Override
	public String toString() {
		return "VasoDeDafe {lleno=" + lleno + "]";
	}
}
