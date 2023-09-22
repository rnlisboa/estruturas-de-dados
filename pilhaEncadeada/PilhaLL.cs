using System;

public class PilhaLL{
        private No head;
        private No tail;
        private No top;

        public void Push(int v){
            
            No newNo = new No();
            newNo.SetValue(v);
            newNo.SetProx(this.head);
            if(head == null){
             tail = newNo;   
            }
            head = newNo;

            SetTop(newNo);
        }

        public void Pop(){
            if(head == null) throw new EPilhaVaziaVazia("Operação inválida: EPilhaVazia vazia!");
            No lastHead = head;
            head = lastHead.GetProx();
            SetTop(head)
        }

        public void SetTop(No n){
            top = n;
        }

        public No GetHead(){
            return head;
        }

        public int GetTop(){
            return head.GetValue();
        }
    }