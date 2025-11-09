
public class Trabalhador {
		private int id, idade;
		private char sexo;
		private float salario;
		private String cargo;
		public Trabalhador(int id, int idade, char sexo, float salario, String cargo){ 
			this.id = id; 
			this.idade = idade;
			this.sexo = sexo;
			this.salario = salario; 
			this.cargo = cargo;
		}
		public int getId(){
	    		return id;
	  	}
		public int getIdade(){
    		return idade;
  	    }
		public char getSexo(){
    		return sexo;
		}
	  	public float getSalario(){
	    		return salario;
	 	}
	  	public String getCargo(){
    		return cargo;
 	    }
	  	public void setId(int id){
	    		this.id = id;
	  	}
	  	public void setIdade(int idade){
    		this.idade = idade;
	  	}
	  	public void setSexo(char sexo){
    		this.sexo = sexo;
	  	}
	  	public void setSalario(float salario){
	    		this.salario = salario;
	  	}
	  	public void setCargo(String cargo){
    		this.cargo = cargo;
  	    }
		@Override
		public String toString()  {
				StringBuilder sb = new StringBuilder();
				sb.append("\n[Trabalhador] Id: ")
					.append(id)
					.append(", sexo: ")
					.append(sexo)
					.append(", idade: ")
					.append(idade)
					.append(", cargo: ")
					.append(cargo)
					.append(", salário: ")
					.append(salario);					
				return sb.toString();
		}
}
