package junit;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.runners.model.Statement;

public class RunCustomExpectedExceptions extends Statement {

	private Object klass;
	private Statement next;
	
	public RunCustomExpectedExceptions (Object klass, Statement next) {
		this.klass= klass;
		this.next = next;
	}
	
	@Override
	public void evaluate() throws Throwable {
		List <Throwable> errors = new ArrayList <Throwable> ();
		try {
			this.next.evaluate();
		}
		catch (Exception e) {
			errors.add(e);
		}
		finally {
			isRulePresent (this.klass);
		}
	}
	
	private void isRulePresent(Object klass) {
		Field [] fields = klass.getClass().getDeclaredFields();
		for (int i=0 ; i<fields.length ; i++) {
			if (fields[i].getType().equals(Watcher.class) ) {
				if (fields[i].isAnnotationPresent(Rule.class)) return;
			}
		}
		throw new RunnerException ("Nenhum atributo declarado na classe "+ klass.getClass()+" está anotado com @Rule.");
	}
}
