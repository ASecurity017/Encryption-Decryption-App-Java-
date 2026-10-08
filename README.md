# Java Encryption/Decryption Tool

A console-based encryption and key management application written in Java.
This project demonstrates practical understanding of cryptographic concepts,
secure key handling, and object-oriented design.

The application allows users to encrypt and decrypt text using multiple
algorithms and includes a custom-built key generation system.

---

## Features

- Encrypt and decrypt text using:
  - Caesar Cipher (weak encryption)
  - DES (moderate encryption)
  - AES (strong encryption)
- Automatic generation and management of cryptographic keys
- AES encryption using random Initialization Vectors (IVs)
- Custom user-defined key generation system
- Interactive command-line menu interface

---

## Supported Encryption Algorithms

### Caesar Cipher
- Simple substitution cipher using a shift value
- Included to demonstrate basic encryption concepts

### DES (Data Encryption Standard)
- Symmetric-key algorithm using a 56-bit key
- Demonstrates legacy encryption techniques

### AES (Advanced Encryption Standard)
- Strong symmetric encryption 
- Uses randomly generated secret keys (256-bit or 512-bit key) and IVs
- Suitable for modern secure applications

---

## Custom Key Generation (MyKeyProvider)

This project includes a **custom-built key generation and retrieval system**
implemented entirely by me using the `MyKeyProvider` class.

The custom key system allows users to:
- Create a personalized key using user-provided information
- Securely store the generated key during runtime
- Retrieve the key by correctly answering security questions

This component was designed to demonstrate:
- Object-oriented design principles
- Secure handling of sensitive user data
- Practical key management concepts beyond standard libraries

> Note: The `MyKeyProvider` implementation is original code and was not sourced
> from external libraries or tutorials.

---

## Project Structure

```text
src/
├── Main.java
├── AES.java
├── DES.java
├── CaesarCipher.java
├── MyKeyProvider.java
├── AESKeyProvider.java
├── AESIVProvider.java
└── DESKeyProvider.java
