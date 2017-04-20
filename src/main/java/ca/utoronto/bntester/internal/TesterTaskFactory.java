package ca.utoronto.bntester.internal;

import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class TesterTaskFactory extends AbstractTaskFactory {

	@Override
	public TaskIterator createTaskIterator() {
		return new TaskIterator(new TesterTask());
	}
}
