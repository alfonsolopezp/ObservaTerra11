package controllers;

import models.Country;
import models.Indicator;
import models.Observation;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.bars;
import views.html.country;
import views.html.index;
import views.html.indicator;
import views.html.observation;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render(Observation.all(), Country.all(),
				Indicator.all()));
	}

	public static Result showCountries() {
		return ok(country.render(Country.all(), countryForm));
	}

	public static Result showIndicators() {
		return ok(indicator.render(Indicator.all(), indicatorForm));
	}

	public static Result showObservations() {
		return ok(observation.render(Observation.find.all(), Country.all(),
				Indicator.all(), observationForm));
	}

	public static Result bars(String indicator) {
		return ok(bars.render(Indicator.findByCode(indicator)));
	}

	public static Result login() {
		return ok(login.render());
	}

	public String validate() {
		if (User.authenticate(email, password) == null) {
			return "Invalid user or password";
		}
		return null;
	}

	static Form<Country> countryForm = Form.form(Country.class);
	static Form<Indicator> indicatorForm = Form.form(Indicator.class);
	static Form<Observation> observationForm = Form.form(Observation.class);

}
