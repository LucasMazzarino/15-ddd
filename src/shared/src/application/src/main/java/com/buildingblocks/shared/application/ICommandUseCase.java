package com.buildingblocks.shared.application;

public interface ICommandUseCase<T extends Request, R>{

    R execute(T request);
}
// Command and query Responsability segregation
// CQRS