package com.medibank.interview;

import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber.*;
import cucumber.api.junit.*;
import cucumber.api.java.*;
import org.junit.After;
import org.junit.runner.*;
import org.junit.Before;
import org.junit.Test;
@RunWith(Cucumber.class)
@Cucumber.Options(
		//format={"pretty","html:target/cucumber"},
		format={"pretty","json:target/cucumber.json","html:target/cucumber","junit:target/junit-report/allcukes.xml"},
		features="src/test/resources")
public class RunCukesTest{
}