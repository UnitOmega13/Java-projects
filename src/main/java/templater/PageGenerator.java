package templater;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

/**
 * @author v.chibrikov
 * <p>
 * Пример кода для курса на https://stepic.org/
 * <p>
 * Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class PageGenerator {
	private static final String HTML_DIR = "templates";
	private static PageGenerator pageGenerator;
	private final Configuration configuration;

	public static PageGenerator instance() {
		if (pageGenerator == null)
			pageGenerator = new PageGenerator();
		return pageGenerator;
	}

	public String getPage(String filename, Map<String, Object> data) {
		Writer stream = new StringWriter();
		try {
			Template template = configuration.getTemplate(filename);
			template.process(data, stream);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
		return stream.toString();
	}

	private PageGenerator() {
		configuration = new Configuration();
		try {
			configuration.setDirectoryForTemplateLoading(new File(HTML_DIR));
		} catch (IOException e) {
			e.printStackTrace();
		}
		configuration.setDefaultEncoding("UTF-8");
	}
}
