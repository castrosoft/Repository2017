- Implementar la clase Tanque, que extiende de Contenedor, e implemente el siguiente constructor:
3	. public Tanque(Ingrediente ingrediente, int capacidad)
        el constructor lanza una IllegalArgumentException si el tipo de ingrediente no es LIQUIDO
    
- Implementar los métodos de la clase Receta según la documentación
1	. public Receta(String nombre)
5	. public void agreagarIngrediente(Ingrediente ingrediente, int cantidad)
4	. public void cambiarOrden(Ingrediente ingrediente, int nroDeOrden) *
3	. public int getCantidadDeIngrediente(Ingrediente ingrediente)
2	. public void setTiempoDeAmasado (int tiempo)
3	. public String toString()

- Modificar la clase Amasadora tal que implemente la interfaz maquina
2	. public Amasadora()
3   . public Contenedor getContenedorPara(Ingrediente ingrediente) throws ContenedorNoDisponibleException
4   . public boolean verificarDisponibilidadDeIngrediente (Ingrediente ingrediente, int cantidad)
4   . public void extraerIngrediente(Ingrediente ingrediente, int cantidad)
3   . public List<Ingrediente> getIngredientesFaltantesParaReceta() 
3   . public void setReceta(Receta receta)
    . public Date getHoraFinAmasado()
        
- Implementar los métodos de la interfaz Maquina para Amasadaora tal que
1	. Al encender cambia el Estado de la maquina a ENCENDIDO
1	. Al apagar cambia el Estado de la maquina a APAGADO. Si la maquina está OCUPADA, lanza una IllegalStateException
8	. Al iniciar proceso:
		Inicia el proces de amasado de la receta asociada 
	 		- Extrae los ingredientes necesarios para la receta
	 		- Cambia estado de la amasadora a OCUPADO
	 		- Setea la alarma del Reloj de la amasadora al final del ciclo de amasado según el tiempo de amasado de la receta
	 		- Setea el peso del lote amasado (sumatoria de la cantidad de cada ingrediente de la receta) 
	 	Lanza IllegalStateException cuando 
	 		- el Estado de la amasadora no es correcto (apagado u ocupado), 
	 		- no hay receta cargada en la amasadora
	 		- hay algún faltante de ingrediente 
	 		
2	. Al finalizar proceso
	 	 Finaliza el proceso de la maquina
	 		- Cambia el estado a ENCENDIDO
	 	  	- desaloja el lote (pone el peso del lote en cero)
	 		- limpia la alarma del reloj de la amasadora
		 Lanza IllegalStateException cuando
		 	- el estado de la maquina está en estado APAGADO o ENCENDIDO (no hay ningún proceso corriendo)