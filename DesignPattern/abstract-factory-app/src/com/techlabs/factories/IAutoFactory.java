package com.techlabs.factories;

import com.techlabs.automobile.IAutomibile;

public interface IAutoFactory {
	public IAutomibile makeSUV();
	public IAutomibile makeSedan();
	public IAutomibile makeHatchBack();
}
