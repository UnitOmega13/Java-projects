class RoleSorter {

	private String printTextPerRole(String[] roles, String[] textLines) {
		StringBuilder stringBuilder = new StringBuilder();
		String roleWithText;
		for (String role : roles) {
			roleWithSuffix = role + ':';
			stringBuilder.append(roleWithText + '\n');
			for (int i = 0; i < textLines.length; i++) {
				if (textLines[i].startsWith(roleWithText)) {
					stringBuilder.append((i + 1) + ")" + textLines[i].substring(roleWithText.length()) + "\n");
				}
			}
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}
}
