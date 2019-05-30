class BitChanger {

	int changeBit(int number, int bitIndex) {
		return number ^ (1 << bitIndex - 1);
	}
}
