This is a simple library for Danske Bank customers with a mobile agreement. 
It offers a simple API, is written in java for the Android Platform. 

It properly requires to run on Android 2.2+ as is uses HttpURLConnection.

It's to be incluced as a Android library in eclipse but i'm not sure i got completely it right.

## Requirements

1. [GSON](http://code.google.com/p/google-gson/)
2. The Android INTERNET Permission

## Usage
The API is pretty simple, take a look at the model and you'll be ready to go.

```java
DanskeBank db = new DanskeBank();
Login l = db.login(LOGINID, LOGINCODE);

Accounts a = db.getAccounts();

//Gets first account
Account b = a.getAccounts().get(0);

//gets the newst 20 transactions        	
Transactions t = db.getTransactions(b.getAccountId());

ArrayList<Transaction> transactionList = t.getTransactions();
```

## License
MIT License
Copyright (C) 2011 by Kristian Mide

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.