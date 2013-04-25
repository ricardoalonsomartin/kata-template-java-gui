package no.finntech.kata;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public final class HelloWorldTest {

    @Test
    public void sayHelloWorld_sholdSayHelloWorld() {
        final HelloWorld helloWorld = new HelloWorld();
        assertThat(helloWorld.sayHelloWorld()).isEqualTo("Hello World!");
    }
}
