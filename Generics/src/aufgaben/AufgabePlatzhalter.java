package aufgaben;

import java.util.List;

interface Inter{}
class Base implements Inter{}
class Derived extends Base {}
class A extends Derived {}
class C extends Derived {}
class X implements Inter {}
class AD extends A {}
class ADD extends AD {}

public class AufgabePlatzhalter {

	public static void main(String[] args) {
		
		List list = null;
		List<?> listUnknown = null;//? = ? extends Object
		List<Object> listObject = null;
		List<? super Object> listSuperObject = null;
		List<? extends Object> listExtendsObject = null;
		List<Inter> listInter = null;
		List<? super Inter> listSuperInter = null;
		List<? extends Inter> listExtendsInter = null;
		List<Base> listBase = null;
		List<? super Base> listSuperBase = null;
		List<? extends Base> listExtendsBase = null;
		List<Derived> listDerived = null;
		List<? super Derived> listSuperDerived = null;
		List<? extends Derived> listExtendsDerived = null;
		List<A> listA = null;
		List<? super A> listSuperA = null;
		List<? extends A> listExtendsA = null;
		List<C> listC = null;
		List<? super C> listSuperC = null;
		List<? extends C> listExtendsC = null;
		List<AD> listAD = null;
		List<? super AD> listSuperAD = null;
		List<? extends AD> listExtendsAD = null;
		List<ADD> listADD = null;
		List<? super ADD> listSuperADD = null;
		List<? extends ADD> listExtendsADD = null;
		
		listSuperA  = listSuperInter;
//		listDerived = listSuperC;
		listExtendsADD  = listADD;
		listExtendsBase = listExtendsADD;
//		listAD  = listBase;                   
//		listADD = listSuperA;
		listExtendsBase = listExtendsBase;
//		listBase    = listExtendsADD;
//		listObject  = listExtendsDerived;
//		listSuperA  = listExtendsInter;
//		listSuperObject = listAD;
//		listSuperC = listExtendsAD;
		listExtendsAD = listExtendsADD;
//		listDerived = listADD;
//		listADD = listA;
//		listBase = listA;
		listSuperBase = listInter;
//		listSuperBase = listUnknown;
		listExtendsObject = listA;
//		listExtendsC = listSuperC;
		listUnknown = listExtendsAD;
//		listSuperDerived = listA;
		listSuperDerived = listInter;
//		listDerived = listAD;
//		listExtendsInter = listSuperBase;
		listExtendsBase = list;
		listExtendsObject = listExtendsC;
//		listAD = listObject;
//		listExtendsC = listUnknown;
//		listSuperC = listA;
		listExtendsInter = listExtendsBase;
		listExtendsObject = listSuperDerived;
		listExtendsObject = listExtendsADD;
//		listSuperDerived = listExtendsC;
		listAD = listSuperObject;
		listSuperAD = listSuperDerived;
//		listExtendsAD = listA;
//		listUnknown = listSuperC;
//		listExtendsADD = listC;
//		listAD = listSuperAD;
//		listSuperBase = listExtendsAD;
//		listC = listSuperA;
//		listA = listInter;
//		list = listSuperAD;
//		listObject = listExtendsInter;
//		listSuperA = listSuperA;
//		listExtendsAD = listExtendsC;
//		list = listADD;
//		listA = listDerived;
//		listUnknown = listSuperA;
		
	}
	
}
