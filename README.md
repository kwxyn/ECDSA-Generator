# ECDSA-Generator
A Java application for Elliptic Curve Digital signature generation

Related to Elliptic curve crypotography or RSA cryptography. The application encrypts texts data using key-based technique such as pairs of public and private keys. The ECC signature generator takes the secret text message and 256-bit private key together with the input of the elliptic curve parameters to compute output of the ECDSA signature which consists of a pair of big integers {r,s} in the range of [1...subgroup order n - 1]. The private key is taken from the user's input. The public key which is a point on the elliptic curve, computed by the EC point mutiplication such that public key point = private key mutiplied by the generator point from the curve parameters. After key generation and data signing, you may verify the output JSON files by using the ECDSA verifier which located in other project.

## Getting Started
1. Download the application
2. Enter the inputs of the curve parameters
3. Select input JSON file of the Text data. Format: {"text": [ "data a", "data b", "data c",...]}
4. Select output paramaters JSON file to write the curve parameters
5. Select output JSON file to write the results and Execute.
