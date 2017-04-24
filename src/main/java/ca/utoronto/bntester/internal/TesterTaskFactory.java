package ca.utoronto.bntester.internal;

import org.cytoscape.application.swing.CySwingApplication;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class TesterTaskFactory extends AbstractTaskFactory {

	private CySwingApplication swingApplication;
	
	public TesterTaskFactory(CySwingApplication swingApplication) {
		this.swingApplication = swingApplication;
	}
	
	@Override
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new TesterTask(swingApplication));
	}
}
