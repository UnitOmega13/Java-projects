package UnitOmega13;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RoleSorter {
	public String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	public String printTextPerEveryRole(String[] roles, String[] textLines) {
		StringBuilder sb = new StringBuilder();
		String roleWithSuffix;
		for (String role : roles) {
			roleWithSuffix = role + ':';
			sb.append(roleWithSuffix + '\n');
			for (int i = 0; i < textLines.length; i++) {
				if (textLines[i].startsWith(roleWithSuffix)) {
					sb.append((i + 1) + ")" + textLines[i].substring(roleWithSuffix.length()) + "\n");
				}
			}
			sb.append('\n');
		}
		return sb.toString();
	}
}
