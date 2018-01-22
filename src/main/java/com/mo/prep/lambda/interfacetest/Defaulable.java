package com.mo.prep.lambda.interfacetest;

interface Defaulable {
	default String notRequire() {
		return "Default implementation";
	}
}
