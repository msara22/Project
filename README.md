Encoder-Decoder Application
Done by Sarvinoz and Ismatullo

The main idea of this project is to encrypt or decrypt the plane text. For this, we used affine cipher algoithm. The main encryption equation of affime cipher is:(ax + b) mod m
where a and b make the keys. So, we have created an application that takes three inputs: 2 main keys, and one input is a text that should be ciphered or deciphered.
Overall this class has 4 methods. First 2 methods are encoder and decoder, which will be evoked when the buttons are pressed. Next goes modularMultiplicativeInverse method. This method is used for decoder, in order to find the inverse of the given key. 
For example if user wants to cipher the word "Encryption" and the cipher keys are 5 and 7 -> the encoded text will be --"Buroxeyvzu". Now if the user wants to decode this text, he needs to know the exact key(5 and 7). If the user enters the text "Buroxeyvzu" and (5 and 7) the result will be -->("Encryption").
