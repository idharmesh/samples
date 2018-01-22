package com.mo.prep.lambda.interfacetest;

import java.util.function.Supplier;

public interface DefaulableFactory {
	static Defaulable create(Supplier<Defaulable> supplier) {
		return supplier.get();
	}
}
