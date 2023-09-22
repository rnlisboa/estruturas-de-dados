using System;

class EFilaVaziaVazia : Exception {
 
  public EFilaVaziaVazia(string message) : base(message) {
   
  }
  public EFilaVaziaVazia(string message, Exception innerException) : base(message, innerException) { }
}