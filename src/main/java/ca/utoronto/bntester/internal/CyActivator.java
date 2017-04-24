package ca.utoronto.bntester.internal;

import static org.cytoscape.work.ServiceProperties.INSERT_TOOLBAR_SEPARATOR_AFTER;
import static org.cytoscape.work.ServiceProperties.INSERT_TOOLBAR_SEPARATOR_BEFORE;
import static org.cytoscape.work.ServiceProperties.IN_MENU_BAR;
import static org.cytoscape.work.ServiceProperties.IN_TOOL_BAR;
import static org.cytoscape.work.ServiceProperties.LARGE_ICON_URL;
import static org.cytoscape.work.ServiceProperties.PREFERRED_MENU;
import static org.cytoscape.work.ServiceProperties.TITLE;
import static org.cytoscape.work.ServiceProperties.TOOL_BAR_GRAVITY;

import java.util.Properties;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.service.util.AbstractCyActivator;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;

public class CyActivator extends AbstractCyActivator {

	@Override
	public void start(BundleContext bc) throws Exception {
		CySwingApplication swingApplication = getService(bc, CySwingApplication.class);
		
		TesterTaskFactory taskFactory = new TesterTaskFactory(swingApplication);
		
		Properties props = new Properties();
		props.setProperty(IN_MENU_BAR, "true");
		props.setProperty(PREFERRED_MENU, "Apps");
		props.setProperty(TITLE, "Bounded Number Tester");
		props.setProperty(IN_TOOL_BAR, "true");
		props.setProperty(TOOL_BAR_GRAVITY, "11.0");
		props.setProperty(LARGE_ICON_URL, getClass().getResource("/img/bug-32.png").toString());
		props.setProperty(INSERT_TOOLBAR_SEPARATOR_BEFORE, "true");
		props.setProperty(INSERT_TOOLBAR_SEPARATOR_AFTER, "true");
		registerService(bc, taskFactory, TaskFactory.class, props);
	}
}
