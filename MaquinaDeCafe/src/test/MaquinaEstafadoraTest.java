package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import maquinadecafe.MaquinaDeCafe;
import maquinadecafe.MaquinaEstafadora;
import maquinadecafe.VasoDeCafe;

public class MaquinaEstafadoraTest {
	MaquinaDeCafe maquina;
	
	@Before
	public void setup() {
		maquina = new MaquinaEstafadora();
	}
	
	@Test
	public void queDevuelvaUnVasoAlServir() {
		VasoDeCafe vaso = maquina.servirCafe();
		Assert.assertNotNull(vaso);
	}
	
	@Test
	public void quePuedeServirUnCafe() {
		maquina.servirCafe();
		Assert.assertTrue(maquina.puedeServir());
	}
	
	@Test
	public void queElPrimerVasoEstaLlenoYElSiguienteVacio() {
		Assert.assertTrue(maquina.servirCafe().estaLleno());
		Assert.assertFalse(maquina.servirCafe().estaLleno());
		Assert.assertTrue(maquina.servirCafe().estaLleno());
		Assert.assertFalse(maquina.servirCafe().estaLleno());
	}
	
	@Test
	public void seAgotaElCafe() {
		VasoDeCafe vaso = null;
		for(int i=0; i<199; i++) {
			vaso = maquina.servirCafe();
		}
		Assert.assertTrue(vaso.estaLleno());
	}
	
	@Test
	public void queLuegoDeAgotarElCafeSirveVasoVacio() {
		for(int i=0; i<200; i++) {
			maquina.servirCafe();
		}
		VasoDeCafe vaso = maquina.servirCafe();
		Assert.assertFalse(vaso.estaLleno());
	}
}
