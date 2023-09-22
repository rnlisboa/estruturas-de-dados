using System;

public class No {
        private int value;
        private No prox;

        public void SetValue(int v){
            value = v;
        }

        public int GetValue(){
            return value;
        }

        public void SetProx(No? v){
            prox = v;
        }

        public No? GetProx(){
            return prox;
        }

    }