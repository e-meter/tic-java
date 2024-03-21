# tic-java

<img src="https://forum.hacf.fr/uploads/default/original/3X/2/b/2bb1f308a3c6395918b3872df9edd563aec0d85d.jpeg" width="268" height="356" />

## About The Project

This project is a library , written in Java, used to handle communication with french electric meter using proprietary protocol
called Télé Information Client (TIC).

This protocol is designed to send information about the electric meter periodically.
This library can be used with two uses cases :
- Receive information from the electric meter
- Send information to emulate electric meter behaviour

The full specification of the protocol, written in french, can be download [here](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwjTxeWv-f-EAxW3VaQEHaKTA38QFnoECBMQAQ&url=https%3A%2F%2Fwww.enedis.fr%2Fmedia%2F2035%2Fdownload&usg=AOvVaw0Bn9Pv64VK2dhbtmrZD8YD&opi=89978449).

### Built With

This project is built with [maven](https://maven.apache.org).

## Getting Started

### Prerequisites

Make sure Java (at least version 8) is installed :
```sh
  java -version
```
Check that Maven is also installed :
```sh
  mvn -version
```
Make sure Git is installed :
```sh
  git --version
```

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/e-meter/tic-java.git
   ```
2. Change the working directory
   ```sh
   cd tic-java
   ```
3. Install library tic-java
   ```sh
   mvn install
   ```

## Usage

* [Download `.jar` manually](../../releases) or add using maven

```xml
<dependency>
    <groupId>emeter</groupId>
    <artifactId>tic-java</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
* [API code examples](../../wiki/examples)

## Support

* [Report a bug or request a feature](../../issues/new)

## License

Distributed under the GNU General Public License v3.0. See [`LICENSE`](LICENSE) for more information.

## Contact

Owner: [e-meter](https://github.com/e-meter) - emeter@free.fr

Project Link: [tic-java](https://github.com/e-meter/tic-java.git)