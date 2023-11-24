build:
	mvn verify -B || echo "build failed"
	mvn checkstyle:checkstyle -B || echo "checkstyle failed"

test: build
	perl test.pl || echo "# Some tests failed"

clean:
	mvn clean -B

.PHONY: clean build test
