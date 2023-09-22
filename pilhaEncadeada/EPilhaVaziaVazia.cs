using System;

class EPilhaVaziaVazia : Exception {
 
  public EPilhaVaziaVazia(string message) : base(message) {
   
  }
  public EPilhaVaziaVazia(string message, Exception innerException) : base(message, innerException) { }
}