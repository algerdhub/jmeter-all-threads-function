package jmeter.plugins.functions;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterContextService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Function to return the current thread number.
 * @since 1.X
 */
public class AllActiveThreadsNum extends AbstractFunction {

    private static final String KEY = "__all_active_threadNum"; //$NON-NLS-1$

    private static final List<String> desc = new LinkedList<String>();

    /** {@inheritDoc} */
    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
        JMeterContextService.ThreadCounts tc = JMeterContextService.getThreadCounts();
        return String.valueOf(tc.activeThreads);
    }

    /** {@inheritDoc} */
    @Override
    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
        checkParameterCount(parameters,0,0);
    }

    /** {@inheritDoc} */
    @Override
    public String getReferenceKey() {
        return KEY;
    }

    /** {@inheritDoc} */
    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }
}
