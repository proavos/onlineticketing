package com.proavos.training.onlinetkt.common;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Created by mouly on 7/25/14.
 */
public class LocalResolver extends SessionLocaleResolver {

	public final static String SELECTED_LANGUAGE = "language";

	@Override
	protected Locale determineDefaultLocale(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {

			String language = (String) session.getAttribute(SELECTED_LANGUAGE);
			if (language != null) {
				setDefaultLocale(new Locale(language));
			}

		}
		return super.determineDefaultLocale(request);
	}

}
