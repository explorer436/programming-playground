package com.my.company.secondshot;

public class CurrentConditionDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Subject weatherData;

	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;

		// Why are we storing a reference to the Subject?
		// In the future, we may want to un-register ourselves as an observer and it
		// would be handy to already have a reference to the subject.
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

	public void display() {
		System.out.println("Current conditions: " + temperature + " F degrees and " + humidity + " % humidity");
	}

}
